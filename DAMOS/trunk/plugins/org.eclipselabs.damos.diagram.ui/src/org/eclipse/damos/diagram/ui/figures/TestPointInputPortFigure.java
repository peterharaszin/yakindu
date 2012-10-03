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

package org.eclipse.damos.diagram.ui.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.PointList;

/**
 * @author Andreas Unger
 *
 */
public class TestPointInputPortFigure extends PortFigure {

	public TestPointInputPortFigure() {
	}

	public TestPointInputPortFigure(String text) {
		super(text);
	}

	public TestPointInputPortFigure(IFigure contentFigure) {
		super(contentFigure);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.figures.PortFigure#createTerminalFigure()
	 */
	protected TerminalFigure createTerminalFigure() {
		return new InputTerminalFigure(this);
	}
	
	private static class InputTerminalFigure extends PolygonTerminalFigure {
		
		private static final int SIZE = IFigureConstants.DEFAULT_TERMINAL_SIZE;

		private static final PointList POLYGON = new PointList();

		static {
			POLYGON.addPoint(-SIZE, SIZE);
			POLYGON.addPoint(-SIZE * 2, 0);
			POLYGON.addPoint(-SIZE, -SIZE);
		}

		/**
		 * @param owner
		 */
		public InputTerminalFigure(PortFigure owner) {
			super(owner);
			setForegroundColor(ColorConstants.blue);
		}

		/* (non-Javadoc)
		 * @see org.eclipse.damos.diagram.figures.TerminalFigure#getPolyline()
		 */
		protected PointList getPointList() {
			return POLYGON;
		}
		
	}

}
