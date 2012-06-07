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

package org.eclipselabs.damos.diagram.ui.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.PointList;

/**
 * @author Andreas Unger
 *
 */
public class TestPointOutputPortFigure extends PortFigure {

	public TestPointOutputPortFigure() {
	}

	public TestPointOutputPortFigure(String text) {
		super(text);
	}

	public TestPointOutputPortFigure(IFigure contentFigure) {
		super(contentFigure);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.diagram.figures.PortFigure#createTerminalFigure()
	 */
	protected TerminalFigure createTerminalFigure() {
		return new OutputTerminalFigure(this);
	}
	
	private static class OutputTerminalFigure extends PolygonTerminalFigure {
		
		private static final int SIZE = IFigureConstants.DEFAULT_TERMINAL_SIZE;

		private static final PointList POLYGON = new PointList();

		static {
			POLYGON.addPoint(-SIZE * 2, -SIZE);
			POLYGON.addPoint(-SIZE, 0);
			POLYGON.addPoint(-SIZE * 2, SIZE);
		}

		/**
		 * @param owner
		 */
		public OutputTerminalFigure(PortFigure owner) {
			super(owner);
			setForegroundColor(ColorConstants.blue);
		}

		/* (non-Javadoc)
		 * @see org.eclipselabs.damos.diagram.figures.TerminalFigure#getPolyline()
		 */
		protected PointList getPointList() {
			return POLYGON;
		}
		
	}

}
