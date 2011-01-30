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

package org.eclipselabs.damos.diagram.ui.figures;

import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;

public class ConnectionFigure extends PolylineConnectionEx implements IFigureConstants {
	
	public ConnectionFigure() {
		PolygonDecoration decoration = new PolygonDecoration();
		decoration.setScale(182, 78);
		setTargetDecoration(decoration);
		setLineWidth(DEFAULT_LINE_WIDTH);
	}
	
}
