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

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.damos.mscript.CompoundStatement;
import org.eclipse.damos.mscript.Expression;
import org.eclipse.damos.mscript.FunctionCall;
import org.eclipse.damos.mscript.FunctionDeclaration;
import org.eclipse.damos.mscript.FunctionKind;
import org.eclipse.damos.mscript.ImplicitVariableDeclaration;
import org.eclipse.damos.mscript.InputParameterDeclaration;
import org.eclipse.damos.mscript.OutputParameterDeclaration;
import org.eclipse.damos.mscript.RealType;
import org.eclipse.damos.mscript.function.ComputationCompound;
import org.eclipse.damos.mscript.function.FunctionInstance;
import org.eclipse.damos.mscript.function.transform.FunctionDefinitionTransformer;
import org.eclipse.damos.mscript.internal.builtin.BuiltinFunctionLookup;
import org.eclipse.damos.mscript.internal.builtin.IBuiltinFunction;
import org.eclipse.damos.mscript.internal.builtin.IBuiltinFunctionLookup;
import org.eclipse.damos.mscript.interpreter.value.IValue;
import org.eclipse.damos.mscript.interpreter.value.InvalidValue;
import org.eclipse.damos.mscript.interpreter.value.Values;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * Stateful interpreter
 * 
 * @author Andreas Unger
 *
 */
public class Interpreter implements IInterpreter, IFunctionInvocationHandler {

	private final FunctionDefinitionTransformer functionDefinitionTransformer = new FunctionDefinitionTransformer();
	private final ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator();
	private final CompoundStatementInterpreter compoundStatementInterpreter = new CompoundStatementInterpreter();
	private final IBuiltinFunctionLookup builtinFunctionLookup = new BuiltinFunctionLookup();

	private final IStaticEvaluationResult staticEvaluationResult;
	private final IComputationContext computationContext;
	
	private final double sampleTime;
	private double time;
	
	private final Map<FunctionCallPath, IFunctionObject> functionObjects = new HashMap<FunctionCallPath, IFunctionObject>();

	public Interpreter(IStaticEvaluationResult staticEvaluationResult, IComputationContext computationContext) {
		this(staticEvaluationResult, computationContext, 0.0);
	}
	
	public Interpreter(IStaticEvaluationResult staticEvaluationResult, IComputationContext computationContext, double sampleTime) {
		this.staticEvaluationResult = staticEvaluationResult;
		this.computationContext = computationContext;
		this.sampleTime = sampleTime;
	}
	
	public IFunctionObject createFunctionObject(IInterpreterContext context) {
		FunctionInstance functionInstance = new FunctionDefinitionTransformer().transform(staticEvaluationResult, staticEvaluationResult.getFunctionInfo(context.getFunctionCallPath()));

		IFunctionObject functionObject = FunctionObject.create(context, functionInstance);
		functionObjects.put(FunctionCallPath.EMPTY, functionObject);

		initializeImplicitVariables(context, functionObject);

		for (IVariable variable : functionObject.getVariables()) {
			context.addVariable(variable);
		}
		
		CompoundStatement initializationCompound = functionObject.getFunctionInstance().getInitializationCompound();
		if (initializationCompound != null) {
			compoundStatementInterpreter.execute(context, initializationCompound);
		}
		
		return functionObject;
	}
	
	public List<IValue> invokeFunction(IExpressionEvaluationContext context, FunctionCall functionCall) {
		IBuiltinFunction function = builtinFunctionLookup.getFunction(functionCall);
		if (function != null) {
			IValue value = function.call(context, functionCall, false);
			return Collections.singletonList(value);
		}

		List<IValue> argumentValues = new ArrayList<IValue>();
		for (Expression argument : functionCall.getArguments()) {
			IValue value = expressionEvaluator.evaluate(context, argument);
			if (value instanceof InvalidValue) {
				return Collections.<IValue>singletonList(InvalidValue.SINGLETON);
			}
			argumentValues.add(value);
		}
	
		FunctionCallPath functionCallPath = context.getFunctionCallPath().append(functionCall);
		
		FunctionInstance functionInstance = functionDefinitionTransformer.transform(staticEvaluationResult, staticEvaluationResult.getFunctionInfo(functionCallPath));
		if (functionInstance == null) {
			throw new NullPointerException();
		}
		
		InterpreterContext interpreterContext = new InterpreterContext(staticEvaluationResult, computationContext, this, functionCallPath);
		IFunctionObject functionObject = getFunctionObject(interpreterContext, functionInstance, argumentValues);
	
		compute(interpreterContext, functionInstance);
		
		OutputParameterDeclaration outputParameterDeclaration = functionObject.getFunctionInstance().getDeclaration().getOutputParameterDeclarations().get(0);
		IValue result = functionObject.getVariable(outputParameterDeclaration).getValue(0);
		
		return Collections.singletonList(result);
	}
	
	public void compute(IInterpreterContext context) {
		FunctionInstance functionInstance = functionObjects.get(context.getFunctionCallPath()).getFunctionInstance();
		compute(context, functionInstance);
	}

	/**
	 * @param context
	 * @param functionInstance
	 */
	private void compute(IInterpreterContext context, FunctionInstance functionInstance) {
		for (ComputationCompound compound : functionInstance.getComputationCompounds()) {
			if (compound.getDerivatives().isEmpty() && !compound.getOutputs().isEmpty()) {
				compoundStatementInterpreter.execute(context, compound);
			}
		}
	}

	public void update() {
		for (Entry<FunctionCallPath, IFunctionObject> entry : functionObjects.entrySet()) {
			FunctionCallPath functionCallPath = entry.getKey();
			IFunctionObject functionObject = entry.getValue();
			
			InterpreterContext context = new InterpreterContext(staticEvaluationResult, computationContext, this, functionCallPath);
	
			updateImplicitVariables(context, functionObject);
			
			for (IVariable variable : functionObject.getVariables()) {
				context.addVariable(variable);
			}
			
			for (ComputationCompound compound : functionObject.getFunctionInstance().getComputationCompounds()) {
				if (compound.getDerivatives().isEmpty() && compound.getOutputs().isEmpty()) {
					compoundStatementInterpreter.execute(context, compound);
				}
			}
			
			for (IVariable variable : functionObject.getVariables()) {
				variable.incrementStepIndex();
			}
		}
	}

	public void updateTime(double time) {
		this.time = time;
	}

	private IFunctionObject getFunctionObject(IInterpreterContext context, FunctionInstance functionInstance, List<IValue> argumentValues) {
		boolean initialize = false;
		
		IFunctionObject functionObject = functionObjects.get(context.getFunctionCallPath());
		if (functionObject == null) {
			functionObject = FunctionObject.create(context, functionInstance);
			initializeImplicitVariables(context, functionObject);
			functionObjects.put(context.getFunctionCallPath(), functionObject);
			initialize = true;
		}

		for (IVariable variable : functionObject.getVariables()) {
			context.addVariable(variable);
		}
		
		Iterator<InputParameterDeclaration> inputParameterDeclarations = functionObject.getFunctionInstance().getDeclaration().getInputParameterDeclarations().iterator();
		for (IValue argumentValue : argumentValues) {
			functionObject.getVariable(inputParameterDeclarations.next()).setValue(0, argumentValue);
		}
		// TODO: Set default values, if inputParameterDeclarations.hasNext() == true

		updateImplicitVariables(context, functionObject);
		
		if (initialize) {
			CompoundStatement compoundStatement = functionInstance.getInitializationCompound();
			if (compoundStatement != null) {
				compoundStatementInterpreter.execute(context, compoundStatement);
			}
		}
		
		return functionObject;
	}
	
	private void initializeImplicitVariables(IInterpreterContext context, IFunctionObject functionObject) {
		FunctionDeclaration functionDeclaration = functionObject.getFunctionInstance().getDeclaration();

		if (functionDeclaration.getKind() == FunctionKind.SYNCHRONOUS) {
			{
				ImplicitVariableDeclaration variableDeclaration = functionDeclaration.getImplicitVariableDeclaration("Ts");
				if (variableDeclaration != null) {
					IValue value = staticEvaluationResult.getFunctionInfo(context.getFunctionCallPath()).getValue(variableDeclaration);
					if (value != null) {
						RealType dataType = EcoreUtil.copy((RealType) value.getDataType());
						IVariable variable = new Variable(context, variableDeclaration);
						variable.setValue(0, Values.valueOf(computationContext, dataType, sampleTime));
						functionObject.addVariable(variable);
					}
				}
			}
	
			{
				ImplicitVariableDeclaration variableDeclaration = functionDeclaration.getImplicitVariableDeclaration("fs");
				if (variableDeclaration != null) {
					IValue value = staticEvaluationResult.getFunctionInfo(context.getFunctionCallPath()).getValue(variableDeclaration);
					if (value != null) {
						RealType dataType = EcoreUtil.copy((RealType) value.getDataType());
						IVariable variable = new Variable(context, variableDeclaration);
						variable.setValue(0, Values.valueOf(computationContext, dataType, 1.0 / sampleTime));
						functionObject.addVariable(variable);
					}
				}
			}
		}
		
		// TODO: set time variable
		if (functionDeclaration.getKind() == FunctionKind.CONTINUOUS) {
			ImplicitVariableDeclaration variableDeclaration = functionDeclaration.getImplicitVariableDeclaration("t");
			if (variableDeclaration != null) {
				IValue value = staticEvaluationResult.getFunctionInfo(FunctionCallPath.EMPTY).getValue(variableDeclaration);
				if (value != null) {
					RealType timeVariableType = EcoreUtil.copy((RealType) value.getDataType());
					IVariable timeVariable = new Variable(context, variableDeclaration);
					timeVariable.setValue(0, Values.valueOf(context.getComputationContext(), timeVariableType, 0.0));
					functionObject.addVariable(timeVariable);
				}
			}
		}
	}

	protected void updateImplicitVariables(IInterpreterContext context, IFunctionObject functionObject) {
		FunctionDeclaration functionDeclaration = functionObject.getFunctionInstance().getDeclaration();
		if (functionDeclaration.getKind() == FunctionKind.CONTINUOUS) {
			ImplicitVariableDeclaration variableDeclaration = functionDeclaration.getImplicitVariableDeclaration("t");
			if (variableDeclaration != null) {
				IVariable variable = functionObject.getVariable(variableDeclaration);
				RealType dataType = (RealType) variable.getValue(0).getDataType();
				variable.setValue(0, Values.valueOf(context.getComputationContext(), dataType, time));
			}
		}
	}
	
}
