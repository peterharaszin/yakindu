/****************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipse.damos.diagram.ui.figures;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.PointList;

/**
 * @author Andreas Unger
 *
 */
public class SocketInputPortFigure extends SocketPortFigure {

	public SocketInputPortFigure() {
	}

	public SocketInputPortFigure(String text) {
		super(text);
	}

	public SocketInputPortFigure(IFigure contentFigure) {
		super(contentFigure);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.figures.PortFigure#createTerminalFigure()
	 */
	protected TerminalFigure createTerminalFigure() {
		return new InputTerminalFigure(this);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.ui.figures.SocketPortFigure#getTerminalDistance()
	 */
	@Override
	protected int getTerminalDistance() {
		return TERMINAL_SPACING;
	}
	
	private static class InputTerminalFigure extends SocketTerminalFigure {
		
		private static final PointList POLYLINE = new PointList();

		static {
			POLYLINE.addPoint(SIZE, -SIZE);
			POLYLINE.addPoint(0, 0);
			POLYLINE.addPoint(SIZE, SIZE);

			POLYLINE.addPoint(-TERMINAL_SPACING + SIZE, -SIZE);
			POLYLINE.addPoint(-TERMINAL_SPACING, 0);
			POLYLINE.addPoint(-TERMINAL_SPACING + SIZE, SIZE);
		}

		/**
		 * @param owner
		 */
		public InputTerminalFigure(PortFigure owner) {
			super(owner);
		}
		
		/* (non-Javadoc)
		 * @see org.eclipse.damos.diagram.ui.figures.PolypointTerminalFigure#getPointList()
		 */
		@Override
		protected PointList getPointList() {
			return POLYLINE;
		}

	}

}
