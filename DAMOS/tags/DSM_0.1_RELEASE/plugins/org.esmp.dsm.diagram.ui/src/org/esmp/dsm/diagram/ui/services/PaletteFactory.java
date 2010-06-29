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

package org.esmp.dsm.diagram.ui.services;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.gef.Tool;
import org.eclipse.gmf.runtime.diagram.ui.services.palette.PaletteFactory.Adapter;
import org.eclipse.gmf.runtime.diagram.ui.tools.ConnectionCreationTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.CreationTool;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.esmp.dsm.diagram.core.internal.type.IBlockElementType;
import org.esmp.dsm.diagram.core.type.ElementTypes;
import org.esmp.dsm.diagram.ui.DSMDiagramUIPlugin;
import org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage;

public class PaletteFactory extends Adapter {

	public Tool createTool(String toolId) {
		IElementType elementType = ElementTypeRegistry.getInstance().getType(toolId);
		if (elementType != null) {
			if (BlockDiagramPackage.eINSTANCE.getConnection().isSuperTypeOf(elementType.getEClass())) {
				return new ConnectionCreationTool(elementType);
			}
			return new CreationTool(elementType);
		}

		elementType = ElementTypeRegistry.getInstance().getType(ElementTypes.BLOCK_ID);
		if (elementType instanceof IBlockElementType) {
			try {
				URI uri = URI.createURI(toolId);
				((IBlockElementType) elementType).setBlockTypeURI(uri);
				return new CreationTool(elementType);
			} catch (IllegalArgumentException e) {
				DSMDiagramUIPlugin.getDefault().getLog().log(
						new Status(IStatus.ERROR, DSMDiagramUIPlugin.PLUGIN_ID,
								"Invalid Block Type URL specified: " + toolId, e));
			}
		}
		
		return null;
	}
	
}
