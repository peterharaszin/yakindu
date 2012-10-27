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

package org.eclipse.damos.library.base.ui.editparts;

import org.eclipse.damos.diagram.ui.editparts.RectangularBlockEditPart;
import org.eclipse.damos.diagram.ui.figures.StandardComponentLayout;
import org.eclipse.damos.library.base.ui.figures.IntegratorContentFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.SWT;

/**
 * @author Andreas Unger
 *
 */
public class IntegratorEditPart extends RectangularBlockEditPart {

	/**
	 * @param view
	 */
	public IntegratorEditPart(View view) {
		super(view);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.ui.editparts.RectangularComponentEditPart#createMainFigure()
	 */
	@Override
	protected NodeFigure createMainFigure() {
		NodeFigure figure = super.createMainFigure();
		StandardComponentLayout layout = (StandardComponentLayout) figure.getLayoutManager();
		layout.setHorizontalContentAlignment(SWT.FILL);
		layout.setVerticalContentAlignment(SWT.FILL);
		figure.add(new IntegratorContentFigure());
		return figure;
	}
		
}
