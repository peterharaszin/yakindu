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

package org.eclipse.damos.mscript.codegen.c;

import static org.eclipse.damos.mscript.codegen.c.ICodeFragment.DEPENDS_ON;
import static org.eclipse.damos.mscript.codegen.c.ICodeFragment.FORWARD_DECLARATION_DEPENDS_ON;
import static org.eclipse.damos.mscript.codegen.c.ICodeFragment.REQUIRED_BY;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;

import org.eclipse.damos.mscript.codegen.c.CModuleEntry.Visibility;

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
	 * @return the headerComment
	 */
	public String getHeaderComment() {
		return headerComment;
	}
	
	/**
	 * @param headerComment the headerComment to set
	 */
	public void setHeaderComment(String headerComment) {
		this.headerComment = headerComment;
	}
	
	/**
	 * @return the sourceComment
	 */
	public String getSourceComment() {
		return sourceComment;
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
