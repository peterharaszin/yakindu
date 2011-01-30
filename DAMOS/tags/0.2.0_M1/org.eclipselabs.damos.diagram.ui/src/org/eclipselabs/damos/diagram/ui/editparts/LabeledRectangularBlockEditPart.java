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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipselabs.damos.diagram.ui.internal.editparts.BlockEditPartDelegate;
import org.eclipselabs.damos.diagram.ui.internal.editparts.ComponentEditPartDelegate;
import org.eclipselabs.damos.dml.Block;

/**
 * @author Andreas Unger
 *
 */
public class LabeledRectangularBlockEditPart extends LabeledRectangularComponentEditPart {

	/**
	 * 
	 */
	public LabeledRectangularBlockEditPart(View view) {
		super(view);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.diagram.ui.editparts.BlockEditPart#createDelegate()
	 */
	@Override
	protected final ComponentEditPartDelegate createDelegate() {
		return new BlockEditPartDelegate(this);
	}
	
	protected String getLabel() {
		String label = "";
		EObject o = ViewUtil.resolveSemanticElement((View) getModel());
		if (o instanceof Block) {
			label = ((Block) o).getType().getName().trim();
		}
		return label.length() == 0 ? super.getLabel() : label;
	}
	
}
