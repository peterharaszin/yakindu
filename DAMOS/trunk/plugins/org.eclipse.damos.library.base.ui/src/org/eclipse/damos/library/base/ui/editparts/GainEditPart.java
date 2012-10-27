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
import org.eclipse.damos.diagram.ui.figures.StandardComponentFigure;
import org.eclipse.damos.diagram.ui.figures.StandardComponentLayout;
import org.eclipse.damos.dml.Argument;
import org.eclipse.damos.dml.ParameterizedElement;
import org.eclipse.damos.library.base.ui.figures.GainFigure;
import org.eclipse.damos.library.base.util.GainConstants;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.SWT;

/**
 * @author Andreas Unger
 *
 */
public class GainEditPart extends TextualContentBlockEditPart {

	/**
	 * @param view
	 */
	public GainEditPart(View view) {
		super(view);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.ui.editparts.StandardBlockEditPart#createMainFigure()
	 */
	protected NodeFigure createMainFigure() {
		StandardComponentFigure figure = new GainFigure();
		((StandardComponentLayout) figure.getLayoutManager()).setHorizontalContentAlignment(SWT.BEGINNING);
		figure.add(new FontColorAwareLabel());
		return figure;
	}
	
	protected Argument getContentArgument() {
		return ((ParameterizedElement) resolveSemanticElement()).getArgument(GainConstants.PARAMETER__GAIN);
	}
	
}
