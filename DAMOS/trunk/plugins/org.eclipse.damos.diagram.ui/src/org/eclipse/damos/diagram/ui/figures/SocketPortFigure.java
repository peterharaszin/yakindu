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

package org.eclipse.damos.diagram.ui.figures;

import org.eclipse.damos.diagram.ui.internal.geometry.Geometry;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * @author Andreas Unger
 *
 */
public abstract class SocketPortFigure extends PortFigure {

	protected static final int TERMINAL_SPACING = 4 * IFigureConstants.DEFAULT_LINE_WIDTH;
	
	public SocketPortFigure() {
	}

	public SocketPortFigure(String text) {
		super(text);
	}

	public SocketPortFigure(IFigure contentFigure) {
		super(contentFigure);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.ui.figures.PortFigure#getTerminalLocation()
	 */
	@Override
	public Point getTerminalLocation() {
		if (Double.isNaN(rotation)) {
			return null;
		}
		int padding = terminalPadding + getTerminalDistance();
		Rectangle r = getBounds().getExpanded(padding, padding);
		return Geometry.getRectangleCenterLineIntersectionPoint(r, rotation);
	}
	
	protected abstract int getTerminalDistance();

	protected static abstract class SocketTerminalFigure extends PolypointTerminalFigure {
		
		protected static final int SIZE = IFigureConstants.DEFAULT_TERMINAL_SIZE;

		/**
		 * @param owner
		 */
		public SocketTerminalFigure(PortFigure owner) {
			super(owner);
			setForegroundColor(IFigureConstants.DEFAULT_TERMINAL_COLOR);
		}
		
		/* (non-Javadoc)
		 * @see org.eclipse.damos.diagram.ui.figures.TerminalFigure#setConnected(boolean)
		 */
		@Override
		public void setConnected(boolean connected) {
			super.setConnected(connected);
			setForegroundColor(connected ? ColorConstants.black : IFigureConstants.DEFAULT_TERMINAL_COLOR);
		}

		/* (non-Javadoc)
		 * @see org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure#paintFigure(org.eclipse.draw2d.Graphics)
		 */
		protected void paintFigure(Graphics graphics) {
			PointList points = getTransformedPointList();
			if (points != null) {
				graphics.setLineWidth(IFigureConstants.DEFAULT_LINE_WIDTH);

				PointList points1 = new PointList();
				points1.addPoint(points.getPoint(0));
				points1.addPoint(points.getPoint(1));
				points1.addPoint(points.getPoint(2));
				graphics.drawPolyline(points1);

				PointList points2 = new PointList();
				points2.addPoint(points.getPoint(3));
				points2.addPoint(points.getPoint(4));
				points2.addPoint(points.getPoint(5));
				graphics.drawPolyline(points2);
			}
		}

	}

}
