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

import org.eclipse.core.resources.IFile;
import org.eclipse.damos.diagram.core.internal.provider.IBlockTypeProvider;
import org.eclipse.damos.dml.BlockType;
import org.eclipse.damos.dml.DMLPackage;
import org.eclipse.damos.dml.registry.IBlockTypeDescriptor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

/**
 * @author Andreas Unger
 *
 */
public abstract class AbstractFileBlockTypeProvider implements IBlockTypeProvider {

	private EditingDomain editingDomain;

	private BlockType cachedBlockType;

	/**
	 * 
	 */
	public AbstractFileBlockTypeProvider(EditingDomain editingDomain) {
		this.editingDomain = editingDomain;
	}

	public IBlockTypeDescriptor getBlockTypeDescriptor() {
		return null;
	}

	public BlockType getBlockType() {
		if (cachedBlockType == null) {
			IFile file = getFile();
			if (file != null) {
				ResourceSet resourceSet = editingDomain.getResourceSet();
				try {
					Resource resource = resourceSet.getResource(URI.createPlatformResourceURI(file.getFullPath().toString(), false), true);
					BlockType blockType = (BlockType) EcoreUtil.getObjectByType(resource.getContents(), DMLPackage.eINSTANCE.getBlockType());
					if (blockType != null) {
						cachedBlockType = blockType;
					} else {
						showError("'" + file.getFullPath().toString() + "' does not contain a valid block type");
					}
				} catch (Exception e) {
					showError("Could not load block type from '" + file.getFullPath() + "'");
				}
			}
		}
		return cachedBlockType;
	}

	protected abstract IFile getFile();

	protected void showError(String message) {
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		MessageDialog.openError(shell, "Choose Block Type", message);
	}

}