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

package org.eclipse.damos.mscript.interpreter;

import java.util.Iterator;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.damos.mscript.AdditiveStepExpression;
import org.eclipse.damos.mscript.Equation;
import org.eclipse.damos.mscript.FeatureReference;
import org.eclipse.damos.mscript.FunctionDeclaration;
import org.eclipse.damos.mscript.NegateStepExpression;
import org.eclipse.damos.mscript.StepLiteral;
import org.eclipse.damos.mscript.StepN;
import org.eclipse.damos.mscript.internal.MscriptPlugin;
import org.eclipse.damos.mscript.util.MscriptSwitch;
import org.eclipse.damos.mscript.util.SyntaxStatus;
import org.eclipse.emf.ecore.EObject;

/**
 * @author Andreas Unger
 *
 */
public class StaticStepExpressionEvaluator {
		
	public void evaluate(IStaticEvaluationContext context, FunctionDeclaration functionDeclaration) {
		Evaluator evaluator = new Evaluator(context);
		for (Equation equation : functionDeclaration.getEquations()) {
			for (Iterator<EObject> it = equation.eAllContents(); it.hasNext();) {
				EObject next = it.next();
				if (next instanceof FeatureReference) {
					FeatureReference variableReference = (FeatureReference) next;
					if (variableReference.getStepExpression() != null) {
						Integer stepIndex = evaluator.doSwitch(variableReference.getStepExpression());
						context.getResult().getFunctionInfo(context.getFunctionCallPath()).setStepIndex(variableReference, stepIndex);
					}
				}
			}
		}
		context.getResult().collectStatus(evaluator.getStatus());
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
		 * @see org.eclipse.damos.mscript.language.ast.util.AstSwitch#caseAdditiveStepExpression(org.eclipse.damos.mscript.language.ast.AdditiveStepExpression)
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
			default:
				break;
			}
			throw new IllegalArgumentException();
		}
		
		/* (non-Javadoc)
		 * @see org.eclipse.damos.mscript.language.ast.util.AstSwitch#caseUnaryExpression(org.eclipse.damos.mscript.language.ast.UnaryExpression)
		 */
		@Override
		public Integer caseNegateStepExpression(NegateStepExpression negateStepExpression) {
			return -doSwitch(negateStepExpression.getOperand());
		}

		/* (non-Javadoc)
		 * @see org.eclipse.damos.mscript.language.ast.util.AstSwitch#caseStepLiteral(org.eclipse.damos.mscript.language.ast.StepLiteral)
		 */
		@Override
		public Integer caseStepLiteral(StepLiteral stepLiteral) {
			return stepLiteral.getValue();
		}
		
		/* (non-Javadoc)
		 * @see org.eclipse.damos.mscript.language.ast.util.AstSwitch#caseStepN(org.eclipse.damos.mscript.language.ast.StepN)
		 */
		@Override
		public Integer caseStepN(StepN stepN) {
			return 0;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipse.damos.mscript.language.ast.util.AstSwitch#defaultCase(org.eclipse.emf.ecore.EObject)
		 */
		@Override
		public Integer defaultCase(EObject object) {
			status.add(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Invalid expression", object));
			return 0;
		}
	
	}
	
}
