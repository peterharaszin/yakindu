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
import org.eclipselabs.mscript.typesystem.util.TypeSystemUtil;

/**
 * @author Andreas Unger
 *
 */
public class InvalidValue implements IValue {
	
	public static final InvalidValue SINGLETON = new InvalidValue();

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.evaluation.IValue#getDataType()
	 */
	public DataType getDataType() {
		return TypeSystemUtil.INVALID_DATA_TYPE;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.evaluation.IValue#add(org.eclipselabs.damos.evaluation.IValue)
	 */
	public IValue add(IValue other) {
		return this;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.evaluation.IValue#subtract(org.eclipselabs.damos.evaluation.IValue)
	 */
	public IValue subtract(IValue other) {
		return this;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.evaluation.IValue#multiply(org.eclipselabs.damos.evaluation.IValue)
	 */
	public IValue multiply(IValue other) {
		return this;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.evaluation.IValue#divide(org.eclipselabs.damos.evaluation.IValue)
	 */
	public IValue divide(IValue other) {
		return this;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.evaluation.IValue#elementWiseMultiply(org.eclipselabs.damos.evaluation.IValue)
	 */
	public IValue elementWiseMultiply(IValue other) {
		return this;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.evaluation.IValue#elementWiseDivide(org.eclipselabs.damos.evaluation.IValue)
	 */
	public IValue elementWiseDivide(IValue other) {
		return this;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.evaluation.IValue#unaryMinus()
	 */
	public IValue unaryMinus() {
		return this;
	}

}
