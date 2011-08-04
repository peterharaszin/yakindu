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

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.SWT;
import org.eclipselabs.damos.diagram.ui.editpolicies.IEditPolicyRoles;
import org.eclipselabs.damos.diagram.ui.figures.ConnectionFigure;
import org.eclipselabs.damos.diagram.ui.internal.editpolicies.ConnectionGraphicalNodeEditPolicy;
import org.eclipselabs.damos.diagram.ui.internal.editpolicies.FragmentSelectionEditPolicy;
import org.eclipselabs.damos.dml.Connection;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.Port;

public class ConnectionEditPart extends ConnectionNodeEditPart {

	public ConnectionEditPart(View view) {
		super(view);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart#createDefaultEditPolicies()
	 */
	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(IEditPolicyRoles.FRAGMENT_SELECTION_ROLE, new FragmentSelectionEditPolicy());
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new ConnectionGraphicalNodeEditPolicy());
	}
	
	protected void refreshVisuals() {
		super.refreshVisuals();
		refreshConnectionType();
	}
	
	protected void refreshConnectionType() {
		Connection connection = (Connection) resolveSemanticElement();
		if (connection != null) {
			boolean testPointConnection = false;
			if (connection.getSource() instanceof Port) {
				Port source = (Port) connection.getSource();
				testPointConnection |= source.getInoutput().isTestPoint();
			}
			if (connection.getTarget() instanceof Port) {
				Port target = (Port) connection.getTarget();
				testPointConnection |= target.getInoutput().isTestPoint();
			}
			setLineType(testPointConnection ? SWT.LINE_DOT : SWT.LINE_SOLID);
		}
	}
	
	protected void setLineType(int lineType) {
		((ConnectionFigure) getFigure()).setLineStyle(lineType);
	}
	
	protected PolylineConnection createConnectionFigure() {
		if (getModel() == null) {
			return null;
		}
		return new ConnectionFigure();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart#getTargetConnectionAnchor(org.eclipse.gef.Request)
	 */
	@Override
	public ConnectionAnchor getTargetConnectionAnchor(Request request) {
		if (request instanceof CreateConnectionViewAndElementRequest) {
			return getSourceConnectionAnchor();
		}
		return super.getTargetConnectionAnchor(request);
	}
	
	protected void handleNotificationEvent(Notification notification) {
		Object feature = notification.getFeature();
		if (DMLPackage.eINSTANCE.getConnection_Source() == feature || DMLPackage.eINSTANCE.getConnection_Target() == feature) {
			refreshConnectionType();
		} else {
			super.handleNotificationEvent(notification);
		}
	}

}
