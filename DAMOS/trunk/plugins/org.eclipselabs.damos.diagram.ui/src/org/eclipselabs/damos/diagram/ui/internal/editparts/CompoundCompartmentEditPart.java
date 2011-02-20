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

import org.eclipse.draw2d.IFigure;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipselabs.damos.diagram.ui.editpolicies.IEditPolicyRoles;
import org.eclipselabs.damos.diagram.ui.internal.editpolicies.CompoundCompartmentCanonicalEditPolicy;

/**
 * @author Andreas Unger
 *
 */
public class CompoundCompartmentEditPart extends ShapeCompartmentEditPart {

	/**
	 * @param view
	 */
	public CompoundCompartmentEditPart(View view) {
		super(view);
	}

	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		removeEditPolicy(IEditPolicyRoles.CONNECTION_HANDLES_ROLE);
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new CompoundCompartmentCanonicalEditPolicy());
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart#createFigure()
	 */
	@Override
	protected IFigure createFigure() {
		IFigure figure = super.createFigure();
		figure.setBorder(null);
		figure.setToolTip(null);
		return figure;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ResizableCompartmentEditPart#isSelectable()
	 */
	@Override
	public boolean isSelectable() {
		return false;
	}

}
