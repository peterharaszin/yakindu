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

package org.eclipse.damos.dml.ui.internal.registry;

import org.eclipse.damos.dml.ui.registry.IBlockImageDescriptor;
import org.eclipse.jface.resource.ImageDescriptor;

public class BlockImageDescriptor implements IBlockImageDescriptor {
	
	private String blockTypeQualifiedName;
	private ImageDescriptor icon16ImageDescriptor;
	private ImageDescriptor icon24ImageDescriptor;
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.dml.ui.internal.registry.IBlockImageDescriptor#getBlockTypeQualifiedName()
	 */
	public String getBlockTypeQualifiedName() {
		return blockTypeQualifiedName;
	}
	
	/**
	 * @param blockTypeQualifiedName the blockTypeQualifiedName to set
	 */
	public void setBlockTypeQualifiedName(String blockTypeQualifiedName) {
		this.blockTypeQualifiedName = blockTypeQualifiedName;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.dml.ui.internal.registry.IBlockImageDescriptor#getIcon16ImageDescriptor()
	 */
	public ImageDescriptor getIcon16ImageDescriptor() {
		return icon16ImageDescriptor;
	}
	
	/**
	 * @param icon16ImageDescriptor the icon16ImageDescriptor to set
	 */
	public void setIcon16ImageDescriptor(ImageDescriptor icon16ImageDescriptor) {
		this.icon16ImageDescriptor = icon16ImageDescriptor;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.dml.ui.internal.registry.IBlockImageDescriptor#getIcon24ImageDescriptor()
	 */
	public ImageDescriptor getIcon24ImageDescriptor() {
		return icon24ImageDescriptor;
	}
	
	/**
	 * @param icon24ImageDescriptor the icon24ImageDescriptor to set
	 */
	public void setIcon24ImageDescriptor(ImageDescriptor icon24ImageDescriptor) {
		this.icon24ImageDescriptor = icon24ImageDescriptor;
	}
	
}