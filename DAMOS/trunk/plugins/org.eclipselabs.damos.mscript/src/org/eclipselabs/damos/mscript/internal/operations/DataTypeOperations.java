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

package org.eclipselabs.damos.mscript.internal.operations;

import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.MscriptFactory;
import org.eclipselabs.damos.mscript.OperatorKind;

public class DataTypeOperations {

	public static DataType evaluate(DataType dataType, OperatorKind operator, DataType other) {
		return MscriptFactory.eINSTANCE.createInvalidDataType();
	}

	public static DataType evaluate(DataType dataType, OperatorKind operator, int n) {
		return MscriptFactory.eINSTANCE.createInvalidDataType();
	}
	
	public static boolean isAssignableFrom(DataType dataType, DataType other) {
		return dataType == other;
	}

	public static boolean isEquivalentTo(DataType dataType, DataType other) {
		if (other == null) {
			throw new NullPointerException();
		}
		return dataType.isAssignableFrom(other) && other.isAssignableFrom(dataType);
	}

}
