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

package org.eclipse.damos.library.base.ui.figures;

import org.eclipse.damos.diagram.ui.figures.IFigureConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * @author Andreas Unger
 *
 */
public class DebounceInputPortContentFigure extends Figure {

	private final int[] points = new int[24];
	
	/**
	 * 
	 */
	public DebounceInputPortContentFigure() {
		setPreferredSize(500, 400);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.draw2d.Figure#paintFigure(org.eclipse.draw2d.Graphics)
	 */
	@Override
	protected void paintFigure(Graphics graphics) {
		Rectangle bounds = getBounds().getShrinked(IFigureConstants.DEFAULT_LINE_WIDTH_HALF, 3 * IFigureConstants.DEFAULT_LINE_WIDTH / 2);
		
		int peakWidth = 2 * IFigureConstants.DEFAULT_LINE_WIDTH;
		
		points[0] = bounds.x;
		points[1] = bounds.bottom();
		points[2] = bounds.x + 3 * peakWidth;
		points[3] = bounds.bottom();
		points[4] = points[2];
		points[5] = bounds.y;
		points[6] = points[4] + peakWidth;
		points[7] = bounds.y;
		points[8] = points[6];
		points[9] = bounds.bottom();
		points[10] = points[6] + peakWidth;
		points[11] = bounds.bottom();
		points[12] = points[10];
		points[13] = bounds.y;
		points[14] = points[12] + peakWidth;
		points[15] = bounds.y;
		points[16] = points[14];
		points[17] = bounds.bottom();
		points[18] = points[16] + peakWidth;
		points[19] = bounds.bottom();
		points[20] = points[18];
		points[21] = bounds.y;
		points[22] = bounds.right();
		points[23] = bounds.y;
		
		graphics.setLineWidth(IFigureConstants.DEFAULT_LINE_WIDTH);
		graphics.drawPolyline(points);
	}
	
}
