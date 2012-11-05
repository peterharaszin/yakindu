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

package org.eclipse.damos.library.base.ui.figures;

import org.eclipse.damos.diagram.ui.figures.ICanvasContext;
import org.eclipse.damos.diagram.ui.figures.IFigureConstants;
import org.eclipse.damos.diagram.ui.figures.RectangularComponentFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.swt.SWT;

/**
 * @author Andreas Unger
 *
 */
public class SwitchFigure extends RectangularComponentFigure implements IFigureConstants {

	public Dimension calculateMinimumCanvasSize(int wHint, int hHint) {
		if (minSize == null) {
			minSize = getPreferredCanvasSize().getCopy();
			if (minSize.width < minSize.height) {
				minSize.width = minSize.height;
			}
		}
		return minSize;
	}

	protected void paintCanvas(ICanvasContext cc) {
		super.paintCanvas(cc);
		
		Dimension size = getCanvasSize();
		
		cc.setForegroundColor(getFontColor());
		cc.setLineWidth(DEFAULT_LINE_WIDTH);

		cc.drawLine(0, size.height / 6, 300, size.height / 6);

		cc.drawLine(0, size.height / 2, 200, size.height / 2);
		cc.drawLine(200, size.height / 2 - 100, 200, size.height / 2 + 100);

		cc.drawLine(0, size.height - size.height / 6, 300, size.height - size.height / 6);

		cc.drawLine(size.width - 200, size.height / 2, size.width, size.height / 2);
		
		cc.drawLine(300, size.height / 6, size.width - 200, size.height / 2);
		
		cc.setLineStyle(SWT.LINE_DOT);
		cc.drawLine(300, size.height - size.height / 6, size.width - 200, size.height / 2);
	}

}
