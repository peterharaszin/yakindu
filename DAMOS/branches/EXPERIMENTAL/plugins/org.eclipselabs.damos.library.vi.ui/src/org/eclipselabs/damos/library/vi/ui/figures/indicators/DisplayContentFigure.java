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

package org.eclipselabs.damos.library.vi.ui.figures.indicators;

import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipselabs.damos.diagram.ui.figures.FontColorAwareFigure;
import org.eclipselabs.damos.diagram.ui.figures.FontColorAwareLabel;
import org.eclipselabs.damos.diagram.ui.figures.IFigureConstants;

/**
 * @author Andreas Unger
 *
 */
public class DisplayContentFigure extends FontColorAwareFigure implements IFigureConstants {

	private Label textLabel;
	
	/**
	 * 
	 */
	public DisplayContentFigure() {
		setLayoutManager(new FlowLayout());
		textLabel = new FontColorAwareLabel();
		textLabel.setBorder(new MarginBorder(100));
		add(textLabel);
	}
	
	/**
	 * @param value the value to set
	 */
	public void setText(String text) {
		textLabel.setText(text);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.diagram.figures.BlockFigure#paintCanvas(org.eclipselabs.damos.diagram.figures.ICanvasContext)
	 */
	protected void paintFigure(Graphics g) {
		Rectangle bounds = getBounds().getShrinked(DEFAULT_LINE_WIDTH_HALF, DEFAULT_LINE_WIDTH_HALF);
    	g.setForegroundColor(getFontColor());
		g.setLineWidth(DEFAULT_LINE_WIDTH);
		g.drawRectangle(bounds);
	}

}
