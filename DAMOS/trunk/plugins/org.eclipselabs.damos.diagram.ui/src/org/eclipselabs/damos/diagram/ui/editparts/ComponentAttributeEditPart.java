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

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.figures.LabelEx;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipselabs.damos.diagram.ui.editpolicies.IEditPolicyRoles;
import org.eclipselabs.damos.diagram.ui.internal.editpolicies.NonResizableLabelEditPolicy;
import org.eclipselabs.damos.dml.Component;

/**
 * @author Andreas Unger
 */
public abstract class ComponentAttributeEditPart extends LabelEditPart {

	private Label label;
	
	public ComponentAttributeEditPart(View view) {
		super(view);
	}
	
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		removeEditPolicy(IEditPolicyRoles.CONNECTION_HANDLES_ROLE);
		installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, new NonResizableLabelEditPolicy());
	}

	@Override
	protected IFigure createFigure() {
		IFigure figure = super.createFigure();
		label = new LabelEx();
		figure.add(label);
		return figure;
	}

	protected void refreshVisuals() {
		super.refreshVisuals();
		refreshAttribute();
	}
	
	protected void refreshAttribute() {
		Component component = (Component) resolveSemanticElement();
		label.setText(getAttributeStringValue(component.eGet(getAttributeFeature())));
	}
	
	protected String getAttributeStringValue(Object attributeValue) {
		return attributeValue.toString();
	}

	protected void handleNotificationEvent(Notification notification) {
		if (notification.getFeature() == getAttributeFeature()) {
			refreshAttribute();
		} else {
			super.handleNotificationEvent(notification);
		}
	}
	
	protected abstract EStructuralFeature getAttributeFeature();

}
