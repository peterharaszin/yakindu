/****************************************************************************
 * Copyright (c) 2008, 2011 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.diagram.ui.internal.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipselabs.damos.diagram.ui.figures.IFigureConstants;

/**
 * @author Andreas Unger
 *
 */
public class CompoundConnectorFigure extends DefaultSizeNodeFigure {

	public  static final Dimension DEFAULT_SIZE = new Dimension(400, 400);
	
	/**
	 * 
	 */
	public CompoundConnectorFigure() {
		super(DEFAULT_SIZE);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure#paintFigure(org.eclipse.draw2d.Graphics)
	 */
	@Override
	protected void paintFigure(Graphics graphics) {
		Rectangle bounds = getBounds().getCopy();
		bounds.shrink(IFigureConstants.DEFAULT_LINE_WIDTH_HALF, IFigureConstants.DEFAULT_LINE_WIDTH_HALF);
		graphics.setLineWidth(IFigureConstants.DEFAULT_LINE_WIDTH);
		graphics.setBackgroundColor(getBackgroundColor());
		graphics.fillRectangle(bounds);
		graphics.setBackgroundColor(getForegroundColor());
		graphics.drawRectangle(bounds);
	}
	
}
