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

package org.eclipselabs.damos.mscript.internal.builtin;

import java.util.List;

import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.IntegerType;
import org.eclipselabs.damos.mscript.RealType;
import org.eclipselabs.damos.mscript.builtin.IBuiltinFunctionSignature;

/**
 * @author Andreas Unger
 *
 */
public class RoundSignature implements IBuiltinFunctionSignature {

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.il.builtin.ISignature#evaluateOutputParameterDataTypes(java.util.List)
	 */
	public boolean accepts(List<? extends DataType> inputParameterDataTypes) {
		if (inputParameterDataTypes.size() != 1) {
			return false;
		}
		
		DataType inputDataType = inputParameterDataTypes.get(0);
		
		return inputDataType instanceof RealType || inputDataType instanceof IntegerType;
	}

}
