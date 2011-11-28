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

package org.eclipselabs.damos.codegen.c.generator.internal.generators;

import org.eclipselabs.damos.codegen.c.generator.IVariableAccessor;
import org.eclipselabs.damos.codegen.c.generator.internal.util.InternalGeneratorUtil;
import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.BlockInput;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.dml.Output;
import org.eclipselabs.damos.dml.util.DMLUtil;
import org.eclipselabs.damos.execution.core.IComponentSignature;
import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.InputParameterDeclaration;
import org.eclipselabs.damos.mscript.OutputParameterDeclaration;
import org.eclipselabs.damos.mscript.StateVariableDeclaration;
import org.eclipselabs.damos.mscript.VariableAccess;
import org.eclipselabs.damos.mscript.VariableDeclaration;
import org.eclipselabs.damos.mscript.codegen.c.IVariableAccessStrategy;
import org.eclipselabs.damos.mscript.interpreter.IStaticEvaluationContext;
import org.eclipselabs.damos.mscript.util.MscriptSwitch;

/**
 * @author Andreas Unger
 *
 */
public class VariableAccessStrategy implements IVariableAccessStrategy {

	private IStaticEvaluationContext staticEvaluationContext;
	private Block block;
	private IComponentSignature signature;
	private IVariableAccessor variableAccessor;
	
	/**
	 * 
	 */
	public VariableAccessStrategy(IStaticEvaluationContext staticEvaluationContext, Block block, IComponentSignature signature, IVariableAccessor variableAccessor) {
		this.staticEvaluationContext = staticEvaluationContext;
		this.block = block;
		this.signature = signature;
		this.variableAccessor = variableAccessor;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.codegen.c.IVariableAccessStrategy#getVariableAccessString(org.eclipselabs.mscript.language.il.VariableAccess)
	 */
	public String getVariableAccessString(VariableAccess variableAccess) {
		return new VariableAccessSwitch(variableAccess).doSwitch(variableAccess.getFeature());
	}

	/**
	 * @param inputVariableDeclaration
	 * @return
	 */
	static String getInputParameterAccessString(IStaticEvaluationContext staticEvaluationContext, Block block, IComponentSignature signature, IVariableAccessor variableAccessor, InputParameterDeclaration inputParameterDeclaration) {
		int index = DMLUtil.indexOf(inputParameterDeclaration);
		
		if (!block.getInputSockets().isEmpty()) {
			if (index == 0) {
				return variableAccessor.getMessageKindVariable(false);
			}
			--index;
		}
		
		BlockInput blockInput = (BlockInput) block.getInputs().get(index);
		if (blockInput.getDefinition().isManyPorts() || blockInput.getDefinition().getMinimumPortCount() == 0) {
			return String.format("%s_%s", InternalGeneratorUtil.uncapitalize(block.getName()), blockInput.getDefinition().getName());
		} else {
			InputPort inputPort = blockInput.getPorts().get(0);
			DataType inputDataType = signature.getInputDataType(inputPort);
			DataType targetDataType = staticEvaluationContext.getValue(inputParameterDeclaration).getDataType();
			if (!inputDataType.isEquivalentTo(targetDataType)) {
				return String.format("%s_%s", InternalGeneratorUtil.uncapitalize(block.getName()), blockInput.getDefinition().getName());
			}
		}
		return variableAccessor.getInputVariable(blockInput.getPorts().get(0), false);
	}

	/**
	 * @param outputParameterDeclaration
	 * @return
	 */
	static String getOutputParameterAccessString(Block block, IComponentSignature signature, IVariableAccessor variableAccessor, OutputParameterDeclaration outputParameterDeclaration) {
		int index = DMLUtil.indexOf(outputParameterDeclaration);
		Output output = block.getOutputs().get(index);
		return variableAccessor.getOutputVariable(output.getPorts().get(0), false);
	}

	public class VariableAccessSwitch extends MscriptSwitch<String> {

		private VariableAccess variableAccess;
		
		public VariableAccessSwitch(VariableAccess variableAccess) {
			this.variableAccess = variableAccess;
		}

		@Override
		public String caseInputParameterDeclaration(InputParameterDeclaration inputParameterDeclaration) {
			int stepIndex = staticEvaluationContext.getStepIndex(variableAccess);
			if (stepIndex == 0) {
				return getInputParameterAccessString(staticEvaluationContext, block, signature, variableAccessor, inputParameterDeclaration);
			}
			return getContextAccess();
		}
		
		@Override
		public String caseOutputParameterDeclaration(OutputParameterDeclaration outputParameterDeclaration) {
			int stepIndex = staticEvaluationContext.getStepIndex(variableAccess);
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
			VariableDeclaration target = (VariableDeclaration) variableAccess.getFeature();
			int stepIndex = staticEvaluationContext.getStepIndex(variableAccess);

			String contextVariable = variableAccessor.getContextVariable(false);
			String targetName = target.getName();
			int circularBufferSize = staticEvaluationContext.getCircularBufferSize(target);
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
