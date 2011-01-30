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

package org.eclipselabs.damos.diagram.ui.palette;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.gef.Tool;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IEditorPart;
import org.eclipselabs.damos.diagram.ui.tools.BlockCreationTool;
import org.eclipselabs.damos.dml.BlockType;
import org.eclipselabs.damos.dml.registry.IBlockTypeDescriptor;

/**
 * @author Andreas Unger
 * 
 */
public class BlockCreationToolEntry extends ComponentCreationToolEntry {

	private IBlockTypeDescriptor blockTypeDescriptor;

	public BlockCreationToolEntry(IEditorPart editor, IBlockTypeDescriptor blockTypeDescriptor) {
		super(editor, blockTypeDescriptor.getName(), "Create " + blockTypeDescriptor.getName() + " block");
		this.blockTypeDescriptor = blockTypeDescriptor;
	}

	public Tool createTool() {
		try {
			BlockType blockType = getBlockType(blockTypeDescriptor);
			if (blockType != null) {
				Tool tool = new BlockCreationTool(blockType);
				tool.setProperties(getToolProperties());
				return tool;
			}
		} catch (Exception e) {
			MessageDialog.openError(getEditor().getSite().getShell(), "Block Creation", "Block creation failed: " + e.getLocalizedMessage());
		}
		return null;
	}

	protected BlockType getBlockType(IBlockTypeDescriptor blockTypeDescriptor) {
		ResourceSet resourceSet = getEditingDomain().getResourceSet();
		EObject element;
		try {
			element = resourceSet.getEObject(blockTypeDescriptor.getUri(), true);
		} catch (Exception e) {
			throw new IllegalArgumentException("Could not load block type URI '" + blockTypeDescriptor.getUri() + "'", e);
		}
		if (element instanceof BlockType) {
			return (BlockType) element;
		} else {
			throw new IllegalArgumentException("URI '" + blockTypeDescriptor.getUri() + "' does not represent a valid block type");
		}
	}
	
}
