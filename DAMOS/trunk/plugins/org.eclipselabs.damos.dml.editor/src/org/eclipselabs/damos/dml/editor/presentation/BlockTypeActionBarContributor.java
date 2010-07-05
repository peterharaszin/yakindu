/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dml.editor.presentation;

import org.eclipselabs.damos.dml.editor.DMLEditorPlugin;

public class BlockTypeActionBarContributor extends DMLActionBarContributor {
	
	protected String getMenuText() {
		return DMLEditorPlugin.INSTANCE.getString("_UI_BlockTypeEditor_menu");
	}

}