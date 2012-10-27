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

package org.eclipse.damos.diagram.ui.figures;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.swt.graphics.Path;
import org.eclipse.swt.widgets.Display;

/**
 * @author Andreas Unger
 *
 */
public class InoutportFigure extends StandardComponentFigure implements IFigureConstants {
	
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
		
		float x = DEFAULT_LINE_WIDTH_HALF;
		float y = DEFAULT_LINE_WIDTH_HALF;
		float right = size.width - DEFAULT_LINE_WIDTH_HALF;
		float bottom = size.height - DEFAULT_LINE_WIDTH_HALF;

		float quarterHeight = size.height / 4f;
		float halfHeight = size.height / 2f;
		
		Path path = new Path(Display.getDefault());
		try {
			path.moveTo(quarterHeight, y);
			path.lineTo(right - halfHeight, y);
			path.lineTo(right, halfHeight);
			path.lineTo(right - halfHeight, bottom);
			path.lineTo(quarterHeight, bottom);
			path.cubicTo(x, bottom, x, bottom - quarterHeight, x, halfHeight);
			path.cubicTo(x, y + quarterHeight, x, y, quarterHeight, y);

			cc.fillPath(path);
			cc.drawPath(path);
		} finally {
			path.dispose();
		}
	}
	
}
