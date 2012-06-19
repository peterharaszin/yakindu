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
import org.eclipselabs.damos.mscript.VariableDeclaration;
import org.eclipselabs.damos.mscript.VariableReference;
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
	
	public IComputationContext getComputationContext() {
		return interpreterContext.getComputationContext();
	}
	
	public IValue getValue(Evaluable evaluable) {
		if (evaluable instanceof VariableReference) {
			VariableReference variableReference = (VariableReference) evaluable;
			if (!(variableReference.getFeature() instanceof VariableDeclaration)) {
				return InvalidValue.SINGLETON;
			}
			VariableDeclaration variableDeclaration = (VariableDeclaration) variableReference.getFeature();
			IVariable variable = interpreterContext.getVariable(variableDeclaration);
			int stepIndex = interpreterContext.getStaticEvaluationResult().getStepIndex(variableReference);
			IValue result = variable.getValue(stepIndex);
			if (result == null) {
				return InvalidValue.SINGLETON;
			}
			return result;
		}
		return interpreterContext.getStaticEvaluationResult().getValue(evaluable);
	}
	
}
