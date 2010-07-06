/****************************************************************************
 * Copyright (c) 2008, 2009 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/
package org.eclipselabs.damos.diagram.ui.editparts;

import org.eclipse.draw2d.Label;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderItemEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.LabelEx;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipselabs.damos.diagram.ui.editpolicies.IEditPolicyRoles;
import org.eclipselabs.damos.dml.Component;

/**
 * @author Andreas Unger
 */
public abstract class ComponentAttributeEditPart extends AbstractBorderItemEditPart {

	public ComponentAttributeEditPart(View view) {
		super(view);
	}
	
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		removeEditPolicy(IEditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	protected void refreshVisuals() {
		super.refreshVisuals();
		refreshAttribute();
	}
	
	protected void refreshAttribute() {
		Component component = (Component) resolveSemanticElement();
		Label label = (Label) getFigure().getChildren().get(0);
		label.setText(component.eGet(getAttributeFeature()).toString());
	}

	protected void handleNotificationEvent(Notification notification) {
		if (notification.getFeature() == getAttributeFeature()) {
			refreshAttribute();
		} else {
			super.handleNotificationEvent(notification);
		}
	}
	
	protected abstract EStructuralFeature getAttributeFeature();

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart#createNodeFigure()
	 */
	protected NodeFigure createNodeFigure() {
		NodeFigure figure = new NodeFigure();
		figure.setLayoutManager(new ConstrainedToolbarLayout());
		figure.add(new LabelEx());
		return figure;
	}
	
}
