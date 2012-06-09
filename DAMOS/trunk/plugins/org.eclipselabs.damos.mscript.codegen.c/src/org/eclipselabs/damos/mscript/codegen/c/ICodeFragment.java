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

import java.util.Collection;

import org.eclipse.core.runtime.IProgressMonitor;

/**
 * @author Andreas Unger
 *
 */
public interface ICodeFragment {
	
	int FORWARD_DECLARATION_DEPENDS_ON = 0x01;
	int FORWARD_DECLARATION_REQUIRED_BY = 0x02;
	int IMPLEMENTATION_DEPENDS_ON = 0x04;
	int IMPLEMENTATION_REQUIRED_BY = 0x08;
	
	int DEPENDS_ON = FORWARD_DECLARATION_DEPENDS_ON | IMPLEMENTATION_DEPENDS_ON;
	int REQUIRED_BY = FORWARD_DECLARATION_REQUIRED_BY | IMPLEMENTATION_REQUIRED_BY;
	
	void initialize(ICodeFragmentContext context, IProgressMonitor monitor);

	void addDependency(int kind, IDependencyRule rule);
	
	boolean hasDependency(int kind, ICodeFragment other);
	
	boolean contributesInternalForwardDeclaration();

	Collection<Include> getForwardDeclarationIncludes();
	
	CharSequence generateForwardDeclaration(boolean internal);
	
	boolean contributesImplementation();

	Collection<Include> getImplementationIncludes();
	
	CharSequence generateImplementation(boolean internal);
	
	@Override
	int hashCode();
	
	@Override
	boolean equals(Object obj);
	
	interface IDependencyRule {
		
		boolean applies(ICodeFragment other);
		
	}
	
}
