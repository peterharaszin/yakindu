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
import org.eclipse.damos.diagram.core.internal.provider.ISystemInterfaceProvider;
import org.eclipse.damos.dml.DMLFactory;
import org.eclipse.damos.dml.Inlet;
import org.eclipse.damos.dml.InputPort;
import org.eclipse.damos.dml.Outlet;
import org.eclipse.damos.dml.OutputPort;
import org.eclipse.damos.dml.Subsystem;
import org.eclipse.damos.dml.SubsystemInput;
import org.eclipse.damos.dml.SubsystemOutput;
import org.eclipse.damos.dml.SystemInterface;
import org.eclipse.damos.dml.util.DMLUtil;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.ConfigureElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;

public class ConfigureSubsystemCommand extends ConfigureElementCommand {
	
    public ConfigureSubsystemCommand(ConfigureRequest request, EClass configurableType) {
        super(request);
        setEClass(configurableType);
    }
    
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		ISystemInterfaceProvider provider = (ISystemInterfaceProvider) getRequest().getParameters().get(ISystemInterfaceProvider.class);
		if (provider == null) {
			return CommandResult.newErrorCommandResult("No system interface provider supplied");
		}

		SystemInterface interface_ = provider.getSystemInterface();
		if (interface_ == null) {
			return CommandResult.newCancelledCommandResult();
		}

		ConfigureRequest request = (ConfigureRequest) getRequest();
		Subsystem subsystem = (Subsystem) request.getElementToConfigure();
    	    	
    	subsystem.setName(DMLUtil.findAvailableComponentName(subsystem.getEnclosingFragment(), interface_.getName()));
		subsystem.setInterface(interface_);
		for (Inlet inlet : interface_.getInlets()) {
			SubsystemInput input = DMLFactory.eINSTANCE.createSubsystemInput();
			input.setInlet(inlet);
			InputPort inputPort = DMLFactory.eINSTANCE.createInputPort();
			input.getPorts().add(inputPort);
			subsystem.getInputs().add(input);
		}
		for (Outlet outlet : interface_.getOutlets()) {
			SubsystemOutput output = DMLFactory.eINSTANCE.createSubsystemOutput();
			output.setOutlet(outlet);
			OutputPort outputPort = DMLFactory.eINSTANCE.createOutputPort();
			output.getPorts().add(outputPort);
			subsystem.getOutputs().add(output);
		}

		return CommandResult.newOKCommandResult(subsystem);
	}
	
}
