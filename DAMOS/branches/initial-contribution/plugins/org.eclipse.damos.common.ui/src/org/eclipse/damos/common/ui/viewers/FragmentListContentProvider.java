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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

/**
 * @author Andreas Unger
 *
 */
public class FragmentListContentProvider extends AbstractFragmentContentProvider {

	/**
	 * 
	 */
	public FragmentListContentProvider() {
	}
	
	public FragmentListContentProvider(Fragment rootFragment) {
		super(rootFragment);
	}
	
	public Object[] getElements(Object inputElement) {
		List<Object> elements = new ArrayList<Object>();
		if (inputElement instanceof ResourceSet) {
			ResourceSet resourceSet = (ResourceSet) inputElement;
			for (Resource resource : resourceSet.getResources()) {
				for (EObject object : resource.getContents()) {
					if (object instanceof Fragment && includeFragment((Fragment) object)) {
						elements.add(object);
					}
				}
			}
		}
		return elements.toArray();
	}
	
}
