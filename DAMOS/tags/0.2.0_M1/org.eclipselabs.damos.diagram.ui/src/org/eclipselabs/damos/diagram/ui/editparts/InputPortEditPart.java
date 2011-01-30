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

package org.eclipselabs.damos.diagram.ui.editparts;

import java.util.Collections;
import java.util.List;

import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipselabs.damos.diagram.ui.figures.InputPortFigure;
import org.eclipselabs.damos.dml.Connection;
import org.eclipselabs.damos.dml.InputPort;

/**
 * @author Andreas Unger
 *
 */
public class InputPortEditPart extends PortEditPart {

	/**
	 * @param view
	 */
	public InputPortEditPart(View view) {
		super(view);
	}

	protected NodeFigure createNodeFigure() {
		return new InputPortFigure();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.diagram.ui.editparts.PortEditPart#getConnections()
	 */
	@Override
	protected List<Connection> getConnections() {
		InputPort port = (InputPort) resolveSemanticElement();
		if (port != null) {
			return port.getIncomingConnections();
		}
		return Collections.emptyList();
	}

}
