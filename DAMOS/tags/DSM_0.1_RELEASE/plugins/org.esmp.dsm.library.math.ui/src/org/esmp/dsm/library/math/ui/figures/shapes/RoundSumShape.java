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

package org.esmp.dsm.library.math.ui.figures.shapes;

import org.eclipse.draw2d.LayoutManager;
import org.eclipse.draw2d.geometry.Dimension;
import org.esmp.dsm.diagram.ui.figures.BlockFigure;
import org.esmp.dsm.diagram.ui.figures.CanvasContext;
import org.esmp.dsm.diagram.ui.figures.FigureConstants;
import org.esmp.dsm.diagram.ui.figures.OvalBlockLayout;
import org.esmp.dsm.library.basic.ui.figures.shapes.AbstractBlockShape;

/**
 * @author Andreas Unger
 *
 */
public class RoundSumShape extends AbstractBlockShape implements FigureConstants {
	
	/**
	 * @param blockFigure
	 */
	public RoundSumShape(BlockFigure blockFigure) {
		super(blockFigure);
	}

	/* (non-Javadoc)
	 * @see org.esmp.dsm.library.basicblocks.figures.AbstractBlockShape#createLayoutManager()
	 */
	public LayoutManager createLayoutManager() {
		OvalBlockLayout layout = new OvalBlockLayout();
		layout.setOutputPortsArrangement("|o");
		return layout;
	}

	/* (non-Javadoc)
	 * @see org.esmp.dsm.diagram.figures.BlockFigure#calculateMinimumCanvasSize(int, int)
	 */
	public Dimension calculateMinimumCanvasSize(int wHint, int hHint) {
		return new Dimension(546, 546);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure#paintFigure(org.eclipse.draw2d.Graphics)
	 */
	public void paintCanvas(CanvasContext cc) {
		Dimension size = blockFigure.getCanvasSize();
		cc.setLineWidth(DEFAULT_LINE_WIDTH);
		cc.drawOval(
				DEFAULT_LINE_WIDTH_HALF,
				DEFAULT_LINE_WIDTH_HALF,
				size.width - DEFAULT_LINE_WIDTH,
				size.height - DEFAULT_LINE_WIDTH);
	}

}
