/****************************************************************************
 * Copyright (c) 2008, 2011 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.diagram.ui.internal.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;
import org.eclipselabs.damos.diagram.ui.figures.IFigureConstants;

/**
 * @author Andreas Unger
 *
 */
public class AsynchronousEntityFigure extends CompoundFigure {

	private static final int CORNER_SIZE = 400;
	
	private final int[] points = new int[8];
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure#paintFigure(org.eclipse.draw2d.Graphics)
	 */
	@Override
	protected void paintCompound(Graphics graphics) {
		Rectangle bounds = getBounds().getCopy();
		bounds.shrink(IFigureConstants.DEFAULT_LINE_WIDTH_HALF, IFigureConstants.DEFAULT_LINE_WIDTH_HALF);
		
		graphics.setLineWidth(IFigureConstants.DEFAULT_LINE_WIDTH);
		graphics.fillRectangle(bounds);
		
		points[0] = bounds.x + CORNER_SIZE;
		points[1] = bounds.y;
		points[2] = bounds.x;
		points[3] = bounds.y;
		points[4] = bounds.x;
		points[5] = bounds.bottom();
		points[6] = bounds.x + CORNER_SIZE;
		points[7] = bounds.bottom();
		graphics.drawPolyline(points);

		points[0] = bounds.right() - CORNER_SIZE;
		points[1] = bounds.y;
		points[2] = bounds.right();
		points[3] = bounds.y;
		points[4] = bounds.right();
		points[5] = bounds.bottom();
		points[6] = bounds.right() - CORNER_SIZE;
		points[7] = bounds.bottom();
		graphics.drawPolyline(points);

		graphics.setLineStyle(SWT.LINE_DOT);
		graphics.setLineDash(new int[] { 2, 4 });
		graphics.drawLine(bounds.x + CORNER_SIZE, bounds.y, bounds.right() - CORNER_SIZE, bounds.y);
		graphics.drawLine(bounds.x + CORNER_SIZE, bounds.bottom(), bounds.right() - CORNER_SIZE, bounds.bottom());
	}
	
}
