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
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipselabs.damos.diagram.core.type.ElementTypes;
import org.eclipselabs.damos.diagram.ui.requests.IRequestConstants;
import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.BlockInput;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.Input;
import org.eclipselabs.damos.dml.InputDefinition;
import org.eclipselabs.damos.dml.InputPort;

/**
 * @author Andreas Unger
 * 
 */
public class InputPortCountEditPolicy extends AbstractEditPolicy {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.gef.editpolicies.AbstractEditPolicy#getCommand(org.eclipse
	 * .gef.Request)
	 */
	public Command getCommand(Request request) {
		if (IRequestConstants.REQ_ADD_INPUT_PORT.equals(request.getType())) {
			return createAddInputPortCommand(request);
		}
		if (IRequestConstants.REQ_REMOVE_INPUT_PORT.equals(request.getType())) {
			return createRemoveInputPortCommand(request);
		}
		return super.getCommand(request);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.gef.editpolicies.AbstractEditPolicy#getTargetEditPart(org
	 * .eclipse.gef.Request)
	 */
	public EditPart getTargetEditPart(Request request) {
		if (IRequestConstants.REQ_ADD_INPUT_PORT.equals(request.getType()) || IRequestConstants.REQ_REMOVE_INPUT_PORT.equals(request.getType())) {
			return getHost();
		}
		return super.getTargetEditPart(request);
	}

	protected Command createAddInputPortCommand(Request request) {
		BlockInput input = getInput(request);
		if (input != null) {
			InputDefinition definition = input.getDefinition();
			if (definition.getMaximumPortCount() < 0 || input.getPorts().size() < definition.getMaximumPortCount()) {
				CreateElementRequest createRequest = new CreateElementRequest(((IGraphicalEditPart) getHost()).getEditingDomain(),
						input, ElementTypes.BLOCK_INPUT_PORT, DMLPackage.Literals.INPUT__PORTS);
				return new ICommandProxy(ElementTypes.BLOCK_INPUT.getEditCommand(createRequest));
			}
		}
		return UnexecutableCommand.INSTANCE;
	}

	protected Command createRemoveInputPortCommand(Request request) {
		InputPort inputPort = getInputPortToBeRemoved(request);
		if (inputPort != null) {
			DestroyElementRequest destroyRequest = new DestroyElementRequest(((IGraphicalEditPart) getHost())
					.getEditingDomain(), inputPort, false);
			return new ICommandProxy(ElementTypes.BLOCK_INPUT.getEditCommand(destroyRequest));
		}
		return UnexecutableCommand.INSTANCE;
	}
	
	protected InputPort getInputPortToBeRemoved(Request request) {
		BlockInput input = getInput(request);
		if (input != null) {
			List<InputPort> inputPorts = input.getPorts();
			if (inputPorts.size() > input.getDefinition().getMinimumPortCount()) {
				return inputPorts.get(inputPorts.size() - 1);
			}
		}
		return null;
	}

	protected BlockInput getInput(Request request) {
		EObject o = ViewUtil.resolveSemanticElement((View) getHost().getModel());
		if (o instanceof Block) {
			for (Input input : ((Block) o).getInputs()) {
				if (input instanceof BlockInput && ((BlockInput) input).getDefinition().isManyPorts()) {
					return (BlockInput) input;
				}
			}
		}
		return null;
	}

}
