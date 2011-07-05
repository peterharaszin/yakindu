/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.ui.simulation.launch;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.ui.DebugUITools;
import org.eclipse.debug.ui.ILaunchShortcut;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.yakindu.sct.core.simulation.launch.IStatechartLaunchConfigurationType;

/**
 * 
 * @author andreas muelder
 * 
 */
public class StatechartLaunchShortcut implements ILaunchShortcut,
		IStatechartLaunchConfigurationType {

	public void launch(ISelection selection, String mode) {
		if (selection instanceof IStructuredSelection) {
			final IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			final Object object = structuredSelection.getFirstElement();
			if (object instanceof IAdaptable) {
				IFile file = (IFile) ((IAdaptable) object)
						.getAdapter(IResource.class);
				launch(file, mode);
			}
		}
	}

	public void launch(IEditorPart editor, String mode) {
		IResource resource = (IResource) editor.getEditorInput().getAdapter(
				IResource.class);
		launch((IFile) resource, mode);
	}

	protected void launch(IFile file, String mode) {
		// TODO: Check for existing launch configuration
		ILaunchConfiguration launchConfiguration = createNewLaunchConfiguration(file);
		DebugUITools.launch(launchConfiguration, mode);
	}

	private ILaunchConfiguration createNewLaunchConfiguration(IFile file) {
		final ILaunchManager launchManager = DebugPlugin.getDefault()
				.getLaunchManager();
		final ILaunchConfigurationType configType = launchManager
				.getLaunchConfigurationType(CONFIG_TYPE);
		try {
			ILaunchConfigurationWorkingCopy newConfig = configType.newInstance(
					null, launchManager.generateLaunchConfigurationName(file
							.getName()));
			return newConfig.doSave();
		} catch (CoreException e) {
			e.printStackTrace();
		}
		throw new IllegalStateException();
	}

}
