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
import java.util.Set;
import java.util.TreeSet;

import org.eclipselabs.damos.common.util.PrintAppendable;

/**
 * @author Andreas Unger
 *
 */
public class CSourceGenerator implements ICModuleGenerator {

	public CharSequence generate(CModule module) {
		StringBuilder sb = new StringBuilder();
		PrintAppendable out = new PrintAppendable(sb);

		if (module.getSourceComment() != null) {
			out.println(module.getSourceComment());
		}
		
		Collection<Include> includes = getIncludes(module);
		
		for (Include include : includes) {
			out.println(include.toString());
		}

		if (!includes.isEmpty()) {
			out.println();
		}
		
		out.printf("#include \"%s.h\"\n", module.getName());
		
		for (CModule otherModule : module.getModuleSet().getModules()) {
			if (otherModule != module && module.dependsOn(otherModule)) {
				out.printf("#include \"%s.h\"\n", otherModule.getName());
			}
		}
		
		out.println();

		// Write internal forward declarations
		for (CModuleEntry entry : module.getEntries()) {
			ICodeFragment codeFragment = entry.getCodeFragment();
			if (entry.isInternal() && codeFragment.contributesInternalForwardDeclaration()) {
				out.print(codeFragment.generateForwardDeclaration(true));
				out.println();
			}
		}

		// Write implementations which do not contribute forward declarations first
		for (CModuleEntry entry : module.getEntries()) {
			ICodeFragment codeFragment = entry.getCodeFragment();
			if (codeFragment.contributesImplementation() && !codeFragment.contributesInternalForwardDeclaration()) {
				out.print(codeFragment.generateImplementation(entry.isInternal()));
				out.println();
			}
		}

		for (CModuleEntry entry : module.getEntries()) {
			ICodeFragment codeFragment = entry.getCodeFragment();
			if (codeFragment.contributesImplementation() && codeFragment.contributesInternalForwardDeclaration()) {
				out.print(codeFragment.generateImplementation(entry.isInternal()));
				out.println();
			}
		}
		
		return sb;
	}

	/**
	 * @param module
	 * @return
	 */
	private Collection<Include> getIncludes(CModule module) {
		// Add internal forward declaration includes
		Set<Include> includes = new TreeSet<Include>();
		for (CModuleEntry entry : module.getEntries()) {
			ICodeFragment codeFragment = entry.getCodeFragment();
			if (entry.isInternal() && codeFragment.contributesInternalForwardDeclaration()) {
				for (Include include : codeFragment.getForwardDeclarationIncludes()) {
					includes.add(include);
				}
			}
		}

		// Add implementation includes
		for (CModuleEntry entry : module.getEntries()) {
			for (Include include : entry.getCodeFragment().getImplementationIncludes()) {
				includes.add(include);
			}
		}
		return includes;
	}

}
