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

package org.eclipselabs.damos.library.base.ui.logic.figures.shapes;

import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipselabs.damos.diagram.ui.figures.AbstractPortLayoutHelper;
import org.eclipselabs.damos.diagram.ui.figures.ComponentFigure;
import org.eclipselabs.damos.diagram.ui.figures.ICanvasContext;
import org.eclipselabs.damos.diagram.ui.figures.IPortLayoutHelper;

/**
 * @author Andreas Unger
 *
 */
public class DistinctiveOrShape extends LogicGateShape {

	private static final double FACTOR = Math.sqrt(2) - 1;

	/**
	 * @param blockFigure
	 */
	public DistinctiveOrShape(ComponentFigure blockFigure) {
		super(blockFigure);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.core.runtime.IAdaptable#getAdapter(java.lang.Class)
	 */
	public Object getHelper(Class<?> clazz) {
		if (clazz == IPortLayoutHelper.class) {
			return new AbstractPortLayoutHelper(blockFigure) {
				protected int calculateTerminalDisplacement(int xHint, int yHint, int sideHint) {
					if (sideHint == PositionConstants.WEST) {
						Dimension size = componentFigure.getCanvasSize();
						return (int) Math.round(size.width * Math.cos(Math.asin(1 - 2.0 * yHint / size.height)) / 5);
					}
					return 0;
				}
			};
		}
		return null;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure#paintFigure(org.eclipse.draw2d.Graphics)
	 */
	public void paintCanvas(ICanvasContext cc) {
		Dimension size = blockFigure.getCanvasSize();
		
		int h = size.height / 2 - DEFAULT_LINE_WIDTH_HALF;
		int x = (int) Math.round(h / FACTOR);
		int r = x + h;
		
		cc.setLineWidth(DEFAULT_LINE_WIDTH);
		cc.drawLine(
				DEFAULT_LINE_WIDTH_HALF,
				DEFAULT_LINE_WIDTH_HALF,
				size.width - x,
				DEFAULT_LINE_WIDTH_HALF);
		cc.drawLine(
				DEFAULT_LINE_WIDTH_HALF,
				size.height - DEFAULT_LINE_WIDTH_HALF,
				size.width - x,
				size.height - DEFAULT_LINE_WIDTH_HALF);
					
		cc.drawArc(
				size.width - x - r - DEFAULT_LINE_WIDTH_HALF,
				h + x - r + DEFAULT_LINE_WIDTH_HALF,
				2 * r,
				2 * r,
				45, 45);
		cc.drawArc(
				size.width - x - r - DEFAULT_LINE_WIDTH_HALF,
				h - x - r + DEFAULT_LINE_WIDTH_HALF,
				2 * r,
				2 * r,
				270, 45);
		
		r = size.width / 5;
		cc.drawArc(-r, DEFAULT_LINE_WIDTH_HALF, 2 * r, size.height - DEFAULT_LINE_WIDTH, 270, 180);
	}

}
