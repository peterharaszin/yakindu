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

package org.esmp.dsm.diagram.core.internal.edithelper;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelper;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.esmp.dsm.diagram.core.internal.commands.CreateConnectionCommand;
import org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage;
import org.esmp.dsm.semantic.blockdiagram.Port;
import org.esmp.dsm.semantic.blockdiagram.util.BlockDiagramUtil;

public class BlockDiagramEditHelper extends AbstractEditHelper {
	
	protected ICommand getCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (BlockDiagramPackage.eINSTANCE.getConnection().isSuperTypeOf(req.getElementType().getEClass())) {
	        Port sourcePort = null;
	        Port targetPort = null;
	        if (req.getSource() instanceof Port) {
	        	sourcePort = (Port) req.getSource();
	        }
	        if (req.getTarget() instanceof Port) {
	        	targetPort = (Port) req.getTarget();
	        }
	        if (BlockDiagramUtil.canConnectOutgoingConnection(sourcePort)) {
		        if (targetPort == null) {
					return super.getCreateRelationshipCommand(req);
		        }
				if (BlockDiagramUtil.canConnectIncomingConnection(targetPort)) {
					return new CreateConnectionCommand(req);
				}
	        }
			return null;
		}
		return super.getCreateRelationshipCommand(req);
	}
	
}
