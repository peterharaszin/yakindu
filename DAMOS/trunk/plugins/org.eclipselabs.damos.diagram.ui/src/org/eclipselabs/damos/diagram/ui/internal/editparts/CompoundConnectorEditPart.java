/****************************************************************************
 * Copyright (c) 2008, 2011 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.diagram.ui.internal.editparts;

import java.util.Collection;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.LocationRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.BorderedBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;
import org.eclipselabs.damos.diagram.core.type.ElementTypes;
import org.eclipselabs.damos.diagram.ui.editpolicies.IEditPolicyRoles;
import org.eclipselabs.damos.diagram.ui.figures.IFontColorAwareFigure;
import org.eclipselabs.damos.diagram.ui.figures.TerminalFigure;
import org.eclipselabs.damos.diagram.ui.internal.editpolicies.ConnectorGraphicalNodeEditPolicy;
import org.eclipselabs.damos.diagram.ui.internal.editpolicies.NonDestroySemanticEditPolicy;
import org.eclipselabs.damos.diagram.ui.internal.editpolicies.TerminalEditPolicy;
import org.eclipselabs.damos.diagram.ui.internal.figures.IConnectorFigure;
import org.eclipselabs.damos.dml.Connector;

/**
 * @author Andreas Unger
 *
 */
public abstract class CompoundConnectorEditPart extends BorderedBorderItemEditPart implements IConnectorEditPart {

	/**
	 * @param view
	 */
	public CompoundConnectorEditPart(View view) {
		super(view);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart#createDefaultEditPolicies()
	 */
	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		removeEditPolicy(EditPolicy.COMPONENT_ROLE);
		removeEditPolicy(EditPolicyRoles.CONNECTION_HANDLES_ROLE);
		installEditPolicy(IEditPolicyRoles.SEMANTIC_ROLE, new NonDestroySemanticEditPolicy());
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new ConnectorGraphicalNodeEditPolicy());
		installEditPolicy(IEditPolicyRoles.TERMINAL_ROLE, new TerminalEditPolicy());
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderItemEditPart#refreshBounds()
	 */
	@Override
	protected void refreshBounds() {
		super.refreshBounds();
		getMainFigure().revalidate();
	}
	
	public Connector getConnector() {
		return (Connector) resolveSemanticElement();
	}

	public IConnectorFigure getConnectorFigure() {
		return (IConnectorFigure) getMainFigure();
	}

	@Override
	protected void refreshVisuals() {
		super.refreshVisuals();
		refreshFontColor();
	}

	@Override
	protected void setFontColor(Color color) {
		IFigure figure = getMainFigure();
		if (figure instanceof IFontColorAwareFigure) {
			IFontColorAwareFigure fontColorAwareFigure = (IFontColorAwareFigure) figure;
			fontColorAwareFigure.setFontColor(color);
		}
	}

	protected void handleNotificationEvent(Notification notification) {
		Object feature = notification.getFeature();
		if (NotationPackage.eINSTANCE.getFontStyle_FontColor().equals(feature)) {
			refreshFontColor();
		} else {
			super.handleNotificationEvent(notification);
		}
	}

	@Override
	public DragTracker getDragTracker(Request request) {
		if (request instanceof LocationRequest) {
			LocationRequest locationRequest = (LocationRequest) request;
			Point p = new PrecisionPoint(locationRequest.getLocation());
			TerminalFigure terminalFigure = getConnectorFigure().getTerminalFigure();
			terminalFigure.translateToRelative(p);
			if (terminalFigure.containsPoint(p)) {
				return new ConnectionCreationDragTracker(ElementTypes.CONNECTION);
			}
		}
		return super.getDragTracker(request);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	protected Collection disableCanonicalFor(Request request) {
		Collection hosts = super.disableCanonicalFor(request);
		if (request instanceof CreateConnectionRequest) {
			hosts.add(getRoot().getContents());
		}
		return hosts;
	}

}