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

package org.eclipse.damos.library.base.ui.figures.audio;

import org.eclipse.damos.diagram.ui.figures.FontColorAwareFigure;
import org.eclipse.damos.diagram.ui.figures.IFigureConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * @author Andreas Unger
 *
 */
public class AudioFileContentFigure extends FontColorAwareFigure {

	private int[] borderPoints = new int[10];
	private int[] speakerPoints = new int[12];
	
	/**
	 * 
	 */
	public AudioFileContentFigure() {
		setPreferredSize(500, 600);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.draw2d.Figure#paintFigure(org.eclipse.draw2d.Graphics)
	 */
	@Override
	protected void paintFigure(Graphics graphics) {
		Rectangle bounds = getBounds().getCopy();
		bounds.shrink(IFigureConstants.DEFAULT_LINE_WIDTH_HALF, IFigureConstants.DEFAULT_LINE_WIDTH_HALF);

		int cornerSize = 100;
		
		borderPoints[0] = bounds.x;
		borderPoints[1] = bounds.y;
		borderPoints[2] = bounds.right() - cornerSize;
		borderPoints[3] = bounds.y;
		borderPoints[4] = bounds.right();
		borderPoints[5] = bounds.y + cornerSize;
		borderPoints[6] = bounds.right();
		borderPoints[7] = bounds.bottom();
		borderPoints[8] = bounds.x;
		borderPoints[9] = bounds.bottom();
		
		int centerX = bounds.x + bounds.width / 2;
		
		int horizontalSpacing = 100;
		int verticalCoilSpacing = 200;
		int verticalBasketSpacing = 100;
		
		speakerPoints[0] = bounds.x + horizontalSpacing;
		speakerPoints[1] = bounds.y + verticalCoilSpacing;
		speakerPoints[2] = centerX;
		speakerPoints[3] = bounds.y + verticalCoilSpacing;
		speakerPoints[4] = bounds.right() - horizontalSpacing;
		speakerPoints[5] = bounds.y + verticalBasketSpacing;
		speakerPoints[6] = bounds.right() - horizontalSpacing;
		speakerPoints[7] = bounds.bottom() - verticalBasketSpacing;
		speakerPoints[8] = centerX;
		speakerPoints[9] = bounds.bottom() - verticalCoilSpacing;
		speakerPoints[10] = bounds.x + horizontalSpacing;
		speakerPoints[11] = bounds.bottom() - verticalCoilSpacing;
		
		graphics.setForegroundColor(getFontColor());
		graphics.setLineWidth(IFigureConstants.DEFAULT_LINE_WIDTH);
		graphics.drawPolygon(borderPoints);
		graphics.setBackgroundColor(getFontColor());
		graphics.fillPolygon(speakerPoints);
	}
	
}
