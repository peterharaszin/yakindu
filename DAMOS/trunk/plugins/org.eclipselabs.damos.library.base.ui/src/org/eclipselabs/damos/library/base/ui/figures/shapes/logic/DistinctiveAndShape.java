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

package org.eclipselabs.damos.library.base.ui.figures.shapes.logic;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.swt.graphics.Path;
import org.eclipse.swt.widgets.Display;
import org.eclipselabs.damos.diagram.ui.figures.ComponentFigure;
import org.eclipselabs.damos.diagram.ui.figures.ICanvasContext;

public class DistinctiveAndShape extends LogicGateShape {
	
	/**
	 * @param blockFigure
	 */
	public DistinctiveAndShape(ComponentFigure blockFigure) {
		super(blockFigure);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure#paintFigure(org.eclipse.draw2d.Graphics)
	 */
	public void paintCanvas(ICanvasContext cc) {
		Dimension size = blockFigure.getCanvasSize();
		cc.setLineWidth(DEFAULT_LINE_WIDTH);

		float x = DEFAULT_LINE_WIDTH_HALF;
		float y = DEFAULT_LINE_WIDTH_HALF;
		float right = size.width - DEFAULT_LINE_WIDTH_HALF;
		float bottom = size.height - DEFAULT_LINE_WIDTH_HALF;

		float quarterHeight = size.height / 4f;
		float halfHeight = size.height / 2f;

		Path path = new Path(Display.getDefault());
		try {
			path.moveTo(x, y);
			path.lineTo(right - halfHeight, y);
			path.cubicTo(right - quarterHeight, y, right, y + quarterHeight, right, halfHeight);
			path.cubicTo(right, bottom - quarterHeight, right - quarterHeight, bottom, right - halfHeight, bottom);
			path.lineTo(x, bottom);
			path.close();
			cc.fillPath(path);
			cc.drawPath(path);
		} finally {
			path.dispose();
		}
	}
	
}