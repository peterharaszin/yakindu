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

package org.eclipselabs.damos.diagram.core.internal.commands;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateRelationshipCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipselabs.damos.dml.Connection;
import org.eclipselabs.damos.dml.Fragment;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.dml.OutputPort;
import org.eclipselabs.damos.dml.Port;
import org.eclipselabs.damos.dml.util.DMLUtil;

public class CreateConnectionCommand extends CreateRelationshipCommand {
	
	public CreateConnectionCommand(CreateRelationshipRequest request) {
		super(request);
		setElementToEdit(request.getContainer());
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
		if (canConnectPorts((Port) getSource(), (Port) getTarget())) {
			return super.canExecute();
		}
		return false;
	}
	
	private boolean canConnectPorts(Port sourcePort, Port targetPort) {
		return DMLUtil.canConnectOutgoingConnection(sourcePort)
				&& getElementToEdit() instanceof Fragment
				&& DMLUtil.canConnectIncomingConnection(targetPort, ((Fragment) getElementToEdit()));
	}

}
