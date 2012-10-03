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

package org.eclipse.damos.mscript.codegen.c.internal;

import org.eclipse.damos.mscript.FeatureReference;
import org.eclipse.damos.mscript.InputParameterDeclaration;
import org.eclipse.damos.mscript.OutputParameterDeclaration;
import org.eclipse.damos.mscript.StateVariableDeclaration;
import org.eclipse.damos.mscript.VariableDeclaration;
import org.eclipse.damos.mscript.codegen.c.IVariableAccessStrategy;
import org.eclipse.damos.mscript.interpreter.StaticFunctionInfo;
import org.eclipse.damos.mscript.util.MscriptSwitch;

/**
 * @author Andreas Unger
 *
 */
public class DefaultVariableAccessStrategy implements IVariableAccessStrategy {

	private StaticFunctionInfo functionInfo;
	
	/**
	 * 
	 */
	public DefaultVariableAccessStrategy(StaticFunctionInfo functionInfo) {
		this.functionInfo = functionInfo;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.mscript.codegen.c.IVariableAccessStrategy#generateContextMemberAccess(boolean, java.lang.String)
	 */
	public CharSequence generateContextMemberAccess(boolean pointer, String memberName) {
		StringBuilder sb = new StringBuilder();
		if (pointer) {
			sb.append("&");
		}
		return sb.append("context->").append(memberName);
	}
	
	public String generateVariableReference(FeatureReference variableReference) {
		return new VariableAccessSwitch(variableReference).doSwitch(variableReference.getFeature());
	}

	public class VariableAccessSwitch extends MscriptSwitch<String> {

		private FeatureReference variableReference;
		
		public VariableAccessSwitch(FeatureReference variableReference) {
			this.variableReference = variableReference;
		}

		@Override
		public String caseInputParameterDeclaration(InputParameterDeclaration inputParameterDeclaration) {
			int stepIndex = functionInfo.getStepIndex(variableReference);
			if (stepIndex == 0) {
				return inputParameterDeclaration.getName();
			}
			return getContextAccess();
		}
		
		@Override
		public String caseOutputParameterDeclaration(OutputParameterDeclaration outputParameterDeclaration) {
			int stepIndex = functionInfo.getStepIndex(variableReference);
			if (stepIndex == 0) {
				return outputParameterDeclaration.getName();
			}
			return getContextAccess();
		}
		
		@Override
		public String caseStateVariableDeclaration(StateVariableDeclaration stateVariableDeclaration) {
			return getContextAccess();
		}
		
		private String getContextAccess() {
			VariableDeclaration target = (VariableDeclaration) variableReference.getFeature();
			int stepIndex = functionInfo.getStepIndex(variableReference);

			String name = target.getName();
			int circularBufferSize = functionInfo.getCircularBufferSize(target);
			if (circularBufferSize > 1) {
				if (stepIndex < 0) {
					stepIndex = (stepIndex + circularBufferSize) % circularBufferSize;
				}
				if (stepIndex == 0) {
					return String.format("context->%s[context->%s_index]", name, name, stepIndex, circularBufferSize);
				}
				return String.format("context->%s[(context->%s_index + %d) %% %d]", name, name, stepIndex,
						circularBufferSize);
			}
			return String.format("context->%s", name);
		}
		
	}

}
