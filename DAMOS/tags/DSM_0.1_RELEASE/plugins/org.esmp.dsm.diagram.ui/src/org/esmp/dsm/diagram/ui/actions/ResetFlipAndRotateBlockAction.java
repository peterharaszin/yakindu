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

package org.esmp.dsm.diagram.ui.actions;

import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction;
import org.eclipse.ui.IWorkbenchPage;
import org.esmp.dsm.diagram.ui.requests.RequestConstants;

/**
 * @author Andreas Unger
 *
 */
public class ResetFlipAndRotateBlockAction extends DiagramAction {

	/**
	 * @param workbenchPage
	 */
	public ResetFlipAndRotateBlockAction(IWorkbenchPage workbenchPage) {
		super(workbenchPage);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.common.ui.action.AbstractActionHandler#init()
	 */
	public void init() {
		super.init();
		setText("Reset Flip and Rotate");
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction#createTargetRequest()
	 */
	protected Request createTargetRequest() {
		return new Request(RequestConstants.REQ_RESET_FLIP_AND_ROTATE_BLOCK);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction#isSelectionListener()
	 */
	protected boolean isSelectionListener() {
		return true;
	}

}
