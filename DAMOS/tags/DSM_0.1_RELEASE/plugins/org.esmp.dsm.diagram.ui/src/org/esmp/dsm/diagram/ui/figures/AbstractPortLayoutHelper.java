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

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.esmp.dsm.diagram.ui.internal.geometry.Geometry;

/**
 * @author Andreas Unger
 *
 */
public abstract class AbstractPortLayoutHelper implements IPortLayoutHelper {

	protected BlockFigure blockFigure;
	
	/**
	 * 
	 */
	public AbstractPortLayoutHelper(BlockFigure blockFigure) {
		this.blockFigure = blockFigure;
	}
	
	/* (non-Javadoc)
	 * @see org.esmp.dsm.diagram.figures.IPortLayoutHelper#getMaximumTerminalDisplacement(int)
	 */
	public final int getMaximumTerminalDisplacement(int side) {
		return calculateMaximumTerminalDisplacement(
				Geometry.reverseTransformSide(side, blockFigure.isFlipped(), blockFigure.getRotation()));
	}

	protected int calculateMaximumTerminalDisplacement(int side) {
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.esmp.dsm.diagram.figures.IPortLayoutHelper#getTerminalDisplacement(int, int, int)
	 */
	public final int getTerminalDisplacement(int xHint, int yHint, int side) {
		Rectangle bounds = blockFigure.getBounds();
		xHint -= bounds.x;
		yHint -= bounds.y;
		
		Dimension canvasSize = Geometry.transformDimension(new Dimension(bounds.width, bounds.height), blockFigure.getRotation());
		Point locationHint = Geometry.reverseTransformPoint(new Point(xHint, yHint), blockFigure.isFlipped(), blockFigure.getRotation(), canvasSize.width, canvasSize.height);
		side = Geometry.reverseTransformSide(side, blockFigure.isFlipped(), blockFigure.getRotation());
		
		return calculateTerminalDisplacement(locationHint.x, locationHint.y, side);
	}

	protected abstract int calculateTerminalDisplacement(int xHint, int yHint, int sideHint);
	
}
