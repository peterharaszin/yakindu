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

package org.eclipselabs.damos.diagram.ui.editparts;

import org.eclipse.gmf.runtime.notation.View;
import org.eclipselabs.damos.diagram.ui.internal.editparts.BlockEditPartDelegate;
import org.eclipselabs.damos.diagram.ui.internal.editparts.ComponentEditPartDelegate;

public abstract class BlockEditPart extends ComponentEditPart {

	public BlockEditPart(View view) {
		super(view);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.diagram.ui.editparts.BlockEditPart#createDelegate()
	 */
	@Override
	protected final ComponentEditPartDelegate createDelegate() {
		return new BlockEditPartDelegate(this);
	}
	
}
