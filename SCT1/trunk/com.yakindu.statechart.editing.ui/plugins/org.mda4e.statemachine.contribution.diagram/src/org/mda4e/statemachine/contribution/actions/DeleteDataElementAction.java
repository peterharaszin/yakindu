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

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.mda4e.statemachine.contribution.commands.CmdDeleteEvent;
import org.mda4e.statemachine.contribution.commands.CmdDeleteVar;
import org.mda4e.statemachine.contribution.model.TreeObject;

import statemachine.Event;
import statemachine.Variable;
import statemachine.diagram.part.StatemachineDiagramEditor;

public class DeleteDataElementAction extends Action //implements ISelectionListener
{
	
	private EObject selectedObject;
	
	public DeleteDataElementAction(TreeViewer viewer){
		ISelection selection = viewer.getSelection();
		TreeObject treeObject = (TreeObject) ((IStructuredSelection)selection).getFirstElement();
		selectedObject = treeObject.getObject();
		setText("Delete");
		setToolTipText("Delete selected Element");
		setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
				getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
	}
	
	public boolean isEnabled(){
		if (selectedObject instanceof Variable || selectedObject instanceof Event)
			return true;
		return false;
	}
	
	public void run() {
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		if (page.getActiveEditor() instanceof StatemachineDiagramEditor) {
			StatemachineDiagramEditor editor = (StatemachineDiagramEditor)page.getActiveEditor();
			if (selectedObject instanceof Variable)
				try {
					new CmdDeleteVar(editor.getEditingDomain(),"Delete Variable",null,(Variable)selectedObject).execute(null, null);
				} catch (ExecutionException e) {
					e.printStackTrace();
				}
			else if (selectedObject instanceof Event)
				try {
					new CmdDeleteEvent(editor.getEditingDomain(),"Delete Event",null,(Event)selectedObject).execute(null, null);
					OperationHistoryFactory.getOperationHistory().execute(new CmdDeleteEvent(editor.getEditingDomain(),"Delete Event",null,(Event)selectedObject),null,null);
				} catch (ExecutionException e) {
					e.printStackTrace();
				}
		}
	}
}//DeleteDataElementAction