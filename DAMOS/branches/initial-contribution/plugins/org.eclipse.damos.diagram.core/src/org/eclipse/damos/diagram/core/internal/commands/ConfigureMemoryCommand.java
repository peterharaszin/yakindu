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
import org.eclipse.damos.dml.DMLFactory;
import org.eclipse.damos.dml.Input;
import org.eclipse.damos.dml.Memory;
import org.eclipse.damos.dml.Output;
import org.eclipse.damos.dml.util.DMLUtil;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.ConfigureElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;

public class ConfigureMemoryCommand extends ConfigureElementCommand {
	
    public ConfigureMemoryCommand(ConfigureRequest request, EClass configurableType) {
        super(request);
        setEClass(configurableType);
    }
    
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		ConfigureRequest request = (ConfigureRequest) getRequest();
    	Memory memory = (Memory) request.getElementToConfigure();
    	
    	memory.setName(DMLUtil.findAvailableComponentName(memory.getEnclosingFragment(), "Memory"));

    	Input input = DMLFactory.eINSTANCE.createMemoryInitialCondition();
    	input.getPorts().add(DMLFactory.eINSTANCE.createInputPort());
    	memory.getInputs().add(input);
    	
    	input = DMLFactory.eINSTANCE.createMemoryInput();
    	input.getPorts().add(DMLFactory.eINSTANCE.createInputPort());
    	memory.getInputs().add(input);

    	Output output = DMLFactory.eINSTANCE.createMemoryOutput();
    	output.getPorts().add(DMLFactory.eINSTANCE.createOutputPort());
    	memory.getOutputs().add(output);

    	return CommandResult.newOKCommandResult(memory);
	}
		
}
