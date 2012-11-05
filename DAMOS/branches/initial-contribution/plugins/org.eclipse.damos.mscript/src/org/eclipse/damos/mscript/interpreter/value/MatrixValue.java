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

package org.eclipse.damos.mscript.interpreter.value;

import org.eclipse.damos.mscript.ArrayType;
import org.eclipse.damos.mscript.Type;
import org.eclipse.damos.mscript.interpreter.IComputationContext;
import org.eclipse.damos.mscript.util.TypeUtil;

/**
 * @author Andreas Unger
 *
 */
public class MatrixValue extends AbstractExplicitDataTypeValue implements IArrayValue {

	IValue[][] elements;
	int rowSize;
	int columnSize;
	
	public MatrixValue(IComputationContext context, ArrayType dataType, IValue[][] elements) {
		super(context, dataType);
		if (dataType.getDimensionality() != 2) {
			throw new IllegalArgumentException("Array type must be matrix");
		}
		this.rowSize = TypeUtil.getArrayRowSize(dataType);
		this.columnSize = TypeUtil.getArrayColumnSize(dataType);
		this.elements = elements;
	}
	
	public MatrixValue(IComputationContext context, ArrayType dataType) {
		super(context, dataType);
		if (dataType.getDimensionality() != 2) {
			throw new IllegalArgumentException("Array type must be matrix");
		}
		rowSize = TypeUtil.getArrayRowSize(dataType);
		columnSize = TypeUtil.getArrayColumnSize(dataType);
		elements = new IValue[rowSize][columnSize];
		for (int i = 0; i < rowSize; ++i) {
			for (int j = 0; j < columnSize; ++j) {
				elements[i][j] = new UninitializedValue(getContext());
			}
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.mscript.computation.core.value.AbstractExplicitDataTypeValue#getDataType()
	 */
	@Override
	public ArrayType getDataType() {
		return (ArrayType) super.getDataType();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.mscript.computation.core.value.AbstractValue#doConvert(org.eclipse.damos.mscript.typesystem.DataType)
	 */
	@Override
	protected IValue doConvert(Type type) {
		if (!TypeUtil.isNumericMatrix(getDataType())) {
			return InvalidValue.SINGLETON;
		}
		ArrayType arrayType = (ArrayType) type;
		IValue[][] convertedElements = new IValue[rowSize][columnSize];
		for (int i = 0; i < rowSize; ++i) {
			for (int j = 0; j < columnSize; ++j) {
				convertedElements[i][j] = elements[i][j].convert(arrayType.getElementType());
			}
		}
		return new MatrixValue(getContext(), arrayType, convertedElements);
	}
	
	/**
	 * @return the rowSize
	 */
	public int getRowSize() {
		return rowSize;
	}
	
	/**
	 * @return the columnSize
	 */
	public int getColumnSize() {
		return columnSize;
	}
	
	public IValue get(int index) {
		throw new UnsupportedOperationException();
	}

	public IValue get(int rowIndex, int columnIndex) {
		return elements[rowIndex][columnIndex];
	}
	
	public IValue get(int... indices) {
		if (indices.length != 2) {
			throw new IllegalArgumentException("Index array length must be 2");
		}
		return elements[indices[0]][indices[1]];
	}
	
	public void set(int index, IValue value) {
		throw new UnsupportedOperationException();
	}
	
	public void set(int rowIndex, int columnIndex, IValue value) {
		elements[rowIndex][columnIndex] = value;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.mscript.computation.core.value.IArrayValue#set(int[], org.eclipse.damos.mscript.computation.core.value.IValue)
	 */
	public void set(int[] indices, IValue value) {
		if (indices.length != 2) {
			throw new IllegalArgumentException("Index array length must be 2");
		}
		elements[indices[0]][indices[1]] = value;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.mscript.interpreter.value.AbstractValue#doAdd(org.eclipse.damos.mscript.interpreter.value.IValue, org.eclipse.damos.mscript.DataType)
	 */
	@Override
	protected IValue doAdd(IValue other, Type resultDataType) {
		if (other instanceof MatrixValue) {
			MatrixValue otherMatrixValue = (MatrixValue) other;
			if (rowSize != otherMatrixValue.rowSize || columnSize != otherMatrixValue.columnSize) {
				return InvalidValue.SINGLETON;
			}
			IValue[][] result = new IValue[rowSize][columnSize];
			for (int i = 0; i < rowSize; ++i) {
				for (int j = 0; j < columnSize; ++j) {
					IValue sum = elements[i][j].add(otherMatrixValue.elements[i][j]);
					if (sum instanceof InvalidValue) {
						return InvalidValue.SINGLETON;
					}
					result[i][j] = sum;
				}
			}
			return new MatrixValue(getContext(), (ArrayType) resultDataType, result);
		}
		return super.doAdd(other, resultDataType);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.mscript.computation.core.value.AbstractValue#doMultiply(org.eclipse.damos.mscript.computation.core.value.IValue, org.eclipse.damos.mscript.typesystem.DataType)
	 */
	@Override
	protected IValue doMultiply(IValue other, Type resultDataType) {
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
		} else if (other instanceof VectorValue) {
			VectorValue otherVectorValue = (VectorValue) other;
			if (columnSize != otherVectorValue.elements.length) {
				return InvalidValue.SINGLETON;
			}
			IValue[] result = new IValue[rowSize];
			for (int i = 0; i < rowSize; ++i) {
				for (int j = 0; j < columnSize; ++j) {
					IValue product = elements[i][j].multiply(otherVectorValue.elements[j]);
					if (!(product instanceof INumericValue)) {
						return InvalidValue.SINGLETON;
					}
					INumericValue numericProduct = (INumericValue) product;
					if (result[i] == null) {
						result[i] = numericProduct;
					} else {
						IValue sum = result[i].add(numericProduct);
						if (!(sum instanceof INumericValue)) {
							return InvalidValue.SINGLETON;
						}
						result[i] = sum;
					}
				}
			}
			return new VectorValue(getContext(), (ArrayType) resultDataType, result);
		} else if (other instanceof MatrixValue) {
			MatrixValue otherMatrixValue = (MatrixValue) other;
			if (columnSize != otherMatrixValue.rowSize) {
				return InvalidValue.SINGLETON;
			}
			IValue[][] result = new IValue[rowSize][otherMatrixValue.columnSize];
			for (int k = 0; k < otherMatrixValue.columnSize; ++k) {
				for (int i = 0; i < rowSize; ++i) {
					for (int j = 0; j < columnSize; ++j) {
						IValue product = elements[i][j].multiply(otherMatrixValue.elements[j][k]);
						if (!(product instanceof INumericValue)) {
							return InvalidValue.SINGLETON;
						}
						INumericValue numericProduct = (INumericValue) product;
						if (result[i][k] == null) {
							result[i][k] = numericProduct;
						} else {
							IValue sum = result[i][k].add(numericProduct);
							if (!(sum instanceof INumericValue)) {
								return InvalidValue.SINGLETON;
							}
							result[i][k] = sum;
						}
					}
				}
			}
			return new MatrixValue(getContext(), (ArrayType) resultDataType, result);
		}
		return super.doMultiply(other, resultDataType);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.mscript.interpreter.value.AbstractValue#doDivide(org.eclipse.damos.mscript.interpreter.value.IValue, org.eclipse.damos.mscript.DataType)
	 */
	@Override
	protected IValue doDivide(IValue other, Type resultDataType) {
		if (other instanceof INumericValue) {
			INumericValue otherNumericValue = (INumericValue) other;
			INumericValue[][] resultElements = new INumericValue[rowSize][columnSize];
			for (int i = 0; i < rowSize; ++i) {
				for (int j = 0; j < columnSize; ++j) {
					IValue resultElement = elements[i][j].divide(otherNumericValue);
					if (!(resultElement instanceof INumericValue)) {
						return InvalidValue.SINGLETON;
					}
					resultElements[i][j] = (INumericValue) resultElement;
				}
			}
			return new MatrixValue(getContext(), (ArrayType) resultDataType, resultElements);
		}
		return super.doDivide(other, resultDataType);
	}

}
