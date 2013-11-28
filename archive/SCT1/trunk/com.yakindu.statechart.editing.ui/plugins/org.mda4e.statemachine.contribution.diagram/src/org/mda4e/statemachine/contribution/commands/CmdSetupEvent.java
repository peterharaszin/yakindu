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

import statemachine.Event;
import statemachine.IOTypes;
import statemachine.TriggerTypes;

/**
 * @author m.muehlbrandt<p>
 * Dieses Kommando dient zur �nderung bereits angelegter Events (z. B. Namens�nderung).
 *
 */
public class CmdSetupEvent extends AbstractTransactionalCommand {
	
	private Event event;
	private String newName;
	private int port;
	private TriggerTypes newTriggerType;
	private IOTypes newIOType;

	public CmdSetupEvent(TransactionalEditingDomain domain, String label, List<IFile> affectedFiles,Event event, TriggerTypes newTriggerType, IOTypes newIOType,int port, String newName) {
		super(domain, label, affectedFiles);
		this.event = event;
		this.newName = newName;
		this.newTriggerType = newTriggerType;
		this.newIOType = newIOType;
		this.port = port;
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
			IAdaptable info) throws ExecutionException {
		event.setName(newName);
		event.setTrigger(newTriggerType);
		event.setIoType(newIOType);
		event.setPort(port);
		return null;
	}
}