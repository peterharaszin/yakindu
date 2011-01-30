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

import org.eclipse.gef.EditPart;
import org.eclipselabs.damos.diagram.ui.editparts.ComponentEditPart;

/**
 * @author Andreas Unger
 *
 */
public class ComponentEditPartDelegate {

	protected ComponentEditPart editPart;
	
	/**
	 * 
	 */
	public ComponentEditPartDelegate(ComponentEditPart editPart) {
		this.editPart = editPart;
	}
	
	public void createDefaultEditPolicies() {
	}
		
	public void addSemanticListeners() {
	}
	
	public void removeSemanticListeners() {
	}
	
	public EditPart getPrimaryChildEditPart() {
		return null;
	}
	
	public Object getAdapter(@SuppressWarnings("rawtypes") Class key) {
		return null;
	}

}
