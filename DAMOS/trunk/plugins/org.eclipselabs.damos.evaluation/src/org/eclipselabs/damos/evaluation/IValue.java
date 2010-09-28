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

package org.eclipselabs.damos.evaluation;

import org.eclipselabs.mscript.typesystem.DataType;

/**
 * @author Andreas Unger
 *
 * @noextend
 * @noimplement
 */
public interface IValue {
	
	DataType getDataType();

	IValue add(IValue other);
	IValue subtract(IValue other);
	IValue multiply(IValue other);
	IValue divide(IValue other);
	IValue elementWiseMultiply(IValue other);
	IValue elementWiseDivide(IValue other);
	IValue unaryMinus();
	
}
