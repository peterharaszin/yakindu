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

package org.esmp.dsm.library.basic.ui.figures.shapes;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LayoutManager;
import org.eclipse.draw2d.geometry.Dimension;
import org.esmp.dsm.diagram.ui.figures.CanvasContext;
import org.esmp.dsm.semantic.blockdiagram.Port;

/**
 * @author Andreas Unger
 *
 */
public interface BlockShape {
	
	Object getHelper(Class<?> clazz);

	LayoutManager createLayoutManager();

	IFigure getContentFigure();
	Object getContentFigureConstraint();
	Object getPortFigureConstraint(Port port);
	
	Dimension calculateMinimumCanvasSize(int wHint, int hHint);
	
	void paintCanvas(CanvasContext cc);
	
}
