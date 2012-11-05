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

package org.eclipse.damos.dml.util;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.damos.dml.Fragment;
import org.eclipse.damos.dml.System;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EContentAdapter;

/**
 * @author Andreas Unger
 *
 */
public class FragmentSelectionManager {

	private System system;
	private Fragment selectedFragment;
	private Set<IFragmentSelectionChangeListener> changeListeners = new HashSet<IFragmentSelectionChangeListener>();

	private Adapter adapter = new EContentAdapter() {
		
		public void notifyChanged(Notification notification) {
			super.notifyChanged(notification);
			Object notifier = notification.getNotifier();
			if (notifier instanceof ResourceSet || notifier instanceof Resource) {
				ResourceSet resourceSet = DMLUtil.getResourceSet(system);
				if (resourceSet == null || !isFragmentInResourceSet(resourceSet, selectedFragment)) {
					setSelectedFragment(system);
				}
			}
		}
		
		public void setTarget(Notifier newTarget) {
			if (newTarget instanceof ResourceSet) {
				super.setTarget(newTarget);
			}
		}
		
		public void unsetTarget(Notifier oldTarget) {
			if (oldTarget instanceof ResourceSet) {
				super.unsetTarget(oldTarget);
			}
		}

	};

	/**
	 * 
	 */
	public FragmentSelectionManager(System system) {
		this.system = system;
		this.selectedFragment = system;
		ResourceSet resourceSet = DMLUtil.getResourceSet(system);
		if (resourceSet != null) {
			resourceSet.eAdapters().add(adapter);
		}
	}
	
	public System getSystem() {
		return system;
	}

	/**
	 * @return the context
	 */
	public Fragment getSelectedFragment() {
		return selectedFragment;
	}
	
	/**
	 * @param selectedFragment the context to set
	 */
	public void setSelectedFragment(Fragment selectedFragment) {
		this.selectedFragment = selectedFragment;
		fireFragmentSelectionChangeEvent(new FragmentSelectionChangeEvent(this, selectedFragment));
	}
	
	public void addFragmentSelectionChangeListener(IFragmentSelectionChangeListener l) {
		changeListeners.add(l);
	}
	
	public void removeFragmentSelectionChangeListener(IFragmentSelectionChangeListener l) {
		changeListeners.remove(l);
	}
	
	protected void fireFragmentSelectionChangeEvent(FragmentSelectionChangeEvent event) {
		for (IFragmentSelectionChangeListener l : changeListeners) {
			l.fragmentSelectionChanged(event);
		}
	}
	
	public void dispose() {
		ResourceSet resourceSet = DMLUtil.getResourceSet(system);
		if (resourceSet != null) {
			resourceSet.eAdapters().remove(adapter);
		}
	}
	
	private boolean isFragmentInResourceSet(ResourceSet resourceSet, Fragment fragment) {
		for (Resource resource : resourceSet.getResources()) {
			for (Object o : resource.getContents()) {
				if (fragment == o) {
					return true;
				}
			}
		}
		return false;
	}
		
}
