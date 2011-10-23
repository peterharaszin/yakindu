/****************************************************************************
 * Copyright (c) 2008, 2011 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.mscript.interpreter;

import org.eclipselabs.damos.mscript.FunctionDefinition;
import org.eclipselabs.damos.mscript.VariableAccess;
import org.eclipselabs.damos.mscript.functionmodel.FunctionDescriptor;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;

/**
 * @author Andreas Unger
 *
 */
public interface IStaticEvaluationContext {

	IComputationContext getComputationContext();
	
	IValue getValue(Object key);
	void setValue(Object key, IValue value);
	
	int getStepIndex(VariableAccess variableAccess);
	void setStepIndex(VariableAccess variableAccess, int stepIndex);
	
	FunctionDescriptor getFunctionDescriptor(FunctionDefinition functionDefinition);
	void setFunctionDescriptor(FunctionDefinition functionDefinition, FunctionDescriptor functionDescriptor);

}
