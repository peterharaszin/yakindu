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

package org.eclipselabs.damos.diagram.ui.internal.editparts;

import org.eclipse.gmf.runtime.notation.View;
import org.eclipselabs.damos.common.util.NameUtil;
import org.eclipselabs.damos.diagram.ui.editparts.StandardBlockEditPart;
import org.eclipselabs.damos.diagram.ui.editpolicies.IEditPolicyRoles;
import org.eclipselabs.damos.diagram.ui.editpolicies.NonRotatableTransformEditPolicy;
import org.eclipselabs.damos.diagram.ui.figures.FunctionBlockFigure;
import org.eclipselabs.damos.dml.Block;

/**
 * @author Andreas Unger
 *
 */
public class FunctionBlockEditPart extends StandardBlockEditPart {

	/**
	 * @param view
	 */
	public FunctionBlockEditPart(View view) {
		super(view);
	}

	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(IEditPolicyRoles.TRANSFORM_ROLE, new NonRotatableTransformEditPolicy());
	}

	@Override
	protected void refreshVisuals() {
		super.refreshVisuals();
		refreshName();
	}

	protected void refreshName() {
		Block block = (Block) resolveSemanticElement();
		if (block != null) {
			getMainFigure().setHeaderText(NameUtil.formatName(block.getType().getName()));
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart#createMainFigure()
	 */
	@Override
	protected FunctionBlockFigure createMainFigure() {
		return new FunctionBlockFigure();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#getFigure()
	 */
	@Override
	public FunctionBlockFigure getMainFigure() {
		return (FunctionBlockFigure) super.getMainFigure();
	}
	
}
