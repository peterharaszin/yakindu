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

package org.eclipse.damos.diagram.ui.actions;

import org.eclipse.gmf.runtime.common.ui.services.action.contributionitem.AbstractContributionItemProvider;
import org.eclipse.gmf.runtime.common.ui.util.IWorkbenchPartDescriptor;
import org.eclipse.jface.action.IAction;

/**
 * @author Andreas Unger
 *
 */
public class ContributionItemProvider extends AbstractContributionItemProvider {
	
	private static final String FLIP_BLOCK_ACTION = "flipBlockAction";
	private static final String ROTATE_BLOCK_ACTION = "rotateBlockAction";
	private static final String RESET_FLIP_AND_ROTATE_BLOCK_ACTION = "resetFlipAndRotateBlockAction";
	

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.common.ui.services.action.contributionitem.AbstractContributionItemProvider#createAction(java.lang.String, org.eclipse.gmf.runtime.common.ui.util.IWorkbenchPartDescriptor)
	 */
	protected IAction createAction(String actionId, IWorkbenchPartDescriptor partDescriptor) {
		if (actionId.equals(FLIP_BLOCK_ACTION)) {
			return new FlipComponentAction(partDescriptor.getPartPage());
		}
		if (actionId.equals(ROTATE_BLOCK_ACTION)) {
			return new RotateComponentAction(partDescriptor.getPartPage());
		}
		if (actionId.equals(RESET_FLIP_AND_ROTATE_BLOCK_ACTION)) {
			return new ResetFlipAndRotateComponentAction(partDescriptor.getPartPage());
		}
		return super.createAction(actionId, partDescriptor);
	}
	
}
