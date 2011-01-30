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

package org.eclipselabs.damos.library.base.ui.sources.editparts;

import org.eclipse.gmf.runtime.draw2d.ui.figures.LabelEx;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipselabs.damos.diagram.ui.editparts.EditableContentBlockEditPart;
import org.eclipselabs.damos.diagram.ui.figures.RectangularComponentFigure;
import org.eclipselabs.damos.diagram.ui.figures.StandardComponentFigure;
import org.eclipselabs.damos.dml.Argument;
import org.eclipselabs.damos.dml.ParameterizedElement;
import org.eclipselabs.damos.library.base.sources.util.ConstantConstants;

/**
 * @author Andreas Unger
 *
 */
public class ConstantEditPart extends EditableContentBlockEditPart {

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
		figure.add(new LabelEx());
		return figure;
	}
	
	protected Argument getArgument() {
		return ((ParameterizedElement) resolveSemanticElement()).getArgument(ConstantConstants.PARAMETER__VALUE);
	}
	
}
