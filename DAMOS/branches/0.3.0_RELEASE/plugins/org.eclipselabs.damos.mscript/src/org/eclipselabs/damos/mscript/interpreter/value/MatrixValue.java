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

package org.eclipselabs.damos.mscript.interpreter.value;

import org.eclipselabs.damos.mscript.ArrayType;
import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.interpreter.IComputationContext;
import org.eclipselabs.damos.mscript.util.TypeUtil;

/**
 * @author Andreas Unger
 *
 */
public class MatrixValue extends AbstractExplicitDataTypeValue implements IArrayValue {

	private IValue[][] elements;
	private int rowSize;
	private int columnSize;
	
	/**
	 * @param context
	 * @param dataType
	 */
	public MatrixValue(IComputationContext context, ArrayType dataType, IValue[][] elements) {
		super(context, dataType);
		if (!dataType.isMatrix()) {
			throw new IllegalArgumentException("Array type must be matrix");
		}
		this.elements = elements;
		this.rowSize = TypeUtil.getArrayRowSize(dataType);
		this.columnSize = TypeUtil.getArrayColumnSize(dataType);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.computation.core.value.AbstractExplicitDataTypeValue#getDataType()
	 */
	@Override
	public ArrayType getDataType() {
		return (ArrayType) super.getDataType();
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.computation.core.value.AbstractValue#doConvert(org.eclipselabs.mscript.typesystem.DataType)
	 */
	@Override
	protected IValue doConvert(DataType dataType) {
		if (!TypeUtil.isMatrix(dataType)) {
			throw new IllegalArgumentException("Data type must be matrix type");
		}
		ArrayType arrayType = (ArrayType) dataType;
		INumericValue[][] convertedElements = new INumericValue[rowSize][columnSize];
		for (int i = 0; i < rowSize; ++i) {
			for (int j = 0; j < columnSize; ++j) {
				convertedElements[i][j] = (INumericValue) elements[i][j].convert(arrayType.getElementType());
			}
		}
		return new MatrixValue(getContext(), arrayType, convertedElements);
	}
	
	public INumericValue get(int index) {
		throw new UnsupportedOperationException();
	}

	public INumericValue get(int rowIndex, int columnIndex) {
		return (INumericValue) elements[rowIndex][columnIndex];
	}
	
	public INumericValue get(int... indices) {
		if (indices.length != 2) {
			throw new IllegalArgumentException("Index array length must be 2");
		}
		return (INumericValue) elements[indices[0]][indices[1]];
	}
	
	public void set(int index, IValue value) {
		throw new UnsupportedOperationException();
	}
	
	public void set(int rowIndex, int columnIndex, IValue value) {
		if (!(value instanceof INumericValue)) {
			throw new IllegalArgumentException("Value must be numeric");
		}
		elements[rowIndex][columnIndex] = (INumericValue) value;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.computation.core.value.IArrayValue#set(int[], org.eclipselabs.mscript.computation.core.value.IValue)
	 */
	public void set(int[] indices, IValue value) {
		if (indices.length != 2) {
			throw new IllegalArgumentException("Index array length must be 2");
		}
		if (!(value instanceof INumericValue)) {
			throw new IllegalArgumentException("Value must be numeric");
		}
		elements[indices[0]][indices[1]] = (INumericValue) value;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.computation.core.value.AbstractValue#doMultiply(org.eclipselabs.mscript.computation.core.value.IValue, org.eclipselabs.mscript.typesystem.DataType)
	 */
	@Override
	protected IValue doMultiply(IValue other, DataType resultDataType) {
		if (other instanceof INumericValue) {
			INumericValue otherNumericValue = (INumericValue) other;
			INumericValue[][] resultElements = new INumericValue[rowSize][columnSize];
			for (int i = 0; i < rowSize; ++i) {
				for (int j = 0; j < columnSize; ++j) {
					IValue resultElement = elements[i][j].multiply(otherNumericValue);
					if (!(resultElement instanceof INumericValue)) {
						return InvalidValue.SINGLETON;
					}
					resultElements[i][j] = (INumericValue) resultElement;
				}
			}
			return new MatrixValue(getContext(), (ArrayType) resultDataType, resultElements);
//		} else if (other instanceof VectorValue) {
//			VectorValue otherVectorValue = (VectorValue) other;
//			if (elements.length != otherVectorValue.elements.length) {
//				return InvalidValue.SINGLETON;
//			}
//			INumericValue result = null;
//			for (int i = 0; i < elements.length; ++i) {
//				IValue product = elements[i].multiply(otherVectorValue.elements[i]);
//				if (!(product instanceof INumericValue)) {
//					return InvalidValue.SINGLETON;
//				}
//				INumericValue numericProduct = (INumericValue) product;
//				if (result == null) {
//					result = numericProduct;
//				} else {
//					IValue sum = result.add(numericProduct);
//					if (!(sum instanceof INumericValue)) {
//						return InvalidValue.SINGLETON;
//					}
//					result = (INumericValue) sum;
//				}
//			}
//			return result;
		}
		return super.doMultiply(other, resultDataType);
	}

}
