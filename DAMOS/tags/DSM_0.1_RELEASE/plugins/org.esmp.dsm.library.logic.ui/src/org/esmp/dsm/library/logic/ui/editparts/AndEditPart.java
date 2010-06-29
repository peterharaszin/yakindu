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

package org.esmp.dsm.library.logic.ui.editparts;

import org.eclipse.gmf.runtime.notation.View;
import org.esmp.dsm.library.basic.ui.figures.shapes.BlockShape;
import org.esmp.dsm.library.logic.ui.figures.shapes.DistinctiveAndShape;

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
	 * @see org.esmp.dsm.library.basicblocks.editparts.LogicGateEditPart#createDistinctiveShape()
	 */
	protected BlockShape createDistinctiveShape() {
		return new DistinctiveAndShape(getBlockFigure());
	}
	
	/* (non-Javadoc)
	 * @see org.esmp.dsm.library.basicblocks.editparts.LogicGateEditPart#createRectangularShape()
	 */
	protected String getRectangularShapeLabel() {
		return "AND";
	}
	
}
