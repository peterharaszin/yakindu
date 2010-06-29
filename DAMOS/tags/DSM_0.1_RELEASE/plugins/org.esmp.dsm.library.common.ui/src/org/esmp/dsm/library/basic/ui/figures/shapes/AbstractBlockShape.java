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

package org.esmp.dsm.library.basic.ui.figures.shapes;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LayoutManager;
import org.eclipse.draw2d.geometry.Dimension;
import org.esmp.dsm.diagram.ui.figures.BlockFigure;
import org.esmp.dsm.diagram.ui.figures.CanvasContext;
import org.esmp.dsm.semantic.blockdiagram.Port;

/**
 * @author Andreas Unger
 *
 */
public abstract class AbstractBlockShape implements BlockShape {

	private IFigure contentFigure;
	protected BlockFigure blockFigure;
	
	public AbstractBlockShape(BlockFigure blockFigure) {
		this.blockFigure = blockFigure;
	}
	
	/* (non-Javadoc)
	 * @see org.esmp.dsm.library.basicblocks.figures.IBlockShape#getHelper(java.lang.Class)
	 */
	public Object getHelper(Class<?> clazz) {
		return null;
	}
	
	/* (non-Javadoc)
	 * @see org.esmp.dsm.library.basicblocks.figures.IBlockShape#createLayoutManager()
	 */
	public LayoutManager createLayoutManager() {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.esmp.dsm.library.basicblocks.figures.IBlockShape#createFigureChildren()
	 */
	public IFigure createContentFigure() {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.esmp.dsm.library.basicblocks.figures.IBlockShape#getContentFigure()
	 */
	public final IFigure getContentFigure() {
		if (contentFigure == null) {
			contentFigure = createContentFigure();
		}
		return contentFigure;
	};

	/* (non-Javadoc)
	 * @see org.esmp.dsm.library.basicblocks.figures.IBlockShape#createContentFigureConstraint()
	 */
	public Object getContentFigureConstraint() {
		return null;
	}
	
	/* (non-Javadoc)
	 * @see org.esmp.dsm.library.basicblocks.figures.IBlockShape#getPortFigureConstraint(org.esmp.dsm.semantic.blockdiagram.Port)
	 */
	public Object getPortFigureConstraint(Port port) {
		return null;
	}
		
	/* (non-Javadoc)
	 * @see org.esmp.dsm.library.basicblocks.figures.IBlockShape#calculateMinimumCanvasSize(int, int)
	 */
	public Dimension calculateMinimumCanvasSize(int wHint, int hHint) {
		return null;
	}
	
	/* (non-Javadoc)
	 * @see org.esmp.dsm.library.basicblocks.figures.IBlockShape#paintCanvas(org.eclipse.draw2d.Graphics)
	 */
	public void paintCanvas(CanvasContext cc) {
	}

}
