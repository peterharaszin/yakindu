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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.GetEditContextCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelper;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.GetEditContextRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipselabs.damos.diagram.core.internal.commands.ConfigureActionLinkCommand;
import org.eclipselabs.damos.diagram.core.internal.commands.ReorientActionLinkCommand;
import org.eclipselabs.damos.dml.Action;
import org.eclipselabs.damos.dml.Choice;
import org.eclipselabs.damos.dml.DMLPackage;

public class ActionLinkEditHelper extends AbstractEditHelper {

	protected ICommand getEditContextCommand(GetEditContextRequest request) {
		IEditCommandRequest editRequest = request.getEditCommandRequest();
		if (editRequest instanceof CreateRelationshipRequest) {
			CreateRelationshipRequest createRelationshipRequest = (CreateRelationshipRequest) editRequest;
			EObject source = createRelationshipRequest.getSource();
			if (source instanceof Choice) {
				EObject target = createRelationshipRequest.getTarget();
				if (target == null || target instanceof Action) {
					GetEditContextCommand result = new GetEditContextCommand(request);
					result.setEditContext(source);
					return result;
				}
			}
		}
		return null;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelper#getConfigureCommand(org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest)
	 */
	@Override
	protected ICommand getConfigureCommand(ConfigureRequest request) {
		return new ConfigureActionLinkCommand(request, DMLPackage.Literals.ACTION_LINK);
	}

	protected ICommand getReorientRelationshipCommand(ReorientRelationshipRequest request) {
		return new ReorientActionLinkCommand(request);
	}

}
