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

package org.eclipse.damos.diagram.ui.editpolicies;

import java.util.List;

import org.eclipse.damos.diagram.core.type.ElementTypes;
import org.eclipse.damos.diagram.ui.internal.requests.IChangePortCountRequestConstants;
import org.eclipse.damos.diagram.ui.requests.IRequestConstants;
import org.eclipse.damos.dml.Component;
import org.eclipse.damos.dml.DMLPackage;
import org.eclipse.damos.dml.Output;
import org.eclipse.damos.dml.OutputPort;
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

/**
 * @author Andreas Unger
 * 
 */
public class OutputPortCountEditPolicy extends AbstractEditPolicy {

	@Override
	public Command getCommand(Request request) {
		if (IRequestConstants.REQ_ADD_OUTPUT_PORT.equals(request.getType())) {
			return createAddOutputPortCommand(request);
		}
		if (IRequestConstants.REQ_REMOVE_OUTPUT_PORT.equals(request.getType())) {
			return createRemoveOutputPortCommand(request);
		}
		return super.getCommand(request);
	}

	@Override
	public EditPart getTargetEditPart(Request request) {
		if (IRequestConstants.REQ_ADD_OUTPUT_PORT.equals(request.getType()) || IRequestConstants.REQ_REMOVE_OUTPUT_PORT.equals(request.getType())) {
			return getHost();
		}
		return super.getTargetEditPart(request);
	}

	protected Command createAddOutputPortCommand(Request request) {
		Output output = getOutput(request);
		if (output != null) {
			CreateElementRequest createRequest = new CreateElementRequest(getHost().getEditingDomain(),
					output, ElementTypes.OUTPUT_PORT, DMLPackage.Literals.OUTPUT__PORTS);
			return new ICommandProxy(ElementTypes.OUTPUT.getEditCommand(createRequest));
		}
		return UnexecutableCommand.INSTANCE;
	}

	protected Command createRemoveOutputPortCommand(Request request) {
		OutputPort outputPort = getOutputPortToBeRemoved(request);
		if (outputPort != null) {
			DestroyElementRequest destroyRequest = new DestroyElementRequest(((IGraphicalEditPart) getHost())
					.getEditingDomain(), outputPort, false);
			return new ICommandProxy(ElementTypes.OUTPUT.getEditCommand(destroyRequest));
		}
		return UnexecutableCommand.INSTANCE;
	}

	protected OutputPort getOutputPortToBeRemoved(Request request) {
		Output output = getOutput(request);
		if (output != null && output.canRemovePort()) {
			List<OutputPort> outputPorts = output.getPorts();
			return outputPorts.get(outputPorts.size() - 1);
		}
		return null;
	}

	protected Output getOutput(Request request) {
		EObject o = getHost().resolveSemanticElement();
		if (o instanceof Component) {
			Component component = (Component) o;
			String name = (String) request.getExtendedData().get(IChangePortCountRequestConstants.PARAMETER__NAME);
			if (name != null) {
				return component.getOutput(name);
			}
		}
		return null;
	}
	
	@Override
	public IGraphicalEditPart getHost() {
		return (IGraphicalEditPart) super.getHost();
	}

}
