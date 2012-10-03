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

package org.eclipse.damos.library.vi.ui.figures;

import org.eclipse.damos.diagram.ui.figures.FontColorAwareFigure;
import org.eclipse.damos.diagram.ui.figures.IFigureConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * @author Andreas Unger
 *
 */
public class GaugeContentFigure extends FontColorAwareFigure implements IFigureConstants {

	private int[] points = new int[8];

	private double value;
	private double offset = 5.0 / 8.0;
	private double length = 3.0 / 4.0;
	
	/**
	 * 
	 */
	public GaugeContentFigure() {
		setPreferredSize(1000, 1000);
	}
	
	/**
	 * @return the value
	 */
	public double getValue() {
		return value;
	}
	
	/**
	 * @param value the value to set
	 */
	public void setValue(double value) {
		if (value == this.value) {
			return;
		}
		this.value = value;
		repaint();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.figures.BlockFigure#paintCanvas(org.eclipse.damos.diagram.figures.ICanvasContext)
	 */
	protected void paintFigure(Graphics g) {
		Rectangle border = getBounds().getCopy();
		border.shrink(DEFAULT_LINE_WIDTH_HALF, DEFAULT_LINE_WIDTH_HALF);
		
		Point center = border.getCenter();

		double angle = 2 * Math.PI * (value * length + offset) - Math.PI / 2;
		double radius = Math.min(border.width / 2, border.height / 2);
		double innerRadius = radius / 6;
		
		points[0] = center.x;
		points[1] = center.y;
		points[2] = center.x + (int) (innerRadius * Math.cos(angle + Math.PI / 4));
		points[3] = center.y + (int) (innerRadius * Math.sin(angle + Math.PI / 4));
		points[4] = center.x + (int) (radius * Math.cos(angle));
		points[5] = center.y + (int) (radius * Math.sin(angle));
		points[6] = center.x + (int) (innerRadius * Math.cos(angle - Math.PI / 4));
		points[7] = center.y + (int) (innerRadius * Math.sin(angle - Math.PI / 4));
		
    	g.setForegroundColor(getFontColor());
		g.setLineWidth(DEFAULT_LINE_WIDTH);
		g.drawLine(center.x, center.y, points[4], points[5]);
		g.setBackgroundColor(getFontColor());
		g.fillPolygon(points);
	}

}
