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

package org.eclipselabs.damos.library.base.ui.logic.figures.shapes;

import org.eclipse.draw2d.LayoutManager;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipselabs.damos.diagram.ui.figures.ComponentFigure;
import org.eclipselabs.damos.diagram.ui.figures.IFigureConstants;
import org.eclipselabs.damos.diagram.ui.figures.StandardComponentLayout;
import org.eclipselabs.damos.diagram.ui.figures.StandardComponentLayoutData;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.dml.OutputPort;
import org.eclipselabs.damos.dml.Port;
import org.eclipselabs.damos.library.common.ui.figures.shapes.AbstractBlockShape;

/**
 * @author Andreas Unger
 *
 */
public class LogicGateShape extends AbstractBlockShape implements IFigureConstants {

	/**
	 * @param blockFigure
	 */
	public LogicGateShape(ComponentFigure blockFigure) {
		super(blockFigure);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.library.basicblocks.figures.AbstractBlockShape#createLayoutManager()
	 */
	public LayoutManager createLayoutManager() {
		return new StandardComponentLayout();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.library.basicblocks.figures.AbstractBlockShape#getPortFigureConstraint(org.eclipselabs.damos.semantic.blockdiagram.Port)
	 */
	public Object getPortFigureConstraint(Port port) {
		if (port instanceof InputPort) {
			return new StandardComponentLayoutData(PositionConstants.WEST);
		}
		if (port instanceof OutputPort) {
			return new StandardComponentLayoutData(PositionConstants.EAST);
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.draw2d.Figure#getMinimumSize(int, int)
	 */
	public Dimension calculateMinimumCanvasSize(int wHint, int hHint) {
		Dimension size = blockFigure.getPreferredCanvasSize().getCopy();
		if (size.width < size.height) {
			size.width = size.height;
		}
		return size;
	}

}
