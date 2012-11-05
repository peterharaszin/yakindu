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

package org.eclipse.damos.diagram.ui.internal.figures;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderedNodeFigure;

/**
 * @author Andreas Unger
 *
 */
public class BlankableBorderedNodeFigure extends BorderedNodeFigure implements IBlankableFigure {

	private boolean blanked;

	/**
	 * @param mainFigure
	 */
	public BlankableBorderedNodeFigure(IFigure mainFigure) {
		super(mainFigure);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.draw2d.Figure#isVisible()
	 */
	@Override
	public boolean isVisible() {
		return !isBlanked() && super.isVisible();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.ui.internal.figures.IBlankableFigure#isBlank()
	 */
	public boolean isBlanked() {
		return blanked;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.ui.internal.figures.IBlankableFigure#setBlank(boolean)
	 */
	public void setBlanked(boolean blanked) {
		this.blanked = blanked;
		revalidate();
		repaint();
	}

}
