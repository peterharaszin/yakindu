/**
 * Copyright (c) 2006-2009 committers of mda4e and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of mda4e (http://www.mda4e.org/) - initial API and implementation
 *
 */
package org.mda4e.statemachine.contribution.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.mda4e.statemachine.contribution.views.SetupDataElementDialog;
import org.mda4e.statemachine.contribution.views.SetupDataElementDialog.DialogType;

public class CreateEventAction extends Action {

	public CreateEventAction(){
		setText("Create Event");
		setToolTipText("Create a new event");
		setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
				getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
	}
	
	public void run() {
		//CreateEventWindow shell = new CreateEventWindow(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell());
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		SetupDataElementDialog dialog = new SetupDataElementDialog(shell,DialogType.EVENT,null);
		dialog.setBlockOnOpen(true);
		dialog.open();
	}
}//CreateEventAction
