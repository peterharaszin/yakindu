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

import static org.eclipse.damos.mscript.codegen.c.ICodeFragment.FORWARD_DECLARATION_DEPENDS_ON;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.damos.mscript.codegen.c.ICodeFragment;
import org.eclipse.damos.mscript.codegen.c.ICodeFragment.IDependencyRule;
import org.eclipse.damos.mscript.codegen.c.ICodeFragmentCollector;
import org.eclipse.damos.mscript.codegen.c.codefragments.StringTypeDeclaration;

/**
 * @author Andreas Unger
 *
 */
public class MachineStringType extends MachineDataType {
	
	private final int stringBufferSize;
	
	/**
	 * 
	 */
	MachineStringType(int stringBufferSize) {
		this.stringBufferSize = stringBufferSize;
	}
	
	@Override
	public CharSequence generateDataType(CharSequence variableName, ICodeFragmentCollector codeFragmentCollector, ICodeFragment dependentCodeFragment) {
		final StringTypeDeclaration codeFragment = (StringTypeDeclaration) codeFragmentCollector
				.addCodeFragment(new StringTypeDeclaration(stringBufferSize),
						new NullProgressMonitor());
		if (dependentCodeFragment != null) {
			dependentCodeFragment.addDependency(FORWARD_DECLARATION_DEPENDS_ON, new IDependencyRule() {
				
				public boolean applies(ICodeFragment other) {
					return other == codeFragment;
				}
				
			});
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(codeFragment.getName());
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
		return obj instanceof MachineStringType;
	}
	
}
