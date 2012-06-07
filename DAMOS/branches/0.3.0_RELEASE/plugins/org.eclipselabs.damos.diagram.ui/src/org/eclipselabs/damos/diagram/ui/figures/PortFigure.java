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

package org.eclipselabs.damos.diagram.ui.figures;

import java.util.List;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.swt.graphics.Color;
import org.eclipselabs.damos.diagram.ui.internal.figures.TerminalBorderFigure;
import org.eclipselabs.damos.diagram.ui.internal.geometry.Extents;
import org.eclipselabs.damos.diagram.ui.internal.geometry.Geometry;

/**
 * @author Andreas Unger
 *
 */
public abstract class PortFigure extends NodeFigure implements IPortFigure, IFontColorAwareFigure {

	private Color fontColor;

	private static final String ANCHOR_KEY = "port";
	
	protected double rotation = Double.NaN;
	
	protected TerminalFigure terminalFigure;
	protected IFigure terminalBorderFigure;
	protected int terminalPadding = 3 * IFigureConstants.DEFAULT_LINE_WIDTH;
	
	private ConnectionAnchor connectionAnchor;

	public PortFigure() {
		this((IFigure) null);
	}

	public PortFigure(String text) {
		this(text != null ? new FontColorAwareLabel(text) : (IFigure) null);
	}

	public PortFigure(IFigure contentFigure) {
		if (contentFigure != null) {
			add(contentFigure);
		}
		setConnectionAnchor(new PortAnchor(this));
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

	public Extents getExtents() {
		return getExtents(Double.NaN);
	}
	
	public Extents getExtents(double rotationHint) {
    	double rotation = !Double.isNaN(rotationHint) ? rotationHint : this.rotation;
    	
    	Dimension preferredSize = getPreferredSize().getCopy();
    	
    	if (preferredSize.width < 0) {
    		preferredSize.width = 0;
    	}
    	
    	if (preferredSize.height < 0) {
    		preferredSize.height = 0;
    	}
    	
		Rectangle r = new Rectangle(0, 0, preferredSize.width, preferredSize.height);
		r.expand(terminalPadding, terminalPadding);
		Geometry.moveRectangleToBorderPoint(r, new Point(), rotation);
		r.shrink(terminalPadding, terminalPadding);
		
		Extents extents = Extents.fromRectangle(r);
		
		if (preferredSize.width == 0) {
			extents.left = 0;
			extents.right = 0;
		}
		
		if (preferredSize.height == 0) {
			extents.top = 0;
			extents.bottom = 0;
		}

		return extents.union(getTerminalFigure().getExtents(rotation));
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.draw2d.Figure#getPreferredSize(int, int)
	 */
	public final Dimension getPreferredSize(int wHint, int hHint) {
		if (prefSize == null) {
			IFigure contentFigure = getContentFigure();
			if (contentFigure != null) {
				prefSize = contentFigure.getPreferredSize();
			} else {
				prefSize = new Dimension();
			}
		}
		return prefSize;
	}
	
	public TerminalFigure getTerminalFigure() {
		return terminalFigure;
	}

	protected abstract TerminalFigure createTerminalFigure();
	
	public IFigure getTerminalBorderFigure() {
		if (terminalBorderFigure == null) {
			terminalBorderFigure = new TerminalBorderFigure();
		}
		return terminalBorderFigure;
	}
	
	public double getRotation() {
		return rotation;
	}
	
	public void setRotation(double rotation) {
		this.rotation = rotation;
	}
	
	@SuppressWarnings("unchecked")
	public IFigure getContentFigure() {
		List<IFigure> children = getChildren();
		if (children.size() > 0) {
			return children.get(0);
		}
		return null;
	}
	
	public void setContentFigure(IFigure contentFigure) {
		removeAll();
		add(contentFigure);
	}
	
	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		IFigure contentFigure = getContentFigure();
		if (contentFigure != null) {
			if (contentFigure instanceof Label) {
				((Label) contentFigure).setText(text);
			} else {
				removeAll();
				add(new FontColorAwareLabel(text));
			}
		} else {
			add(new FontColorAwareLabel(text));
		}
	}
	
	public Point getTerminalLocation() {
		if (Double.isNaN(rotation)) {
			return null;
		}
		Rectangle r = getBounds().getExpanded(terminalPadding, terminalPadding);
		return Geometry.getRectangleCenterLineIntersectionPoint(r, rotation);
	}
	
	public void updateBounds(Point terminalLocation) {
		Rectangle bounds = new Rectangle();
		bounds.setSize(getPreferredSize());
		bounds.expand(terminalPadding, terminalPadding);
		Geometry.moveRectangleToBorderPoint(bounds, terminalLocation, rotation);
		bounds.shrink(terminalPadding, terminalPadding);
		setBounds(bounds);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.draw2d.Figure#invalidate()
	 */
	public void invalidate() {
		prefSize = null;
		super.invalidate();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.draw2d.Figure#validate()
	 */
	public void validate() {
		if (isValid()) {
			return;
		}
		
		if (getLayoutManager() == null) {
			IFigure contentFigure = getContentFigure();
			if (contentFigure != null) {
				Point location = getLocation();
				Dimension preferredChildSize = contentFigure.getPreferredSize();
				contentFigure.setBounds(new Rectangle(
						location.x,
						location.y + (getPreferredSize().height - preferredChildSize.height) / 2,
						preferredChildSize.width,
						preferredChildSize.height));
			}
		}

		super.validate();
	}

    /* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure#getSourceConnectionAnchorAt(org.eclipse.draw2d.geometry.Point)
	 */
	public ConnectionAnchor getSourceConnectionAnchorAt(Point p) {
		return connectionAnchor;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure#getTargetConnectionAnchorAt(org.eclipse.draw2d.geometry.Point)
	 */
	public ConnectionAnchor getTargetConnectionAnchorAt(Point p) {
		return connectionAnchor;
	}
	
	@SuppressWarnings("unchecked")
	protected void setConnectionAnchor(ConnectionAnchor connectionAnchor) {
		this.connectionAnchor = connectionAnchor;
		getConnectionAnchors().put(ANCHOR_KEY, connectionAnchor);
	}
	
}
