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

package org.eclipselabs.damos.library.base.ui.editparts.math;

import org.eclipse.gmf.runtime.notation.View;
import org.eclipselabs.damos.library.base.util.math.RoundConstants;
import org.eclipselabs.damos.library.common.ui.editparts.ArgumentValueBlockEditPart;

/**
 * @author Andreas Unger
 *
 */
public class RoundEditPart extends ArgumentValueBlockEditPart {

	/**
	 * @param view
	 */
	public RoundEditPart(View view) {
		super(view);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.library.common.ui.editparts.ArgumentValueBlockEditPart#getParameterName()
	 */
	@Override
	protected String getParameterName() {
		return RoundConstants.PARAMETER__KIND;
	}

}
