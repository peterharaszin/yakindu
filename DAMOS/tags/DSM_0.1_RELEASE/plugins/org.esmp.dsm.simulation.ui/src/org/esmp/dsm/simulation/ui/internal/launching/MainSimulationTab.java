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

package org.esmp.dsm.simulation.ui.internal.launching;

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
import org.eclipse.ui.dialogs.FilteredResourcesSelectionDialog;
import org.esmp.dsm.semantic.blockdiagram.util.BlockDiagramConstants;
import org.esmp.dsm.simulation.internal.launching.SimulationLaunchConfigurationDelegate;
import org.esmp.dsm.simulation.ui.DSMSimulatorUIPlugin;

/**
 * @author Andreas Unger
 *
 */
public class MainSimulationTab extends AbstractLaunchConfigurationTab {
	
	private Text blockDiagramPathText;
	private Text samplingFrequencyText;
	private Text simulationTimeText;
	
	/**
	 * 
	 */
	public MainSimulationTab() {
		setMessage("Create a configuration to simulate a block diagram.");
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
		
		Button browseButton = createPushButton(composite, "Browse...", null);
		browseButton.addSelectionListener(new SelectionAdapter() {
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

		new Label(composite, SWT.NONE).setText("Simulation time (seconds):");
		simulationTimeText = new Text(composite, SWT.SINGLE | SWT.BORDER);
		simulationTimeText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent event) {
				updateLaunchConfigurationDialog();
			}
		});
		gridData = new GridData(GridData.FILL, GridData.BEGINNING, true, false);
		gridData.horizontalSpan = 2;
		simulationTimeText.setLayoutData(gridData);
	}

	public String getName() {
		return "Main";
	}

	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			blockDiagramPathText.setText(configuration.getAttribute(SimulationLaunchConfigurationDelegate.ATTRIBUTE__BLOCK_DIAGRAM_PATH, ""));
			samplingFrequencyText.setText(configuration.getAttribute(SimulationLaunchConfigurationDelegate.ATTRIBUTE__SAMPLING_FREQUENCY, "8000"));
			simulationTimeText.setText(configuration.getAttribute(SimulationLaunchConfigurationDelegate.ATTRIBUTE__SIMULATION_TIME, "10"));
		} catch (CoreException e) {
			DSMSimulatorUIPlugin.getDefault().getLog().log(e.getStatus());
		}
	}

	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		String errorMessage = null;
		
		String blockDiagramPath = blockDiagramPathText.getText();
		configuration.setAttribute(SimulationLaunchConfigurationDelegate.ATTRIBUTE__BLOCK_DIAGRAM_PATH, blockDiagramPath);
		
		try {
			String samplingFrequency = samplingFrequencyText.getText();
			Long.parseLong(samplingFrequency);
			configuration.setAttribute(SimulationLaunchConfigurationDelegate.ATTRIBUTE__SAMPLING_FREQUENCY, samplingFrequency);
		} catch (NumberFormatException e) {
			errorMessage = "Invalid sampling frequency";
		}
		
		try {
			String simulationTime = simulationTimeText.getText();
			Double.parseDouble(simulationTime);
			configuration.setAttribute(SimulationLaunchConfigurationDelegate.ATTRIBUTE__SIMULATION_TIME, simulationTime);
		} catch (NumberFormatException e) {
			errorMessage = "Invalid simulation time";
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
		configuration.setAttribute(SimulationLaunchConfigurationDelegate.ATTRIBUTE__BLOCK_DIAGRAM_PATH, defaultBlockDiagramPath);
		configuration.setAttribute(SimulationLaunchConfigurationDelegate.ATTRIBUTE__SAMPLING_FREQUENCY, "8000");
		configuration.setAttribute(SimulationLaunchConfigurationDelegate.ATTRIBUTE__SIMULATION_TIME, "10");
	}

}
