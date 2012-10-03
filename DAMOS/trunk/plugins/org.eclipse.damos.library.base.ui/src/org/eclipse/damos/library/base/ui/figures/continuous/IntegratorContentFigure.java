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

package org.eclipse.damos.library.base.ui.figures.continuous;

import org.eclipse.damos.diagram.ui.figures.FontColorAwareFigure;
import org.eclipse.damos.diagram.ui.figures.IFigureConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Path;
import org.eclipse.swt.widgets.Display;

/**
 * @author Andreas Unger
 *
 */
public class IntegratorContentFigure extends FontColorAwareFigure implements IFigureConstants {
	
	private static final int PREFERRED_SIZE = 400;
	private static final float HEIGHT = PREFERRED_SIZE - DEFAULT_LINE_WIDTH;
	private static final float RADIUS = 50;
	private static final float RADIUS_HALF = RADIUS / 2;
	private static final float DIAMETER = 2 * RADIUS;
	
	/**
	 * 
	 */
	public IntegratorContentFigure() {
		setPreferredSize(PREFERRED_SIZE, PREFERRED_SIZE);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.figures.BlockFigure#paintCanvas(org.eclipse.damos.diagram.figures.ICanvasContext)
	 */
	protected void paintFigure(Graphics g) {
		g.setForegroundColor(getFontColor());
		g.setLineWidth(DEFAULT_LINE_WIDTH);
		Rectangle border = getBounds().getCopy().shrink(DEFAULT_LINE_WIDTH_HALF, DEFAULT_LINE_WIDTH_HALF);
		
		float centerX = (float) border.x + border.width / 2;
		float centerY = (float) border.y + border.height / 2;
		float top = centerY - HEIGHT / 2;
		float bottom = centerY + HEIGHT / 2;

		Path path = new Path(Display.getCurrent());
		try {
			path.moveTo(centerX + DIAMETER, top + RADIUS);
			path.cubicTo(centerX + DIAMETER, top + RADIUS_HALF, centerX + 3 * RADIUS_HALF, top, centerX + RADIUS, top);
			path.cubicTo(centerX + RADIUS_HALF, top, centerX, top + RADIUS_HALF, centerX, top + RADIUS);
			path.lineTo(centerX, bottom - RADIUS);
			path.cubicTo(centerX, bottom - RADIUS_HALF, centerX - RADIUS_HALF, bottom, centerX - RADIUS, bottom);
			path.cubicTo(centerX - 3 * RADIUS_HALF, bottom, centerX - DIAMETER, bottom - RADIUS_HALF, centerX - DIAMETER, bottom - RADIUS);
			g.drawPath(path);
		} finally {
			if (path != null) {
				path.dispose();
				path = null;
			}
		}
	}
	
}
