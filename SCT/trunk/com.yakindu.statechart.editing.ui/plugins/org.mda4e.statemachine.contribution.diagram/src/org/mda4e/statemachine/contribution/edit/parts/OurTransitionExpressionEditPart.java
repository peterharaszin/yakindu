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
package org.mda4e.statemachine.contribution.edit.parts;

import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.notation.View;

import statemachine.diagram.edit.parts.TransitionExpressionEditPart;

public class OurTransitionExpressionEditPart extends
		TransitionExpressionEditPart {

	public OurTransitionExpressionEditPart(View view) {
		super(view);
	}
	
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		removeEditPolicy(EditPolicy.COMPONENT_ROLE);
	}
}
