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

/**
 * @author Andreas Unger
 *
 */
public class MachineBooleanType extends MachineDataType {
	
	/**
	 * 
	 */
	MachineBooleanType() {
	}
	
	@Override
	public CharSequence generateDataType(CharSequence variableName, ICodeFragmentCollector codeFragmentCollector, ICodeFragment dependentCodeFragment) {
		StringBuilder sb = new StringBuilder();
		sb.append("uint_fast8_t");
		if (variableName != null) {
			sb.append(" ");
			sb.append(variableName);
		}
		return sb;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		return obj instanceof MachineBooleanType;
	}
	
}
