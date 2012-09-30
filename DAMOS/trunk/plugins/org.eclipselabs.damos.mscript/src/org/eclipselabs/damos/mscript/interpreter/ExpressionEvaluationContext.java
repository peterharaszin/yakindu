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

package org.eclipselabs.damos.mscript.interpreter;

import org.eclipselabs.damos.mscript.Evaluable;
import org.eclipselabs.damos.mscript.FeatureReference;
import org.eclipselabs.damos.mscript.VariableDeclaration;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;
import org.eclipselabs.damos.mscript.interpreter.value.InvalidValue;

/**
 * @author Andreas Unger
 *
 */
public class ExpressionEvaluationContext extends AbstractExpressionEvaluationContext {

	private final IInterpreterContext interpreterContext;
	
	public ExpressionEvaluationContext(IInterpreterContext interpreterContext) {
		this.interpreterContext = interpreterContext;
	}
	
	/**
	 * @return the interpreterContext
	 */
	public IInterpreterContext getInterpreterContext() {
		return interpreterContext;
	}
	
	public IComputationContext getComputationContext() {
		return interpreterContext.getComputationContext();
	}
	
	public FunctionCallPath getFunctionCallPath() {
		return interpreterContext.getFunctionCallPath();
	}
	
	public void enterVariableScope() {
		interpreterContext.enterVariableScope();
	}
	
	public void leaveVariableScope() {
		interpreterContext.leaveVariableScope();
	}
	
	public void addVariable(IVariable variable) {
		interpreterContext.addVariable(variable);
	}
	
	public IValue getValue(Evaluable evaluable) {
		if (evaluable instanceof FeatureReference) {
			FeatureReference variableReference = (FeatureReference) evaluable;
			if (!(variableReference.getFeature() instanceof VariableDeclaration)) {
				return InvalidValue.SINGLETON;
			}
			VariableDeclaration variableDeclaration = (VariableDeclaration) variableReference.getFeature();
			IVariable variable = interpreterContext.getVariable(variableDeclaration);
			if (variable != null) {
				int stepIndex = interpreterContext.getStaticEvaluationResult().getFunctionInfo(interpreterContext.getFunctionCallPath()).getStepIndex(variableReference);
				IValue result = variable.getValue(stepIndex);
				if (result == null) {
					return InvalidValue.SINGLETON;
				}
				return result;
			}
		}
		return interpreterContext.getStaticEvaluationResult().getFunctionInfo(interpreterContext.getFunctionCallPath()).getValue(evaluable);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.interpreter.IExpressionEvaluationContext#getFunctionInvocationHandler()
	 */
	public IFunctionInvocationHandler getFunctionInvocationHandler() {
		return interpreterContext.getFunctionInvocationHandler();
	}
	
}
