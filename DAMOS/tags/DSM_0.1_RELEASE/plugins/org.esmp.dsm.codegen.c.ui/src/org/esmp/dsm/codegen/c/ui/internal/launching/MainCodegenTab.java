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

package org.esmp.dsm.codegen.c.ui.internal.launching;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ContainerSelectionDialog;
import org.eclipse.ui.dialogs.FilteredResourcesSelectionDialog;
import org.esmp.dsm.codegen.c.internal.launching.CCodegenLaunchConfigurationDelegate;
import org.esmp.dsm.codegen.c.ui.DSMCodegenCUIPlugin;
import org.esmp.dsm.semantic.blockdiagram.util.BlockDiagramConstants;

/**
 * @author Andreas Unger
 *
 */
public class MainCodegenTab extends AbstractLaunchConfigurationTab {
	
	private Text blockDiagramPathText;
	private Text targetFolderPathText;
	private Text samplingFrequencyText;
	
	/**
	 * 
	 */
	public MainCodegenTab() {
		setMessage("Create a configuration to generate C code for a block diagram.");
		setDirty(false);
	}

	public void createControl(Composite parent) {
		final Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(3, false));
		setControl(composite);
		
		new Label(composite, SWT.NONE).setText("Block diagram model:");
		blockDiagramPathText = new Text(composite, SWT.SINGLE | SWT.BORDER);
		blockDiagramPathText.setLayoutData(new GridData(GridData.FILL, GridData.BEGINNING, true, false));
		blockDiagramPathText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				updateLaunchConfigurationDialog();
			}
		});
		
		Button searchButton = createPushButton(composite, "Browse...", null);
		searchButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				FilteredResourcesSelectionDialog d = new FilteredResourcesSelectionDialog(
						composite.getShell(),
						false,
						ResourcesPlugin.getWorkspace().getRoot(),
						IResource.FILE);
				d.setInitialPattern("*." + BlockDiagramConstants.FILE_EXTENSION);
				d.open();
				Object firstResult = d.getFirstResult();
				if (firstResult instanceof IFile) {
					blockDiagramPathText.setText(((IFile) firstResult).getFullPath().toString()); 
				}
			}
		});
		
		new Label(composite, SWT.NONE).setText("Target folder:");
		targetFolderPathText = new Text(composite, SWT.SINGLE | SWT.BORDER);
		targetFolderPathText.setLayoutData(new GridData(GridData.FILL, GridData.BEGINNING, true, false));
		targetFolderPathText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				updateLaunchConfigurationDialog();
			}
		});

		Button targetFolderBrowseButton = createPushButton(composite, "Browse...", null);
		targetFolderBrowseButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				ContainerSelectionDialog d = new ContainerSelectionDialog(
						composite.getShell(),
						ResourcesPlugin.getWorkspace().getRoot(),
						false,
						null);
				d.open();
				Object[] results = d.getResult();
				if (results != null && results.length > 0 && results[0] instanceof IPath) {
					targetFolderPathText.setText(((IPath) results[0]).toString()); 
				}
			}
		});

		new Label(composite, SWT.NONE).setText("Sampling frequency (Hz):");
		samplingFrequencyText = new Text(composite, SWT.SINGLE | SWT.BORDER);
		samplingFrequencyText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent event) {
				updateLaunchConfigurationDialog();
			}
		});
		GridData gridData = new GridData(GridData.FILL, GridData.BEGINNING, true, false);
		gridData.horizontalSpan = 2;
		samplingFrequencyText.setLayoutData(gridData);
	}

	public String getName() {
		return "Main";
	}

	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			blockDiagramPathText.setText(configuration.getAttribute(CCodegenLaunchConfigurationDelegate.ATTRIBUTE__BLOCK_DIAGRAM_PATH, ""));
			targetFolderPathText.setText(configuration.getAttribute(CCodegenLaunchConfigurationDelegate.ATTRIBUTE__TARGET_FOLDER_PATH, ""));
			samplingFrequencyText.setText(configuration.getAttribute(CCodegenLaunchConfigurationDelegate.ATTRIBUTE__SAMPLING_FREQUENCY, "8000"));
		} catch (CoreException e) {
			DSMCodegenCUIPlugin.getDefault().getLog().log(e.getStatus());
		}
	}

	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		String errorMessage = null;
		
		String blockDiagramPath = blockDiagramPathText.getText();
		configuration.setAttribute(CCodegenLaunchConfigurationDelegate.ATTRIBUTE__BLOCK_DIAGRAM_PATH, blockDiagramPath);
		
		String targetFolderPath = targetFolderPathText.getText();
		configuration.setAttribute(CCodegenLaunchConfigurationDelegate.ATTRIBUTE__TARGET_FOLDER_PATH, targetFolderPath);

		try {
			String samplingFrequency = samplingFrequencyText.getText();
			Long.parseLong(samplingFrequency);
			configuration.setAttribute(CCodegenLaunchConfigurationDelegate.ATTRIBUTE__SAMPLING_FREQUENCY, samplingFrequency);
		} catch (NumberFormatException e) {
			errorMessage = "Invalid sampling frequency";
		}

		setErrorMessage(errorMessage);
	}

	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		String defaultBlockDiagramPath = "";
		IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		IEditorPart activeEditor = activePage.getActiveEditor();
		if (activeEditor != null) {
			IEditorInput editorInput = activeEditor.getEditorInput();
			if (editorInput instanceof IFileEditorInput) {
				IPath path = ((IFileEditorInput) editorInput).getFile().getFullPath();
				if (BlockDiagramConstants.FILE_EXTENSION.equals(path.getFileExtension())) {
					defaultBlockDiagramPath = path.toString();
				}
			}
		}
		configuration.setAttribute(CCodegenLaunchConfigurationDelegate.ATTRIBUTE__BLOCK_DIAGRAM_PATH, defaultBlockDiagramPath);
		configuration.setAttribute(CCodegenLaunchConfigurationDelegate.ATTRIBUTE__SAMPLING_FREQUENCY, "8000");
	}

}
