/****************************************************************************
 * Copyright (c) 2008, 2011 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.dml.ui.viewers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipselabs.damos.dml.registry.BlockGroupRegistry;
import org.eclipselabs.damos.dml.registry.IBlockGroupDescriptor;
import org.eclipselabs.damos.dml.registry.IBlockTypeDescriptor;

/**
 * @author Andreas Unger
 *
 */
public class BlockLibraryContentProvider implements ITreeContentProvider {

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
	 */
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getElements(java.lang.Object)
	 */
	public Object[] getElements(Object inputElement) {
		List<IBlockGroupDescriptor> topLevelGroups = new ArrayList<IBlockGroupDescriptor>();
		for (IBlockGroupDescriptor group : BlockGroupRegistry.getInstance().getBlockGroups()) {
			if (group.getSupergroup() == null) {
				topLevelGroups.add(group);
			}
		}
		return topLevelGroups.toArray();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang.Object)
	 */
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof IBlockGroupDescriptor) {
			IBlockGroupDescriptor blockGroup = (IBlockGroupDescriptor) parentElement;
			List<Object> children = new ArrayList<Object>(blockGroup.getSubgroups().size() + blockGroup.getBlockTypes().size());
			children.addAll(blockGroup.getSubgroups());
			children.addAll(blockGroup.getBlockTypes());
			return children.toArray();
		}
		return new Object[0];
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang.Object)
	 */
	public Object getParent(Object element) {
		if (element instanceof IBlockTypeDescriptor) {
			IBlockTypeDescriptor blockType = (IBlockTypeDescriptor) element;
			return blockType.getGroup();
		}
		if (element instanceof IBlockGroupDescriptor) {
			IBlockGroupDescriptor blockGroup = (IBlockGroupDescriptor) element;
			return blockGroup.getSupergroup();
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang.Object)
	 */
	public boolean hasChildren(Object element) {
		if (element instanceof IBlockGroupDescriptor) {
			IBlockGroupDescriptor blockGroup = (IBlockGroupDescriptor) element;
			return !blockGroup.getSubgroups().isEmpty() || !blockGroup.getBlockTypes().isEmpty();
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
	 */
	public void dispose() {
	}

}
