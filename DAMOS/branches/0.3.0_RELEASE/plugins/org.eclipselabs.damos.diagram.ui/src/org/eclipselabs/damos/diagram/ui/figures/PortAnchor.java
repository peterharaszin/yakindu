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

public class PortAnchor extends ConnectorAnchor {

	public PortAnchor(PortFigure portFigure) {
		super(portFigure);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.draw2d.AbstractConnectionAnchor#getOwner()
	 */
	public IFigure getOwner() {
		PortFigure portFigure = (PortFigure) getConnectorFigure();
		IFigure owner = portFigure.getTerminalBorderFigure();
		if (owner != null) {
			return owner;
		}
		return portFigure.getParent();
	}
	
}
