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

package org.eclipse.damos.diagram.ui.editparts;

import org.eclipse.damos.diagram.ui.figures.StandardComponentLayoutData;
import org.eclipse.damos.dml.InputPort;
import org.eclipse.damos.dml.OutputPort;
import org.eclipse.damos.dml.Port;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @author Andreas Unger
 *
 */
public abstract class StandardComponentEditPart extends ComponentEditPart {

	/**
	 * @param view
	 */
	public StandardComponentEditPart(View view) {
		super(view);
	}

	protected Object getPortFigureConstraint(Port port) {
		if (port instanceof InputPort) {
			return new StandardComponentLayoutData(PositionConstants.WEST);
		}
		if (port instanceof OutputPort) {
			return new StandardComponentLayoutData(PositionConstants.EAST);
		}
		return null;
	}

}
