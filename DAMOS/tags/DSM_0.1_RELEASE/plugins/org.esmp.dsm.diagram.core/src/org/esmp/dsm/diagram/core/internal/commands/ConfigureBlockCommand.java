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

import java.io.IOException;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.ConfigureElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.esmp.dsm.diagram.core.internal.requests.RequestParameterConstants;
import org.esmp.dsm.diagram.core.internal.type.IBlockElementType;
import org.esmp.dsm.diagram.core.internal.util.ConfigureUtil;
import org.esmp.dsm.diagram.core.type.ElementTypes;
import org.esmp.dsm.semantic.blockdiagram.Block;
import org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage;
import org.esmp.dsm.semantic.blockdiagram.BlockType;
import org.esmp.dsm.semantic.blockdiagram.InputSpecification;
import org.esmp.dsm.semantic.blockdiagram.OutputSpecification;
import org.esmp.dsm.semantic.blockdiagram.util.BlockDiagramUtil;

public class ConfigureBlockCommand extends ConfigureElementCommand {
	
    public ConfigureBlockCommand(ConfigureRequest request, EClass configurableType) {
        super(request);
        setEClass(configurableType);
    }
    
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		ConfigureRequest request = (ConfigureRequest) getRequest();
    	Block block = (Block) request.getElementToConfigure();

    	IBlockElementType elementType = (IBlockElementType) getElementType();
		BlockType blockType = null;
		
		try {
			ResourceSet resourceSet = null;
			Resource blockResource = block.eResource();
			if (blockResource != null) {
				resourceSet = blockResource.getResourceSet();
			}
			if (resourceSet == null) {
				resourceSet = new ResourceSetImpl();
			}
			
			Resource blockTypeResource = resourceSet.createResource(elementType.getBlockTypeURI());
			blockTypeResource.load(null);
			
			List<EObject> contents = blockTypeResource.getContents();
			if (contents.isEmpty() || !(contents.get(0) instanceof BlockType)) {
				throw new ExecutionException("Block type resource '" + elementType.getBlockTypeURI() + "' contains invalid data");
			}
			blockType = (BlockType) contents.get(0);
		} catch (IOException e) {
			throw new ExecutionException("Loading block type resource '" + elementType.getBlockTypeURI() + "' failed", e);
		}
		
    	block.setType(blockType);
    	
		ConfigureUtil.configureParameters(block);
		configureInputs(block);
		configureOutputs(block);

		String name = blockType.getName().trim().replaceAll("\\s", "_");
    	if (name.length() == 0) {
    		name = "Block";
    	}
    	block.setName(BlockDiagramUtil.findAvailableBlockName(block.getBlockDiagram(), name));

		return CommandResult.newOKCommandResult(block);
	}
	
	private void configureInputs(Block block) throws ExecutionException {
		for (InputSpecification spec : block.getType().getInputs()) {
			CreateElementRequest createRequest = new CreateElementRequest(
                    getEditingDomain(),
                    block,
                    ElementTypes.INPUT,
                    BlockDiagramPackage.eINSTANCE.getBlock_Inputs());
            createRequest.setParameter(RequestParameterConstants.INPUT_SPECIFICATION, spec);
            ICommand command = ElementTypes.BLOCK.getEditCommand(createRequest);
            command.execute(null, null);
		}
	}
	
	private void configureOutputs(Block block) throws ExecutionException {
		for (OutputSpecification spec : block.getType().getOutputs()) {
			CreateElementRequest createRequest = new CreateElementRequest(
                    getEditingDomain(),
                    block,
                    ElementTypes.OUTPUT,
                    BlockDiagramPackage.eINSTANCE.getBlock_Outputs());
            createRequest.setParameter(RequestParameterConstants.OUTPUT_SPECIFICATION, spec);
            ICommand command = ElementTypes.BLOCK.getEditCommand(createRequest);
            command.execute(null, null);
		}
	}
	
}
