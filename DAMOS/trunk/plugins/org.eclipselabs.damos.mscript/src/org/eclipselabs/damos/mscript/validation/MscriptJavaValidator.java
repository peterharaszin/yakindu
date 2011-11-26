package org.eclipselabs.damos.mscript.validation;

import java.util.Iterator;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.validation.Check;
import org.eclipselabs.damos.mscript.AdditiveOperator;
import org.eclipselabs.damos.mscript.AdditiveStepExpression;
import org.eclipselabs.damos.mscript.ArrayElementAccess;
import org.eclipselabs.damos.mscript.ArraySubscript;
import org.eclipselabs.damos.mscript.BuiltinFunction;
import org.eclipselabs.damos.mscript.BuiltinVariable;
import org.eclipselabs.damos.mscript.CallableElement;
import org.eclipselabs.damos.mscript.DataTypeSpecifier;
import org.eclipselabs.damos.mscript.EndExpression;
import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.FunctionCall;
import org.eclipselabs.damos.mscript.FunctionDefinition;
import org.eclipselabs.damos.mscript.FunctionKind;
import org.eclipselabs.damos.mscript.FunctionObjectDeclaration;
import org.eclipselabs.damos.mscript.InputParameterDeclaration;
import org.eclipselabs.damos.mscript.MscriptPackage;
import org.eclipselabs.damos.mscript.NegateStepExpression;
import org.eclipselabs.damos.mscript.OutputParameterDeclaration;
import org.eclipselabs.damos.mscript.ParameterDeclaration;
import org.eclipselabs.damos.mscript.StateVariableDeclaration;
import org.eclipselabs.damos.mscript.StepN;
import org.eclipselabs.damos.mscript.TemplateParameterDeclaration;
import org.eclipselabs.damos.mscript.VariableAccess;
import org.eclipselabs.damos.mscript.VariableDeclaration;
import org.eclipselabs.damos.mscript.interpreter.ComputationContext;
import org.eclipselabs.damos.mscript.interpreter.IStaticEvaluationContext;
import org.eclipselabs.damos.mscript.interpreter.StaticEvaluationContext;
import org.eclipselabs.damos.mscript.interpreter.StaticExpressionEvaluator;
import org.eclipselabs.damos.mscript.interpreter.StaticFunctionEvaluator;
import org.eclipselabs.damos.mscript.interpreter.value.AnyValue;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;
import org.eclipselabs.damos.mscript.interpreter.value.InvalidValue;
import org.eclipselabs.damos.mscript.util.SyntaxStatus;

public class MscriptJavaValidator extends AbstractMscriptJavaValidator {

	@Check
	public void checkStatelessFunction(FunctionDefinition functionDefinition) {
		if (functionDefinition.getKind() == FunctionKind.STATELESS) {
			for (StateVariableDeclaration stateVariableDeclaration : functionDefinition.getStateVariableDeclarations()) {
				error("The state variable " + stateVariableDeclaration.getName() + " can only be declared in stateful or continuous functions", stateVariableDeclaration, null, -1);
			}
		}
	}

	@Check
	public void checkFunctionHasChecks(FunctionDefinition functionDefinition) {
		if (functionDefinition.getChecks().isEmpty()) {
			warning("No static checking can be performed for function " + functionDefinition.getName() + " since no checks have been defined", functionDefinition, MscriptPackage.eINSTANCE.getDefinition_Name(), -1);
		}
	}
	
	@Check
	public void checkVariableAccessReferencesVariable(VariableAccess variableAccess) {
		CallableElement ce = variableAccess.getFeature();
		if (!(ce instanceof ParameterDeclaration
				|| ce instanceof VariableDeclaration
				|| ce instanceof BuiltinVariable)) {
			error("Invalid variable reference " + variableAccess.getFeature().getName(), null);
		}
	}

	@Check
	public void checkVariableAccessStepExpressionApplication(VariableAccess variableAccess) {
		if (variableAccess.getStepExpression() != null) {
			CallableElement ce = variableAccess.getFeature();
			if (!(ce instanceof InputParameterDeclaration
					|| ce instanceof OutputParameterDeclaration
					|| ce instanceof StateVariableDeclaration)) {
				error("Step expression cannot be specified on " + variableAccess.getFeature().getName(), null);
			}
		}
	}

	@Check
	public void checkFunctionCallReferencesVariable(FunctionCall variableAccess) {
		CallableElement ce = variableAccess.getFeature();
		if (!(ce instanceof FunctionDefinition
				|| ce instanceof FunctionObjectDeclaration
				|| ce instanceof BuiltinFunction)) {
			error("Invalid function call " + variableAccess.getFeature().getName(), null);
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
		if (additiveStepExpression.getRightOperand() instanceof StepN && additiveStepExpression.getOperator() == AdditiveOperator.SUBTRACT) {
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
	public void checkTypes(FunctionDefinition functionDefinition) {
		StaticExpressionEvaluator staticExpressionEvaluator = new StaticExpressionEvaluator();
		for (org.eclipselabs.damos.mscript.Check check : functionDefinition.getChecks()) {
			if (!checkFunctionCheckSignatures(check)) {
				continue;
			}
				
			IStaticEvaluationContext context = new StaticEvaluationContext();

			Iterator<TemplateParameterDeclaration> templateParameterIt = functionDefinition.getTemplateParameterDeclarations().iterator();
			for (Expression argument : check.getTemplateArguments()) {
				staticExpressionEvaluator.evaluate(context, argument);
				context.setValue(templateParameterIt.next(), context.getValue(argument));
			}
			
			Iterator<InputParameterDeclaration> inputParameterIt = functionDefinition.getInputParameterDeclarations().iterator();
			for (DataTypeSpecifier dataTypeSpecifier : check.getInputParameterTypes()) {
				context.setValue(inputParameterIt.next(), new AnyValue(new ComputationContext(), dataTypeSpecifier.getType()));
			}

			IStatus status = new StaticFunctionEvaluator().evaluate(context, functionDefinition);
			
			if (status.isOK()) {
				Iterator<OutputParameterDeclaration> outputParameterIt = functionDefinition.getOutputParameterDeclarations().iterator();
				for (DataTypeSpecifier dataTypeSpecifier : check.getOutputParameterTypes()) {
					IValue value = context.getValue(outputParameterIt.next());
					if (!(value instanceof InvalidValue) && !dataTypeSpecifier.getType().isEquivalentTo(value.getDataType())) {
						error("Check does not return specified data type", dataTypeSpecifier, null, -1);
					}
				}
			}
			
			SyntaxStatus.addAllSyntaxStatusesToDiagnostics(status, getChain());
		}
		
	}

	private boolean checkFunctionCheckSignatures(org.eclipselabs.damos.mscript.Check check) {
		boolean result = true;
		if (check.getTemplateArguments().size() != check.getFunction().getTemplateParameterDeclarations().size()) {
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
	
}
