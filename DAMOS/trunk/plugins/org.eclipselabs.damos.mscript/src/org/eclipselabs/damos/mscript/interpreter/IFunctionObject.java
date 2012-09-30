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

import java.util.Collection;

import org.eclipselabs.damos.mscript.VariableDeclaration;
import org.eclipselabs.damos.mscript.function.FunctionInstance;

/**
 * @author Andreas Unger
 *
 * @noextend
 * @noimplement
 */
public interface IFunctionObject {

	FunctionInstance getFunctionInstance();
	
	Collection<IVariable> getVariables();
	
	IVariable getVariable(VariableDeclaration declaration);
	
	void addVariable(IVariable variable);
	
	void incrementStepIndex();

}