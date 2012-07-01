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

package org.eclipselabs.damos.diagram.ui.internal.figures;

import org.eclipse.draw2d.PolylineDecoration;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.swt.SWT;
import org.eclipselabs.damos.diagram.ui.figures.IFigureConstants;

public class ActionLinkFigure extends PolylineConnectionEx implements IFigureConstants {
	
	private static final double DECORATION_SCALE_X = 10 * DEFAULT_LINE_WIDTH;
	private static final double DECORATION_SCALE_Y = 5 * DEFAULT_LINE_WIDTH;

	public ActionLinkFigure() {
		PolylineDecoration decoration = new PolylineDecoration() {
			
			@Override
			public Rectangle getBounds() {
				return super.getBounds().getExpanded(DEFAULT_LINE_WIDTH, DEFAULT_LINE_WIDTH);
			}
			
		};
		decoration.setLineWidth(DEFAULT_LINE_WIDTH);
		decoration.setScale(DECORATION_SCALE_X, DECORATION_SCALE_Y);
		setTargetDecoration(decoration);
		setLineWidth(DEFAULT_LINE_WIDTH);
		setLineStyle(SWT.LINE_DASH);
	}
	
}
