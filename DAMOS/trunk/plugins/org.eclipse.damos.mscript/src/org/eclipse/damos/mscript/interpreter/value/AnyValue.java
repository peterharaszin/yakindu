/****************************************************************************
 * Copyright (c) 2008, 2010 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipse.damos.mscript.interpreter.value;

import org.eclipse.damos.mscript.Type;
import org.eclipse.damos.mscript.interpreter.IComputationContext;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * @author Andreas Unger
 *
 */
public class AnyValue extends AbstractExplicitDataTypeValue {

	/**
	 * @param type
	 */
	public AnyValue(IComputationContext context, Type type) {
		super(context, type);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.mscript.interpreter.value.AbstractValue#doConvert(org.eclipse.damos.mscript.typesystem.DataType)
	 */
	@Override
	protected IValue doConvert(Type type) {
		return new AnyValue(getContext(), EcoreUtil.copy(type));
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.mscript.interpreter.value.AbstractValue#doAdd(org.eclipse.damos.mscript.interpreter.value.IValue, org.eclipse.damos.mscript.typesystem.DataType)
	 */
	@Override
	protected IValue doAdd(IValue other, Type resultDataType) {
		return new AnyValue(getContext(), resultDataType);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.mscript.interpreter.value.AbstractValue#doSubtract(org.eclipse.damos.mscript.interpreter.value.IValue, org.eclipse.damos.mscript.typesystem.DataType)
	 */
	@Override
	protected IValue doSubtract(IValue other, Type resultDataType) {
		return new AnyValue(getContext(), resultDataType);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.mscript.interpreter.value.AbstractValue#doMultiply(org.eclipse.damos.mscript.interpreter.value.IValue, org.eclipse.damos.mscript.typesystem.DataType)
	 */
	@Override
	protected IValue doMultiply(IValue other, Type resultDataType) {
		return new AnyValue(getContext(), resultDataType);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.mscript.interpreter.value.AbstractValue#doDivide(org.eclipse.damos.mscript.interpreter.value.IValue, org.eclipse.damos.mscript.typesystem.DataType)
	 */
	@Override
	protected IValue doDivide(IValue other, Type resultDataType) {
		return new AnyValue(getContext(), resultDataType);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.mscript.interpreter.value.AbstractValue#doElementWiseMultiply(org.eclipse.damos.mscript.interpreter.value.IValue, org.eclipse.damos.mscript.typesystem.DataType)
	 */
	@Override
	protected IValue doElementWiseMultiply(IValue other, Type resultDataType) {
		return new AnyValue(getContext(), resultDataType);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.mscript.interpreter.value.AbstractValue#doElementWiseDivide(org.eclipse.damos.mscript.interpreter.value.IValue, org.eclipse.damos.mscript.typesystem.DataType)
	 */
	@Override
	protected IValue doElementWiseDivide(IValue other, Type resultDataType) {
		return new AnyValue(getContext(), resultDataType);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.mscript.interpreter.value.AbstractValue#doModulo(org.eclipse.damos.mscript.interpreter.value.IValue, org.eclipse.damos.mscript.DataType)
	 */
	@Override
	protected IValue doModulo(IValue other, Type resultDataType) {
		return new AnyValue(getContext(), resultDataType);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.mscript.interpreter.value.AbstractValue#doNegate(org.eclipse.damos.mscript.typesystem.DataType)
	 */
	@Override
	protected IValue doNegate(Type resultDataType) {
		return new AnyValue(getContext(), resultDataType);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.mscript.interpreter.value.AbstractValue#doLessThan(org.eclipse.damos.mscript.interpreter.value.IValue, org.eclipse.damos.mscript.typesystem.DataType)
	 */
	@Override
	protected IValue doLessThan(IValue other, Type resultDataType) {
		return new AnyValue(getContext(), resultDataType);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.mscript.interpreter.value.AbstractValue#doLessThanOrEqualTo(org.eclipse.damos.mscript.interpreter.value.IValue, org.eclipse.damos.mscript.typesystem.DataType)
	 */
	@Override
	protected IValue doLessThanOrEqualTo(IValue other, Type resultDataType) {
		return new AnyValue(getContext(), resultDataType);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.mscript.interpreter.value.AbstractValue#doGreaterThan(org.eclipse.damos.mscript.interpreter.value.IValue, org.eclipse.damos.mscript.typesystem.DataType)
	 */
	@Override
	protected IValue doGreaterThan(IValue other, Type resultDataType) {
		return new AnyValue(getContext(), resultDataType);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.mscript.interpreter.value.AbstractValue#doGreaterThanOrEqualTo(org.eclipse.damos.mscript.interpreter.value.IValue, org.eclipse.damos.mscript.typesystem.DataType)
	 */
	@Override
	protected IValue doGreaterThanOrEqualTo(IValue other, Type resultDataType) {
		return new AnyValue(getContext(), resultDataType);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.mscript.interpreter.value.AbstractValue#doEqualTo(org.eclipse.damos.mscript.interpreter.value.IValue, org.eclipse.damos.mscript.typesystem.DataType)
	 */
	@Override
	protected IValue doEqualTo(IValue other, Type resultDataType) {
		return new AnyValue(getContext(), resultDataType);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.mscript.interpreter.value.AbstractValue#doNotEqualTo(org.eclipse.damos.mscript.interpreter.value.IValue, org.eclipse.damos.mscript.typesystem.DataType)
	 */
	@Override
	protected IValue doNotEqualTo(IValue other, Type resultDataType) {
		return new AnyValue(getContext(), resultDataType);
	}

}
