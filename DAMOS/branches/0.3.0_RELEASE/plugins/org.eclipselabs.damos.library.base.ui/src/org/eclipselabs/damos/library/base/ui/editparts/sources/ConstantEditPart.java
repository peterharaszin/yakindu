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

package org.eclipselabs.damos.library.base.ui.editparts.sources;

import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipselabs.damos.diagram.ui.editparts.TextualContentBlockEditPart;
import org.eclipselabs.damos.diagram.ui.figures.FontColorAwareLabel;
import org.eclipselabs.damos.diagram.ui.figures.RectangularComponentFigure;
import org.eclipselabs.damos.diagram.ui.figures.StandardComponentFigure;
import org.eclipselabs.damos.dml.Argument;
import org.eclipselabs.damos.dml.ParameterizedElement;
import org.eclipselabs.damos.library.base.util.sources.ConstantConstants;

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
	 * @see org.eclipselabs.damos.diagram.ui.editparts.StandardBlockEditPart#createMainFigure()
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
	 * @see org.eclipselabs.damos.diagram.ui.editparts.ITextualContentEditPart#setContentText(java.lang.String)
	 */
	public void setContentText(String text) {
		// TODO Auto-generated method stub
		
	}
	
}
