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

package org.eclipselabs.damos.mscript.interpreter;

import java.util.ArrayList;
import java.util.List;

import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.Type;
import org.eclipselabs.damos.mscript.interpreter.value.IBooleanValue;
import org.eclipselabs.damos.mscript.interpreter.value.INumericValue;
import org.eclipselabs.damos.mscript.interpreter.value.ISimpleNumericValue;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;

/**
 * @author Andreas Unger
 *
 */
public class FunctionSignature {

	private List<ValueWrapper> staticParameterValues = new ArrayList<ValueWrapper>();
	private List<TypeWrapper> parameterTypes = new ArrayList<TypeWrapper>();
	private int cachedHashCode;
	
	/**
	 * 
	 */
	public FunctionSignature(List<IValue> staticParameterValues, List<DataType> parameterTypes) {
		for (IValue value : staticParameterValues) {
			this.staticParameterValues.add(new ValueWrapper(value));
		}
		for (Type type : parameterTypes) {
			this.parameterTypes.add(new TypeWrapper(type));
		}
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		if (cachedHashCode == 0) {
			cachedHashCode = 17 + staticParameterValues.hashCode() + parameterTypes.hashCode();
			if (cachedHashCode == 0) { 
				cachedHashCode = 1;
			}
		}
		return cachedHashCode;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof FunctionSignature) {
			FunctionSignature other = (FunctionSignature) obj;
			return other.staticParameterValues.equals(staticParameterValues) && other.parameterTypes.equals(parameterTypes);
		}
		return false;
	}

	private static class ValueWrapper {
		
		private final IValue value;
		
		public ValueWrapper(IValue value) {
			this.value = value;
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Object#hashCode()
		 */
		@Override
		public int hashCode() {
			int hashCode = ValueWrapper.class.hashCode();
			if (value instanceof INumericValue) {
				hashCode += Double.toString(((ISimpleNumericValue) value).doubleValue()).hashCode();
			}
			return hashCode;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (obj instanceof ValueWrapper) {
				ValueWrapper other = (ValueWrapper) obj;
				IValue otherValue = other.value;
				if (!otherValue.getDataType().isEquivalentTo(value.getDataType())) {
					return false;
				}
				IValue result = otherValue.equalTo(value);
				return result instanceof IBooleanValue && ((IBooleanValue) result).booleanValue();
			}
			return false;
		}
		
	}

	private static class TypeWrapper {
	
		private final Type dataType;

		/**
		 * @param dataType
		 */
		public TypeWrapper(Type dataType) {
			this.dataType = dataType;
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Object#hashCode()
		 */
		@Override
		public int hashCode() {
			return TypeWrapper.class.hashCode();
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof DataType) {
				DataType other = (DataType) obj;
				return other.isEquivalentTo(dataType);
			}
			return false;
		}
		
	}
	
}
