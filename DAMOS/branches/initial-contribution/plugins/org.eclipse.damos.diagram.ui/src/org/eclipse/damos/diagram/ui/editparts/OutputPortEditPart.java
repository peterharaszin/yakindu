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

package org.eclipse.damos.diagram.ui.editparts;

import org.eclipse.damos.diagram.ui.figures.OutputPortFigure;
import org.eclipse.damos.diagram.ui.figures.SocketOutputPortFigure;
import org.eclipse.damos.diagram.ui.figures.TestPointOutputPortFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @author Andreas Unger
 *
 */
public class OutputPortEditPart extends PortEditPart {

	/**
	 * @param view
	 */
	public OutputPortEditPart(View view) {
		super(view);
	}

	protected NodeFigure createNodeFigure() {
		if (isTestPoint()) {
			return new TestPointOutputPortFigure();
		}
		if (isSocket()) {
			return new SocketOutputPortFigure();
		}
		return new OutputPortFigure();
	}

}
