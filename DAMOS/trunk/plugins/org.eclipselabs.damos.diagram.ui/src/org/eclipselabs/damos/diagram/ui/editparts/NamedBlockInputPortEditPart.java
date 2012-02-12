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

package org.eclipselabs.damos.diagram.ui.editparts;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipselabs.damos.dml.DMLPackage;

/**
 * @author Andreas Unger
 *
 */
public class NamedBlockInputPortEditPart extends BlockInputPortEditPart {

	private final NamedBlockPortHelper helper = new NamedBlockPortHelper(this);
	
	/**
	 * @param view
	 */
	public NamedBlockInputPortEditPart(View view) {
		super(view);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.diagram.ui.editparts.PortEditPart#refreshVisuals()
	 */
	@Override
	protected void refreshVisuals() {
		super.refreshVisuals();
		refreshName();
	}
	
	protected void refreshName() {
		helper.refreshName();
	}
	
	@Override
	protected void handleNotificationEvent(Notification notification) {
		if (notification.getFeature() == DMLPackage.eINSTANCE.getBlockInput_Definition()) {
			refreshName();
		}
		super.handleNotificationEvent(notification);
	}

}
