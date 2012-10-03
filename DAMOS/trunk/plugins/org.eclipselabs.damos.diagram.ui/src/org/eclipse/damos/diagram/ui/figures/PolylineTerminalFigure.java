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

package org.eclipse.damos.diagram.ui.figures;

import org.eclipse.damos.diagram.ui.internal.figures.IConnectorFigure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.PointList;

/**
 * @author Andreas Unger
 *
 */
public abstract class PolylineTerminalFigure extends PolypointTerminalFigure {

	/**
	 * @param owner
	 */
	public PolylineTerminalFigure(IConnectorFigure owner) {
		super(owner);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure#paintFigure(org.eclipse.draw2d.Graphics)
	 */
	protected void paintFigure(Graphics graphics) {
		PointList points = getTransformedPointList();
		if (points != null) {
			graphics.setLineWidth(IFigureConstants.DEFAULT_LINE_WIDTH);
			graphics.drawPolyline(points);
		}
	}

}
