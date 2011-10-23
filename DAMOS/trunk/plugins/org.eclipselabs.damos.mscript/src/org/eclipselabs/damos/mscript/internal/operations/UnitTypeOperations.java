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
import org.eclipselabs.damos.mscript.UnitType;


public class UnitTypeOperations extends DataTypeOperations {

	public static DataType evaluate(UnitType unitType, OperatorKind operator, DataType other) {
		if (!(other instanceof UnitType)) {
			return MscriptFactory.eINSTANCE.createInvalidDataType();
		}
		switch (operator) {
		case MULTIPLY:
		case DIVIDE:
			return MscriptFactory.eINSTANCE.createUnitType();
		case EQUAL_TO:
		case NOT_EQUAL_TO:
			return MscriptFactory.eINSTANCE.createBooleanType();
		}
		return MscriptFactory.eINSTANCE.createInvalidDataType();
	}

	public static DataType evaluate(UnitType unitType, OperatorKind operator, int n) {
		return MscriptFactory.eINSTANCE.createUnitType();
	}
	
	public static boolean isAssignableFrom(UnitType unitType, DataType other) {
		return other instanceof UnitType;
	}

}
