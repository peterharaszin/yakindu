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

package org.eclipselabs.damos.diagram.ui.internal.tools;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.tools.CreationTool;
import org.eclipselabs.damos.diagram.core.internal.provider.IBlockTypeProvider;
import org.eclipselabs.damos.diagram.core.type.ElementTypes;
import org.eclipselabs.damos.diagram.ui.internal.providers.SelectFileBlockTypeProvider;

/**
 * @author Andreas Unger
 *
 */
public class InstantiateBlockTypeTool extends CreationTool {

	private EditingDomain editingDomain;

	/**
	 * 
	 */
	public InstantiateBlockTypeTool(EditingDomain editingDomain) {
		super(ElementTypes.BLOCK);
		this.editingDomain = editingDomain;
	}
	
	@SuppressWarnings("unchecked")
	protected Request createTargetRequest() {
		Request request = super.createTargetRequest();
		request.getExtendedData().put(IBlockTypeProvider.class, new SelectFileBlockTypeProvider(editingDomain));
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
