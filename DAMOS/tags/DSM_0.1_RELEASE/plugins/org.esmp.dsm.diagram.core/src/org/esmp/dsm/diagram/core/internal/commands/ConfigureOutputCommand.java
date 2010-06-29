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
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.ConfigureElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.esmp.dsm.diagram.core.internal.requests.RequestParameterConstants;
import org.esmp.dsm.diagram.core.type.ElementTypes;
import org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage;
import org.esmp.dsm.semantic.blockdiagram.Output;
import org.esmp.dsm.semantic.blockdiagram.OutputSpecification;

/**
 * @author Andreas Unger
 *
 */
public class ConfigureOutputCommand extends ConfigureElementCommand {

	/**
	 * 
	 */
	public ConfigureOutputCommand(ConfigureRequest request, EClass configurableType) {
		super(request);
        setEClass(configurableType);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor, org.eclipse.core.runtime.IAdaptable)
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		ConfigureRequest request = (ConfigureRequest) getRequest();
    	Output output = (Output) request.getElementToConfigure();
    	OutputSpecification spec = (OutputSpecification) request.getParameter(RequestParameterConstants.OUTPUT_SPECIFICATION);
    	output.setSpecification(spec);
    	
		for (int i = 0; i < spec.getMinimumPortCount(); ++i) {
			CreateElementRequest createRequest = new CreateElementRequest(
                    getEditingDomain(),
                    output,
                    ElementTypes.OUTPUT_PORT,
                    BlockDiagramPackage.eINSTANCE.getOutput_Ports());
            ICommand command = ElementTypes.OUTPUT.getEditCommand(createRequest);
            command.execute(null, null);
		}

		return CommandResult.newOKCommandResult(output);
	}

}
