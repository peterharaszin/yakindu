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
public class Include implements Comparable<Include> {

	private final String name;
	private final boolean systemInclude;
	
	public Include(String name) {
		this(name, true);
	}
	
	public Include(String name, boolean systemInclude) {
		if (name == null) {
			throw new NullPointerException();
		}
		this.name = name;
		this.systemInclude = systemInclude;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return the systemInclude
	 */
	public boolean isSystemInclude() {
		return systemInclude;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Include o) {
		if (systemInclude && !o.systemInclude) {
			return -1;
		}
		if (!systemInclude && o.systemInclude) {
			return 1;
		}
		return name.compareTo(o.name);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return name.hashCode() ^ (systemInclude ? 1 : 0);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Include) {
			Include other = (Include) obj;
			return other.name.equals(name) && other.systemInclude == systemInclude;
		}
		return false;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("#include ");
		sb.append(systemInclude ? "<" : "\"");
		sb.append(name);
		sb.append(systemInclude ? ">" : "\"");
		return sb.toString();
	}
	
}
