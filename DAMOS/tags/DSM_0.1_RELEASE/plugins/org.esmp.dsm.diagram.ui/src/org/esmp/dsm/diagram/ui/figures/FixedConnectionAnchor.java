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

import org.eclipse.draw2d.AncestorListener;
import org.eclipse.draw2d.AnchorListener;
import org.eclipse.draw2d.ConnectionAnchorBase;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionPoint;

public class FixedConnectionAnchor extends ConnectionAnchorBase implements AncestorListener {

	private PortFigure portFigure;
	
	public FixedConnectionAnchor(PortFigure portFigure) {
		this.portFigure = portFigure;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.draw2d.AbstractConnectionAnchor#getOwner()
	 */
	public IFigure getOwner() {
		IFigure owner = portFigure.getTerminalBorderFigure();
		if (owner != null) {
			return owner;
		}
		return portFigure.getParent();
	}
	
	public Point getLocation(Point reference) {
		Point terminalLocation = portFigure.getTerminalLocation();
		if (terminalLocation == null) {
			return new Point(); // TODO
		}
		
		Point p = new PrecisionPoint(terminalLocation);
		portFigure.translateToAbsolute(p);
		return p;
	}

	public Point getReferencePoint() {
		return getLocation(null);
	}

	public void addAnchorListener(AnchorListener listener) {
		if (listener == null) {
			return;
		}
		if (listeners.size() == 0) {
			portFigure.addAncestorListener(this);
		}
		super.addAnchorListener(listener);
	}
	
	public void removeAnchorListener(AnchorListener listener) {
		super.removeAnchorListener(listener);
		if (listeners.size() == 0) {
			getOwner().removeAncestorListener(this);
		}
	}
	
	public void ancestorMoved(IFigure figure) {
		fireAnchorMoved();
	}
	
	public void ancestorAdded(IFigure ancestor) {
	}
	
	public void ancestorRemoved(IFigure ancestor) {
	}
	
}