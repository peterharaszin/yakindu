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

package org.eclipselabs.damos.mscript.interpreter;

import org.eclipselabs.damos.mscript.VariableDeclaration;



/**
 * @author Andreas Unger
 *
 */
public class InterpreterContext implements IInterpreterContext {

	private IStaticEvaluationResult staticEvaluationResult;
	private IComputationContext computationContext;

	private VariableScope scope = new VariableScope(null);

	private volatile boolean canceled;
		
	/**
	 * 
	 */
	public InterpreterContext(IStaticEvaluationResult staticEvaluationResult, IComputationContext computationContext) {
		this.staticEvaluationResult = staticEvaluationResult;
		this.computationContext = computationContext;
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
	
	public boolean isCanceled() {
		return canceled;
	}
	
	public void setCanceled(boolean canceled) {
		this.canceled = canceled;
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
	
}
