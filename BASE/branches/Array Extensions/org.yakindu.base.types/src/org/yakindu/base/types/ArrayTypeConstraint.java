package org.yakindu.base.types;

import org.yakindu.base.types.impl.TypeConstraintImpl;

public class ArrayTypeConstraint extends TypeConstraintImpl {

	Object value;

	@Override
	public Object getValue() {
		return this.value;
	}

	@Override
	public void setValue(Object value) {
		this.value = value;
	}

}
