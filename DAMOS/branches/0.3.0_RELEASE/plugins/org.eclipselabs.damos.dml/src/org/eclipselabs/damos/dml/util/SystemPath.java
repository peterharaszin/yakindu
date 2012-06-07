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

package org.eclipselabs.damos.dml.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.Fragment;
import org.eclipselabs.damos.dml.Subsystem;

/**
 * @author Andreas Unger
 *
 */
public final class SystemPath {

	private final Fragment contextFragment;
	private final List<Subsystem> subsystems;
	private final Component component;
	
	private SystemPath(Fragment contextFragment) {
		this(contextFragment, Collections.<Subsystem>emptyList());
	}
	
	private SystemPath(Fragment contextFragment, List<Subsystem> subsystems) {
		this(contextFragment, subsystems, null);
	}
	
	private SystemPath(Fragment contextFragment, List<Subsystem> subsystems, Component component) {
		this.contextFragment = contextFragment;
		this.subsystems = subsystems;
		this.component = component;
	}
	
	public static SystemPath create(Fragment contextFragment) {
		if (contextFragment == null) {
			throw new NullPointerException();
		}
		return new SystemPath(contextFragment, Collections.<Subsystem>emptyList());
	}

	public static SystemPath create(Fragment contextFragment, List<Subsystem> subsystems) {
		if (contextFragment == null || subsystems == null) {
			throw new NullPointerException();
		}
		return new SystemPath(contextFragment, Collections.unmodifiableList(new ArrayList<Subsystem>(subsystems)));
	}

	public static SystemPath create(Fragment contextFragment, List<Subsystem> subsystems, Component component) {
		if (contextFragment == null || subsystems == null) {
			throw new NullPointerException();
		}
		return new SystemPath(contextFragment, Collections.unmodifiableList(new ArrayList<Subsystem>(subsystems)), component);
	}

	/**
	 * @return the contextFragment
	 */
	public Fragment getContextFragment() {
		return contextFragment;
	}
	
	public List<Subsystem> getSubsystems() {
		return subsystems;
	}
	
	/**
	 * @return the component
	 */
	public Component getComponent() {
		return component;
	}
	
	public boolean isRoot() {
		return subsystems.isEmpty();
	}
	
	public boolean isComponentPath() {
		return component != null;
	}

	public SystemPath append(Subsystem subsystem) {
		if (component != null) {
			throw new IllegalStateException("Subsystem cannot be appended to component path");
		}
		List<Subsystem> newSubsystems = new ArrayList<Subsystem>(subsystems.size() + 1);
		newSubsystems.addAll(subsystems);
		newSubsystems.add(subsystem);
		return new SystemPath(contextFragment, Collections.unmodifiableList(newSubsystems));
	}
	
	public SystemPath append(Component component) {
		if (this.component != null) {
			throw new IllegalStateException("Component cannot be appended to component path");
		}
		return new SystemPath(contextFragment, subsystems, component);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		int hashCode = contextFragment.hashCode() ^ subsystems.hashCode();
		if (component != null) {
			hashCode ^= component.hashCode();
		}
		return hashCode;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof SystemPath) {
			SystemPath other = (SystemPath) obj;
			return contextFragment == other.contextFragment && component == other.component && subsystems.equals(other.subsystems);
		}
		return false;
	}

}
