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

import org.eclipse.damos.mscript.VariableDeclaration;

/**
 * @author Andreas Unger
 *
 */
public class InterpreterContext implements IInterpreterContext {

	private IStaticEvaluationResult staticEvaluationResult;
	private IComputationContext computationContext;

	private FunctionCallPath functionCallPath;
	private VariableScope scope = new VariableScope(null);

	private final IFunctionInvocationHandler functionInvocationHandler;
		
	public InterpreterContext(IStaticEvaluationResult staticEvaluationResult, IComputationContext computationContext, IFunctionInvocationHandler functionInvocationHandler) {
		this(staticEvaluationResult, computationContext, functionInvocationHandler, FunctionCallPath.EMPTY);
	}

	public InterpreterContext(IStaticEvaluationResult staticEvaluationResult, IComputationContext computationContext, IFunctionInvocationHandler functionInvocationHandler, FunctionCallPath functionCallPath) {
		this.staticEvaluationResult = staticEvaluationResult;
		this.computationContext = computationContext;
		this.functionInvocationHandler = functionInvocationHandler;
		this.functionCallPath = functionCallPath;
	}

	/**
	 * @return the staticEvaluationResult
	 */
	public IStaticEvaluationResult getStaticEvaluationResult() {
		return staticEvaluationResult;
	}
	
	/**
	 * @return the computationContext
	 */
	public IComputationContext getComputationContext() {
		return computationContext;
	}
	
	/**
	 * @return the functionCallPath
	 */
	public FunctionCallPath getFunctionCallPath() {
		return functionCallPath;
	}
	
	public void enterVariableScope() {
		scope = new VariableScope(scope);
	}
	
	public void leaveVariableScope() {
		scope = scope.getOuterScope();
	}
	
	public IVariable getVariable(VariableDeclaration variableDeclaration) {
		return scope.findInEnclosingScopes(variableDeclaration);
	}
	
	public void addVariable(IVariable variable) {
		scope.add(variable);
	}
	
	public IFunctionInvocationHandler getFunctionInvocationHandler() {
		return functionInvocationHandler;
	}
	
}
