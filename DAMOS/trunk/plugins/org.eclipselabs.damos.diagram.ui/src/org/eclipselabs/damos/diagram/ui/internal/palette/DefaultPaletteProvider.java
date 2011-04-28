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

package org.eclipselabs.damos.diagram.ui.internal.palette;

import java.util.List;
import java.util.Map;

import org.eclipse.gef.palette.PaletteEntry;
import org.eclipse.gef.palette.PaletteToolbar;
import org.eclipse.ui.IEditorPart;
import org.eclipselabs.damos.diagram.core.type.ElementTypes;
import org.eclipselabs.damos.diagram.ui.DiagramUIPlugin;
import org.eclipselabs.damos.diagram.ui.palette.ConnectionElementCreationToolEntry;
import org.eclipselabs.damos.diagram.ui.palette.PaletteProvider;

/**
 * @author Andreas Unger
 *
 */
public class DefaultPaletteProvider extends PaletteProvider {

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.diagram.ui.palette.PaletteProvider#contributeToolbar(org.eclipse.ui.IEditorPart, java.lang.Object, org.eclipse.gef.palette.PaletteToolbar, java.util.Map)
	 */
	@Override
	protected void contributeToolbar(IEditorPart editor, Object content, PaletteToolbar toolbar, @SuppressWarnings("rawtypes") Map predefinedEntries) {
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.diagram.ui.palette.PaletteProvider#createBuiltinComponentEntries(org.eclipse.ui.IEditorPart)
	 */
	@Override
	protected List<PaletteEntry> createBuiltinComponentEntries(IEditorPart editor) {
		List<PaletteEntry> entries = super.createBuiltinComponentEntries(editor);
		entries.add(0, new ConnectionElementCreationToolEntry(
				ElementTypes.CONNECTION,
				DiagramUIPlugin.imageDescriptorFromPlugin(DiagramUIPlugin.PLUGIN_ID, "icons/builtin/Connection16.png"),
				DiagramUIPlugin.imageDescriptorFromPlugin(DiagramUIPlugin.PLUGIN_ID, "icons/builtin/Connection24.png")));
		return entries;
	}
	
}
