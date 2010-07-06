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
public class AdjustInputCountEditPolicy extends AbstractEditPolicy {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.gef.editpolicies.AbstractEditPolicy#getCommand(org.eclipse
	 * .gef.Request)
	 */
	public Command getCommand(Request request) {
		if (IRequestConstants.REQ_ADD_INPUT.equals(request.getType())) {
			return createAddInputCommand();
		}
		if (IRequestConstants.REQ_REMOVE_INPUT.equals(request.getType())) {
			return createRemoveInputCommand();
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
		if (IRequestConstants.REQ_ADD_INPUT.equals(request.getType()) || IRequestConstants.REQ_REMOVE_INPUT.equals(request.getType())) {
			return getHost();
		}
		return super.getTargetEditPart(request);
	}

	protected Command createAddInputCommand() {
		BlockInput input = getInput();
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

	protected Command createRemoveInputCommand() {
		BlockInput input = getInput();
		if (input != null) {
			List<InputPort> inputPorts = input.getPorts();
			if (inputPorts.size() > input.getDefinition().getMinimumPortCount()) {
				DestroyElementRequest destroyRequest = new DestroyElementRequest(((IGraphicalEditPart) getHost())
						.getEditingDomain(), inputPorts.get(inputPorts.size() - 1), false);
				return new ICommandProxy(ElementTypes.BLOCK_INPUT.getEditCommand(destroyRequest));
			}
		}
		return UnexecutableCommand.INSTANCE;
	}

	protected BlockInput getInput() {
		EObject o = ViewUtil.resolveSemanticElement((View) getHost().getModel());
		if (o instanceof Block) {
			List<Input> inputs = ((Block) o).getInputs();
			if (inputs.size() == 1) {
				Input input = inputs.get(0);
				if (input instanceof BlockInput) {
					return (BlockInput) input;
				}
			}
		}
		return null;
	}

}
