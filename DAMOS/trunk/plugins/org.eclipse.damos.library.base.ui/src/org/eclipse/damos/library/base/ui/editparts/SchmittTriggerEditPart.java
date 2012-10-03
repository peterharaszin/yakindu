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

package org.eclipse.damos.library.base.ui.editparts;

import org.eclipse.damos.diagram.ui.editparts.StandardBlockEditPart;
import org.eclipse.damos.library.base.ui.figures.SchmittTriggerFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @author Andreas Unger
 *
 */
public class SchmittTriggerEditPart extends StandardBlockEditPart {

	/**
	 * @param view
	 */
	public SchmittTriggerEditPart(View view) {
		super(view);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.ui.editparts.StandardBlockEditPart#createMainFigure()
	 */
	protected NodeFigure createMainFigure() {
		return new SchmittTriggerFigure();
	}
	
}
