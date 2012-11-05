/*******************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Andreas Unger - initial API and implementation
 *******************************************************************************/
package org.eclipse.damos.simulation.ide.ui.internal.launch;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.damos.common.ui.dialogs.SelectFragmentDialog;
import org.eclipse.damos.dconfig.Configuration;
import org.eclipse.damos.dconfig.DconfigPackage;
import org.eclipse.damos.dconfig.util.PropertyEnumerationHelper;
import org.eclipse.damos.dml.DMLPackage;
import org.eclipse.damos.dml.Fragment;
import org.eclipse.damos.dml.util.DMLUtil;
import org.eclipse.damos.dml.util.FragmentSelectionManager;
import org.eclipse.damos.simulation.ide.core.internal.launch.SimulationLaunchConfigurationDelegate;
import org.eclipse.damos.simulation.ide.core.util.LaunchConfigurationUtil;
import org.eclipse.damos.simulation.ide.ui.SimulationIDEUIPlugin;
import org.eclipse.damos.simulation.ide.ui.internal.dialogs.SimulationLaunchConfigurationSelectionDialog;
import org.eclipse.damos.simulation.ide.ui.internal.util.LaunchShortcutUtil;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.ui.DebugUITools;
import org.eclipse.debug.ui.ILaunchShortcut2;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.RootEditPart;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PlatformUI;

public class FragmentLaunchShortcut implements ILaunchShortcut2 {

	private static final String BLOCK_DIAGRAM_FILE_EXTENSION = "blockdiagram";

	public void launch(ISelection selection, String mode) {
		Fragment fragment = getFragment(selection);
		if (fragment != null) {
			launch(fragment, mode);
		}
	}

	public void launch(IEditorPart editor, String mode) {
		Fragment fragment = getFragment(editor);
		if (fragment != null) {
			launch(fragment, mode);
		}
	}
	
	private void launch(Fragment fragment, String mode) {
		Collection<ILaunchConfiguration> launchConfigurations = getLaunchConfigurations(fragment);
		
		URI uri = EcoreUtil.getURI(fragment);
		IPath path = new Path(uri.toPlatformString(true));
		
		if (launchConfigurations.isEmpty()) {
			try {
				ILaunchManager launchManager = DebugPlugin.getDefault().getLaunchManager();
				ILaunchConfigurationType launchConfigurationType = launchManager.getLaunchConfigurationType(SimulationLaunchConfigurationDelegate.LAUNCH_CONFIGURATION_TYPE);
				
				String name = launchManager.generateLaunchConfigurationName(path.removeFileExtension().lastSegment() + " Simulation");
				ILaunchConfigurationWorkingCopy launchConfiguration = launchConfigurationType.newInstance(null, name);
				LaunchConfigurationUtil.initializeLaunchConfiguration(launchConfiguration, fragment);
				launchConfiguration.doSave();
				
				DebugUITools.launch(launchConfiguration, mode);
			} catch (CoreException e) {
				SimulationIDEUIPlugin.getDefault().getLog().log(new Status(IStatus.ERROR, SimulationIDEUIPlugin.PLUGIN_ID, 
						"Launching configuration creation failed", e));
			}
		} else {
			if (launchConfigurations.size() == 1) {
				DebugUITools.launch(launchConfigurations.iterator().next(), mode);
			} else {
				SimulationLaunchConfigurationSelectionDialog d = new SimulationLaunchConfigurationSelectionDialog(
						PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), path.toFile().getName(), launchConfigurations);
				d.open();
				if (d.getReturnCode() == Dialog.OK) {
					Object[] result = d.getResult();
					if (result.length > 0 && result[0] instanceof ILaunchConfiguration) {
						DebugUITools.launch((ILaunchConfiguration) result[0], mode);
					}
				}
			}
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchShortcut2#getLaunchConfigurations(org.eclipse.jface.viewers.ISelection)
	 */
	public ILaunchConfiguration[] getLaunchConfigurations(ISelection selection) {
		Collection<Fragment> fragments = getFragments(selection);
		List<ILaunchConfiguration> launchConfigurations = new ArrayList<ILaunchConfiguration>();
		for (Fragment fragment : fragments) {
			launchConfigurations.addAll(getLaunchConfigurations(fragment));
		}
		return LaunchShortcutUtil.toArray(launchConfigurations);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchShortcut2#getLaunchConfigurations(org.eclipse.ui.IEditorPart)
	 */
	public ILaunchConfiguration[] getLaunchConfigurations(IEditorPart editor) {
		Fragment fragment = getFragment(editor);
		if (fragment != null) {
			return LaunchShortcutUtil.toArray(getLaunchConfigurations(fragment));
		}
		return null;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchShortcut2#getLaunchableResource(org.eclipse.jface.viewers.ISelection)
	 */
	public IResource getLaunchableResource(ISelection selection) {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchShortcut2#getLaunchableResource(org.eclipse.ui.IEditorPart)
	 */
	public IResource getLaunchableResource(IEditorPart editor) {
		IEditorInput editorInput = editor.getEditorInput();
		if (editorInput instanceof IFileEditorInput) {
			return ((IFileEditorInput) editorInput).getFile();
		}
		return null;
	}

	private Collection<ILaunchConfiguration> getLaunchConfigurations(Fragment fragment) {
		URI uri = EcoreUtil.getURI(fragment);

		try {
			ILaunchManager launchManager = DebugPlugin.getDefault().getLaunchManager();
			ILaunchConfigurationType launchConfigurationType = launchManager.getLaunchConfigurationType(SimulationLaunchConfigurationDelegate.LAUNCH_CONFIGURATION_TYPE);
			if (launchConfigurationType != null) {
				List<ILaunchConfiguration> launchConfigurations = new ArrayList<ILaunchConfiguration>();
				for (ILaunchConfiguration launchConfiguration : launchManager.getLaunchConfigurations(launchConfigurationType)) {
					if (launchConfiguration.getAttribute(SimulationLaunchConfigurationDelegate.ATTRIBUTE__OVERRIDE_CONFIGURATION, true)) {
						try {
							Configuration configuration = LaunchConfigurationUtil.createConfiguration(launchConfiguration, new PropertyEnumerationHelper("damos.simulation.solver"));
							if (configuration.getContextFragment() != null && !configuration.getContextFragment().eIsProxy()) {
								URI topLevelFragmentURI = EcoreUtil.getURI(configuration.getContextFragment());
								if (topLevelFragmentURI.equals(uri)) {
									launchConfigurations.add(launchConfiguration);
								}
							}
						} catch (CoreException e) {
							SimulationIDEUIPlugin.getDefault().getLog().log(new Status(IStatus.ERROR, SimulationIDEUIPlugin.PLUGIN_ID, 
									"Loading simulation model failed", e)); 
						}
					} else {
						String configurationPathString = launchConfiguration.getAttribute(SimulationLaunchConfigurationDelegate.ATTRIBUTE__BASE_CONFIGURATION_PATH, "");
						Configuration configuration = (Configuration) EcoreUtil.getObjectByType(getResourceContents(configurationPathString), DconfigPackage.eINSTANCE.getConfiguration());
						if (configuration != null) {
							Fragment topLevelFragment = configuration.getContextFragment();
							if (topLevelFragment != null && EcoreUtil.getURI(topLevelFragment).equals(uri)) {
								launchConfigurations.add(launchConfiguration);
							}
						}
					}
				}
				return launchConfigurations;
			}
		} catch (Exception e) {
			SimulationIDEUIPlugin.getDefault().getLog().log(new Status(IStatus.ERROR, SimulationIDEUIPlugin.PLUGIN_ID, 
					"Querying launch configurations failed", e)); 
		}
		return Collections.emptyList();
	}

	private Fragment getFragment(IEditorPart editor) {
		EditPart editPart = (EditPart) editor.getAdapter(EditPart.class);
		if (editPart instanceof RootEditPart) {
			EditPart contentsEditPart = ((RootEditPart) editPart).getContents();
			if (contentsEditPart instanceof IAdaptable) {
				FragmentSelectionManager fragmentSelectionManager = (FragmentSelectionManager) ((IAdaptable) contentsEditPart).getAdapter(FragmentSelectionManager.class);
				if (fragmentSelectionManager != null) {
					Fragment selectedFragment = fragmentSelectionManager.getSelectedFragment();
					if (selectedFragment != null) {
						return selectedFragment;
					}
				}
			}
		}
		return null;
	}
	
	private Fragment getFragment(ISelection selection) {
		Collection<Fragment> fragments = getFragments(selection);
		if (fragments.size() == 1) {
			return fragments.iterator().next();
		} else if (fragments.size() > 1 && Display.getCurrent() != null) {
			Shell shell = PlatformUI.getWorkbench().getModalDialogShellProvider().getShell();
			if (shell != null) {
				return SelectFragmentDialog.open(shell, "Damos Simulation", "Select fragment to simulate:", DMLUtil.getResourceSet(fragments.iterator().next()));
			}
		}
		return null;
	}
	
	private Collection<Fragment> getFragments(ISelection selection) {
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			if (structuredSelection.size() == 1) {
				Object element = structuredSelection.getFirstElement();
				if (element instanceof Fragment) {
					return Collections.singleton((Fragment) element);
				}
				if (element instanceof IFile) {
					IFile file = (IFile) element;
					String extension = file.getFullPath().getFileExtension();
					if (BLOCK_DIAGRAM_FILE_EXTENSION.equals(extension)) {
						List<EObject> contents = getResourceContents(file);
						return EcoreUtil.getObjectsByType(contents, DMLPackage.eINSTANCE.getFragment());
					}
				}
			}
		}
		return Collections.emptyList();
	}

	private List<EObject> getResourceContents(IFile file) {
		return getResourceContents(file.getFullPath().toString());
	}

	private List<EObject> getResourceContents(String fullPath) {
		try {
			ResourceSet resourceSet = new ResourceSetImpl();
			URI uri = URI.createPlatformResourceURI(fullPath, true);
			return resourceSet.getResource(uri, true).getContents();
		} catch (Exception e) {
			SimulationIDEUIPlugin.getDefault().getLog().log(new Status(IStatus.ERROR, SimulationIDEUIPlugin.PLUGIN_ID, "Loading resource failed", e));
		}
		return Collections.emptyList();
	}

}
