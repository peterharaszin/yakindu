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

package org.eclipselabs.damos.library.base.ui.figures.shapes.logic;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipselabs.damos.diagram.ui.figures.ComponentFigure;
import org.eclipselabs.damos.diagram.ui.figures.FontColorAwareLabel;
import org.eclipselabs.damos.diagram.ui.figures.ICanvasContext;

/**
 * @author Andreas Unger
 *
 */
public class RectangularLogicGateShape extends LogicGateShape {

	private String name;
	
	/**
	 * @param blockFigure
	 */
	public RectangularLogicGateShape(ComponentFigure blockFigure, String name) {
		super(blockFigure);
		this.name = name;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.library.basicblocks.figures.AbstractBlockShape#createContentFigure()
	 */
	public IFigure createContentFigure() {
		return new FontColorAwareLabel(name);
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
