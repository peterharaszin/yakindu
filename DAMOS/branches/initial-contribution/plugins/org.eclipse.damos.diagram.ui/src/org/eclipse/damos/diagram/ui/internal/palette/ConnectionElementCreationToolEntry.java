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

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.CombinedTemplateCreationEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.ConnectionCreationTool;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.jface.resource.ImageDescriptor;

/**
 * @author Andreas Unger
 *
 */
public class ConnectionElementCreationToolEntry extends CombinedTemplateCreationEntry {

	IElementType elementType;
	
	public ConnectionElementCreationToolEntry(IElementType elementType, ImageDescriptor iconSmall, ImageDescriptor iconLarge) {
		super(elementType.getDisplayName(), "Create " + elementType.getDisplayName(), null, iconSmall, iconLarge);
		this.elementType = elementType;
	}

	public Tool createTool() {
		return new ConnectionCreationTool(elementType);
	}

}
