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

import static org.eclipselabs.damos.mscript.codegen.c.ICodeFragment.DEPENDS_ON;
import static org.eclipselabs.damos.mscript.codegen.c.ICodeFragment.FORWARD_DECLARATION_DEPENDS_ON;
import static org.eclipselabs.damos.mscript.codegen.c.ICodeFragment.REQUIRED_BY;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import org.eclipselabs.damos.common.util.PrintAppendable;
import org.eclipselabs.damos.mscript.codegen.c.CModuleEntry.Visibility;

/**
 * @author Andreas Unger
 *
 */
public class CModule {

	private CModuleSet moduleSet;
	private String name;
	private String headerComment;
	private String sourceComment;
	private Collection<CModuleEntry> entries = new ArrayList<CModuleEntry>();
	
	/**
	 * 
	 */
	CModule(CModuleSet moduleSet, String name) {
		this.moduleSet = moduleSet;
		this.name = name;
	}
	
	/**
	 * @return the moduleSet
	 */
	public CModuleSet getModuleSet() {
		return moduleSet;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	public void setComment(String comment) {
		setHeaderComment(comment);
		setSourceComment(comment);
	}
	
	/**
	 * @param headerComment the headerComment to set
	 */
	public void setHeaderComment(String headerComment) {
		this.headerComment = headerComment;
	}
	
	/**
	 * @param sourceComment the sourceComment to set
	 */
	public void setSourceComment(String sourceComment) {
		this.sourceComment = sourceComment;
	}
	
	public void addEntry(ICodeFragment codeFragment, Visibility visibility) {
		entries.add(new CModuleEntry(this, codeFragment, visibility));
	}
	
	/**
	 * @return the entries
	 */
	public Collection<CModuleEntry> getEntries() {
		return entries;
	}
	
	public void writeHeader(Appendable appendable) throws IOException {
		PrintAppendable out = new PrintAppendable(appendable);

		if (headerComment != null) {
			out.println(headerComment);
		}

		String headerMacro = name.replaceAll("\\W", "_").toUpperCase() + "_H_";
		out.printf("#ifndef %s\n", headerMacro);
		out.printf("#define %s\n", headerMacro);
		out.println();
		
		// Add external forward declaration includes
		Set<Include> includes = new TreeSet<Include>();
		for (CModuleEntry entry : entries) {
			if (!entry.isInternal()) {
				for (Include include : entry.getCodeFragment().getForwardDeclarationIncludes()) {
					includes.add(include);
				}
			}
		}
		
		for (Include include : includes) {
			out.println(include.toString());
		}
		
		if (!includes.isEmpty()) {
			out.println();
		}
		
		out.println("#ifdef __cplusplus");
		out.println("extern \"C\" {");
		out.println("#endif /* __cplusplus */");
		out.println();
		
		// Write external forward declarations
		for (CModuleEntry entry : entries) {
			if (!entry.isInternal()) {
				out.print(entry.getCodeFragment().generateForwardDeclaration(false));
				out.println();
			}
		}
		
		out.println("#ifdef __cplusplus");
		out.println("}");
		out.println("#endif /* __cplusplus */");
		out.println();
		out.printf("#endif /* %s */\n", headerMacro);
	}
	
	public void writeSource(Appendable appendable) throws IOException {
		PrintAppendable out = new PrintAppendable(appendable);

		if (sourceComment != null) {
			out.println(sourceComment);
		}
		
		// Add internal forward declaration includes
		Set<Include> includes = new TreeSet<Include>();
		
		for (CModuleEntry entry : entries) {
			ICodeFragment codeFragment = entry.getCodeFragment();
			if (entry.isInternal() && codeFragment.contributesInternalForwardDeclaration()) {
				for (Include include : codeFragment.getForwardDeclarationIncludes()) {
					includes.add(include);
				}
			}
		}

		// Add implementation includes
		for (CModuleEntry entry : entries) {
			for (Include include : entry.getCodeFragment().getImplementationIncludes()) {
				includes.add(include);
			}
		}
		
		for (Include include : includes) {
			out.println(include.toString());
		}

		if (!includes.isEmpty()) {
			out.println();
		}
		
		out.printf("#include \"%s.h\"\n", name);
		
		for (CModule otherModule : moduleSet.getModules()) {
			if (otherModule != this && dependsOn(otherModule)) {
				out.printf("#include \"%s.h\"\n", otherModule.getName());
			}
		}
		
		out.println();

		// Write internal forward declarations
		for (CModuleEntry entry : entries) {
			ICodeFragment codeFragment = entry.getCodeFragment();
			if (entry.isInternal() && codeFragment.contributesInternalForwardDeclaration()) {
				out.print(codeFragment.generateForwardDeclaration(true));
				out.println();
			}
		}

		// Write implementations which do not contribute forward declarations first
		for (CModuleEntry entry : entries) {
			ICodeFragment codeFragment = entry.getCodeFragment();
			if (codeFragment.contributesImplementation() && !codeFragment.contributesInternalForwardDeclaration()) {
				out.print(codeFragment.generateImplementation(entry.isInternal()));
				out.println();
			}
		}

		for (CModuleEntry entry : entries) {
			ICodeFragment codeFragment = entry.getCodeFragment();
			if (codeFragment.contributesImplementation() && codeFragment.contributesInternalForwardDeclaration()) {
				out.print(codeFragment.generateImplementation(entry.isInternal()));
				out.println();
			}
		}
	}

	public boolean isPrivate() {
		for (CModuleEntry entry : entries) {
			if (entry.getVisibility() != Visibility.PRIVATE) {
				return false;
			}
		}
		return true;
	}
	
	public boolean dependsOn(CModule other) {
		for (CModuleEntry entry : entries) {
			for (CModuleEntry otherEntry : other.entries) {
				if (entry.getCodeFragment().hasDependency(FORWARD_DECLARATION_DEPENDS_ON, otherEntry.getCodeFragment())) {
					return true;
				}
			}
		}
		return false;
	}
	
	void resolveEntries() {
		Collection<CModuleEntry> allResolvedEntries = new ArrayList<CModuleEntry>();
		Collection<CModuleEntry> backlog = new LinkedHashSet<CModuleEntry>(entries);
		while (!backlog.isEmpty()) {
			Collection<CModuleEntry> resolvedEntries = new LinkedHashSet<CModuleEntry>();
			resolveDependencies(backlog, backlog.iterator().next(), resolvedEntries, new HashSet<CModuleEntry>());
			backlog.removeAll(resolvedEntries);
			allResolvedEntries.addAll(resolvedEntries);
		}
		entries = allResolvedEntries;
	}
	
	private void resolveDependencies(Collection<CModuleEntry> backlog, CModuleEntry nextEntry, Collection<CModuleEntry> resolvedEntries, Collection<CModuleEntry> unresolvedEntries) {
		unresolvedEntries.add(nextEntry);
		for (CModuleEntry entry : backlog) {
			if (!resolvedEntries.contains(entry) && (nextEntry.getCodeFragment().hasDependency(DEPENDS_ON, entry.getCodeFragment())
					|| entry.getCodeFragment().hasDependency(REQUIRED_BY, nextEntry.getCodeFragment()))) {
				if (unresolvedEntries.contains(entry)) {
					throw new IllegalStateException("Circular dependency encountered");
				}
				resolveDependencies(backlog, entry, resolvedEntries, unresolvedEntries);
			}
		}
		resolvedEntries.add(nextEntry);
		unresolvedEntries.remove(nextEntry);
	}

}
