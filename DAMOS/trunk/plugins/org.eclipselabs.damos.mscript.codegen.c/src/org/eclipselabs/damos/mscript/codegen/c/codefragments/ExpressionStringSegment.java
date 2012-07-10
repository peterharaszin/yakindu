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

package org.eclipselabs.damos.mscript.codegen.c.codefragments;

import org.eclipselabs.damos.mscript.codegen.c.ICodeFragment;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentCollector;
import org.eclipselabs.damos.mscript.codegen.c.datatype.MachineDataType;
import org.eclipselabs.damos.mscript.codegen.c.datatype.MachineStringType;

/**
 * @author Andreas Unger
 *
 */
public class ExpressionStringSegment implements IStringSegment {

	private final boolean static_;
	private final MachineDataType dataType;
	
	/**
	 * 
	 */
	public ExpressionStringSegment(boolean static_, MachineDataType dataType) {
		this.static_ = static_;
		this.dataType = dataType;
	}
	
	/**
	 * @return the static_
	 */
	public boolean isStatic_() {
		return static_;
	}
	
	/**
	 * @return the dataType
	 */
	public MachineDataType getDataType() {
		return dataType;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.codegen.c.codefragments.IStringSegment#generateDataType(org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentCollector, org.eclipselabs.damos.mscript.codegen.c.ICodeFragment)
	 */
	public CharSequence generateDataType(ICodeFragmentCollector codeFragmentCollector,
			ICodeFragment dependentCodeFragment) {
		if (static_) {
			return "int ";
		}
		if (dataType instanceof MachineStringType) {
			return "const char *";
		}
		return dataType.generateDataType(codeFragmentCollector, dependentCodeFragment) + " ";
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return getClass().hashCode() ^ dataType.hashCode() ^ (static_ ? 1 : 0);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ExpressionStringSegment) {
			ExpressionStringSegment other = (ExpressionStringSegment) obj;
			return other.static_ == static_ && other.dataType.equals(dataType);
		}
		return false;
	}
	
}
