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

package org.eclipselabs.damos.codegen.c;

import java.util.Collection;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipselabs.damos.mscript.codegen.c.Include;

/**
 * @author Andreas Unger
 *
 * @noextend
 * @noimplement This interface is <em>not</em> intended to be implemented by
 * clients. Clients should extend {@link AbstractComponentGenerator}.
 */
public interface IComponentGenerator {

	void initialize(IComponentGeneratorContext context, IProgressMonitor monitor) throws CoreException;
	
	IComponentGeneratorContext getContext();
	
	boolean contributesContextCode();
	
	Collection<Include> getContextCodeIncludes();
	
	CharSequence getContextTypeName();
	
	CharSequence generateContextCode(String typeName, IProgressMonitor monitor);

	boolean contributesInitializationCode();
	
	Collection<Include> getInitializationCodeIncludes();

	CharSequence generateInitializationCode(IProgressMonitor monitor);
	
	boolean contributesComputeOutputsCode();

	Collection<Include> getComputeOutputsCodeIncludes();

	CharSequence generateComputeOutputsCode(IProgressMonitor monitor);

	boolean contributesUpdateCode();

	Collection<Include> getUpdateCodeIncludes();

	CharSequence generateUpdateCode(IProgressMonitor monitor);

}
