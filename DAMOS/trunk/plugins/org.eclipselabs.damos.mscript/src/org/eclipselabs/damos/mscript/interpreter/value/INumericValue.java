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

package org.eclipselabs.damos.mscript.interpreter.value;

import org.eclipselabs.damos.mscript.NumericType;
import org.eclipselabs.damos.mscript.Unit;

/**
 * @author Andreas Unger
 *
 * @noextend
 * @noimplement
 */
public interface INumericValue extends IValue {

	NumericType getDataType();
	
	INumericValue convertUnit(Unit unit);
	
}
