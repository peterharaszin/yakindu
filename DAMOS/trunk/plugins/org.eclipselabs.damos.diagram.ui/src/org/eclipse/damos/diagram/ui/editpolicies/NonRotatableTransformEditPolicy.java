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

import org.eclipse.damos.diagram.ui.requests.IRequestConstants;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;

/**
 * @author Andreas Unger
 *
 */
public class NonRotatableTransformEditPolicy extends TransformEditPolicy {

	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.ui.editpolicies.TransformEditPolicy#getCommand(org.eclipse.gef.Request)
	 */
	public Command getCommand(Request request) {
		if (IRequestConstants.REQ_ROTATE_COMPONENT.equals(request.getType())) {
			return null;
		}
		return super.getCommand(request);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.ui.editpolicies.TransformEditPolicy#getTargetEditPart(org.eclipse.gef.Request)
	 */
	public EditPart getTargetEditPart(Request request) {
		if (IRequestConstants.REQ_ROTATE_COMPONENT.equals(request.getType())) {
			return null;
		}
		return super.getTargetEditPart(request);
	}
	
}
