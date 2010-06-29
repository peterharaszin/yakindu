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

package org.esmp.dsm.diagram.ui.editpolicies;

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
import org.esmp.dsm.diagram.core.type.ElementTypes;
import org.esmp.dsm.diagram.ui.requests.RequestConstants;
import org.esmp.dsm.semantic.blockdiagram.Block;
import org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage;
import org.esmp.dsm.semantic.blockdiagram.Input;
import org.esmp.dsm.semantic.blockdiagram.InputPort;
import org.esmp.dsm.semantic.blockdiagram.InputSpecification;

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
		if (RequestConstants.REQ_ADD_INPUT.equals(request.getType())) {
			return createAddInputCommand();
		}
		if (RequestConstants.REQ_REMOVE_INPUT.equals(request.getType())) {
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
		if (RequestConstants.REQ_ADD_INPUT.equals(request.getType()) || RequestConstants.REQ_REMOVE_INPUT.equals(request.getType())) {
			return getHost();
		}
		return super.getTargetEditPart(request);
	}

	protected Command createAddInputCommand() {
		Input input = getInput();
		if (input != null) {
			InputSpecification spec = input.getSpecification();
			if (spec.getMaximumPortCount() < 0 || input.getPorts().size() < spec.getMaximumPortCount()) {
				CreateElementRequest createRequest = new CreateElementRequest(((IGraphicalEditPart) getHost()).getEditingDomain(),
						input, ElementTypes.INPUT_PORT, BlockDiagramPackage.eINSTANCE.getInput_Ports());
				return new ICommandProxy(ElementTypes.INPUT.getEditCommand(createRequest));
			}
		}
		return UnexecutableCommand.INSTANCE;
	}

	protected Command createRemoveInputCommand() {
		Input input = getInput();
		if (input != null) {
			List<InputPort> inputPorts = input.getPorts();
			if (inputPorts.size() > input.getSpecification().getMinimumPortCount()) {
				DestroyElementRequest destroyRequest = new DestroyElementRequest(((IGraphicalEditPart) getHost())
						.getEditingDomain(), inputPorts.get(inputPorts.size() - 1), false);
				return new ICommandProxy(ElementTypes.INPUT.getEditCommand(destroyRequest));
			}
		}
		return UnexecutableCommand.INSTANCE;
	}

	protected Input getInput() {
		EObject o = ViewUtil.resolveSemanticElement((View) getHost().getModel());
		if (o instanceof Block) {
			List<Input> inputs = ((Block) o).getInputs();
			if (inputs.size() == 1) {
				return inputs.get(0);
			}
		}
		return null;
	}

}
