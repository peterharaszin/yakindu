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
import org.eclipse.swt.graphics.Path;
import org.eclipse.swt.widgets.Display;
import org.eclipselabs.damos.diagram.ui.figures.IFigureConstants;

/**
 * @author Andreas Unger
 *
 */
public class WhileLoopFigure extends CompoundFigure {

	private static final int CORNER_RADIUS = 250;
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure#paintFigure(org.eclipse.draw2d.Graphics)
	 */
	@Override
	protected void paintFigure(Graphics graphics) {
		Rectangle bounds = getBounds().getCopy();
		
		bounds.shrink(IFigureConstants.DEFAULT_LINE_WIDTH, IFigureConstants.DEFAULT_LINE_WIDTH);

		graphics.setLineWidth(2 * IFigureConstants.DEFAULT_LINE_WIDTH);

		Path path = new Path(Display.getCurrent());
		try {
			path.moveTo(bounds.x, bounds.bottom() - 1.5f * CORNER_RADIUS);
			path.lineTo(bounds.x, bounds.y + CORNER_RADIUS);
			path.cubicTo(bounds.x, bounds.y + CORNER_RADIUS / 2, bounds.x + CORNER_RADIUS / 2, bounds.y, bounds.x + CORNER_RADIUS, bounds.y);
			path.lineTo(bounds.right() - CORNER_RADIUS, bounds.y);
			path.cubicTo(bounds.right() - CORNER_RADIUS / 2, bounds.y, bounds.right(), bounds.y + CORNER_RADIUS / 2, bounds.right(), bounds.y + CORNER_RADIUS);
			path.lineTo(bounds.right(), bounds.bottom() - CORNER_RADIUS);
			path.cubicTo(bounds.right(), bounds.bottom() - CORNER_RADIUS / 2, bounds.right() - CORNER_RADIUS / 2, bounds.bottom(), bounds.right() - CORNER_RADIUS, bounds.bottom());
			path.lineTo(bounds.x + CORNER_RADIUS, bounds.bottom());
			path.lineTo(bounds.x + CORNER_RADIUS / 2, bounds.bottom() - CORNER_RADIUS / 2);
	
			graphics.fillPath(path);
			graphics.drawPath(path);
		} finally {
			if (path != null) {
				path.dispose();
				path = null;
			}
		}

		try {
			path = new Path(Display.getCurrent());
			path.moveTo(bounds.x, bounds.bottom() - IFigureConstants.DEFAULT_LINE_WIDTH);
			path.lineTo(bounds.x, bounds.bottom() - CORNER_RADIUS);
			path.lineTo(bounds.x + CORNER_RADIUS - IFigureConstants.DEFAULT_LINE_WIDTH, bounds.bottom() - CORNER_RADIUS);
			path.close();
			
			graphics.setBackgroundColor(getForegroundColor());
			graphics.fillPath(path);
			graphics.drawPath(path);
		} finally {
			if (path != null) {
				path.dispose();
				path = null;
			}
		}
	}
	
}
