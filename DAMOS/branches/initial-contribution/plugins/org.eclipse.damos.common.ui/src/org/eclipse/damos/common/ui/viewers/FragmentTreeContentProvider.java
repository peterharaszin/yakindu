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

package org.eclipse.damos.common.ui.viewers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.damos.dml.Fragment;
import org.eclipse.damos.dml.System;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.viewers.ITreeContentProvider;

public class FragmentTreeContentProvider extends AbstractFragmentContentProvider implements ITreeContentProvider {

	/**
	 * 
	 */
	public FragmentTreeContentProvider() {
	}

	public FragmentTreeContentProvider(Fragment rootFragment) {
		super(rootFragment);
	}

	public Object[] getElements(Object inputElement) {
		List<Object> elements = new ArrayList<Object>();
		if (inputElement instanceof ResourceSet) {
			ResourceSet resourceSet = (ResourceSet) inputElement;
			for (Resource resource : resourceSet.getResources()) {
				for (EObject object : resource.getContents()) {
					if (object instanceof System && includeFragment((System) object)) {
						elements.add(object);
					}
				}
			}
		}
		return elements.toArray();
	}

	public Object getParent(Object element) {
		if (element instanceof Fragment) {
			return ((Fragment) element).getParent();
		}
		return null;
	}

	public boolean hasChildren(Object element) {
		if (element instanceof Fragment) {
			Fragment fragment = (Fragment) element;
			Resource fragmentResource = fragment.eResource();
			if (fragmentResource != null) {
				ResourceSet resourceSet = fragmentResource.getResourceSet();
				if (resourceSet != null) {
					for (Resource resource : resourceSet.getResources()) {
						for (EObject object : resource.getContents()) {
							if (object instanceof Fragment && ((Fragment) object).getParent() == element) {
								return true;
							}
						}
					}
				}
			}
		}
		return false;
	}

	public Object[] getChildren(Object element) {
		List<Object> children = new ArrayList<Object>();
		if (element instanceof Fragment) {
			Fragment fragment = (Fragment) element;
			Resource fragmentResource = fragment.eResource();
			if (fragmentResource != null) {
				ResourceSet resourceSet = fragmentResource.getResourceSet();
				if (resourceSet != null) {
					for (Resource resource : resourceSet.getResources()) {
						for (EObject object : resource.getContents()) {
							if (object instanceof Fragment && ((Fragment) object).getParent() == element
									&& includeFragment((Fragment) object)) {
								children.add(object);
							}
						}
					}
				}
			}
		}
		return children.toArray();
	}

}