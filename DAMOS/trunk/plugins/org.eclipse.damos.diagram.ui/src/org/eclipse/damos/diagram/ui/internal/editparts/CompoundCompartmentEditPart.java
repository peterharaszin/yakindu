/****************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipse.damos.diagram.ui.internal.editparts;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.damos.diagram.core.type.ElementTypes;
import org.eclipse.damos.diagram.ui.editpolicies.IEditPolicyRoles;
import org.eclipse.damos.diagram.ui.editpolicies.SnapToConnectorFeedbackPolicy;
import org.eclipse.damos.diagram.ui.internal.editpolicies.CompoundCompartmentCanonicalEditPolicy;
import org.eclipse.damos.dml.ActionLink;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.CompoundSnapToHelper;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.SnapToGeometry;
import org.eclipse.gef.SnapToHelper;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @author Andreas Unger
 *
 */
public class CompoundCompartmentEditPart extends ShapeCompartmentEditPart {

	/**
	 * @param view
	 */
	public CompoundCompartmentEditPart(View view) {
		super(view);
	}

	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		removeEditPolicy(IEditPolicyRoles.CONNECTION_HANDLES_ROLE);
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new CompoundCompartmentCanonicalEditPolicy());
		installEditPolicy(IEditPolicyRoles.SNAP_TO_CONNECTOR_FEEDBACK_ROLE, new SnapToConnectorFeedbackPolicy());
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart#createFigure()
	 */
	@Override
	protected IFigure createFigure() {
		IFigure figure = super.createFigure();
		figure.setBorder(null);
		figure.setToolTip(null);
		return figure;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ResizableCompartmentEditPart#isSelectable()
	 */
	@Override
	public boolean isSelectable() {
		return false;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gef.editparts.AbstractEditPart#getTargetEditPart(org.eclipse.gef.Request)
	 */
	@Override
	public EditPart getTargetEditPart(Request request) {
		if (request instanceof CreateConnectionViewAndElementRequest) {
			CreateConnectionViewAndElementRequest createRequest = (CreateConnectionViewAndElementRequest) request;
			IAdaptable adaptable = createRequest.getConnectionViewAndElementDescriptor().getElementAdapter();
			if (adaptable != null && adaptable.getAdapter(IElementType.class) == ElementTypes.ACTION_LINK) {
				return getParent();
			}
		} else if (request instanceof ReconnectRequest) {
			ReconnectRequest reconnectRequest = (ReconnectRequest) request;
			if (reconnectRequest.getConnectionEditPart().getAdapter(ActionLink.class) != null) {
				return getParent();
			}
		}
		return super.getTargetEditPart(request);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ResizableCompartmentEditPart#getAdapter(java.lang.Class)
	 */
	@Override
	public Object getAdapter(@SuppressWarnings("rawtypes") Class key) {
		if (key == SnapToHelper.class) {
			Boolean snapEnabled = (Boolean) getViewer().getProperty(SnapToGeometry.PROPERTY_SNAP_ENABLED);
			if (snapEnabled != null && snapEnabled.booleanValue()) {
				SnapToHelper snapToHelper = (SnapToHelper) super.getAdapter(key);
				if (snapToHelper != null) {
					return new CompoundSnapToHelper(new SnapToHelper[] { new SnapToConnector(this), snapToHelper });
				}
				return new SnapToConnector(this);
			}
		}
		return super.getAdapter(key);
	}

}
