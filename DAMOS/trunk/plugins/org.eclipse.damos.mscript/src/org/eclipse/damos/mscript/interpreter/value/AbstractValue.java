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

import java.util.List;

import org.eclipse.damos.mscript.InvalidType;
import org.eclipse.damos.mscript.OperatorKind;
import org.eclipse.damos.mscript.Type;
import org.eclipse.damos.mscript.interpreter.IComputationContext;

/**
 * @author Andreas Unger
 *
 */
public abstract class AbstractValue implements IValue {
	
	private IComputationContext context;
	
	/**
	 * 
	 */
	public AbstractValue(IComputationContext context) {
		this.context = context;
	}
	
	/**
	 * @return the context
	 */
	protected IComputationContext getContext() {
		return context;
	}
	
	public IValue convert(Type type) {
		if (type.isEquivalentTo(getDataType())) {
			return this;
		}
		if (type.isAssignableFrom(getDataType())) {
			return doConvert(type);
		}
		return InvalidValue.SINGLETON;
	}
	
	protected IValue doConvert(Type type) {
		return InvalidValue.SINGLETON;		
	}

	public IValue add(IValue other) {
		Type type = getDataType().evaluate(OperatorKind.ADD, other.getDataType());
		if (type instanceof InvalidType) { 
			return InvalidValue.SINGLETON;
		}
		if (other instanceof AnyValue) {
			return new AnyValue(getContext(), type);
		}
		if (other instanceof UninitializedValue || other instanceof InvalidValue) {
			return InvalidValue.SINGLETON;
		}
		return doAdd(other, type);
	}

	/**
	 * @param other
	 * @return
	 */
	protected IValue doAdd(IValue other, Type resultDataType) {
		return InvalidValue.SINGLETON;
	}

	public IValue subtract(IValue other) {
		Type type = getDataType().evaluate(OperatorKind.SUBTRACT, other.getDataType());
		if (type instanceof InvalidType) { 
			return InvalidValue.SINGLETON;
		}
		if (other instanceof AnyValue) {
			return new AnyValue(getContext(), type);
		}
		if (other instanceof UninitializedValue || other instanceof InvalidValue) {
			return InvalidValue.SINGLETON;
		}
		return doSubtract(other, type);
	}
	
	protected IValue doSubtract(IValue other, Type resultDataType) {
		return InvalidValue.SINGLETON;
	}

	public IValue multiply(IValue other) {
		Type type = getDataType().evaluate(OperatorKind.MULTIPLY, other.getDataType());
		if (type instanceof InvalidType) { 
			return InvalidValue.SINGLETON;
		}
		if (other instanceof AnyValue) {
			return new AnyValue(getContext(), type);
		}
		if (other instanceof UninitializedValue || other instanceof InvalidValue) {
			return InvalidValue.SINGLETON;
		}
		return doMultiply(other, type);
	}

	protected IValue doMultiply(IValue other, Type resultDataType) {
		return InvalidValue.SINGLETON;
	}
	
	public IValue divide(IValue other) {
		Type type = getDataType().evaluate(OperatorKind.DIVIDE, other.getDataType());
		if (type instanceof InvalidType) { 
			return InvalidValue.SINGLETON;
		}
		if (other instanceof AnyValue) {
			return new AnyValue(getContext(), type);
		}
		if (other instanceof UninitializedValue || other instanceof InvalidValue) {
			return InvalidValue.SINGLETON;
		}
		return doDivide(other, type);
	}

	protected IValue doDivide(IValue other, Type resultDataType) {
		return InvalidValue.SINGLETON;
	}

	public IValue elementWiseMultiply(IValue other) {
		Type type = getDataType().evaluate(OperatorKind.ELEMENT_WISE_MULTIPLY, other.getDataType());
		if (type instanceof InvalidType) { 
			return InvalidValue.SINGLETON;
		}
		if (other instanceof AnyValue) {
			return new AnyValue(getContext(), type);
		}
		if (other instanceof UninitializedValue || other instanceof InvalidValue) {
			return InvalidValue.SINGLETON;
		}
		return doElementWiseMultiply(other, type);
	}

	protected IValue doElementWiseMultiply(IValue other, Type resultDataType) {
		return InvalidValue.SINGLETON;
	}

	public IValue elementWiseDivide(IValue other) {
		Type type = getDataType().evaluate(OperatorKind.ELEMENT_WISE_DIVIDE, other.getDataType());
		if (type instanceof InvalidType) { 
			return InvalidValue.SINGLETON;
		}
		if (other instanceof AnyValue) {
			return new AnyValue(getContext(), type);
		}
		if (other instanceof UninitializedValue || other instanceof InvalidValue) {
			return InvalidValue.SINGLETON;
		}
		return doElementWiseDivide(other, type);
	}

	protected IValue doElementWiseDivide(IValue other, Type resultDataType) {
		return InvalidValue.SINGLETON;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.mscript.interpreter.value.IValue#modulo(org.eclipse.damos.mscript.interpreter.value.IValue)
	 */
	public IValue modulo(IValue other) {
		Type type = getDataType().evaluate(OperatorKind.MODULO, other.getDataType());
		if (type instanceof InvalidType) { 
			return InvalidValue.SINGLETON;
		}
		if (other instanceof AnyValue) {
			return new AnyValue(getContext(), type);
		}
		if (other instanceof UninitializedValue || other instanceof InvalidValue) {
			return InvalidValue.SINGLETON;
		}
		return doModulo(other, type);
	}

	protected IValue doModulo(IValue other, Type resultDataType) {
		return InvalidValue.SINGLETON;
	}

	public IValue negate() {
		Type type = getDataType().evaluate(OperatorKind.NEGATE, null);
		if (type instanceof InvalidType) { 
			return InvalidValue.SINGLETON;
		}
		return doNegate(type);
	}

	protected IValue doNegate(Type resultDataType) {
		return InvalidValue.SINGLETON;
	}
	
	public IValue power(IValue other) {
		return InvalidValue.SINGLETON;
	}

	public IValue lessThan(IValue other) {
		Type type = getDataType().evaluate(OperatorKind.LESS_THAN, other.getDataType());
		if (type instanceof InvalidType) { 
			return InvalidValue.SINGLETON;
		}
		if (other instanceof AnyValue) {
			return new AnyValue(getContext(), type);
		}
		if (other instanceof UninitializedValue || other instanceof InvalidValue) {
			return InvalidValue.SINGLETON;
		}
		return doLessThan(other, type);
	}

	protected IValue doLessThan(IValue other, Type resultDataType) {
		return InvalidValue.SINGLETON;
	}
	
	public IValue lessThanOrEqualTo(IValue other) {
		Type type = getDataType().evaluate(OperatorKind.LESS_THAN_OR_EQUAL_TO, other.getDataType());
		if (type instanceof InvalidType) { 
			return InvalidValue.SINGLETON;
		}
		if (other instanceof AnyValue) {
			return new AnyValue(getContext(), type);
		}
		if (other instanceof UninitializedValue || other instanceof InvalidValue) {
			return InvalidValue.SINGLETON;
		}
		return doLessThanOrEqualTo(other, type);
	}

	protected IValue doLessThanOrEqualTo(IValue other, Type resultDataType) {
		return InvalidValue.SINGLETON;
	}
	
	public IValue greaterThan(IValue other) {
		Type type = getDataType().evaluate(OperatorKind.GREATER_THAN, other.getDataType());
		if (type instanceof InvalidType) { 
			return InvalidValue.SINGLETON;
		}
		if (other instanceof AnyValue) {
			return new AnyValue(getContext(), type);
		}
		if (other instanceof UninitializedValue || other instanceof InvalidValue) {
			return InvalidValue.SINGLETON;
		}
		return doGreaterThan(other, type);
	}

	protected IValue doGreaterThan(IValue other, Type resultDataType) {
		return InvalidValue.SINGLETON;
	}
	
	public IValue greaterThanOrEqualTo(IValue other) {
		Type type = getDataType().evaluate(OperatorKind.GREATER_THAN_OR_EQUAL_TO, other.getDataType());
		if (type instanceof InvalidType) { 
			return InvalidValue.SINGLETON;
		}
		if (other instanceof AnyValue) {
			return new AnyValue(getContext(), type);
		}
		if (other instanceof UninitializedValue || other instanceof InvalidValue) {
			return InvalidValue.SINGLETON;
		}
		return doGreaterThanOrEqualTo(other, type);
	}

	protected IValue doGreaterThanOrEqualTo(IValue other, Type resultDataType) {
		return InvalidValue.SINGLETON;
	}
	
	public IValue equalTo(IValue other) {
		Type type = getDataType().evaluate(OperatorKind.EQUAL_TO, other.getDataType());
		if (type instanceof InvalidType) { 
			return InvalidValue.SINGLETON;
		}
		if (other instanceof AnyValue) {
			return new AnyValue(getContext(), type);
		}
		if (other instanceof UninitializedValue || other instanceof InvalidValue) {
			return InvalidValue.SINGLETON;
		}
		return doEqualTo(other, type);
	}

	protected IValue doEqualTo(IValue other, Type resultDataType) {
		return InvalidValue.SINGLETON;
	}
	
	public IValue notEqualTo(IValue other) {
		Type type = getDataType().evaluate(OperatorKind.NOT_EQUAL_TO, other.getDataType());
		if (type instanceof InvalidType) { 
			return InvalidValue.SINGLETON;
		}
		if (other instanceof AnyValue) {
			return new AnyValue(getContext(), type);
		}
		if (other instanceof UninitializedValue || other instanceof InvalidValue) {
			return InvalidValue.SINGLETON;
		}
		return doNotEqualTo(other, type);
	}

	protected IValue doNotEqualTo(IValue other, Type resultDataType) {
		return InvalidValue.SINGLETON;
	}
	
	public IValue getProperty(String name, List<IValue> arguments) {
		return null;
	}

}
