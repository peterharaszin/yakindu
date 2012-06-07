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

import java.util.Iterator;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipselabs.damos.mscript.AdditiveStepExpression;
import org.eclipselabs.damos.mscript.Equation;
import org.eclipselabs.damos.mscript.FunctionDeclaration;
import org.eclipselabs.damos.mscript.NegateStepExpression;
import org.eclipselabs.damos.mscript.StepLiteral;
import org.eclipselabs.damos.mscript.StepN;
import org.eclipselabs.damos.mscript.VariableReference;
import org.eclipselabs.damos.mscript.internal.MscriptPlugin;
import org.eclipselabs.damos.mscript.util.MscriptSwitch;
import org.eclipselabs.damos.mscript.util.SyntaxStatus;

/**
 * @author Andreas Unger
 *
 */
public class StaticStepExpressionEvaluator {
		
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.interpreter.IExpressionValueEvaluator#evaluate(org.eclipselabs.mscript.language.interpreter.IEvaluationContext, org.eclipselabs.mscript.language.ast.Expression)
	 */
	public IStatus evaluate(IStaticEvaluationContext context, FunctionDeclaration functionDeclaration) {
		Evaluator evaluator = new Evaluator(context);
		for (Equation equation : functionDeclaration.getEquations()) {
			for (Iterator<EObject> it = equation.eAllContents(); it.hasNext();) {
				EObject next = it.next();
				if (next instanceof VariableReference) {
					VariableReference variableReference = (VariableReference) next;
					if (variableReference.getStepExpression() != null) {
						Integer stepIndex = evaluator.doSwitch(variableReference.getStepExpression());
						context.setStepIndex(variableReference, stepIndex);
					}
				}
			}
		}
		return evaluator.getStatus();
	}
	
	private static class Evaluator extends MscriptSwitch<Integer> {
		
		private MultiStatus status;
		
		/**
		 * 
		 */
		public Evaluator(IStaticEvaluationContext context) {
			status = new MultiStatus(MscriptPlugin.PLUGIN_ID, 0, "Step expression evaluation", null);
		}
		
		/**
		 * @return the status
		 */
		public IStatus getStatus() {
			return status;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseAdditiveStepExpression(org.eclipselabs.mscript.language.ast.AdditiveStepExpression)
		 */
		@Override
		public Integer caseAdditiveStepExpression(AdditiveStepExpression additiveStepExpression) {
			Integer leftOperand = doSwitch(additiveStepExpression.getLeftOperand());
			Integer rightOperand = doSwitch(additiveStepExpression.getRightOperand());
			switch (additiveStepExpression.getOperator()) {
			case ADD:
				return leftOperand + rightOperand;
			case SUBTRACT:
				return leftOperand - rightOperand;
			}
			throw new IllegalArgumentException();
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseUnaryExpression(org.eclipselabs.mscript.language.ast.UnaryExpression)
		 */
		@Override
		public Integer caseNegateStepExpression(NegateStepExpression negateStepExpression) {
			return -doSwitch(negateStepExpression.getOperand());
		}

		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseStepLiteral(org.eclipselabs.mscript.language.ast.StepLiteral)
		 */
		@Override
		public Integer caseStepLiteral(StepLiteral stepLiteral) {
			return stepLiteral.getValue();
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseStepN(org.eclipselabs.mscript.language.ast.StepN)
		 */
		@Override
		public Integer caseStepN(StepN stepN) {
			return 0;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#defaultCase(org.eclipse.emf.ecore.EObject)
		 */
		@Override
		public Integer defaultCase(EObject object) {
			status.add(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Invalid expression", object));
			return 0;
		}
	
	}
	
}
