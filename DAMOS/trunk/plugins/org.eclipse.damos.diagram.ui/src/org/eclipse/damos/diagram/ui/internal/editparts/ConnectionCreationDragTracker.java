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

package org.eclipse.damos.diagram.ui.internal.editparts;

import org.eclipse.gef.DragTracker;
import org.eclipse.gmf.runtime.diagram.ui.tools.ConnectionCreationTool;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

/**
 * @author Andreas Unger
 *
 */
public class ConnectionCreationDragTracker extends ConnectionCreationTool implements DragTracker {

	/**
	 * 
	 */
	public ConnectionCreationDragTracker(IElementType elementType) {
		super(elementType);
	}
	
}
