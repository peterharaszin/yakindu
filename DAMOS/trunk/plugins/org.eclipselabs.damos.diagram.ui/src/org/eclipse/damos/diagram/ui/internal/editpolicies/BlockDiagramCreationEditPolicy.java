/****************************************************************************
 * Copyright (c) 2008, 2010 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipse.damos.diagram.ui.internal.editpolicies;

import org.eclipse.damos.dml.util.FragmentSelectionManager;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

/**
 * @author Andreas Unger
 *
 */
public class BlockDiagramCreationEditPolicy extends CreationEditPolicy {

	public Command getCommand(Request request) {
		FragmentSelectionManager fragmentManager = (FragmentSelectionManager) getHost().getAdapter(FragmentSelectionManager.class);
		if (fragmentManager != null && fragmentManager.getSelectedFragment() != null) {
			CreateElementRequestAdapter requestAdapter = null;
			if (request instanceof CreateViewAndElementRequest) {
				// get the element descriptor
				requestAdapter = ((CreateViewAndElementRequest) request).getViewAndElementDescriptor().getCreateElementRequestAdapter();
			} else if (request instanceof CreateConnectionViewAndElementRequest) {
				// get the element descriptor
				requestAdapter = ((CreateConnectionViewAndElementRequest) request).getConnectionViewAndElementDescriptor().getCreateElementRequestAdapter();
			}
			if (requestAdapter != null) {
				// get the semantic request
				CreateElementRequest createElementRequest = (CreateElementRequest) requestAdapter.getAdapter(CreateElementRequest.class);
				createElementRequest.setContainer(fragmentManager.getSelectedFragment());
			}
		}
		return super.getCommand(request);
	}

}
