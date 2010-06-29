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

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.esmp.dsm.semantic.blockdiagram.Connection;
import org.esmp.dsm.semantic.blockdiagram.InputPort;
import org.esmp.dsm.semantic.blockdiagram.OutputPort;
import org.esmp.dsm.semantic.blockdiagram.Port;
import org.esmp.dsm.semantic.blockdiagram.util.BlockDiagramUtil;

public class ReorientConnectionCommand extends EditElementCommand {

	/**
	 * The reorient direction.
	 */
	private final int reorientDirection;

	/**
	 * The relationship's new source or target.
	 */
	private final EObject newEnd;
	
	public ReorientConnectionCommand(ReorientRelationshipRequest request) {
		super(request.getLabel(), request.getRelationship(), request);
		this.reorientDirection = request.getDirection();
		this.newEnd = request.getNewRelationshipEnd();
	}

	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		Connection connection = (Connection) getElementToEdit();
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) {
			connection.setSourcePort((OutputPort) newEnd);
		} else if (reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET) {
			connection.setTargetPort((InputPort) newEnd);
		}
		return CommandResult.newOKCommandResult(connection);
	}

	public boolean canExecute() {
		if (!(newEnd instanceof Port)) {
			return false;
		}
		Port port = (Port) newEnd;
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE && !BlockDiagramUtil.canConnectOutgoingConnection(port)) {
			return false;
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET && !BlockDiagramUtil.canConnectIncomingConnection(port)) {
			return false;
		}
		return super.canExecute();
	}

}
