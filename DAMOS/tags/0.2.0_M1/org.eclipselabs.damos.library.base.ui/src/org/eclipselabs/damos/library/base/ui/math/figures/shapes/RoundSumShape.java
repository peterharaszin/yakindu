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

package org.eclipselabs.damos.library.base.ui.math.figures.shapes;

import org.eclipse.draw2d.LayoutManager;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipselabs.damos.diagram.ui.figures.ComponentFigure;
import org.eclipselabs.damos.diagram.ui.figures.ICanvasContext;
import org.eclipselabs.damos.diagram.ui.figures.IFigureConstants;
import org.eclipselabs.damos.diagram.ui.figures.OvalComponentLayout;
import org.eclipselabs.damos.library.common.ui.figures.shapes.AbstractBlockShape;

/**
 * @author Andreas Unger
 *
 */
public class RoundSumShape extends AbstractBlockShape implements IFigureConstants {
	
	/**
	 * @param blockFigure
	 */
	public RoundSumShape(ComponentFigure blockFigure) {
		super(blockFigure);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.library.basicblocks.figures.AbstractBlockShape#createLayoutManager()
	 */
	public LayoutManager createLayoutManager() {
		OvalComponentLayout layout = new OvalComponentLayout();
		layout.setOutputPortsArrangement("|o");
		return layout;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.diagram.figures.BlockFigure#calculateMinimumCanvasSize(int, int)
	 */
	public Dimension calculateMinimumCanvasSize(int wHint, int hHint) {
		return new Dimension(546, 546);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure#paintFigure(org.eclipse.draw2d.Graphics)
	 */
	public void paintCanvas(ICanvasContext cc) {
		Dimension size = blockFigure.getCanvasSize();
		cc.setLineWidth(DEFAULT_LINE_WIDTH);
		cc.drawOval(
				DEFAULT_LINE_WIDTH_HALF,
				DEFAULT_LINE_WIDTH_HALF,
				size.width - DEFAULT_LINE_WIDTH,
				size.height - DEFAULT_LINE_WIDTH);
	}

}
