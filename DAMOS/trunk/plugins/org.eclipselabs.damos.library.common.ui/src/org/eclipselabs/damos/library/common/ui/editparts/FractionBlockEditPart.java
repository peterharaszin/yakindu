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

package org.eclipselabs.damos.library.common.ui.editparts;

import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipselabs.damos.diagram.ui.editparts.RectangularBlockEditPart;
import org.eclipselabs.damos.library.common.ui.figures.FractionBlockContentFigure;

/**
 * @author Andreas Unger
 *
 */
public abstract class FractionBlockEditPart extends RectangularBlockEditPart {

	private FractionBlockContentFigure contentFigure;
	
	/**
	 * @param view
	 */
	public FractionBlockEditPart(View view) {
		super(view);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.diagram.ui.editparts.BlockEditPart#refreshVisuals()
	 */
	protected void refreshVisuals() {
		super.refreshVisuals();
		refreshNumerator();
		refreshDenominator();
	}
	
	protected void refreshNumerator() {
		contentFigure.setNumerator(getNumerator());
	}
	
	protected void refreshDenominator() {
		contentFigure.setDenominator(getDenominator());
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.diagram.ui.editparts.RectangularBlockEditPart#createMainFigure()
	 */
	protected NodeFigure createMainFigure() {
		NodeFigure figure = super.createMainFigure();
		contentFigure = new FractionBlockContentFigure();
		figure.add(contentFigure);
		return figure;
	}
	
	protected abstract String getNumerator();
	
	protected abstract String getDenominator();

}
