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
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.ConfigureElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipselabs.damos.diagram.core.internal.requests.RequestParameterConstants;
import org.eclipselabs.damos.diagram.core.type.ElementTypes;
import org.eclipselabs.damos.dml.BlockOutput;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.OutputDefinition;

/**
 * @author Andreas Unger
 *
 */
public class ConfigureBlockOutputCommand extends ConfigureElementCommand {

	/**
	 * 
	 */
	public ConfigureBlockOutputCommand(ConfigureRequest request, EClass configurableType) {
		super(request);
        setEClass(configurableType);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor, org.eclipse.core.runtime.IAdaptable)
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		ConfigureRequest request = (ConfigureRequest) getRequest();
    	BlockOutput output = (BlockOutput) request.getElementToConfigure();
    	OutputDefinition definition = (OutputDefinition) request.getParameter(RequestParameterConstants.OUTPUT_DEFINITION);
    	output.setDefinition(definition);
    	
		for (int i = 0; i < definition.getMinimumPortCount(); ++i) {
			CreateElementRequest createRequest = new CreateElementRequest(
                    getEditingDomain(),
                    output,
                    ElementTypes.BLOCK_OUTPUT_PORT,
                    DMLPackage.Literals.OUTPUT__PORTS);
            ICommand command = ElementTypes.BLOCK_OUTPUT.getEditCommand(createRequest);
            command.execute(null, null);
		}

		return CommandResult.newOKCommandResult(output);
	}

}
