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

package org.eclipse.damos.diagram.ui.internal.editparts;

import org.eclipse.damos.diagram.ui.editparts.PortEditPart;
import org.eclipse.damos.dml.BlockPort;
import org.eclipse.emf.ecore.EObject;

/**
 * @author Andreas Unger
 *
 */
public class BlockPortEditPartDelegate extends PortEditPartDelegate {

	private final NotificationHelper argumentNotificationHelper;

	/**
	 * @param editPart
	 */
	public BlockPortEditPartDelegate(PortEditPart editPart) {
		super(editPart);
		this.argumentNotificationHelper = new NotificationHelper(editPart);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.ui.editparts.PortEditPartDelegate#addSemanticListeners()
	 */
	@Override
	public void addSemanticListeners() {
		super.addSemanticListeners();
		EObject o = editPart.resolveSemanticElement();
		if (o instanceof BlockPort) {
			BlockPort blockPort = (BlockPort) o;
			argumentNotificationHelper.addSemanticListeners(blockPort.getArguments());
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.ui.editparts.PortEditPartDelegate#removeSemanticListeners()
	 */
	@Override
	public void removeSemanticListeners() {
		argumentNotificationHelper.removeSemanticListeners();
		super.removeSemanticListeners();
	}

}
