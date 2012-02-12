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

import java.util.Collections;

import org.eclipse.emf.ecore.EObject;
import org.eclipselabs.damos.diagram.ui.editparts.PortEditPart;
import org.eclipselabs.damos.dml.Port;


/**
 * @author Andreas Unger
 *
 */
public class PortEditPartDelegate {

	protected final PortEditPart editPart;

	private final NotificationHelper inoutputNotificationHelper;
	
	/**
	 * 
	 */
	public PortEditPartDelegate(PortEditPart editPart) {
		this.editPart = editPart;
		this.inoutputNotificationHelper = new NotificationHelper(editPart);
	}
	
	public void addSemanticListeners() {
		EObject o = editPart.resolveSemanticElement();
		if (o instanceof Port) {
			Port port = (Port) o;
			inoutputNotificationHelper.addSemanticListeners(Collections.singletonList(port.getInoutput()));
		}
	}
	
	public void removeSemanticListeners() {
		inoutputNotificationHelper.removeSemanticListeners();
	}
	
}
