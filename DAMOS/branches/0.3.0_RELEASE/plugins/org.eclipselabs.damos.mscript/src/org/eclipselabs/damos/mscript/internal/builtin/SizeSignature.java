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

import org.eclipselabs.damos.mscript.ArrayType;
import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.IntegerType;
import org.eclipselabs.damos.mscript.builtin.IBuiltinFunctionSignature;

/**
 * @author Andreas Unger
 *
 */
public class SizeSignature implements IBuiltinFunctionSignature {

	public boolean accepts(List<? extends DataType> inputParameterDataTypes) {
		if (inputParameterDataTypes.isEmpty()) {
			return false;
		}
		if (inputParameterDataTypes.size() > 2) {
			return false;
		}
		if (!(inputParameterDataTypes.get(0) instanceof ArrayType)) {
			return false;
		}
		if (inputParameterDataTypes.size() == 2 && !(inputParameterDataTypes.get(1) instanceof IntegerType)) {
			return false;
		}
		return true;
	}

}
