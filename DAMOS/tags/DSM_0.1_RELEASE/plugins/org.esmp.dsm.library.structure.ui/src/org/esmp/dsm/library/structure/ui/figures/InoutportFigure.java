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

package org.esmp.dsm.library.structure.ui.figures;

import org.eclipse.draw2d.geometry.Dimension;
import org.esmp.dsm.diagram.ui.figures.CanvasContext;
import org.esmp.dsm.diagram.ui.figures.FigureConstants;
import org.esmp.dsm.diagram.ui.figures.StandardBlockFigure;

/**
 * @author Andreas Unger
 *
 */
public class InoutportFigure extends StandardBlockFigure implements FigureConstants {

	public Dimension calculateMinimumCanvasSize(int wHint, int hHint) {
		if (minSize == null) {
			minSize = getPreferredCanvasSize().getCopy();
			if (minSize.width < minSize.height * 3 / 2) {
				minSize.width = minSize.height * 3 / 2;
			}
		}
		return minSize;
	}

	protected void paintCanvas(CanvasContext cc) {
		Dimension size = getCanvasSize();
		cc.setLineWidth(DEFAULT_LINE_WIDTH);
		cc.drawRoundRectangle(
				DEFAULT_LINE_WIDTH_HALF,
				DEFAULT_LINE_WIDTH_HALF,
				size.width - DEFAULT_LINE_WIDTH,
				size.height - DEFAULT_LINE_WIDTH,
				size.height - DEFAULT_LINE_WIDTH,
				size.height - DEFAULT_LINE_WIDTH);
	}
	
}
