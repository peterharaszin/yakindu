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

package org.eclipselabs.damos.library.base.ui.figures.logic;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipselabs.damos.diagram.ui.figures.IFigureConstants;

/**
 * @author Andreas Unger
 *
 */
public class DebounceOutputPortContentFigure extends Figure {

	private final int[] points = new int[8];

	/**
	 * 
	 */
	public DebounceOutputPortContentFigure() {
		setPreferredSize(500, 400);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.draw2d.Figure#paintFigure(org.eclipse.draw2d.Graphics)
	 */
	@Override
	protected void paintFigure(Graphics graphics) {
		Rectangle bounds = getBounds().getShrinked(IFigureConstants.DEFAULT_LINE_WIDTH_HALF, 3 * IFigureConstants.DEFAULT_LINE_WIDTH / 2);
		
		points[0] = bounds.x;
		points[1] = bounds.bottom();
		points[2] = bounds.x + 6 * IFigureConstants.DEFAULT_LINE_WIDTH;
		points[3] = bounds.bottom();
		points[4] = points[2];
		points[5] = bounds.y;
		points[6] = bounds.right();
		points[7] = bounds.y;
		
		graphics.setLineWidth(IFigureConstants.DEFAULT_LINE_WIDTH);
		graphics.drawPolyline(points);
	}

}
