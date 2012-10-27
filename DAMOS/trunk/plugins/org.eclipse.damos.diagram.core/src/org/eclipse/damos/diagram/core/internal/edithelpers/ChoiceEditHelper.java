/****************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipse.damos.diagram.core.internal.edithelpers;

import org.eclipse.damos.diagram.core.internal.commands.ConfigureChoiceCommand;
import org.eclipse.damos.dml.Action;
import org.eclipse.damos.dml.DMLPackage;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelper;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;

public class ChoiceEditHelper extends AbstractEditHelper {

	protected ICommand getConfigureCommand(ConfigureRequest request) {
		return new ConfigureChoiceCommand(request, DMLPackage.Literals.CHOICE);
	}

	protected ICommand getCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (DMLPackage.eINSTANCE.getActionLink().isSuperTypeOf(req.getElementType().getEClass()) && req.getTarget() instanceof Action) {
        	Action action = (Action) req.getTarget();
        	if (action.getLink() != null) {
        		return null;
        	}
		}
		return super.getCreateRelationshipCommand(req);
	}

}
