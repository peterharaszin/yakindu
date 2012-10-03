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

package org.eclipse.damos.mscript.internal.operations;

import org.eclipse.damos.mscript.IntegerType;
import org.eclipse.damos.mscript.MscriptFactory;
import org.eclipse.damos.mscript.OperatorKind;
import org.eclipse.damos.mscript.StringType;
import org.eclipse.damos.mscript.Type;


public class StringTypeOperations extends PrimitiveTypeOperations {

	public static Type evaluate(StringType stringType, OperatorKind operator, Type other) {
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
		return MscriptFactory.eINSTANCE.createInvalidType();
	}

	public static boolean isAssignableFrom(StringType stringType, Type other) {
		return other instanceof StringType || other instanceof IntegerType;
	}

}
