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
import org.eclipse.gef.EditPart;
import org.eclipselabs.damos.diagram.ui.editparts.ComponentAttributeEditPart;
import org.eclipselabs.damos.diagram.ui.editparts.ComponentEditPart;
import org.eclipselabs.damos.diagram.ui.editparts.PortEditPart;
import org.eclipselabs.damos.diagram.ui.editpolicies.AdjustInputCountEditPolicy;
import org.eclipselabs.damos.diagram.ui.editpolicies.AdjustOutputCountEditPolicy;
import org.eclipselabs.damos.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipselabs.damos.diagram.ui.properties.ParametersPropertySectionDelegate;
import org.eclipselabs.damos.dml.Block;

/**
 * @author Andreas Unger
 *
 */
public class BlockEditPartDelegate extends ComponentEditPartDelegate {

	private ArgumentNotificationHelper argumentNotificationHelper;
	
	/**
	 * 
	 */
	public BlockEditPartDelegate(ComponentEditPart componentEditPart) {
		super(componentEditPart);
		argumentNotificationHelper = new ArgumentNotificationHelper(componentEditPart);
	}
	
	public void createDefaultEditPolicies() {
		editPart.installEditPolicy(EditPolicyRoles.ADJUST_INPUT_COUNT_ROLE, new AdjustInputCountEditPolicy());
		editPart.installEditPolicy(EditPolicyRoles.ADJUST_OUTPUT_COUNT_ROLE, new AdjustOutputCountEditPolicy());
	}
		
	public void addSemanticListeners() {
		super.addSemanticListeners();
		EObject o = editPart.resolveSemanticElement();
		if (o instanceof Block) {
			argumentNotificationHelper.addSemanticListeners(((Block) o).getArguments());
		}
	}
	
	public void removeSemanticListeners() {
		argumentNotificationHelper.removeSemanticListeners();
		super.removeSemanticListeners();
	}
	
	public EditPart getPrimaryChildEditPart() {
		// The first non-port and non-attribute edit part is our primary edit part.
		for (Object ep : editPart.getChildren()) {
			if (!(ep instanceof PortEditPart || ep instanceof ComponentAttributeEditPart)) {
				return (EditPart) ep;
			}
		}
		return super.getPrimaryChildEditPart();
	}
	
	@SuppressWarnings("unchecked")
	public Object getAdapter(Class key) {
		if (key == ParametersPropertySectionDelegate.class) {
			return new ParametersPropertySectionDelegate();
		}
		return super.getAdapter(key);
	}

}
