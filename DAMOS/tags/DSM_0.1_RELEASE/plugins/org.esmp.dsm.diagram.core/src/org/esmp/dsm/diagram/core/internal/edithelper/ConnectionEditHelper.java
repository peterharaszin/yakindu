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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.emf.type.core.commands.GetEditContextCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelper;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.GetEditContextRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.esmp.dsm.diagram.core.internal.commands.ReorientConnectionCommand;
import org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage;
import org.esmp.dsm.semantic.blockdiagram.Port;
import org.esmp.dsm.semantic.blockdiagram.util.BlockDiagramUtil;

public class ConnectionEditHelper extends AbstractEditHelper {

	protected ICommand getEditContextCommand(GetEditContextRequest req) {
		IEditCommandRequest editRequest = req.getEditCommandRequest();
		if (editRequest instanceof CreateRelationshipRequest) {
			CreateRelationshipRequest createRelationshipRequest = (CreateRelationshipRequest) editRequest;
			if (hasValidSourceAndTarget(createRelationshipRequest)) {
				List<EObject> ports = new ArrayList<EObject>();

				EObject source = createRelationshipRequest.getSource();
				if (source != null) {
					ports.add(source);
				}
				EObject target = createRelationshipRequest.getTarget();
				if (target != null) {
					ports.add(target);
				}

				EObject container = EMFCoreUtil
						.getLeastCommonContainer(ports, BlockDiagramPackage.eINSTANCE.getBlockDiagram());

				GetEditContextCommand result = new GetEditContextCommand(req);
				result.setEditContext(container);
				return result;
			}
		}
		return null;
	}

	private boolean hasValidSourceAndTarget(CreateRelationshipRequest createRelationshipRequest) {
		EObject source = createRelationshipRequest.getSource();
		if (source != null && !(source instanceof Port && BlockDiagramUtil.canConnectOutgoingConnection((Port) source))) {
			return false;
		}
		
		EObject target = createRelationshipRequest.getTarget();
		if (target != null && !(target instanceof Port && BlockDiagramUtil.canConnectIncomingConnection((Port) target))) {
			return false;
		}
		
		return true;
	}

	protected ICommand getReorientRelationshipCommand(ReorientRelationshipRequest req) {
		return new ReorientConnectionCommand(req);
	}

}
