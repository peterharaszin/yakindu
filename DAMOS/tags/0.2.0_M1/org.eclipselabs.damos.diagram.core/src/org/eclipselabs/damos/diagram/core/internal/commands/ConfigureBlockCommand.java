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
import org.eclipselabs.damos.diagram.core.internal.requests.IRequestParameterConstants;
import org.eclipselabs.damos.diagram.core.internal.util.ConfigureUtil;
import org.eclipselabs.damos.diagram.core.type.ElementTypes;
import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.BlockType;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.InputDefinition;
import org.eclipselabs.damos.dml.OutputDefinition;
import org.eclipselabs.damos.dml.util.DMLUtil;

public class ConfigureBlockCommand extends ConfigureElementCommand {
	
    public ConfigureBlockCommand(ConfigureRequest request, EClass configurableType) {
        super(request);
        setEClass(configurableType);
    }
    
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		ConfigureRequest request = (ConfigureRequest) getRequest();
    	Block block = (Block) request.getElementToConfigure();

		BlockType blockType = (BlockType) request.getParameters().get(BlockType.class);
    	block.setType(blockType);
    	
		ConfigureUtil.configureParameters(block);
		configureInputs(block);
		configureOutputs(block);

		String name = blockType.getName();
    	if (name.length() == 0) {
    		name = "Block";
    	}
    	block.setName(DMLUtil.findAvailableComponentName(block.getOwningFragment(), name));

		return CommandResult.newOKCommandResult(block);
	}
	
	private void configureInputs(Block block) throws ExecutionException {
		for (InputDefinition definition : block.getType().getInputDefinitions()) {
			CreateElementRequest createRequest = new CreateElementRequest(
                    getEditingDomain(),
                    block,
                    ElementTypes.BLOCK_INPUT,
                    DMLPackage.Literals.COMPONENT__INPUTS);
            createRequest.setParameter(IRequestParameterConstants.INPUT_DEFINITION, definition);
            ICommand command = ElementTypes.BLOCK.getEditCommand(createRequest);
            command.execute(null, null);
		}
	}
	
	private void configureOutputs(Block block) throws ExecutionException {
		for (OutputDefinition definition : block.getType().getOutputDefinitions()) {
			CreateElementRequest createRequest = new CreateElementRequest(
                    getEditingDomain(),
                    block,
                    ElementTypes.BLOCK_OUTPUT,
                    DMLPackage.Literals.COMPONENT__OUTPUTS);
            createRequest.setParameter(IRequestParameterConstants.OUTPUT_DEFINITION, definition);
            ICommand command = ElementTypes.BLOCK.getEditCommand(createRequest);
            command.execute(null, null);
		}
	}
	
}
