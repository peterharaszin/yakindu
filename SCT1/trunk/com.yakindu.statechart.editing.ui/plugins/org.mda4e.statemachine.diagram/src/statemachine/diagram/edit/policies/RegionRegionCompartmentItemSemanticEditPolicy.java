/**
 * Copyright (c) 2006-2009 committers of mda4e and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of mda4e (http://www.mda4e.org/) - initial API and implementation
 *
 */
package statemachine.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import statemachine.StatemachinePackage;
import statemachine.diagram.edit.commands.FinalStateCreateCommand;
import statemachine.diagram.edit.commands.Pseudostate2CreateCommand;
import statemachine.diagram.edit.commands.Pseudostate3CreateCommand;
import statemachine.diagram.edit.commands.Pseudostate4CreateCommand;
import statemachine.diagram.edit.commands.Pseudostate5CreateCommand;
import statemachine.diagram.edit.commands.PseudostateCreateCommand;
import statemachine.diagram.edit.commands.StateCreateCommand;
import statemachine.diagram.providers.StatemachineElementTypes;

/**
 * @generated
 */
public class RegionRegionCompartmentItemSemanticEditPolicy extends
		StatemachineBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public RegionRegionCompartmentItemSemanticEditPolicy() {
		super(StatemachineElementTypes.Region_2001);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (StatemachineElementTypes.State_3001 == req.getElementType()) {
			return getGEFWrapper(new StateCreateCommand(req));
		}
		if (StatemachineElementTypes.Pseudostate_3003 == req.getElementType()) {
			return getGEFWrapper(new PseudostateCreateCommand(req));
		}
		if (StatemachineElementTypes.FinalState_3004 == req.getElementType()) {
			return getGEFWrapper(new FinalStateCreateCommand(req));
		}
		if (StatemachineElementTypes.Pseudostate_3005 == req.getElementType()) {
			return getGEFWrapper(new Pseudostate2CreateCommand(req));
		}
		if (StatemachineElementTypes.Pseudostate_3006 == req.getElementType()) {
			return getGEFWrapper(new Pseudostate3CreateCommand(req));
		}
		if (StatemachineElementTypes.Pseudostate_3007 == req.getElementType()) {
			return getGEFWrapper(new Pseudostate4CreateCommand(req));
		}
		if (StatemachineElementTypes.Pseudostate_3008 == req.getElementType()) {
			return getGEFWrapper(new Pseudostate5CreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
