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

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.draw2d.ui.geometry.PointListUtilities;
import org.eclipselabs.damos.diagram.ui.internal.figures.IBlankableFigure;

public class ConnectionFigure extends PolylineConnectionEx implements IBlankableFigure, IFigureConstants {
	
	private static final int JUNCTION_RADIUS = 80;
	
	private static final double DECORATION_SCALE_X = 7 * DEFAULT_LINE_WIDTH;
	private static final double DECORATION_SCALE_Y = 3 * DEFAULT_LINE_WIDTH;
	
	private boolean blanked;
	
	public ConnectionFigure() {
		PolygonDecoration decoration = new PolygonDecoration() {
			
			@Override
			public Rectangle getBounds() {
				return super.getBounds().getExpanded(DEFAULT_LINE_WIDTH, DEFAULT_LINE_WIDTH);
			}
			
		};
		decoration.setScale(DECORATION_SCALE_X, DECORATION_SCALE_Y);
		setTargetDecoration(decoration);
		setLineWidth(DEFAULT_LINE_WIDTH);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.draw2d.Figure#isVisible()
	 */
	@Override
	public boolean isVisible() {
		return !isBlanked() && super.isVisible();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.diagram.ui.internal.figures.IBlankableFigure#isBlank()
	 */
	public boolean isBlanked() {
		return blanked;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.diagram.ui.internal.figures.IBlankableFigure#setBlank(boolean)
	 */
	public void setBlanked(boolean blanked) {
		this.blanked = blanked;
		revalidate();
		repaint();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.draw2d.Shape#paintFigure(org.eclipse.draw2d.Graphics)
	 */
	@Override
	public void paintFigure(Graphics graphics) {
		super.paintFigure(graphics);
		if (hasJunction()) {
			Point p = getPoints().getPoint(1);
			graphics.setBackgroundColor(graphics.getForegroundColor());
			graphics.fillOval(p.x - JUNCTION_RADIUS, p.y - JUNCTION_RADIUS, 2 * JUNCTION_RADIUS, 2 * JUNCTION_RADIUS);
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx#getSmoothPoints(boolean)
	 */
	@Override
	public PointList getSmoothPoints(boolean calculateAppox) {
		PointList points = PointListUtilities.copyPoints(getPoints());
		if (points.size() > 0 && hasJunction()) {
			points.removePoint(0);
		}
		return points;
	}
	
	private boolean hasJunction() {
		boolean foundThis = false;
		for (Object o : getParent().getChildren()) {
			if (o == this) {
				foundThis = true;
				continue;
			}
			if (o instanceof ConnectionFigure) {
				ConnectionFigure connectionFigure = (ConnectionFigure) o;
				if (connectionFigure.isVisible() && connectionFigure.getSourceAnchor().getOwner() == getSourceAnchor().getOwner()
						&& connectionFigure.getStart().equals(getStart())) {
					Point junctionPoint = getPoints().getPoint(1);
					Point otherPoint1 = connectionFigure.getPoints().getPoint(0);
					Point otherPoint2 = connectionFigure.getPoints().getPoint(1);
					if (junctionPoint.x == otherPoint2.x) {
						int otherY1 = Math.min(otherPoint1.y, otherPoint2.y);
						int otherY2 = Math.max(otherPoint1.y, otherPoint2.y);
						if (foundThis && (junctionPoint.y == otherY1 || junctionPoint.y == otherY2)) {
							return true;
						} else if(junctionPoint.y > otherY1 && junctionPoint.y < otherY2) {
							return true;
						}
					} else if (junctionPoint.y == otherPoint2.y) {
						int otherX1 = Math.min(otherPoint1.x, otherPoint2.x);
						int otherX2 = Math.max(otherPoint1.x, otherPoint2.x);
						if (foundThis && (junctionPoint.x == otherX1 && junctionPoint.x == otherX2)) {
							return true;
						} else if (junctionPoint.x > otherX1 && junctionPoint.x < otherX2) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	
}
