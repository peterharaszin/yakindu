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

package org.eclipselabs.damos.diagram.core.internal.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.ConfigureElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipselabs.damos.dml.DMLFactory;
import org.eclipselabs.damos.dml.Inport;
import org.eclipselabs.damos.dml.Input;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.dml.OpaqueDataTypeSpecification;
import org.eclipselabs.damos.dml.Output;
import org.eclipselabs.damos.dml.OutputPort;
import org.eclipselabs.damos.dml.util.DMLUtil;

public class ConfigureInportCommand extends ConfigureElementCommand {
	
    public ConfigureInportCommand(ConfigureRequest request, EClass configurableType) {
        super(request);
        setEClass(configurableType);
    }
    
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		ConfigureRequest request = (ConfigureRequest) getRequest();
    	Inport inport = (Inport) request.getElementToConfigure();
    	inport.setName(DMLUtil.findAvailableComponentName(inport.getEnclosingFragment(), "In"));
    	OpaqueDataTypeSpecification dataTypeSpecification = DMLFactory.eINSTANCE.createOpaqueDataTypeSpecification();
    	dataTypeSpecification.setDataType("");
    	inport.setDataType(dataTypeSpecification);
    	
    	Output output = DMLFactory.eINSTANCE.createOutput();
    	OutputPort outputPort = DMLFactory.eINSTANCE.createOutputPort();
    	output.getPorts().add(outputPort);
    	inport.getOutputs().add(output);

    	Input input = DMLFactory.eINSTANCE.createInput();
    	InputPort inputPort = DMLFactory.eINSTANCE.createInputPort();
    	input.getPorts().add(inputPort);
    	inport.getInputs().add(input);

    	return CommandResult.newOKCommandResult(inport);
	}
	
}
