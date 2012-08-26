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

package org.eclipselabs.damos.mscript.interpreter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EValidator;
import org.eclipselabs.damos.mscript.Assertion;
import org.eclipselabs.damos.mscript.AssertionStatusKind;
import org.eclipselabs.damos.mscript.CallableElement;
import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.FeatureReference;
import org.eclipselabs.damos.mscript.FunctionDeclaration;
import org.eclipselabs.damos.mscript.InputParameterDeclaration;
import org.eclipselabs.damos.mscript.MscriptPackage;
import org.eclipselabs.damos.mscript.OperatorKind;
import org.eclipselabs.damos.mscript.StaticParameterDeclaration;
import org.eclipselabs.damos.mscript.Type;
import org.eclipselabs.damos.mscript.UnaryExpression;
import org.eclipselabs.damos.mscript.functionmodel.EquationDescription;
import org.eclipselabs.damos.mscript.functionmodel.EquationPart;
import org.eclipselabs.damos.mscript.functionmodel.FunctionDescription;
import org.eclipselabs.damos.mscript.functionmodel.impl.FunctionDescriptionBuilder;
import org.eclipselabs.damos.mscript.functionmodel.util.FunctionModelValidator;
import org.eclipselabs.damos.mscript.internal.MscriptPlugin;
import org.eclipselabs.damos.mscript.internal.util.EObjectTreeIterator;
import org.eclipselabs.damos.mscript.interpreter.value.AnyValue;
import org.eclipselabs.damos.mscript.interpreter.value.IBooleanValue;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;
import org.eclipselabs.damos.mscript.interpreter.value.InvalidValue;
import org.eclipselabs.damos.mscript.interpreter.value.StringValue;
import org.eclipselabs.damos.mscript.util.SyntaxStatus;
import org.eclipselabs.damos.mscript.util.TypeUtil;

/**
 * @author Andreas Unger
 *
 */
public class StaticFunctionEvaluator {
	
	private final StaticStepExpressionEvaluator staticStepExpressionEvaluator = new StaticStepExpressionEvaluator();
	private final FunctionDescriptionBuilder functionDescriptionBuilder = new FunctionDescriptionBuilder();
	private final EValidator functionModelValidator = new FunctionModelValidator();
	private final IExpressionEvaluator expressionEvaluator = new ExpressionEvaluator();
	
	public void evaluate(IStaticEvaluationResult result, FunctionDeclaration functionDeclaration) {
		staticStepExpressionEvaluator.evaluate(result, functionDeclaration);

		FunctionDescription functionDescription = functionDescriptionBuilder.build(result, functionDeclaration);
		result.setFunctionDescriptor(functionDeclaration, functionDescription);

		BasicDiagnostic diagnostics = new BasicDiagnostic();
		for (EObjectTreeIterator it = new EObjectTreeIterator(functionDescription, true); it.hasNext();) {
			functionModelValidator.validate(it.next(), diagnostics, new HashMap<Object, Object>());
		}
		
		if (diagnostics.getSeverity() != Diagnostic.OK) {
			result.collectStatus(SyntaxStatus.toStatus(diagnostics));
		}

		if (!evaluateStaticAssertions(result, functionDescription)) {
			return;
		}
		evaluateAssertions(result, functionDescription);
		
		evaluateEquations(result, functionDescription);
	}

	private boolean evaluateStaticAssertions(IStaticEvaluationResult result, FunctionDescription functionDescription) {
		boolean passed = true;
		
		for (Assertion assertion : functionDescription.getDeclaration().getAssertions()) {
			if (assertion.isStatic()) {
				IExpressionEvaluationContext expressionEvaluationContext = new StaticExpressionEvaluationContext(result);
				expressionEvaluationContext.enterStaticScope();
				IValue value = expressionEvaluator.evaluate(expressionEvaluationContext, assertion.getCondition());
				if (value instanceof InvalidValue) {
					continue;
				}
				if (!(value instanceof IBooleanValue)) {
					result.collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Assertion condition must result to boolean value", assertion.getCondition()));
					continue;
				}
				if (!((IBooleanValue) value).booleanValue()) {
					IValue message = expressionEvaluator.evaluate(expressionEvaluationContext, assertion.getMessage());
					if (message instanceof InvalidValue) {
						continue;
					}
					if (message instanceof StringValue) {
						String messageText = message.toString();
						int severity;
						switch (assertion.getStatusKind()) {
						case INFO:
							severity = IStatus.INFO;
							break;
						case WARNING:
							severity = IStatus.WARNING;
							break;
						default:
							severity = IStatus.ERROR;
							break;
						}
						if (severity > IStatus.WARNING) {
							passed = false;
						}
						result.collectStatus(new SyntaxStatus(severity, MscriptPlugin.PLUGIN_ID, 0, messageText, functionDescription.getDeclaration(), MscriptPackage.eINSTANCE.getFunctionDeclaration_Name()));
						if (assertion.getStatusKind() == AssertionStatusKind.FATAL) {
							break;
						}
					} else {
						result.collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Assertion message must result to string", assertion.getMessage()));
					}
				}
			}
		}
		
		return passed;
	}

	/**
	 * @param result
	 * @param functionDescription
	 */
	private void evaluateAssertions(IStaticEvaluationResult result, FunctionDescription functionDescription) {
		for (Assertion assertion : functionDescription.getDeclaration().getAssertions()) {
			if (!assertion.isStatic()) {
				expressionEvaluator.evaluate(new StaticExpressionEvaluationContext(result), assertion.getCondition());
			}
		}
	}

	/**
	 * @param result
	 * @param functionDescription
	 */
	private void evaluateEquations(IStaticEvaluationResult result, FunctionDescription functionDescription) {
		Collection<EquationDescription> sortedEquations = getSortedEquations(result, functionDescription);
		
		boolean changed;
		do {
			changed = false;
			for (EquationDescription equationDescription : sortedEquations) {
				IValue value = expressionEvaluator.evaluate(new StaticExpressionEvaluationContext(result), equationDescription.getRightHandSide().getExpression());
				if (value instanceof InvalidValue) {
					continue;
				}
				
				boolean derivative = false;
				Expression leftHandSideExpression = equationDescription.getLeftHandSide().getExpression();
				if (leftHandSideExpression instanceof UnaryExpression && ((UnaryExpression) leftHandSideExpression).getOperator() == OperatorKind.DERIVATIVE) {
					leftHandSideExpression = ((UnaryExpression) leftHandSideExpression).getOperand();
					derivative = true;
				}
				FeatureReference variableReference = (FeatureReference) leftHandSideExpression;
				
				IValue leftHandSideValue = result.getValue(variableReference.getFeature());
				IValue rightHandSideValue = result.getValue(equationDescription.getRightHandSide().getExpression());
				if (!(leftHandSideValue instanceof InvalidValue) && !(rightHandSideValue instanceof InvalidValue)) {
					Type type;
					
					Type rightHandSideDataType = rightHandSideValue.getDataType();
					if (derivative) {
						rightHandSideDataType = rightHandSideDataType.evaluate(OperatorKind.MULTIPLY, TypeUtil.createRealType(equationDescription.getEquation().eResource().getResourceSet(), "s"));
					}
					if (leftHandSideValue != null) {
						type = TypeUtil.getLeftHandDataType(leftHandSideValue.getDataType(), rightHandSideDataType);
					} else {
						type = rightHandSideDataType;
					}
					
					if (type != null) {
						Type previousDataType = null;
						IValue previousValue = result.getValue(variableReference.getFeature());
						if (previousValue != null) {
							previousDataType = previousValue.getDataType();
						}
						if (previousDataType == null || !previousDataType.isEquivalentTo(type)) {
							changed = true;
						}
						AnyValue anyValue = new AnyValue(result.getComputationContext(), type);
						result.setValue(variableReference, anyValue);
						result.setValue(variableReference.getFeature(), anyValue);
					} else {
						result.collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0,
								"The data type of the variable " + variableReference.getFeature().getName()
										+ " could not be determined",
								variableReference.getFeature()));
					}
				}
			}
		} while (changed);
	}
	
	private Collection<EquationDescription> getSortedEquations(IStaticEvaluationResult result, FunctionDescription functionDescription) {
		Set<CallableElement> definedFeatures = new HashSet<CallableElement>();
		List<EquationDescription> sortedEquations = new ArrayList<EquationDescription>();
		List<EquationDescription> backlog = new LinkedList<EquationDescription>(functionDescription.getEquationDescriptions());
		
		boolean changed;
		do {
			changed = false;
			for (Iterator<EquationDescription> it = backlog.iterator(); it.hasNext();) {
				EquationDescription equationDescription = it.next();
				boolean defined = true;
				for (EquationPart part : equationDescription.getRightHandSide().getParts()) {
					FeatureReference variableReference = part.getVariableReference();
					if (variableReference.getFeature() instanceof StaticParameterDeclaration || variableReference.getFeature() instanceof InputParameterDeclaration) {
						continue;
					}
					if (!definedFeatures.contains(variableReference.getFeature())) {
						defined = false;
						break;
					}
				}
				if (defined) {
					Expression expression = equationDescription.getLeftHandSide().getExpression();
					if (expression instanceof UnaryExpression) {
						UnaryExpression postfixExpression = (UnaryExpression) expression;
						if (postfixExpression.getOperator() == OperatorKind.DERIVATIVE) {
							expression = postfixExpression.getOperand();
						}
					}
					if (expression instanceof FeatureReference) {
						FeatureReference variableReference = (FeatureReference) expression;
						definedFeatures.add(variableReference.getFeature());
						sortedEquations.add(equationDescription);
						it.remove();
						changed = true;
					}
				}
			}
		} while (changed);
		
		for (EquationDescription equationDescription : backlog) {
			for (EquationPart part : equationDescription.getRightHandSide().getParts()) {
				FeatureReference variableReference = part.getVariableReference();
				if (!definedFeatures.contains(variableReference.getFeature())) {
					result.collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0,
							"The data type of the variable " + variableReference.getFeature().getName()
									+ " could not be determined",
							variableReference));
				}
			}
		}
		
		return sortedEquations;
	}
		
}
