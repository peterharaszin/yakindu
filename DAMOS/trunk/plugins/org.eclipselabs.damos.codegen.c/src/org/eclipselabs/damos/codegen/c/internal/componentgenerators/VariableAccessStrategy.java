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
import org.eclipselabs.damos.codegen.c.IVariableAccessor;
import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.BlockInput;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.dml.Output;
import org.eclipselabs.damos.dml.util.DMLUtil;
import org.eclipselabs.damos.execution.datatype.IComponentSignature;
import org.eclipselabs.damos.mscript.FeatureReference;
import org.eclipselabs.damos.mscript.FunctionDeclaration;
import org.eclipselabs.damos.mscript.InputParameterDeclaration;
import org.eclipselabs.damos.mscript.OutputParameterDeclaration;
import org.eclipselabs.damos.mscript.StateVariableDeclaration;
import org.eclipselabs.damos.mscript.Type;
import org.eclipselabs.damos.mscript.VariableDeclaration;
import org.eclipselabs.damos.mscript.codegen.c.IVariableAccessStrategy;
import org.eclipselabs.damos.mscript.interpreter.IStaticEvaluationResult;
import org.eclipselabs.damos.mscript.util.MscriptSwitch;

/**
 * @author Andreas Unger
 *
 */
public class VariableAccessStrategy implements IVariableAccessStrategy {

	private IStaticEvaluationResult staticEvaluationResult;
	private Block block;
	private IComponentSignature signature;
	private IVariableAccessor variableAccessor;
	
	/**
	 * 
	 */
	public VariableAccessStrategy(IStaticEvaluationResult staticEvaluationResult, Block block, IComponentSignature signature, IVariableAccessor variableAccessor) {
		this.staticEvaluationResult = staticEvaluationResult;
		this.block = block;
		this.signature = signature;
		this.variableAccessor = variableAccessor;
	}
	
	public String generateVariableReference(FeatureReference variableReference) {
		return new VariableAccessSwitch(variableReference).doSwitch(variableReference.getFeature());
	}

	/**
	 * @param inputVariableDeclaration
	 * @return
	 */
	static String getInputParameterAccessString(IStaticEvaluationResult staticEvaluationResult, Block block, IComponentSignature signature, IVariableAccessor variableAccessor, InputParameterDeclaration inputParameterDeclaration) {
		int index = ((FunctionDeclaration) inputParameterDeclaration.eContainer()).getNonConstantInputParameterDeclarations().indexOf(inputParameterDeclaration);
		
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

	public class VariableAccessSwitch extends MscriptSwitch<String> {

		private FeatureReference variableReference;
		
		public VariableAccessSwitch(FeatureReference variableReference) {
			this.variableReference = variableReference;
		}

		@Override
		public String caseInputParameterDeclaration(InputParameterDeclaration inputParameterDeclaration) {
			int stepIndex = staticEvaluationResult.getStepIndex(variableReference);
			if (stepIndex == 0) {
				return getInputParameterAccessString(staticEvaluationResult, block, signature, variableAccessor, inputParameterDeclaration);
			}
			return getContextAccess();
		}
		
		@Override
		public String caseOutputParameterDeclaration(OutputParameterDeclaration outputParameterDeclaration) {
			int stepIndex = staticEvaluationResult.getStepIndex(variableReference);
			if (stepIndex == 0) {
				return getOutputParameterAccessString(block, signature, variableAccessor, outputParameterDeclaration);
			}
			return getContextAccess();
		}
		
		@Override
		public String caseStateVariableDeclaration(StateVariableDeclaration stateVariableDeclaration) {
			return getContextAccess();
		}
		
		private String getContextAccess() {
			VariableDeclaration target = (VariableDeclaration) variableReference.getFeature();
			int stepIndex = staticEvaluationResult.getStepIndex(variableReference);

			String contextVariable = variableAccessor.generateContextVariableReference(false);
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

}
