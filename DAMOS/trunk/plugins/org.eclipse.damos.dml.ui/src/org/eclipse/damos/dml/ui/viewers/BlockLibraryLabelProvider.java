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

package org.eclipse.damos.dml.ui.viewers;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.damos.dml.registry.IBlockGroupDescriptor;
import org.eclipse.damos.dml.registry.IBlockTypeDescriptor;
import org.eclipse.damos.dml.ui.registry.BlockImageRegistry;
import org.eclipse.damos.dml.ui.registry.IBlockImageDescriptor;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

/**
 * @author Andreas Unger
 *
 */
public class BlockLibraryLabelProvider extends LabelProvider {

	private Map<ImageDescriptor, Image> images = new HashMap<ImageDescriptor, Image>();
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.LabelProvider#getText(java.lang.Object)
	 */
	@Override
	public String getText(Object element) {
		if (element instanceof IBlockTypeDescriptor) {
			IBlockTypeDescriptor blockType = (IBlockTypeDescriptor) element;
			return blockType.getName();
		}
		if (element instanceof IBlockGroupDescriptor) {
			IBlockGroupDescriptor blockGroup = (IBlockGroupDescriptor) element;
			return blockGroup.getName();
		}
		return super.getText(element);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.LabelProvider#getImage(java.lang.Object)
	 */
	@Override
	public Image getImage(Object element) {
		if (element instanceof IBlockTypeDescriptor) {
			IBlockTypeDescriptor blockType = (IBlockTypeDescriptor) element;
			IBlockImageDescriptor blockImage = BlockImageRegistry.getInstance().getBlockImage(blockType.getQualifiedName());
			if (blockImage != null) {
				ImageDescriptor icon = blockImage.getIcon16ImageDescriptor();
				Image iconImage = images.get(icon);
				if (iconImage == null) {
					iconImage = icon.createImage();
					images.put(icon, iconImage);
				}
				return iconImage;
			}
		}
		if (element instanceof IBlockGroupDescriptor) {
			return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FOLDER);
		}
		return super.getImage(element);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.BaseLabelProvider#dispose()
	 */
	@Override
	public void dispose() {
		super.dispose();
		for (Image image : images.values()) {
			image.dispose();
		}
		images.clear();
	}
	
}
