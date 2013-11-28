/**
 * Copyright (c) 2006-2009 committers of mda4e and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of mda4e (http://www.mda4e.org/) - initial API and implementation
 *
 */
package org.mda4e.statemachine.contribution.commands;

import java.util.List;


import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;
import org.mda4e.statemachine.contribution.edit.parts.OurStateEditPart;

/**
 * @author m.muehlbrandt<p>
 * 
 *
 */
public class CmdSetStateBackground extends AbstractTransactionalCommand {

	private OurStateEditPart selectedElement;
	private Color color;
	
	public CmdSetStateBackground(TransactionalEditingDomain domain, String label, OurStateEditPart selectedElement, Color color) {
		super(domain, label, null);
		this.selectedElement = selectedElement;
		this.color = color;
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
			IAdaptable info) throws ExecutionException {
		selectedElement.getPrimaryShape().setBackgroundColor(color);
		return null;
	}
	
	@Override
	public List getAffectedFiles()
	    {
	        if(selectedElement != null)
	        {
	            View view = (View)selectedElement.getAdapter(View.class);
	            if(view != null)
	                return getWorkspaceFiles(view);
	        }
	        return super.getAffectedFiles();
	    }

}
