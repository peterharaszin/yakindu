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
import org.eclipse.damos.dml.Join;
import org.eclipse.damos.dml.Output;
import org.eclipse.damos.dml.util.DMLUtil;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.ConfigureElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;

public class ConfigureJoinCommand extends ConfigureElementCommand {
	
    public ConfigureJoinCommand(ConfigureRequest request, EClass configurableType) {
        super(request);
        setEClass(configurableType);
    }
    
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		ConfigureRequest request = (ConfigureRequest) getRequest();
    	Join join = (Join) request.getElementToConfigure();
    	
    	join.setName(DMLUtil.findAvailableComponentName(join.getEnclosingFragment(), "Join"));

    	Input input = DMLFactory.eINSTANCE.createJoinInput();
    	join.getInputs().add(input);
    	input.createPort();
    	input.createPort();
    	
    	Output output = DMLFactory.eINSTANCE.createOutput();
    	join.getOutputs().add(output);
    	output.createPort();
    	
		return CommandResult.newOKCommandResult(join);
	}
		
}
