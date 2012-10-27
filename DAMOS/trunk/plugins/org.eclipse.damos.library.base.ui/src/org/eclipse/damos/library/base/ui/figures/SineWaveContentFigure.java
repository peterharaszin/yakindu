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

import org.eclipse.damos.diagram.ui.figures.FontColorAwareFigure;
import org.eclipse.damos.diagram.ui.figures.IFigureConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * @author Andreas Unger
 *
 */
public class SineWaveContentFigure extends FontColorAwareFigure implements IFigureConstants {
	
	private static final int AMPLITUDE = 1000;
	private static final int[] SINE_VALUES = new int[41];
	private int[] points = new int[2 * SINE_VALUES.length];
	
	{
		double x = 2 * Math.PI / (SINE_VALUES.length - 1);
		for (int i = 0; i < SINE_VALUES.length; ++i) {
			SINE_VALUES[i] = (int) Math.round(-AMPLITUDE * Math.sin(x * i));
		}
	}
	
	/**
	 * 
	 */
	public SineWaveContentFigure() {
		setPreferredSize(400, 400);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.figures.BlockFigure#paintCanvas(org.eclipse.damos.diagram.figures.ICanvasContext)
	 */
	protected void paintFigure(Graphics g) {
		Rectangle border = getBounds().getCopy();
		border.shrink(DEFAULT_LINE_WIDTH_HALF, DEFAULT_LINE_WIDTH_HALF);
		
		for (int i = 0, j = 0; i < points.length; i += 2, ++j) {
			points[i] = j * border.width / (SINE_VALUES.length - 1);
			points[i + 1] = (SINE_VALUES[j] * border.height / AMPLITUDE + border.height) / 2;
		}
		
		g.translate(border.x, border.y);
    	g.setForegroundColor(getFontColor());
		g.setLineWidth(DEFAULT_LINE_WIDTH);
		g.drawPolyline(points);
	}
	
}
