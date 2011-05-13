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

import org.eclipse.draw2d.Figure;
import org.eclipse.swt.graphics.Color;

/**
 * @author Andreas Unger
 *
 */
public class FontColorAwareFigure extends Figure implements IFontColorAwareFigure {

	private Color fontColor;

	/**
	 * 
	 */
	public FontColorAwareFigure() {
		super();
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

}