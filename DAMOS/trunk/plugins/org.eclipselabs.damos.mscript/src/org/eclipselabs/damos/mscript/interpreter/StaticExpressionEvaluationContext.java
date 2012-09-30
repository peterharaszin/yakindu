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

import org.eclipselabs.damos.mscript.CallableElement;
import org.eclipselabs.damos.mscript.Evaluable;
import org.eclipselabs.damos.mscript.FeatureReference;
import org.eclipselabs.damos.mscript.VariableDeclaration;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;

/**
 * @author Andreas Unger
 *
 */
public class StaticExpressionEvaluationContext extends AbstractExpressionEvaluationContext {

	private final IStaticEvaluationContext context;
	
	private final IFunctionInvocationHandler functionInvocationHandler;
	
	private VariableScope scope = new VariableScope(null);
	
	public StaticExpressionEvaluationContext(IStaticEvaluationContext context) {
		this(context, null);
	}

	public StaticExpressionEvaluationContext(IStaticEvaluationContext context, IFunctionInvocationHandler functionInvocationHandler) {
		this.context = context;
		this.functionInvocationHandler = functionInvocationHandler;
	}
	
	public IComputationContext getComputationContext() {
		return context.getResult().getComputationContext();
	}
	
	public FunctionCallPath getFunctionCallPath() {
		return context.getFunctionCallPath();
	}
	
	public void enterVariableScope() {
		scope = new VariableScope(scope);
	}
	
	public void leaveVariableScope() {
		scope = scope.getOuterScope();
	}
	
	public void addVariable(IVariable variable) {
		scope.add(variable);
	}
	
	public IValue getValue(Evaluable evaluable) {
		if (evaluable instanceof FeatureReference) {
			CallableElement feature = ((FeatureReference) evaluable).getFeature();
			if (feature instanceof VariableDeclaration) {
				IVariable variable = scope.findInEnclosingScopes((VariableDeclaration) feature);
				if (variable != null) {
					return variable.getValue(0);
				}
			}
			return getFunctionInfo().getValue(feature);
		}
		return getFunctionInfo().getValue(evaluable);
	}

	public void processValue(Evaluable evaluable, IValue value) {
		getFunctionInfo().setValue(evaluable, value);
	}

	public IStatusCollector getStatusCollector() {
		return context.getResult();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.interpreter.IExpressionEvaluationContext#getFunctionInvocationHandler()
	 */
	public IFunctionInvocationHandler getFunctionInvocationHandler() {
		return functionInvocationHandler;
	}

	private StaticFunctionInfo getFunctionInfo() {
		return context.getResult().getFunctionInfo(context.getFunctionCallPath());
	}
	
}
