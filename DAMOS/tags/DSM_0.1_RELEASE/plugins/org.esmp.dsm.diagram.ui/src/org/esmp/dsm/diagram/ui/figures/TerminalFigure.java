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

package org.esmp.dsm.diagram.ui.figures;

import org.eclipse.draw2d.AncestorListener;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.swt.graphics.Color;
import org.esmp.dsm.diagram.ui.internal.geometry.Extents;
import org.esmp.dsm.diagram.ui.internal.geometry.Transform;

/**
 * @author Andreas Unger
 *
 */
public abstract class TerminalFigure extends NodeFigure implements AncestorListener, PositionConstants, FigureConstants {

	protected static final int SIZE = 100;
	private static final Color TERMINAL_COLOR = new Color(null, 0xb3, 0x00, 0x77);

	private PortFigure owner;
	
	/**
	 * 
	 */
	public TerminalFigure(PortFigure owner) {
		this.owner = owner;
	}
	
	/**
	 * @return the owner
	 */
	public PortFigure getOwner() {
		return owner;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure#paintFigure(org.eclipse.draw2d.Graphics)
	 */
	protected void paintFigure(Graphics graphics) {
		PointList polyline = getTransformedPolyline();
		if (polyline != null) {
			graphics.setForegroundColor(TERMINAL_COLOR);
			graphics.setLineWidth(DEFAULT_LINE_WIDTH);
			graphics.drawPolyline(polyline);
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.draw2d.Figure#validate()
	 */
	public void validate() {
		if (isValid()) {
			return;
		}

		PointList polyline = getTransformedPolyline();
		if (polyline != null) {
			getParent().setConstraint(this, polyline.getBounds().getExpanded(DEFAULT_LINE_WIDTH, DEFAULT_LINE_WIDTH));
		}
		
		super.validate();
	}
	
	public Extents getExtents(double rotationHint) {
    	double rotation = !Double.isNaN(rotationHint) ? rotationHint : owner.getRotation();
		
		Transform transform = new Transform();
		transform.setRotation(-rotation);
		PointList polyline = transform.getTransformed(getPolyline());
		
		return Extents.fromRectangle(polyline.getBounds());
	}
	
	private PointList getTransformedPolyline() {
		PointList polyline = null;
		
		Point terminalLocation = owner.getTerminalLocation();
		if (terminalLocation != null) {
			Transform transform = new Transform();
			transform.setRotation(-owner.getRotation());
			transform.setTranslation(terminalLocation.x, terminalLocation.y);
			polyline = transform.getTransformed(getPolyline());
		}
		
		return polyline;
	}
	
	protected abstract PointList getPolyline();
	
	/* (non-Javadoc)
	 * @see org.eclipse.draw2d.AncestorListener#ancestorMoved(org.eclipse.draw2d.IFigure)
	 */
	public void ancestorMoved(IFigure ancestor) {
		invalidate();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.draw2d.AncestorListener#ancestorAdded(org.eclipse.draw2d.IFigure)
	 */
	public void ancestorAdded(IFigure ancestor) {
	}

	/* (non-Javadoc)
	 * @see org.eclipse.draw2d.AncestorListener#ancestorRemoved(org.eclipse.draw2d.IFigure)
	 */
	public void ancestorRemoved(IFigure ancestor) {
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.draw2d.Figure#addNotify()
	 */
	public void addNotify() {
		super.addNotify();
		owner.addAncestorListener(this);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.draw2d.Figure#removeNotify()
	 */
	public void removeNotify() {
		owner.removeAncestorListener(this);
		super.removeNotify();
	}
	
}
