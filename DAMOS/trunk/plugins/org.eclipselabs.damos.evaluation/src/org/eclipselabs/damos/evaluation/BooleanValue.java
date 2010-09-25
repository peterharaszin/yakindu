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

package org.eclipselabs.damos.evaluation;

import org.eclipselabs.mscript.typesystem.DataType;

/**
 * @author Andreas Unger
 *
 */
public class BooleanValue extends AbstractValue {
	
	private boolean value;

	/**
	 * 
	 */
	public BooleanValue(DataType dataType, boolean value) {
		super(dataType);
		this.value = value;
	}
	
	public boolean booleanValue() {
		return value;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.evaluation.IValue#add(org.eclipselabs.damos.evaluation.IValue)
	 */
	public IValue add(IValue other) {
		return InvalidValue.SINGLETON;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.evaluation.IValue#subtract(org.eclipselabs.damos.evaluation.IValue)
	 */
	public IValue subtract(IValue other) {
		return InvalidValue.SINGLETON;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.evaluation.IValue#multiply(org.eclipselabs.damos.evaluation.IValue)
	 */
	public IValue multiply(IValue other) {
		return InvalidValue.SINGLETON;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.evaluation.IValue#divide(org.eclipselabs.damos.evaluation.IValue)
	 */
	public IValue divide(IValue other) {
		return InvalidValue.SINGLETON;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.evaluation.IValue#elementWiseMultiply(org.eclipselabs.damos.evaluation.IValue)
	 */
	public IValue elementWiseMultiply(IValue other) {
		return InvalidValue.SINGLETON;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.evaluation.IValue#elementWiseDivide(org.eclipselabs.damos.evaluation.IValue)
	 */
	public IValue elementWiseDivide(IValue other) {
		return InvalidValue.SINGLETON;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.evaluation.IValue#unaryMinus()
	 */
	public IValue unaryMinus() {
		return InvalidValue.SINGLETON;
	}

}
