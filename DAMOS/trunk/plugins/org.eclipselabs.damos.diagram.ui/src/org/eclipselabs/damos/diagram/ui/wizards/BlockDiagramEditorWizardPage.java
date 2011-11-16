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

import java.io.InputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.ide.util.IDEEditorFileCreator;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.ide.wizards.EditorWizardPage;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.util.DiagramFileCreator;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipselabs.damos.diagram.ui.util.EditorUtil;

public class BlockDiagramEditorWizardPage extends EditorWizardPage {

	private final String fileExtension;
	private final PreferencesHint preferencesHint;
	
	/**
	 * LogicDiagramWizardPage constructor
	 *
	 * @param aWorkbench
	 *            workbench
	 * @param selection
	 *            selection
	 */
	public BlockDiagramEditorWizardPage(IWorkbench aWorkbench, IStructuredSelection selection, String fileExtension, PreferencesHint preferencesHint) {
		super("BlockDiagramPage", aWorkbench, selection); //$NON-NLS-1$
		this.setTitle("Create Block Diagram");
		this.setDescription("Create a new block diagram.");
		this.fileExtension = fileExtension;
		this.preferencesHint = preferencesHint;
	}
	
	public IFile createAndOpenDiagram(
			IPath containerPath,
			String fileName,
			InputStream initialContents,
			String kind,
			IWorkbenchWindow dWindow,
			IProgressMonitor progressMonitor,
			boolean saveDiagram) {
		
		String semanticResourcePath = null;
		
		return EditorUtil.createAndOpenDiagram(
				getDiagramFileCreator(),
				containerPath,
				fileName,
				initialContents,
				kind,
				dWindow,
				progressMonitor,
				isOpenNewlyCreatedDiagramEditor(),
				saveDiagram,
				semanticResourcePath,
				preferencesHint);
	}
	

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.resources.editor.ide.wizards.EditorWizardPage#getDefaultFileName()
	 */
	protected String getDefaultFileName() {
		return "Unnamed";
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.resources.editor.ide.wizards.EditorWizardPage#getDiagramFileCreator()
	 */
	public DiagramFileCreator getDiagramFileCreator() {
		return new IDEEditorFileCreator() {
			
			@Override
			public String getExtension() {
				return "." + fileExtension;
			}
			
		};
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.resources.editor.ide.wizards.EditorWizardPage#getDiagramKind()
	 */
	protected String getDiagramKind() {
		return ""; //$NON-NLS-1$
	}
	
}
