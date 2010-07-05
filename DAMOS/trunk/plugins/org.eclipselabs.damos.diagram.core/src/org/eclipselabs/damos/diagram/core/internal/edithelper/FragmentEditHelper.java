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

package org.eclipselabs.damos.diagram.core.internal.edithelper;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelper;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipselabs.damos.diagram.core.internal.commands.CreateConnectionCommand;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.Port;
import org.eclipselabs.damos.dml.util.DMLUtil;

public class FragmentEditHelper extends AbstractEditHelper {
	
	protected ICommand getCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (DMLPackage.eINSTANCE.getConnection().isSuperTypeOf(req.getElementType().getEClass())) {
	        if (req.getTarget() == null) {
	        	if (req.getSource() instanceof Port && DMLUtil.canConnectOutgoingConnection((Port) req.getSource())) {
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
