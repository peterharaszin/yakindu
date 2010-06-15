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

import statemachine.Event;
import statemachine.IOTypes;
import statemachine.StatemachineFactory;
import statemachine.TriggerTypes;
import statemachine.diagram.part.StatemachineDiagramEditorPlugin;

/**
 * @author m.muehlbrandt<p>
 * Kommando zum Erzeugen eines Events.
 *
 */
public class CmdCreateEvent extends AbstractTransactionalCommand {
	
	Event event;
	String newName;
	int newPort;
	TriggerTypes newTriggerType;
	IOTypes newIOType;

	public CmdCreateEvent(TransactionalEditingDomain domain, String label, List<IFile> affectedFiles, TriggerTypes newTriggerType, IOTypes newIOType,int newPort, String newName) {
		super(domain, label, affectedFiles);
		this.newName = newName;
		this.newPort = newPort;
		this.newTriggerType = newTriggerType;
		this.newIOType = newIOType;
	}

	protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
			IAdaptable info) throws ExecutionException {
		StatemachineFactory factory = StatemachineFactory.eINSTANCE;
		event = factory.createEvent();
		StatemachineDiagramEditorPlugin.getInstance().getItemProvidersAdapterFactory().adaptAllNew(event);
		event.setName(newName);
		event.setPort(newPort);
		event.setTrigger(newTriggerType);
		event.setIoType(newIOType);
		StaticMethods.getStatechart().getDataElement().add(event);
		return null;
	}
}