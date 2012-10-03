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

import org.eclipse.damos.mscript.MscriptFactory;
import org.eclipse.damos.mscript.OperatorKind;
import org.eclipse.damos.mscript.Type;
import org.eclipse.damos.mscript.UnitType;


public class UnitTypeOperations extends TypeOperations {

	public static Type evaluate(UnitType unitType, OperatorKind operator, Type other) {
		if (!(other instanceof UnitType)) {
			return MscriptFactory.eINSTANCE.createInvalidType();
		}
		switch (operator) {
		case MULTIPLY:
		case DIVIDE:
			return MscriptFactory.eINSTANCE.createUnitType();
		case EQUAL_TO:
		case NOT_EQUAL_TO:
			return MscriptFactory.eINSTANCE.createBooleanType();
		default:
			break;
		}
		return MscriptFactory.eINSTANCE.createInvalidType();
	}

	public static Type evaluate(UnitType unitType, OperatorKind operator, int n) {
		return MscriptFactory.eINSTANCE.createUnitType();
	}
	
	public static boolean isAssignableFrom(UnitType unitType, Type other) {
		return other instanceof UnitType;
	}

}
