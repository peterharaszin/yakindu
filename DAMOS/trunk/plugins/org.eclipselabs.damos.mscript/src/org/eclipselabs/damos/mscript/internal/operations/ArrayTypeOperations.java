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
import org.eclipselabs.damos.mscript.InvalidType;
import org.eclipselabs.damos.mscript.MscriptFactory;
import org.eclipselabs.damos.mscript.NumericType;
import org.eclipselabs.damos.mscript.OperatorKind;
import org.eclipselabs.damos.mscript.Type;
import org.eclipselabs.damos.mscript.util.TypeUtil;

public class ArrayTypeOperations extends TypeOperations {

	public static Type getElementType(ArrayType arrayType) {
		return arrayType.getElementTypeSpecifier().getType();
	}

	public static boolean isAssignableFrom(ArrayType arrayType, Type other) {
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
				Type elementType = arrayType.getElementType();
				Type otherElementType = otherArrayType.getElementType();
				if (elementType != null && !elementType.eIsProxy() && otherElementType != null && !otherElementType.eIsProxy()) {
					return elementType.isAssignableFrom(otherElementType);
				}
			}
		}
		return false;
	}

	public static Type evaluate(ArrayType arrayType, OperatorKind operator, Type other) {
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
		return MscriptFactory.eINSTANCE.createInvalidType();
	}
	
	private static Type evaluateElementWise(ArrayType arrayType, OperatorKind operator, Type other) {
		if (other instanceof NumericType) {
			if (operator == OperatorKind.ELEMENT_WISE_MULTIPLY || operator == OperatorKind.ELEMENT_WISE_DIVIDE || operator == OperatorKind.ELEMENT_WISE_MODULO
					|| operator == OperatorKind.ELEMENT_WISE_ADD || operator == OperatorKind.ELEMENT_WISE_SUBTRACT) {
				return evaluateElementWiseScalar(arrayType, operator, (NumericType) other);
			}
		} else if (TypeUtil.isNumericArray(other)) {
			return evaluateElementWiseArray(arrayType, operator, (ArrayType) other);
		}
		return MscriptFactory.eINSTANCE.createInvalidType();
	}
	
	static Type evaluateElementWiseScalar(ArrayType arrayType, OperatorKind operator, NumericType numericType) {
		Type elementType = arrayType.getElementType().evaluate(operator, numericType);
		if (elementType instanceof InvalidType) {
			return elementType;
		}
		ArrayType result = EcoreUtil.copy(arrayType);
		TypeUtil.setArrayElementType(result, elementType);
		return result;
	}

	static Type evaluateElementWiseScalar(NumericType numericType, OperatorKind operator, ArrayType arrayType) {
		Type elementType = numericType.evaluate(operator, arrayType.getElementType());
		if (elementType instanceof InvalidType) {
			return elementType;
		}
		ArrayType result = EcoreUtil.copy(arrayType);
		TypeUtil.setArrayElementType(result, elementType);
		return result;
	}

	private static Type evaluateElementWiseArray(ArrayType arrayType, OperatorKind operator, ArrayType otherArrayType) {
		if (TypeUtil.equalArrayDimensions(arrayType, otherArrayType)) {
			Type elementType = arrayType.getElementType().evaluate(operator, otherArrayType.getElementType());
			if (elementType instanceof InvalidType) {
				return elementType;
			}
			ArrayType result = EcoreUtil.copy(arrayType);
			TypeUtil.setArrayElementType(result, elementType);
			return result;
		}
		return MscriptFactory.eINSTANCE.createInvalidType();
	}
	
	private static Type evaluateMultiply(ArrayType arrayType, Type other) {
		if (other instanceof NumericType) {
			return evaluateElementWiseScalar(arrayType, OperatorKind.MULTIPLY, (NumericType) other);
		}
		if (!TypeUtil.isNumericArray(other)) {
			return MscriptFactory.eINSTANCE.createInvalidType();
		}
		
		ArrayType otherArrayType = (ArrayType) other;
		
		int rowSize;
		int columnSize;
		
		if (arrayType.isNumericVector()) {
			if (otherArrayType.isNumericVector()) {
				if (TypeUtil.getArraySize(arrayType) != TypeUtil.getArraySize(otherArrayType)) {
					return MscriptFactory.eINSTANCE.createInvalidType();
				}
				rowSize = -1;
				columnSize = -1;
			} else if (otherArrayType.isNumericMatrix()) {
				if (TypeUtil.getArraySize(arrayType) != TypeUtil.getArrayRowSize(otherArrayType)) {
					return MscriptFactory.eINSTANCE.createInvalidType();
				}
				rowSize = TypeUtil.getArrayColumnSize(otherArrayType);
				columnSize = -1;
			} else {
				return MscriptFactory.eINSTANCE.createInvalidType();
			}
		} else if (arrayType.isNumericMatrix()) {
			if (otherArrayType.isNumericVector()) {
				if (TypeUtil.getArrayColumnSize(arrayType) != TypeUtil.getArraySize(otherArrayType)) {
					return MscriptFactory.eINSTANCE.createInvalidType();
				}
				rowSize = TypeUtil.getArrayRowSize(arrayType);
				columnSize = -1;
			} else if (otherArrayType.isNumericMatrix()) {
				if (TypeUtil.getArrayColumnSize(arrayType) !=  TypeUtil.getArrayRowSize(otherArrayType)) {
					return MscriptFactory.eINSTANCE.createInvalidType();
				}
				rowSize =  TypeUtil.getArrayRowSize(arrayType);
				columnSize = TypeUtil.getArrayColumnSize(otherArrayType);
			} else {
				return MscriptFactory.eINSTANCE.createInvalidType();
			}
		} else {
			return MscriptFactory.eINSTANCE.createInvalidType();
		}
		
		Type elementType = arrayType.getElementType().evaluate(OperatorKind.MULTIPLY, otherArrayType.getElementType());
		if (elementType instanceof InvalidType) {
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
	
	private static Type evaluateDivideModulo(ArrayType arrayType, OperatorKind operator, Type other) {
		if (other instanceof NumericType) {
			return evaluateElementWiseScalar(arrayType, operator, (NumericType) other);
		}
		return MscriptFactory.eINSTANCE.createInvalidType();
	}

}
