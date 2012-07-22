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

import org.eclipselabs.damos.mscript.VariableDeclaration;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;

public class IteratorVariable implements IVariable {

	private final VariableDeclaration declaration;
	private IValue value;
	
	/**
	 * 
	 */
	public IteratorVariable(VariableDeclaration declaration, IValue value) {
		this.declaration = declaration;
		this.value = value;
	}
	
	public VariableDeclaration getDeclaration() {
		return declaration;
	}

	public IValue getValue(int stepIndex) {
		return value;
	}

	public void setValue(int stepIndex, IValue value) {
		throw new UnsupportedOperationException("Iteration variables cannot be set");
	}

	public void incrementStepIndex() {
		throw new UnsupportedOperationException("Iteration variables cannot be incremented");
	}
	
}