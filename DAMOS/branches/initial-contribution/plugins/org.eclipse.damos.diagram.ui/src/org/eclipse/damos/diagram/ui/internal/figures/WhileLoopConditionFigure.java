/****************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipse.damos.diagram.ui.internal.figures;

import org.eclipse.damos.diagram.ui.figures.IFigureConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * @author Andreas Unger
 *
 */
public class WhileLoopConditionFigure extends CompoundInputConnectorFigure {
	
	private int[] playIconPoints = new int[6];

	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.ui.internal.figures.CompoundConnectorFigure#isInternal()
	 */
	@Override
	protected boolean isInternal() {
		return true;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.ui.internal.figures.CompoundConnectorFigure#paintFigure(org.eclipse.draw2d.Graphics)
	 */
	@Override
	protected void paintFigure(Graphics graphics) {
		super.paintFigure(graphics);
		graphics.setForegroundColor(getFontColor());
		Rectangle bounds = getBounds().getCopy().shrink(9 * IFigureConstants.DEFAULT_LINE_WIDTH_HALF, 7 * IFigureConstants.DEFAULT_LINE_WIDTH_HALF);
		playIconPoints[0] = bounds.x;
		playIconPoints[1] = bounds.y;
		playIconPoints[2] = bounds.right();
		playIconPoints[3] = bounds.y + bounds.height / 2;
		playIconPoints[4] = bounds.x;
		playIconPoints[5] = bounds.bottom();
		graphics.setBackgroundColor(getForegroundColor());
		graphics.drawPolygon(playIconPoints);
	}
	
}
