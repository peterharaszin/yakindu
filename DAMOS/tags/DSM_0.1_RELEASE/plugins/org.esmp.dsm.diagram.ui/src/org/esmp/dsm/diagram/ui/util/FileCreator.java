/****************************************************************************
 * Copyright (c) 2008, 2009 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.esmp.dsm.diagram.ui.util;

import org.eclipse.gmf.runtime.diagram.ui.resources.editor.ide.util.IDEEditorFileCreator;
import org.esmp.dsm.semantic.blockdiagram.util.BlockDiagramConstants;

public class FileCreator extends IDEEditorFileCreator {
	
	private static FileCreator instance;

	private FileCreator() {
	}
	
	public static FileCreator getInstance() {
		if (instance == null) {
			instance = new FileCreator();
		}
		return instance;
	}
	
	public String getExtension() {
		return "." + BlockDiagramConstants.FILE_EXTENSION;
	}

}
