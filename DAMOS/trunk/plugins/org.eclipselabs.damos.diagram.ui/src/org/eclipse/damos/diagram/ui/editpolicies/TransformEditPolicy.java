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

package org.eclipse.damos.diagram.ui.editpolicies;

import org.eclipse.damos.diagram.core.internal.commands.FlipComponentCommand;
import org.eclipse.damos.diagram.core.internal.commands.ResetFlipAndRotateComponentCommand;
import org.eclipse.damos.diagram.core.internal.commands.RotateComponentCommand;
import org.eclipse.damos.diagram.ui.requests.IRequestConstants;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.editpolicies.AbstractEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.Node;

/**
 * @author Andreas Unger
 *
 */
public class TransformEditPolicy extends AbstractEditPolicy {
	
	/* (non-Javadoc)
	 * @see org.eclipse.gef.editpolicies.AbstractEditPolicy#getCommand(org.eclipse.gef.Request)
	 */
	public Command getCommand(Request request) {
		if (IRequestConstants.REQ_FLIP_COMPONENT.equals(request.getType())) {
			return createFlipComponentCommand();
		}
		if (IRequestConstants.REQ_ROTATE_COMPONENT.equals(request.getType())) {
			return createRotateComponentCommand();
		}
		if (IRequestConstants.REQ_RESET_FLIP_AND_ROTATE_COMPONENT.equals(request.getType())) {
			return createResetFlipAndRotateComponentCommand();
		}
		return super.getCommand(request);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gef.editpolicies.AbstractEditPolicy#getTargetEditPart(org.eclipse.gef.Request)
	 */
	public EditPart getTargetEditPart(Request request) {
		if (IRequestConstants.REQ_FLIP_COMPONENT.equals(request.getType())
				|| IRequestConstants.REQ_ROTATE_COMPONENT.equals(request.getType())
				|| IRequestConstants.REQ_RESET_FLIP_AND_ROTATE_COMPONENT.equals(request.getType())) {
			return getHost();
		}
		return super.getTargetEditPart(request);
	}
	
	protected Command createFlipComponentCommand() {
		if (getHost() instanceof IGraphicalEditPart) {
			IGraphicalEditPart host = (IGraphicalEditPart) getHost();
			return new ICommandProxy(new FlipComponentCommand(host.getEditingDomain(), (Node) host.getNotationView()));
		}
		return UnexecutableCommand.INSTANCE; 
	}
	
	protected Command createRotateComponentCommand() {
		if (getHost() instanceof IGraphicalEditPart) {
			IGraphicalEditPart host = (IGraphicalEditPart) getHost();
			return new ICommandProxy(new RotateComponentCommand(host.getEditingDomain(), (Node) host.getNotationView()));
		}
		return UnexecutableCommand.INSTANCE; 
	}
	
	protected Command createResetFlipAndRotateComponentCommand() {
		if (getHost() instanceof IGraphicalEditPart) {
			IGraphicalEditPart host = (IGraphicalEditPart) getHost();
			return new ICommandProxy(new ResetFlipAndRotateComponentCommand(host.getEditingDomain(), (Node) host.getNotationView()));
		}
		return UnexecutableCommand.INSTANCE; 
	}

}
