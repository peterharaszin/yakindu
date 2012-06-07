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

import org.eclipse.gef.Tool;
import org.eclipse.ui.IEditorPart;
import org.eclipselabs.damos.diagram.ui.tools.BlockCreationTool;
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
		Tool tool = new BlockCreationTool(getEditingDomain(), blockTypeDescriptor);
		tool.setProperties(getToolProperties());
		return tool;
	}

}
