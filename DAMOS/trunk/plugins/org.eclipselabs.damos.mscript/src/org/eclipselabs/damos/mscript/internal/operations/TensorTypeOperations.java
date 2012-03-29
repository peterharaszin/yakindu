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

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.InvalidDataType;
import org.eclipselabs.damos.mscript.MscriptFactory;
import org.eclipselabs.damos.mscript.NumericType;
import org.eclipselabs.damos.mscript.OperatorKind;
import org.eclipselabs.damos.mscript.TensorType;
import org.eclipselabs.damos.mscript.util.TypeUtil;

public class TensorTypeOperations extends ArrayTypeOperations {

	public static DataType evaluate(TensorType tensorType, OperatorKind operator, DataType other) {
		switch (operator) {
		case ADD:
			return evaluateElementWise(tensorType, operator, other);
		case SUBTRACT:
			return evaluateElementWise(tensorType, operator, other);
		case MULTIPLY:
			return evaluateMultiply(tensorType, other);
		case DIVIDE:
			return evaluateDivide(tensorType, other);
		case ELEMENT_WISE_MULTIPLY:
			return evaluateElementWise(tensorType, operator, other);
		case ELEMENT_WISE_DIVIDE:
			return evaluateElementWise(tensorType, operator, other);
		case NEGATE:
			return EcoreUtil.copy(tensorType);
		}
		return MscriptFactory.eINSTANCE.createInvalidDataType();
	}
	
	private static DataType evaluateElementWise(TensorType tensorType, OperatorKind operator, DataType other) {
		if (other instanceof NumericType) {
			if (operator == OperatorKind.ELEMENT_WISE_MULTIPLY || operator == OperatorKind.ELEMENT_WISE_DIVIDE) {
				return evaluateElementWiseScalar(tensorType, operator, (NumericType) other);
			}
		} else if (other instanceof TensorType) {
			return evaluateElementWiseTensor(tensorType, operator, (TensorType) other);
		}
		return MscriptFactory.eINSTANCE.createInvalidDataType();
	}
	
	static DataType evaluateElementWiseScalar(TensorType tensorType, OperatorKind operator, NumericType other) {
		DataType elementType = tensorType.getElementType().evaluate(operator, other);
		if (elementType instanceof InvalidDataType) {
			return elementType;
		}
		TensorType result = EcoreUtil.copy(tensorType);
		result.setElementType(elementType);
		return result;
	}

	private static DataType evaluateElementWiseTensor(TensorType tensorType, OperatorKind operator, TensorType otherTensorType) {
		if (TypeUtil.equalArrayDimensions(tensorType, otherTensorType)) {
			DataType elementType = tensorType.getElementType().evaluate(operator, otherTensorType.getElementType());
			if (elementType instanceof InvalidDataType) {
				return elementType;
			}
			TensorType result = EcoreUtil.copy(tensorType);
			result.setElementType(elementType);
			return result;
		}
		return MscriptFactory.eINSTANCE.createInvalidDataType();
	}
	
	private static DataType evaluateMultiply(TensorType tensorType, DataType other) {
		if (other instanceof NumericType) {
			return evaluateElementWiseScalar(tensorType, OperatorKind.MULTIPLY, (NumericType) other);
		}
		if (!(other instanceof TensorType)) {
			return MscriptFactory.eINSTANCE.createInvalidDataType();
		}
		
		TensorType otherTensorType = (TensorType) other;
		
		int rowSize;
		int columnSize;
		
		if (tensorType.isVector()) {
			if (!otherTensorType.isVector() || TypeUtil.getArraySize(tensorType) != TypeUtil.getArraySize(otherTensorType)) {
				return MscriptFactory.eINSTANCE.createInvalidDataType();
			}
			rowSize = 1;
			columnSize = 1;
		} else if (tensorType.isMatrix()) {
			if (!otherTensorType.isMatrix() || TypeUtil.getArrayColumnSize(tensorType) !=  TypeUtil.getArrayRowSize(otherTensorType)) {
				return MscriptFactory.eINSTANCE.createInvalidDataType();
			}
			rowSize =  TypeUtil.getArrayRowSize(tensorType);
			columnSize = TypeUtil.getArrayColumnSize(otherTensorType);
		} else {
			return MscriptFactory.eINSTANCE.createInvalidDataType();
		}
		
		DataType elementType = tensorType.getElementType().evaluate(OperatorKind.MULTIPLY, otherTensorType.getElementType());
		if (elementType instanceof InvalidDataType) {
			return elementType;
		}
		
		if (rowSize == 1 && columnSize == 1) {
			return elementType;
		}

		return TypeUtil.createArrayType(
				elementType,
				rowSize,
				columnSize);
	}
	
	private static DataType evaluateDivide(TensorType tensorType, DataType other) {
		if (other instanceof NumericType) {
			return evaluateElementWiseScalar(tensorType, OperatorKind.DIVIDE, (NumericType) other);
		}
		// TODO
		return MscriptFactory.eINSTANCE.createInvalidDataType();
	}

}