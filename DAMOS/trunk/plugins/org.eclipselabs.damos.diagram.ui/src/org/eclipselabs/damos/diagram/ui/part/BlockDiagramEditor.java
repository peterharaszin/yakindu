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

package org.eclipselabs.damos.diagram.ui.part;

import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.ide.editor.FileDiagramEditorWithFlyoutPalette;
import org.eclipselabs.damos.diagram.ui.DiagramUIPlugin;
import org.eclipselabs.damos.diagram.ui.editparts.FragmentSelectionManager;

public class BlockDiagramEditor extends FileDiagramEditorWithFlyoutPalette {

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor#getContributorId()
	 */
	public String getContributorId() {
		return "org.eclipselabs.damos.diagram.ui";
	}
	
	protected PreferencesHint getPreferencesHint() {
		return DiagramUIPlugin.DIAGRAM_PREFERENCES_HINT;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor#getAdapter(java.lang.Class)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Object getAdapter(Class type) {
		if (type == FragmentSelectionManager.class) {
			return getDiagramEditPart().getAdapter(type);
		}
		return super.getAdapter(type);
	}

}
