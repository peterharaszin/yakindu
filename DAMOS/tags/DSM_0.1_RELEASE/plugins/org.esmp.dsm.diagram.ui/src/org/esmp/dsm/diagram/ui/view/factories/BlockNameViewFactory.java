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

package org.esmp.dsm.diagram.ui.view.factories;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @author Andreas Unger
 *
 */
public class BlockNameViewFactory extends BlockParameterViewFactory {

	/* (non-Javadoc)
	 * @see org.esmp.dsm.diagram.view.factories.BlockParameterViewFactory#decorateView(org.eclipse.gmf.runtime.notation.View, org.eclipse.gmf.runtime.notation.View, org.eclipse.core.runtime.IAdaptable, java.lang.String, int, boolean)
	 */
	protected void decorateView(View containerView, View view, IAdaptable element, String semanticHint, int index, boolean persisted) {
		super.decorateView(containerView, view, element, semanticHint, index, persisted);
		view.setVisible(false);
	}
	
}
