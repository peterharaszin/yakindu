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
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipselabs.damos.diagram.core.type.ElementTypes;
import org.eclipselabs.damos.dml.InputConnector;
import org.eclipselabs.damos.dml.OutputConnector;
import org.eclipselabs.damos.dml.util.FragmentSelectionManager;

/**
 * @author Andreas Unger
 *
 */
public class ConnectorGraphicalNodeEditPolicy extends GraphicalNodeEditPolicy {

	public Command getCommand(Request request) {
		Command command = super.getCommand(request);

		FragmentSelectionManager fragmentManager = (FragmentSelectionManager) getHost().getRoot().getContents().getAdapter(FragmentSelectionManager.class);
		if (fragmentManager != null && fragmentManager.getSelectedFragment() != null) {
			CreateElementRequestAdapter requestAdapter = null;
			if (request instanceof CreateConnectionViewAndElementRequest) {
				// get the element descriptor
				requestAdapter = ((CreateConnectionViewAndElementRequest) request).getConnectionViewAndElementDescriptor().getCreateElementRequestAdapter();
			}
			if (requestAdapter != null) {
				// get the semantic request
				CreateElementRequest createElementRequest = (CreateElementRequest) requestAdapter.getAdapter(CreateElementRequest.class);
				createElementRequest.setContainer(fragmentManager.getSelectedFragment());
			}
		}
		
		return command;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.GraphicalNodeEditPolicy#getConnectionAndRelationshipCompleteCommand(org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest)
	 */
	@Override
	protected Command getConnectionAndRelationshipCompleteCommand(CreateConnectionViewAndElementRequest request) {
		Object source = request.getSourceEditPart().getAdapter(InputConnector.class);
		Object target = request.getTargetEditPart().getAdapter(OutputConnector.class);
		if (source != null && target != null) {
			EditPart realSourceEditPart = request.getTargetEditPart();
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
	 * @see org.eclipse.gef.editpolicies.AbstractEditPolicy#getHost()
	 */
	@Override
	public IGraphicalEditPart getHost() {
		return (IGraphicalEditPart) super.getHost();
	}

}
