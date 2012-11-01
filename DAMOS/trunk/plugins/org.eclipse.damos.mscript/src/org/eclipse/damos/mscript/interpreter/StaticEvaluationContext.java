/****************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipse.damos.mscript.interpreter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.damos.mscript.Expression;
import org.eclipse.damos.mscript.FunctionCall;
import org.eclipse.damos.mscript.FunctionDeclaration;
import org.eclipse.damos.mscript.FunctionKind;
import org.eclipse.damos.mscript.InputParameterDeclaration;
import org.eclipse.damos.mscript.builtin.BuiltinFunctionLookup;
import org.eclipse.damos.mscript.builtin.IBuiltinFunction;
import org.eclipse.damos.mscript.builtin.IBuiltinFunctionLookup;
import org.eclipse.damos.mscript.internal.MscriptPlugin;
import org.eclipse.damos.mscript.interpreter.value.AnyValue;
import org.eclipse.damos.mscript.interpreter.value.IValue;
import org.eclipse.damos.mscript.interpreter.value.InvalidValue;
import org.eclipse.damos.mscript.util.SyntaxStatus;

/**
 * @author Andreas Unger
 *
 */
public class StaticEvaluationContext implements IStaticEvaluationContext {

	private final StaticFunctionEvaluator staticFunctionEvaluator = new StaticFunctionEvaluator();
	private final ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator();
	private final IBuiltinFunctionLookup builtinFunctionLookup = new BuiltinFunctionLookup();
	
	private final IStaticEvaluationResult result;
	private final Map<FunctionSignature, StaticFunctionInfo> functionInfos = new HashMap<FunctionSignature, StaticFunctionInfo>();
	
	private FunctionCallPath functionCallPath = FunctionCallPath.EMPTY;
	
	/**
	 * 
	 */
	public StaticEvaluationContext(IStaticEvaluationResult result) {
		this.result = result;
	}
	
	public IStaticEvaluationResult getResult() {
		return result;
	}
	
	/**
	 * @return the functionCallPath
	 */
	public FunctionCallPath getFunctionCallPath() {
		return functionCallPath;
	}

	public List<IValue> invokeFunction(IExpressionEvaluationContext context, FunctionCall functionCall) {
		IBuiltinFunction function = builtinFunctionLookup.getFunction(functionCall);
		if (function != null) {
			IValue value = function.call(context, functionCall, true);
			if (value instanceof InvalidValue) {
				return Collections.<IValue>singletonList(InvalidValue.SINGLETON);
			}
			if (value instanceof AnyValue) {
				Interpreter interpreter = new Interpreter(result, result.getComputationContext());
				IInterpreterContext interpreterContext = new InterpreterContext(result, result.getComputationContext(), interpreter, functionCallPath);
				return interpreter.invokeFunction(new ExpressionEvaluationContext(interpreterContext), functionCall);
			}
			return Collections.singletonList(value);
		}
		
		boolean anyValue = false;
		boolean invalidValue = false;
		for (Expression argument : functionCall.getArguments()) {
			IValue value = expressionEvaluator.evaluate(context, argument);
			if (value instanceof InvalidValue) {
				invalidValue = true;
			}
			if (value instanceof AnyValue) {
				anyValue = true;
			}
		}
		if (invalidValue) {
			return Collections.<IValue>singletonList(InvalidValue.SINGLETON);
		}

		if (functionCallPath.contains(functionCall)) {
			result.collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Recursive function calls not permitted", functionCall));
			return Collections.<IValue>singletonList(InvalidValue.SINGLETON);
		}

		FunctionDeclaration functionDeclaration = (FunctionDeclaration) functionCall.getFeature();

		List<FunctionParameter> parameters = new ArrayList<FunctionParameter>();
		
		{
			Iterator<InputParameterDeclaration> it = functionDeclaration.getInputParameterDeclarations().iterator();
			for (Expression argument : functionCall.getArguments()) {
				if (!it.hasNext()) {
					result.collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Too many arguments specified", argument));
					return Collections.<IValue>singletonList(InvalidValue.SINGLETON);
				}
	
				IValue value = result.getFunctionInfo(functionCallPath).getValue(argument);
				InputParameterDeclaration next = it.next();
				if (next.isConstant()) {
					if (value instanceof AnyValue) {
						result.collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Argument must be static expression", argument));
						return Collections.<IValue>singletonList(InvalidValue.SINGLETON);
					}
					parameters.add(FunctionParameter.create(value));
				} else {
					parameters.add(FunctionParameter.create(value.getDataType()));
				}
			}
			
			while (it.hasNext()) {
				InputParameterDeclaration next = it.next();
				if (!next.isConstant() || next.getDefaultExpression() == null) {
					result.collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Too few arguments specified", functionCall));
					return Collections.<IValue>singletonList(InvalidValue.SINGLETON);
				}
				StaticExpressionEvaluationContext expressionEvaluationContext = new StaticExpressionEvaluationContext(this);
				IValue defaultValue = expressionEvaluator.evaluate(expressionEvaluationContext, next.getDefaultExpression());
				if (defaultValue instanceof InvalidValue) {
					return Collections.<IValue>singletonList(InvalidValue.SINGLETON);
				}
				if (defaultValue instanceof AnyValue) {
					result.collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Default input parameter expression must be static expression", functionCall));
					return Collections.<IValue>singletonList(InvalidValue.SINGLETON);
				}
				parameters.add(FunctionParameter.create(defaultValue));
			}
		}
		
		FunctionSignature functionSignature = FunctionSignature.create(functionDeclaration, parameters);
		
		FunctionCallPath previousFunctionCallPath = functionCallPath;
		functionCallPath = functionCallPath.append(functionCall);
		StaticFunctionInfo functionInfo = functionInfos.get(functionSignature);
		if (functionInfo != null) {
			result.setFunctionInfo(functionCallPath, functionInfo);
		} else {
			functionInfo = new StaticFunctionInfo(null);
			result.setFunctionInfo(functionCallPath, functionInfo);
			Iterator<InputParameterDeclaration> it = functionDeclaration.getInputParameterDeclarations().iterator();
			for (FunctionParameter parameter : parameters) {
				if (parameter instanceof TypeFunctionParameter) {
					functionInfo.setValue(it.next(), new AnyValue(result.getComputationContext(), ((TypeFunctionParameter) parameter).getType()));
				} else if (parameter instanceof ValueFunctionParameter) {
					functionInfo.setValue(it.next(), ((ValueFunctionParameter) parameter).getValue());
				}
			}
			staticFunctionEvaluator.evaluate(this, functionDeclaration);
			functionInfos.put(functionSignature, functionInfo);
		}
		
		functionCallPath = previousFunctionCallPath;

		result.getFunctionInfo(functionCallPath).addCallee(functionCall, functionInfo);

		IValue returnValue;

		// Try to really execute the function
		if (!anyValue && functionDeclaration.getKind() == FunctionKind.STANDARD && !functionInfo.getFunctionDescription().isStateful()) {
			Interpreter interpreter = new Interpreter(result, result.getComputationContext());
			IInterpreterContext interpreterContext = new InterpreterContext(result, result.getComputationContext(), interpreter, previousFunctionCallPath);
			returnValue = interpreter.invokeFunction(new ExpressionEvaluationContext(interpreterContext), functionCall).get(0);
		} else {
			returnValue = functionInfo.getValue(functionDeclaration.getOutputParameterDeclarations().get(0));
		}
		
		if (returnValue == null) {
			result.collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Invoking function '" + functionDeclaration.getName() + "' failed", functionCall));
			return Collections.<IValue>singletonList(InvalidValue.SINGLETON);
		}
		
		return Collections.singletonList(returnValue);
	}

}
