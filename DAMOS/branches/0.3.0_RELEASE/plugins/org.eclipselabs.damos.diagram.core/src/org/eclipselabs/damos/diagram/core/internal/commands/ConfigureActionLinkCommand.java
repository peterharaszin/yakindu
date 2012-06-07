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

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.ConfigureElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipselabs.damos.dml.Action;
import org.eclipselabs.damos.dml.ActionLink;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.registry.InjectorProviderRegistry;
import org.eclipselabs.damos.dml.util.IElementInitializer;

import com.google.inject.Inject;
import com.google.inject.Injector;

public class ConfigureActionLinkCommand extends ConfigureElementCommand {
	
	@Inject
	private IElementInitializer elementInitializer;

    public ConfigureActionLinkCommand(ConfigureRequest request, EClass configurableType) {
        super(request);
        setEClass(configurableType);

        Injector injector = InjectorProviderRegistry.getInstance().getInjector(getElementToEdit());
		if (injector != null) {
			injector.injectMembers(this);
		}
    }
    
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		ConfigureRequest request = (ConfigureRequest) getRequest();
    	ActionLink actionLink = (ActionLink) request.getElementToConfigure();
    	actionLink.setAction((Action) request.getParameter(CreateRelationshipRequest.TARGET));
    	
    	List<ActionLink> actionLinks = actionLink.getChoice().getActionLinks();
    	if (actionLinks.size() < 3) {
	    	if (elementInitializer != null) {
	    		elementInitializer.initialize(actionLink, DMLPackage.eINSTANCE.getActionLink_Condition(), null);
	    	}
    	}
    	
		return CommandResult.newOKCommandResult(actionLink);
	}
		
}
