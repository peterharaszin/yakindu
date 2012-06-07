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

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.FilteredResourcesSelectionDialog;
import org.eclipselabs.damos.common.ui.util.UIUtil;
import org.eclipselabs.damos.common.ui.viewers.FragmentLabelProvider;
import org.eclipselabs.damos.common.ui.viewers.FragmentListContentProvider;
import org.eclipselabs.damos.common.util.NameUtil;
import org.eclipselabs.damos.dconfig.PropertyDeclaration;
import org.eclipselabs.damos.dconfig.SelectionPropertyOption;
import org.eclipselabs.damos.dconfig.SimplePropertyDeclaration;
import org.eclipselabs.damos.dconfig.util.PropertyEnumerationHelper;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.Fragment;
import org.eclipselabs.damos.simulation.ide.core.internal.launch.SimulationLaunchConfigurationDelegate;
import org.eclipselabs.damos.simulation.ide.core.util.LaunchConfigurationUtil;
import org.eclipselabs.damos.simulation.ide.ui.SimulationIDEUIPlugin;
import org.eclipselabs.damos.simulation.simulator.registry.ISolverDescriptor;
import org.eclipselabs.damos.simulation.simulator.registry.ISolverRegistry;

/**
 * @author Andreas Unger
 *
 */
public class MainSimulationTab extends AbstractLaunchConfigurationTab {
	
	private static final String DCONFIG_FILE_EXTENSION = "dconfig";
	private static final String BLOCK_DIAGRAM_FILE_EXTENSION = "blockdiagram";
	
	private final PropertyEnumerationHelper propertyEnumerationHelper = new PropertyEnumerationHelper("damos.simulation.solver");

	private Label baseConfigurationPathLabel;
	private Text baseConfigurationPathText;

	private Button overrideConfigurationButton;
	private Text blockDiagramPathText;
	private ComboViewer fragmentViewer;
	private Text simulationTimeText;
	private Button realTimeSimulationButton;
	private ComboViewer solverViewer;
	private Group solverConfigurationGroup;
	private List<Control> overrideConfigurationControls = new ArrayList<Control>();
	
	private Map<String, SolverConfigurationPage> solverConfigurationControls = new HashMap<String, SolverConfigurationPage>();
	
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
		
		GridData gridData;
		
		baseConfigurationPathLabel = new Label(composite, SWT.NONE);
		baseConfigurationPathLabel.setLayoutData(new GridData(GridData.FILL, GridData.BEGINNING, true, false, 3, 1));

		baseConfigurationPathText = new Text(composite, SWT.SINGLE | SWT.BORDER);
		gridData = new GridData(GridData.FILL, GridData.BEGINNING, true, false, 2, 1);
		baseConfigurationPathText.setLayoutData(gridData);
		baseConfigurationPathText.addModifyListener(new ModifyListener() {
			
			public void modifyText(ModifyEvent event) {
				updateLaunchConfigurationDialog();
			}
			
		});
		
		Button baseConfigurationBrowseButton = createPushButton(composite, "Browse...", null);
		baseConfigurationBrowseButton.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				FilteredResourcesSelectionDialog d = new FilteredResourcesSelectionDialog(
						composite.getShell(),
						false,
						ResourcesPlugin.getWorkspace().getRoot(),
						IResource.FILE);
				d.setInitialPattern("*." + DCONFIG_FILE_EXTENSION);
				d.open();
				Object firstResult = d.getFirstResult();
				if (firstResult instanceof IFile) {
					baseConfigurationPathText.setText(((IFile) firstResult).getFullPath().makeRelative().toString());
				}
			}
			
		});

		int indent = UIUtil.getToggleButtonIndentInPixels(composite);
		
		overrideConfigurationButton = new Button(composite, SWT.CHECK);
		overrideConfigurationButton.setText("Override base configuration or create new configuration with:");
		overrideConfigurationButton.setLayoutData(new GridData(GridData.FILL, GridData.BEGINNING, true, false, 3, 1));
		overrideConfigurationButton.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				updateControlsEnablement();
				updateLaunchConfigurationDialog();
			}

		});
		
		Label label = new Label(composite, SWT.NONE);
		gridData = new GridData();
		gridData.horizontalIndent = indent;
		label.setText("Block diagram:");
		label.setLayoutData(gridData);
		overrideConfigurationControls.add(label);
		
		blockDiagramPathText = new Text(composite, SWT.SINGLE | SWT.BORDER);
		gridData = new GridData(GridData.FILL, GridData.BEGINNING, true, false);
		blockDiagramPathText.setLayoutData(gridData);
		blockDiagramPathText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent event) {
				try {
					ResourceSet rs = new ResourceSetImpl();
					URI uri = URI.createPlatformResourceURI(blockDiagramPathText.getText(), false);
					rs.getResource(uri, true);
					fragmentViewer.setInput(rs);
					fragmentViewer.getCombo().select(0);
				} catch (RuntimeException e) {
					fragmentViewer.setInput(null);
				}
				updateLaunchConfigurationDialog();
			}
		});
		overrideConfigurationControls.add(blockDiagramPathText);
		
		Button browseButton = createPushButton(composite, "Browse...", null);
		browseButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				FilteredResourcesSelectionDialog d = new FilteredResourcesSelectionDialog(
						composite.getShell(),
						false,
						ResourcesPlugin.getWorkspace().getRoot(),
						IResource.FILE);
				d.setInitialPattern("*." + BLOCK_DIAGRAM_FILE_EXTENSION);
				d.open();
				Object firstResult = d.getFirstResult();
				if (firstResult instanceof IFile) {
					blockDiagramPathText.setText(((IFile) firstResult).getFullPath().makeRelative().toString());
				}
			}
		});
		overrideConfigurationControls.add(browseButton);
		
		label = new Label(composite, SWT.NONE);
		gridData = new GridData();
		gridData.horizontalIndent = indent;
		label.setText("Fragment:");
		label.setLayoutData(gridData);
		overrideConfigurationControls.add(label);

		fragmentViewer = new ComboViewer(composite, SWT.SINGLE | SWT.BORDER | SWT.READ_ONLY);
		fragmentViewer.getCombo().setLayoutData(new GridData(GridData.FILL, GridData.BEGINNING, true, false, 2, 1));
		fragmentViewer.setLabelProvider(new FragmentLabelProvider());
		fragmentViewer.setContentProvider(new FragmentListContentProvider());
		fragmentViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			
			public void selectionChanged(SelectionChangedEvent event) {
				updateLaunchConfigurationDialog();
			}
			
		});
		overrideConfigurationControls.add(fragmentViewer.getControl());
		
		label = new Label(composite, SWT.NONE);
		gridData = new GridData();
		gridData.horizontalIndent = indent;
		label.setText("Simulation time:");
		label.setLayoutData(gridData);
		overrideConfigurationControls.add(label);

		simulationTimeText = new Text(composite, SWT.SINGLE | SWT.BORDER);
		simulationTimeText.setToolTipText("Simulation time in seconds, e.g. 10(s)");
		simulationTimeText.addModifyListener(new ModifyListener() {
			
			public void modifyText(ModifyEvent event) {
				updateLaunchConfigurationDialog();
			}
			
		});
		gridData = new GridData(GridData.FILL, GridData.BEGINNING, true, false);
		gridData.horizontalSpan = 2;
		simulationTimeText.setLayoutData(gridData);
		overrideConfigurationControls.add(simulationTimeText);
		
		label = new Label(composite, SWT.NONE);
		gridData = new GridData();
		gridData.horizontalIndent = indent;
		label.setLayoutData(gridData);
		
		realTimeSimulationButton = new Button(composite, SWT.CHECK);
		realTimeSimulationButton.setText("Perform real-time simulation");
		gridData = new GridData(GridData.BEGINNING, GridData.BEGINNING, true, false);
		gridData.horizontalSpan = 2;
		realTimeSimulationButton.setLayoutData(gridData);
		realTimeSimulationButton.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				updateSimulationTimeEnablement();
				updateLaunchConfigurationDialog();
			}

		});
		overrideConfigurationControls.add(realTimeSimulationButton);
		
		label = new Label(composite, SWT.NONE);
		gridData = new GridData();
		gridData.horizontalIndent = indent;
		label.setText("Solver:");
		label.setLayoutData(gridData);
		overrideConfigurationControls.add(label);
	
		solverViewer = new ComboViewer(composite, SWT.SINGLE | SWT.BORDER | SWT.READ_ONLY);
		solverViewer.getCombo().setLayoutData(new GridData(GridData.FILL, GridData.BEGINNING, true, false, 2, 1));
		solverViewer.setLabelProvider(new LabelProvider() {

			@Override
			public String getText(Object element) {
				if (element instanceof ISolverDescriptor) {
					return ((ISolverDescriptor) element).getName();
				}
				return super.getText(element);
			}
			
		});
		solverViewer.setContentProvider(new ArrayContentProvider());
		solverViewer.setComparator(new ViewerComparator());
		solverViewer.setInput(ISolverRegistry.INSTANCE.getSolvers());
		solverViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			
			public void selectionChanged(SelectionChangedEvent event) {
				updateSolverConfigurationControls();
				updateLaunchConfigurationDialog();
			}
			
		});
		overrideConfigurationControls.add(solverViewer.getControl());
		
		solverConfigurationGroup = new Group(composite, SWT.NONE);
		solverConfigurationGroup.setText("Solver configuration");
		gridData = new GridData(GridData.FILL, GridData.BEGINNING, true, false, 3, 1);
		gridData.horizontalIndent = indent;
		solverConfigurationGroup.setLayoutData(gridData);
		StackLayout stackLayout = new StackLayout();
		stackLayout.marginWidth = 5;
		stackLayout.marginHeight = 5;
		solverConfigurationGroup.setLayout(stackLayout);
		overrideConfigurationControls.add(solverConfigurationGroup);
	}

	public String getName() {
		return "Main";
	}
	
	private void updateControlsEnablement() {
		boolean enabled = overrideConfigurationButton.getSelection();
		for (Control control : overrideConfigurationControls) {
			control.setEnabled(enabled);
			if (enabled) {
				baseConfigurationPathLabel.setText("Base configuration (optional):");
			} else {
				baseConfigurationPathLabel.setText("Simulation configuration:");
			}
		}
		Control solverConfigurationControl = getSelectedSolverConfigurationControl();
		if (solverConfigurationControl != null) {
			solverConfigurationControl.setEnabled(enabled);
		}
		updateSimulationTimeEnablement();
	}
	
	private void updateSimulationTimeEnablement() {
		simulationTimeText.setEnabled(!realTimeSimulationButton.getSelection());
	}
	
	private void updateSolverConfigurationControls() {
		StackLayout stackLayout = (StackLayout) solverConfigurationGroup.getLayout();

		Control composite = getSelectedSolverConfigurationControl();
			
		if (composite != null) {
			stackLayout.topControl = composite;
		} else {
			stackLayout.topControl = null;
		}
		
		solverConfigurationGroup.layout();
	}
	
	private Control getSelectedSolverConfigurationControl() {
		Control solverConfigurationControl = null;
		
		IStructuredSelection selection = (IStructuredSelection) solverViewer.getSelection();
		ISolverDescriptor solver = (ISolverDescriptor) selection.getFirstElement();
		if (solver != null) {
			String solverId = solver.getId();
			SolverConfigurationPage page = solverConfigurationControls.get(solverId);
			if (page == null) {
				page = createSolverConfigurationControl(solverId);
				solverConfigurationControls.put(solverId, page);
			}
			solverConfigurationControl = page.control;
		}
		
		return solverConfigurationControl;
	}
	
	private SolverConfigurationPage createSolverConfigurationControl(String solverId) {
		SolverConfigurationPage page = new SolverConfigurationPage();
		
		SelectionPropertyOption option = propertyEnumerationHelper.getSelectionPropertyOption("damos.simulation.solver", solverId);
		if (option == null) {
			Label label = new Label(solverConfigurationGroup, SWT.NONE);
			label.setText("No solver configuration found");
			page.control = label;
		} else {
			Composite composite = new Composite(solverConfigurationGroup, SWT.NONE);
			GridLayout layout = new GridLayout(2, false);
			composite.setLayout(layout);
			page.control = composite;
			
			for (PropertyDeclaration propertyDeclaration : option.getPropertyDeclarations()) {
				if (propertyDeclaration instanceof SimplePropertyDeclaration) {
					SimplePropertyDeclaration simplePropertyDeclaration = (SimplePropertyDeclaration) propertyDeclaration;
					String name = simplePropertyDeclaration.getName();
					if (name != null) {
						Label label = new Label(composite, SWT.NONE);
						label.setText(NameUtil.formatName(name) + ":");
						overrideConfigurationControls.add(label);
	
						Text text = new Text(composite, SWT.SINGLE | SWT.BORDER);
						text.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
						text.addModifyListener(new ModifyListener() {
							
							public void modifyText(ModifyEvent event) {
								updateLaunchConfigurationDialog();
							}
							
						});
						overrideConfigurationControls.add(text);
						
						page.propertyTexts.put(name, text);
					}
				}
			}
		}
		
		return page;
	}
	
	public void initializeFrom(ILaunchConfiguration launchConfiguration) {
		try {
			boolean overrideConfiguration = launchConfiguration.getAttribute(SimulationLaunchConfigurationDelegate.ATTRIBUTE__OVERRIDE_CONFIGURATION, true);

			baseConfigurationPathText.setText(launchConfiguration.getAttribute(SimulationLaunchConfigurationDelegate.ATTRIBUTE__BASE_CONFIGURATION_PATH, ""));
			overrideConfigurationButton.setSelection(overrideConfiguration);

			blockDiagramPathText.setText("");
			simulationTimeText.setText("");
			realTimeSimulationButton.setSelection(false);
			fragmentViewer.setInput(null);
			solverViewer.setSelection(null);

			if (overrideConfiguration) {
				String fragmentURIString = launchConfiguration.getAttribute(SimulationLaunchConfigurationDelegate.ATTRIBUTE__FRAGMENT, "");
				if (fragmentURIString.trim().length() > 0) {
					URI fragmentURI = URI.createURI(fragmentURIString);

					IPath blockDiagramPath = new Path(fragmentURI.toPlatformString(true));
					blockDiagramPathText.setText(blockDiagramPath.makeRelative().toString());
					
					ResourceSet resourceSet = new ResourceSetImpl();
					try {
						EObject eObject = resourceSet.getEObject(fragmentURI, true);
						if (eObject instanceof Fragment) {
							fragmentViewer.setInput(resourceSet);
							fragmentViewer.setSelection(new StructuredSelection(eObject));
						}
					} catch (RuntimeException e) {
						// Ignore invalid fragment URIs
					}
				}
				
				boolean realTimeSimulation = launchConfiguration.getAttribute(SimulationLaunchConfigurationDelegate.ATTRIBUTE__REAL_TIME_SIMULATION, false);
				realTimeSimulationButton.setSelection(realTimeSimulation);
				if (!realTimeSimulation) {
					simulationTimeText.setText(launchConfiguration.getAttribute(SimulationLaunchConfigurationDelegate.ATTRIBUTE__SIMULATION_TIME, SimulationLaunchConfigurationDelegate.DEFAULT_SIMULATION_TIME));
				}
				
				ISolverDescriptor solver = ISolverRegistry.INSTANCE.getSolver(launchConfiguration.getAttribute(SimulationLaunchConfigurationDelegate.ATTRIBUTE__SOLVER, SimulationLaunchConfigurationDelegate.DEFAULT_SOLVER_ID));
				if (solver != null) {
					solverViewer.setSelection(new StructuredSelection(solver));
					updateSolverConfigurationControls();
					SolverConfigurationPage page = solverConfigurationControls.get(solver.getId());
					if (page != null) {
						Map<?, ?> solverConfiguration = launchConfiguration.getAttribute(SimulationLaunchConfigurationDelegate.ATTRIBUTE__SOLVER_CONFIGURATION, Collections.<String, String>emptyMap());
						for (Entry<String, Text> entry : page.propertyTexts.entrySet()) {
							Object value = solverConfiguration.get(entry.getKey());
							if (value instanceof String) {
								entry.getValue().setText(value.toString());
							}
						}
					}
				}
			}

			updateControlsEnablement();
			updateSolverConfigurationControls();
		} catch (CoreException e) {
			SimulationIDEUIPlugin.getDefault().getLog().log(e.getStatus());
		}
	}

	public void performApply(ILaunchConfigurationWorkingCopy launchConfiguration) {
		String errorMessage = null;
		
		launchConfiguration.setAttribute(SimulationLaunchConfigurationDelegate.ATTRIBUTE__BASE_CONFIGURATION_PATH, baseConfigurationPathText.getText().trim());

		boolean overrideConfiguration = overrideConfigurationButton.getSelection();
		launchConfiguration.setAttribute(SimulationLaunchConfigurationDelegate.ATTRIBUTE__OVERRIDE_CONFIGURATION, overrideConfiguration);
		
		if (overrideConfiguration) {
			String blockDiagramPathString = blockDiagramPathText.getText().trim();
			if (blockDiagramPathString.length() == 0) {
				errorMessage = "No block diagram specified";
			}
			
			if (errorMessage == null) {
				ResourceSet resourceSet = new ResourceSetImpl();
				try {
					Resource resource = resourceSet.getResource(URI.createPlatformResourceURI(blockDiagramPathString, true), true);
					boolean fragmentFound = false;
					for (EObject eObject : resource.getContents()) {
						if (eObject instanceof Fragment) {
							fragmentFound = true;
							break;
						}
					}
					if (!fragmentFound) {
						errorMessage = "Specified block diagram file does not contain fragments";
					}
				} catch (RuntimeException e) {
					errorMessage = "Invalid block diagram file specified";
				}
			}
		
			if (errorMessage == null) {
				Fragment fragment = null;
				ISelection selection = fragmentViewer.getSelection();
				if (selection instanceof IStructuredSelection) {
					fragment = (Fragment) ((IStructuredSelection) selection).getFirstElement();
				}
				if (fragment != null) {
					launchConfiguration.setAttribute(SimulationLaunchConfigurationDelegate.ATTRIBUTE__FRAGMENT, EcoreUtil.getURI(fragment).toString());
				} else {
					errorMessage = "No fragment selected";
				}
	
				boolean realTimeSimulation = realTimeSimulationButton.getSelection();
				launchConfiguration.setAttribute(SimulationLaunchConfigurationDelegate.ATTRIBUTE__REAL_TIME_SIMULATION, realTimeSimulation);
				if (!realTimeSimulation) {
					String simulationTimeString = simulationTimeText.getText().trim();
					launchConfiguration.setAttribute(SimulationLaunchConfigurationDelegate.ATTRIBUTE__SIMULATION_TIME, simulationTimeString);
				}
	
				IStructuredSelection solverSelection = (IStructuredSelection) solverViewer.getSelection();
				ISolverDescriptor solver = (ISolverDescriptor) solverSelection.getFirstElement();
				if (solver != null) {
					launchConfiguration.setAttribute(SimulationLaunchConfigurationDelegate.ATTRIBUTE__SOLVER, solver.getId());
					SolverConfigurationPage page = solverConfigurationControls.get(solver.getId());
					if (page != null) {
						Map<String, String> solverConfiguration = new HashMap<String, String>();
						for (Entry<String, Text> entry : page.propertyTexts.entrySet()) {
							String text = entry.getValue().getText();
							if (text.trim().length() > 0) {
								solverConfiguration.put(entry.getKey(), text);
							}
						}
						launchConfiguration.setAttribute(SimulationLaunchConfigurationDelegate.ATTRIBUTE__SOLVER_CONFIGURATION, solverConfiguration);
					}
				} else {
					errorMessage = "No solver selected";
				}
			}
		}
		
		if (errorMessage == null) {
			try {
				LaunchConfigurationUtil.createConfiguration(launchConfiguration, propertyEnumerationHelper);
			} catch (CoreException e) {
				errorMessage = e.getStatus().getMessage();
			}
		}

		setErrorMessage(errorMessage);
	}

	public void setDefaults(ILaunchConfigurationWorkingCopy launchConfiguration) {
		Fragment fragment = null;
		IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		IEditorPart activeEditor = activePage.getActiveEditor();
		if (activeEditor != null) {
			IEditorInput editorInput = activeEditor.getEditorInput();
			if (editorInput instanceof IFileEditorInput) {
				IPath path = ((IFileEditorInput) editorInput).getFile().getFullPath();
				if (BLOCK_DIAGRAM_FILE_EXTENSION.equals(path.getFileExtension())) {
					URI uri = URI.createPlatformResourceURI(path.toString(), false);
					ResourceSet rs = new ResourceSetImpl();
					Resource r = rs.getResource(uri, true);
					fragment = (Fragment) EcoreUtil.getObjectByType(r.getContents(), DMLPackage.Literals.MODEL);
					if (fragment == null) {
						fragment = (Fragment) EcoreUtil.getObjectByType(r.getContents(), DMLPackage.Literals.FRAGMENT);
					}
				}
			}
		}
		
		LaunchConfigurationUtil.initializeLaunchConfiguration(launchConfiguration, fragment);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.AbstractLaunchConfigurationTab#dispose()
	 */
	@Override
	public void dispose() {
		ResourceSet resourceSet = propertyEnumerationHelper.getResourceSet();
		if (resourceSet != null) {
			for (Resource resource : resourceSet.getResources()) {
				resource.unload();
			}
		}
		super.dispose();
	}

	private static class SolverConfigurationPage {
	
		public Control control;
		public Map<String, Text> propertyTexts = new HashMap<String, Text>();
		
	}
	
}
