/****************************************************************************
 * Copyright (c) 2008, 2010 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.library.base.ui.discrete.figures;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipselabs.damos.diagram.ui.figures.ICanvasContext;
import org.eclipselabs.damos.diagram.ui.figures.IFigureConstants;
import org.eclipselabs.damos.diagram.ui.figures.RectangularComponentFigure;

/**
 * @author Andreas Unger
 *
 */
public class CounterFigure extends RectangularComponentFigure implements IFigureConstants {

	private static final int SIZE = 160;
	
	private final int[] points = new int[6];
	
	public Dimension calculateMinimumCanvasSize(int wHint, int hHint) {
		if (minSize == null) {
			minSize = getPreferredCanvasSize().getCopy();
			if (minSize.width < minSize.height) {
				minSize.width = minSize.height;
			}
		}
		return minSize;
	}

	protected void paintCanvas(ICanvasContext cc) {
		super.paintCanvas(cc);
		Dimension size = getCanvasSize();
		
		cc.setForegroundColor(getFontColor());
		cc.setBackgroundColor(getFontColor());

		int x = SIZE;
		int center = size.height / 4;
		int y = center - SIZE / 2;
		int signX = x + 3 * SIZE / 4;
		
		points[0] = x;
		points[1] = y;
		points[2] = x + SIZE / 2;
		points[3] = y + SIZE;
		points[4] = x - SIZE / 2;
		points[5] = y + SIZE;
		
		cc.fillPolygon(points);

		center += SIZE / 5;
		cc.drawLine(signX, center, signX + SIZE, center);
		cc.drawLine(signX + SIZE / 2, center - SIZE / 2, signX + SIZE / 2, center + SIZE / 2);

		center = 3 * size.height / 4;
		y = center + SIZE / 2;
				
		points[0] = x;
		points[1] = y;
		points[2] = x - SIZE / 2;
		points[3] = y - SIZE;
		points[4] = x + SIZE / 2;
		points[5] = y - SIZE;
		
		cc.fillPolygon(points);

		center -= SIZE / 5;
		cc.drawLine(signX + SIZE / 5, center, signX + 4 * SIZE / 5, center);
	}

}
