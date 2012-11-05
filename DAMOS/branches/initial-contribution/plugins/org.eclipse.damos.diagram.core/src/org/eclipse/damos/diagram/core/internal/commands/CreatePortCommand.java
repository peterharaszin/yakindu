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

package org.eclipse.damos.diagram.core.internal.commands;

import org.eclipse.damos.dml.Inoutput;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

public class CreatePortCommand extends CreateElementCommand {

	/**
	 * @param editingDomain
	 */
	public CreatePortCommand(CreateElementRequest request) {
		super(request);
		setElementToEdit(request.getContainer());
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand#doDefaultElementCreation()
	 */
	@Override
	protected EObject doDefaultElementCreation() {
		return getInoutput().createPort();
	}

	public boolean canExecute() {
		return getInoutput().canAddPort();
	}
	
	private Inoutput getInoutput() {
		return (Inoutput) getElementToEdit();
	}
	
}
