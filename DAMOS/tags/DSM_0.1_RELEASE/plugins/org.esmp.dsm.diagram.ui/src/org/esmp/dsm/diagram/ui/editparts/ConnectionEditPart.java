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

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.esmp.dsm.diagram.ui.figures.ConnectionFigure;
import org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage;
import org.esmp.dsm.semantic.blockdiagram.Connection;

public class ConnectionEditPart extends ConnectionNodeEditPart {

	public ConnectionEditPart(View view) {
		super(view);
	}
	
	protected PolylineConnection createConnectionFigure() {
		if (getModel() == null) {
			return null;
		}
		return new ConnectionFigure();
	}
	
	protected void refreshVisuals() {
		super.refreshVisuals();
		refreshLineType();
	}

	protected int getLineType() {
		Connection connection = (Connection) resolveSemanticElement();
		if (connection != null && connection.isVirtual()) {
			return Graphics.LINE_DOT;
		}
		return Graphics.LINE_SOLID;
	}
	
	protected void setLineType(int lineType) {
		((PolylineConnection) getConnectionFigure()).setLineStyle(getLineType());
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart#getTargetEditPart(org.eclipse.gef.Request)
	 */
	public EditPart getTargetEditPart(Request request) {
		EditPart editPart = super.getTargetEditPart(request);
		if (editPart instanceof org.eclipse.gef.ConnectionEditPart) {
			Object type = request.getType();
			if (RequestConstants.REQ_CONNECTION_START.equals(type)
					|| RequestConstants.REQ_RECONNECT_SOURCE.equals(type)) {
				 return ((org.eclipse.gef.ConnectionEditPart) editPart).getSource();
			} else if (RequestConstants.REQ_CONNECTION_END.equals(type)
					|| RequestConstants.REQ_RECONNECT_TARGET.equals(type)) {
				 return ((org.eclipse.gef.ConnectionEditPart) editPart).getTarget();
			}
		}
		return editPart;
	}
	
	protected void handleNotificationEvent(Notification notification) {
		if (notification.getFeature() == BlockDiagramPackage.eINSTANCE.getConnection_Virtual()) {
			refreshLineType();
		} else {
			super.handleNotificationEvent(notification);
		}
	}
	
}
