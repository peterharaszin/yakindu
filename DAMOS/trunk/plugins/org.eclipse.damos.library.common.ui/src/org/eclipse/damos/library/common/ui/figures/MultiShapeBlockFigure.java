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

package org.eclipse.damos.library.common.ui.figures;

import org.eclipse.damos.diagram.ui.figures.ComponentFigure;
import org.eclipse.damos.diagram.ui.figures.ICanvasContext;
import org.eclipse.damos.library.common.ui.figures.shapes.BlockShape;
import org.eclipse.draw2d.geometry.Dimension;

/**
 * @author Andreas Unger
 *
 */
public class MultiShapeBlockFigure extends ComponentFigure {

	private BlockShape shape;
	
	public BlockShape getShape() {
		return shape;
	}
	
	public void setShape(BlockShape shape) {
		this.shape = shape;
		revalidate();
		repaint();
	}
		
	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.figures.BlockFigure#getAdapter(java.lang.Class)
	 */
	public Object getHelper(Class<?> clazz) {
		Object helper= shape.getHelper(clazz);
		if (helper != null) {
			return helper;
		}
		return super.getHelper(clazz);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.figures.BlockFigure#calculateMinimumCanvasSize(int, int)
	 */
	protected Dimension calculateMinimumCanvasSize(int wHint, int hHint) {
		if (shape != null) {
			return shape.calculateMinimumCanvasSize(wHint, hHint);
		}
		return null;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.figures.BlockFigure#paintCanvas(org.eclipse.draw2d.Graphics)
	 */
	protected void paintCanvas(ICanvasContext cc) {
		if (shape != null) {
			shape.paintCanvas(cc);
		}
	}
	
}
