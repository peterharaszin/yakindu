/****************************************************************************
 * Copyright (c) 2008, 2011 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.diagram.ui.internal.editpolicies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.SemanticEditPolicy;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;

/**
 * @author Andreas Unger
 *
 */
public class NonDestroySemanticEditPolicy extends SemanticEditPolicy {

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.SemanticEditPolicy#getSemanticCommand(org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest)
	 */
	@Override
	protected Command getSemanticCommand(IEditCommandRequest request) {
		if (request instanceof DestroyElementRequest) {
			return null;
		}
		return super.getSemanticCommand(request);
	}

}
