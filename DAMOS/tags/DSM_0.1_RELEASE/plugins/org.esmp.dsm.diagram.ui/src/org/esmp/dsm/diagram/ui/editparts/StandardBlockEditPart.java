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

package org.esmp.dsm.diagram.ui.editparts;

import org.eclipse.draw2d.PositionConstants;
import org.eclipse.gmf.runtime.notation.View;
import org.esmp.dsm.diagram.ui.figures.StandardBlockPortLayoutData;
import org.esmp.dsm.semantic.blockdiagram.InputPort;
import org.esmp.dsm.semantic.blockdiagram.OutputPort;
import org.esmp.dsm.semantic.blockdiagram.Port;

/**
 * @author Andreas Unger
 *
 */
public abstract class StandardBlockEditPart extends BlockEditPart {

	/**
	 * @param view
	 */
	public StandardBlockEditPart(View view) {
		super(view);
	}

	protected Object getPortFigureConstraint(Port port) {
		if (port instanceof InputPort) {
			return new StandardBlockPortLayoutData(PositionConstants.WEST);
		}
		if (port instanceof OutputPort) {
			return new StandardBlockPortLayoutData(PositionConstants.EAST);
		}
		return null;
	}

}
