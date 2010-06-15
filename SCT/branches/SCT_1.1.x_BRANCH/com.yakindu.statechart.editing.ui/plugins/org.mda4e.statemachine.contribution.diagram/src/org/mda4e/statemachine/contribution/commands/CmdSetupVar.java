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

import statemachine.DataTypes;
import statemachine.IOTypes;
import statemachine.Variable;

/**
 * @author m.muehlbrandt<p>
 * Dieses Kommando dient zur �nderung bereits angelegter Variablen (z. B. Namens�nderung).
 *
 */
public class CmdSetupVar extends AbstractTransactionalCommand {
	
	private Variable variable;
	private String newName;
	private DataTypes newDataType;
	private IOTypes newIOType;
	private int newPort;

	public CmdSetupVar(TransactionalEditingDomain domain, String label, List<IFile> affectedFiles,Variable variable, DataTypes newDataType, IOTypes newIOType, String newName,int newPort) {
		super(domain, label, affectedFiles);
		this.variable = variable;
		this.newName = newName;
		this.newDataType = newDataType;
		this.newIOType = newIOType;
		this.newPort = newPort;
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
			IAdaptable info) throws ExecutionException {
		variable.setName(newName);
		variable.setDataType(newDataType);
		variable.setIoType(newIOType);
		variable.setPort(newPort);
		return null;
	}
}