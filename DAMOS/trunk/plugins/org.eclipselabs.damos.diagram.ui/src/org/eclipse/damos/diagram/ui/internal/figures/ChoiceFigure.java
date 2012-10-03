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

package org.eclipse.damos.diagram.ui.internal.figures;

import org.eclipse.damos.diagram.ui.figures.ICanvasContext;
import org.eclipse.damos.diagram.ui.figures.IFigureConstants;
import org.eclipse.damos.diagram.ui.figures.StandardComponentFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * @author Andreas Unger
 *
 */
public class ChoiceFigure extends StandardComponentFigure {

	private static final int CORNER_SIZE = 250;

	private static final Dimension MINIMUM_SIZE = new Dimension(3 * CORNER_SIZE, 3 * CORNER_SIZE);
	
	private final int[] points = new int[16];
	
	/* (non-Javadoc)
	 * @see org.eclipse.draw2d.Figure#getMinimumSize(int, int)
	 */
	public Dimension calculateMinimumCanvasSize(int wHint, int hHint) {
		return MINIMUM_SIZE;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.ui.figures.ComponentFigure#paintCanvas(org.eclipse.damos.diagram.ui.figures.ICanvasContext)
	 */
	@Override
	protected void paintCanvas(ICanvasContext cc) {
		Dimension size = getCanvasSize();
		
		points[0] = CORNER_SIZE;
		points[1] = IFigureConstants.DEFAULT_LINE_WIDTH_HALF;
		points[2] = size.width - CORNER_SIZE;
		points[3] = IFigureConstants.DEFAULT_LINE_WIDTH_HALF;
		points[4] = size.width - IFigureConstants.DEFAULT_LINE_WIDTH_HALF;
		points[5] = CORNER_SIZE;
		points[6] = size.width - IFigureConstants.DEFAULT_LINE_WIDTH_HALF;
		points[7] = size.height - CORNER_SIZE;
		points[8] = size.width - CORNER_SIZE;
		points[9] = size.height - IFigureConstants.DEFAULT_LINE_WIDTH_HALF;
		points[10] = CORNER_SIZE;
		points[11] = size.height - IFigureConstants.DEFAULT_LINE_WIDTH_HALF;
		points[12] = IFigureConstants.DEFAULT_LINE_WIDTH_HALF;
		points[13] = size.height - CORNER_SIZE;
		points[14] = IFigureConstants.DEFAULT_LINE_WIDTH_HALF;
		points[15] = CORNER_SIZE;
		
		cc.setLineWidth(IFigureConstants.DEFAULT_LINE_WIDTH);
		cc.fillPolygon(points);
		cc.drawPolygon(points);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure#getPolygonPoints()
	 */
	@Override
	public PointList getPolygonPoints() {
		Rectangle bounds = getBounds();
		PointList pointList = new PointList(9);
		pointList.addPoint(bounds.x + CORNER_SIZE, bounds.y);
		pointList.addPoint(bounds.right() - CORNER_SIZE, bounds.y);
		pointList.addPoint(bounds.right(), bounds.y + CORNER_SIZE);
		pointList.addPoint(bounds.right(), bounds.bottom() - CORNER_SIZE);
		pointList.addPoint(bounds.right() - CORNER_SIZE, bounds.bottom());
		pointList.addPoint(bounds.x + CORNER_SIZE, bounds.bottom());
		pointList.addPoint(bounds.x, bounds.bottom() - CORNER_SIZE);
		pointList.addPoint(bounds.x, bounds.y + CORNER_SIZE);
		pointList.addPoint(pointList.getFirstPoint());
		return pointList;
	}
	
}
