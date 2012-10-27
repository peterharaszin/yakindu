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

package org.eclipse.damos.diagram.ui.figures;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.damos.diagram.core.internal.util.MathUtil;
import org.eclipse.damos.diagram.ui.internal.figures.CanvasContext;
import org.eclipse.damos.diagram.ui.internal.figures.TerminalBorderFigure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.GradientStyle;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Pattern;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.themes.ColorUtil;

public abstract class ComponentFigure extends NodeFigure implements IFontColorAwareFigure {

	private Color fontColor;
	
	private boolean flipped;
	private int rotation;

	/**
	 * @return the fontColor
	 */
	public Color getFontColor() {
		if (fontColor == null && getParent() instanceof IFontColorAwareFigure) {
			return ((IFontColorAwareFigure) getParent()).getFontColor();
		}
		return fontColor;
	}
	
	/**
	 * @param fontColor the fontColor to set
	 */
	public void setFontColor(Color fontColor) {
		this.fontColor = fontColor;
		repaint();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.figures.ITransformableFigure#isFlipped()
	 */
	public boolean isFlipped() {
		return flipped;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.figures.ITransformableFigure#setFlipped(boolean)
	 */
	public void setFlipped(boolean flipped) {
		this.flipped = flipped;
		revalidate();
		repaint();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.figures.ITransformableFigure#getRotation()
	 */
	public int getRotation() {
		return rotation;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.figures.ITransformableFigure#setRotation(int)
	 */
	public void setRotation(int rotation) {
		this.rotation = MathUtil.normalizeAngle(rotation);
		revalidate();
		repaint();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.core.runtime.IAdaptable#getAdapter(java.lang.Class)
	 */
	public Object getHelper(Class<?> clazz) {
		return null;
	}
	
	public List<IFigure> getContentFigures() {
		List<IFigure> contentFigures = new ArrayList<IFigure>();
		for (Object o : getChildren()) {
			if (!(o instanceof PortFigure || o instanceof TerminalBorderFigure)) {
				contentFigures.add((IFigure) o);
			}
		}
		return contentFigures;
	}

	public IFigure getPrimaryContentFigure() {
		List<IFigure> contentFigures = getContentFigures();
		return contentFigures.isEmpty() ? null : contentFigures.get(0);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.draw2d.Figure#getMinimumSize(int, int)
	 */
	public Dimension getMinimumSize(int wHint, int hHint) {
		if (minSize == null) {
			Dimension calculatedMinSize = calculateMinimumSize(wHint, hHint);
			if (calculatedMinSize != null) {
				minSize = calculatedMinSize;
			} else {
				minSize = super.getMinimumSize(wHint, hHint);
			}
		}
		return minSize;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.figures.BlockFigure#calculateMinimumSize(int, int)
	 */
	private Dimension calculateMinimumSize(int wHint, int hHint) {
		Dimension size = calculateMinimumCanvasSize(wHint, hHint);
		if (size != null && (rotation == 90 || rotation == 270)) {
			size.transpose();
		}
		return size;
	}

	protected Dimension calculateMinimumCanvasSize(int wHint, int hHint) {
		return null;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.draw2d.Figure#getPreferredSize(int, int)
	 */
	public final Dimension getPreferredCanvasSize() {
		return getPreferredCanvasSize(-1, -1);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.figures.BlockFigure#getPreferredCanvasSize(int, int)
	 */
	public Dimension getPreferredCanvasSize(int wHint, int hHint) {
		Dimension size = getPreferredSize(wHint, hHint).getCopy();
		if (rotation == 90 || rotation == 270) {
			size.transpose();
		}
		return size;
	}
	
	public Dimension getCanvasSize() {
		Dimension size = getSize().getCopy();
		if (rotation == 90 || rotation == 270) {
			size.transpose();
		}
		return size;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.figures.TransformableBlockFigure#invalidate()
	 */
	public void invalidate() {
		minSize = null;
		for (Object o : getChildren()) {
			((IFigure) o).invalidate();
		}
		super.invalidate();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure#paintFigure(org.eclipse.draw2d.Graphics)
	 */
	protected void paintFigure(Graphics graphics) {
		Rectangle bounds = getBounds();
		graphics.translate(bounds.x, bounds.y);
		
		if (isUsingGradient()) {
			Color gradientColor1 = FigureUtilities.integerToColor(getGradientColor1());
			Color gradientColor2 = FigureUtilities.integerToColor(getGradientColor2());
			Color backgroundColor = null;
			try {
				float x2 = 0;
				float y2 = 0;
				if (getGradientStyle() == GradientStyle.HORIZONTAL) {
					x2 = (float) (bounds.width * graphics.getAbsoluteScale());
				} else {
					y2 = (float) (bounds.height * graphics.getAbsoluteScale());
				}
				Pattern pattern = new Pattern(Display.getDefault(), 0, 0, x2, y2, gradientColor1, gradientColor2);
				try {
					try {
						graphics.setBackgroundPattern(pattern);
					} catch (RuntimeException e) {
						// Gradients not supported, set background color instead
						RGB rgb = ColorUtil.blend(gradientColor1.getRGB(), gradientColor2.getRGB());
						backgroundColor = new Color(Display.getDefault(), rgb);
						graphics.setBackgroundColor(backgroundColor);
					}
					paintCanvas(new CanvasContext(graphics, getCanvasSize(), flipped, rotation));
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
			paintCanvas(new CanvasContext(graphics, getCanvasSize(), flipped, rotation));
		}
	}

	protected void paintCanvas(ICanvasContext cc) {
	}

}
