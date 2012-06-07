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

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipselabs.damos.diagram.ui.figures.TerminalFigure;

/**
 * @author Andreas Unger
 *
 */
public interface IConnectorFigure extends IFigure {
	
	TerminalFigure getTerminalFigure();

	Point getTerminalLocation();
	
	double getRotation();
	
}
