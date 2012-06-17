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
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipselabs.damos.mscript.Assertion;
import org.eclipselabs.damos.mscript.AssertionStatusKind;
import org.eclipselabs.damos.mscript.CallableElement;
import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.FunctionDeclaration;
import org.eclipselabs.damos.mscript.InputParameterDeclaration;
import org.eclipselabs.damos.mscript.MscriptPackage;
import org.eclipselabs.damos.mscript.OperatorKind;
import org.eclipselabs.damos.mscript.PostfixExpression;
import org.eclipselabs.damos.mscript.StringLiteral;
import org.eclipselabs.damos.mscript.TemplateParameterDeclaration;
import org.eclipselabs.damos.mscript.VariableReference;
import org.eclipselabs.damos.mscript.functionmodel.EquationDescriptor;
import org.eclipselabs.damos.mscript.functionmodel.EquationPart;
import org.eclipselabs.damos.mscript.functionmodel.FunctionDescriptor;
import org.eclipselabs.damos.mscript.functionmodel.IFunctionDescriptorBuilderResult;
import org.eclipselabs.damos.mscript.functionmodel.impl.FunctionDescriptorBuilder;
import org.eclipselabs.damos.mscript.functionmodel.util.FunctionModelValidator;
import org.eclipselabs.damos.mscript.internal.MscriptPlugin;
import org.eclipselabs.damos.mscript.internal.util.EObjectTreeIterator;
import org.eclipselabs.damos.mscript.internal.util.StatusUtil;
import org.eclipselabs.damos.mscript.interpreter.value.AnyValue;
import org.eclipselabs.damos.mscript.interpreter.value.IBooleanValue;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;
import org.eclipselabs.damos.mscript.interpreter.value.InvalidValue;
import org.eclipselabs.damos.mscript.util.SyntaxStatus;
import org.eclipselabs.damos.mscript.util.TypeUtil;

/**
 * @author Andreas Unger
 *
 */
public class StaticFunctionEvaluator {
	
	public IStatus evaluate(IStaticEvaluationContext context, FunctionDeclaration functionDeclaration) {
		MultiStatus multiStatus = new MultiStatus(MscriptPlugin.PLUGIN_ID, 0, "Static function evaluation", null);
		StatusUtil.merge(multiStatus, new StaticStepExpressionEvaluator().evaluate(context, functionDeclaration));

		IFunctionDescriptorBuilderResult functionDescriptorBuilderResult = new FunctionDescriptorBuilder().build(context, functionDeclaration);
		StatusUtil.merge(multiStatus, functionDescriptorBuilderResult.getStatus());
		FunctionDescriptor functionDescriptor = functionDescriptorBuilderResult.getFunctionDescriptor();
		context.setFunctionDescriptor(functionDeclaration, functionDescriptor);

		FunctionModelValidator validator = new FunctionModelValidator();
		BasicDiagnostic diagnostics = new BasicDiagnostic();
		for (EObjectTreeIterator it = new EObjectTreeIterator(functionDescriptor, true); it.hasNext();) {
			validator.validate(it.next(), diagnostics, new HashMap<Object, Object>());
		}
		if (diagnostics.getSeverity() != Diagnostic.OK) {
			StatusUtil.merge(multiStatus, SyntaxStatus.toStatus(diagnostics));
		}

		StatusUtil.merge(multiStatus, evaluate(context, functionDescriptor));
		
		return multiStatus;
	}

	private IStatus evaluate(IStaticEvaluationContext context, FunctionDescriptor functionDescriptor) {
		MultiStatus status = new MultiStatus(MscriptPlugin.PLUGIN_ID, 0, "Static function evaluation", null);
		StaticExpressionEvaluator staticExpressionEvaluator = new StaticExpressionEvaluator();
		
		for (Assertion assertion : functionDescriptor.getDeclaration().getAssertions()) {
			if (assertion.isStatic()) {
				IStatus assertStatus = staticExpressionEvaluator.evaluate(context, assertion.getCondition(), true);
				if (!assertStatus.isOK()) {
					status.merge(assertStatus);
				}
				IValue value = context.getValue(assertion.getCondition());
				if (value instanceof InvalidValue) {
					continue;
				}
				if (!(value instanceof IBooleanValue)) {
					status.add(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Assertion condition must result to boolean value", assertion.getCondition()));
					continue;
				}
				if (!((IBooleanValue) value).booleanValue()) {
					Expression message = assertion.getMessage();
					if (message instanceof StringLiteral) {
						StringLiteral stringMessage = (StringLiteral) message;
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
						status.add(new SyntaxStatus(severity, MscriptPlugin.PLUGIN_ID, 0, stringMessage.getValue(), functionDescriptor.getDeclaration(), MscriptPackage.eINSTANCE.getDeclaration_Name()));
						if (assertion.getStatusKind() == AssertionStatusKind.FATAL) {
							return status;
						}
					}
				}
			}
		}
		
		if (status.getSeverity() > IStatus.WARNING) {
			return status;
		}
		
		for (Assertion assertion : functionDescriptor.getDeclaration().getAssertions()) {
			if (!assertion.isStatic()) {
				staticExpressionEvaluator.evaluate(context, assertion.getCondition());
			}
		}
		
		Collection<EquationDescriptor> sortedEquations = getSortedEquations(functionDescriptor, status);
		
		boolean changed;
		do {
			changed = false;
			for (EquationDescriptor equationDescriptor : sortedEquations) {
				StatusUtil.merge(status, staticExpressionEvaluator.evaluate(context, equationDescriptor.getRightHandSide().getExpression()));
				
				boolean derivative = false;
				Expression leftHandSideExpression = equationDescriptor.getLeftHandSide().getExpression();
				if (leftHandSideExpression instanceof PostfixExpression) {
					leftHandSideExpression = ((PostfixExpression) leftHandSideExpression).getOperand();
					derivative = true;
				}
				VariableReference variableReference = (VariableReference) leftHandSideExpression;
				
				IValue leftHandSideValue = context.getValue(variableReference.getFeature());
				IValue rightHandSideValue = context.getValue(equationDescriptor.getRightHandSide().getExpression());
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
						IValue previousValue = context.getValue(variableReference.getFeature());
						if (previousValue != null) {
							previousDataType = previousValue.getDataType();
						}
						if (previousDataType == null || !previousDataType.isEquivalentTo(dataType)) {
							changed = true;
						}
						AnyValue value = new AnyValue(context.getComputationContext(), dataType);
						context.setValue(variableReference, value);
						context.setValue(variableReference.getFeature(), value);
					} else {
						status.add(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0,
								"The data type of the variable " + variableReference.getFeature().getName()
										+ " could not be determined",
								variableReference.getFeature()));
					}
				}
			}
		} while (changed);
		
		return status;
	}
	
	private Collection<EquationDescriptor> getSortedEquations(FunctionDescriptor functionDescriptor, MultiStatus status) {
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
					if (variableReference.getFeature() instanceof TemplateParameterDeclaration || variableReference.getFeature() instanceof InputParameterDeclaration) {
						continue;
					}
					if (!definedFeatures.contains(variableReference.getFeature())) {
						defined = false;
						break;
					}
				}
				if (defined) {
					Expression expression = equationDescriptor.getLeftHandSide().getExpression();
					if (expression instanceof PostfixExpression) {
						PostfixExpression postfixExpression = (PostfixExpression) expression;
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
					status.add(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0,
							"The data type of the variable " + variableReference.getFeature().getName()
									+ " could not be determined",
							variableReference));
				}
			}
		}
		
		return sortedEquations;
	}
		

}
