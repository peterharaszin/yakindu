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
import org.eclipselabs.damos.mscript.IntegerType;
import org.eclipselabs.damos.mscript.MscriptFactory;
import org.eclipselabs.damos.mscript.OperatorKind;
import org.eclipselabs.damos.mscript.StringType;


public class StringTypeOperations extends PrimitiveTypeOperations {

	public static DataType evaluate(StringType stringType, OperatorKind operator, DataType other) {
		switch (operator) {
		case ADD:
			if (stringType.isAssignableFrom(other)) {
				return MscriptFactory.eINSTANCE.createStringType();
			}
			break;
		case EQUAL_TO:
		case NOT_EQUAL_TO:
			if (other instanceof StringType) {
				return MscriptFactory.eINSTANCE.createBooleanType();
			}
		default:
			break;
		}
		return MscriptFactory.eINSTANCE.createInvalidDataType();
	}

	public static boolean isAssignableFrom(StringType stringType, DataType other) {
		return other instanceof StringType || other instanceof IntegerType;
	}

}
