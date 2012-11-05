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

import java.util.HashSet;
import java.util.Set;

import org.eclipse.damos.mscript.Evaluable;
import org.eclipse.damos.mscript.interpreter.value.IValue;

/**
 * @author Andreas Unger
 *
 */
public abstract class AbstractExpressionEvaluationContext implements IExpressionEvaluationContext {

	private int staticScopeCounter;
	
	private Set<Evaluable> visitedEvaluables = new HashSet<Evaluable>(); 

	/**
	 * 
	 */
	public AbstractExpressionEvaluationContext() {
		super();
	}

	public void enterStaticScope() {
		++staticScopeCounter;
	}

	public void leaveStaticScope() {
		--staticScopeCounter;
	}

	public boolean isStaticScope() {
		return staticScopeCounter > 0;
	}
	
	public void processValue(Evaluable evaluable, IValue value) {
	}
	
	public IStatusCollector getStatusCollector() {
		return null;
	}
	
	public boolean addVisitedEvaluable(Evaluable evaluable) {
		return visitedEvaluables.add(evaluable);
	}
	
	public void removeVisitedEvaluable(Evaluable evaluable) {
		visitedEvaluables.remove(evaluable);
	}

}