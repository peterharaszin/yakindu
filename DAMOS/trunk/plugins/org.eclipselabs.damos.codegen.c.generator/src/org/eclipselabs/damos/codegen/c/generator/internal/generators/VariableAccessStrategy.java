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
import org.eclipselabs.mscript.codegen.c.IVariableAccessStrategy;
import org.eclipselabs.mscript.language.il.InputVariableDeclaration;
import org.eclipselabs.mscript.language.il.InstanceVariableDeclaration;
import org.eclipselabs.mscript.language.il.OutputVariableDeclaration;
import org.eclipselabs.mscript.language.il.StatefulVariableDeclaration;
import org.eclipselabs.mscript.language.il.VariableAccess;
import org.eclipselabs.mscript.language.il.util.ILSwitch;
import org.eclipselabs.mscript.typesystem.DataType;

/**
 * @author Andreas Unger
 *
 */
public class VariableAccessStrategy implements IVariableAccessStrategy {

	private Block block;
	private IComponentSignature signature;
	private IVariableAccessor variableAccessor;
	
	/**
	 * 
	 */
	public VariableAccessStrategy(Block block, IComponentSignature signature, IVariableAccessor variableAccessor) {
		this.block = block;
		this.signature = signature;
		this.variableAccessor = variableAccessor;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.codegen.c.IVariableAccessStrategy#getVariableAccessString(org.eclipselabs.mscript.language.il.VariableAccess)
	 */
	public String getVariableAccessString(VariableAccess variableAccess) {
		return new VariableAccessSwitch(variableAccess).doSwitch(variableAccess.getTarget());
	}

	/**
	 * @param inputVariableDeclaration
	 * @return
	 */
	static String getInputVariableAccessString(Block block, IComponentSignature signature, IVariableAccessor variableAccessor, InputVariableDeclaration inputVariableDeclaration) {
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
			DataType targetDataType = inputVariableDeclaration.getDataType();
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
			if (variableAccess.getStepIndex() == 0) {
				return getInputVariableAccessString(block, signature, variableAccessor, inputVariableDeclaration);
			}
			return getContextAccess();
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.il.util.ILSwitch#caseOutputVariableDeclaration(org.eclipselabs.mscript.language.il.OutputVariableDeclaration)
		 */
		@Override
		public String caseOutputVariableDeclaration(OutputVariableDeclaration outputVariableDeclaration) {
			if (variableAccess.getStepIndex() == 0) {
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
			StatefulVariableDeclaration target = (StatefulVariableDeclaration) variableAccess.getTarget();
			int stepIndex = variableAccess.getStepIndex();

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
