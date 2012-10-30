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

package org.eclipse.damos.mscript.codegen.c.datatype;

import org.eclipse.damos.mscript.codegen.c.ICodeFragment;
import org.eclipse.damos.mscript.codegen.c.ICodeFragmentCollector;
import org.eclipse.damos.mscript.codegen.c.PrimitiveTypeGenerator;
import org.eclipse.damos.mscript.computation.FixedPointFormat;
import org.eclipse.damos.mscript.computation.FloatingPointFormat;
import org.eclipse.damos.mscript.computation.NumberFormat;

/**
 * @author Andreas Unger
 *
 */
public class MachineNumericType extends MachineDataType {

	private final PrimitiveTypeGenerator primitiveTypeGenerator;
	
	private final NumberFormat numberFormat;
	
	/**
	 * @param dataType
	 */
	protected MachineNumericType(PrimitiveTypeGenerator primitiveTypeGenerator, NumberFormat numberFormat) {
		this.primitiveTypeGenerator = primitiveTypeGenerator;
		if (!(numberFormat instanceof FloatingPointFormat || numberFormat instanceof FixedPointFormat)) {
			throw new IllegalArgumentException("Unknown number format " + numberFormat.getClass().getCanonicalName());
		}
		this.numberFormat = numberFormat;
	}
	
	/**
	 * @return the numberFormat
	 */
	public NumberFormat getNumberFormat() {
		return numberFormat;
	}
	
	@Override
	public CharSequence generateDataType(CharSequence variableName, ICodeFragmentCollector codeFragmentCollector, ICodeFragment dependentCodeFragment) {
		StringBuilder sb = new StringBuilder();
		if (numberFormat instanceof FloatingPointFormat) {
			FloatingPointFormat floatingPointFormat = (FloatingPointFormat) numberFormat;
			sb.append(primitiveTypeGenerator.generateFloatingPointType(floatingPointFormat.getKind()));
		} else if (numberFormat instanceof FixedPointFormat) {
			FixedPointFormat fixedPointFormat = (FixedPointFormat) numberFormat;
			sb.append(primitiveTypeGenerator.generateIntegerType(fixedPointFormat.getWordSize()));
		} else {
			// Should not happen since we check it in the constructor
			throw new IllegalArgumentException("Unknown number format " + numberFormat.getClass().getCanonicalName());
		}
		if (variableName != null) {
			sb.append(" ");
			sb.append(variableName);
		}
		return sb;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.mscript.codegen.c.datatypeinfo.DataTypeInfo#hashCode()
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
	 * @see org.eclipse.damos.mscript.codegen.c.datatypeinfo.DataTypeInfo#equals(java.lang.Object)
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
