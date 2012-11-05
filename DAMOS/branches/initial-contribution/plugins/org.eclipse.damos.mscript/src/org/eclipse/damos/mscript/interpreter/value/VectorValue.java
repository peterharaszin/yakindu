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
public class VectorValue extends AbstractExplicitDataTypeValue implements IArrayValue {

	IValue[] elements;
	
	public VectorValue(IComputationContext context, ArrayType dataType, IValue[] elements) {
		super(context, dataType);
		if (dataType.getDimensionality() != 1) {
			throw new IllegalArgumentException("Array type must be vector");
		}
		if (elements.length != TypeUtil.getArraySize(dataType)) {
			throw new IllegalArgumentException("Number of elements must be equal to vector size");
		}
		this.elements = elements;
	}
	
	public VectorValue(IComputationContext context, ArrayType dataType) {
		super(context, dataType);
		if (dataType.getDimensionality() != 1) {
			throw new IllegalArgumentException("Array type must be vector");
		}
		elements = new IValue[TypeUtil.getArraySize(dataType)];
		for (int i = 0; i < elements.length; ++i) {
			elements[i] = new UninitializedValue(getContext());
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
		if (!TypeUtil.isNumericVector(getDataType())) {
			return InvalidValue.SINGLETON;
		}
		ArrayType arrayType = (ArrayType) type;
		IValue[] convertedElements = new IValue[elements.length];
		for (int i = 0; i < elements.length; ++i) {
			convertedElements[i] = elements[i].convert(arrayType.getElementType());
		}
		return new VectorValue(getContext(), arrayType, convertedElements);
	}
	
	public int getSize() {
		return elements.length;
	}
	
	public IValue get(int index) {
		return elements[index];
	}

	public IValue get(int rowIndex, int columnIndex) {
		throw new UnsupportedOperationException();
	}
	
	public IValue get(int... indices) {
		if (indices.length != 1) {
			throw new IllegalArgumentException("Index array length must be 1");
		}
		return elements[indices[0]];
	}
	
	public void set(int index, IValue value) {
		elements[index] = value;
	}
	
	public void set(int rowIndex, int columnIndex, IValue value) {
		throw new UnsupportedOperationException();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.mscript.computation.core.value.IArrayValue#set(int[], org.eclipse.damos.mscript.computation.core.value.IValue)
	 */
	public void set(int[] indices, IValue value) {
		if (indices.length != 1) {
			throw new IllegalArgumentException("Index array length must be 1");
		}
		elements[indices[0]] = value;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.mscript.interpreter.value.AbstractValue#doAdd(org.eclipse.damos.mscript.interpreter.value.IValue, org.eclipse.damos.mscript.DataType)
	 */
	@Override
	protected IValue doAdd(IValue other, Type resultDataType) {
		if (other instanceof VectorValue) {
			VectorValue otherVectorValue = (VectorValue) other;
			if (elements.length != otherVectorValue.elements.length) {
				return InvalidValue.SINGLETON;
			}
			IValue[] result = new IValue[elements.length];
			for (int i = 0; i < elements.length; ++i) {
				IValue sum = elements[i].add(otherVectorValue.elements[i]);
				if (sum instanceof InvalidValue) {
					return InvalidValue.SINGLETON;
				}
				result[i] = sum;
			}
			return new VectorValue(getContext(), (ArrayType) resultDataType, result);
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
			INumericValue[] resultElements = new INumericValue[elements.length];
			for (int i = 0; i < elements.length; ++i) {
				IValue resultElement = elements[i].multiply(otherNumericValue);
				if (!(resultElement instanceof INumericValue)) {
					return InvalidValue.SINGLETON;
				}
				resultElements[i] = (INumericValue) resultElement;
			}
			return new VectorValue(getContext(), (ArrayType) resultDataType, resultElements);
		} else if (other instanceof VectorValue) {
			VectorValue otherVectorValue = (VectorValue) other;
			if (elements.length != otherVectorValue.elements.length) {
				return InvalidValue.SINGLETON;
			}
			INumericValue result = null;
			for (int i = 0; i < elements.length; ++i) {
				IValue product = elements[i].multiply(otherVectorValue.elements[i]);
				if (!(product instanceof INumericValue)) {
					return InvalidValue.SINGLETON;
				}
				INumericValue numericProduct = (INumericValue) product;
				if (result == null) {
					result = numericProduct;
				} else {
					IValue sum = result.add(numericProduct);
					if (!(sum instanceof INumericValue)) {
						return InvalidValue.SINGLETON;
					}
					result = (INumericValue) sum;
				}
			}
			return result;
		} else if (other instanceof MatrixValue) {
			MatrixValue otherMatrixValue = (MatrixValue) other;
			if (elements.length != otherMatrixValue.rowSize) {
				return InvalidValue.SINGLETON;
			}
			IValue[] result = new IValue[otherMatrixValue.columnSize];
			for (int i = 0; i < result.length; ++i) {
				for (int j = 0; j < elements.length; ++j) {
					IValue product = elements[j].multiply(otherMatrixValue.elements[j][i]);
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
			INumericValue[] resultElements = new INumericValue[elements.length];
			for (int i = 0; i < elements.length; ++i) {
				IValue resultElement = elements[i].divide(otherNumericValue);
				if (!(resultElement instanceof INumericValue)) {
					return InvalidValue.SINGLETON;
				}
				resultElements[i] = (INumericValue) resultElement;
			}
			return new VectorValue(getContext(), (ArrayType) resultDataType, resultElements);
		}
		return super.doDivide(other, resultDataType);
	}
	
}
