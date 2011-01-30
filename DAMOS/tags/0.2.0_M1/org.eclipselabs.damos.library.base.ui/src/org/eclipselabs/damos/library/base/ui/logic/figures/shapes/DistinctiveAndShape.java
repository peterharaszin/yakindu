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

package org.eclipselabs.damos.library.base.ui.logic.figures.shapes;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipselabs.damos.diagram.ui.figures.ComponentFigure;
import org.eclipselabs.damos.diagram.ui.figures.ICanvasContext;

public class DistinctiveAndShape extends LogicGateShape {
	
	private int[] points = new int[8];

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
		
		points[0] = size.width - size.height / 2;
		points[1] = DEFAULT_LINE_WIDTH_HALF;
		points[2] = DEFAULT_LINE_WIDTH_HALF;
		points[3] = DEFAULT_LINE_WIDTH_HALF;
		points[4] = DEFAULT_LINE_WIDTH_HALF;
		points[5] = size.height - DEFAULT_LINE_WIDTH_HALF;
		points[6] = points[0];
		points[7] = points[5];
		
		cc.setLineWidth(DEFAULT_LINE_WIDTH);
		cc.drawPolyline(points);
		cc.drawArc(
				size.width - size.height,
				DEFAULT_LINE_WIDTH_HALF,
				size.height - DEFAULT_LINE_WIDTH_HALF,
				size.height - DEFAULT_LINE_WIDTH,
				270, 180);
	}
	
}