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

package org.eclipse.damos.diagram.ui.wizards;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.damos.diagram.core.resource.BlockDiagramFileExtension;
import org.eclipse.damos.diagram.ui.util.EditorUtil;
import org.eclipse.damos.dml.ui.wizards.WizardNewQualifiedElementCreationPage;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.ide.util.IDEEditorFileCreator;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.util.DiagramFileCreator;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.SWT;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

import com.google.inject.Inject;

/**
 * @author Andreas Unger
 *
 */
public class NewBlockDiagramCreationWizard extends Wizard implements INewWizard {

	@Inject
	@BlockDiagramFileExtension
	private String fileExtension;

	@Inject
	private PreferencesHint preferencesHint;

	private IWorkbench workbench;
	private IStructuredSelection selection;

	private WizardNewQualifiedElementCreationPage mainPage;
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchWizard#init(org.eclipse.ui.IWorkbench, org.eclipse.jface.viewers.IStructuredSelection)
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		this.selection = selection;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.Wizard#addPages()
	 */
	@Override
	public void addPages() {
		super.addPages();
		mainPage = new WizardNewQualifiedElementCreationPage("main", "Block Diagram", null, "block diagram", fileExtension, fileExtension, selection);
		mainPage.setDescription("Create new block diagram");
		mainPage.setInitialModelName("");
		addPage(mainPage);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
		// TODO: Use wizard progress bar
		getShell().setCursor(getShell().getDisplay().getSystemCursor(SWT.CURSOR_WAIT));
		try {
			return EditorUtil.createAndOpenDiagram(
					getDiagramFileCreator(),
					mainPage.getModelFile().getParent().getFullPath(),
					mainPage.getModelFile().getName(),
					mainPage.getPackageName(),
					mainPage.getModelName(),
					EditorUtil.getInitialContents(),
					"",
					workbench.getActiveWorkbenchWindow(),
					new NullProgressMonitor(),
					true,
					true,
					null,
					preferencesHint) != null;
		} finally {
			getShell().setCursor(null);
		}
	}
	
	private DiagramFileCreator getDiagramFileCreator() {
		return new IDEEditorFileCreator() {
			
			@Override
			public String getExtension() {
				return "." + fileExtension;
			}
			
		};
	}
	
}
