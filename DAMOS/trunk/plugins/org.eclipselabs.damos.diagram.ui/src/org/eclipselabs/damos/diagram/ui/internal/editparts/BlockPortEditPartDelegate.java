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

package org.eclipselabs.damos.diagram.ui.internal.editparts;

import org.eclipse.emf.ecore.EObject;
import org.eclipselabs.damos.diagram.ui.editparts.PortEditPart;
import org.eclipselabs.damos.dml.BlockPort;

/**
 * @author Andreas Unger
 *
 */
public class BlockPortEditPartDelegate extends PortEditPartDelegate {

	private ArgumentNotificationHelper parameterNotificationHelper;

	/**
	 * @param editPart
	 */
	public BlockPortEditPartDelegate(PortEditPart editPart) {
		super(editPart);
		this.parameterNotificationHelper = new ArgumentNotificationHelper(editPart);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.diagram.ui.editparts.PortEditPartDelegate#addSemanticListeners()
	 */
	@Override
	public void addSemanticListeners() {
		EObject o = editPart.resolveSemanticElement();
		if (o instanceof BlockPort) {
			parameterNotificationHelper.addSemanticListeners(((BlockPort) o).getArguments());
		}
		super.addSemanticListeners();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.diagram.ui.editparts.PortEditPartDelegate#removeSemanticListeners()
	 */
	@Override
	public void removeSemanticListeners() {
		parameterNotificationHelper.removeSemanticListeners();
		super.removeSemanticListeners();
	}

}
