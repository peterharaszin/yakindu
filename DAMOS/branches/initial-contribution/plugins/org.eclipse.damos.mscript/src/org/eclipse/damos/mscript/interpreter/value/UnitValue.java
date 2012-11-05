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

import org.eclipse.damos.mscript.OperatorKind;
import org.eclipse.damos.mscript.Type;
import org.eclipse.damos.mscript.Unit;
import org.eclipse.damos.mscript.interpreter.IComputationContext;
import org.eclipse.damos.mscript.util.TypeUtil;


/**
 * @author Andreas Unger
 *
 */
public class UnitValue extends AbstractValue {

	private Unit value;
	
	/**
	 * 
	 */
	public UnitValue(IComputationContext context, Unit value) {
		super(context);
		this.value = value;
	}
	
	/**
	 * @return the value
	 */
	public Unit getValue() {
		return value;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.mscript.execution.value.IValue#getDataType()
	 */
	public Type getDataType() {
		return TypeUtil.UNIT_TYPE;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.mscript.interpreter.value.AbstractValue#doConvert(org.eclipse.damos.mscript.typesystem.DataType)
	 */
	@Override
	protected IValue doConvert(Type type) {
		return this;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.mscript.interpreter.value.AbstractValue#doMultiply(org.eclipse.damos.mscript.interpreter.value.IValue, org.eclipse.damos.mscript.typesystem.DataType)
	 */
	@Override
	protected IValue doMultiply(IValue other, Type resultDataType) {
		if (other instanceof UnitValue) {
			return new UnitValue(getContext(), value.evaluate(OperatorKind.MULTIPLY, ((UnitValue) other).value));
		}
		return InvalidValue.SINGLETON;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.mscript.interpreter.value.AbstractValue#doDivide(org.eclipse.damos.mscript.interpreter.value.IValue, org.eclipse.damos.mscript.typesystem.DataType)
	 */
	@Override
	protected IValue doDivide(IValue other, Type resultDataType) {
		if (other instanceof UnitValue) {
			return new UnitValue(getContext(), value.evaluate(OperatorKind.DIVIDE, ((UnitValue) other).value));
		}
		return InvalidValue.SINGLETON;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.mscript.interpreter.value.AbstractValue#doEqualTo(org.eclipse.damos.mscript.interpreter.value.IValue, org.eclipse.damos.mscript.typesystem.DataType)
	 */
	@Override
	protected IValue doEqualTo(IValue other, Type resultDataType) {
		UnitValue otherUnitValue = (UnitValue) other;
		if (value == null && otherUnitValue.value == null) {
			return new BooleanValue(getContext(), true);
		}
		if (value == null || otherUnitValue == null) {
			return new BooleanValue(getContext(), false);
		}
		return new BooleanValue(getContext(), value.isEquivalentTo(otherUnitValue.value, false));
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.mscript.interpreter.value.AbstractValue#doNotEqualTo(org.eclipse.damos.mscript.interpreter.value.IValue, org.eclipse.damos.mscript.typesystem.DataType)
	 */
	@Override
	protected IValue doNotEqualTo(IValue other, Type resultDataType) {
		UnitValue otherUnitValue = (UnitValue) other;
		if (value == null && otherUnitValue.value == null) {
			return new BooleanValue(getContext(), false);
		}
		if (value == null || otherUnitValue == null) {
			return new BooleanValue(getContext(), true);
		}
		return new BooleanValue(getContext(), !value.isEquivalentTo(otherUnitValue.value, false));
	}
	
}
