package org.eclipselabs.damos.mscript.validation;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.validation.Check;
import org.eclipselabs.damos.mscript.AdditiveStepExpression;
import org.eclipselabs.damos.mscript.AlgorithmExpression;
import org.eclipselabs.damos.mscript.AnonymousTypeSpecifier;
import org.eclipselabs.damos.mscript.ArrayElementAccess;
import org.eclipselabs.damos.mscript.ArraySubscript;
import org.eclipselabs.damos.mscript.BuiltinFunctionDeclaration;
import org.eclipselabs.damos.mscript.BuiltinVariableDeclaration;
import org.eclipselabs.damos.mscript.CallableElement;
import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.DataTypeDeclaration;
import org.eclipselabs.damos.mscript.DataTypeSpecifier;
import org.eclipselabs.damos.mscript.DeclaredTypeSpecifier;
import org.eclipselabs.damos.mscript.EndExpression;
import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.FunctionAliasDeclaration;
import org.eclipselabs.damos.mscript.FunctionCall;
import org.eclipselabs.damos.mscript.FunctionDeclaration;
import org.eclipselabs.damos.mscript.FunctionKind;
import org.eclipselabs.damos.mscript.IfExpression;
import org.eclipselabs.damos.mscript.ImpliesExpression;
import org.eclipselabs.damos.mscript.InputParameterDeclaration;
import org.eclipselabs.damos.mscript.IterationCall;
import org.eclipselabs.damos.mscript.LogicalAndExpression;
import org.eclipselabs.damos.mscript.LogicalOrExpression;
import org.eclipselabs.damos.mscript.MscriptPackage;
import org.eclipselabs.damos.mscript.NegateStepExpression;
import org.eclipselabs.damos.mscript.OperatorKind;
import org.eclipselabs.damos.mscript.OutputParameterDeclaration;
import org.eclipselabs.damos.mscript.ParameterDeclaration;
import org.eclipselabs.damos.mscript.PrimitiveType;
import org.eclipselabs.damos.mscript.StateVariableDeclaration;
import org.eclipselabs.damos.mscript.StepN;
import org.eclipselabs.damos.mscript.SwitchCase;
import org.eclipselabs.damos.mscript.SwitchExpression;
import org.eclipselabs.damos.mscript.StaticParameterDeclaration;
import org.eclipselabs.damos.mscript.VariableDeclaration;
import org.eclipselabs.damos.mscript.VariableReference;
import org.eclipselabs.damos.mscript.interpreter.ComputationContext;
import org.eclipselabs.damos.mscript.interpreter.ExpressionEvaluator;
import org.eclipselabs.damos.mscript.interpreter.IExpressionEvaluator;
import org.eclipselabs.damos.mscript.interpreter.IStaticEvaluationResult;
import org.eclipselabs.damos.mscript.interpreter.StaticEvaluationResult;
import org.eclipselabs.damos.mscript.interpreter.StaticExpressionEvaluationContext;
import org.eclipselabs.damos.mscript.interpreter.StaticFunctionEvaluator;
import org.eclipselabs.damos.mscript.interpreter.value.AnyValue;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;
import org.eclipselabs.damos.mscript.interpreter.value.InvalidValue;
import org.eclipselabs.damos.mscript.util.SyntaxStatus;

public class MscriptJavaValidator extends AbstractMscriptJavaValidator {
	
	private final IExpressionEvaluator expressionEvaluator = new ExpressionEvaluator();

	@Check
	public void checkStatelessFunction(FunctionDeclaration functionDeclaration) {
		if (functionDeclaration.getKind() == FunctionKind.STATELESS) {
			for (StateVariableDeclaration stateVariableDeclaration : functionDeclaration.getStateVariableDeclarations()) {
				error("The state variable " + stateVariableDeclaration.getName() + " can only be declared in stateful or continuous functions", stateVariableDeclaration, null, -1);
			}
		}
	}

	@Check
	public void checkFunctionHasChecks(FunctionDeclaration functionDeclaration) {
		if (functionDeclaration.getChecks().isEmpty()) {
			warning("No static checking can be performed for function " + functionDeclaration.getName() + " since no checks have been defined", functionDeclaration, MscriptPackage.eINSTANCE.getDeclaration_Name(), -1);
		}
	}
	
	@Check
	public void checkVariableReferenceReferencesVariable(VariableReference variableReference) {
		if (variableReference.getFeature() == null || variableReference.getFeature().eIsProxy()) {
			return;
		}
		CallableElement ce = variableReference.getFeature();
		if (!(ce instanceof ParameterDeclaration
				|| ce instanceof VariableDeclaration
				|| ce instanceof BuiltinVariableDeclaration)) {
			error("Invalid variable reference " + variableReference.getFeature().getName(), null);
		}
	}

	@Check
	public void checkVariableAccessStepExpressionApplication(VariableReference variableReference) {
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
				|| ce instanceof FunctionAliasDeclaration
				|| ce instanceof BuiltinFunctionDeclaration)) {
			error("Invalid function call " + functionCall.getFeature().getName(), null);
		}
	}
	
	@Check
	public void checkStatefulFunctionEnclosingExpression(FunctionCall functionCall) {
		if (functionCall.getFeature() instanceof FunctionDeclaration) {
			FunctionDeclaration functionDeclaration = (FunctionDeclaration) functionCall.getFeature();
			if (functionDeclaration.getKind() == FunctionKind.STATEFUL) {
				EObject element = functionCall;
				EObject container = element.eContainer();
				while (container instanceof Expression) {
					if (container instanceof AlgorithmExpression) {
						error("Stateful function calls must not be contained within algorithm expressions", null);
						break;
					}
					if (container instanceof IfExpression) {
						IfExpression ifExpression = (IfExpression) container;
						if (!ifExpression.isStatic() && (ifExpression.getThenExpression() == element || ifExpression.getElseExpression() == element)) {
							error("Stateful function calls must not be contained within non-static if-then or if-else expression", null);
							break;
						}
					}
					if (container instanceof SwitchExpression) {
						SwitchExpression switchExpression = (SwitchExpression) container;
						if (!switchExpression.isStatic() && switchExpression.getDefaultExpression() == element) {
							error("Stateful function calls must not be contained within non-static switch default expression", null);
							break;
						}
					}
					if (container instanceof SwitchCase) {
						SwitchCase switchCase = (SwitchCase) container;
						if (!switchCase.getOwner().isStatic() && (switchCase.getCaseExpression() == element || switchCase.getResultExpression() == element)) {
							error("Stateful function calls must not be contained within non-static switch case expression", null);
							break;
						}
					}
					if (container instanceof IterationCall) {
						IterationCall iterationCall = (IterationCall) container;
						if (iterationCall.getBreakCondition() == element) {
							error("Stateful function calls must not be contained within iteration call break condition", null);
							break;
						}
						if (iterationCall.getExpression() == element) {
							error("Stateful function calls must not be contained within iteration call expression", null);
							break;
						}
					}
					if (container instanceof LogicalAndExpression) {
						error("Stateful function calls must not be contained within AND expression", null);
						break;
					}
					if (container instanceof LogicalOrExpression) {
						error("Stateful function calls must not be contained within OR expression", null);
						break;
					}
					if (container instanceof ImpliesExpression) {
						error("Stateful function calls must not be contained within implies expression", null);
						break;
					}
					element = container;
					container = element.eContainer();
				}
			}
		}
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
		for (org.eclipselabs.damos.mscript.Check check : functionDeclaration.getChecks()) {
			if (!checkFunctionCheckSignatures(check)) {
				continue;
			}
				
			IStaticEvaluationResult staticEvaluationResult = new StaticEvaluationResult();

			Iterator<StaticParameterDeclaration> staticParameterIt = functionDeclaration.getStaticParameterDeclarations().iterator();
			for (Expression argument : check.getStaticArguments()) {
				expressionEvaluator.evaluate(new StaticExpressionEvaluationContext(staticEvaluationResult), argument);
				staticEvaluationResult.setValue(staticParameterIt.next(), staticEvaluationResult.getValue(argument));
			}
			
			Iterator<InputParameterDeclaration> inputParameterIt = functionDeclaration.getInputParameterDeclarations().iterator();
			for (DataTypeSpecifier dataTypeSpecifier : check.getInputParameterTypes()) {
				staticEvaluationResult.setValue(inputParameterIt.next(), new AnyValue(new ComputationContext(), dataTypeSpecifier.getType()));
			}

			new StaticFunctionEvaluator().evaluate(staticEvaluationResult, functionDeclaration);
			
			if (staticEvaluationResult.getStatus().getSeverity() < IStatus.ERROR) {
				Iterator<OutputParameterDeclaration> outputParameterIt = functionDeclaration.getOutputParameterDeclarations().iterator();
				for (DataTypeSpecifier dataTypeSpecifier : check.getOutputParameterTypes()) {
					IValue value = staticEvaluationResult.getValue(outputParameterIt.next());
					if (value != null && !(value instanceof InvalidValue) && !dataTypeSpecifier.getType().isEquivalentTo(value.getDataType())) {
						error("Check does not return specified data type", dataTypeSpecifier, null, -1);
					}
				}
			}
			
			SyntaxStatus.addAllSyntaxStatusesToDiagnostics(staticEvaluationResult.getStatus(), getChain());
		}
		
	}

	private boolean checkFunctionCheckSignatures(org.eclipselabs.damos.mscript.Check check) {
		boolean result = true;
		if (check.getStaticArguments().size() != check.getFunction().getStaticParameterDeclarations().size()) {
			error("Number of template arguments do not correspond to number of template parameters of function " + check.getFunction().getName(), check, null, -1);
			result = false;
		}
		if (check.getInputParameterTypes().size() != check.getFunction().getInputParameterDeclarations().size()) {
			error("Number of input argument types do not correspond to number of input parameters of function " + check.getFunction().getName(), check, null, -1);
			result = false;
		}
		if (check.getOutputParameterTypes().size() != check.getFunction().getOutputParameterDeclarations().size()) {
			error("Number of output argument types do not correspond to number of output parameters of function " + check.getFunction().getName(), check, null, -1);
			result = false;
		}
		return result;
	}
	
	@Check
	public void checkCyclicDataTypeDeclaration(DataTypeDeclaration typeDeclaration) {
		checkCyclicDataTypeDeclaration(typeDeclaration.getTypeSpecifier(), new HashSet<DataTypeDeclaration>(Collections.singleton(typeDeclaration)));
	}
	
	private void checkCyclicDataTypeDeclaration(DataTypeSpecifier dataTypeSpecifier, Set<DataTypeDeclaration> visitedTypeDeclarations) {
		if (dataTypeSpecifier instanceof AnonymousTypeSpecifier) {
			DataType anonymousType = dataTypeSpecifier.getType();
			if (anonymousType != null && !(anonymousType instanceof PrimitiveType)) {
				for (TreeIterator<EObject> it = anonymousType.eAllContents(); it.hasNext();) {
					EObject next = it.next();
					if (next instanceof DataTypeSpecifier) {
						checkCyclicDataTypeDeclaration((DataTypeSpecifier) next, new HashSet<DataTypeDeclaration>(visitedTypeDeclarations));
					}
				}
			}
		} else if (dataTypeSpecifier instanceof DeclaredTypeSpecifier) {
			DataTypeDeclaration typeDeclaration = ((DeclaredTypeSpecifier) dataTypeSpecifier).getTypeDeclaration();
			if (typeDeclaration != null && !typeDeclaration.eIsProxy()) {
				if (visitedTypeDeclarations.add(typeDeclaration)) {
					checkCyclicDataTypeDeclaration(typeDeclaration.getTypeSpecifier(), new HashSet<DataTypeDeclaration>(visitedTypeDeclarations));
				} else {
					String message = "Cyclic data type declaration of " + typeDeclaration.getName();
					error(message, typeDeclaration, MscriptPackage.eINSTANCE.getDeclaration_Name(), -1);
					error(message, dataTypeSpecifier, null, -1);
				}
			}
		}
	}
	
}
