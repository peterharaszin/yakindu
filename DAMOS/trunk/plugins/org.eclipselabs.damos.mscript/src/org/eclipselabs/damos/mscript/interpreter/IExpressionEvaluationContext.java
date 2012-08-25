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
import org.eclipselabs.damos.mscript.interpreter.value.IValue;

/**
 * @author Andreas Unger
 *
 */
public interface IExpressionEvaluationContext {

	IComputationContext getComputationContext();

	void enterStaticScope();
	void leaveStaticScope();
	boolean isStaticScope();
	
	void enterVariableScope();
	void leaveVariableScope();

	void addVariable(IVariable variable);
	
	IValue getValue(Evaluable evaluable);
	void processValue(Evaluable evaluable, IValue value);
	
	IStatusCollector getStatusCollector();
	
	boolean addVisitedEvaluable(Evaluable evaluable);
	void removeVisitedEvaluable(Evaluable evaluable);
	
}
