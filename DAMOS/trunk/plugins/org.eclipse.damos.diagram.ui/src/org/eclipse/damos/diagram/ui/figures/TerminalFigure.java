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

import org.eclipse.damos.diagram.ui.internal.figures.IConnectorFigure;
import org.eclipse.damos.diagram.ui.internal.geometry.Extents;
import org.eclipse.draw2d.AncestorListener;
import org.eclipse.draw2d.Cursors;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderedNodeFigure;
import org.eclipse.swt.graphics.Cursor;

/**
 * @author Andreas Unger
 *
 */
public abstract class TerminalFigure extends Figure {

	private IConnectorFigure owner;
	private boolean connected;
	
	private AncestorListener ancestorListener = new AncestorListener() {
		
		public void ancestorMoved(IFigure ancestor) {
			revalidate();
		}
		
		public void ancestorAdded(IFigure ancestor) {
			IFigure parent = getParent();
			if (parent != null) {
				parent.add(TerminalFigure.this);
			}
		}

		public void ancestorRemoved(IFigure ancestor) {
			IFigure parent = TerminalFigure.this.getParent();
			if (parent != null) {
				parent.remove(TerminalFigure.this);
			}
		}

		private IFigure getParent() {
			IFigure figure = owner.getParent();
			while (figure != null) {
				if (figure instanceof BorderedNodeFigure) {
					return ((BorderedNodeFigure) figure).getBorderItemContainer();
				}
				figure = figure.getParent();
			}
			return null;
		}

	};
	
	/**
	 * 
	 */
	public TerminalFigure(IConnectorFigure owner) {
		this.owner = owner;
		owner.addAncestorListener(ancestorListener);
		setForegroundColor(IFigureConstants.DEFAULT_TERMINAL_COLOR);
	}
	
	/**
	 * @return the owner
	 */
	public IConnectorFigure getOwner() {
		return owner;
	}
	
	/**
	 * @return the connected
	 */
	public boolean isConnected() {
		return connected;
	}
	
	/**
	 * @param connected the connected to set
	 */
	public void setConnected(boolean connected) {
		this.connected = connected;
		repaint();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.draw2d.Figure#getCursor()
	 */
	@Override
	public Cursor getCursor() {
		return Cursors.CROSS;
	}
	
	public abstract Extents getExtents(double rotationHint);
	
}
