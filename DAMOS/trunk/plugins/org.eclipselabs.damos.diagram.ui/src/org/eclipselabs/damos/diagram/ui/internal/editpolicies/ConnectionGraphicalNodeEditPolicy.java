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

package org.eclipselabs.damos.diagram.ui.internal.editpolicies;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipselabs.damos.diagram.core.type.ElementTypes;
import org.eclipselabs.damos.dml.InputConnector;

/**
 * @author Andreas Unger
 *
 */
public class ConnectionGraphicalNodeEditPolicy extends GraphicalNodeEditPolicy {

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.GraphicalNodeEditPolicy#getConnectionAndRelationshipCompleteCommand(org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest)
	 */
	@Override
	protected Command getConnectionAndRelationshipCompleteCommand(CreateConnectionViewAndElementRequest request) {
		Object source = request.getSourceEditPart().getAdapter(InputConnector.class);
		if (source != null) {
			EditPart realSourceEditPart = getSource();
			EditPart realTargetEditPart = request.getSourceEditPart();
			CreateConnectionRequest connectionRequest = CreateViewRequestFactory.getCreateConnectionRequest(
					ElementTypes.CONNECTION, getHost().getDiagramPreferencesHint());

			connectionRequest.setSourceEditPart(null);
			connectionRequest.setTargetEditPart(realSourceEditPart);
			connectionRequest.setLocation(new Point(0, 0));
			connectionRequest.setType(RequestConstants.REQ_CONNECTION_START);
			realSourceEditPart.getCommand(connectionRequest);

			connectionRequest.setSourceEditPart(realSourceEditPart);
			connectionRequest.setTargetEditPart(realTargetEditPart);
			connectionRequest.setType(RequestConstants.REQ_CONNECTION_END);

			Command command = realTargetEditPart.getCommand(connectionRequest);
			return command;
		}
		return super.getConnectionAndRelationshipCompleteCommand(request);
	}
		
	/* (non-Javadoc)
	 * @see org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy#getTargetEditPart(org.eclipse.gef.Request)
	 */
	@Override
	public EditPart getTargetEditPart(Request request) {
		if (REQ_CONNECTION_START.equals(request.getType())) {
			return getSource();
		}
		return super.getTargetEditPart(request);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.editpolicies.AbstractEditPolicy#getHost()
	 */
	@Override
	public IGraphicalEditPart getHost() {
		return (IGraphicalEditPart) super.getHost();
	}

	/**
	 * @return
	 */
	private EditPart getSource() {
		return ((ConnectionEditPart) getHost()).getSource();
	}

}
