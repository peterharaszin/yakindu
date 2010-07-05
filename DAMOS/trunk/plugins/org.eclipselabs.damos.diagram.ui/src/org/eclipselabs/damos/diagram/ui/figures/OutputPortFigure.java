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

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.PointList;

/**
 * @author Andreas Unger
 *
 */
public class OutputPortFigure extends PortFigure {

	public OutputPortFigure() {
	}

	public OutputPortFigure(String text) {
		super(text);
	}

	public OutputPortFigure(IFigure contentFigure) {
		super(contentFigure);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.diagram.figures.PortFigure#createTerminalFigure()
	 */
	protected TerminalFigure createTerminalFigure() {
		return new OutputTerminalFigure(this);
	}
	
	private static class OutputTerminalFigure extends PolylineTerminalFigure {
		
		private static final int SIZE = FigureConstants.DEFAULT_TERMINAL_SIZE;

		private static final PointList POLYLINE = new PointList();

		static {
			POLYLINE.addPoint(0, -SIZE);
			POLYLINE.addPoint(SIZE, 0);
			POLYLINE.addPoint(0, SIZE);
		}

		/**
		 * @param owner
		 */
		public OutputTerminalFigure(PortFigure owner) {
			super(owner);
		}

		/* (non-Javadoc)
		 * @see org.eclipselabs.damos.diagram.figures.TerminalFigure#getPolyline()
		 */
		protected PointList getPointList() {
			return POLYLINE;
		}
		
	}

}
