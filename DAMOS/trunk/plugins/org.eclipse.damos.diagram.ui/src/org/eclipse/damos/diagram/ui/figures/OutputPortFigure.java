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

package org.eclipse.damos.diagram.ui.figures;

import org.eclipse.damos.diagram.ui.internal.figures.OutputTerminalFigure;
import org.eclipse.draw2d.IFigure;

/**
 * @author Andreas Unger
 *
 */
public class OutputPortFigure extends PortFigure {

	public OutputPortFigure() {
	}

	public OutputPortFigure(String text) {
		super(text);
	}

	public OutputPortFigure(IFigure contentFigure) {
		super(contentFigure);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.figures.PortFigure#createTerminalFigure()
	 */
	protected TerminalFigure createTerminalFigure() {
		return new OutputTerminalFigure(this);
	}

}
