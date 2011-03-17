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
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.ide.wizards.EditorWizardPage;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.util.DiagramFileCreator;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.dialogs.ResourceSelectionDialog;
import org.eclipselabs.damos.diagram.ui.util.EditorUtil;
import org.eclipselabs.damos.diagram.ui.util.FileCreator;

public class BlockDiagramEditorWizardPage extends EditorWizardPage {

//	private Button separateSemantics;
//	private Text semanticResource;

	/**
	 * LogicDiagramWizardPage constructor
	 *
	 * @param aWorkbench
	 *            workbench
	 * @param selection
	 *            selection
	 */
	public BlockDiagramEditorWizardPage(IWorkbench aWorkbench, IStructuredSelection selection) {
		super("BlockDiagramPage", aWorkbench, selection); //$NON-NLS-1$
		this.setTitle("Create Block Diagram");
		this.setDescription("Create a new block diagram.");
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
		
//		if (separateSemantics.getSelection()
//				&& semanticResource.getText().length() > 0) {
//			
//			semanticResourcePath = semanticResource.getText();
//		}
		
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
				semanticResourcePath);
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
		return FileCreator.getInstance();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.resources.editor.ide.wizards.EditorWizardPage#getDiagramKind()
	 */
	protected String getDiagramKind() {
		return ""; //$NON-NLS-1$
	}
	
//	protected void createAdvancedControls(Composite parent) {
//		super.createAdvancedControls(parent);
//		
//		separateSemantics = new Button(parent,SWT.CHECK);
//		separateSemantics.setText("Store semantics in a separate semantic resource");
//		separateSemantics.setSelection(false);
//		
//        Composite separateSemanticsGroup = new Composite(parent, SWT.NONE);
//        GridLayout layout = new GridLayout();
//        layout.numColumns = 4;
//        layout.marginHeight = 0;
//        layout.marginWidth = 0;
//        separateSemanticsGroup.setLayout(layout);
//        GridData data = new GridData(GridData.FILL_HORIZONTAL);
//        separateSemanticsGroup.setLayoutData(data);
//		
//        semanticResource = new Text(separateSemanticsGroup, SWT.BORDER);
//		data = new GridData(GridData.FILL_HORIZONTAL);
//        data.widthHint = IDialogConstants.ENTRY_FIELD_WIDTH;
//        data.horizontalSpan = 2;
//        semanticResource.setLayoutData(data);
//        semanticResource.setEnabled(false);
//        
//        // browse button
//        final Button browseButton = new Button(separateSemanticsGroup, SWT.PUSH);      
//        browseButton.setText("Browse...");
//        browseButton.addSelectionListener(new SelectionAdapter() {
//            public void widgetSelected(SelectionEvent event) {
//                handleBrowseButtonPressed();
//            }
//        });
//        browseButton.setEnabled(false);
//        setButtonLayoutData(browseButton);
//        
//		separateSemantics.addSelectionListener(new SelectionListener() {
//			public void widgetSelected(SelectionEvent e) {
//				semanticResource.setEnabled(!semanticResource.getEnabled());
//				browseButton.setEnabled(!browseButton.getEnabled());
//				semanticResource.setText(getContainerFullPath().append(getFileName()).removeFileExtension().addFileExtension("dml").toString()); //$NON-NLS-1$
//			}
//
//			public void widgetDefaultSelected(SelectionEvent e) {
//				// Do nothing
//			}
//		});
//	}

	protected void handleBrowseButtonPressed() {
		ResourceSelectionDialog dialog = new ResourceSelectionDialog(getShell(),ResourcesPlugin.getWorkspace().getRoot(), "Sematic Resource Selection");
		
		if (dialog.open() == ResourceSelectionDialog.OK) {
			if (dialog.getResult().length == 0)
				return;
			
//			IResource r = (IResource)dialog.getResult()[0];
//			semanticResource.setText(r.getFullPath().toString());
		}
	}

}
