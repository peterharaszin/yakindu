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

package org.esmp.dsm.diagram.core.internal.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.ConfigureElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.esmp.dsm.diagram.core.internal.util.ConfigureUtil;
import org.esmp.dsm.semantic.blockdiagram.Output;
import org.esmp.dsm.semantic.blockdiagram.OutputPort;

/**
 * @author Andreas Unger
 *
 */
public class ConfigureOutputPortCommand extends ConfigureElementCommand {

	public ConfigureOutputPortCommand(ConfigureRequest request, EClass configurableType) {
        super(request);
        setEClass(configurableType);
    }
    
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		ConfigureRequest request = (ConfigureRequest) getRequest();
		OutputPort outputPort = (OutputPort) request.getElementToConfigure();
    	Output output = outputPort.getOutput();
    	ConfigureUtil.configureParameters(outputPort, output.getSpecification());
    	return CommandResult.newOKCommandResult(outputPort);
	}
	
}
