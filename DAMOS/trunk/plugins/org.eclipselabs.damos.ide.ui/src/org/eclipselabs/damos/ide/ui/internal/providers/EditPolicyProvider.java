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

package org.eclipselabs.damos.ide.ui.internal.providers;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.CreateEditPoliciesOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.IEditPolicyProvider;
import org.eclipselabs.damos.diagram.ui.editparts.BlockDiagramEditPart;
import org.eclipselabs.damos.ide.ui.internal.editpolicies.LinkerEditPolicy;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Andreas Unger
 *
 */
public class EditPolicyProvider extends AbstractProvider implements IEditPolicyProvider {

	private static final String LINKER_ROLE = "linkerRole";
	
	@Inject
	private Provider<LinkerEditPolicy> linkerEditPolicyProvider;
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.common.core.service.IProvider#provides(org.eclipse.gmf.runtime.common.core.service.IOperation)
	 */
	public boolean provides(IOperation operation) {
		if (operation instanceof CreateEditPoliciesOperation) {
			CreateEditPoliciesOperation createEditPoliciesOperation = (CreateEditPoliciesOperation) operation;
			return createEditPoliciesOperation.getEditPart() instanceof BlockDiagramEditPart;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.IEditPolicyProvider#createEditPolicies(org.eclipse.gef.EditPart)
	 */
	public void createEditPolicies(EditPart editPart) {
		editPart.installEditPolicy(LINKER_ROLE, linkerEditPolicyProvider.get());
	}

}
