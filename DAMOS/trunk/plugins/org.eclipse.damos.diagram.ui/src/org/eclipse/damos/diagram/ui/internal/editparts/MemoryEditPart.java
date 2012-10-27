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

package org.eclipse.damos.diagram.ui.internal.editparts;

import org.eclipse.damos.diagram.ui.editparts.RectangularBlockEditPart;
import org.eclipse.damos.diagram.ui.figures.StandardComponentLayout;
import org.eclipse.damos.diagram.ui.figures.StandardComponentLayoutData;
import org.eclipse.damos.diagram.ui.internal.figures.MemoryContentFigure;
import org.eclipse.damos.dml.InputPort;
import org.eclipse.damos.dml.MemoryInitialCondition;
import org.eclipse.damos.dml.Port;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.SWT;

/**
 * @author Andreas Unger
 *
 */
public class MemoryEditPart extends RectangularBlockEditPart {

	/**
	 * @param view
	 */
	public MemoryEditPart(View view) {
		super(view);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart#createMainFigure()
	 */
	protected NodeFigure createMainFigure() {
		NodeFigure figure = super.createMainFigure();
		StandardComponentLayout layout = (StandardComponentLayout) figure.getLayoutManager();
		layout.setHorizontalContentAlignment(SWT.FILL);
		layout.setVerticalContentAlignment(SWT.FILL);
		figure.add(new MemoryContentFigure());
		return figure;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.ui.editparts.StandardComponentEditPart#getPortFigureConstraint(org.eclipse.damos.dml.Port)
	 */
	@Override
	protected Object getPortFigureConstraint(Port port) {
		if (port instanceof InputPort) {
			InputPort inputPort = (InputPort) port;
			if (inputPort.getInput() instanceof MemoryInitialCondition) {
				return new StandardComponentLayoutData(PositionConstants.NORTH);
			}
		}
		return super.getPortFigureConstraint(port);
	}

}
