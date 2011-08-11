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
public class SocketOutputPortFigure extends SocketPortFigure {

	public SocketOutputPortFigure() {
	}

	public SocketOutputPortFigure(String text) {
		super(text);
	}

	public SocketOutputPortFigure(IFigure contentFigure) {
		super(contentFigure);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.diagram.figures.PortFigure#createTerminalFigure()
	 */
	protected TerminalFigure createTerminalFigure() {
		return new OutputTerminalFigure(this);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.diagram.ui.figures.SocketPortFigure#getTerminalDistance()
	 */
	@Override
	protected int getTerminalDistance() {
		return TERMINAL_SPACING + SocketTerminalFigure.SIZE;
	}
	
	private static class OutputTerminalFigure extends SocketTerminalFigure {
		
		private static final PointList POLYLINE = new PointList();

		static {
			POLYLINE.addPoint(-SIZE, -SIZE);
			POLYLINE.addPoint(0, 0);
			POLYLINE.addPoint(-SIZE, SIZE);

			POLYLINE.addPoint(-TERMINAL_SPACING - SIZE, -SIZE);
			POLYLINE.addPoint(-TERMINAL_SPACING, 0);
			POLYLINE.addPoint(-TERMINAL_SPACING - SIZE, SIZE);
		}

		/**
		 * @param owner
		 */
		public OutputTerminalFigure(PortFigure owner) {
			super(owner);
		}

		/* (non-Javadoc)
		 * @see org.eclipselabs.damos.diagram.ui.figures.PolypointTerminalFigure#getPointList()
		 */
		@Override
		protected PointList getPointList() {
			return POLYLINE;
		}

	}

}
