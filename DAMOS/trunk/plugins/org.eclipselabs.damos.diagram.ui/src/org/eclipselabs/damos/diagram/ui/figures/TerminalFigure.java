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

import org.eclipse.draw2d.AncestorListener;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipselabs.damos.diagram.ui.internal.figures.IConnectorFigure;
import org.eclipselabs.damos.diagram.ui.internal.geometry.Extents;

/**
 * @author Andreas Unger
 *
 */
public abstract class TerminalFigure extends NodeFigure {

	private IConnectorFigure owner;
	private boolean blank;
	
	private AncestorListener ancestorListener = new AncestorListener() {
		
		public void ancestorMoved(IFigure ancestor) {
			invalidate();
		}
		
		public void ancestorAdded(IFigure ancestor) {
		}

		public void ancestorRemoved(IFigure ancestor) {
		}

	};
	
	/**
	 * 
	 */
	public TerminalFigure(IConnectorFigure owner) {
		this.owner = owner;
		setForegroundColor(IFigureConstants.DEFAULT_TERMINAL_COLOR);
	}
	
	/**
	 * @return the owner
	 */
	public IConnectorFigure getOwner() {
		return owner;
	}
	
	/**
	 * @return the blank
	 */
	public boolean isBlank() {
		return blank;
	}
	
	/**
	 * @param blank the blank to set
	 */
	public void setBlank(boolean blank) {
		this.blank = blank;
		repaint();
	}
	
	public abstract Extents getExtents(double rotationHint);
	
	/* (non-Javadoc)
	 * @see org.eclipse.draw2d.Figure#paint(org.eclipse.draw2d.Graphics)
	 */
	@Override
	public void paint(Graphics graphics) {
		if (!isBlank()) {
			super.paint(graphics);
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.draw2d.Figure#addNotify()
	 */
	public void addNotify() {
		super.addNotify();
		owner.addAncestorListener(ancestorListener);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.draw2d.Figure#removeNotify()
	 */
	public void removeNotify() {
		owner.removeAncestorListener(ancestorListener);
		super.removeNotify();
	}
	
}
