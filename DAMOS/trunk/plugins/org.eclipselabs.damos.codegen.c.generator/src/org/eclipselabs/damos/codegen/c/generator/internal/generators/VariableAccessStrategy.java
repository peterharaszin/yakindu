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
import org.eclipselabs.damos.mscript.VariableAccess;
import org.eclipselabs.damos.mscript.codegen.c.IVariableAccessStrategy;
import org.eclipselabs.damos.mscript.il.InputVariableDeclaration;
import org.eclipselabs.damos.mscript.il.InstanceVariableDeclaration;
import org.eclipselabs.damos.mscript.il.OutputVariableDeclaration;
import org.eclipselabs.damos.mscript.il.StatefulVariableDeclaration;
import org.eclipselabs.damos.mscript.il.util.ILSwitch;
import org.eclipselabs.damos.mscript.interpreter.IStaticEvaluationContext;

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
	static String getInputVariableAccessString(IStaticEvaluationContext staticEvaluationContext, Block block, IComponentSignature signature, IVariableAccessor variableAccessor, InputVariableDeclaration inputVariableDeclaration) {
		int index = DMLUtil.indexOf(inputVariableDeclaration);
		
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
			DataType targetDataType = staticEvaluationContext.getValue(inputVariableDeclaration).getDataType();
			if (!inputDataType.isEquivalentTo(targetDataType)) {
				return String.format("%s_%s", InternalGeneratorUtil.uncapitalize(block.getName()), blockInput.getDefinition().getName());
			}
		}
		return variableAccessor.getInputVariable(blockInput.getPorts().get(0), false);
	}

	/**
	 * @param outputVariableDeclaration
	 * @return
	 */
	static String getOutputVariableAccessString(Block block, IComponentSignature signature, IVariableAccessor variableAccessor, OutputVariableDeclaration outputVariableDeclaration) {
		int index = DMLUtil.indexOf(outputVariableDeclaration);
		Output output = block.getOutputs().get(index);
		return variableAccessor.getOutputVariable(output.getPorts().get(0), false);
	}

	public class VariableAccessSwitch extends ILSwitch<String> {

		private VariableAccess variableAccess;
		
		public VariableAccessSwitch(VariableAccess variableAccess) {
			this.variableAccess = variableAccess;
		}

		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.il.util.ILSwitch#caseInputVariableDeclaration(org.eclipselabs.mscript.language.il.InputVariableDeclaration)
		 */
		@Override
		public String caseInputVariableDeclaration(InputVariableDeclaration inputVariableDeclaration) {
			int stepIndex = staticEvaluationContext.getStepIndex(variableAccess);
			if (stepIndex == 0) {
				return getInputVariableAccessString(staticEvaluationContext, block, signature, variableAccessor, inputVariableDeclaration);
			}
			return getContextAccess();
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.il.util.ILSwitch#caseOutputVariableDeclaration(org.eclipselabs.mscript.language.il.OutputVariableDeclaration)
		 */
		@Override
		public String caseOutputVariableDeclaration(OutputVariableDeclaration outputVariableDeclaration) {
			int stepIndex = staticEvaluationContext.getStepIndex(variableAccess);
			if (stepIndex == 0) {
				return getOutputVariableAccessString(block, signature, variableAccessor, outputVariableDeclaration);
			}
			return getContextAccess();
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.il.util.ILSwitch#caseInstanceVariableDeclaration(org.eclipselabs.mscript.language.il.InstanceVariableDeclaration)
		 */
		@Override
		public String caseInstanceVariableDeclaration(InstanceVariableDeclaration instanceVariableDeclaration) {
			return getContextAccess();
		}
		
		private String getContextAccess() {
			StatefulVariableDeclaration target = (StatefulVariableDeclaration) variableAccess.getFeature();
			int stepIndex = staticEvaluationContext.getStepIndex(variableAccess);

			String contextVariable = variableAccessor.getContextVariable(false);
			String targetName = target.getName();
			int circularBufferSize = ((StatefulVariableDeclaration) target).getCircularBufferSize();
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
