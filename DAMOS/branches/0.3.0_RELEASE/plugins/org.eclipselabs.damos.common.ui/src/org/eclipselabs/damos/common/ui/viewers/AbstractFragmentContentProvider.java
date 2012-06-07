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

package org.eclipselabs.damos.common.ui.viewers;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Display;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.Fragment;

/**
 * @author Andreas Unger
 *
 */
public abstract class AbstractFragmentContentProvider implements IStructuredContentProvider {

	private Fragment rootFragment;
	private Viewer viewer;
	
	/**
	 * 
	 */
	public AbstractFragmentContentProvider() {
	}
	
	public AbstractFragmentContentProvider(Fragment rootFragment) {
		this.rootFragment = rootFragment;
	}	
	
	private Adapter adapter = new EContentAdapter() {
		
		public void notifyChanged(final Notification notification) {
			super.notifyChanged(notification);
			final Object notifier = notification.getNotifier();
			Display.getDefault().asyncExec(new Runnable() {
				
				public void run() {
					if (viewer != null && !viewer.getControl().isDisposed() && (notifier instanceof ResourceSet || notifier instanceof Resource || notification.getFeature() == DMLPackage.eINSTANCE.getQualifiedElement_QualifiedName())) {
						viewer.refresh();
					}
				}
			
			});
		}
		
		public void setTarget(Notifier newTarget) {
			if (newTarget instanceof ResourceSet || newTarget instanceof Resource) {
				super.setTarget(newTarget);
			}
		}
		
		public void unsetTarget(Notifier oldTarget) {
			if (oldTarget instanceof ResourceSet || oldTarget instanceof Resource) {
				super.unsetTarget(oldTarget);
			}
		}

	};

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		if (oldInput instanceof ResourceSet) {
			((ResourceSet) oldInput).eAdapters().remove(adapter);
		}
		this.viewer = viewer;
		if (newInput instanceof ResourceSet) {
			((ResourceSet) newInput).eAdapters().add(adapter);
		}
	}
	
	protected boolean includeFragment(Fragment fragment) {
		return rootFragment == null || rootFragment == fragment || fragment.getParent() != null;
	}

	public void dispose() {
		Object input = viewer.getInput();
		if (input instanceof ResourceSet) {
			((ResourceSet) input).eAdapters().remove(adapter);
		}
	}

}
