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

package org.eclipselabs.damos.library.base.ui.figures.logic;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipselabs.damos.diagram.ui.figures.ICanvasContext;
import org.eclipselabs.damos.diagram.ui.figures.IFigureConstants;
import org.eclipselabs.damos.diagram.ui.figures.StandardComponentFigure;

/**
 * @author Andreas Unger
 *
 */
public class SchmittTriggerFigure extends StandardComponentFigure implements IFigureConstants {
	
	private int[] points = new int[6];
	
	protected Dimension calculateMinimumCanvasSize(int wHint, int hHint) {
		return new Dimension(700, 700);
	}

	protected void paintCanvas(ICanvasContext cc) {
		Dimension size = getCanvasSize();
		cc.setLineWidth(DEFAULT_LINE_WIDTH);
		
		points[0] = size.width - DEFAULT_LINE_WIDTH_HALF;
		points[1] = size.height / 2;
		points[2] = DEFAULT_LINE_WIDTH_HALF;
		points[3] = DEFAULT_LINE_WIDTH;
		points[4] = DEFAULT_LINE_WIDTH_HALF;
		points[5] = size.height - DEFAULT_LINE_WIDTH;
		cc.fillPolygon(points);
		cc.drawPolygon(points);
		
		points[0] = size.width * 5 / 40;
		points[1] = size.height * 6 / 10;
		points[2] = size.width * 4 / 10;
		points[3] = points[1];
		points[4] = points[2];
		points[5] = size.height * 4 / 10;
		cc.drawPolyline(points);

		points[0] = size.width * 3 / 10;
		points[1] = size.height * 6 / 10;
		points[2] = points[0];
		points[3] = size.height * 4 / 10;
		points[4] = size.width * 23 / 40;
		points[5] = points[3];
		cc.drawPolyline(points);
	}
	
}
