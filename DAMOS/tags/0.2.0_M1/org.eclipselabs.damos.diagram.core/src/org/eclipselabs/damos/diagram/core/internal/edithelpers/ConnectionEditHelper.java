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

package org.eclipselabs.damos.diagram.core.internal.edithelpers;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.GetEditContextCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelper;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.GetEditContextRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipselabs.damos.diagram.core.internal.commands.ReorientConnectionCommand;

public class ConnectionEditHelper extends AbstractEditHelper {

	protected ICommand getEditContextCommand(GetEditContextRequest req) {
		IEditCommandRequest editRequest = req.getEditCommandRequest();
		if (editRequest instanceof CreateRelationshipRequest) {
			CreateRelationshipRequest createRelationshipRequest = (CreateRelationshipRequest) editRequest;
			GetEditContextCommand result = new GetEditContextCommand(req);
			result.setEditContext(createRelationshipRequest.getContainer());
			return result;
		}
		return null;
	}

	protected ICommand getReorientRelationshipCommand(ReorientRelationshipRequest req) {
		return new ReorientConnectionCommand(req);
	}

}
