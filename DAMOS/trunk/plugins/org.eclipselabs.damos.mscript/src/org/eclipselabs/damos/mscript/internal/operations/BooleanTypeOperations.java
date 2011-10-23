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

import org.eclipselabs.damos.mscript.BooleanType;
import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.MscriptFactory;
import org.eclipselabs.damos.mscript.OperatorKind;


public class BooleanTypeOperations extends PrimitiveTypeOperations {

	public static DataType evaluate(BooleanType booleanType, OperatorKind operator, DataType other) {
		if (operator == OperatorKind.LOGICAL_NOT) {
			return MscriptFactory.eINSTANCE.createBooleanType();
		}
		if (other instanceof BooleanType) {
			switch (operator) {
			case EQUAL_TO:
			case NOT_EQUAL_TO:
			case LOGICAL_AND:
			case LOGICAL_OR:
			case IMPLIES:
				return MscriptFactory.eINSTANCE.createBooleanType();
			}
		}
		return MscriptFactory.eINSTANCE.createInvalidDataType();
	}

	public static boolean isAssignableFrom(BooleanType booleanType, DataType other) {
		return other instanceof BooleanType;
	}

}
