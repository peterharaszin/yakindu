/****************************************************************************
 * Copyright (c) 2008, 2010 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.diagram.ui.internal.editpolicies;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ConnectionHandleEditPolicy;
import org.eclipselabs.damos.diagram.ui.figures.PortFigure;
import org.eclipselabs.damos.diagram.ui.figures.TerminalFigure;

/**
 * @author Andreas Unger
 *
 */
public class PortConnectionHandleEditPolicy extends ConnectionHandleEditPolicy {

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.ConnectionHandleEditPolicy#activate()
	 */
	@Override
	public void activate() {
		super.activate();
		if (getHostFigure() instanceof PortFigure) {
			TerminalFigure terminalFigure = ((PortFigure) getHostFigure()).getTerminalFigure();
			if (terminalFigure != null) {
				terminalFigure.addMouseMotionListener(this);
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.ConnectionHandleEditPolicy#deactivate()
	 */
	@Override
	public void deactivate() {
		if (getHostFigure() instanceof PortFigure) {
			TerminalFigure terminalFigure = ((PortFigure) getHostFigure()).getTerminalFigure();
			if (terminalFigure != null) {
				terminalFigure.removeMouseMotionListener(this);
			}
		}
		super.deactivate();
	}
	
}
