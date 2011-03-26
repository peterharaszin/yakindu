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
import org.eclipselabs.damos.dml.Action;
import org.eclipselabs.damos.dml.ActionLink;
import org.eclipselabs.damos.dml.Choice;

public class ReorientActionLinkCommand extends EditElementCommand {

	/**
	 * The reorient direction.
	 */
	private final int reorientDirection;

	private final EObject newEnd;
	
	public ReorientActionLinkCommand(ReorientRelationshipRequest request) {
		super(request.getLabel(), request.getRelationship(), request);
		this.reorientDirection = request.getDirection();
		this.newEnd = request.getNewRelationshipEnd();
	}

	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		ActionLink actionLink = (ActionLink) getElementToEdit();
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) {
			actionLink.setChoice((Choice) newEnd);
		} else if (reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET) {
			actionLink.setAction((Action) newEnd);
		}
		return CommandResult.newOKCommandResult(actionLink);
	}
	
	public boolean canExecute() {
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE && !(newEnd instanceof Choice)) {
			return false;
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET && !(newEnd instanceof Action)) {
			return false;
		}
		return super.canExecute();
	}
	
}
