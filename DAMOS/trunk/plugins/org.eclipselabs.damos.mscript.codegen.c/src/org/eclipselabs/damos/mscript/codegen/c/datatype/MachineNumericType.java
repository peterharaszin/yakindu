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

package org.eclipselabs.damos.mscript.codegen.c.datatype;

import org.eclipselabs.damos.mscript.codegen.c.ICodeFragment;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentCollector;
import org.eclipselabs.damos.mscript.computationmodel.ComputationModel;
import org.eclipselabs.damos.mscript.computationmodel.FixedPointFormat;
import org.eclipselabs.damos.mscript.computationmodel.FloatingPointFormat;
import org.eclipselabs.damos.mscript.computationmodel.NumberFormat;

/**
 * @author Andreas Unger
 *
 */
public class MachineNumericType extends MachineDataType {

	private final NumberFormat numberFormat;
	
	/**
	 * @param dataType
	 */
	MachineNumericType(NumberFormat numberFormat) {
		if (!(numberFormat instanceof FloatingPointFormat || numberFormat instanceof FixedPointFormat)) {
			throw new IllegalArgumentException("Unknown number format " + numberFormat.getClass().getCanonicalName());
		}
		this.numberFormat = numberFormat;
	}
	
	@Override
	public String getCDataType(ComputationModel computationModel, ICodeFragmentCollector codeFragmentCollector, ICodeFragment dependentCodeFragment) {
		if (numberFormat instanceof FloatingPointFormat) {
			FloatingPointFormat floatingPointFormat = (FloatingPointFormat) numberFormat;
			switch (floatingPointFormat.getKind()) {
			case BINARY32:
				return "float";
			case BINARY64:
				return "double";
			default:
				// Do nothing
				break;
			}
		} else if (numberFormat instanceof FixedPointFormat) {
			FixedPointFormat fixedPointFormat = (FixedPointFormat) numberFormat;
			return String.format("int%d_t", fixedPointFormat.getWordSize());
		}
		// Should not happen since we check it in the constructor
		throw new IllegalArgumentException("Unknown number format " + numberFormat.getClass().getCanonicalName());
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.codegen.c.datatypeinfo.DataTypeInfo#hashCode()
	 */
	@Override
	public int hashCode() {
		int hashCode = super.hashCode();
		if (numberFormat instanceof FloatingPointFormat) {
			FloatingPointFormat floatingPointFormat = (FloatingPointFormat) numberFormat;
			hashCode ^= floatingPointFormat.getKind().getValue();
		} else if (numberFormat instanceof FixedPointFormat) {
			FixedPointFormat fixedPointFormat = (FixedPointFormat) numberFormat;
			hashCode ^= fixedPointFormat.getIntegerLength() ^ fixedPointFormat.getFractionLength();
		}
		return hashCode;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.codegen.c.datatypeinfo.DataTypeInfo#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof MachineNumericType) {
			MachineNumericType other = (MachineNumericType) obj;
			return other.numberFormat.isEquivalentTo(numberFormat);
		}
		return false;
	}

}
