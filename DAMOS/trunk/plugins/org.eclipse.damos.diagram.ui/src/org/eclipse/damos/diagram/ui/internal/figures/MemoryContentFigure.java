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

import org.eclipse.damos.diagram.ui.figures.FontColorAwareFigure;
import org.eclipse.damos.diagram.ui.figures.IFigureConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * @author Andreas Unger
 *
 */
public class MemoryContentFigure extends FontColorAwareFigure {

	private static final int RECTANGLE_SIZE = 160;
	
	private static final int ARROW_SIZE = 80;
	
	private int[] loopPoints = new int[10];
	private int[] decorationPoints = new int[6];
	
	/**
	 * 
	 */
	public MemoryContentFigure() {
		setPreferredSize(400, 400);
	}
	
	protected void paintFigure(Graphics g) {
		g.setForegroundColor(getFontColor());
		g.setLineWidth(IFigureConstants.DEFAULT_LINE_WIDTH);
		Rectangle border = getBounds().getCopy().shrink(IFigureConstants.DEFAULT_LINE_WIDTH_HALF, IFigureConstants.DEFAULT_LINE_WIDTH_HALF);

		g.drawRectangle(border.x, border.y, RECTANGLE_SIZE, RECTANGLE_SIZE);
		
		loopPoints[0] = border.x + RECTANGLE_SIZE;
		loopPoints[1] = border.y + RECTANGLE_SIZE / 2;
		loopPoints[2] = border.x + border.width;
		loopPoints[3] = border.y + RECTANGLE_SIZE / 2;
		loopPoints[4] = border.x + border.width;
		loopPoints[5] = border.y + border.height;
		loopPoints[6] = border.x + RECTANGLE_SIZE / 2;
		loopPoints[7] = border.y + border.height;
		loopPoints[8] = border.x + RECTANGLE_SIZE / 2;
		loopPoints[9] = border.y + RECTANGLE_SIZE;
		g.drawPolyline(loopPoints);
		
		decorationPoints[0] = border.x + RECTANGLE_SIZE / 2 - ARROW_SIZE;
		decorationPoints[1] = border.y + RECTANGLE_SIZE + ARROW_SIZE + IFigureConstants.DEFAULT_LINE_WIDTH;
		decorationPoints[2] = border.x + RECTANGLE_SIZE / 2;
		decorationPoints[3] = border.y + RECTANGLE_SIZE + IFigureConstants.DEFAULT_LINE_WIDTH;
		decorationPoints[4] = border.x + RECTANGLE_SIZE / 2 + ARROW_SIZE;
		decorationPoints[5] = border.y + RECTANGLE_SIZE + ARROW_SIZE + IFigureConstants.DEFAULT_LINE_WIDTH;
		g.drawPolyline(decorationPoints);
	}

}
