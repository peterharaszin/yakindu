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

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipselabs.damos.diagram.ui.internal.geometry.Geometry;

/**
 * @author Andreas Unger
 *
 */
public abstract class AbstractPortLayoutHelper implements IPortLayoutHelper {

	private ComponentFigure componentFigure;
	
	/**
	 * 
	 */
	public AbstractPortLayoutHelper(ComponentFigure componentFigure) {
		this.componentFigure = componentFigure;
	}
	
	/**
	 * @return the componentFigure
	 */
	protected ComponentFigure getComponentFigure() {
		return componentFigure;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.diagram.figures.IPortLayoutHelper#getMaximumTerminalDisplacement(int)
	 */
	public final int getMaximumTerminalDisplacement(int side) {
		return calculateMaximumTerminalDisplacement(
				Geometry.reverseTransformSide(side, componentFigure.isFlipped(), componentFigure.getRotation()));
	}

	protected int calculateMaximumTerminalDisplacement(int side) {
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.diagram.figures.IPortLayoutHelper#getTerminalDisplacement(int, int, int)
	 */
	public final int getTerminalDisplacement(int xHint, int yHint, int side) {
		Rectangle bounds = componentFigure.getBounds();
		xHint -= bounds.x;
		yHint -= bounds.y;
		
		Dimension canvasSize = Geometry.transformDimension(new Dimension(bounds.width, bounds.height), componentFigure.getRotation());
		Point locationHint = Geometry.reverseTransformPoint(new Point(xHint, yHint), componentFigure.isFlipped(), componentFigure.getRotation(), canvasSize.width, canvasSize.height);
		side = Geometry.reverseTransformSide(side, componentFigure.isFlipped(), componentFigure.getRotation());
		
		return calculateTerminalDisplacement(locationHint.x, locationHint.y, side);
	}

	protected abstract int calculateTerminalDisplacement(int xHint, int yHint, int sideHint);
	
}
