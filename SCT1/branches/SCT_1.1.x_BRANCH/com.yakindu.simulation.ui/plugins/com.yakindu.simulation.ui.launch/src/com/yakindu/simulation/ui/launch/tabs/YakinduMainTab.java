/**
 * Copyright (c) 2010 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package com.yakindu.simulation.ui.launch.tabs;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.mda4e.simulation.core.AbstractSimulationParameterSet;
import org.mda4e.simulation.core.ISimulationEngine;

import com.yakindu.simulation.ui.launch.dialogs.FilteredFileSelectionDialog;
import com.yakindu.simulation.ui.launch.providers.ProjectLabelProvider;

public class YakinduMainTab extends AbstractLaunchConfigurationTab {

	public static final String PROJECT_NAME = "PROJECT_NAME";
	public static final String SELECTED_ENGINE = "SELECTED_ENGINE";
	private static final String BLOCK_SYSTEM = AbstractSimulationParameterSet.SimulationSystem;

	private static final String ENGINE_EXTENSION_POINT = ISimulationEngine.ENGINE_EXTENSION_POINT;

	private IConfigurationElement[] engineExtensionList;
	private IProject project;
	private IFile file;
	private Combo cmbEngine;
	private Label lblProject;
	private Label lblFile;
	private Button btnSelectProject;
	private Button btnSelectFile;
	// private Button btnRealtime;
	// private Text txtSimulationTime;
	// private Text txtSimulationStepSize;
	private TabListener listener;
	private Pattern fileExtension;

	public YakinduMainTab() {
		super();
		IExtensionRegistry reg = Platform.getExtensionRegistry();
		engineExtensionList = reg
				.getConfigurationElementsFor(ENGINE_EXTENSION_POINT);
		project = null;
		file = null;
		listener = new TabListener();
	}

	public void createControl(final Composite parent) {
		Composite comp = new Composite(parent, SWT.NONE);
		setControl(comp);
		GridLayout topLayout = new GridLayout();
		comp.setLayout(topLayout);
		GridData gd;

		createProjectEditor(comp);

		createFileEditor(comp);

		Composite parametersComp = new Composite(comp, SWT.NONE);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		parametersComp.setLayoutData(gd);
		GridLayout parametersLayout = new GridLayout();
		parametersLayout.numColumns = 2;
		// parametersLayout.marginHeight = 0;
		// parametersLayout.marginWidth = 0;
		parametersComp.setLayout(parametersLayout);

		Label lblSimulationEngine = new Label(parametersComp, SWT.NONE);
		lblSimulationEngine.setText("Simulation engine:");
		cmbEngine = new Combo(parametersComp, SWT.READ_ONLY);
		for (int i = 0; i < engineExtensionList.length; i++) {
			IConfigurationElement element = engineExtensionList[i];
			if (element.getAttribute("Name") != null) {
				cmbEngine.add(element.getAttribute("Name"));
			}
		}
		cmbEngine.setEnabled(true);
		cmbEngine.addSelectionListener(listener);
		cmbEngine.select(0);
		if (cmbEngine.getSelectionIndex() != -1) {
			String extension = engineExtensionList[cmbEngine.getSelectionIndex()]
								.getAttribute("FileExtension");
			if (extension != null) {
				fileExtension = Pattern.compile(extension);
			}
		}
		/*
		 * Label lblSimulationTime = new Label(parametersComp, SWT.NONE);
		 * lblSimulationTime.setText("Simulation time (s):"); txtSimulationTime
		 * = new Text(parametersComp, SWT.BORDER);
		 * txtSimulationTime.setToolTipText(
		 * "Enter the simulation time in seconds. Enter \"-1\" for endless simulation."
		 * ); txtSimulationTime.addModifyListener(listener);
		 * 
		 * Label lblSimulationStepSize = new Label(parametersComp, SWT.NONE);
		 * lblSimulationStepSize.setText("Simulation step size (ms):");
		 * txtSimulationStepSize = new Text(parametersComp, SWT.BORDER);
		 * txtSimulationStepSize
		 * .setToolTipText("Enter the simulation step size in milliseconds.");
		 * txtSimulationStepSize.addModifyListener(listener);
		 * 
		 * Label lblRealtime = new Label(parametersComp, SWT.NONE);
		 * lblRealtime.setText("Realtime simulation:"); btnRealtime = new
		 * Button(parametersComp, SWT.CHECK);btnRealtime.setToolTipText(
		 * "Simulation will be calculated in realtime if selected.");
		 * btnRealtime.addSelectionListener(listener);
		 */
	}

	public String getName() {
		return "Global Simulation Settings";
	}

	public void initializeFrom(final ILaunchConfiguration configuration) {
		try {
			String projectName = configuration.getAttribute(PROJECT_NAME, "");
			if (!projectName.equals("")) {
				project = this.getWorkspaceRoot().getProject(projectName);
			}
			lblProject.setText(projectName);
			// lblProject.setText(configuration.getAttribute(PROJECT_NAME, ""));
			String model = configuration.getAttribute(BLOCK_SYSTEM, "");
			if(!model.equals(""))
			{
				file = project.getFile(Path.fromOSString(model));
				lblFile.setText(file.getProjectRelativePath().toOSString());
			}
			cmbEngine.select(configuration.getAttribute(SELECTED_ENGINE, 0));
			// txtSimulationTime.setText(Integer.toString(configuration.getAttribute(SIMULATION_TIME,
			// 10)));
			// txtSimulationStepSize.setText(Integer.toString(configuration.getAttribute(SIMULATION_STEP_SIZE,
			// 100)));
			// btnRealtime.setSelection(configuration.getAttribute(REALTIME,
			// false));
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	public void performApply(final ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(PROJECT_NAME, lblProject.getText());
		configuration.setAttribute(BLOCK_SYSTEM, file != null ? file.getProjectRelativePath().toOSString() : "");
		configuration.setAttribute(SELECTED_ENGINE, (Integer) cmbEngine
				.getSelectionIndex());
		// configuration.setAttribute(SIMULATION_TIME,
		// Integer.valueOf(txtSimulationTime.getText()));
		// configuration.setAttribute(SIMULATION_STEP_SIZE,
		// Integer.valueOf(txtSimulationStepSize.getText()));
		// configuration.setAttribute(REALTIME, btnRealtime.getSelection());
	}

	public void setDefaults(final ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(PROJECT_NAME, "");
		configuration.setAttribute(BLOCK_SYSTEM, "");
		configuration.setAttribute(SELECTED_ENGINE, 0);
		// configuration.setAttribute(SIMULATION_TIME, 10);
		// configuration.setAttribute(SIMULATION_STEP_SIZE, 100);
		// configuration.setAttribute(REALTIME, false);
	}

	@Override
	public boolean isValid(final ILaunchConfiguration launchConfig) {
		setErrorMessage(null);
		String text = lblProject.getText().trim();
		if (text == null || text.equals("")) {
			setErrorMessage("Select a project.");
			return false;
		} else if (!project.isAccessible()) {
			setErrorMessage("Specified project is closed or does not exist in the workspace.");
			return false;
		}
		text = lblFile.getText().trim();

		if (text == null || text == "") {
			setErrorMessage("Select a file.");
			return false;
		} else if (!fileExtension.matcher(text.toLowerCase()).matches()) {
			setErrorMessage("Selected file is not a system file for the selected engine.");
			return false;
		}
		/*
		 * try { int value =
		 * Integer.parseInt(txtSimulationTime.getText().trim()); if ((value <
		 * -1) || (value == 0)) {setErrorMessage(
		 * "Simulation time should be larger than 0 or -1 for endless simulation."
		 * ); return false; } } catch(NumberFormatException nfe) {
		 * setErrorMessage("Simulation time is not a valid integer value.");
		 * return false; }
		 * 
		 * try { int value =
		 * Integer.parseInt(txtSimulationStepSize.getText().trim()); if (value
		 * <= 0) {
		 * setErrorMessage("Simulation step size time should be larger than 0."
		 * ); return false; } } catch(NumberFormatException nfe) {
		 * setErrorMessage
		 * ("Simulation step size is not a valid integer value."); return false;
		 * }
		 */
		return true;
	}

	private void createProjectEditor(final Composite parent) {
		Group ressourceGroup = new Group(parent, SWT.NONE);
		ressourceGroup.setText("Project:");
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		ressourceGroup.setLayoutData(gd);

		GridLayout ressourceLayout = new GridLayout();
		ressourceLayout.numColumns = 2;
		ressourceGroup.setLayout(ressourceLayout);

		lblProject = new Label(ressourceGroup, SWT.BORDER);
		lblProject.setLayoutData(gd);

		btnSelectProject = new Button(ressourceGroup, SWT.PUSH);
		btnSelectProject.setText("Choose...");
		btnSelectProject.addSelectionListener(listener);
	}

	private IProject chooseProject() {
		ElementListSelectionDialog dialog = new ElementListSelectionDialog(
				getShell(), new ProjectLabelProvider());
		dialog.setTitle("Project Selection");
		dialog.setMessage("Select a project to constrain your search:");
		IProject[] projects = getWorkspaceRoot().getProjects();
		List<IProject> openProjects = new LinkedList<IProject>();
		for (IProject i : projects) {
			if (i.isOpen()) {
				openProjects.add(i);
			}
		}
		dialog.setElements(openProjects.toArray(new IProject[openProjects
				.size()]));

		if (dialog.open() == Window.OK) {
			return (IProject) dialog.getFirstResult();
		}
		return null;
	}

	private void createFileEditor(final Composite parent) {
		Group ressourceGroup = new Group(parent, SWT.NONE);
		ressourceGroup.setText("Model-File:");
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		ressourceGroup.setLayoutData(gd);

		GridLayout ressourceLayout = new GridLayout();
		ressourceLayout.numColumns = 2;
		ressourceGroup.setLayout(ressourceLayout);

		lblFile = new Label(ressourceGroup, SWT.BORDER);
		lblFile.setLayoutData(gd);

		btnSelectFile = new Button(ressourceGroup, SWT.PUSH);
		btnSelectFile.setText("Choose...");
		btnSelectFile.addSelectionListener(listener);
	}

	private IFile chooseFile() {
		if (fileExtension != null && project != null) {
			FilteredFileSelectionDialog dialog = new FilteredFileSelectionDialog(
					getShell(), project, IResource.DEPTH_INFINITE
							| IResource.FILE, fileExtension);

			if (dialog.open() == Window.OK) {
				if (dialog.getResult()[0] instanceof IFile) {
					return (IFile) dialog.getResult()[0];
				}
			}
		}
		return null;
	}

	/**
	 * Convenience method to get the workspace root.
	 */
	protected IWorkspaceRoot getWorkspaceRoot() {
		return ResourcesPlugin.getWorkspace().getRoot();
	}

	private class TabListener extends SelectionAdapter implements
			ModifyListener {

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.
		 * events.ModifyEvent)
		 */
		public void modifyText(final ModifyEvent e) {
			updateLaunchConfigurationDialog();
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse
		 * .swt.events.SelectionEvent)
		 */
		public void widgetSelected(final SelectionEvent e) {
			Object source = e.getSource();
			if (source == cmbEngine) {
				String extension = engineExtensionList[cmbEngine
									.getSelectionIndex()].getAttribute("FileExtension");
				if (extension != null) {
					fileExtension = Pattern.compile(extension);
				}
				updateLaunchConfigurationDialog();
			} else if (source == btnSelectProject) {
				IProject choosen = chooseProject();
				if (choosen != null) {
					project = choosen;
					lblProject.setText(project.getName());
				} else {
					lblProject.setText("");
				}

				updateLaunchConfigurationDialog();
			} else if (source == btnSelectFile) {
				if (project != null) {
					file = chooseFile();
					if (file != null) {
						lblFile.setText(file.getProjectRelativePath().toOSString());
					}
					updateLaunchConfigurationDialog();
				}
			} /*
			 * else if (source == btnRealtime) {
			 * updateLaunchConfigurationDialog(); }
			 */
		}
	}
} // YakinduMainTab
