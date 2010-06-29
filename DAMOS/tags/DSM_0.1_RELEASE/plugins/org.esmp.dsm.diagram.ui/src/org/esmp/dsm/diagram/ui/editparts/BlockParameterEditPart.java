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
package org.esmp.dsm.diagram.ui.editparts;

import org.eclipse.draw2d.Label;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderItemEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.LabelEx;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.esmp.dsm.diagram.ui.editpolicies.EditPolicyRoles;
import org.esmp.dsm.semantic.blockdiagram.Block;

/**
 * @author Andreas Unger
 */
public abstract class BlockParameterEditPart extends AbstractBorderItemEditPart {

	public BlockParameterEditPart(View view) {
		super(view);
	}
	
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		removeEditPolicy(EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	protected void refreshVisuals() {
		super.refreshVisuals();
		refreshParameter();
	}
	
	protected void refreshParameter() {
		Block block = (Block) resolveSemanticElement();
		Label label = (Label) getFigure().getChildren().get(0);
		label.setText(block.eGet(getParameterFeature()).toString());
	}

	protected void handleNotificationEvent(Notification notification) {
		if (notification.getFeature() == getParameterFeature()) {
			refreshParameter();
		} else {
			super.handleNotificationEvent(notification);
		}
	}
	
	protected abstract EStructuralFeature getParameterFeature();

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
