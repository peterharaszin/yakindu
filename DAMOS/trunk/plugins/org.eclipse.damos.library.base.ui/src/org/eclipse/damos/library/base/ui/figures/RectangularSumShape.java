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

package org.eclipse.damos.library.base.ui.figures;

import org.eclipse.damos.diagram.ui.figures.ComponentFigure;
import org.eclipse.damos.diagram.ui.figures.ICanvasContext;
import org.eclipse.damos.diagram.ui.figures.IFigureConstants;
import org.eclipse.damos.diagram.ui.figures.StandardComponentLayout;
import org.eclipse.damos.diagram.ui.figures.StandardComponentLayoutData;
import org.eclipse.damos.dml.InputPort;
import org.eclipse.damos.dml.OutputPort;
import org.eclipse.damos.dml.Port;
import org.eclipse.damos.library.common.ui.figures.shapes.AbstractBlockShape;
import org.eclipse.draw2d.LayoutManager;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;

/**
 * @author Andreas Unger
 *
 */
public class RectangularSumShape extends AbstractBlockShape implements IFigureConstants {
	
	/**
	 * @param blockFigure
	 */
	public RectangularSumShape(ComponentFigure blockFigure) {
		super(blockFigure);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.library.basicblocks.figures.AbstractBlockShape#createLayoutManager()
	 */
	public LayoutManager createLayoutManager() {
		return new StandardComponentLayout();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.library.basicblocks.figures.AbstractBlockShape#getPortFigureConstraint(org.eclipse.damos.semantic.blockdiagram.Port)
	 */
	public Object getPortFigureConstraint(Port port) {
		if (port instanceof InputPort) {
			return new StandardComponentLayoutData(PositionConstants.WEST);
		}
		if (port instanceof OutputPort) {
			return new StandardComponentLayoutData(PositionConstants.EAST);
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

	public void paintCanvas(ICanvasContext cc) {
		Dimension size = blockFigure.getCanvasSize();
		
		int x = DEFAULT_LINE_WIDTH_HALF;
		int y = DEFAULT_LINE_WIDTH_HALF;
		int width = size.width - DEFAULT_LINE_WIDTH;
		int height = size.height - DEFAULT_LINE_WIDTH;

		cc.setLineWidth(DEFAULT_LINE_WIDTH);
		cc.fillRectangle(x, y, width, height);
		cc.drawRectangle(x, y, width, height);
	}

}
