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

/**
 * @author Andreas Unger
 *
 */
public class CModuleEntry {

	public enum Visibility {
		PRIVATE,
		PUBLIC
	}
	
	private final CModule module;
	private final ICodeFragment codeFragment;
	private Visibility visibility;
	
	/**
	 * 
	 */
	public CModuleEntry(CModule module, ICodeFragment codeFragment, Visibility visibility) {
		this.module = module;
		this.codeFragment = codeFragment;
		this.visibility = visibility;
	}
	
	/**
	 * @return the codeFragment
	 */
	public ICodeFragment getCodeFragment() {
		return codeFragment;
	}
	
	/**
	 * @return the visibility
	 */
	public Visibility getVisibility() {
		return visibility;
	}
	
	/**
	 * @param visibility the visibility to set
	 */
	public void setVisibility(Visibility visibility) {
		this.visibility = visibility;
	}
	
	public boolean isInternal() {
		if (visibility != Visibility.PRIVATE) {
			return false;
		}
		for (CModule otherModule : module.getModuleSet().getModules()) {
			if (otherModule != module) {
				for (CModuleEntry otherEntry : otherModule.getEntries()) {
					if (otherEntry.codeFragment.forwardDeclarationDependsOn(codeFragment)
							|| codeFragment.forwardDeclarationRequiredBy(otherEntry.codeFragment)
							|| otherEntry.codeFragment.implementationDependsOn(codeFragment)
							|| codeFragment.implementationRequiredBy(otherEntry.codeFragment)) {
						return false;
					}
				}
			}
			for (CModuleEntry otherEntry : otherModule.getEntries()) {
				if ((otherEntry.codeFragment.forwardDeclarationDependsOn(codeFragment) || codeFragment.forwardDeclarationRequiredBy(otherEntry.codeFragment)) && !otherEntry.isInternal()) {
					return false;
				}
			}
		}
		return true;
	}

}
