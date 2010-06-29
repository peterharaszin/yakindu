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

import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.esmp.dsm.diagram.ui.figures.InputPortFigure;

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

}
