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
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipselabs.damos.diagram.ui.figures.IFigureConstants;
import org.eclipselabs.damos.diagram.ui.internal.editpolicies.WhileLoopCanonicalEditPolicy;
import org.eclipselabs.damos.diagram.ui.internal.figures.CompoundConnectorFigure;
import org.eclipselabs.damos.diagram.ui.internal.figures.WhileLoopFigure;

/**
 * @author Andreas Unger
 *
 */
public class WhileLoopEditPart extends CompoundEditPart {

	private static final Dimension BORDER_ITEM_OFFSET;
	
	static {
		BORDER_ITEM_OFFSET = CompoundConnectorFigure.DEFAULT_SIZE.getScaled(0.5);
		BORDER_ITEM_OFFSET.expand(IFigureConstants.DEFAULT_LINE_WIDTH, IFigureConstants.DEFAULT_LINE_WIDTH);
	}

	/**
	 * @param view
	 */
	public WhileLoopEditPart(View view) {
		super(view);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart#createDefaultEditPolicies()
	 */
	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new WhileLoopCanonicalEditPolicy());
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart#createMainFigure()
	 */
	@Override
	protected NodeFigure createMainFigure() {
		return new WhileLoopFigure();
	}

	protected void addBorderItem(IFigure borderItemContainer, IBorderItemEditPart borderItemEditPart) {
		BorderItemLocator locator = new BorderItemLocator(getMainFigure(), PositionConstants.EAST);
		locator.setBorderItemOffset(BORDER_ITEM_OFFSET);
		borderItemContainer.add(borderItemEditPart.getFigure(), locator);
	}

}
