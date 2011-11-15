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

package org.eclipselabs.damos.diagram.ui.parts;

import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramActionBarContributor;
import org.eclipselabs.damos.diagram.ui.DiagramUIPlugin;

public class BlockDiagramActionBarContributor extends DiagramActionBarContributor {

	protected Class<?> getEditorClass() {
		return BlockDiagramEditor.class;
	}

	protected String getEditorId() {
		return DiagramUIPlugin.EDITOR_ID;
	}

}
