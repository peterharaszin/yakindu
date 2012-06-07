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

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.diagram.ui.figures.IBorderItemLocator;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.swt.graphics.Color;
import org.eclipselabs.damos.diagram.ui.figures.ConnectorAnchor;
import org.eclipselabs.damos.diagram.ui.figures.IFigureConstants;
import org.eclipselabs.damos.diagram.ui.figures.IFontColorAwareFigure;
import org.eclipselabs.damos.diagram.ui.figures.TerminalFigure;

/**
 * @author Andreas Unger
 *
 */
public abstract class CompoundConnectorFigure extends DefaultSizeNodeFigure implements IConnectorFigure, IFontColorAwareFigure {

	public static final Dimension DEFAULT_SIZE = new Dimension(400, 400);
	
	private Color fontColor;

	private TerminalFigure terminalFigure;

	/**
	 * 
	 */
	public CompoundConnectorFigure() {
		super(DEFAULT_SIZE);
		terminalFigure = createTerminalFigure();
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

	public TerminalFigure getTerminalFigure() {
		return terminalFigure;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.diagram.ui.internal.figures.IConnectorFigure#getTerminalLocation()
	 */
	public Point getTerminalLocation() {
		int side = getCurrentSideOfParent();
		Rectangle bounds = getBounds();
		Point center = getBounds().getCenter();
		
		if (isInternal()) {
			switch (side) {
			case PositionConstants.NORTH:
				return new Point(center.x, bounds.bottom());
			case PositionConstants.SOUTH:
				return new Point(center.x, bounds.y);
			case PositionConstants.EAST:
				return new Point(bounds.x, center.y);
			case PositionConstants.WEST:
				return new Point(bounds.right(), center.y);
			}
		} else {
			switch (side) {
			case PositionConstants.NORTH:
				return new Point(center.x, bounds.y);
			case PositionConstants.SOUTH:
				return new Point(center.x, bounds.bottom());
			case PositionConstants.EAST:
				return new Point(bounds.right(), center.y);
			case PositionConstants.WEST:
				return new Point(bounds.x, center.y);
			}
		}

		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.diagram.ui.internal.figures.IConnectorFigure#getRotation()
	 */
	public double getRotation() {
		int side = getCurrentSideOfParent();

		if (isInternal()) {
			switch (side) {
			case PositionConstants.NORTH:
				return Math.toRadians(270);
			case PositionConstants.SOUTH:
				return Math.toRadians(90);
			case PositionConstants.EAST:
				return Math.toRadians(180);
			case PositionConstants.WEST:
				return Math.toRadians(0);
			}
		} else {
			switch (side) {
			case PositionConstants.NORTH:
				return Math.toRadians(90);
			case PositionConstants.SOUTH:
				return Math.toRadians(270);
			case PositionConstants.EAST:
				return Math.toRadians(0);
			case PositionConstants.WEST:
				return Math.toRadians(180);
			}
		}

		return 0;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure#paintFigure(org.eclipse.draw2d.Graphics)
	 */
	@Override
	protected void paintFigure(Graphics graphics) {
		Rectangle bounds = getBounds().getCopy();
		bounds.shrink(IFigureConstants.DEFAULT_LINE_WIDTH_HALF, IFigureConstants.DEFAULT_LINE_WIDTH_HALF);
		graphics.setLineWidth(IFigureConstants.DEFAULT_LINE_WIDTH);
		graphics.setBackgroundColor(getBackgroundColor());
		graphics.setForegroundColor(getForegroundColor());
		graphics.fillRectangle(bounds);
		graphics.drawRectangle(bounds);
	}

	private int getCurrentSideOfParent() {
		Object constraint = getParent().getParent().getLayoutManager().getConstraint(getParent());
		if (constraint instanceof IBorderItemLocator) {
			IBorderItemLocator locator = (IBorderItemLocator) constraint;
			return locator.getCurrentSideOfParent();
		}
		return 0;
	}

	protected abstract TerminalFigure createTerminalFigure();
	
	protected boolean isInternal() {
		return false;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure#createConnectionAnchor(org.eclipse.draw2d.geometry.Point)
	 */
	@Override
	protected ConnectionAnchor createConnectionAnchor(Point p) {
		return createDefaultAnchor();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure#createDefaultAnchor()
	 */
	@Override
	protected ConnectionAnchor createDefaultAnchor() {
		return new ConnectorAnchor(this);
	}

}
