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

package org.eclipse.damos.mscript.interpreter.value;

/**
 * @author Andreas Unger
 *
 * @noextend
 * @noimplement
 */
public interface ISimpleNumericValue extends INumericValue {

	double doubleValue();
	
	long longValue();

	IValue round();
	IValue exp();
	IValue ln();
	IValue lg();
	IValue lb();
	IValue sin();
	IValue cos();
	IValue tan();
	
}
