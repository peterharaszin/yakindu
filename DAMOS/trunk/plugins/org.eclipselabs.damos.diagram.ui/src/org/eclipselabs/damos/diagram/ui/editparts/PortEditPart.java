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
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.requests.LocationRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.tools.DragEditPartsTrackerEx;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipselabs.damos.diagram.core.type.ElementTypes;
import org.eclipselabs.damos.diagram.ui.editpolicies.IEditPolicyRoles;
import org.eclipselabs.damos.diagram.ui.figures.PortFigure;
import org.eclipselabs.damos.diagram.ui.figures.TerminalFigure;
import org.eclipselabs.damos.diagram.ui.internal.editparts.ConnectionCreationDragTracker;
import org.eclipselabs.damos.diagram.ui.internal.editparts.IConnectorEditPart;
import org.eclipselabs.damos.diagram.ui.internal.editparts.PortEditPartDelegate;
import org.eclipselabs.damos.diagram.ui.internal.editpolicies.ConnectorGraphicalNodeEditPolicy;
import org.eclipselabs.damos.diagram.ui.internal.editpolicies.TerminalEditPolicy;
import org.eclipselabs.damos.diagram.ui.internal.figures.IConnectorFigure;
import org.eclipselabs.damos.dml.Connector;
import org.eclipselabs.damos.dml.Port;

public abstract class PortEditPart extends ShapeNodeEditPart implements IConnectorEditPart {

	private PortEditPartDelegate delegate;

	public PortEditPart(View view) {
		super(view);
	}

	/**
	 * @return the delegate
	 */
	PortEditPartDelegate getDelegate() {
		if (delegate == null) {
			delegate = createDelegate();
		}
		return delegate;
	}
	
	PortEditPartDelegate createDelegate() {
		return new PortEditPartDelegate(this);
	}

	protected boolean isTestPoint() {
		EObject element = resolveSemanticElement();
		if (element instanceof Port) {
			Port port = (Port) element;
			return port.getInoutput().isTestPoint();
		}
		return false;
	}

	protected boolean isSocket() {
		EObject element = resolveSemanticElement();
		if (element instanceof Port) {
			Port port = (Port) element;
			return port.getInoutput().isSocket();
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.editpolicies.AbstractEditPolicy#activate()
	 */
	public void activate() {
		super.activate();
		addTerminalBorderFigure();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gef.editpolicies.AbstractEditPolicy#deactivate()
	 */
	public void deactivate() {
		removeTerminalBorderFigure();
		super.deactivate();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart#createDefaultEditPolicies()
	 */
	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		removeEditPolicy(EditPolicyRoles.CONNECTION_HANDLES_ROLE);
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new ConnectorGraphicalNodeEditPolicy());
		installEditPolicy(IEditPolicyRoles.TERMINAL_ROLE, new TerminalEditPolicy());
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#addSemanticListeners()
	 */
	protected void addSemanticListeners() {
		super.addSemanticListeners();
		getDelegate().addSemanticListeners();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#removeSemanticListeners()
	 */
	protected void removeSemanticListeners() {
		getDelegate().removeSemanticListeners();
		super.removeSemanticListeners();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeEditPart#refreshBounds()
	 */
	protected void refreshBounds() {
		// Do nothing
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.diagram.ui.internal.editparts.IConnectorEditPart#getConnector()
	 */
	public Connector getConnector() {
		return (Connector) resolveSemanticElement();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.diagram.ui.internal.editparts.IConnectorEditPart#getConnectorFigure()
	 */
	public IConnectorFigure getConnectorFigure() {
		return (IConnectorFigure) getFigure();
	}
	
	protected void addTerminalBorderFigure() {
		IFigure hostFigure = getFigure();
		if (hostFigure instanceof PortFigure) {
			IFigure terminalBorderFigure = ((PortFigure) hostFigure).getTerminalBorderFigure();
			if (hostFigure.getParent() != null) {
				hostFigure.getParent().add(terminalBorderFigure);
			}
		}
	}
	
	protected void removeTerminalBorderFigure() {
		IFigure hostFigure = getFigure();
		if (hostFigure instanceof PortFigure) {
			IFigure terminalBorderFigure = ((PortFigure) hostFigure).getTerminalBorderFigure();
			if (hostFigure.getParent() != null) {
				hostFigure.getParent().remove(terminalBorderFigure);
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#getDragTracker(org.eclipse.gef.Request)
	 */
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
		EditPart parent = getDragTrackerTargetEditPart(request);
		if (parent != null) {
			return new DragEditPartsTrackerEx(parent);
		}
		return null;
	}
	
	protected EditPart getDragTrackerTargetEditPart(Request request) {
		return getParent();
	}
	
}
