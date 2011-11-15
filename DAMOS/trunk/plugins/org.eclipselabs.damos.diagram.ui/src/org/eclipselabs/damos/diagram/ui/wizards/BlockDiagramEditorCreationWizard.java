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

package org.eclipselabs.damos.diagram.ui.wizards;

import org.eclipse.gmf.runtime.diagram.ui.resources.editor.ide.wizards.EditorCreationWizard;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbench;
import org.eclipselabs.damos.diagram.core.resource.BlockDiagramFileExtension;

import com.google.inject.Inject;

public class BlockDiagramEditorCreationWizard extends EditorCreationWizard {

	@Inject
	@BlockDiagramFileExtension
	private String fileExtension;
	
	/**
	 * @see org.eclipse.jface.wizard.IWizard#addPages()
	 */
	public void addPages() {
		super.addPages();
		if (page == null) {
			page = new BlockDiagramEditorWizardPage(getWorkbench(), getSelection(), fileExtension);
		}
		addPage(page);
	}
	
	public void init(IWorkbench workbench, IStructuredSelection sel) {
		super.init(workbench, sel);
		setWindowTitle("New Block Diagram");
		setNeedsProgressMonitor(true);
	}

}
