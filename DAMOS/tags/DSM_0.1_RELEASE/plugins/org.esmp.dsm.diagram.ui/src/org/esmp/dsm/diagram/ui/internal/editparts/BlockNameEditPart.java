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

package org.esmp.dsm.diagram.ui.internal.editparts;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.notation.View;
import org.esmp.dsm.diagram.ui.editparts.BlockParameterEditPart;
import org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage;

public class BlockNameEditPart extends BlockParameterEditPart {

	public BlockNameEditPart(View view) {
		super(view);
	}
	
	/* (non-Javadoc)
	 * @see org.esmp.dsm.diagram.ui.editparts.BlockParameterEditPart#getParameterFeature()
	 */
	protected EStructuralFeature getParameterFeature() {
		return BlockDiagramPackage.eINSTANCE.getNamedElement_Name();
	}
	
}
