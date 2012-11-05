/*******************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Andreas Unger - initial API and implementation
 *******************************************************************************/
package org.eclipse.damos.mscript.validation;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.damos.mscript.AdditiveStepExpression;
import org.eclipse.damos.mscript.AlgorithmExpression;
import org.eclipse.damos.mscript.AnonymousTypeSpecifier;
import org.eclipse.damos.mscript.ArrayElementAccess;
import org.eclipse.damos.mscript.ArraySubscript;
import org.eclipse.damos.mscript.BuiltinFunctionDeclaration;
import org.eclipse.damos.mscript.CallableElement;
import org.eclipse.damos.mscript.CheckArgument;
import org.eclipse.damos.mscript.ConstantDeclaration;
import org.eclipse.damos.mscript.DeclaredTypeSpecifier;
import org.eclipse.damos.mscript.DerivedUnitDeclaration;
import org.eclipse.damos.mscript.EndExpression;
import org.eclipse.damos.mscript.Expression;
import org.eclipse.damos.mscript.ExpressionCheckArgument;
import org.eclipse.damos.mscript.FeatureReference;
import org.eclipse.damos.mscript.FunctionCall;
import org.eclipse.damos.mscript.FunctionDeclaration;
import org.eclipse.damos.mscript.InputParameterDeclaration;
import org.eclipse.damos.mscript.MscriptPackage;
import org.eclipse.damos.mscript.NegateStepExpression;
import org.eclipse.damos.mscript.OperatorKind;
import org.eclipse.damos.mscript.OutputParameterDeclaration;
import org.eclipse.damos.mscript.PrimitiveType;
import org.eclipse.damos.mscript.StateVariableDeclaration;
import org.eclipse.damos.mscript.StepN;
import org.eclipse.damos.mscript.Type;
import org.eclipse.damos.mscript.TypeCheckArgument;
import org.eclipse.damos.mscript.TypeDeclaration;
import org.eclipse.damos.mscript.TypeSpecifier;
import org.eclipse.damos.mscript.UnitDeclaration;
import org.eclipse.damos.mscript.UnitFactor;
import org.eclipse.damos.mscript.interpreter.ComputationContext;
import org.eclipse.damos.mscript.interpreter.ExpressionEvaluator;
import org.eclipse.damos.mscript.interpreter.FunctionCallPath;
import org.eclipse.damos.mscript.interpreter.IExpressionEvaluator;
import org.eclipse.damos.mscript.interpreter.IStaticEvaluationResult;
import org.eclipse.damos.mscript.interpreter.StaticEvaluationContext;
import org.eclipse.damos.mscript.interpreter.StaticEvaluationResult;
import org.eclipse.damos.mscript.interpreter.StaticExpressionEvaluationContext;
import org.eclipse.damos.mscript.interpreter.StaticFunctionEvaluator;
import org.eclipse.damos.mscript.interpreter.value.AnyValue;
import org.eclipse.damos.mscript.interpreter.value.IValue;
import org.eclipse.damos.mscript.interpreter.value.InvalidValue;
import org.eclipse.damos.mscript.util.MscriptUtil;
import org.eclipse.damos.mscript.util.SyntaxStatus;
import org.eclipse.damos.mscript.validation.AbstractMscriptJavaValidator;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;

import com.google.common.collect.Lists;

public class MscriptJavaValidator extends AbstractMscriptJavaValidator {
	
	private final IExpressionEvaluator expressionEvaluator = new ExpressionEvaluator();

	@Check
	public void checkAlgorithmExpression(AlgorithmExpression algorithmExpression) {
		error("Algorithm expressions not supported", null);
	}
	
	@Check
	public void checkStatelessFunction(FunctionDeclaration functionDeclaration) {
//		if (functionDeclaration.getKind() == FunctionKind.STATELESS) {
//			for (StateVariableDeclaration stateVariableDeclaration : functionDeclaration.getStateVariableDeclarations()) {
//				error("The state variable " + stateVariableDeclaration.getName() + " can only be declared in stateful or continuous functions", stateVariableDeclaration, null, -1);
//			}
//		}
	}

	@Check
	public void checkFunctionHasChecks(FunctionDeclaration functionDeclaration) {
		if (functionDeclaration.getChecks().isEmpty()) {
			warning("No static checking can be performed for " + functionDeclaration.getName() + " since no checks have been defined", null);
		}
	}
	
//	@Check
//	public void checkVariableReferenceReferencesVariable(VariableReference variableReference) {
//		if (variableReference.getFeature() == null || variableReference.getFeature().eIsProxy()) {
//			return;
//		}
//		CallableElement ce = variableReference.getFeature();
//		if (!(ce instanceof ParameterDeclaration
//				|| ce instanceof VariableDeclaration
//				|| ce instanceof BuiltinVariableDeclaration)) {
//			error("Invalid variable reference " + variableReference.getFeature().getName(), null);
//		}
//	}

	@Check
	public void checkVariableAccessStepExpressionApplication(FeatureReference variableReference) {
		if (variableReference.getFeature() == null || variableReference.getFeature().eIsProxy()) {
			return;
		}
		if (variableReference.getStepExpression() != null) {
			CallableElement ce = variableReference.getFeature();
			if (!(ce instanceof InputParameterDeclaration
					|| ce instanceof OutputParameterDeclaration
					|| ce instanceof StateVariableDeclaration)) {
				error("Step expression cannot be specified on " + variableReference.getFeature().getName(), null);
			}
		}
	}

	@Check
	public void checkFunctionCallReferencesVariable(FunctionCall functionCall) {
		if (functionCall.getFeature() == null || functionCall.getFeature().eIsProxy()) {
			return;
		}
		CallableElement ce = functionCall.getFeature();
		if (!(ce instanceof FunctionDeclaration
				|| ce instanceof BuiltinFunctionDeclaration)) {
			error("Invalid function call " + functionCall.getFeature().getName(), null);
		}
	}
	
	@Check
	public void checkInputParameterDeclarationDefaultExpression(InputParameterDeclaration inputParameterDeclaration) {
		if (!inputParameterDeclaration.isConstant() && inputParameterDeclaration.getDefaultExpression() != null) {
			error("Default expression can only be specified for constant input parameters", inputParameterDeclaration.getDefaultExpression(), null, -1);
		}
	}
	
	@Check
	public void checkInputParameterDeclarationDefaultExpressionOrder(FunctionDeclaration functionDeclaration) {
		boolean hasNonDefaultParameter = false;
		for (InputParameterDeclaration inputParameterDeclaration : Lists.reverse(functionDeclaration.getInputParameterDeclarations())) {
			if (inputParameterDeclaration.getDefaultExpression() == null) {
				hasNonDefaultParameter = true;
			} else if (inputParameterDeclaration.isConstant() && hasNonDefaultParameter) {
				error("Input parameters with default expressions must be last parameters", inputParameterDeclaration, null, -1);
			}
		}
	}
	
	@Check
	public void checkStatefulFunctionEnclosingExpression(FunctionCall functionCall) {
//		if (functionCall.getFeature() instanceof FunctionDeclaration) {
//			FunctionDeclaration functionDeclaration = (FunctionDeclaration) functionCall.getFeature();
//			if (functionDeclaration.getKind() == FunctionKind.STATEFUL) {
//				EObject element = functionCall;
//				EObject container = element.eContainer();
//				while (container instanceof Expression) {
//					if (container instanceof AlgorithmExpression) {
//						error("Stateful function calls must not be contained within algorithm expressions", null);
//						break;
//					}
//					if (container instanceof IfExpression) {
//						IfExpression ifExpression = (IfExpression) container;
//						if (!ifExpression.isStatic() && (ifExpression.getThenExpression() == element || ifExpression.getElseExpression() == element)) {
//							error("Stateful function calls must not be contained within non-static if-then or if-else expression", null);
//							break;
//						}
//					}
//					if (container instanceof SwitchExpression) {
//						SwitchExpression switchExpression = (SwitchExpression) container;
//						if (!switchExpression.isStatic() && switchExpression.getDefaultExpression() == element) {
//							error("Stateful function calls must not be contained within non-static switch default expression", null);
//							break;
//						}
//					}
//					if (container instanceof SwitchCase) {
//						SwitchCase switchCase = (SwitchCase) container;
//						if (!switchCase.getOwner().isStatic() && (switchCase.getCaseExpression() == element || switchCase.getResultExpression() == element)) {
//							error("Stateful function calls must not be contained within non-static switch case expression", null);
//							break;
//						}
//					}
//					if (container instanceof LogicalAndExpression) {
//						error("Stateful function calls must not be contained within AND expression", null);
//						break;
//					}
//					if (container instanceof LogicalOrExpression) {
//						error("Stateful function calls must not be contained within OR expression", null);
//						break;
//					}
//					if (container instanceof ImpliesExpression) {
//						error("Stateful function calls must not be contained within implies expression", null);
//						break;
//					}
//					element = container;
//					container = element.eContainer();
//				}
//			}
//		}
	}

	@Check
	public void checkEndExpressionMustBeInsideArraySubscript(EndExpression endExpression) {
		if (!isInsideArraySubscript(endExpression)) {
			error("'end' may only appear inside array subscripts", null);
		}
	}
	
	@Check
	public void checkStepNNotNegated(NegateStepExpression negateStepExpression) {
		if (negateStepExpression.getOperand() instanceof StepN) {
			warning("Negating step n has no effect", null);
		}
	}

	@Check
	public void checkStepNNotNegated(AdditiveStepExpression additiveStepExpression) {
		if (additiveStepExpression.getRightOperand() instanceof StepN && additiveStepExpression.getOperator() == OperatorKind.SUBTRACT) {
			warning("Subtracting step n has no effect, use addition instead", null);
		}
	}

	private boolean isInsideArraySubscript(EObject eObject) {
		EObject container = eObject.eContainer();
		
		while (container != null && !(container instanceof ArraySubscript)) {
			container = container.eContainer();
		}
		
		return container instanceof ArraySubscript && ((ArraySubscript) container).eContainer() instanceof ArrayElementAccess;
	}
	
	@Check
	public void checkTypes(FunctionDeclaration functionDeclaration) {
		for (org.eclipse.damos.mscript.Check check : functionDeclaration.getChecks()) {
			if (!checkFunctionCheckSignatures(check)) {
				continue;
			}
			
			IStaticEvaluationResult staticEvaluationResult = new StaticEvaluationResult();
			
			if (!evaluateCheckInputArguments(check, staticEvaluationResult)) {
				continue;
			}
			
			new StaticFunctionEvaluator().evaluate(new StaticEvaluationContext(staticEvaluationResult), functionDeclaration);
			
			if (staticEvaluationResult.getStatus().getSeverity() < IStatus.ERROR) {
				Iterator<OutputParameterDeclaration> outputParameterIt = functionDeclaration.getOutputParameterDeclarations().iterator();
				for (TypeSpecifier typeSpecifier : check.getOutputTypeSpecifiers()) {
					IValue value = staticEvaluationResult.getFunctionInfo(FunctionCallPath.EMPTY).getValue(outputParameterIt.next());
					if (value != null && !(value instanceof InvalidValue) && isResolved(typeSpecifier.getType()) && !typeSpecifier.getType().isEquivalentTo(value.getDataType())) {
						error("Check does not return specified data type", typeSpecifier, null, -1);
					}
				}
			}
			
			SyntaxStatus.addAllSyntaxStatusesToDiagnostics(staticEvaluationResult.getStatus(), getChain());
		}
	}

	/**
	 * @param check
	 * @param staticEvaluationResult
	 * @return
	 */
	private boolean evaluateCheckInputArguments(org.eclipse.damos.mscript.Check check,
			IStaticEvaluationResult staticEvaluationResult) {
		Iterator<CheckArgument> argumentIt = check.getInputArguments().iterator();
		for (InputParameterDeclaration parameter : check.getFunction().getInputParameterDeclarations()) {
			CheckArgument argument = argumentIt.hasNext() ? argumentIt.next() : null;
			if (parameter.isConstant()) {
				Expression expression = null;
				if (argument == null) {
					expression = parameter.getDefaultExpression();
				} else if (argument instanceof ExpressionCheckArgument) {
					expression = ((ExpressionCheckArgument) argument).getExpression();
				}
				if (expression == null) {
					return false;
				}
				IValue value = expressionEvaluator.evaluate(new StaticExpressionEvaluationContext(new StaticEvaluationContext(staticEvaluationResult)), expression);
				staticEvaluationResult.getFunctionInfo(FunctionCallPath.EMPTY).setValue(parameter, value);
			} else {
				if (!(argument instanceof TypeCheckArgument)) {
					return false;
				}
				TypeSpecifier typeSpecifier = ((TypeCheckArgument) argument).getTypeSpecifier();
				staticEvaluationResult.getFunctionInfo(FunctionCallPath.EMPTY).setValue(parameter, new AnyValue(new ComputationContext(), typeSpecifier.getType()));
			}
		}
		return true;
	}

	private boolean checkFunctionCheckSignatures(org.eclipse.damos.mscript.Check check) {
		boolean result = checkCheckInputArguments(check);
		
		if (check.getOutputTypeSpecifiers().size() != check.getFunction().getOutputParameterDeclarations().size()) {
			error("Number of output argument types do not correspond to number of output parameters of " + check.getFunction().getName(), check, null, -1);
			result = false;
		}

		return result;
	}
	
	private boolean checkCheckInputArguments(org.eclipse.damos.mscript.Check check) {
		boolean result = true;
		
		Iterator<InputParameterDeclaration> parameterIt = check.getFunction().getInputParameterDeclarations().iterator();
		for (CheckArgument argument : check.getInputArguments()) {
			if (!parameterIt.hasNext()) {
				error("Too many check input arguments specified", argument, null, -1);
				return false;
			}
			InputParameterDeclaration parameter = parameterIt.next();
			if (parameter.isConstant() && argument instanceof TypeCheckArgument) {
				StringBuilder message = new StringBuilder("Check argument must be constant value expression");
				Expression defaultExpression = parameter.getDefaultExpression();
				if (defaultExpression != null) {
					ICompositeNode node = NodeModelUtils.findActualNodeFor(defaultExpression);
					if (node != null) {
						String text = NodeModelUtils.getTokenText(node);
						if (text != null) {
							message.append(", e.g. '<");
							message.append(text);
							message.append(">'");
						}
					}
				}
				error(message.toString(), argument, null, -1);
				result = false;
			}
			if (!parameter.isConstant() && argument instanceof ExpressionCheckArgument) {
				error("Check argument must be type specifier", argument, null, -1);
				result = false;
			}
		}
		
		if (parameterIt.hasNext()) {
			InputParameterDeclaration parameter = parameterIt.next();
			if (!parameter.isConstant() || parameter.getDefaultExpression() == null) {
				error("At least " + MscriptUtil.getMandatoryInputParameterCount(check.getFunction()) + " input arguments required", check, null, -1);
				return false;
			}
		}
		
		return result;
	}
	
	@Check(CheckType.NORMAL)
	public void checkCyclicDataTypeDeclaration(TypeDeclaration typeDeclaration) {
		checkCyclicDataTypeDeclaration(typeDeclaration.getTypeSpecifier(), new HashSet<TypeDeclaration>(Collections.singleton(typeDeclaration)));
	}
	
	private void checkCyclicDataTypeDeclaration(TypeSpecifier typeSpecifier, Set<TypeDeclaration> visitedTypeDeclarations) {
		if (typeSpecifier instanceof AnonymousTypeSpecifier) {
			Type anonymousType = typeSpecifier.getType();
			if (anonymousType != null && !(anonymousType instanceof PrimitiveType)) {
				for (TreeIterator<EObject> it = anonymousType.eAllContents(); it.hasNext();) {
					EObject next = it.next();
					if (next instanceof TypeSpecifier) {
						checkCyclicDataTypeDeclaration((TypeSpecifier) next, new HashSet<TypeDeclaration>(visitedTypeDeclarations));
					}
				}
			}
		} else if (typeSpecifier instanceof DeclaredTypeSpecifier) {
			TypeDeclaration typeDeclaration = ((DeclaredTypeSpecifier) typeSpecifier).getTypeDeclaration();
			if (typeDeclaration != null && !typeDeclaration.eIsProxy()) {
				if (visitedTypeDeclarations.add(typeDeclaration)) {
					checkCyclicDataTypeDeclaration(typeDeclaration.getTypeSpecifier(), new HashSet<TypeDeclaration>(visitedTypeDeclarations));
				} else {
					String message = "Cyclic data type declaration of " + typeDeclaration.getName();
					error(message, typeDeclaration, MscriptPackage.eINSTANCE.getTypeDeclaration_Name(), -1);
					error(message, typeSpecifier, null, -1);
				}
			}
		}
	}
	
	@Check(CheckType.NORMAL)
	public void checkCyclicUnitDeclaration(UnitDeclaration unitDeclaration) {
		checkCyclicUnitDeclaration(unitDeclaration, new HashSet<UnitDeclaration>());
	}
	
	private void checkCyclicUnitDeclaration(UnitDeclaration unitDeclaration, Set<UnitDeclaration> visitedUnitDeclarations) {
		if (visitedUnitDeclarations.add(unitDeclaration)) {
			if (unitDeclaration instanceof DerivedUnitDeclaration) {
				DerivedUnitDeclaration derivedUnitDeclaration = (DerivedUnitDeclaration) unitDeclaration;
				if (derivedUnitDeclaration.getDefinition() != null) {
					for (UnitFactor factor : derivedUnitDeclaration.getDefinition().getFactors()) {
						if (factor.getSymbol() != null && !factor.getSymbol().eIsProxy()) {
							checkCyclicUnitDeclaration(factor.getSymbol().getOwner(), new HashSet<UnitDeclaration>(visitedUnitDeclarations));
						}
					}
				}
			}
		} else {
			error("Cyclic unit declaration of " + unitDeclaration.getName(), unitDeclaration, MscriptPackage.eINSTANCE.getUnitDeclaration_Name(), -1);
		}
	}

	@Check(CheckType.NORMAL)
	public void checkCyclicConstantDeclaration(ConstantDeclaration constantDeclaration) {
		checkCyclicConstantDeclaration(constantDeclaration, new HashSet<ConstantDeclaration>());
	}
	
	private void checkCyclicConstantDeclaration(ConstantDeclaration constantDeclaration, Set<ConstantDeclaration> visitedConstantDeclarations) {
		if (visitedConstantDeclarations.add(constantDeclaration)) {
			for (TreeIterator<EObject> it = constantDeclaration.eAllContents(); it.hasNext();) {
				EObject next = it.next();
				if (next instanceof FeatureReference) {
					FeatureReference featureReference = (FeatureReference) next;
					if (featureReference.getFeature() instanceof ConstantDeclaration) {
						checkCyclicConstantDeclaration((ConstantDeclaration) featureReference.getFeature(), new HashSet<ConstantDeclaration>(visitedConstantDeclarations));
					}
				}
			}
		} else {
			error("Cyclic constant declaration of " + constantDeclaration.getName(), constantDeclaration, constantDeclaration.getNameFeature(), -1);
		}
	}
	
	private boolean isResolved(EObject eObject) {
		return eObject != null && !eObject.eIsProxy();
	}

}
