/****************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipse.damos.library.base.ui.editparts.logic;

import org.eclipse.damos.diagram.ui.editparts.BlockOutputPortEditPart;
import org.eclipse.damos.diagram.ui.figures.PortFigure;
import org.eclipse.damos.library.base.ui.figures.logic.DebounceOutputPortContentFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @author Andreas Unger
 *
 */
public class DebounceOutputPortEditPart extends BlockOutputPortEditPart {

	/**
	 * @param view
	 */
	public DebounceOutputPortEditPart(View view) {
		super(view);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.ui.editparts.OutputPortEditPart#createNodeFigure()
	 */
	@Override
	protected NodeFigure createNodeFigure() {
		PortFigure figure = (PortFigure) super.createNodeFigure();
		figure.setContentFigure(new DebounceOutputPortContentFigure());
		return figure;
	}
	
}
