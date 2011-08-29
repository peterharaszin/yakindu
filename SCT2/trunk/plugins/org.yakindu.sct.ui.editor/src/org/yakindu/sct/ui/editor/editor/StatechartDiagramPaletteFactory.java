/**
 * Copyright (c) 2010 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.ui.editor.editor;

import org.eclipse.gef.Tool;
import org.eclipse.gmf.runtime.diagram.ui.services.palette.PaletteFactory;
import org.eclipse.gmf.runtime.diagram.ui.tools.ConnectionCreationTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.CreationTool;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 *
 */
public class StatechartDiagramPaletteFactory extends PaletteFactory.Adapter {

	@Override
	public Tool createTool(String toolId) {
		IElementType elementType = ElementTypeRegistry.getInstance().getType(
				toolId);
		if (elementType == null)
			throw new IllegalStateException("No Element Id for toolId " + toolId
					+ " found!");
		if (toolId.equals(StatechartElementTypes.TRANSITION.getId())) {
			return new ConnectionCreationTool(elementType);
		} else
			return new CreationTool(elementType);
	}
}
