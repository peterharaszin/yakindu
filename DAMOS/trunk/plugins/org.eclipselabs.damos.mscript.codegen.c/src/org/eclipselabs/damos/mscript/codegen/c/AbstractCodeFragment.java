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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;

/**
 * @author Andreas Unger
 *
 */
public abstract class AbstractCodeFragment implements ICodeFragment {

	private final Collection<Dependency> dependencies = new ArrayList<Dependency>();
	
	public void initialize(IAdaptable context, IProgressMonitor monitor) {
	}
	
	public final void addDependency(int kind, IDependencyRule rule) {
		dependencies.add(new Dependency(kind, rule));
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.codegen.c.ICodeFragment#hasDependency(int, org.eclipselabs.damos.mscript.codegen.c.ICodeFragment)
	 */
	public boolean hasDependency(int kind, ICodeFragment other) {
		for (Dependency dependency : dependencies) {
			if ((dependency.kind & kind) != 0 && dependency.rule.applies(other)) {
				return true;
			}
		}
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
	public Collection<Include> getForwardDeclarationIncludes() {
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
	public Collection<Include> getImplementationIncludes() {
		return Collections.emptyList();
	}
	
	public CharSequence generateImplementation(boolean internal) {
		return "";
	}
	
	private static class Dependency {
		
		private final int kind;
		private final IDependencyRule rule;
		
		/**
		 * 
		 */
		public Dependency(int kind, IDependencyRule rule) {
			this.kind = kind;
			this.rule = rule;
		}
		
	}
	
}
