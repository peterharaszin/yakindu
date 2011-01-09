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

package org.eclipselabs.damos.simulation.ide.ui.internal.launch;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
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
import org.eclipselabs.damos.common.ui.viewers.FragmentLabelProvider;
import org.eclipselabs.damos.common.ui.viewers.FragmentListContentProvider;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.Fragment;
import org.eclipselabs.damos.simulation.ide.core.internal.launch.SimulationLaunchConfigurationDelegate;
import org.eclipselabs.damos.simulation.ide.ui.SimulationIDEUIPlugin;

/**
 * @author Andreas Unger
 *
 */
public class MainSimulationTab extends AbstractLaunchConfigurationTab {
	
	private static final String FILE_EXTENSION = "blockdiagram";

	private Text blockDiagramPathText;
	private ComboViewer fragmentViewer;
	private Text sampleRateText;
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
			public void modifyText(ModifyEvent event) {
				try {
					ResourceSet rs = new ResourceSetImpl();
					URI uri = URI.createPlatformResourceURI(blockDiagramPathText.getText(), false);
					rs.getResource(uri, true);
					fragmentViewer.setInput(rs);
					fragmentViewer.getCombo().select(0);
				} catch (Exception e) {
					fragmentViewer.setInput(null);
				}
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
				d.setInitialPattern("*." + FILE_EXTENSION);
				d.open();
				Object firstResult = d.getFirstResult();
				if (firstResult instanceof IFile) {
					blockDiagramPathText.setText(((IFile) firstResult).getFullPath().toString());
				}
			}
		});
		
		new Label(composite, SWT.NONE).setText("Fragment:");
		fragmentViewer = new ComboViewer(composite, SWT.SINGLE | SWT.BORDER | SWT.READ_ONLY);
		fragmentViewer.getCombo().setLayoutData(new GridData(GridData.FILL, GridData.BEGINNING, true, false, 2, 1));
		fragmentViewer.setLabelProvider(new FragmentLabelProvider());
		fragmentViewer.setContentProvider(new FragmentListContentProvider());
		fragmentViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			
			public void selectionChanged(SelectionChangedEvent event) {
				updateLaunchConfigurationDialog();
			}
			
		});
		
		new Label(composite, SWT.NONE).setText("Sample rate (Hz):");
		sampleRateText = new Text(composite, SWT.SINGLE | SWT.BORDER);
		sampleRateText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent event) {
				updateLaunchConfigurationDialog();
			}
		});
		GridData gridData = new GridData(GridData.FILL, GridData.BEGINNING, true, false);
		gridData.horizontalSpan = 2;
		sampleRateText.setLayoutData(gridData);

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
			Fragment fragment = null;
			String fragmentURIString = configuration.getAttribute(SimulationLaunchConfigurationDelegate.ATTRIBUTE__FRAGMENT_URI, "");
			if (fragmentURIString.length() > 0) {
				URI uri = URI.createURI(fragmentURIString);
				ResourceSet rs = new ResourceSetImpl();
				fragment = (Fragment) rs.getEObject(uri, true);
			}
			if (fragment != null) {
				blockDiagramPathText.setText(fragment.eResource().getURI().toPlatformString(false));
				fragmentViewer.setInput(fragment.eResource().getResourceSet());
				fragmentViewer.setSelection(new StructuredSelection(fragment));
			}
			sampleRateText.setText(configuration.getAttribute(SimulationLaunchConfigurationDelegate.ATTRIBUTE__SAMPLE_RATE, "8000"));
			simulationTimeText.setText(configuration.getAttribute(SimulationLaunchConfigurationDelegate.ATTRIBUTE__SIMULATION_TIME, "10"));
		} catch (CoreException e) {
			SimulationIDEUIPlugin.getDefault().getLog().log(e.getStatus());
		}
	}

	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		String errorMessage = null;
		
		Fragment fragment = null;
		ISelection selection = fragmentViewer.getSelection();
		if (selection instanceof IStructuredSelection) {
			fragment = (Fragment) ((IStructuredSelection) selection).getFirstElement();
		}
		if (fragment != null) {
			configuration.setAttribute(SimulationLaunchConfigurationDelegate.ATTRIBUTE__FRAGMENT_URI, EcoreUtil.getURI(fragment).toString());
		} else {
			errorMessage = "No fragment selected";
		}
		
		try {
			String sampleRate = sampleRateText.getText();
			Long.parseLong(sampleRate);
			configuration.setAttribute(SimulationLaunchConfigurationDelegate.ATTRIBUTE__SAMPLE_RATE, sampleRate);
		} catch (NumberFormatException e) {
			errorMessage = "Invalid sample rate";
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
				if (FILE_EXTENSION.equals(path.getFileExtension())) {
					URI uri = URI.createPlatformResourceURI(path.toString(), false);
					ResourceSet rs = new ResourceSetImpl();
					Resource r = rs.getResource(uri, true);
					Fragment fragment = (Fragment) EcoreUtil.getObjectByType(r.getContents(), DMLPackage.Literals.MODEL);
					if (fragment == null) {
						fragment = (Fragment) EcoreUtil.getObjectByType(r.getContents(), DMLPackage.Literals.FRAGMENT);
					}
					if (fragment != null) {
						defaultBlockDiagramPath = EcoreUtil.getURI(fragment).toString();
					}
				}
			}
		}
		configuration.setAttribute(SimulationLaunchConfigurationDelegate.ATTRIBUTE__FRAGMENT_URI, defaultBlockDiagramPath);
		configuration.setAttribute(SimulationLaunchConfigurationDelegate.ATTRIBUTE__SAMPLE_RATE, "8000");
		configuration.setAttribute(SimulationLaunchConfigurationDelegate.ATTRIBUTE__SIMULATION_TIME, "10");
	}

}
