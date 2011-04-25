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

import java.util.ArrayList;
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
import org.eclipselabs.damos.dml.ConditionSpecification;
import org.eclipselabs.damos.dml.DMLFactory;
import org.eclipselabs.damos.dml.OpaqueConditionSpecification;

public class ConfigureActionLinkCommand extends ConfigureElementCommand {
	
	private static final String TRUE = "true";
	private static final String FALSE = "false";
	
    public ConfigureActionLinkCommand(ConfigureRequest request, EClass configurableType) {
        super(request);
        setEClass(configurableType);
    }
    
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		ConfigureRequest request = (ConfigureRequest) getRequest();
    	ActionLink actionLink = (ActionLink) request.getElementToConfigure();
    	actionLink.setAction((Action) request.getParameter(CreateRelationshipRequest.TARGET));
    	
    	List<ActionLink> actionLinks = actionLink.getChoice().getActionLinks();
    	if (actionLinks.size() < 3) {
    		actionLinks = new ArrayList<ActionLink>(actionLinks);
	    	actionLinks.remove(actionLink);
	    	
	    	switch (actionLinks.size()) {
	    	case 0:
	    		setActionLinkCondition(actionLink, TRUE);
	    		break;
	    	case 1:
	    		ConditionSpecification conditionSpecification = actionLinks.get(0).getCondition();
	    		if (conditionSpecification != null) {
					String condition = conditionSpecification.stringCondition();
					if (TRUE.equals(condition)) {
		    			setActionLinkCondition(actionLink, FALSE);
		    		} else if (FALSE.equals(condition)) {
		    			setActionLinkCondition(actionLink, TRUE);
		    		}
	    		}
	    		break;
	    	}
    	}
    	
		return CommandResult.newOKCommandResult(actionLink);
	}
	
	private void setActionLinkCondition(ActionLink actionLink, String condition) {
		OpaqueConditionSpecification conditionSpecification = DMLFactory.eINSTANCE.createOpaqueConditionSpecification();
		conditionSpecification.setCondition(condition);
		actionLink.setCondition(conditionSpecification);
	}
	
}
