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
public class ResetFlipAndRotateComponentCommand extends AbstractTransactionalCommand {

	private Node node;
	
	/**
	 * @param editingDomain
	 */
	public ResetFlipAndRotateComponentCommand(TransactionalEditingDomain editingDomain, Node node) {
		super(editingDomain, "Reset Flip and Rotate Block", null);
		this.node = node;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor, org.eclipse.core.runtime.IAdaptable)
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		RotatableBounds l = (RotatableBounds) node.getLayoutConstraint();

		l.setFlipped(false);

		if (l.getRotation() == 90 || l.getRotation() == 270) {
			int width = l.getWidth();
			int height = l.getHeight();
			l.setWidth(height);
			l.setHeight(width);
		}

		l.setRotation(0);
			
		return CommandResult.newOKCommandResult();
	}

	public boolean canExecute() {
		if (node != null && node.getLayoutConstraint() instanceof RotatableBounds) {
			RotatableBounds l = (RotatableBounds) node.getLayoutConstraint();
			if (l.isFlipped() || l.getRotation() != 0) {
				return super.canExecute();
			}
		}
		return false;
	}
	
}
