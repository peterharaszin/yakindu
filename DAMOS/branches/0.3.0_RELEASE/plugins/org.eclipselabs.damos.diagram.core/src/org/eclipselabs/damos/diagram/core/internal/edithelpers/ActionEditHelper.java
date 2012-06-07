/****************************************************************************
 * Copyright (c) 2008, 2010 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.diagram.core.internal.edithelpers;

import java.util.Collections;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyDependentsRequest;
import org.eclipselabs.damos.diagram.core.internal.commands.ConfigureActionCommand;
import org.eclipselabs.damos.dml.Action;
import org.eclipselabs.damos.dml.DMLPackage;

/**
 * @author Andreas Unger
 *
 */
public class ActionEditHelper extends CompoundEditHelper {

	protected ICommand getConfigureCommand(ConfigureRequest request) {
		return new ConfigureActionCommand(request, DMLPackage.eINSTANCE.getAction());
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelper#getDestroyDependentsCommand(org.eclipse.gmf.runtime.emf.type.core.requests.DestroyDependentsRequest)
	 */
	protected ICommand getDestroyDependentsCommand(DestroyDependentsRequest request) {
		Action action = (Action) request.getElementToDestroy();
		if (action.getLink() != null) {
			return request.getDestroyDependentsCommand(Collections.singleton(action.getLink()));
		}
		return super.getDestroyDependentsCommand(request);
	}

}
