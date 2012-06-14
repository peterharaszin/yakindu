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

package org.eclipselabs.damos.mscript.codegen.c.internal;

import org.eclipselabs.damos.mscript.InputParameterDeclaration;
import org.eclipselabs.damos.mscript.OutputParameterDeclaration;
import org.eclipselabs.damos.mscript.StateVariableDeclaration;
import org.eclipselabs.damos.mscript.VariableReference;
import org.eclipselabs.damos.mscript.VariableDeclaration;
import org.eclipselabs.damos.mscript.codegen.c.IVariableAccessStrategy;
import org.eclipselabs.damos.mscript.interpreter.IStaticEvaluationContext;
import org.eclipselabs.damos.mscript.util.MscriptSwitch;

/**
 * @author Andreas Unger
 *
 */
public class DefaultVariableAccessStrategy implements IVariableAccessStrategy {

	private IStaticEvaluationContext staticEvaluationContext;
	
	/**
	 * 
	 */
	public DefaultVariableAccessStrategy(IStaticEvaluationContext staticEvaluationContext) {
		this.staticEvaluationContext = staticEvaluationContext;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.codegen.c.IVariableAccessStrategy#getVariableAccessString(org.eclipselabs.mscript.language.il.VariableAccess)
	 */
	public String generateVariableReference(VariableReference variableReference) {
		return new VariableAccessSwitch(variableReference).doSwitch(variableReference.getFeature());
	}

	public class VariableAccessSwitch extends MscriptSwitch<String> {

		private VariableReference variableReference;
		
		public VariableAccessSwitch(VariableReference variableReference) {
			this.variableReference = variableReference;
		}

		@Override
		public String caseInputParameterDeclaration(InputParameterDeclaration inputParameterDeclaration) {
			int stepIndex = staticEvaluationContext.getStepIndex(variableReference);
			if (stepIndex == 0) {
				return inputParameterDeclaration.getName();
			}
			return getContextAccess();
		}
		
		@Override
		public String caseOutputParameterDeclaration(OutputParameterDeclaration outputParameterDeclaration) {
			int stepIndex = staticEvaluationContext.getStepIndex(variableReference);
			if (stepIndex == 0) {
				return String.format("*%s", outputParameterDeclaration.getName());
			}
			return getContextAccess();
		}
		
		@Override
		public String caseStateVariableDeclaration(StateVariableDeclaration stateVariableDeclaration) {
			return getContextAccess();
		}
		
		private String getContextAccess() {
			VariableDeclaration target = (VariableDeclaration) variableReference.getFeature();
			int stepIndex = staticEvaluationContext.getStepIndex(variableReference);

			String name = target.getName();
			int circularBufferSize = staticEvaluationContext.getCircularBufferSize(target);
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
