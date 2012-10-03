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

package org.eclipse.damos.diagram.ui.internal.providers;

import org.eclipse.damos.diagram.core.internal.provider.IBlockTypeProvider;
import org.eclipse.damos.dml.BlockType;
import org.eclipse.damos.dml.registry.IBlockTypeDescriptor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

/**
 * @author Andreas Unger
 *
 */
public class BlockTypeProvider implements IBlockTypeProvider {

	private EditingDomain editingDomain;
	private IBlockTypeDescriptor blockTypeDescriptor;
	private BlockType cachedBlockType;
	
	/**
	 * 
	 */
	public BlockTypeProvider(EditingDomain editingDomain, IBlockTypeDescriptor blockTypeDescriptor) {
		this.editingDomain = editingDomain;
		this.blockTypeDescriptor = blockTypeDescriptor;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.core.internal.provider.IBlockTypeProvider#getBlockTypeDescriptor()
	 */
	public IBlockTypeDescriptor getBlockTypeDescriptor() {
		return blockTypeDescriptor;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.core.internal.provider.IBlockTypeProvider#getBlockType()
	 */
	public BlockType getBlockType() {
		if (cachedBlockType == null) {
			ResourceSet resourceSet = editingDomain.getResourceSet();
			EObject element;
			URI uri = blockTypeDescriptor.getURI();
			try {
				element = resourceSet.getEObject(uri, true);
				if (element instanceof BlockType) {
					cachedBlockType = (BlockType) element;
				} else {
					showError("URI '" + uri + "' does not represent a valid block type");
				}
			} catch (Exception e) {
				showError("Could not load block type URI '" + uri + "'");
			}
		}
		return cachedBlockType;
	}
	
	private void showError(String message) {
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		MessageDialog.openError(shell, "Load Block Type", message);
	}
	
}
