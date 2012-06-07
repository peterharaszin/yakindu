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

import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Path;
import org.eclipse.swt.widgets.Display;
import org.eclipselabs.damos.diagram.ui.figures.AbstractPortLayoutHelper;
import org.eclipselabs.damos.diagram.ui.figures.ComponentFigure;
import org.eclipselabs.damos.diagram.ui.figures.ICanvasContext;
import org.eclipselabs.damos.diagram.ui.figures.IPortLayoutHelper;

/**
 * @author Andreas Unger
 *
 */
public class DistinctiveOrShape extends LogicGateShape {

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
			return new PortLayoutHelper(blockFigure);
		}
		return null;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure#paintFigure(org.eclipse.draw2d.Graphics)
	 */
	public void paintCanvas(ICanvasContext cc) {
		Dimension size = blockFigure.getCanvasSize();
		Path path = createPath(size);
		try {
			cc.setLineWidth(DEFAULT_LINE_WIDTH);
			cc.fillPath(path);
			cc.drawPath(path);
		} finally {
			path.dispose();
		}
	}
	
	private static Path createPath(Dimension size) {
		float x = DEFAULT_LINE_WIDTH;
		float y = DEFAULT_LINE_WIDTH_HALF;
		float right = size.width - DEFAULT_LINE_WIDTH_HALF;
		float bottom = size.height - DEFAULT_LINE_WIDTH_HALF;

		float quarterHeight = size.height / 4f;
		float halfWidth = size.width / 2f;
		float halfHeight = size.height / 2f;
		float thirdHeight = size.height / 3f;

		Path path = new Path(Display.getDefault());
		try {
			path.moveTo(x, y);
			path.cubicTo(halfWidth, y, right - thirdHeight, y, right, halfHeight);
			path.cubicTo(right - thirdHeight, bottom, halfWidth, bottom, x, bottom);
			path.cubicTo(quarterHeight, bottom - quarterHeight, quarterHeight, y + quarterHeight, x, y);
			path.close();
		} catch (Exception e) {
			path.dispose();
			throw new RuntimeException(e);
		}
		return path;
	}

	/**
	 * @author Andreas Unger
	 *
	 */
	private static final class PortLayoutHelper extends AbstractPortLayoutHelper {
		
		/**
		 * @param componentFigure
		 */
		private PortLayoutHelper(ComponentFigure componentFigure) {
			super(componentFigure);
		}
	
		protected int calculateTerminalDisplacement(int xHint, int yHint, int sideHint) {
			if (sideHint == PositionConstants.WEST) {
				Dimension size = getComponentFigure().getCanvasSize();
				Path path = createPath(size);
				GC gc = new GC(Display.getDefault());
				try {
					int left = 0;
					int right = size.width / 2;
					int prev = Integer.MAX_VALUE;
					int x;
					int d;
					
					do {
						x = (left + right) / 2;
						if (path.contains(x, yHint, gc, false)) {
							right = x;
						} else {
							left = x;
						}
						d = Math.abs(prev - x);
						prev = x;
					} while (d > 0);
					
					return x;
				} finally {
					path.dispose();
					gc.dispose();
				}
			}
			return 0;
		}
		
	}

}
