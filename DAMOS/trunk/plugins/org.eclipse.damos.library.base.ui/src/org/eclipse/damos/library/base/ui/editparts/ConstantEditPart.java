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

import org.eclipse.damos.diagram.ui.editparts.TextualContentBlockEditPart;
import org.eclipse.damos.diagram.ui.figures.FontColorAwareLabel;
import org.eclipse.damos.diagram.ui.figures.RectangularComponentFigure;
import org.eclipse.damos.diagram.ui.figures.StandardComponentFigure;
import org.eclipse.damos.dml.Argument;
import org.eclipse.damos.dml.ParameterizedElement;
import org.eclipse.damos.library.base.util.ConstantConstants;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @author Andreas Unger
 *
 */
public class ConstantEditPart extends TextualContentBlockEditPart {

	/**
	 * @param view
	 */
	public ConstantEditPart(View view) {
		super(view);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.ui.editparts.StandardBlockEditPart#createMainFigure()
	 */
	protected NodeFigure createMainFigure() {
		StandardComponentFigure figure = new RectangularComponentFigure();
		figure.add(new FontColorAwareLabel());
		return figure;
	}
	
	protected Argument getContentArgument() {
		return ((ParameterizedElement) resolveSemanticElement()).getArgument(ConstantConstants.PARAMETER__VALUE);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.ui.editparts.ITextualContentEditPart#setContentText(java.lang.String)
	 */
	public void setContentText(String text) {
		// TODO Auto-generated method stub
		
	}
	
}
