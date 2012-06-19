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
import org.eclipselabs.damos.mscript.VariableReference;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;

/**
 * @author Andreas Unger
 *
 */
public class StaticExpressionEvaluationContext extends AbstractExpressionEvaluationContext {

	private final IStaticEvaluationResult staticEvaluationResult;
	
	public StaticExpressionEvaluationContext(IStaticEvaluationResult staticEvaluationResult) {
		this.staticEvaluationResult = staticEvaluationResult;
	}
	
	public IComputationContext getComputationContext() {
		return staticEvaluationResult.getComputationContext();
	}
	
	public IValue getValue(Evaluable evaluable) {
		if (evaluable instanceof VariableReference) {
			return staticEvaluationResult.getValue(((VariableReference) evaluable).getFeature());
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
