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

package org.eclipselabs.damos.mscript.codegen.c;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;

/**
 * @author Andreas Unger
 *
 */
public abstract class AbstractCodeFragment implements ICodeFragment {

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.codegen.c.ICodeFragment#initialize(org.eclipse.core.runtime.IAdaptable, org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void initialize(IAdaptable context, IProgressMonitor monitor) throws IOException {
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.codegen.c.ICodeFragment#dependsOn(org.eclipselabs.damos.mscript.codegen.c.ICodeFragment)
	 */
	public boolean dependsOn(ICodeFragment other) {
		return false;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.codegen.c.ICodeFragment#contributesInternalForwardDeclaration()
	 */
	public boolean contributesInternalForwardDeclaration() {
		return true;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.codegen.c.ICodeFragment#getIncludes()
	 */
	public Collection<String> getForwardDeclarationIncludes() {
		return Collections.emptyList();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.codegen.c.ICodeFragment#contributesImplementation()
	 */
	public boolean contributesImplementation() {
		return false;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.codegen.c.ICodeFragment#getImplementationIncludes()
	 */
	public Collection<String> getImplementationIncludes() {
		return Collections.emptyList();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.codegen.c.ICodeFragment#writeImplementation(java.lang.Appendable, boolean)
	 */
	public void writeImplementation(Appendable appendable, boolean internal) throws IOException {
	}
	
}
