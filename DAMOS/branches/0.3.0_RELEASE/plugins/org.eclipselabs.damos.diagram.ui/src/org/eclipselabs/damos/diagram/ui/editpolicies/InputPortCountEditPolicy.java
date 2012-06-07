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

package org.eclipselabs.damos.diagram.ui.editpolicies;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.editpolicies.AbstractEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipselabs.damos.diagram.core.type.ElementTypes;
import org.eclipselabs.damos.diagram.ui.internal.requests.IChangePortCountRequestConstants;
import org.eclipselabs.damos.diagram.ui.requests.IRequestConstants;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.Input;
import org.eclipselabs.damos.dml.InputPort;

/**
 * @author Andreas Unger
 * 
 */
public class InputPortCountEditPolicy extends AbstractEditPolicy {

	@Override
	public Command getCommand(Request request) {
		if (IRequestConstants.REQ_ADD_INPUT_PORT.equals(request.getType())) {
			return createAddInputPortCommand(request);
		}
		if (IRequestConstants.REQ_REMOVE_INPUT_PORT.equals(request.getType())) {
			return createRemoveInputPortCommand(request);
		}
		return super.getCommand(request);
	}

	@Override
	public EditPart getTargetEditPart(Request request) {
		if (IRequestConstants.REQ_ADD_INPUT_PORT.equals(request.getType()) || IRequestConstants.REQ_REMOVE_INPUT_PORT.equals(request.getType())) {
			return getHost();
		}
		return super.getTargetEditPart(request);
	}

	protected Command createAddInputPortCommand(Request request) {
		Input input = getInput(request);
		if (input != null) {
			CreateElementRequest createRequest = new CreateElementRequest(getHost().getEditingDomain(),
					input, ElementTypes.INPUT_PORT, DMLPackage.Literals.INPUT__PORTS);
			return new ICommandProxy(ElementTypes.INPUT.getEditCommand(createRequest));
		}
		return UnexecutableCommand.INSTANCE;
	}

	protected Command createRemoveInputPortCommand(Request request) {
		InputPort inputPort = getInputPortToBeRemoved(request);
		if (inputPort != null) {
			DestroyElementRequest destroyRequest = new DestroyElementRequest(((IGraphicalEditPart) getHost())
					.getEditingDomain(), inputPort, false);
			return new ICommandProxy(ElementTypes.INPUT.getEditCommand(destroyRequest));
		}
		return UnexecutableCommand.INSTANCE;
	}
	
	protected InputPort getInputPortToBeRemoved(Request request) {
		Input input = getInput(request);
		if (input != null && input.canRemovePort()) {
			List<InputPort> inputPorts = input.getPorts();
			return inputPorts.get(inputPorts.size() - 1);
		}
		return null;
	}

	protected Input getInput(Request request) {
		EObject o = getHost().resolveSemanticElement();
		if (o instanceof Component) {
			Component component = (Component) o;
			String name = (String) request.getExtendedData().get(IChangePortCountRequestConstants.PARAMETER__NAME);
			if (name != null) {
				return component.getInput(name);
			}
		}
		return null;
	}
	
	@Override
	public IGraphicalEditPart getHost() {
		return (IGraphicalEditPart) super.getHost();
	}

}
