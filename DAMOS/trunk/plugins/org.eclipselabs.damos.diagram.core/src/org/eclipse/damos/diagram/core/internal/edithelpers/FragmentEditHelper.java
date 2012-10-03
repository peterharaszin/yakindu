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

package org.eclipse.damos.diagram.core.internal.edithelpers;

import org.eclipse.damos.diagram.core.internal.commands.CreateBlockCommand;
import org.eclipse.damos.diagram.core.internal.commands.CreateConnectionCommand;
import org.eclipse.damos.dml.Connector;
import org.eclipse.damos.dml.DMLPackage;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelper;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;

public class FragmentEditHelper extends AbstractEditHelper {
	
	@Override
	protected ICommand getCreateCommand(CreateElementRequest req) {
		if (DMLPackage.eINSTANCE.getBlock().isSuperTypeOf(req.getElementType().getEClass())) {
			return new CreateBlockCommand(req, DMLPackage.eINSTANCE.getFragment_FragmentElements());
		}
		return super.getCreateCommand(req);
	}

	protected ICommand getCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (DMLPackage.eINSTANCE.getConnection().isSuperTypeOf(req.getElementType().getEClass())) {
	        if (req.getTarget() == null) {
	        	if (req.getSource() instanceof Connector) {
	        		return super.getCreateRelationshipCommand(req);
	        	}
	        } else {
	        	return new CreateConnectionCommand(req);
	        }
			return null;
		}
		return super.getCreateRelationshipCommand(req);
	}
		
}
