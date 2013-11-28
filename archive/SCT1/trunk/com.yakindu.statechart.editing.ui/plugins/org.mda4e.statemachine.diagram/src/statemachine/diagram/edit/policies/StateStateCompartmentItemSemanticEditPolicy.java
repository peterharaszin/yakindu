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
import statemachine.diagram.edit.commands.Region2CreateCommand;
import statemachine.diagram.providers.StatemachineElementTypes;

/**
 * @generated
 */
public class StateStateCompartmentItemSemanticEditPolicy extends
		StatemachineBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public StateStateCompartmentItemSemanticEditPolicy() {
		super(StatemachineElementTypes.State_3001);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (StatemachineElementTypes.Region_3002 == req.getElementType()) {
			return getGEFWrapper(new Region2CreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
