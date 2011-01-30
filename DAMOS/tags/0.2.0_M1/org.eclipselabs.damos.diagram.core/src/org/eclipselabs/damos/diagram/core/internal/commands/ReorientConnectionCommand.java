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

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipselabs.damos.dml.Connection;
import org.eclipselabs.damos.dml.Fragment;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.dml.OutputPort;
import org.eclipselabs.damos.dml.Port;
import org.eclipselabs.damos.dml.util.DMLUtil;

public class ReorientConnectionCommand extends EditElementCommand {

	/**
	 * The reorient direction.
	 */
	private final int reorientDirection;

	private final EObject newEnd;
	
	public ReorientConnectionCommand(ReorientRelationshipRequest request) {
		super(request.getLabel(), request.getRelationship(), request);
		this.reorientDirection = request.getDirection();
		this.newEnd = request.getNewRelationshipEnd();
	}

	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		Connection connection = (Connection) getElementToEdit();
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) {
			OutputPort outputPort = (OutputPort) newEnd;
			reparentConnection(connection, outputPort);
			connection.setSourcePort(outputPort);
		} else if (reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET) {
			InputPort inputPort = (InputPort) newEnd;
			reparentConnection(connection, inputPort);
			connection.setTargetPort(inputPort);
		}
		return CommandResult.newOKCommandResult(connection);
	}
	
	private void reparentConnection(Connection connection, Port port) {
		Fragment portFragment = port.getComponent().getOwningFragment();
		if (connection.getOwningFragment() != portFragment && DMLUtil.isChildFragment(portFragment, connection.getOwningFragment())) {
			connection.getOwningFragment().getConnections().remove(connection);
			portFragment.getConnections().add(connection);
		}
	}
	
	public boolean canExecute() {
		if (!(newEnd instanceof Port)) {
			return false;
		}
		Port newPort = (Port) newEnd;
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE
				&& !canReconnectSourcePort(newPort)) {
			return false;
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET
				&& !canReconnectTargetPort(newPort)) {
			return false;
		}
		return super.canExecute();
	}
	
	private boolean canReconnectSourcePort(Port newSourcePort) {
		return DMLUtil.canConnectOutgoingConnection(newSourcePort);
	}

	private boolean canReconnectTargetPort(Port newTargetPort) {
		Fragment connectionFragment = ((Connection) getElementToEdit()).getOwningFragment();
		Fragment portFragment = newTargetPort.getComponent().getOwningFragment();
		if (DMLUtil.isChildFragment(portFragment, connectionFragment)) {
			connectionFragment = portFragment;
		}
		return DMLUtil.canConnectIncomingConnection(newTargetPort, connectionFragment);
	}

}
