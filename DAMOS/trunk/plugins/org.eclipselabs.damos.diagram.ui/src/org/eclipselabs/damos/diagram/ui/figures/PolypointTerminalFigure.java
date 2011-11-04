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

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipselabs.damos.diagram.ui.internal.figures.IConnectorFigure;
import org.eclipselabs.damos.diagram.ui.internal.geometry.Extents;
import org.eclipselabs.damos.diagram.ui.internal.geometry.Transform;

/**
 * @author Andreas Unger
 *
 */
public abstract class PolypointTerminalFigure extends TerminalFigure {

	/**
	 * 
	 */
	public PolypointTerminalFigure(IConnectorFigure owner) {
		super(owner);
	}
		
	/* (non-Javadoc)
	 * @see org.eclipse.draw2d.Figure#validate()
	 */
	public void validate() {
		if (isValid()) {
			return;
		}

		PointList points = getTransformedPointList();
		if (points != null) {
			setBounds(points.getBounds().getExpanded(IFigureConstants.DEFAULT_LINE_WIDTH, IFigureConstants.DEFAULT_LINE_WIDTH));
		}
		
		super.validate();
	}
	
	public Extents getExtents(double rotationHint) {
    	double rotation = !Double.isNaN(rotationHint) ? rotationHint : getOwner().getRotation();
		
		Transform transform = new Transform();
		transform.setRotation(-rotation);
		PointList points = transform.getTransformed(getPointList());
		
		return Extents.fromRectangle(points.getBounds());
	}
	
	protected PointList getTransformedPointList() {
		PointList points = null;
		
		Point terminalLocation = getOwner().getTerminalLocation();
		if (terminalLocation != null) {
			Transform transform = new Transform();
			transform.setRotation(-getOwner().getRotation());
			transform.setTranslation(terminalLocation.x, terminalLocation.y);
			points = transform.getTransformed(getPointList());
		}
		
		return points;
	}
	
	protected abstract PointList getPointList();
		
}
