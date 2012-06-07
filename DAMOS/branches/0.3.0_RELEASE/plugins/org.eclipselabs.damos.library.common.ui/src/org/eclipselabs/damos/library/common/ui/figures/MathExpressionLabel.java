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

package org.eclipselabs.damos.library.common.ui.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.TextUtilities;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.gmf.runtime.draw2d.ui.text.TextUtilitiesEx;
import org.eclipselabs.damos.diagram.ui.figures.FontColorAwareFigure;

/**
 * @author Andreas Unger
 * 
 */
public class MathExpressionLabel extends FontColorAwareFigure {

	private String text = "";
	private Dimension textSize;
	private int superscriptHeight;
	private int[] fragmentWidths;

	private IMapMode mapmode;
	private TextUtilities textUtilities;

	private static final String DELIMTER_REGEXP = "\\^\\{|\\}";

	public String getText() {
		return text;
	}

	public void setText(String s) {
		if (s == null) {
			s = ""; //$NON-NLS-1$
		}
		if (text.equals(s)) {
			return;
		}
		text = s;
		revalidate();
		repaint();
	}

	public Dimension getPreferredSize(int wHint, int hHint) {
		if (prefSize == null) {
			prefSize = getTextSize();
		}
		return prefSize;
	}

	private Dimension getTextSize() {
		if (textSize == null) {
			calculateTextMetrics();
		}
		return textSize;
	}
	
	private int[] getFragmentWidths() {
		if (textSize == null) {
			calculateTextMetrics();
		}
		return fragmentWidths;
	}
	
	private int getSuperscriptHeight() {
		if (textSize == null) {
			calculateTextMetrics();
		}
		return superscriptHeight;
	}

	private void calculateTextMetrics() {
		textSize = new Dimension();
		String[] fragments = getText().split(DELIMTER_REGEXP);
		fragmentWidths = new int[fragments.length];
		for (int i = 0; i < fragments.length; ++i) {
			Dimension nextSize = getTextUtilities().getTextExtents(fragments[i], getFont());
			textSize.width += nextSize.width;
			if (textSize.height < nextSize.height) {
				textSize.height = nextSize.height;
			}
			fragmentWidths[i] = nextSize.width;
		}
		if (fragments.length > 1) {
			superscriptHeight = textSize.height / 2; 
			textSize.height += superscriptHeight;
		}
	}

	protected void paintFigure(Graphics graphics) {
		graphics.setForegroundColor(getFontColor());
		
		Rectangle bounds = getBounds();

		boolean superscript = false;
		String[] fragments = getText().split(DELIMTER_REGEXP);
		for (int i = 0, x = bounds.x; i < fragments.length; ++i) {
			int y = bounds.y;
			if (!superscript) {
				y += getSuperscriptHeight();
			}
			if (!isEnabled()) {
				graphics.translate(1, 1);
				graphics.setForegroundColor(ColorConstants.buttonLightest);
				graphics.drawText(fragments[i], x, y);
				graphics.translate(-1, -1);
				graphics.setForegroundColor(ColorConstants.buttonDarker);
			}
			graphics.drawText(fragments[i], x, y);
			x += getFragmentWidths()[i];
			superscript = !superscript;
		}
	}

	public void invalidate() {
		prefSize = null;
		minSize = null;
		textSize = null;
		fragmentWidths = null;
		superscriptHeight = 0;
		super.invalidate();
	}

	/**
	 * Gets the mapmode to be used in pixel to logical unit conversions.
	 * 
	 * @return the mapmode
	 */
	private IMapMode getMapMode() {
		if (mapmode == null) {
			mapmode = MapModeUtil.getMapMode(this);
		}
		return mapmode;
	}

	public TextUtilities getTextUtilities() {
		if (textUtilities == null) {
			textUtilities = new TextUtilitiesEx(getMapMode());
		}
		return textUtilities;
	}

}
