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

package org.eclipselabs.damos.library.base.ui.editparts.logic;

import org.eclipse.gmf.runtime.notation.View;
import org.eclipselabs.damos.diagram.ui.figures.RectangularComponentFigure;
import org.eclipselabs.damos.library.base.util.logic.CompareConstants;
import org.eclipselabs.damos.library.common.ui.editparts.ArgumentValueBlockEditPart;

/**
 * @author Andreas Unger
 *
 */
public class CompareEditPart extends ArgumentValueBlockEditPart {

	/**
	 * @param view
	 */
	public CompareEditPart(View view) {
		super(view);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.library.common.ui.editparts.ArgumentValueBlockEditPart#getParameterName()
	 */
	@Override
	protected String getParameterName() {
		return CompareConstants.PARAMETER__OPERATOR;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.diagram.ui.editparts.RectangularComponentEditPart#createRectangularFigure()
	 */
	@Override
	protected RectangularComponentFigure createRectangularComponentFigure() {
		return new RectangularComponentFigure() {
			
			/* (non-Javadoc)
			 * @see org.eclipselabs.damos.diagram.ui.figures.RectangularComponentFigure#hasTopLeftMarker()
			 */
			@Override
			protected boolean hasTopLeftMarker() {
				return true;
			}
			
		};
	}

}
