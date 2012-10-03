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

package org.eclipse.damos.mscript.codegen.c.codefragments;

import org.eclipse.damos.mscript.codegen.c.ICodeFragment;
import org.eclipse.damos.mscript.codegen.c.ICodeFragmentCollector;

/**
 * @author Andreas Unger
 *
 */
public class ConstantStringSegment implements IStringSegment {

	/* (non-Javadoc)
	 * @see org.eclipse.damos.mscript.codegen.c.codefragments.IStringSegment#generateDataType(org.eclipse.damos.mscript.codegen.c.ICodeFragmentCollector, org.eclipse.damos.mscript.codegen.c.ICodeFragment)
	 */
	public CharSequence generateDataType(ICodeFragmentCollector codeFragmentCollector,
			ICodeFragment dependentCodeFragment) {
		return "int ";
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		return obj instanceof ConstantStringSegment;
	}

}
