/****************************************************************************
 * Copyright (c) 2008, 2010 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.mscript.interpreter;

import org.eclipselabs.damos.mscript.Evaluable;
import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.VariableDeclaration;
import org.eclipselabs.damos.mscript.VariableReference;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;
import org.eclipselabs.damos.mscript.interpreter.value.InvalidValue;

/**
 * @author Andreas Unger
 *
 */
public class ExpressionEvaluator implements IExpressionEvaluator {
		
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.interpreter.IExpressionValueEvaluator#evaluate(org.eclipselabs.mscript.language.interpreter.IInterpreterContext, org.eclipselabs.mscript.language.ast.Expression)
	 */
	public IValue evaluate(IInterpreterContext context, Expression expression) {
		return new Switch(context).doSwitch(expression);
	}
	
	private static class Switch extends ExpressionEvaluatorSwitch {
		
		private IInterpreterContext context;

		/**
		 * 
		 */
		public Switch(IInterpreterContext context) {
			super(false);
			this.context = context;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.damos.mscript.interpreter.ExpressionEvaluatorSwitch#getComputationContext()
		 */
		@Override
		protected IComputationContext getComputationContext() {
			return context.getComputationContext();
		}

		/* (non-Javadoc)
		 * @see org.eclipselabs.damos.mscript.util.MscriptSwitch#caseVariableAccess(org.eclipselabs.damos.mscript.VariableAccess)
		 */
		@Override
		public IValue caseVariableReference(VariableReference variableReference) {
			if (!(variableReference.getFeature() instanceof VariableDeclaration)) {
				throw new IllegalArgumentException();
			}
			VariableDeclaration variableDeclaration = (VariableDeclaration) variableReference.getFeature();
			
			IVariable variable = context.getVariable(variableDeclaration);
			int stepIndex = context.getStaticEvaluationContext().getStepIndex(variableReference);
			IValue result = variable.getValue(stepIndex);
			if (result == null) {
				return InvalidValue.SINGLETON;
			}
			return result;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.damos.mscript.interpreter.ExpressionEvaluatorSwitch#getValue(org.eclipselabs.damos.mscript.Evaluable)
		 */
		@Override
		protected IValue getStaticValue(Evaluable evaluable) {
			return context.getStaticEvaluationContext().getValue(evaluable);
		}
		
	}
	
}
