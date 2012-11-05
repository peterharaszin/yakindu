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

import org.eclipse.damos.diagram.ui.figures.ICanvasContext;
import org.eclipse.damos.diagram.ui.figures.IFigureConstants;
import org.eclipse.damos.diagram.ui.figures.RectangularComponentFigure;
import org.eclipse.draw2d.geometry.Dimension;

/**
 * @author Andreas Unger
 *
 */
public class LatchFigure extends RectangularComponentFigure {

	private static final int MINIMUM_WIDTH = 800;
	private static final int ARROW_SIZE = 80;
	
	private final int[] points = new int[6];
	
	/* (non-Javadoc)
	 * @see org.eclipse.draw2d.Figure#getMinimumSize(int, int)
	 */
	public Dimension calculateMinimumCanvasSize(int wHint, int hHint) {
		if (minSize == null) {
			minSize = getPreferredCanvasSize().getCopy();
			if (minSize.width < MINIMUM_WIDTH) {
				minSize.width = MINIMUM_WIDTH;
			}
		}
		return minSize;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.ui.figures.ComponentFigure#paintCanvas(org.eclipse.damos.diagram.ui.figures.ICanvasContext)
	 */
	@Override
	protected void paintCanvas(ICanvasContext cc) {
		super.paintCanvas(cc);
		
		Dimension size = getCanvasSize();
		
		int arrowEndX = 3 * size.width / 4;
		int arrowEndY = size.height / 2;
		
		points[0] = arrowEndX - ARROW_SIZE;
		points[1] = arrowEndY - ARROW_SIZE;
		points[2] = arrowEndX;
		points[3] = arrowEndY;
		points[4] = arrowEndX - ARROW_SIZE;
		points[5] = arrowEndY + ARROW_SIZE;

		cc.setLineWidth(IFigureConstants.DEFAULT_LINE_WIDTH);
		cc.setForegroundColor(getFontColor());
		cc.drawLine(size.width / 2, IFigureConstants.DEFAULT_LINE_WIDTH, size.width / 2, size.height - IFigureConstants.DEFAULT_LINE_WIDTH);
		cc.drawLine(size.width / 4, size.height / 2, arrowEndX, arrowEndY);
		cc.drawPolyline(points);
	}
	
}
