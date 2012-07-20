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
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;
import org.eclipselabs.damos.mscript.Assertion;
import org.eclipselabs.damos.mscript.AssertionStatusKind;
import org.eclipselabs.damos.mscript.CallableElement;
import org.eclipselabs.damos.mscript.ConstantDeclaration;
import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.FunctionDeclaration;
import org.eclipselabs.damos.mscript.InputParameterDeclaration;
import org.eclipselabs.damos.mscript.MscriptPackage;
import org.eclipselabs.damos.mscript.OperatorKind;
import org.eclipselabs.damos.mscript.StaticParameterDeclaration;
import org.eclipselabs.damos.mscript.UnaryExpression;
import org.eclipselabs.damos.mscript.VariableReference;
import org.eclipselabs.damos.mscript.functionmodel.EquationDescriptor;
import org.eclipselabs.damos.mscript.functionmodel.EquationPart;
import org.eclipselabs.damos.mscript.functionmodel.FunctionDescriptor;
import org.eclipselabs.damos.mscript.functionmodel.impl.FunctionDescriptorBuilder;
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
	private final FunctionDescriptorBuilder functionDescriptorBuilder = new FunctionDescriptorBuilder();
	private final EValidator functionModelValidator = new FunctionModelValidator();
	private final IExpressionEvaluator expressionEvaluator = new ExpressionEvaluator();
	
	public void evaluate(IStaticEvaluationResult result, FunctionDeclaration functionDeclaration) {
		staticStepExpressionEvaluator.evaluate(result, functionDeclaration);

		FunctionDescriptor functionDescriptor = functionDescriptorBuilder.build(result, functionDeclaration);
		result.setFunctionDescriptor(functionDeclaration, functionDescriptor);

		BasicDiagnostic diagnostics = new BasicDiagnostic();
		for (EObjectTreeIterator it = new EObjectTreeIterator(functionDescriptor, true); it.hasNext();) {
			functionModelValidator.validate(it.next(), diagnostics, new HashMap<Object, Object>());
		}
		
		if (diagnostics.getSeverity() != Diagnostic.OK) {
			result.collectStatus(SyntaxStatus.toStatus(diagnostics));
		}

		if (!evaluateStaticAssertions(result, functionDescriptor)) {
			return;
		}
		evaluateAssertions(result, functionDescriptor);
		
		evaluateConstants(result, functionDescriptor);
		evaluateEquations(result, functionDescriptor);
	}

	private boolean evaluateStaticAssertions(IStaticEvaluationResult result, FunctionDescriptor functionDescriptor) {
		boolean passed = true;
		
		for (Assertion assertion : functionDescriptor.getDeclaration().getAssertions()) {
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
						result.collectStatus(new SyntaxStatus(severity, MscriptPlugin.PLUGIN_ID, 0, messageText, functionDescriptor.getDeclaration(), MscriptPackage.eINSTANCE.getDeclaration_Name()));
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
	 * @param functionDescriptor
	 */
	private void evaluateAssertions(IStaticEvaluationResult result, FunctionDescriptor functionDescriptor) {
		for (Assertion assertion : functionDescriptor.getDeclaration().getAssertions()) {
			if (!assertion.isStatic()) {
				expressionEvaluator.evaluate(new StaticExpressionEvaluationContext(result), assertion.getCondition());
			}
		}
	}

	/**
	 * @param result
	 * @param functionDescriptor
	 */
	private void evaluateConstants(IStaticEvaluationResult result, FunctionDescriptor functionDescriptor) {
		for (ConstantDeclaration constant : getSortedConstants(result, functionDescriptor)) {
			IExpressionEvaluationContext expressionEvaluationContext = new StaticExpressionEvaluationContext(result);
			expressionEvaluationContext.enterStaticScope();
			IValue value = expressionEvaluator.evaluate(expressionEvaluationContext, constant.getInitializer());
			if (value instanceof InvalidValue) {
				continue;
			}
			result.setValue(constant, value);
		}
	}
	
	/**
	 * @param result
	 * @param functionDescriptor
	 */
	private void evaluateEquations(IStaticEvaluationResult result, FunctionDescriptor functionDescriptor) {
		Collection<EquationDescriptor> sortedEquations = getSortedEquations(result, functionDescriptor);
		
		boolean changed;
		do {
			changed = false;
			for (EquationDescriptor equationDescriptor : sortedEquations) {
				IValue value = expressionEvaluator.evaluate(new StaticExpressionEvaluationContext(result), equationDescriptor.getRightHandSide().getExpression());
				if (value instanceof InvalidValue) {
					continue;
				}
				
				boolean derivative = false;
				Expression leftHandSideExpression = equationDescriptor.getLeftHandSide().getExpression();
				if (leftHandSideExpression instanceof UnaryExpression && ((UnaryExpression) leftHandSideExpression).getOperator() == OperatorKind.DERIVATIVE) {
					leftHandSideExpression = ((UnaryExpression) leftHandSideExpression).getOperand();
					derivative = true;
				}
				VariableReference variableReference = (VariableReference) leftHandSideExpression;
				
				IValue leftHandSideValue = result.getValue(variableReference.getFeature());
				IValue rightHandSideValue = result.getValue(equationDescriptor.getRightHandSide().getExpression());
				if (!(leftHandSideValue instanceof InvalidValue) && !(rightHandSideValue instanceof InvalidValue)) {
					DataType dataType;
					
					DataType rightHandSideDataType = rightHandSideValue.getDataType();
					if (derivative) {
						rightHandSideDataType = rightHandSideDataType.evaluate(OperatorKind.MULTIPLY, TypeUtil.createRealType("s"));
					}
					if (leftHandSideValue != null) {
						dataType = TypeUtil.getLeftHandDataType(leftHandSideValue.getDataType(), rightHandSideDataType);
					} else {
						dataType = rightHandSideDataType;
					}
					
					if (dataType != null) {
						DataType previousDataType = null;
						IValue previousValue = result.getValue(variableReference.getFeature());
						if (previousValue != null) {
							previousDataType = previousValue.getDataType();
						}
						if (previousDataType == null || !previousDataType.isEquivalentTo(dataType)) {
							changed = true;
						}
						AnyValue anyValue = new AnyValue(result.getComputationContext(), dataType);
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
	
	private Collection<EquationDescriptor> getSortedEquations(IStaticEvaluationResult result, FunctionDescriptor functionDescriptor) {
		Set<CallableElement> definedFeatures = new HashSet<CallableElement>();
		List<EquationDescriptor> sortedEquations = new ArrayList<EquationDescriptor>();
		List<EquationDescriptor> backlog = new LinkedList<EquationDescriptor>(functionDescriptor.getEquationDescriptors());
		
		boolean changed;
		do {
			changed = false;
			for (Iterator<EquationDescriptor> it = backlog.iterator(); it.hasNext();) {
				EquationDescriptor equationDescriptor = it.next();
				boolean defined = true;
				for (EquationPart part : equationDescriptor.getRightHandSide().getParts()) {
					VariableReference variableReference = (VariableReference) part.getVariableAccess();
					if (variableReference.getFeature() instanceof StaticParameterDeclaration || variableReference.getFeature() instanceof InputParameterDeclaration) {
						continue;
					}
					if (!definedFeatures.contains(variableReference.getFeature())) {
						defined = false;
						break;
					}
				}
				if (defined) {
					Expression expression = equationDescriptor.getLeftHandSide().getExpression();
					if (expression instanceof UnaryExpression) {
						UnaryExpression postfixExpression = (UnaryExpression) expression;
						if (postfixExpression.getOperator() == OperatorKind.DERIVATIVE) {
							expression = postfixExpression.getOperand();
						}
					}
					if (expression instanceof VariableReference) {
						VariableReference variableReference = (VariableReference) expression;
						definedFeatures.add(variableReference.getFeature());
						sortedEquations.add(equationDescriptor);
						it.remove();
						changed = true;
					}
				}
			}
		} while (changed);
		
		for (EquationDescriptor equationDescriptor : backlog) {
			for (EquationPart part : equationDescriptor.getRightHandSide().getParts()) {
				VariableReference variableReference = (VariableReference) part.getVariableAccess();
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
		
	private Collection<ConstantDeclaration> getSortedConstants(IStaticEvaluationResult result, FunctionDescriptor functionDescriptor) {
		Set<ConstantDeclaration> definedConstants = new HashSet<ConstantDeclaration>();
		List<ConstantDeclaration> sortedConstants = new ArrayList<ConstantDeclaration>();
		List<ConstantDeclaration> backlog = new LinkedList<ConstantDeclaration>(functionDescriptor.getDeclaration().getConstantDeclarations());
		
		boolean changed;
		do {
			changed = false;
			for (Iterator<ConstantDeclaration> it = backlog.iterator(); it.hasNext();) {
				ConstantDeclaration constant = it.next();
				boolean defined = true;
				for (TreeIterator<EObject> initializerIt = constant.getInitializer().eAllContents(); initializerIt.hasNext();) {
					EObject next = initializerIt.next();
					if (next instanceof VariableReference) {
						VariableReference variableReference = (VariableReference) next;
						if (!(variableReference.getFeature() instanceof ConstantDeclaration)) {
							continue;
						}
						if (!definedConstants.contains(variableReference.getFeature())) {
							defined = false;
							break;
						}
					}
				}
				if (defined) {
					definedConstants.add(constant);
					sortedConstants.add(constant);
					it.remove();
					changed = true;
				}
			}
		} while (changed);
		
		for (ConstantDeclaration constant : backlog) {
			for (TreeIterator<EObject> initializerIt = constant.getInitializer().eAllContents(); initializerIt.hasNext();) {
				EObject next = initializerIt.next();
				if (next instanceof VariableReference) {
					VariableReference variableReference = (VariableReference) next;
					if (!definedConstants.contains(variableReference.getFeature())) {
						result.collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0,
								"The value of the constant " + variableReference.getFeature().getName()
										+ " could not be determined",
								variableReference));
					}
				}
			}
		}
		
		return sortedConstants;
	}

}
