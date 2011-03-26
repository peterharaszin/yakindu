/****************************************************************************
 * Copyright (c) 2008, 2011 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.diagram.ui.internal.editparts;


import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipselabs.damos.diagram.ui.editpolicies.DeleteSemanticComponentEditPolicy;
import org.eclipselabs.damos.diagram.ui.internal.editpolicies.CompoundConstrainedToolbarLayoutEditPolicy;

/**
 * @author Andreas Unger
 *
 */
public abstract class CompoundEditPart extends AbstractBorderedShapeEditPart {

	/**
	 * @param view
	 */
	public CompoundEditPart(View view) {
		super(view);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart#createDefaultEditPolicies()
	 */
	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new CompoundConstrainedToolbarLayoutEditPolicy());
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new DeleteSemanticComponentEditPolicy());
	}
	
}
