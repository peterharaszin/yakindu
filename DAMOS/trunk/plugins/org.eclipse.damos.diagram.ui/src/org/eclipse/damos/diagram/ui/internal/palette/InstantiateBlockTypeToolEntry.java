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

package org.eclipse.damos.diagram.ui.internal.palette;

import org.eclipse.damos.diagram.ui.internal.tools.InstantiateBlockTypeTool;
import org.eclipse.damos.diagram.ui.palette.ComponentCreationToolEntry;
import org.eclipse.gef.Tool;
import org.eclipse.ui.IEditorPart;

/**
 * @author Andreas Unger
 *
 */
public class InstantiateBlockTypeToolEntry extends ComponentCreationToolEntry {

	public InstantiateBlockTypeToolEntry(IEditorPart editor) {
		super(editor, "Instantiate Block Type", "Create new block from existing block type");
	}

	public Tool createTool() {
		Tool tool = new InstantiateBlockTypeTool(getEditingDomain());
		tool.setProperties(getToolProperties());
		return tool;
	}

}
