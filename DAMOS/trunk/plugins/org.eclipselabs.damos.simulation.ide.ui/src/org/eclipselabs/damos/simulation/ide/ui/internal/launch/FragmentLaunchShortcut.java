package org.eclipselabs.damos.simulation.ide.ui.internal.launch;

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
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PlatformUI;
import org.eclipselabs.damos.common.ui.dialogs.SelectFragmentDialog;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.Fragment;
import org.eclipselabs.damos.dml.util.DMLUtil;
import org.eclipselabs.damos.dml.util.FragmentSelectionManager;
import org.eclipselabs.damos.simulation.ide.core.internal.launch.SimulationLaunchConfigurationDelegate;
import org.eclipselabs.damos.simulation.ide.core.util.LaunchConfigurationUtil;
import org.eclipselabs.damos.simulation.ide.ui.SimulationIDEUIPlugin;
import org.eclipselabs.damos.simulation.ide.ui.internal.dialogs.SimulationLaunchConfigurationSelectionDialog;
import org.eclipselabs.damos.simulation.simulationmodel.SimulationModel;
import org.eclipselabs.damos.simulation.simulationmodel.SimulationModelPackage;

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
		ILaunchConfiguration[] launchConfigurations = getLaunchConfigurations(fragment);
		
		URI uri = EcoreUtil.getURI(fragment);
		IPath path = new Path(uri.toPlatformString(true));
		
		if (launchConfigurations == null) {
			try {
				ILaunchManager launchManager = DebugPlugin.getDefault().getLaunchManager();
				ILaunchConfigurationType launchConfigurationType = launchManager.getLaunchConfigurationType(SimulationLaunchConfigurationDelegate.LAUNCH_CONFIGURATION_TYPE);
				
				String name = launchManager.generateLaunchConfigurationName(path.removeFileExtension().lastSegment() + " Simulation");
				ILaunchConfigurationWorkingCopy launchConfiguration = launchConfigurationType.newInstance(null, name);
				launchConfiguration.setAttribute(SimulationLaunchConfigurationDelegate.ATTRIBUTE__CREATE_SIMULATION_MODEL, true);
				LaunchConfigurationUtil.storeSimulationModel(launchConfiguration, LaunchConfigurationUtil.createDefaultSimulationModel(fragment));
				launchConfiguration.doSave();
				
				DebugUITools.launch(launchConfiguration, mode);
			} catch (CoreException e) {
				SimulationIDEUIPlugin.getDefault().getLog().log(new Status(IStatus.ERROR, SimulationIDEUIPlugin.PLUGIN_ID, 
						"Launching configuration creation failed", e));
			}
		} else {
			if (launchConfigurations.length == 1) {
				DebugUITools.launch(launchConfigurations[0], mode);
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
		Fragment fragment = getFragment(selection);
		if (fragment != null) {
			return getLaunchConfigurations(fragment);
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchShortcut2#getLaunchConfigurations(org.eclipse.ui.IEditorPart)
	 */
	public ILaunchConfiguration[] getLaunchConfigurations(IEditorPart editor) {
		Fragment fragment = getFragment(editor);
		if (fragment != null) {
			return getLaunchConfigurations(fragment);
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

	private ILaunchConfiguration[] getLaunchConfigurations(Fragment fragment) {
		URI uri = EcoreUtil.getURI(fragment);

		try {
			ILaunchManager launchManager = DebugPlugin.getDefault().getLaunchManager();
			ILaunchConfigurationType launchConfigurationType = launchManager.getLaunchConfigurationType(SimulationLaunchConfigurationDelegate.LAUNCH_CONFIGURATION_TYPE);
			if (launchConfigurationType != null) {
				List<ILaunchConfiguration> launchConfigurations = new ArrayList<ILaunchConfiguration>();
				for (ILaunchConfiguration launchConfiguration : launchManager.getLaunchConfigurations(launchConfigurationType)) {
					if (launchConfiguration.getAttribute(SimulationLaunchConfigurationDelegate.ATTRIBUTE__CREATE_SIMULATION_MODEL, true)) {
						try {
							SimulationModel simulationModel = LaunchConfigurationUtil.loadSimulationModel(launchConfiguration);
							if (simulationModel.getTopLevelFragment() != null && !simulationModel.getTopLevelFragment().eIsProxy()) {
								URI topLevelFragmentURI = EcoreUtil.getURI(simulationModel.getTopLevelFragment());
								if (topLevelFragmentURI.equals(uri)) {
									launchConfigurations.add(launchConfiguration);
								}
							}
						} catch (CoreException e) {
							SimulationIDEUIPlugin.getDefault().getLog().log(new Status(IStatus.ERROR, SimulationIDEUIPlugin.PLUGIN_ID, 
									"Loading simulation model failed", e)); 
						}
					} else {
						String simulationModelPathString = launchConfiguration.getAttribute(SimulationLaunchConfigurationDelegate.ATTRIBUTE__SIMULATION_MODEL_PATH, "");
						SimulationModel simulationModel = (SimulationModel) EcoreUtil.getObjectByType(getResourceContents(simulationModelPathString), SimulationModelPackage.eINSTANCE.getSimulationModel());
						if (simulationModel != null) {
							Fragment topLevelFragment = simulationModel.getTopLevelFragment();
							if (topLevelFragment != null && EcoreUtil.getURI(topLevelFragment).equals(uri)) {
								launchConfigurations.add(launchConfiguration);
							}
						}
					}
				}
				if (!launchConfigurations.isEmpty()) {
					return launchConfigurations.toArray(new ILaunchConfiguration[launchConfigurations.size()]);
				}
			}
		} catch (Exception e) {
			SimulationIDEUIPlugin.getDefault().getLog().log(new Status(IStatus.ERROR, SimulationIDEUIPlugin.PLUGIN_ID, 
					"Querying launch configurations failed", e)); 
		}
		return null;
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
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			if (structuredSelection.size() == 1) {
				Object element = structuredSelection.getFirstElement();
				if (element instanceof Fragment) {
					return (Fragment) element;
				}
				if (element instanceof IFile) {
					IFile file = (IFile) element;
					String extension = file.getFullPath().getFileExtension();
					if (BLOCK_DIAGRAM_FILE_EXTENSION.equals(extension)) {
						List<EObject> contents = getResourceContents(file);
						Collection<Fragment> fragments = EcoreUtil.getObjectsByType(contents, DMLPackage.eINSTANCE.getFragment());
						if (fragments.size() == 1) {
							return fragments.iterator().next();
						} else if (fragments.size() > 1) {
							return SelectFragmentDialog.open(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), "Damos Simulation", "Select fragment to simulate:", DMLUtil.getResourceSet(fragments.iterator().next()));
						}
					}
				}
			}
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
