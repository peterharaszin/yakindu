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
import org.eclipselabs.damos.diagram.ui.internal.requests.IChangePortCountRequestConstants;
import org.eclipselabs.damos.diagram.ui.requests.IRequestConstants;
import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.BlockOutput;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.OutputDefinition;
import org.eclipselabs.damos.dml.OutputPort;

/**
 * @author Andreas Unger
 * 
 */
public class OutputPortCountEditPolicy extends AbstractEditPolicy {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.gef.editpolicies.AbstractEditPolicy#getCommand(org.eclipse
	 * .gef.Request)
	 */
	public Command getCommand(Request request) {
		if (IRequestConstants.REQ_ADD_OUTPUT_PORT.equals(request.getType())) {
			return createAddOutputPortCommand(request);
		}
		if (IRequestConstants.REQ_REMOVE_OUTPUT_PORT.equals(request.getType())) {
			return createRemoveOutputPortCommand(request);
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
		if (IRequestConstants.REQ_ADD_OUTPUT_PORT.equals(request.getType()) || IRequestConstants.REQ_REMOVE_OUTPUT_PORT.equals(request.getType())) {
			return getHost();
		}
		return super.getTargetEditPart(request);
	}

	protected Command createAddOutputPortCommand(Request request) {
		BlockOutput output = getOutput(request);
		if (output != null) {
			OutputDefinition definition = output.getDefinition();
			if (definition.getMaximumPortCount() < 0 || output.getPorts().size() < definition.getMaximumPortCount()) {
				CreateElementRequest createRequest = new CreateElementRequest(((IGraphicalEditPart) getHost()).getEditingDomain(),
						output, ElementTypes.BLOCK_OUTPUT_PORT, DMLPackage.Literals.OUTPUT__PORTS);
				return new ICommandProxy(ElementTypes.BLOCK_OUTPUT.getEditCommand(createRequest));
			}
		}
		return UnexecutableCommand.INSTANCE;
	}

	protected Command createRemoveOutputPortCommand(Request request) {
		OutputPort outputPort = getOutputPortToBeRemoved(request);
		if (outputPort != null) {
			DestroyElementRequest destroyRequest = new DestroyElementRequest(((IGraphicalEditPart) getHost())
					.getEditingDomain(), outputPort, false);
			return new ICommandProxy(ElementTypes.BLOCK_OUTPUT.getEditCommand(destroyRequest));
		}
		return UnexecutableCommand.INSTANCE;
	}

	protected OutputPort getOutputPortToBeRemoved(Request request) {
		BlockOutput output = getOutput(request);
		if (output != null) {
			List<OutputPort> outputPorts = output.getPorts();
			if (outputPorts.size() > output.getDefinition().getMinimumPortCount()) {
				return outputPorts.get(outputPorts.size() - 1);
			}
		}
		return null;
	}

	protected BlockOutput getOutput(Request request) {
		EObject o = ViewUtil.resolveSemanticElement((View) getHost().getModel());
		if (o instanceof Block) {
			Block block = (Block) o;
			String name = (String) request.getExtendedData().get(IChangePortCountRequestConstants.PARAMETER__NAME);
			if (name != null) {
				return block.getOutput(name);
			}
		}
		return null;
	}

}
