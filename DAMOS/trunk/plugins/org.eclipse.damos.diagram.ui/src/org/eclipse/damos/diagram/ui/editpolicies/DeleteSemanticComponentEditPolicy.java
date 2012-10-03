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

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ComponentEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.GroupRequestViaKeyboard;

/**
 * @author Andreas Unger
 *
 */
public class DeleteSemanticComponentEditPolicy extends ComponentEditPolicy {

	protected Command createDeleteSemanticCommand(GroupRequest deleteRequest) {
		if (deleteRequest instanceof GroupRequestViaKeyboard) {
			((GroupRequestViaKeyboard) deleteRequest).setShowInformationDialog(false);
		}
		return super.createDeleteSemanticCommand(deleteRequest);
	}
	
	protected boolean shouldDeleteSemantic() {
		return true;
	}
	
}
