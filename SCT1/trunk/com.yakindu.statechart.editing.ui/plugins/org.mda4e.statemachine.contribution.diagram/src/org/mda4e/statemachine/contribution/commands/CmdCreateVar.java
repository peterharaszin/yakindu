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

import statemachine.DataTypes;
import statemachine.IOTypes;
import statemachine.StatemachineFactory;
import statemachine.Variable;
import statemachine.diagram.part.StatemachineDiagramEditorPlugin;

/**
 * @author m.muehlbrandt<p>
 * Kommando zum Erzeugen einer Variabel.
 *
 */
public class CmdCreateVar extends AbstractTransactionalCommand {
	
	Variable variable;
	String newName;
	DataTypes newDataType;
	IOTypes newIOType;
	int port;

	public CmdCreateVar(TransactionalEditingDomain domain, String label, List<IFile> affectedFiles,DataTypes newDataType, IOTypes newIOType, String newName, int port) {
		super(domain, label, affectedFiles);
		
		this.newName = newName;
		this.newDataType = newDataType;
		this.newIOType = newIOType;
		this.port = port;
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
			IAdaptable info) throws ExecutionException {
		
		StatemachineFactory factory = StatemachineFactory.eINSTANCE;
		variable = factory.createVariable();
		StatemachineDiagramEditorPlugin.getInstance().getItemProvidersAdapterFactory().adaptAllNew(variable);
		variable.setName(newName);
		variable.setDataType(newDataType);
		variable.setIoType(newIOType);
		variable.setPort(port);
		StaticMethods.getStatechart().getDataElement().add(variable);
		return null;
	}
}