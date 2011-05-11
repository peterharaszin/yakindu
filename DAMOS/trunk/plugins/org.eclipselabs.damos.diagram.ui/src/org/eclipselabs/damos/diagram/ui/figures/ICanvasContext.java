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

import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Path;

/**
 * @author Andreas Unger
 *
 * @noextend
 * @noimplement
 */
public interface ICanvasContext {

	void clipRect(Rectangle r);

	void drawArc(int x, int y, int w, int h, int offset, int length);

	void drawFocus(int x, int y, int w, int h);

	void drawLine(int x1, int y1, int x2, int y2);

	void drawOval(int x, int y, int w, int h);

	void drawPolygon(int[] points);
	void drawPolygon(PointList points);

	void drawPolyline(int[] points);
	void drawPolyline(PointList points);

	void drawRectangle(int x, int y, int width, int height);
	void drawRectangle(Rectangle r);

	void drawRoundRectangle(int x, int y, int width, int height, int arcWidth, int arcHeight);
	void drawRoundRectangle(Rectangle r, int arcWidth, int arcHeight);
	
	void drawPath(Path path);

	void fillArc(int x, int y, int w, int h, int offset, int length);

	void fillOval(int x, int y, int w, int h);

	void fillPolygon(int[] points);
	void fillPolygon(PointList points);

	void fillRectangle(int x, int y, int width, int height);
	void fillRectangle(Rectangle r);

	void fillRoundRectangle(Rectangle r, int arcWidth, int arcHeight);
	
	void fillPath(Path path);

	Color getBackgroundColor();

	Color getForegroundColor();

	int getLineStyle();

	int getLineWidth();

	boolean getXORMode();

	void popState();

	void pushState();

	void restoreState();

	void setForegroundColor(Color rgb);
	void setBackgroundColor(Color rgb);
	void setAlpha(int alpha);

	void setClip(Rectangle r);

	void setLineStyle(int style);
	void setLineWidth(int width);

	void setXORMode(boolean b);

}