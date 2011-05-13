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

package org.eclipselabs.damos.diagram.ui.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.gmf.runtime.draw2d.ui.figures.LabelEx;
import org.eclipse.swt.graphics.Color;

/**
 * @author Andreas Unger
 *
 */
public class FontColorAwareLabel extends LabelEx implements IFontColorAwareFigure {

	private Color fontColor;
	
	/**
	 * 
	 */
	public FontColorAwareLabel() {
	}
	
	public FontColorAwareLabel(String s) {
		super(s);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.diagram.ui.figures.IFontAwareFigure#getFontColor()
	 */
	public Color getFontColor() {
		if (fontColor == null && getParent() instanceof IFontColorAwareFigure) {
			return ((IFontColorAwareFigure) getParent()).getFontColor();
		}
		return fontColor;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.diagram.ui.figures.IFontAwareFigure#setFontColor(org.eclipse.swt.graphics.Color)
	 */
	public void setFontColor(Color fontColor) {
		this.fontColor = fontColor;
		repaint();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.draw2d.ui.figures.LabelEx#paintFigure(org.eclipse.draw2d.Graphics)
	 */
	@Override
	protected void paintFigure(Graphics graphics) {
		graphics.setForegroundColor(getFontColor());
		super.paintFigure(graphics);
	}

}
