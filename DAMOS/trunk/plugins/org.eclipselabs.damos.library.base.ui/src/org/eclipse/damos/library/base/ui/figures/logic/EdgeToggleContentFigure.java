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

package org.eclipse.damos.library.base.ui.figures.logic;

import org.eclipse.damos.diagram.ui.figures.FontColorAwareFigure;
import org.eclipse.damos.diagram.ui.figures.IFigureConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * @author Andreas Unger
 *
 */
public class EdgeToggleContentFigure extends FontColorAwareFigure implements IFigureConstants {
	
	private final int[] points = new int[6];
	
	/**
	 * 
	 */
	public EdgeToggleContentFigure() {
		setPreferredSize(400, 400);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.figures.BlockFigure#paintCanvas(org.eclipse.damos.diagram.figures.ICanvasContext)
	 */
	protected void paintFigure(Graphics g) {
		g.setForegroundColor(getFontColor());
		g.setLineWidth(DEFAULT_LINE_WIDTH);

		Rectangle bounds = getBounds().getShrinked(DEFAULT_LINE_WIDTH_HALF, DEFAULT_LINE_WIDTH_HALF);
		
		int arrowSize = 2 * Math.min(bounds.width, bounds.height) / 5;
		int arrowSizeHalf = arrowSize / 2;
		
		points[0] = bounds.x + arrowSize;
		points[1] = bounds.bottom() - arrowSizeHalf;
		points[2] = bounds.x + arrowSizeHalf;
		points[3] = bounds.bottom() - arrowSizeHalf;
		points[4] = bounds.x + arrowSizeHalf;
		points[5] = bounds.y + arrowSizeHalf;
		
		g.drawPolyline(points);

		points[0] = bounds.right() - arrowSize;
		points[1] = bounds.y + arrowSizeHalf;
		points[2] = bounds.right() - arrowSizeHalf;
		points[3] = bounds.y + arrowSizeHalf;
		points[4] = bounds.right() - arrowSizeHalf;
		points[5] = bounds.bottom() - arrowSizeHalf;
		
		g.drawPolyline(points);
		
		points[0] = bounds.x;
		points[1] = bounds.y + arrowSize;
		points[2] = bounds.x + arrowSizeHalf;
		points[3] = bounds.y + arrowSizeHalf;
		points[4] = bounds.x + arrowSize;
		points[5] = bounds.y + arrowSize;
		
		g.drawPolyline(points);

		points[0] = bounds.right();
		points[1] = bounds.bottom() - arrowSize;
		points[2] = bounds.right() - arrowSizeHalf;
		points[3] = bounds.bottom() - arrowSizeHalf;
		points[4] = bounds.right() - arrowSize;
		points[5] = bounds.bottom() - arrowSize;
		
		g.drawPolyline(points);
	}

}
