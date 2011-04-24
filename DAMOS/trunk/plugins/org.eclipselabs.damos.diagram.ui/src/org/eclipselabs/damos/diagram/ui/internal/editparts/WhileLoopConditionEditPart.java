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

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;
import org.eclipse.gmf.runtime.diagram.ui.figures.IBorderItemLocator;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipselabs.damos.diagram.ui.figures.IFigureConstants;
import org.eclipselabs.damos.diagram.ui.internal.figures.CompoundConnectorFigure;

/**
 * @author Andreas Unger
 *
 */
public class WhileLoopConditionEditPart extends AbstractBorderItemEditPart {

	private static final Dimension BORDER_ITEM_OFFSET;
	
	static {
		BORDER_ITEM_OFFSET = CompoundConnectorFigure.DEFAULT_SIZE.getScaled(0.5);
		BORDER_ITEM_OFFSET.expand(IFigureConstants.DEFAULT_LINE_WIDTH, IFigureConstants.DEFAULT_LINE_WIDTH);
	}
	
	/**
	 * @param view
	 */
	public WhileLoopConditionEditPart(View view) {
		super(view);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart#createNodeFigure()
	 */
	@Override
	protected NodeFigure createNodeFigure() {
		return new CompoundConnectorFigure();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderItemEditPart#getBorderItemLocator()
	 */
	@Override
	public IBorderItemLocator getBorderItemLocator() {
		IBorderItemLocator locator = super.getBorderItemLocator();
		if (locator instanceof BorderItemLocator) {
			BorderItemLocator borderItemLocator = (BorderItemLocator) locator;
			borderItemLocator.setBorderItemOffset(BORDER_ITEM_OFFSET);
		}
		return locator;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderItemEditPart#refreshBounds()
	 */
	@Override
	protected void refreshBounds() {
		super.refreshBounds();
		getFigure().revalidate();
	}
	
}
