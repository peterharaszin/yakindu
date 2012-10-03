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

package org.eclipse.damos.diagram.ui.internal.figures;

import org.eclipse.damos.diagram.core.internal.util.MathUtil;
import org.eclipse.damos.diagram.ui.figures.ICanvasContext;
import org.eclipse.damos.diagram.ui.internal.geometry.Geometry;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Path;
import org.eclipse.swt.graphics.PathData;

/**
 * @author Andreas Unger
 *
 */
public class CanvasContext implements ICanvasContext {

	private Graphics graphics;
	private Dimension canvasSize;
	private boolean flipped;
	private int rotation;
	
	private Point cachedPoint1;
	private Point cachedPoint2;
	private Rectangle cachedRectangle;
	
	/**
	 * 
	 */
	public CanvasContext(Graphics graphics, Dimension canvasSize, boolean flipped, int rotation) {
		this.graphics = graphics;
		this.canvasSize = canvasSize;
		this.flipped = flipped;
		this.rotation = rotation;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.figures.ICanvas#clipRect(org.eclipse.draw2d.geometry.Rectangle)
	 */
	public void clipRect(Rectangle r) {
		graphics.clipRect(transformRectangle(r.x, r.y, r.width, r.height));
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.figures.ICanvas#drawArc(int, int, int, int, int, int)
	 */
	public void drawArc(int x, int y, int w, int h, int offset, int length) {
		drawArc(x, y, w, h, offset, length, false);
	}
	
	private void drawArc(int x, int y, int w, int h, int offset, int length, boolean fill) {
		Rectangle r = transformRectangle(x, y, w, h);
		
		if (flipped) {
			offset = 180 - offset - length;
		}
		
		offset = MathUtil.normalizeAngle(offset + rotation);

		if (fill) {
			graphics.fillArc(r, offset, length);
		} else {
			graphics.drawArc(r, offset, length);
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.figures.ICanvas#drawFocus(int, int, int, int)
	 */
	public void drawFocus(int x, int y, int w, int h) {
		graphics.drawFocus(transformRectangle(x, y, w, h));
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.figures.ICanvas#drawLine(int, int, int, int)
	 */
	public void drawLine(int x1, int y1, int x2, int y2) {
		graphics.drawLine(transformPoint1(x1, y1), transformPoint2(x2, y2));
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.figures.ICanvas#drawOval(int, int, int, int)
	 */
	public void drawOval(int x, int y, int w, int h) {
		graphics.drawOval(transformRectangle(x, y, w, h));
	}
	
	public void drawPolygon(int[] points) {
		drawPolygon(new PointList(points));
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.figures.ICanvas#drawPolygon(org.eclipse.draw2d.geometry.PointList)
	 */
	public void drawPolygon(PointList points) {
		graphics.drawPolygon(transformPoints(points.getCopy()));
	}

	public void drawPolyline(int[] points) {
		drawPolyline(new PointList(points));
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.figures.ICanvas#drawPolyline(org.eclipse.draw2d.geometry.PointList)
	 */
	public void drawPolyline(PointList points) {
		graphics.drawPolyline(transformPoints(points.getCopy()));
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.figures.ICanvas#drawRectangle(int, int, int, int)
	 */
	public void drawRectangle(int x, int y, int width, int height) {
		graphics.drawRectangle(transformRectangle(x, y, width, height));
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.figures.ICanvasContext#drawRectangle(org.eclipse.draw2d.geometry.Rectangle)
	 */
	public void drawRectangle(Rectangle r) {
		drawRectangle(r.x, r.y, r.width, r.height);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.ui.figures.CanvasContext#drawRoundRectangle(int, int, int, int, int)
	 */
	public void drawRoundRectangle(int x, int y, int width, int height, int arcWidth, int arcHeight) {
		graphics.drawRoundRectangle(transformRectangle(x, y, width, height), arcWidth, arcHeight);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.figures.ICanvas#drawRoundRectangle(org.eclipse.draw2d.geometry.Rectangle, int, int)
	 */
	public void drawRoundRectangle(Rectangle r, int arcWidth, int arcHeight) {
		drawRoundRectangle(r.x, r.y, r.width, r.height, arcWidth, arcHeight);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.ui.figures.ICanvasContext#drawPath(org.eclipse.swt.graphics.Path)
	 */
	public void drawPath(Path path) {
		PathData data = path.getPathData();
		Geometry.transformPoints(data.points, flipped, rotation, canvasSize.width, canvasSize.height);
		path = new Path(path.getDevice(), data);
		try {
			graphics.drawPath(path);
		} finally {
			path.dispose();
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.figures.ICanvas#fillArc(int, int, int, int, int, int)
	 */
	public void fillArc(int x, int y, int w, int h, int offset, int length) {
		drawArc(x, y, w, h, offset, length, true);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.figures.ICanvas#fillOval(int, int, int, int)
	 */
	public void fillOval(int x, int y, int w, int h) {
		graphics.fillOval(transformRectangle(x, y, w, h));
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.ui.figures.ICanvasContext#fillPolygon(int[])
	 */
	public void fillPolygon(int[] points) {
		fillPolygon(new PointList(points));
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.figures.ICanvas#fillPolygon(org.eclipse.draw2d.geometry.PointList)
	 */
	public void fillPolygon(PointList points) {
		graphics.fillPolygon(transformPoints(points.getCopy()));
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.figures.ICanvas#fillRectangle(int, int, int, int)
	 */
	public void fillRectangle(int x, int y, int width, int height) {
		graphics.fillRectangle(transformRectangle(x, y, width, height));
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.ui.figures.CanvasContext#fillRectangle(org.eclipse.draw2d.geometry.Rectangle)
	 */
	public void fillRectangle(Rectangle r) {
		fillRectangle(r.x, r.y, r.width, r.height);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.figures.ICanvas#fillRoundRectangle(org.eclipse.draw2d.geometry.Rectangle, int, int)
	 */
	public void fillRoundRectangle(Rectangle r, int arcWidth, int arcHeight) {
		graphics.fillRoundRectangle(transformRectangle(r.x, r.y, r.width, r.height), arcWidth, arcHeight);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.ui.figures.ICanvasContext#fillPath(org.eclipse.swt.graphics.Path)
	 */
	public void fillPath(Path path) {
		PathData data = path.getPathData();
		Geometry.transformPoints(data.points, flipped, rotation, canvasSize.width, canvasSize.height);
		path = new Path(path.getDevice(), data);
		try {
			graphics.fillPath(path);
		} finally {
			path.dispose();
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.figures.ICanvas#getBackgroundColor()
	 */
	public Color getBackgroundColor() {
		return graphics.getBackgroundColor();
	}

//	public Rectangle getClip(Rectangle rect) {
//		// TODO: Check of TransformedGraphics#getClip(Rectangle) works.
//		return reverseTransformRectangle(rect.x, rect.y, rect.width, rect.height);
//	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.figures.ICanvas#getForegroundColor()
	 */
	public Color getForegroundColor() {
		return graphics.getForegroundColor();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.figures.ICanvas#getLineStyle()
	 */
	public int getLineStyle() {
		return graphics.getLineStyle();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.figures.ICanvas#getLineWidth()
	 */
	public int getLineWidth() {
		return graphics.getLineWidth();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.figures.ICanvas#getXORMode()
	 */
	public boolean getXORMode() {
		return graphics.getXORMode();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.figures.ICanvas#popState()
	 */
	public void popState() {
		graphics.popState();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.figures.ICanvas#pushState()
	 */
	public void pushState() {
		graphics.pushState();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.figures.ICanvas#restoreState()
	 */
	public void restoreState() {
		graphics.restoreState();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.figures.ICanvas#setForegroundColor(org.eclipse.swt.graphics.Color)
	 */
	public void setForegroundColor(Color rgb) {
		graphics.setForegroundColor(rgb);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.figures.ICanvas#setBackgroundColor(org.eclipse.swt.graphics.Color)
	 */
	public void setBackgroundColor(Color rgb) {
		graphics.setBackgroundColor(rgb);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.ui.figures.CanvasContext#setAlpha(int)
	 */
	public void setAlpha(int alpha) {
		graphics.setAlpha(alpha);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.figures.ICanvas#setClip(org.eclipse.draw2d.geometry.Rectangle)
	 */
	public void setClip(Rectangle r) {
		graphics.setClip(transformRectangle(r.x, r.y, r.width, r.height));
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.figures.ICanvas#setLineStyle(int)
	 */
	public void setLineStyle(int style) {
		graphics.setLineStyle(style);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.figures.ICanvas#setLineWidth(int)
	 */
	public void setLineWidth(int width) {
		graphics.setLineWidth(width);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.figures.ICanvas#setXORMode(boolean)
	 */
	public void setXORMode(boolean b) {
		graphics.setXORMode(b);
	}

	private Point transformPoint1(int x, int y) {
		if (cachedPoint1 == null) {
			cachedPoint1 = new Point();
		}
		cachedPoint1.x = x;
		cachedPoint1.y = y;
		return Geometry.transformPoint(cachedPoint1, flipped, rotation, canvasSize.width, canvasSize.height);
	}
	
	private Point transformPoint2(int x, int y) {
		if (cachedPoint2 == null) {
			cachedPoint2 = new Point();
		}
		cachedPoint2.x = x;
		cachedPoint2.y = y;
		return Geometry.transformPoint(cachedPoint2, flipped, rotation, canvasSize.width, canvasSize.height);
	}
/*	
	private Point reverseTransformPoint1(int x, int y) {
		if (cachedPoint1 == null) {
			cachedPoint1 = new Point();
		}
		cachedPoint1.x = x;
		cachedPoint1.y = y;
		return Geometry.reverseTransformPoint(cachedPoint1, flipped, rotation, canvasSize.width, canvasSize.height);
	}
	
	private Point reverseTransformPoint2(int x, int y) {
		if (cachedPoint2 == null) {
			cachedPoint2 = new Point();
		}
		cachedPoint2.x = x;
		cachedPoint2.y = y;
		return Geometry.reverseTransformPoint(cachedPoint2, flipped, rotation, canvasSize.width, canvasSize.height);
	}
*/	
	private PointList transformPoints(PointList points) {
		if (cachedPoint1 == null) {
			cachedPoint1 = new Point();
		}
		for (int i = 0; i < points.size(); ++i) {
			points.getPoint(cachedPoint1, i);
			Geometry.transformPoint(cachedPoint1, flipped, rotation, canvasSize.width, canvasSize.height);
			points.setPoint(cachedPoint1, i);
		}
		return points;
	}
	
	private Rectangle transformRectangle(int x, int y, int w, int h) {
		if (cachedRectangle == null) {
			cachedRectangle = new Rectangle();
		}
		Point p1 = transformPoint1(x, y);
		Point p2 = transformPoint2(x + w, y + h);
		cachedRectangle.x = Math.min(p1.x, p2.x);
		cachedRectangle.y = Math.min(p1.y, p2.y);
		cachedRectangle.width = Math.abs(p2.x - p1.x);
		cachedRectangle.height = Math.abs(p2.y - p1.y);
		return cachedRectangle;
	}
/*	
	private Rectangle reverseTransformRectangle(int x, int y, int w, int h) {
		if (cachedRectangle == null) {
			cachedRectangle = new Rectangle();
		}
		Point p1 = reverseTransformPoint1(x, y);
		Point p2 = reverseTransformPoint2(x + w, y + h);
		cachedRectangle.x = Math.min(p1.x, p2.x);
		cachedRectangle.y = Math.min(p1.y, p2.y);
		cachedRectangle.width = Math.abs(p2.x - p1.x);
		cachedRectangle.height = Math.abs(p2.y - p1.y);
		return cachedRectangle;
	}
*/
}
