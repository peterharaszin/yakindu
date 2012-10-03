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

package org.eclipse.damos.diagram.core.internal.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.damos.diagram.dmlnotation.RotatableBounds;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Node;

/**
 * @author Andreas Unger
 *
 */
public class FlipComponentCommand extends AbstractTransactionalCommand {

	private Node node;
	
	/**
	 * @param editingDomain
	 */
	public FlipComponentCommand(TransactionalEditingDomain editingDomain, Node node) {
		super(editingDomain, "Flip Block", null);
		this.node = node;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor, org.eclipse.core.runtime.IAdaptable)
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		RotatableBounds l = (RotatableBounds) node.getLayoutConstraint();
		l.setFlipped(!l.isFlipped());
		return CommandResult.newOKCommandResult();
	}

	public boolean canExecute() {
		if (node != null && node.getLayoutConstraint() instanceof RotatableBounds) {
			return super.canExecute();
		}
		return false;
	}
	
}
