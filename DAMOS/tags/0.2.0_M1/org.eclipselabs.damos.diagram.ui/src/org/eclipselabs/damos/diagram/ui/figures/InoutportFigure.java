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

package org.eclipselabs.damos.diagram.ui.figures;

import org.eclipse.draw2d.geometry.Dimension;

/**
 * @author Andreas Unger
 *
 */
public class InoutportFigure extends StandardComponentFigure implements IFigureConstants {

	private int[] points = new int[10];
	
	public Dimension calculateMinimumCanvasSize(int wHint, int hHint) {
		if (minSize == null) {
			minSize = getPreferredCanvasSize().getCopy();
			if (minSize.width < minSize.height * 3 / 2) {
				minSize.width = minSize.height * 3 / 2;
			}
		}
		return minSize;
	}

	protected void paintCanvas(ICanvasContext cc) {
		Dimension size = getCanvasSize();
		cc.setLineWidth(DEFAULT_LINE_WIDTH);

		cc.drawArc(DEFAULT_LINE_WIDTH_HALF, DEFAULT_LINE_WIDTH_HALF, size.height / 2 - DEFAULT_LINE_WIDTH, size.height - DEFAULT_LINE_WIDTH, 90, 180);
		points[0] = size.height / 4 - DEFAULT_LINE_WIDTH_HALF;
		points[1] = DEFAULT_LINE_WIDTH_HALF;
		points[2] = size.width - size.height / 2 - DEFAULT_LINE_WIDTH_HALF;
		points[3] = DEFAULT_LINE_WIDTH_HALF;
		points[4] = size.width - DEFAULT_LINE_WIDTH_HALF;
		points[5] = size.height / 2;
		points[6] = points[2];
		points[7] = size.height - DEFAULT_LINE_WIDTH_HALF;
		points[8] = points[0];
		points[9] = points[7];
		cc.drawPolyline(points);
	}
	
}
