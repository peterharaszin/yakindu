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
import org.eclipselabs.damos.mscript.VariableDeclaration;
import org.eclipselabs.damos.mscript.VariableReference;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;

/**
 * @author Andreas Unger
 *
 */
public class StaticExpressionEvaluationContext extends AbstractExpressionEvaluationContext {

	private final IStaticEvaluationResult staticEvaluationResult;
	
	private VariableScope scope = new VariableScope(null);
	
	public StaticExpressionEvaluationContext(IStaticEvaluationResult staticEvaluationResult) {
		this.staticEvaluationResult = staticEvaluationResult;
	}
	
	public IComputationContext getComputationContext() {
		return staticEvaluationResult.getComputationContext();
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
		if (evaluable instanceof VariableReference) {
			CallableElement feature = ((VariableReference) evaluable).getFeature();
			if (feature instanceof VariableDeclaration) {
				IVariable variable = scope.findInEnclosingScopes((VariableDeclaration) feature);
				if (variable != null) {
					return variable.getValue(0);
				}
			}
			return staticEvaluationResult.getValue(feature);
		}
		return staticEvaluationResult.getValue(evaluable);
	}
	
	public void processValue(Evaluable evaluable, IValue value) {
		staticEvaluationResult.setValue(evaluable, value);
	}

	public IStatusCollector getStatusCollector() {
		return staticEvaluationResult;
	}

}
