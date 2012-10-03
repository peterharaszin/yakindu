package org.eclipse.damos.simulation.ide.ui.internal.launch;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.damos.dconfig.Configuration;
import org.eclipse.damos.dconfig.DconfigPackage;
import org.eclipse.damos.simulation.ide.core.internal.launch.SimulationLaunchConfigurationDelegate;
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
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PlatformUI;

public class ConfigurationLaunchShortcut implements ILaunchShortcut2 {

	private static final String SIMULATION_MODEL_FILE_EXTENSION = "dconfig";
	
	public void launch(ISelection selection, String mode) {
		Configuration configuration = getConfiguration(selection);
		if (configuration != null) {
			launch(configuration, mode);
		}
	}

	public void launch(IEditorPart editor, String mode) {
		IFile file = getLaunchableResource(editor);
		if (file != null) {
			Configuration configuration = getConfiguration(file);
			if (configuration != null) {
				launch(configuration, mode);
			}
		}
	}
	
	private void launch(Configuration configuration, String mode) {
		Collection<ILaunchConfiguration> launchConfigurations = getLaunchConfigurations(configuration);
		
		URI uri = EcoreUtil.getURI(configuration);
		IPath path = new Path(uri.toPlatformString(true));
		
		if (launchConfigurations.isEmpty()) {
			try {
				ILaunchManager launchManager = DebugPlugin.getDefault().getLaunchManager();
				ILaunchConfigurationType launchConfigurationType = launchManager.getLaunchConfigurationType(SimulationLaunchConfigurationDelegate.LAUNCH_CONFIGURATION_TYPE);
				
				String name = launchManager.generateLaunchConfigurationName(path.removeFileExtension().lastSegment() + " Simulation");
				ILaunchConfigurationWorkingCopy launchConfiguration = launchConfigurationType.newInstance(null, name);
				launchConfiguration.setAttribute(SimulationLaunchConfigurationDelegate.ATTRIBUTE__OVERRIDE_CONFIGURATION, false);
				launchConfiguration.setAttribute(SimulationLaunchConfigurationDelegate.ATTRIBUTE__BASE_CONFIGURATION_PATH, path.makeRelative().toString());
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
		Configuration configuration = getConfiguration(selection);
		if (configuration != null) {
			return LaunchShortcutUtil.toArray(getLaunchConfigurations(configuration));
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchShortcut2#getLaunchConfigurations(org.eclipse.ui.IEditorPart)
	 */
	public ILaunchConfiguration[] getLaunchConfigurations(IEditorPart editor) {
		IFile file = getLaunchableResource(editor);
		if (file != null) {
			Configuration configuration = getConfiguration(file);
			if (configuration != null) {
				return LaunchShortcutUtil.toArray(getLaunchConfigurations(configuration));
			}
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
	public IFile getLaunchableResource(IEditorPart editor) {
		IEditorInput editorInput = editor.getEditorInput();
		if (editorInput instanceof IFileEditorInput) {
			return ((IFileEditorInput) editorInput).getFile();
		}
		return null;
	}

	private Collection<ILaunchConfiguration> getLaunchConfigurations(Configuration configuration) {
		try {
			ILaunchManager launchManager = DebugPlugin.getDefault().getLaunchManager();
			ILaunchConfigurationType launchConfigurationType = launchManager.getLaunchConfigurationType(SimulationLaunchConfigurationDelegate.LAUNCH_CONFIGURATION_TYPE);
			if (launchConfigurationType != null) {
				URI uri = EcoreUtil.getURI(configuration);
				IPath path = new Path(uri.toPlatformString(true));

				List<ILaunchConfiguration> launchConfigurations = new ArrayList<ILaunchConfiguration>();
				for (ILaunchConfiguration launchConfiguration : launchManager.getLaunchConfigurations(launchConfigurationType)) {
					if (!launchConfiguration.getAttribute(SimulationLaunchConfigurationDelegate.ATTRIBUTE__OVERRIDE_CONFIGURATION, true)) {
						String pathString = launchConfiguration.getAttribute(SimulationLaunchConfigurationDelegate.ATTRIBUTE__BASE_CONFIGURATION_PATH, "");
						if (pathString.trim().length() > 0 && path.equals(new Path(pathString).makeAbsolute())) {
							launchConfigurations.add(launchConfiguration);
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

	private Configuration getConfiguration(ISelection selection) {
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			if (structuredSelection.size() == 1) {
				Object element = structuredSelection.getFirstElement();
				if (element instanceof Configuration) {
					return (Configuration) element;
				}
				if (element instanceof IFile) {
					return getConfiguration((IFile) element);
				}
			}
		}
		return null;
	}
	
	private Configuration getConfiguration(IFile file) {
		String extension = file.getFullPath().getFileExtension();
		if (SIMULATION_MODEL_FILE_EXTENSION.equals(extension)) {
			List<EObject> contents = getResourceContents(file);
			return (Configuration) EcoreUtil.getObjectByType(contents, DconfigPackage.eINSTANCE.getConfiguration());
		}
		return null;
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
