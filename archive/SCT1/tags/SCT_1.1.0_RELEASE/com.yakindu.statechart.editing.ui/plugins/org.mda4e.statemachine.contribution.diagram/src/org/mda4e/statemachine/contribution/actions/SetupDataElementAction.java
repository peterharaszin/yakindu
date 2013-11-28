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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.mda4e.statemachine.contribution.model.TreeObject;
import org.mda4e.statemachine.contribution.views.SetupDataElementDialog;
import org.mda4e.statemachine.contribution.views.SetupDataElementDialog.DialogType;

import statemachine.DataElement;
import statemachine.Event;
import statemachine.Variable;

public class SetupDataElementAction extends Action {
	
	private EObject selectedObject;
	private TreeViewer viewer;
	
	public SetupDataElementAction(TreeViewer viewer){
		this.viewer = viewer;
	}
	
	public boolean isEnabled(){
		ISelection selection = viewer.getSelection();
		TreeObject treeObject = (TreeObject) ((IStructuredSelection)selection).getFirstElement();
		selectedObject = treeObject.getObject();
		if (selectedObject instanceof Variable || selectedObject instanceof Event)
			return true;
		return false;
	}
	
	public void run() {
		
		if (selectedObject instanceof Variable) {
			//CreateVarWindow shell = new CreateVarWindow(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), (Variable) selectedObject);
			//shell.setBlockOnOpen(true);
			//shell.open();
			Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
			SetupDataElementDialog dialog = new SetupDataElementDialog(shell,DialogType.VARIABLE,(DataElement)selectedObject);
			dialog.setBlockOnOpen(true);
			dialog.open();
			
		} else if (selectedObject instanceof Event) {
			//CreateEventWindow shell = new CreateEventWindow(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), (Event) selectedObject);
			//shell.setBlockOnOpen(true);
			//shell.open();
			Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
			SetupDataElementDialog dialog = new SetupDataElementDialog(shell,DialogType.EVENT,(DataElement)selectedObject);
			dialog.setBlockOnOpen(true);
			dialog.open();
		}
	}
}//SetupDataElementAction