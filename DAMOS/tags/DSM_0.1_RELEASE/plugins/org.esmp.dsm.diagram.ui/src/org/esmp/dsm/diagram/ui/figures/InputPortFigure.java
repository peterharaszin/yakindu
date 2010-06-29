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

package org.esmp.dsm.diagram.ui.figures;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.PointList;

/**
 * @author Andreas Unger
 *
 */
public class InputPortFigure extends PortFigure {

	public InputPortFigure() {
	}

	public InputPortFigure(String text) {
		super(text);
	}

	public InputPortFigure(IFigure contentFigure) {
		super(contentFigure);
	}

	/* (non-Javadoc)
	 * @see org.esmp.dsm.diagram.figures.PortFigure#createTerminalFigure()
	 */
	protected TerminalFigure createTerminalFigure() {
		return new InputTerminalFigure(this);
	}
	
	private static class InputTerminalFigure extends TerminalFigure {
		
		/**
		 * @param owner
		 */
		public InputTerminalFigure(PortFigure owner) {
			super(owner);
		}

		private static final PointList POLYLINE = new PointList();

		static {
			POLYLINE.addPoint(SIZE, -SIZE);
			POLYLINE.addPoint(0, 0);
			POLYLINE.addPoint(SIZE, SIZE);
		}

		/* (non-Javadoc)
		 * @see org.esmp.dsm.diagram.figures.TerminalFigure#getPolyline()
		 */
		protected PointList getPolyline() {
			return POLYLINE;
		}
		
	}

}
