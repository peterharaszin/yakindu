/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.esmp.dsm.semantic.blockdiagram.presentation;

import org.esmp.dsm.semantic.blockdiagram.DSMSemanticEditorPlugin;


public class BlockCategoryActionBarContributor extends BlockDiagramActionBarContributor {

	protected String getMenuText() {
		return DSMSemanticEditorPlugin.INSTANCE.getString("_UI_BlockCategoryEditor_menu");
	}
	
}