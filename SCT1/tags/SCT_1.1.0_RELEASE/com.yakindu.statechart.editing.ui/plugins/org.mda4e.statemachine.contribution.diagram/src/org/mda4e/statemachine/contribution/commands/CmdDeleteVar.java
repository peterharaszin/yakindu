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
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.mda4e.statemachine.contribution.tools.StaticMethods;

import statemachine.Variable;

/**
 * @author m.muehlbrandt<p>
 * Kommando um eine Variabel zu l�schen.
 *
 */
public class CmdDeleteVar extends AbstractTransactionalCommand {
	
	Variable variable;

	public CmdDeleteVar(TransactionalEditingDomain domain, String label, List<IFile> affectedFiles, Variable variable) {
		super(domain, label, affectedFiles);
		this.variable = variable;
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
			IAdaptable info) throws ExecutionException {
		variable.setName(variable.getName());
		StaticMethods.getStatechart().getDataElement().remove(variable);
		return CommandResult.newOKCommandResult();
	}
}