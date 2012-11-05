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

package org.eclipse.damos.diagram.ui.internal.geometry;

import org.eclipse.damos.diagram.core.internal.util.MathUtil;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.draw2d.ui.geometry.PointListUtilities;
import org.eclipse.swt.SWT;

/**
 * @author Andreas Unger
 *
 */
public class Geometry {
	
	private static double ANGLE_NORTH = Math.toRadians(90);
	private static double ANGLE_SOUTH = Math.toRadians(270);
	private static double ANGLE_WEST = Math.toRadians(180);
	private static double ANGLE_EAST = Math.toRadians(0);
	
	public static double positionToAngle(int side) {
		switch (side) {
		case PositionConstants.NORTH:
			return ANGLE_NORTH;
		case PositionConstants.SOUTH:
			return ANGLE_SOUTH;
		case PositionConstants.WEST:
			return ANGLE_WEST;
		case PositionConstants.EAST:
			return ANGLE_EAST;
		}
		throw new IllegalArgumentException();
	}
	
	/**
	 * Returns the rectangle border intersection point P of the line starting at the center of the rectangle with the given angle.
	 * <pre>
	 *       P
	 * +-----x-----------+
	 * |      \          |
	 * |       \ angle   |
	 * |        x- - - - |
	 * |      center     |
	 * |                 |
	 * +-----------------+
	 * </pre>
	 * 
	 * @param r the rectangle.
	 * @param angle the angle of the line.
	 * @return the intersection point of the line and the rectangle border.
	 */
	public static Point getRectangleCenterLineIntersectionPoint(Rectangle r, double angle) {
		int l = Math.max(r.width, r.height);
		int cx = r.x + r.width / 2;
		int cy = r.y + r.height / 2;
		int x = cx + (int) Math.round(l * Math.cos(angle));
		int y = cy - (int) Math.round(l * Math.sin(angle));
		
		PointList line = new PointList(new int[] { cx, cy, x, y });
		PointList rPoints = PointListUtilities.createPointsFromRect(r);
		PointList intersections = new PointList(1);
		PointListUtilities.findIntersections(rPoints, line, intersections, new PointList(1));
		
		return intersections.size() > 0 ? intersections.getFirstPoint() : r.getCenter();
	}
	
	/**
	 * Moves the given rectangle so that the given point P is located on the rectangle border with the given angle.
	 * <pre>
	 *       P
	 * +-----x-----------+
	 * |      \          |
	 * |       \ angle   |
	 * |        x- - - - |
	 * |      center     |
	 * |                 |
	 * +-----------------+
	 * </pre>
	 *  
	 * @param r the given rectangle.
	 * @param p the border point location.
	 * @param angle the angle of the line starting at the center of the rectangle and cutting the rectangle.
	 */
	public static Rectangle moveRectangleToBorderPoint(Rectangle r, Point p, double angle) {
		Point intersectionPoint = getRectangleCenterLineIntersectionPoint(r, angle);
		
		r.x += p.x - intersectionPoint.x;
		r.y += p.y - intersectionPoint.y;
		
		return r;
	}

	public static Point transformPoint(Point p, boolean flipped, int rotation, int width, int height) {		
		if (flipped) {
			p.x = width - p.x;
		}
		
		int x = p.x;
		int y = p.y;
		
		switch (rotation) {
		case 90:
			p.x = y;
			p.y = width - x;
			break;
		case 180:
			p.x = width - x;
			p.y = height - y;
			break;
		case 270:
			p.x = height - y;
			p.y = x;
			break;
		}
		return p;
	}
	
	public static void transformPoints(float[] points, boolean flipped, int rotation, float width, float height) {
		for (int i = 0, j = 1; j < points.length; i += 2, j += 2) {
			if (flipped) {
				points[i] = width - points[i];
			}
			
			float x = points[i];
			float y = points[j];
			
			switch (rotation) {
			case 90:
				points[i] = y;
				points[j] = width - x;
				break;
			case 180:
				points[i] = width - x;
				points[j] = height - y;
				break;
			case 270:
				points[i] = height - y;
				points[j] = x;
				break;
			}
		}
	}

	public static Point reverseTransformPoint(Point p, boolean flipped, int rotation, int width, int height) {		
		int x = p.x;
		int y = p.y;
		
		switch (rotation) {
		case 90:
			p.x = width - y;
			p.y = x;
			break;
		case 180:
			p.x = width - x;
			p.y = height - y;
			break;
		case 270:
			p.x = y;
			p.y = height - x;
			break;
		}
		
		if (flipped) {
			p.x = width - p.x;
		}
		
		return p;
	}
	
	public static Dimension transformDimension(Dimension d, int rotation) {
		if (rotation == 90 || rotation == 270) {
			d.transpose();
		}
		return d;
	}
	
	public static int transformSide(int side, boolean flipped, int rotation) {
		if (flipped) {
			switch (side) {
			case PositionConstants.EAST:
				side = PositionConstants.WEST;
				break;
			case PositionConstants.WEST:
				side = PositionConstants.EAST;
				break;
			}
		}
		switch (rotation) {
		case 90:
			switch (side) {
			case PositionConstants.EAST:
				return PositionConstants.NORTH;
			case PositionConstants.WEST:
				return PositionConstants.SOUTH;
			case PositionConstants.NORTH:
				return PositionConstants.WEST;
			case PositionConstants.SOUTH:
				return PositionConstants.EAST;
			}
			break;
		case 180:
			switch (side) {
			case PositionConstants.EAST:
				return PositionConstants.WEST;
			case PositionConstants.WEST:
				return PositionConstants.EAST;
			case PositionConstants.NORTH:
				return PositionConstants.SOUTH;
			case PositionConstants.SOUTH:
				return PositionConstants.NORTH;
			}
			break;
		case 270:
			switch (side) {
			case PositionConstants.EAST:
				return PositionConstants.SOUTH;
			case PositionConstants.WEST:
				return PositionConstants.NORTH;
			case PositionConstants.NORTH:
				return PositionConstants.EAST;
			case PositionConstants.SOUTH:
				return PositionConstants.WEST;
			}
			break;
		}
		return side;
	}
	
	public static int reverseTransformSide(int side, boolean flipped, int rotation) {
		switch (rotation) {
		case 90:
			switch (side) {
			case PositionConstants.EAST:
				side = PositionConstants.SOUTH;
				break;
			case PositionConstants.WEST:
				side = PositionConstants.NORTH;
				break;
			case PositionConstants.NORTH:
				side = PositionConstants.EAST;
				break;
			case PositionConstants.SOUTH:
				side = PositionConstants.WEST;
				break;
			}
			break;
		case 180:
			switch (side) {
			case PositionConstants.EAST:
				side = PositionConstants.WEST;
				break;
			case PositionConstants.WEST:
				side = PositionConstants.EAST;
				break;
			case PositionConstants.NORTH:
				side = PositionConstants.SOUTH;
				break;
			case PositionConstants.SOUTH:
				side = PositionConstants.NORTH;
				break;
			}
			break;
		case 270:
			switch (side) {
			case PositionConstants.EAST:
				side = PositionConstants.NORTH;
				break;
			case PositionConstants.WEST:
				side = PositionConstants.SOUTH;
				break;
			case PositionConstants.NORTH:
				side = PositionConstants.WEST;
				break;
			case PositionConstants.SOUTH:
				side = PositionConstants.EAST;
				break;
			}
			break;
		}
		if (flipped) {
			switch (side) {
			case PositionConstants.EAST:
				return PositionConstants.WEST;
			case PositionConstants.WEST:
				return PositionConstants.EAST;
			}
		}
		return side;
	}
	
	public static Alignment transformAlignment(Alignment alignment, boolean flipped, int rotation) {
		int alignmentAngle = -1;
		boolean filled = false;
		
		switch (alignment.horizontal) {
		case SWT.BEGINNING:
			switch (alignment.vertical) {
			case SWT.BEGINNING:
				alignmentAngle = 135;
				break;
			case SWT.FILL:
				filled = true;
			case SWT.CENTER:
				alignmentAngle = 180;
				break;
			case SWT.END:
				alignmentAngle = 225;
				break;
			}
			break;
		case SWT.FILL:
			filled = true;
		case SWT.CENTER:
			switch (alignment.vertical) {
			case SWT.BEGINNING:
				alignmentAngle = 90;
				break;
			case SWT.END:
				alignmentAngle = 270;
				break;
			}
			break;
		case SWT.END:
			switch (alignment.vertical) {
			case SWT.BEGINNING:
				alignmentAngle = 45;
				break;
			case SWT.FILL:
				filled = true;
			case SWT.CENTER:
				alignmentAngle = 0;
				break;
			case SWT.END:
				alignmentAngle = 315;
				break;
			}
			break;
		}
		
		if (alignmentAngle != -1) {
			if (flipped) {
				alignmentAngle = 180 - alignmentAngle;
			}
			alignmentAngle += rotation;
			alignmentAngle = MathUtil.normalizeAngle(alignmentAngle);
			switch (alignmentAngle) {
			case 0:
				alignment.horizontal = SWT.END;
				alignment.vertical = filled ? SWT.FILL : SWT.CENTER;
				break;
			case 45:
				alignment.horizontal = SWT.END;
				alignment.vertical = SWT.BEGINNING;
				break;
			case 90:
				alignment.horizontal = filled ? SWT.FILL : SWT.CENTER;
				alignment.vertical = SWT.BEGINNING;
				break;
			case 135:
				alignment.horizontal = SWT.BEGINNING;
				alignment.vertical = SWT.BEGINNING;
				break;
			case 180:
				alignment.horizontal = SWT.BEGINNING;
				alignment.vertical = filled ? SWT.FILL : SWT.CENTER;
				break;
			case 225:
				alignment.horizontal = SWT.BEGINNING;
				alignment.vertical = SWT.END;
				break;
			case 270:
				alignment.horizontal = filled ? SWT.FILL : SWT.CENTER;
				alignment.vertical = SWT.END;
				break;
			case 315:
				alignment.horizontal = SWT.END;
				alignment.vertical = SWT.END;
				break;
			}
		}

		return alignment;
	}
	
}
