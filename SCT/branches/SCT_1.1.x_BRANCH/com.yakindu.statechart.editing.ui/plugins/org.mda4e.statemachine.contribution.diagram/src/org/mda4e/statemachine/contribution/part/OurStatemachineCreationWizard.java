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
package org.mda4e.statemachine.contribution.part;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.part.FileEditorInput;

import statemachine.diagram.part.Messages;
import statemachine.diagram.part.StatemachineCreationWizard;
import statemachine.diagram.part.StatemachineCreationWizardPage;
import statemachine.diagram.part.StatemachineDiagramEditorPlugin;
import statemachine.diagram.part.StatemachineDiagramEditorUtil;

public class OurStatemachineCreationWizard extends StatemachineCreationWizard {
	
	//This method now opens our statechart editor.
	private boolean openDiagram(Resource diagram) throws PartInitException {
		String path = diagram.getURI().toPlatformString(true);
		IResource workspaceResource = ResourcesPlugin.getWorkspace().getRoot().findMember(new Path(path));
		if (workspaceResource instanceof IFile) {
			IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			return null != page.openEditor(new FileEditorInput((IFile) workspaceResource), OurStatemachineDiagramEditor.ID);
		}
		return false;
	}
	
	/**
	 * @generated
	 */
	
	public void addPages() {
		/*
		diagramModelFilePage = new StatemachineCreationWizardPage(
				"DiagramModelFile", getSelection(), "statemachine_diagram"); //$NON-NLS-1$ //$NON-NLS-2$
		diagramModelFilePage
				.setTitle(Messages.StatemachineCreationWizard_DiagramModelFilePageTitle);
		diagramModelFilePage
				.setDescription(Messages.StatemachineCreationWizard_DiagramModelFilePageDescription);
		addPage(diagramModelFilePage);
		*/
		domainModelFilePage = new StatemachineCreationWizardPage(
				"DomainModelFile", getSelection(), "statemachine"); //$NON-NLS-1$ //$NON-NLS-2$
		domainModelFilePage
				.setTitle(Messages.StatemachineCreationWizard_DomainModelFilePageTitle);
		domainModelFilePage
				.setDescription(Messages.StatemachineCreationWizard_DomainModelFilePageDescription);
		addPage(domainModelFilePage);
	}
	
	public boolean performFinish() {
		IRunnableWithProgress op = new WorkspaceModifyOperation(null) {

			protected void execute(IProgressMonitor monitor)
					throws CoreException, InterruptedException {
				//System.out.println("Uri: "+domainModelFilePage.getURI().trimFileExtension().appendFileExtension("meineErweiterung"));
				diagram = StatemachineDiagramEditorUtil.createDiagram(
						domainModelFilePage.getURI().trimFileExtension().appendFileExtension("statemachine_diagram"), domainModelFilePage
								.getURI(), monitor);
				if (isOpenNewlyCreatedDiagramEditor() && diagram != null) {
					try {
						//Here is the generated code modified.
						openDiagram(diagram);
					} catch (PartInitException e) {
						ErrorDialog
								.openError(
										getContainer().getShell(),
										Messages.StatemachineCreationWizardOpenEditorError,
										null, e.getStatus());
					}
				}
			}
		};
		try {
			getContainer().run(false, true, op);
		} catch (InterruptedException e) {
			return false;
		} catch (InvocationTargetException e) {
			if (e.getTargetException() instanceof CoreException) {
				ErrorDialog.openError(getContainer().getShell(),
						Messages.StatemachineCreationWizardCreationError, null,
						((CoreException) e.getTargetException()).getStatus());
			} else {
				StatemachineDiagramEditorPlugin.getInstance().logError(
						"Error creating diagram", e.getTargetException()); //$NON-NLS-1$
			}
			return false;
		}
		return diagram != null;
	}
}