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

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;

/**
 * @author Andreas Unger
 *
 */
public interface ICodeFragment {
	
	void initialize(IAdaptable context, IProgressMonitor monitor) throws IOException;

	boolean dependsOn(ICodeFragment other);
	
	boolean contributesInternalForwardDeclaration();

	Collection<String> getForwardDeclarationIncludes();
	
	void writeForwardDeclaration(Appendable appendable, boolean internal) throws IOException;
	
	boolean contributesImplementation();

	Collection<String> getImplementationIncludes();
	
	void writeImplementation(Appendable appendable, boolean internal) throws IOException;
	
	@Override
	int hashCode();
	
	@Override
	boolean equals(Object obj);
	
}
