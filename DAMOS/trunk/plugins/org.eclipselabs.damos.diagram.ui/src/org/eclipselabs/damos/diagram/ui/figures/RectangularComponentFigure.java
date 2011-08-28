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

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.geometry.Dimension;

public class RectangularComponentFigure extends StandardComponentFigure implements IFigureConstants {
	
	private static final int[] TOP_LEFT_MARKER_POINTS = new int[] {
		DEFAULT_LINE_WIDTH_HALF, DEFAULT_LINE_WIDTH_HALF,
		8 * DEFAULT_LINE_WIDTH, DEFAULT_LINE_WIDTH_HALF,
		DEFAULT_LINE_WIDTH_HALF, 8 * DEFAULT_LINE_WIDTH
	};
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure#paintFigure(org.eclipse.draw2d.Graphics)
	 */
	protected void paintCanvas(ICanvasContext cc) {
		Dimension size = getCanvasSize();
		
		int x = DEFAULT_LINE_WIDTH_HALF;
		int y = DEFAULT_LINE_WIDTH_HALF;
		int width = size.width - DEFAULT_LINE_WIDTH;
		int height = size.height - DEFAULT_LINE_WIDTH;
		
		cc.setLineWidth(DEFAULT_LINE_WIDTH);
		cc.fillRectangle(x, y, width, height);
		
		if (hasTopLeftMarker()) {
			cc.setBackgroundColor(ColorConstants.lightGray);
			cc.fillPolygon(TOP_LEFT_MARKER_POINTS);
			cc.drawPolygon(TOP_LEFT_MARKER_POINTS);
		}

		cc.drawRectangle(x, y, width, height);
	}
	
	protected boolean hasTopLeftMarker() {
		return false;
	}
	
}