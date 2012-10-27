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

package org.eclipse.damos.library.base.ui.editparts;

import org.eclipse.damos.diagram.ui.editparts.StandardBlockEditPart;
import org.eclipse.damos.library.base.ui.figures.EdgeCounterFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @author Andreas Unger
 *
 */
public class EdgeCounterEditPart extends StandardBlockEditPart {

	/**
	 * @param view
	 */
	public EdgeCounterEditPart(View view) {
		super(view);
	}

	protected NodeFigure createMainFigure() {
		return new EdgeCounterFigure();
	}

}
