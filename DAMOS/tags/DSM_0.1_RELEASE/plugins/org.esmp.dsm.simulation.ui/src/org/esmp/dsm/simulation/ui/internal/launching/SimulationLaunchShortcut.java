package org.esmp.dsm.simulation.ui.internal.launching;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.ui.DebugUITools;
import org.eclipse.debug.ui.ILaunchShortcut2;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PlatformUI;
import org.esmp.dsm.simulation.internal.launching.SimulationLaunchConfigurationDelegate;
import org.esmp.dsm.simulation.ui.DSMSimulatorUIPlugin;
import org.esmp.dsm.simulation.ui.internal.dialogs.SimulationLaunchConfigurationSelectionDialog;

public class SimulationLaunchShortcut implements ILaunchShortcut2 {

	public void launch(ISelection selection, String mode) {
		if (selection instanceof IStructuredSelection) {
			Object firstElement = ((IStructuredSelection) selection).getFirstElement();
			if (firstElement instanceof IFile) {
				launch(((IFile) firstElement).getFullPath(), mode);
			}
		}
	}

	public void launch(IEditorPart editor, String mode) {
		IEditorInput editorInput = editor.getEditorInput();
		if (editorInput instanceof IFileEditorInput) {
			IPath editorInputPath = ((IFileEditorInput) editorInput).getFile().getFullPath();
			launch(editorInputPath, mode);
		}
	}
	
	private void launch(IPath path, String mode) {
		ILaunchConfiguration[] launchConfigurations = getLaunchConfigurations(path);
		if (launchConfigurations == null) {
			try {
				ILaunchManager launchManager = DebugPlugin.getDefault().getLaunchManager();
				ILaunchConfigurationType launchConfigurationType = launchManager.getLaunchConfigurationType(SimulationLaunchConfigurationDelegate.LAUNCH_CONFIGURATION_TYPE);
				
				String name = launchManager.generateUniqueLaunchConfigurationNameFrom(path.removeFileExtension().lastSegment());
				ILaunchConfigurationWorkingCopy launchConfiguration = launchConfigurationType.newInstance(null, name);
				launchConfiguration.setAttribute(SimulationLaunchConfigurationDelegate.ATTRIBUTE__BLOCK_DIAGRAM_PATH, path.toString());
				launchConfiguration.doSave();
				
				DebugUITools.launch(launchConfiguration, mode);
			} catch (CoreException e) {
				DSMSimulatorUIPlugin.getDefault().getLog().log(new Status(IStatus.ERROR, DSMSimulatorUIPlugin.PLUGIN_ID, 
						"Launching configuration creation failed", e));
			}
		} else {
			if (launchConfigurations.length == 1) {
				DebugUITools.launch(launchConfigurations[0], mode);
			} else {
				SimulationLaunchConfigurationSelectionDialog d = new SimulationLaunchConfigurationSelectionDialog(
						PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), path, launchConfigurations);
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
		if (selection instanceof IStructuredSelection) {
			Object firstElement = ((IStructuredSelection) selection).getFirstElement();
			if (firstElement instanceof IFile) {
				return getLaunchConfigurations(((IFile) firstElement).getFullPath());
			}
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchShortcut2#getLaunchConfigurations(org.eclipse.ui.IEditorPart)
	 */
	public ILaunchConfiguration[] getLaunchConfigurations(IEditorPart editorpart) {
		IEditorInput editorInput = editorpart.getEditorInput();
		if (editorInput instanceof IFileEditorInput) {
			IPath editorInputPath = ((IFileEditorInput) editorInput).getFile().getFullPath();
			return getLaunchConfigurations(editorInputPath);
		}
		return null;
	}
	
	private ILaunchConfiguration[] getLaunchConfigurations(IPath path) {
		try {
			ILaunchManager launchManager = DebugPlugin.getDefault().getLaunchManager();
			ILaunchConfigurationType launchConfigurationType = launchManager.getLaunchConfigurationType(SimulationLaunchConfigurationDelegate.LAUNCH_CONFIGURATION_TYPE);
			if (launchConfigurationType != null) {
				List<ILaunchConfiguration> launchConfigurations = new ArrayList<ILaunchConfiguration>();
				for (ILaunchConfiguration launchConfiguration : launchManager.getLaunchConfigurations(launchConfigurationType)) {
					String blockDiagramPath = launchConfiguration.getAttribute(SimulationLaunchConfigurationDelegate.ATTRIBUTE__BLOCK_DIAGRAM_PATH, "");
					if (blockDiagramPath.length() > 0 && new Path(blockDiagramPath).equals(path)) {
						launchConfigurations.add(launchConfiguration);
					}
				}
				if (!launchConfigurations.isEmpty()) {
					return launchConfigurations.toArray(new ILaunchConfiguration[launchConfigurations.size()]);
				}
			}
		} catch (Exception e) {
			DSMSimulatorUIPlugin.getDefault().getLog().log(new Status(IStatus.ERROR, DSMSimulatorUIPlugin.PLUGIN_ID, 
					"Launching block diagram simulation failed", e)); 
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
	public IResource getLaunchableResource(IEditorPart editorpart) {
		return null;
	}

}
