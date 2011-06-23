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

package org.eclipselabs.damos.library.common.ui.figures.shapes;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LayoutManager;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipselabs.damos.diagram.ui.figures.ComponentFigure;
import org.eclipselabs.damos.diagram.ui.figures.ICanvasContext;
import org.eclipselabs.damos.dml.Port;

/**
 * @author Andreas Unger
 *
 */
public abstract class AbstractBlockShape implements BlockShape {

	private IFigure contentFigure;
	protected ComponentFigure blockFigure;
	
	public AbstractBlockShape(ComponentFigure blockFigure) {
		this.blockFigure = blockFigure;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.library.basicblocks.figures.IBlockShape#getHelper(java.lang.Class)
	 */
	public Object getHelper(Class<?> clazz) {
		return null;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.library.basicblocks.figures.IBlockShape#createLayoutManager()
	 */
	public LayoutManager createLayoutManager() {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.library.basicblocks.figures.IBlockShape#createFigureChildren()
	 */
	public IFigure createContentFigure() {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.library.basicblocks.figures.IBlockShape#getContentFigure()
	 */
	public final IFigure getContentFigure() {
		if (contentFigure == null) {
			contentFigure = createContentFigure();
		}
		return contentFigure;
	};

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.library.basicblocks.figures.IBlockShape#createContentFigureConstraint()
	 */
	public Object getContentFigureConstraint() {
		return null;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.library.basicblocks.figures.IBlockShape#getPortFigureConstraint(org.eclipselabs.damos.semantic.blockdiagram.Port)
	 */
	public Object getPortFigureConstraint(Port port) {
		return null;
	}
		
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.library.basicblocks.figures.IBlockShape#calculateMinimumCanvasSize(int, int)
	 */
	public Dimension calculateMinimumCanvasSize(int wHint, int hHint) {
		return null;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.library.basicblocks.figures.IBlockShape#paintCanvas(org.eclipse.draw2d.Graphics)
	 */
	public void paintCanvas(ICanvasContext cc) {
	}

}
