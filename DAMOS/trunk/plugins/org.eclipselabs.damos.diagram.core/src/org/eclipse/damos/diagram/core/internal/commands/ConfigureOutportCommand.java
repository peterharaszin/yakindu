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
import org.eclipse.damos.dml.DMLFactory;
import org.eclipse.damos.dml.Input;
import org.eclipse.damos.dml.InputPort;
import org.eclipse.damos.dml.Outport;
import org.eclipse.damos.dml.Output;
import org.eclipse.damos.dml.OutputPort;
import org.eclipse.damos.dml.util.DMLUtil;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.ConfigureElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;

public class ConfigureOutportCommand extends ConfigureElementCommand {
	
    public ConfigureOutportCommand(ConfigureRequest request, EClass configurableType) {
        super(request);
        setEClass(configurableType);
    }
    
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		ConfigureRequest request = (ConfigureRequest) getRequest();
    	Outport outport = (Outport) request.getElementToConfigure();
    	outport.setName(DMLUtil.findAvailableComponentName(outport.getEnclosingFragment(), "Out"));

    	Input input = DMLFactory.eINSTANCE.createInput();
    	InputPort inputPort = DMLFactory.eINSTANCE.createInputPort();
    	input.getPorts().add(inputPort);
    	outport.getInputs().add(input);

    	Output output = DMLFactory.eINSTANCE.createOutportOutput();
    	OutputPort outputPort = DMLFactory.eINSTANCE.createOutputPort();
    	output.getPorts().add(outputPort);
    	outport.getOutputs().add(output);

    	return CommandResult.newOKCommandResult(outport);
	}
	
}
