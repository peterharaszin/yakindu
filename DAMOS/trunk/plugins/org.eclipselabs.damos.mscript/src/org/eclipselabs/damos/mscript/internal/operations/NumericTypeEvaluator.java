/****************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.mscript.internal.operations;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.damos.mscript.ArrayType;
import org.eclipselabs.damos.mscript.MscriptFactory;
import org.eclipselabs.damos.mscript.NumericType;
import org.eclipselabs.damos.mscript.OperatorKind;
import org.eclipselabs.damos.mscript.Type;
import org.eclipselabs.damos.mscript.Unit;
import org.eclipselabs.damos.mscript.util.TypeUtil;

/**
 * @author Andreas Unger
 *
 */
public abstract class NumericTypeEvaluator {

	public Type evaluate(NumericType numericType, OperatorKind operator, Type other) {
		if (operator == OperatorKind.NEGATE) {
			return EcoreUtil.copy(numericType);
		}
		
		if (!(other instanceof NumericType)) {
			if (TypeUtil.isNumericArray(other)) {
				switch (operator) {
				case MULTIPLY:
				case ELEMENT_WISE_ADD:
				case ELEMENT_WISE_SUBTRACT:
				case ELEMENT_WISE_MULTIPLY:
					return ArrayTypeOperations.evaluateElementWiseScalar((ArrayType) other, operator, numericType);
				case ELEMENT_WISE_DIVIDE:
				case ELEMENT_WISE_MODULO:
					return ArrayTypeOperations.evaluateElementWiseScalar(numericType, operator, (ArrayType) other);
				default:
					break;
				}
			}
			return MscriptFactory.eINSTANCE.createInvalidType();
		}
		NumericType otherNumericType = (NumericType) other;

		switch (operator) {
		case LESS_THAN:
		case LESS_THAN_OR_EQUAL_TO:
		case GREATER_THAN:
		case GREATER_THAN_OR_EQUAL_TO:
		case EQUAL_TO:
		case NOT_EQUAL_TO:
			if (!numericType.getUnit().isEquivalentTo(otherNumericType.getUnit(), false)) {
				return MscriptFactory.eINSTANCE.createInvalidType();
			}
			return MscriptFactory.eINSTANCE.createBooleanType();
		case ADD:
		case SUBTRACT:
		case MULTIPLY:
		case DIVIDE:
		case MODULO:
		case ELEMENT_WISE_ADD:
		case ELEMENT_WISE_SUBTRACT:
		case ELEMENT_WISE_MULTIPLY:
		case ELEMENT_WISE_DIVIDE:
		case ELEMENT_WISE_MODULO:
			Unit unit = numericType.getUnit().evaluate(operator, otherNumericType.getUnit());
			if (unit != null) {
				NumericType result = createResultType(operator, otherNumericType);
				result.setUnit(unit);
				return result;
			}
			break;
		default:
			break;
		}

		return MscriptFactory.eINSTANCE.createInvalidType();
	}

	/**
	 * @param operator
	 * @param otherNumericType
	 * @return
	 */
	protected abstract NumericType createResultType(OperatorKind operator, NumericType otherNumericType);

}
