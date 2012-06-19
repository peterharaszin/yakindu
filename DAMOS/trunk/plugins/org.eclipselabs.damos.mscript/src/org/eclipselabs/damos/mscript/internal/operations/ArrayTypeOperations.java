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

import java.util.Iterator;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.damos.mscript.ArrayDimension;
import org.eclipselabs.damos.mscript.ArrayType;
import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.InvalidDataType;
import org.eclipselabs.damos.mscript.MscriptFactory;
import org.eclipselabs.damos.mscript.NumericType;
import org.eclipselabs.damos.mscript.OperatorKind;
import org.eclipselabs.damos.mscript.util.TypeUtil;

public class ArrayTypeOperations extends DataTypeOperations {

	public static DataType getElementType(ArrayType arrayType) {
		return arrayType.getElementTypeSpecifier().getType();
	}

	public static boolean isAssignableFrom(ArrayType arrayType, DataType other) {
		if (other instanceof ArrayType) {
			ArrayType otherArrayType = (ArrayType) other;
			if (arrayType.getDimensionality() == otherArrayType.getDimensionality()) {
				Iterator<ArrayDimension> dimensionIterator = arrayType.getDimensions().iterator();
				Iterator<ArrayDimension> otherDimensionIterator = otherArrayType.getDimensions().iterator();
				while (dimensionIterator.hasNext() && otherDimensionIterator.hasNext()) {
					int size = TypeUtil.getArrayDimensionSize(dimensionIterator.next());
					int otherSize = TypeUtil.getArrayDimensionSize(otherDimensionIterator.next());
					if (size >= 0 && size != otherSize) {
						return false;
					}
				}
				DataType elementType = arrayType.getElementType();
				DataType otherElementType = otherArrayType.getElementType();
				if (elementType != null && !elementType.eIsProxy() && otherElementType != null && !otherElementType.eIsProxy()) {
					return elementType.isAssignableFrom(otherElementType);
				}
			}
		}
		return false;
	}

	public static DataType evaluate(ArrayType arrayType, OperatorKind operator, DataType other) {
		if (arrayType.isNumeric()) {
			switch (operator) {
			case ADD:
			case SUBTRACT:
				return evaluateElementWise(arrayType, operator, other);
			case MULTIPLY:
				return evaluateMultiply(arrayType, other);
			case DIVIDE:
			case MODULO:
				return evaluateDivideModulo(arrayType, operator, other);
			case ELEMENT_WISE_ADD:
			case ELEMENT_WISE_SUBTRACT:
			case ELEMENT_WISE_MULTIPLY:
			case ELEMENT_WISE_DIVIDE:
			case ELEMENT_WISE_MODULO:
				return evaluateElementWise(arrayType, operator, other);
			case NEGATE:
				return EcoreUtil.copy(arrayType);
			default:
				break;
			}
		}
		return MscriptFactory.eINSTANCE.createInvalidDataType();
	}
	
	private static DataType evaluateElementWise(ArrayType arrayType, OperatorKind operator, DataType other) {
		if (other instanceof NumericType) {
			if (operator == OperatorKind.ELEMENT_WISE_MULTIPLY || operator == OperatorKind.ELEMENT_WISE_DIVIDE || operator == OperatorKind.ELEMENT_WISE_MODULO
					|| operator == OperatorKind.ELEMENT_WISE_ADD || operator == OperatorKind.ELEMENT_WISE_SUBTRACT) {
				return evaluateElementWiseScalar(arrayType, operator, (NumericType) other);
			}
		} else if (TypeUtil.isNumericArray(other)) {
			return evaluateElementWiseArray(arrayType, operator, (ArrayType) other);
		}
		return MscriptFactory.eINSTANCE.createInvalidDataType();
	}
	
	static DataType evaluateElementWiseScalar(ArrayType arrayType, OperatorKind operator, NumericType numericType) {
		DataType elementType = arrayType.getElementType().evaluate(operator, numericType);
		if (elementType instanceof InvalidDataType) {
			return elementType;
		}
		ArrayType result = EcoreUtil.copy(arrayType);
		TypeUtil.setArrayElementType(result, elementType);
		return result;
	}

	static DataType evaluateElementWiseScalar(NumericType numericType, OperatorKind operator, ArrayType arrayType) {
		DataType elementType = numericType.evaluate(operator, arrayType.getElementType());
		if (elementType instanceof InvalidDataType) {
			return elementType;
		}
		ArrayType result = EcoreUtil.copy(arrayType);
		TypeUtil.setArrayElementType(result, elementType);
		return result;
	}

	private static DataType evaluateElementWiseArray(ArrayType arrayType, OperatorKind operator, ArrayType otherArrayType) {
		if (TypeUtil.equalArrayDimensions(arrayType, otherArrayType)) {
			DataType elementType = arrayType.getElementType().evaluate(operator, otherArrayType.getElementType());
			if (elementType instanceof InvalidDataType) {
				return elementType;
			}
			ArrayType result = EcoreUtil.copy(arrayType);
			TypeUtil.setArrayElementType(result, elementType);
			return result;
		}
		return MscriptFactory.eINSTANCE.createInvalidDataType();
	}
	
	private static DataType evaluateMultiply(ArrayType arrayType, DataType other) {
		if (other instanceof NumericType) {
			return evaluateElementWiseScalar(arrayType, OperatorKind.MULTIPLY, (NumericType) other);
		}
		if (!TypeUtil.isNumericArray(other)) {
			return MscriptFactory.eINSTANCE.createInvalidDataType();
		}
		
		ArrayType otherArrayType = (ArrayType) other;
		
		int rowSize;
		int columnSize;
		
		if (arrayType.isNumericVector()) {
			if (otherArrayType.isNumericVector()) {
				if (TypeUtil.getArraySize(arrayType) != TypeUtil.getArraySize(otherArrayType)) {
					return MscriptFactory.eINSTANCE.createInvalidDataType();
				}
				rowSize = -1;
				columnSize = -1;
			} else if (otherArrayType.isNumericMatrix()) {
				if (TypeUtil.getArraySize(arrayType) != TypeUtil.getArrayRowSize(otherArrayType)) {
					return MscriptFactory.eINSTANCE.createInvalidDataType();
				}
				rowSize = TypeUtil.getArrayColumnSize(otherArrayType);
				columnSize = -1;
			} else {
				return MscriptFactory.eINSTANCE.createInvalidDataType();
			}
		} else if (arrayType.isNumericMatrix()) {
			if (otherArrayType.isNumericVector()) {
				if (TypeUtil.getArrayColumnSize(arrayType) != TypeUtil.getArraySize(otherArrayType)) {
					return MscriptFactory.eINSTANCE.createInvalidDataType();
				}
				rowSize = TypeUtil.getArrayRowSize(arrayType);
				columnSize = -1;
			} else if (otherArrayType.isNumericMatrix()) {
				if (TypeUtil.getArrayColumnSize(arrayType) !=  TypeUtil.getArrayRowSize(otherArrayType)) {
					return MscriptFactory.eINSTANCE.createInvalidDataType();
				}
				rowSize =  TypeUtil.getArrayRowSize(arrayType);
				columnSize = TypeUtil.getArrayColumnSize(otherArrayType);
			} else {
				return MscriptFactory.eINSTANCE.createInvalidDataType();
			}
		} else {
			return MscriptFactory.eINSTANCE.createInvalidDataType();
		}
		
		DataType elementType = arrayType.getElementType().evaluate(OperatorKind.MULTIPLY, otherArrayType.getElementType());
		if (elementType instanceof InvalidDataType) {
			return elementType;
		}
		
		if (rowSize == -1 && columnSize == -1) {
			return elementType;
		}

		if (columnSize == -1) {
			return TypeUtil.createArrayType(elementType, rowSize);
		}
		
		return TypeUtil.createArrayType(elementType, rowSize, columnSize);
	}
	
	private static DataType evaluateDivideModulo(ArrayType arrayType, OperatorKind operator, DataType other) {
		if (other instanceof NumericType) {
			return evaluateElementWiseScalar(arrayType, operator, (NumericType) other);
		}
		return MscriptFactory.eINSTANCE.createInvalidDataType();
	}

}
