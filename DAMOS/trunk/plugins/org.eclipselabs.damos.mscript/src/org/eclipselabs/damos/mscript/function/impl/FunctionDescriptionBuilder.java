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

package org.eclipselabs.damos.mscript.function.impl;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipselabs.damos.mscript.CallableElement;
import org.eclipselabs.damos.mscript.Equation;
import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.FeatureReference;
import org.eclipselabs.damos.mscript.FunctionDeclaration;
import org.eclipselabs.damos.mscript.InputParameterDeclaration;
import org.eclipselabs.damos.mscript.OperatorKind;
import org.eclipselabs.damos.mscript.OutputParameterDeclaration;
import org.eclipselabs.damos.mscript.StateVariableDeclaration;
import org.eclipselabs.damos.mscript.StaticParameterDeclaration;
import org.eclipselabs.damos.mscript.UnaryExpression;
import org.eclipselabs.damos.mscript.function.EquationDescription;
import org.eclipselabs.damos.mscript.function.EquationPart;
import org.eclipselabs.damos.mscript.function.EquationSide;
import org.eclipselabs.damos.mscript.function.FunctionDescription;
import org.eclipselabs.damos.mscript.function.FunctionModelFactory;
import org.eclipselabs.damos.mscript.function.IFunctionDescriptionBuilder;
import org.eclipselabs.damos.mscript.function.VariableDescription;
import org.eclipselabs.damos.mscript.function.VariableKind;
import org.eclipselabs.damos.mscript.function.VariableStep;
import org.eclipselabs.damos.mscript.internal.MscriptPlugin;
import org.eclipselabs.damos.mscript.internal.util.StatusUtil;
import org.eclipselabs.damos.mscript.interpreter.IStaticEvaluationResult;
import org.eclipselabs.damos.mscript.util.MscriptSwitch;
import org.eclipselabs.damos.mscript.util.MscriptUtil;
import org.eclipselabs.damos.mscript.util.SyntaxStatus;

/**
 * @author Andreas Unger
 *
 */
public class FunctionDescriptionBuilder implements IFunctionDescriptionBuilder {

	public FunctionDescription build(IStaticEvaluationResult result, FunctionDeclaration functionDeclaration) {
		MultiStatus status = new MultiStatus(MscriptPlugin.PLUGIN_ID, 0, "Function descriptor construction", null);

		FunctionDescription functionDescription = FunctionModelFactory.eINSTANCE.createFunctionDescription();
		functionDescription.setDeclaration(functionDeclaration);

		for (Equation equation : functionDeclaration.getEquations()) {
			EquationDescription equationDescription = FunctionModelFactory.eINSTANCE.createEquationDescription();
			equationDescription.setFunctionDescription(functionDescription);
			equationDescription.setEquation(equation);
			
			Expression lhsExpression = equation.getLeftHandSide();
			EquationSide lhs = FunctionModelFactory.eINSTANCE.createEquationSide();
			lhs.setEquationDescription(equationDescription);
			lhs.setExpression(lhsExpression);
			StatusUtil.merge(status, new EquationSideInitializer(result, lhs).initialize());
			
			Expression rhsExpression = equation.getRightHandSide();
			EquationSide rhs = FunctionModelFactory.eINSTANCE.createEquationSide();
			rhs.setEquationDescription(equationDescription);
			rhs.setExpression(rhsExpression);
			StatusUtil.merge(status, new EquationSideInitializer(result, rhs).initialize());
		}
		
		result.collectStatus(status);

		return functionDescription;
	}
			
	private static class EquationSideInitializer extends MscriptSwitch<Boolean> {
		
		private IStaticEvaluationResult context;
		private EquationSide equationSide;
		private MultiStatus status;
		private boolean derivative;
		
		/**
		 * 
		 */
		public EquationSideInitializer(IStaticEvaluationResult result, EquationSide equationSide) {
			this.context = result;
			this.equationSide = equationSide;
		}
		
		public IStatus initialize() {
			status = new MultiStatus(MscriptPlugin.PLUGIN_ID, 0, "", null);
			doSwitch(equationSide.getExpression());
			return status;
		}
		
		@Override
		public Boolean caseUnaryExpression(UnaryExpression unaryExpression) {
			if (unaryExpression.getOperator() == OperatorKind.DERIVATIVE) {
				derivative = true;
				evaluateContents(unaryExpression);
				derivative = false;
				return true;
			}
			return super.caseUnaryExpression(unaryExpression);
		}
		
		@Override
		public Boolean caseFeatureReference(FeatureReference variableReference) {
			if (!MscriptUtil.isVariableReference(variableReference)) {
				return true;
			}
			String name = variableReference.getFeature().getName();
			
			FunctionDescription functionDescription = equationSide.getEquationDescription().getFunctionDescription();
			VariableKind variableKind = getVariableKind(variableReference.getFeature());
			
			checkFeatureCall(variableReference, variableKind);
			
			if (variableKind != VariableKind.UNKNOWN) {
				int stepIndex = 0;
				boolean initial = false;
				
				if (variableKind == VariableKind.INPUT_PARAMETER
						|| variableKind == VariableKind.OUTPUT_PARAMETER
						|| variableKind == VariableKind.STATE_VARIABLE) {
					stepIndex = context.getStepIndex(variableReference);
					initial = variableReference.isInitial();
				}
				
				if (!initial) {
					Equation equation = (Equation) equationSide.getExpression().eContainer();
					if (equation.getLeftHandSide() == equationSide.getExpression() && equation.isInitial()) {
						initial = true;
					}
				}

				EquationPart part = FunctionModelFactory.eINSTANCE.createEquationPart();
				part.setSide(equationSide);
				part.setVariableReference(variableReference);
				VariableDescription variableDescription = getVariableDescription(functionDescription, name, variableKind);
				
				VariableStep variableStep = variableDescription.getStep(stepIndex, initial, derivative);
				if (variableStep == null) {
					variableStep = FunctionModelFactory.eINSTANCE.createVariableStep();
					variableStep.setVariableDescription(variableDescription);
					variableStep.setIndex(stepIndex);
					variableStep.setInitial(initial);
					variableStep.setDerivative(derivative);
				}
				part.setVariableStep(variableStep);
			}
			return true;
		}
		
		/**
		 * @param featureCall
		 * @param variableKind
		 */
		private void checkFeatureCall(FeatureReference variableReference, VariableKind variableKind) {
			String message = null;
			switch (variableKind) {
			case INPUT_PARAMETER:
			case OUTPUT_PARAMETER:
			case STATE_VARIABLE:
				if (variableReference.getStepExpression() != null) {
					switch (equationSide.getEquationDescription().getFunctionDescription().getDeclaration().getKind()) {
					case STATELESS:
						message = "Variable references of stateless functions must not specify step expressions";
						break;
					case CONTINUOUS:
						message = "Variable references of continuous functions must not specify step expressions";
						break;
					default:
						// Do nothing
						break;
					}
				}
				break;
			default:
				// Do nothing
				break;
			}
			
			if (message != null) {
				status.add(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, message, variableReference));
			}
		}

		/**
		 * @param functionDescription
		 * @param name
		 * @param variableKind
		 * @return
		 */
		private VariableDescription getVariableDescription(FunctionDescription functionDescription, String name,
				VariableKind variableKind) {
			VariableDescription variableDescription = functionDescription.getVariableDescription(name);
			if (variableDescription == null) {
				variableDescription = FunctionModelFactory.eINSTANCE.createVariableDescription();
				variableDescription.setFunctionDescription(functionDescription);
				variableDescription.setName(name);
				variableDescription.setKind(variableKind);
			}
			return variableDescription;
		}

		private VariableKind getVariableKind(CallableElement feature) {
			if (feature instanceof StaticParameterDeclaration) {
				return VariableKind.STATIC_PARAMETER;
			}
			if (feature instanceof InputParameterDeclaration) {
				return VariableKind.INPUT_PARAMETER;
			}
			if (feature instanceof OutputParameterDeclaration) {
				return VariableKind.OUTPUT_PARAMETER;
			}
			if (feature instanceof StateVariableDeclaration) {
				return VariableKind.STATE_VARIABLE;
			}
			return VariableKind.UNKNOWN;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.MscriptSwitch#defaultCase(org.eclipse.emf.ecore.EObject)
		 */
		@Override
		public Boolean defaultCase(EObject object) {
			evaluateContents(object);
			return true;
		}

		/**
		 * @param object
		 */
		private void evaluateContents(EObject object) {
			for (EObject content : object.eContents()) {
				doSwitch(content);
			}
		}

	}

}
