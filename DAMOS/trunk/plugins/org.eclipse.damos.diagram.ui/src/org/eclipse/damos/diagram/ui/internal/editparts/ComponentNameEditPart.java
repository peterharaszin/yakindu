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

package org.eclipse.damos.diagram.ui.internal.editparts;

import org.eclipse.damos.diagram.ui.editparts.ComponentAttributeEditPart;
import org.eclipse.damos.dml.DMLPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.notation.View;

public class ComponentNameEditPart extends ComponentAttributeEditPart {

	public ComponentNameEditPart(View view) {
		super(view);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.ui.editparts.BlockParameterEditPart#getParameterFeature()
	 */
	protected EStructuralFeature getAttributeFeature() {
		return DMLPackage.eINSTANCE.getComponent_Name();
	}
	
}
