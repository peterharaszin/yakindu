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

package org.eclipselabs.damos.library.base.ui.figures.math;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.TextUtilities;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.gmf.runtime.draw2d.ui.text.TextUtilitiesEx;
import org.eclipselabs.damos.diagram.ui.figures.FontColorAwareFigure;

/**
 * @author Andreas Unger
 *
 */
public class SumInputPortContentFigure extends FontColorAwareFigure {
	
	private static final String PLUS = "+";
	private static final String MINUS = "-";
	
	private String sign = PLUS;
	private Dimension textSize;
	private Dimension plusTextSize;
	private Dimension minusTextSize;
	private int textCut = -1;
	
    private IMapMode mapmode;
    private TextUtilities textUtilities;
    
	public void setSign(String sign) {
		this.sign = sign;
		revalidate();
		repaint();
	}
    
    public Dimension getPreferredSize(int wHint, int hHint) {
    	if (prefSize == null) {
    		prefSize = getTextSize();
    	}
    	return prefSize;
    }
    
    protected void paintFigure(Graphics graphics) {
		Point location = getLocation();
		Dimension preferredSize = getPreferredSize();
		graphics.setForegroundColor(getFontColor());
		graphics.drawText(
				sign,
				location.x + (preferredSize.width - getTextSize(sign).width) / 2,
				location.y + (preferredSize.height - getTextSize().height - getTextCut()) / 2);
    }

    protected Dimension getTextSize() {
		if (textSize == null) {
			Dimension plusSize = getTextSize(PLUS);
			Dimension minusSize = getTextSize(MINUS);
			textSize = new Dimension(Math.max(plusSize.width, minusSize.width), Math.max(plusSize.height, minusSize.height));
			textSize.height -= getTextCut();
		}
		return textSize;
	}
    
    protected Dimension getTextSize(String sign) {
    	if (PLUS.equals(sign)) {
    		if (plusTextSize == null) {
				plusTextSize = getTextUtilities().getStringExtents(PLUS, getFont());
    		}
    		return plusTextSize;
    	}
    	if (MINUS.equals(sign)) {
    		if (minusTextSize == null) {
				minusTextSize = getTextUtilities().getStringExtents(MINUS, getFont());
    		}
    		return minusTextSize;
    	}
    	throw new IllegalArgumentException();
	}
    
    protected int getTextCut() {
    	if (textCut == -1) {
    		Dimension plusSize = getTextSize(PLUS);
    		textCut = (int) ((plusSize.height - plusSize.width) * 0.95);
    	}
    	return textCut;
    }

	public void invalidate() {
		prefSize = null;
		textSize = null;
		plusTextSize = null;
		minusTextSize = null;
		textCut = -1;
		super.invalidate();
	}

	protected TextUtilities getTextUtilities() {
        if (textUtilities == null) {
            textUtilities = new TextUtilitiesEx(getMapMode());
        }
        return textUtilities;
	}
	
    protected IMapMode getMapMode() {
        if (mapmode == null) {
            mapmode = MapModeUtil.getMapMode(this);
        }
        return mapmode;
    }

}
