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

import org.eclipse.damos.diagram.core.internal.commands.ConfigureSubsystemCommand;
import org.eclipse.damos.dml.DMLPackage;
import org.eclipse.damos.dml.Subsystem;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelper;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyDependentsRequest;

/**
 * @author Andreas Unger
 *
 */
public class SubsystemEditHelper extends AbstractEditHelper {

	protected ICommand getConfigureCommand(ConfigureRequest request) {
		return new ConfigureSubsystemCommand(request, DMLPackage.Literals.SUBSYSTEM);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelper#getDestroyDependentsCommand(org.eclipse.gmf.runtime.emf.type.core.requests.DestroyDependentsRequest)
	 */
	protected ICommand getDestroyDependentsCommand(DestroyDependentsRequest request) {
		Subsystem subsystem = (Subsystem) request.getElementToDestroy();
		return request.getDestroyDependentsCommand(subsystem.getRealizations());
	}
	
}
