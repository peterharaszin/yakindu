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
package org.yakindu.sct.ui.editor.editparts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.ShapeCompartmentFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.sct.ui.editor.policies.CompartmentCreationEditPolicy;
import org.yakindu.sct.ui.editor.policies.RegionCompartmentCanonicalEditPolicy;
import org.yakindu.sct.ui.editor.policies.RegionCompartmentXYLayoutEditPolicy;


/**
 * @author muelder
 */
public class RegionCompartmentEditPart extends ShapeCompartmentEditPart {
	
	private boolean isSupportingViewActions = true;
	
	public RegionCompartmentEditPart(View view) {
		super(view);
	}

	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.CREATION_ROLE,
				new CompartmentCreationEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE,
				new RegionCompartmentCanonicalEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE,
				new DragDropEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE,
				new RegionCompartmentXYLayoutEditPolicy());
	}
	
	public boolean isSupportingViewActions(){
		return this.isSupportingViewActions;
	}
	
	public void setIsSupportingViewActions(boolean supportsViewActions){
		this.isSupportingViewActions = supportsViewActions;
	}

	@Override
	protected IFigure createFigure() {
		ShapeCompartmentFigure figure = (ShapeCompartmentFigure) super
				.createFigure();
		figure.setBorder(null);
		return figure;
	}

	@Override
	public boolean isSelectable() {
		return false;
	}

}
