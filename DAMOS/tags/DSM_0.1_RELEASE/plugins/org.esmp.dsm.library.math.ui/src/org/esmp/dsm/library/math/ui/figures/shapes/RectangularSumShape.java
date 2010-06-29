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
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.esmp.dsm.diagram.ui.figures.BlockFigure;
import org.esmp.dsm.diagram.ui.figures.CanvasContext;
import org.esmp.dsm.diagram.ui.figures.FigureConstants;
import org.esmp.dsm.diagram.ui.figures.StandardBlockLayout;
import org.esmp.dsm.diagram.ui.figures.StandardBlockPortLayoutData;
import org.esmp.dsm.library.basic.ui.figures.shapes.AbstractBlockShape;
import org.esmp.dsm.semantic.blockdiagram.InputPort;
import org.esmp.dsm.semantic.blockdiagram.OutputPort;
import org.esmp.dsm.semantic.blockdiagram.Port;

/**
 * @author Andreas Unger
 *
 */
public class RectangularSumShape extends AbstractBlockShape implements FigureConstants {
	
	/**
	 * @param blockFigure
	 */
	public RectangularSumShape(BlockFigure blockFigure) {
		super(blockFigure);
	}
	
	/* (non-Javadoc)
	 * @see org.esmp.dsm.library.basicblocks.figures.AbstractBlockShape#createLayoutManager()
	 */
	public LayoutManager createLayoutManager() {
		return new StandardBlockLayout();
	}
	
	/* (non-Javadoc)
	 * @see org.esmp.dsm.library.basicblocks.figures.AbstractBlockShape#getPortFigureConstraint(org.esmp.dsm.semantic.blockdiagram.Port)
	 */
	public Object getPortFigureConstraint(Port port) {
		if (port instanceof InputPort) {
			return new StandardBlockPortLayoutData(PositionConstants.WEST);
		}
		if (port instanceof OutputPort) {
			return new StandardBlockPortLayoutData(PositionConstants.EAST);
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.draw2d.Figure#getMinimumSize(int, int)
	 */
	public Dimension calculateMinimumCanvasSize(int wHint, int hHint) {
		Dimension size = blockFigure.getPreferredCanvasSize().getCopy();
		if (size.width < size.height) {
			size.width = size.height;
		}
		return size;
	}

	public void paintCanvas(CanvasContext cc) {
		Dimension size = blockFigure.getCanvasSize();
		cc.setLineWidth(DEFAULT_LINE_WIDTH);
		cc.drawRectangle(
				DEFAULT_LINE_WIDTH_HALF,
				DEFAULT_LINE_WIDTH_HALF,
				size.width - DEFAULT_LINE_WIDTH,
				size.height - DEFAULT_LINE_WIDTH);
	}

}
