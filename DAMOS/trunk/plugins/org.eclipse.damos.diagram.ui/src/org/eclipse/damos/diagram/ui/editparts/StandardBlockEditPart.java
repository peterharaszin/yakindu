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

import org.eclipse.damos.diagram.ui.internal.editparts.BlockEditPartDelegate;
import org.eclipse.damos.diagram.ui.internal.editparts.ComponentEditPartDelegate;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @author Andreas Unger
 *
 */
public abstract class StandardBlockEditPart extends StandardComponentEditPart {

	/**
	 * @param view
	 */
	public StandardBlockEditPart(View view) {
		super(view);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.ui.editparts.BlockEditPart#createDelegate()
	 */
	@Override
	protected final ComponentEditPartDelegate createDelegate() {
		return new BlockEditPartDelegate(this);
	}

}
