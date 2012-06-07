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

package org.eclipselabs.damos.library.base.ui.editparts.logic;

import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipselabs.damos.diagram.ui.editparts.BlockInputPortEditPart;
import org.eclipselabs.damos.diagram.ui.figures.PortFigure;
import org.eclipselabs.damos.library.base.ui.figures.logic.DebounceInputPortContentFigure;

/**
 * @author Andreas Unger
 *
 */
public class DebounceInputPortEditPart extends BlockInputPortEditPart {

	/**
	 * @param view
	 */
	public DebounceInputPortEditPart(View view) {
		super(view);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.diagram.ui.editparts.InputPortEditPart#createNodeFigure()
	 */
	@Override
	protected NodeFigure createNodeFigure() {
		PortFigure figure = (PortFigure) super.createNodeFigure();
		figure.setContentFigure(new DebounceInputPortContentFigure());
		return figure;
	}

}
