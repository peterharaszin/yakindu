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

import java.util.Collection;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelper;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyDependentsRequest;
import org.eclipselabs.damos.dml.DMLPackage;

public class PortEditHelper extends AbstractEditHelper {

	private static final EReference[] CONNECTION_PORT_REFERENCES = new EReference[] {
		DMLPackage.eINSTANCE.getConnection_SourcePort(),
		DMLPackage.eINSTANCE.getConnection_TargetPort(),
	};
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelper#getDestroyDependentsCommand(org.eclipse.gmf.runtime.emf.type.core.requests.DestroyDependentsRequest)
	 */
	protected ICommand getDestroyDependentsCommand(DestroyDependentsRequest request) {
		Collection<?> connections = EMFCoreUtil.getReferencers(request.getElementToDestroy(), CONNECTION_PORT_REFERENCES);
		return request.getDestroyDependentsCommand(connections);
	}

}
