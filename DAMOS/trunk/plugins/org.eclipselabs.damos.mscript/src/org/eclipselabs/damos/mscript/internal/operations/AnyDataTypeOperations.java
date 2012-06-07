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

import org.eclipselabs.damos.mscript.AnyDataType;
import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.MscriptFactory;
import org.eclipselabs.damos.mscript.OperatorKind;


public class AnyDataTypeOperations extends DataTypeOperations {

	public static DataType evaluate(AnyDataType anyDataType, OperatorKind operator, DataType other) {
		switch (operator) {
		case IMPLIES:
		case LOGICAL_OR:
		case LOGICAL_AND:
		case LOGICAL_NOT:
		case GREATER_THAN:
		case GREATER_THAN_OR_EQUAL_TO:
		case LESS_THAN:
		case LESS_THAN_OR_EQUAL_TO:
		case EQUAL_TO:
		case NOT_EQUAL_TO:
			return MscriptFactory.eINSTANCE.createBooleanType();
		default:
			break;
		}
		return MscriptFactory.eINSTANCE.createInvalidDataType();
	}

	public static DataType evaluate(AnyDataType anyDataType, int n) {
		return MscriptFactory.eINSTANCE.createAnyDataType();
	}

	public static boolean isAssignableFrom(AnyDataType anyDataType, DataType other) {
		return true;
	}

}
