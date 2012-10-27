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

package org.eclipse.damos.diagram.ui.tools;

import org.eclipse.damos.diagram.core.internal.provider.ISystemInterfaceProvider;
import org.eclipse.damos.diagram.core.type.ElementTypes;
import org.eclipse.damos.diagram.ui.internal.providers.SystemInterfaceProvider;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.tools.CreationTool;

/**
 * @author Andreas Unger
 *
 */
public class SubsystemCreationTool extends CreationTool {

	private EditingDomain editingDomain;

	/**
	 * 
	 */
	public SubsystemCreationTool(EditingDomain editingDomain) {
		super(ElementTypes.SUBSYSTEM);
		this.editingDomain = editingDomain;
	}
	
	@SuppressWarnings("unchecked")
	protected Request createTargetRequest() {
		Request request = super.createTargetRequest();
		request.getExtendedData().put(ISystemInterfaceProvider.class, new SystemInterfaceProvider(editingDomain));
		return request;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gef.tools.AbstractTool#executeCommand(org.eclipse.gef.commands.Command)
	 */
	@Override
	protected void executeCommand(Command command) {
		refreshCursor();
		super.executeCommand(command);
	}

}
