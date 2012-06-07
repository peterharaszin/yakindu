/****************************************************************************
 * Copyright (c) 2008, 2010 Andreas Unger and others.
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
import org.eclipse.draw2d.geometry.PointList;
import org.eclipselabs.damos.diagram.ui.internal.figures.IConnectorFigure;


/**
 * @author Andreas Unger
 *
 */
public abstract class PolygonTerminalFigure extends PolypointTerminalFigure {

	/**
	 * @param owner
	 */
	public PolygonTerminalFigure(IConnectorFigure owner) {
		super(owner);
	}

	protected void paintFigure(Graphics graphics) {
		PointList points = getTransformedPointList();
		if (points != null) {
			graphics.setLineWidth(IFigureConstants.DEFAULT_LINE_WIDTH);
			graphics.drawPolygon(points);
		}
	}

}
