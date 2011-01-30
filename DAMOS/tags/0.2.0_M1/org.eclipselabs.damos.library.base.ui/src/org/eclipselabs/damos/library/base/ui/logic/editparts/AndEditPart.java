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

package org.eclipselabs.damos.library.base.ui.logic.editparts;

import org.eclipse.gmf.runtime.notation.View;
import org.eclipselabs.damos.library.base.ui.logic.figures.shapes.DistinctiveAndShape;
import org.eclipselabs.damos.library.common.ui.figures.shapes.BlockShape;

/**
 * @author Andreas Unger
 *
 */
public class AndEditPart extends LogicGateEditPart {

	/**
	 * @param view
	 */
	public AndEditPart(View view) {
		super(view);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.library.basicblocks.editparts.LogicGateEditPart#createDistinctiveShape()
	 */
	protected BlockShape createDistinctiveShape() {
		return new DistinctiveAndShape(getComponentFigure());
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.library.basicblocks.editparts.LogicGateEditPart#createRectangularShape()
	 */
	protected String getRectangularShapeLabel() {
		return "AND";
	}
	
}
