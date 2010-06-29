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
import org.esmp.dsm.semantic.blockdiagram.Output;
import org.esmp.dsm.semantic.blockdiagram.OutputPort;
import org.esmp.dsm.semantic.blockdiagram.OutputSpecification;

/**
 * @author Andreas Unger
 * 
 */
public class AdjustOutputCountEditPolicy extends AbstractEditPolicy {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.gef.editpolicies.AbstractEditPolicy#getCommand(org.eclipse
	 * .gef.Request)
	 */
	public Command getCommand(Request request) {
		if (RequestConstants.REQ_ADD_OUTPUT.equals(request.getType())) {
			return createAddOutputCommand();
		}
		if (RequestConstants.REQ_REMOVE_OUTPUT.equals(request.getType())) {
			return createRemoveOutputCommand();
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
		if (RequestConstants.REQ_ADD_OUTPUT.equals(request.getType()) || RequestConstants.REQ_REMOVE_OUTPUT.equals(request.getType())) {
			return getHost();
		}
		return super.getTargetEditPart(request);
	}

	protected Command createAddOutputCommand() {
		Output output = getOutput();
		if (output != null) {
			OutputSpecification spec = output.getSpecification();
			if (spec.getMaximumPortCount() < 0 || output.getPorts().size() < spec.getMaximumPortCount()) {
				CreateElementRequest createRequest = new CreateElementRequest(((IGraphicalEditPart) getHost()).getEditingDomain(),
						output, ElementTypes.OUTPUT_PORT, BlockDiagramPackage.eINSTANCE.getOutput_Ports());
				return new ICommandProxy(ElementTypes.OUTPUT.getEditCommand(createRequest));
			}
		}
		return UnexecutableCommand.INSTANCE;
	}

	protected Command createRemoveOutputCommand() {
		Output output = getOutput();
		if (output != null) {
			List<OutputPort> outputPorts = output.getPorts();
			if (outputPorts.size() > output.getSpecification().getMinimumPortCount()) {
				DestroyElementRequest destroyRequest = new DestroyElementRequest(((IGraphicalEditPart) getHost())
						.getEditingDomain(), outputPorts.get(outputPorts.size() - 1), false);
				return new ICommandProxy(ElementTypes.OUTPUT.getEditCommand(destroyRequest));
			}
		}
		return UnexecutableCommand.INSTANCE;
	}

	protected Output getOutput() {
		EObject o = ViewUtil.resolveSemanticElement((View) getHost().getModel());
		if (o instanceof Block) {
			List<Output> outputs = ((Block) o).getOutputs();
			if (outputs.size() == 1) {
				return outputs.get(0);
			}
		}
		return null;
	}

}
