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
package org.yakindu.sct.statechart.diagram.editparts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ResizableEditPolicyEx;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.sct.statechart.diagram.editor.figures.RegionFigure;

/**
 * 
 * @author muelder
 * 
 */
public class RegionEditPart extends ShapeNodeEditPart {

	public RegionEditPart(View view) {
		super(view);
	}

	@Override
	protected NodeFigure createNodeFigure() {
		final NodeFigure figure = new NodeFigure();
		figure.setLayoutManager(new StackLayout());
		figure.setMinimumSize(new Dimension(0,0));
		figure.add(new RegionFigure(getMapMode()));
		return figure;
	}

	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		removeEditPolicy(EditPolicyRoles.CONNECTION_HANDLES_ROLE);
		installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, new ResizableEditPolicyEx());
	}

	@Override
	public IFigure getContentPane() {
		return getPrimaryShape().getCompartmentPane();
	}

	private RegionFigure getPrimaryShape() {
		return (RegionFigure) getFigure().getChildren().get(0);
	}

	@Override
	protected void addChildVisual(EditPart childEditPart, int index) {
		if (childEditPart instanceof RegionCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getCompartmentPane();
			pane.setLayoutManager(new StackLayout());
			IFigure figure2 = ((RegionCompartmentEditPart) childEditPart)
					.getFigure();
			pane.add(figure2);
		} else if (childEditPart instanceof RegionNameEditPart) {
			((RegionNameEditPart) childEditPart).setLabel(getPrimaryShape()
					.getNameLabel());
		} else
			super.addChildVisual(childEditPart, index);
	}
	@Override
	protected void removeChildVisual(EditPart childEditPart) {
		if (childEditPart instanceof RegionCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getCompartmentPane();
			IFigure figure = ((RegionCompartmentEditPart) childEditPart)
			.getFigure();
			pane.remove(figure);
		}  else
		super.removeChildVisual(childEditPart);
	}
}
