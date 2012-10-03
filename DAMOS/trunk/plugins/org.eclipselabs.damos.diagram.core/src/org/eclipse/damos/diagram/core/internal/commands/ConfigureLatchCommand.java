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
import org.eclipse.damos.dml.DMLPackage;
import org.eclipse.damos.dml.Input;
import org.eclipse.damos.dml.Latch;
import org.eclipse.damos.dml.Output;
import org.eclipse.damos.dml.registry.InjectorProviderRegistry;
import org.eclipse.damos.dml.util.DMLUtil;
import org.eclipse.damos.dml.util.IElementInitializer;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.ConfigureElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;

import com.google.inject.Inject;
import com.google.inject.Injector;

public class ConfigureLatchCommand extends ConfigureElementCommand {
	
	@Inject
	private IElementInitializer elementInitializer;

	public ConfigureLatchCommand(ConfigureRequest request, EClass configurableType) {
        super(request);
        setEClass(configurableType);

        Injector injector = InjectorProviderRegistry.getInstance().getInjector(getElementToEdit());
		if (injector != null) {
			injector.injectMembers(this);
		}
    }
    
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		ConfigureRequest request = (ConfigureRequest) getRequest();
		Latch latch = (Latch) request.getElementToConfigure();
    	
    	latch.setName(DMLUtil.findAvailableComponentName(latch.getEnclosingFragment(), "Latch"));
    	if (elementInitializer != null) {
    		elementInitializer.initialize(getElementToEdit().eResource().getResourceSet(), latch, DMLPackage.eINSTANCE.getLatch_InitialValue(), null);
    	}
 
    	Input input = DMLFactory.eINSTANCE.createLatchInput();
    	input.getPorts().add(DMLFactory.eINSTANCE.createInputPort());
    	latch.getInputs().add(input);
    	
    	Output output = DMLFactory.eINSTANCE.createOutput();
    	output.getPorts().add(DMLFactory.eINSTANCE.createOutputPort());
    	latch.getOutputs().add(output);

    	return CommandResult.newOKCommandResult(latch);
	}
		
}
