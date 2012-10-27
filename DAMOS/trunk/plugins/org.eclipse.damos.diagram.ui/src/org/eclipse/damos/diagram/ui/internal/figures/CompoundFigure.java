/****************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipse.damos.diagram.ui.internal.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.GradientStyle;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Pattern;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.themes.ColorUtil;

/**
 * @author Andreas Unger
 *
 */
public abstract class CompoundFigure extends NodeFigure {

	/**
	 * 
	 */
	public CompoundFigure() {
		ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
		layout.setStretchMinorAxis(true);
		setLayoutManager(layout);
		setPreferredSize(new Dimension(4000, 3000));
	}
	
	protected abstract void paintCompound(Graphics graphics);
	
	protected void paintFigure(Graphics graphics) {
		Rectangle bounds = getBounds();
		
		if (isUsingGradient()) {
			Color gradientColor1 = FigureUtilities.integerToColor(getGradientColor1());
			Color gradientColor2 = FigureUtilities.integerToColor(getGradientColor2());
			Color backgroundColor = null;
			try {
				float x1 = (float) (bounds.x * graphics.getAbsoluteScale());
				float y1 = (float) (bounds.y * graphics.getAbsoluteScale());
				float x2 = x1;
				float y2 = y1;
				if (getGradientStyle() == GradientStyle.HORIZONTAL) {
					x2 += (float) (bounds.width * graphics.getAbsoluteScale());
				} else {
					y2 += (float) (bounds.height * graphics.getAbsoluteScale());
				}
				Pattern pattern = new Pattern(Display.getDefault(), x1, y1, x2, y2, gradientColor1, gradientColor2);
				try {
					try {
						graphics.setBackgroundPattern(pattern);
					} catch (RuntimeException e) {
						// Gradients not supported, set background color instead
						RGB rgb = ColorUtil.blend(gradientColor1.getRGB(), gradientColor2.getRGB());
						backgroundColor = new Color(Display.getDefault(), rgb);
						graphics.setBackgroundColor(backgroundColor);
					}
					paintCompound(graphics);
				} finally {
					pattern.dispose();
				}
			} finally {
				gradientColor1.dispose();
				gradientColor2.dispose();
				if (backgroundColor != null) {
					backgroundColor.dispose();
				}
			}
		} else {
			paintCompound(graphics);
		}
	}

}
