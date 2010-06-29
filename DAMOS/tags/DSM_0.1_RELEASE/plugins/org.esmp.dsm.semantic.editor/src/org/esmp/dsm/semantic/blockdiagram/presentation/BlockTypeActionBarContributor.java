/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.esmp.dsm.semantic.blockdiagram.presentation;

import org.esmp.dsm.semantic.blockdiagram.DSMSemanticEditorPlugin;

public class BlockTypeActionBarContributor extends BlockDiagramActionBarContributor {
	
	protected String getMenuText() {
		return DSMSemanticEditorPlugin.INSTANCE.getString("_UI_BlockTypeEditor_menu");
	}

}