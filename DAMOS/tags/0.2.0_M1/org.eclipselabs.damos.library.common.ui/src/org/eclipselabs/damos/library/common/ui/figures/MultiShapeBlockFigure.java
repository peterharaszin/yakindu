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

package org.eclipselabs.damos.library.common.ui.figures;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipselabs.damos.diagram.ui.figures.ICanvasContext;
import org.eclipselabs.damos.diagram.ui.figures.ComponentFigure;
import org.eclipselabs.damos.library.common.ui.figures.shapes.BlockShape;

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
	 * @see org.eclipselabs.damos.diagram.figures.BlockFigure#getAdapter(java.lang.Class)
	 */
	public Object getHelper(Class<?> clazz) {
		Object helper= shape.getHelper(clazz);
		if (helper != null) {
			return helper;
		}
		return super.getHelper(clazz);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.diagram.figures.BlockFigure#calculateMinimumCanvasSize(int, int)
	 */
	protected Dimension calculateMinimumCanvasSize(int wHint, int hHint) {
		if (shape != null) {
			return shape.calculateMinimumCanvasSize(wHint, hHint);
		}
		return null;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.diagram.figures.BlockFigure#paintCanvas(org.eclipse.draw2d.Graphics)
	 */
	protected void paintCanvas(ICanvasContext cc) {
		if (shape != null) {
			shape.paintCanvas(cc);
		}
	}
	
}
