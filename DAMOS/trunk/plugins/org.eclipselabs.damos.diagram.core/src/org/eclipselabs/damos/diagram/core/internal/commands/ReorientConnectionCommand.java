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
import org.eclipselabs.damos.dml.Connector;
import org.eclipselabs.damos.dml.Fragment;
import org.eclipselabs.damos.dml.InputConnector;
import org.eclipselabs.damos.dml.OutputConnector;
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
			OutputConnector outputPort = (OutputConnector) newEnd;
			reparentConnection(connection, outputPort);
			connection.setSource(outputPort);
		} else if (reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET) {
			InputConnector inputPort = (InputConnector) newEnd;
			reparentConnection(connection, inputPort);
			connection.setTarget(inputPort);
		}
		return CommandResult.newOKCommandResult(connection);
	}
	
	private void reparentConnection(Connection connection, Connector port) {
		Fragment portFragment = DMLUtil.getOwner(port, Fragment.class);
		if (connection.getOwningFragment() != portFragment && DMLUtil.isChildFragment(portFragment, connection.getOwningFragment())) {
			connection.getOwningFragment().getConnections().remove(connection);
			portFragment.getConnections().add(connection);
		}
	}
	
	public boolean canExecute() {
		if (!(newEnd instanceof Connector)) {
			return false;
		}
		Connector newConnector = (Connector) newEnd;
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE
				&& !canReconnectSource(newConnector)) {
			return false;
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET
				&& !canReconnectTarget(newConnector)) {
			return false;
		}
		return super.canExecute();
	}
	
	private boolean canReconnectSource(Connector newSource) {
		return DMLUtil.canConnectOutgoingConnection(newSource);
	}

	private boolean canReconnectTarget(Connector newTarget) {
		Fragment connectionFragment = ((Connection) getElementToEdit()).getOwningFragment();
		Fragment owningFragment = DMLUtil.getOwner(newTarget, Fragment.class);
		if (DMLUtil.isChildFragment(owningFragment, connectionFragment)) {
			connectionFragment = owningFragment;
		}
		return DMLUtil.canConnectIncomingConnection(newTarget, connectionFragment);
	}

}
