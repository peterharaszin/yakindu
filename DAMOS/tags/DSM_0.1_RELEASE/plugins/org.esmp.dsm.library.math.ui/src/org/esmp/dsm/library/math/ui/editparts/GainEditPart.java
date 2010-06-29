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

package org.esmp.dsm.library.math.ui.editparts;

import org.eclipse.gmf.runtime.draw2d.ui.figures.LabelEx;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.SWT;
import org.esmp.dsm.diagram.ui.editparts.EditableContentBlockEditPart;
import org.esmp.dsm.diagram.ui.figures.StandardBlockFigure;
import org.esmp.dsm.diagram.ui.figures.StandardBlockLayout;
import org.esmp.dsm.library.math.ui.figures.GainFigure;
import org.esmp.dsm.library.math.util.GainConstants;
import org.esmp.dsm.semantic.blockdiagram.Parameter;
import org.esmp.dsm.semantic.blockdiagram.ParameterableElement;

/**
 * @author Andreas Unger
 *
 */
public class GainEditPart extends EditableContentBlockEditPart {

	/**
	 * @param view
	 */
	public GainEditPart(View view) {
		super(view);
	}
	
	/* (non-Javadoc)
	 * @see org.esmp.dsm.diagram.ui.editparts.StandardBlockEditPart#createMainFigure()
	 */
	protected NodeFigure createMainFigure() {
		StandardBlockFigure figure = new GainFigure();
		((StandardBlockLayout) figure.getLayoutManager()).setHorizontalContentAlignment(SWT.BEGINNING);
		figure.add(new LabelEx());
		return figure;
	}
	
	protected Parameter getParameter() {
		return ((ParameterableElement) resolveSemanticElement()).getParameter(GainConstants.PARAMETER__GAIN);
	}
	
}
