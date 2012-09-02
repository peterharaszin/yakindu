/****************************************************************************
 * Copyright (c) 2008, 2011 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.codegen.c.internal.componentgenerators;

import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipselabs.damos.codegen.c.IComponentGeneratorContext;
import org.eclipselabs.damos.codegen.c.IVariableAccessor;
import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.BlockInput;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.dml.Output;
import org.eclipselabs.damos.dml.util.DMLUtil;
import org.eclipselabs.damos.dscript.DscriptBlockType;
import org.eclipselabs.damos.execution.datatype.IComponentSignature;
import org.eclipselabs.damos.mscript.CallableElement;
import org.eclipselabs.damos.mscript.FeatureReference;
import org.eclipselabs.damos.mscript.ImplicitVariableDeclaration;
import org.eclipselabs.damos.mscript.InputParameterDeclaration;
import org.eclipselabs.damos.mscript.OutputParameterDeclaration;
import org.eclipselabs.damos.mscript.RealType;
import org.eclipselabs.damos.mscript.StateVariableDeclaration;
import org.eclipselabs.damos.mscript.Type;
import org.eclipselabs.damos.mscript.VariableDeclaration;
import org.eclipselabs.damos.mscript.codegen.c.DataTypeGenerator;
import org.eclipselabs.damos.mscript.codegen.c.IVariableAccessStrategy;
import org.eclipselabs.damos.mscript.codegen.c.LiteralGenerator;
import org.eclipselabs.damos.mscript.computation.ComputationModel;
import org.eclipselabs.damos.mscript.interpreter.IStaticEvaluationResult;

/**
 * @author Andreas Unger
 *
 */
public class VariableAccessStrategy implements IVariableAccessStrategy {

	private final LiteralGenerator literalGenerator = new LiteralGenerator(new DataTypeGenerator());
	
	private IComponentGeneratorContext context;
	private ComputationModel computationModel;
	private IStaticEvaluationResult staticEvaluationResult;
	
	/**
	 * 
	 */
	public VariableAccessStrategy(IComponentGeneratorContext context, ComputationModel computationModel, IStaticEvaluationResult staticEvaluationResult) {
		this.context = context;
		this.computationModel = computationModel;
		this.staticEvaluationResult = staticEvaluationResult;
	}
	
	public CharSequence generateVariableReference(FeatureReference variableReference) {
		CallableElement feature = variableReference.getFeature();
		if (feature instanceof ImplicitVariableDeclaration) {
			RealType dataType = (RealType) staticEvaluationResult.getValue(feature).getDataType();
			double value;
			if ("Ts".equals(feature.getName())) {
				value = context.getNode().getSampleTime();
			} else if ("fs".equals(feature.getName())) {
				value = 1.0 / context.getNode().getSampleTime();
			} else {
				value = 0.0;
			}
			return literalGenerator.generateLiteral(computationModel, dataType, value);
		}
		if (feature instanceof InputParameterDeclaration) {
			InputParameterDeclaration inputParameterDeclaration = (InputParameterDeclaration) feature;
			int stepIndex = staticEvaluationResult.getStepIndex(variableReference);
			if (stepIndex == 0) {
				return getInputParameterAccessString(staticEvaluationResult, getBlock(), context.getComponentSignature(), context.getVariableAccessor(), inputParameterDeclaration);
			}
			return getContextAccess(variableReference);
		}
		if (feature instanceof OutputParameterDeclaration) {
			OutputParameterDeclaration outputParameterDeclaration = (OutputParameterDeclaration) feature;
			int stepIndex = staticEvaluationResult.getStepIndex(variableReference);
			if (stepIndex == 0) {
				return getOutputParameterAccessString(getBlock(), context.getComponentSignature(), context.getVariableAccessor(), outputParameterDeclaration);
			}
			return getContextAccess(variableReference);
		}
		if (feature instanceof StateVariableDeclaration) {
			return getContextAccess(variableReference);
		}
		throw new IllegalArgumentException("Unknown variable declaration " + feature.getClass().getCanonicalName());
	}

	/**
	 * @param inputVariableDeclaration
	 * @return
	 */
	static String getInputParameterAccessString(IStaticEvaluationResult staticEvaluationResult, Block block, IComponentSignature signature, IVariableAccessor variableAccessor, InputParameterDeclaration inputParameterDeclaration) {
		// TODO: Casting should be reworked, we need to pass a DscriptInputDefinition
		int index = ((DscriptBlockType) block.getType()).getBehavior().getNonConstantInputParameterDeclarations().indexOf(inputParameterDeclaration);
		
		if (!block.getInputSockets().isEmpty()) {
			if (index == 0) {
				return variableAccessor.generateMessageKindVariableReference(false);
			}
			--index;
		}
		
		BlockInput blockInput = (BlockInput) block.getInputs().get(index);
		if (blockInput.getDefinition().isManyPorts() || blockInput.getDefinition().getMinimumPortCount() == 0) {
			return String.format("%s_%s", StringExtensions.toFirstLower(block.getName()), blockInput.getDefinition().getName());
		} else {
			InputPort inputPort = blockInput.getPorts().get(0);
			Type inputDataType = signature.getInputDataType(inputPort);
			Type targetDataType = staticEvaluationResult.getValue(inputParameterDeclaration).getDataType();
			if (!inputDataType.isEquivalentTo(targetDataType)) {
				return String.format("%s_%s", StringExtensions.toFirstLower(block.getName()), blockInput.getDefinition().getName());
			}
		}
		return variableAccessor.generateInputVariableReference(blockInput.getPorts().get(0), false);
	}

	/**
	 * @param outputParameterDeclaration
	 * @return
	 */
	static String getOutputParameterAccessString(Block block, IComponentSignature signature, IVariableAccessor variableAccessor, OutputParameterDeclaration outputParameterDeclaration) {
		int index = DMLUtil.indexOf(outputParameterDeclaration);
		Output output = block.getOutputs().get(index);
		return variableAccessor.generateOutputVariableReference(output.getPorts().get(0), false);
	}
	
	private Block getBlock() {
		return (Block) context.getNode().getComponent();
	}

	private CharSequence getContextAccess(FeatureReference variableReference) {
		VariableDeclaration target = (VariableDeclaration) variableReference.getFeature();
		int stepIndex = staticEvaluationResult.getStepIndex(variableReference);

		String contextVariable = context.getVariableAccessor().generateContextVariableReference(false);
		String targetName = target.getName();
		int circularBufferSize = staticEvaluationResult.getCircularBufferSize(target);
		if (circularBufferSize > 1) {
			if (stepIndex < 0) {
				stepIndex = (stepIndex + circularBufferSize) % circularBufferSize;
			}
			if (stepIndex == 0) {
				return String.format("%s.%s[%s.%s_index]", contextVariable, targetName, contextVariable, targetName, stepIndex, circularBufferSize);
			}
			return String.format("%s.%s[(%s.%s_index + %d) %% %d]", contextVariable, targetName, contextVariable, targetName, stepIndex,
					circularBufferSize);
		}
		return String.format("%s.%s", contextVariable, targetName);
	}

}
