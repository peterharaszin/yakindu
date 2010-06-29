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

package org.esmp.dsm.diagram.core.internal.commands;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateRelationshipCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.esmp.dsm.semantic.blockdiagram.Connection;
import org.esmp.dsm.semantic.blockdiagram.InputPort;
import org.esmp.dsm.semantic.blockdiagram.OutputPort;
import org.esmp.dsm.semantic.blockdiagram.Port;
import org.esmp.dsm.semantic.blockdiagram.util.BlockDiagramUtil;

public class CreateConnectionCommand extends CreateRelationshipCommand {

	public CreateConnectionCommand(CreateRelationshipRequest request) {
		super(request);
	}

	protected EObject doDefaultElementCreation() {
		Connection connection = (Connection) EMFCoreUtil.create(
				getElementToEdit(), getContainmentFeature(), getElementType().getEClass());

		connection.setSourcePort((OutputPort) getSource());
		connection.setTargetPort((InputPort) getTarget());

		return connection;
	}
	
	public boolean canExecute() {
		if (!(getSource() instanceof Port && getTarget() instanceof Port)) {
			return false;
		}
		Port sourcePort = (Port) getSource();
		Port targetPort = (Port) getTarget();
		if (BlockDiagramUtil.canConnectOutgoingConnection(sourcePort) && BlockDiagramUtil.canConnectIncomingConnection(targetPort)) {
			return super.canExecute();
		}
		return false;
	}

}
