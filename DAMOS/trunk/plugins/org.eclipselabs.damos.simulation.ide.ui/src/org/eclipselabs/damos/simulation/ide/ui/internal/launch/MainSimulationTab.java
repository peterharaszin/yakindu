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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EValidator;
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
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.Fragment;
import org.eclipselabs.damos.execution.executionmodel.ExecutionModel;
import org.eclipselabs.damos.execution.executionmodel.ExecutionModelFactory;
import org.eclipselabs.damos.simulation.ide.core.internal.launch.SimulationLaunchConfigurationDelegate;
import org.eclipselabs.damos.simulation.ide.core.util.LaunchConfigurationUtil;
import org.eclipselabs.damos.simulation.ide.ui.SimulationIDEUIPlugin;
import org.eclipselabs.damos.simulation.simulationmodel.SimulationModel;
import org.eclipselabs.damos.simulation.simulationmodel.SimulationModelFactory;
import org.eclipselabs.damos.simulation.simulationmodel.SolverConfiguration;
import org.eclipselabs.damos.simulation.simulationmodel.ui.ISolverConfigurationPage;
import org.eclipselabs.damos.simulation.simulationmodel.ui.ISolverConfigurationPageChangeListener;
import org.eclipselabs.damos.simulation.simulationmodel.ui.SolverConfigurationPageChangeEvent;
import org.eclipselabs.damos.simulation.simulationmodel.ui.registry.ISolverConfigurationPageRegistry;
import org.eclipselabs.damos.simulation.simulationmodel.util.SimulationModelValidator;
import org.eclipselabs.damos.simulation.simulator.registry.ISolverDescriptor;
import org.eclipselabs.damos.simulation.simulator.registry.ISolverRegistry;

/**
 * @author Andreas Unger
 *
 */
public class MainSimulationTab extends AbstractLaunchConfigurationTab {
	
	private static final String BLOCK_DIAGRAM_FILE_EXTENSION = "blockdiagram";
	private static final String SIMULATION_MODEL_FILE_EXTENSION = "simulationmodel";

	private Button createSimulationModelButton;
	private Text blockDiagramPathText;
	private ComboViewer fragmentViewer;
	private Text simulationTimeText;
	private ComboViewer solverViewer;
	private Group solverConfigurationGroup;
	private List<Control> createSimulationModelControls = new ArrayList<Control>();
	
	private Button useSimulationModelButton;
	private Text simulationModelPathText;
	private List<Control> useSimulationModelControls = new ArrayList<Control>();
	
	private Map<String, ISolverConfigurationPage> solverConfigurationPages = new HashMap<String, ISolverConfigurationPage>();
	
	private ISolverConfigurationPageChangeListener solverConfigurationPageChangeListener = new ISolverConfigurationPageChangeListener() {
		
		public void solverConfigurationPageChanged(SolverConfigurationPageChangeEvent event) {
			updateLaunchConfigurationDialog();
		}
		
	};
	
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
		
		int indent = UIUtil.getToggleButtonIndentInPixels(composite);
		
		createSimulationModelButton = new Button(composite, SWT.RADIO);
		createSimulationModelButton.setText("Create an in-memory simulation model for the following configuration:");
		createSimulationModelButton.setLayoutData(new GridData(GridData.FILL, GridData.BEGINNING, true, false, 3, 1));
		createSimulationModelButton.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				updateControlEnablement();
				updateLaunchConfigurationDialog();
			}

		});
		
		Label label = new Label(composite, SWT.NONE);
		GridData gridData = new GridData();
		gridData.horizontalIndent = indent;
		label.setText("Block diagram model:");
		label.setLayoutData(gridData);
		createSimulationModelControls.add(label);
		
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
				} catch (Exception e) {
					fragmentViewer.setInput(null);
				}
				updateLaunchConfigurationDialog();
			}
		});
		createSimulationModelControls.add(blockDiagramPathText);
		
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
					blockDiagramPathText.setText(((IFile) firstResult).getFullPath().toString());
				}
			}
		});
		createSimulationModelControls.add(browseButton);
		
		label = new Label(composite, SWT.NONE);
		gridData = new GridData();
		gridData.horizontalIndent = indent;
		label.setText("Fragment:");
		label.setLayoutData(gridData);
		createSimulationModelControls.add(label);

		fragmentViewer = new ComboViewer(composite, SWT.SINGLE | SWT.BORDER | SWT.READ_ONLY);
		fragmentViewer.getCombo().setLayoutData(new GridData(GridData.FILL, GridData.BEGINNING, true, false, 2, 1));
		fragmentViewer.setLabelProvider(new FragmentLabelProvider());
		fragmentViewer.setContentProvider(new FragmentListContentProvider());
		fragmentViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			
			public void selectionChanged(SelectionChangedEvent event) {
				updateLaunchConfigurationDialog();
			}
			
		});
		createSimulationModelControls.add(fragmentViewer.getControl());
		
		label = new Label(composite, SWT.NONE);
		gridData = new GridData();
		gridData.horizontalIndent = indent;
		label.setText("Simulation time (seconds):");
		label.setLayoutData(gridData);
		createSimulationModelControls.add(label);

		simulationTimeText = new Text(composite, SWT.SINGLE | SWT.BORDER);
		simulationTimeText.addModifyListener(new ModifyListener() {
			
			public void modifyText(ModifyEvent event) {
				updateLaunchConfigurationDialog();
			}
			
		});
		gridData = new GridData(GridData.FILL, GridData.BEGINNING, true, false);
		gridData.horizontalSpan = 2;
		simulationTimeText.setLayoutData(gridData);
		createSimulationModelControls.add(simulationTimeText);
		
		label = new Label(composite, SWT.NONE);
		gridData = new GridData();
		gridData.horizontalIndent = indent;
		label.setText("Solver:");
		label.setLayoutData(gridData);
		createSimulationModelControls.add(label);
	
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
		solverViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			
			public void selectionChanged(SelectionChangedEvent event) {
				updateSolverConfigurationPage();
				updateLaunchConfigurationDialog();
			}
			
		});
		solverViewer.setInput(ISolverRegistry.INSTANCE.getSolvers());
		createSimulationModelControls.add(solverViewer.getControl());
		
		solverConfigurationGroup = new Group(composite, SWT.NONE);
		solverConfigurationGroup.setText("Solver configuration");
		gridData = new GridData(GridData.FILL, GridData.BEGINNING, true, false, 3, 1);
		gridData.horizontalIndent = indent;
		solverConfigurationGroup.setLayoutData(gridData);
		StackLayout stackLayout = new StackLayout();
		stackLayout.marginWidth = 5;
		stackLayout.marginHeight = 5;
		solverConfigurationGroup.setLayout(stackLayout);
		createSimulationModelControls.add(solverConfigurationGroup);

		useSimulationModelButton = new Button(composite, SWT.RADIO);
		useSimulationModelButton.setText("Use an existing simulation model:");
		useSimulationModelButton.setLayoutData(new GridData(GridData.FILL, GridData.BEGINNING, true, false, 3, 1));
		useSimulationModelButton.addSelectionListener(new SelectionAdapter() {
		
			@Override
			public void widgetSelected(SelectionEvent e) {
				updateControlEnablement();
				updateLaunchConfigurationDialog();
			}

		});

		simulationModelPathText = new Text(composite, SWT.SINGLE | SWT.BORDER);
		gridData = new GridData(GridData.FILL, GridData.BEGINNING, true, false, 2, 1);
		gridData.horizontalIndent = indent;
		simulationModelPathText.setLayoutData(gridData);
		simulationModelPathText.addModifyListener(new ModifyListener() {
			
			public void modifyText(ModifyEvent event) {
				updateLaunchConfigurationDialog();
			}
			
		});
		useSimulationModelControls.add(simulationModelPathText);
		
		Button simulationModelBrowseButton = createPushButton(composite, "Browse...", null);
		simulationModelBrowseButton.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				FilteredResourcesSelectionDialog d = new FilteredResourcesSelectionDialog(
						composite.getShell(),
						false,
						ResourcesPlugin.getWorkspace().getRoot(),
						IResource.FILE);
				d.setInitialPattern("*." + SIMULATION_MODEL_FILE_EXTENSION);
				d.open();
				Object firstResult = d.getFirstResult();
				if (firstResult instanceof IFile) {
					simulationModelPathText.setText(((IFile) firstResult).getFullPath().toString());
				}
			}
			
		});
		useSimulationModelControls.add(simulationModelBrowseButton);
	}

	public String getName() {
		return "Main";
	}
	
	private void updateControlEnablement() {
		for (Control control : createSimulationModelControls) {
			control.setEnabled(createSimulationModelButton.getSelection());
		}
		for (Control control : useSimulationModelControls) {
			control.setEnabled(useSimulationModelButton.getSelection());
		}
		ISolverConfigurationPage page = getSelectedSolverConfigurationPage();
		if (page != null) {
			page.setEnabled(createSimulationModelButton.getSelection());
		}
	}
	
	private void updateSolverConfigurationPage() {
		StackLayout stackLayout = (StackLayout) solverConfigurationGroup.getLayout();

		ISolverConfigurationPage page = getSelectedSolverConfigurationPage();
			
		if (page != null) {
			stackLayout.topControl = page.getControl();
		} else {
			stackLayout.topControl = null;
		}
		
		solverConfigurationGroup.layout();
	}
	
	private ISolverConfigurationPage getSelectedSolverConfigurationPage() {
		ISolverConfigurationPage solverConfigurationPage = null;
		
		IStructuredSelection selection = (IStructuredSelection) solverViewer.getSelection();
		ISolverDescriptor solver = (ISolverDescriptor) selection.getFirstElement();
		if (solver != null) {
			String solverConfigurationId = solver.getConfiguration().getId();
			solverConfigurationPage = solverConfigurationPages.get(solverConfigurationId);
			if (solverConfigurationPage == null) {
				solverConfigurationPage = ISolverConfigurationPageRegistry.INSTANCE.createPage(solverConfigurationId);
				if (solverConfigurationPage != null) {
					solverConfigurationPage.createControl(solverConfigurationGroup);
					solverConfigurationPage.addChangeListener(solverConfigurationPageChangeListener);
					solverConfigurationPages.put(solverConfigurationId, solverConfigurationPage);
				}
			}
		}
		
		return solverConfigurationPage;
	}

	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			boolean createSimulationModel = configuration.getAttribute(SimulationLaunchConfigurationDelegate.ATTRIBUTE__CREATE_SIMULATION_MODEL, true);

			createSimulationModelButton.setSelection(createSimulationModel);
			useSimulationModelButton.setSelection(!createSimulationModel);
			
			blockDiagramPathText.setText("");
			fragmentViewer.setInput(null);
			simulationTimeText.setText("");
			solverViewer.setSelection(null);
			simulationModelPathText.setText("");

			if (createSimulationModel) {
				SimulationModel simulationModel = LaunchConfigurationUtil.loadSimulationModel(configuration);
				if (simulationModel != null) {
					Fragment topLevelFragment = simulationModel.getTopLevelFragment();
					if (topLevelFragment != null) {
						blockDiagramPathText.setText(topLevelFragment.eResource().getURI().toPlatformString(false));
						fragmentViewer.setInput(topLevelFragment.eResource().getResourceSet());
						fragmentViewer.setSelection(new StructuredSelection(topLevelFragment));
					}
					if (simulationModel.isSetSimulationTime()) {
						simulationTimeText.setText(Double.toString(simulationModel.getSimulationTime()));
					}
					ISolverDescriptor solver = ISolverRegistry.INSTANCE.getSolver(simulationModel.getSolverId());
					if (solver != null) {
						solverViewer.setSelection(new StructuredSelection(solver));
						updateSolverConfigurationPage();
						ISolverConfigurationPage page = solverConfigurationPages.get(solver.getConfiguration().getId());
						if (page != null) {
							page.initializeFrom(simulationModel);
						}
					}
				}
			} else {
				simulationModelPathText.setText(configuration.getAttribute(SimulationLaunchConfigurationDelegate.ATTRIBUTE__SIMULATION_MODEL_PATH, ""));
			}

			updateControlEnablement();
			updateSolverConfigurationPage();
		} catch (CoreException e) {
			SimulationIDEUIPlugin.getDefault().getLog().log(e.getStatus());
		}
	}

	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		String errorMessage = null;
		
		boolean createSimulationModelSelection = createSimulationModelButton.getSelection();
		configuration.setAttribute(SimulationLaunchConfigurationDelegate.ATTRIBUTE__CREATE_SIMULATION_MODEL, createSimulationModelSelection);
		
		if (createSimulationModelSelection) {
			SimulationModel simulationModel = SimulationModelFactory.eINSTANCE.createSimulationModel();
			ExecutionModel executionModel = ExecutionModelFactory.eINSTANCE.createExecutionModel();
			simulationModel.setExecutionModel(executionModel);

			Fragment fragment = null;
			ISelection selection = fragmentViewer.getSelection();
			if (selection instanceof IStructuredSelection) {
				fragment = (Fragment) ((IStructuredSelection) selection).getFirstElement();
			}
			if (fragment != null) {
				simulationModel.setTopLevelFragment(fragment);
			} else {
				errorMessage = "No fragment selected";
			}
			
			try {
				String simulationTimeString = simulationTimeText.getText().trim();
				if (simulationTimeString.length() > 0) {
					double simulationTime = Double.parseDouble(simulationTimeString);
					simulationModel.setSimulationTime(simulationTime);
				}
			} catch (NumberFormatException e) {
				errorMessage = "Invalid simulation time";
			}
			
			configuration.setAttribute(SimulationLaunchConfigurationDelegate.ATTRIBUTE__SIMULATION_MODEL_PATH, (String) null);
			
			IStructuredSelection solverSelection = (IStructuredSelection) solverViewer.getSelection();
			ISolverDescriptor solver = (ISolverDescriptor) solverSelection.getFirstElement();
			if (solver != null) {
				URI uri = solver.getConfiguration().getURI();
				ResourceSet resourceSet = new ResourceSetImpl();
				EObject eObject = resourceSet.getEObject(uri, true);
				if (eObject instanceof EClass) {
					EClass eClass = (EClass) eObject;
					EFactory eFactory = EPackage.Registry.INSTANCE.getEFactory(eClass.getEPackage().getNsURI());
					EObject solverConfiguration = eFactory.create(eClass);
					if (solverConfiguration instanceof SolverConfiguration) {
						simulationModel.setSolverConfiguration((SolverConfiguration) solverConfiguration);
						ISolverConfigurationPage page = solverConfigurationPages.get(solver.getConfiguration().getId());
						if (page != null) {
							if (!page.performApply(simulationModel)) {
								errorMessage = page.getErrorMessage();
							}
						}
					}
				}
				simulationModel.setSolverId(solver.getId());
			}
			
			if (errorMessage == null) {
				EValidator validator = new SimulationModelValidator();
				Map<Object, Object> context = new HashMap<Object, Object>();
				BasicDiagnostic diagnostics = new BasicDiagnostic();
				validator.validate(simulationModel, diagnostics, context);
				for (Iterator<EObject> it = simulationModel.eAllContents(); it.hasNext();) {
					validator.validate(it.next(), diagnostics, context);
				}
				if (diagnostics.getSeverity() > Diagnostic.WARNING && !diagnostics.getChildren().isEmpty()) {
					errorMessage = diagnostics.getChildren().get(0).getMessage();
				}
			}
			
			LaunchConfigurationUtil.storeSimulationModel(configuration, simulationModel);
		} else {
			configuration.setAttribute(SimulationLaunchConfigurationDelegate.ATTRIBUTE__SIMULATION_MODEL, (String) null);
			configuration.setAttribute(SimulationLaunchConfigurationDelegate.ATTRIBUTE__SIMULATION_MODEL_PATH, simulationModelPathText.getText());
		}
		
		setErrorMessage(errorMessage);
	}

	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
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
		
		configuration.setAttribute(SimulationLaunchConfigurationDelegate.ATTRIBUTE__CREATE_SIMULATION_MODEL, true);
		LaunchConfigurationUtil.storeSimulationModel(configuration, LaunchConfigurationUtil.createDefaultSimulationModel(fragment));
	}
	
}
