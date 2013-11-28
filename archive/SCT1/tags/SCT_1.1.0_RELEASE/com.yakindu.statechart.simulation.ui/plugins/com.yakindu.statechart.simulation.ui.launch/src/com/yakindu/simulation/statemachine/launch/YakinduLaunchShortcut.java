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
package com.yakindu.simulation.statemachine.launch;


import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
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
import org.mda4e.simulation.core.AbstractSimulationParameterSet;
import org.mda4e.simulation.core.ISimulationEngine;

import com.yakindu.simulation.ui.launch.tabs.YakinduMainTab;

public class YakinduLaunchShortcut implements ILaunchShortcut {

	public final String CONFIG_TYPE = "com.yakindu.simulation.launchconfig.yakinduLaunchConfigurationType";
	
	public void launch(ISelection selection, String mode) {
		if (selection instanceof IStructuredSelection) {
			final IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			final Object object = structuredSelection.getFirstElement();
			if (object instanceof IAdaptable) {
				IFile file = (IFile) ((IAdaptable) object).getAdapter(IResource.class);
				launch(file, mode);
			}
		} 
	}

	public void launch(IEditorPart editor, String mode) {
		if (editor!=null && "run".equals(mode)){
			IResource resource = (IResource)editor.getEditorInput().getAdapter(IResource.class);
			if (resource==null){
				return;
			}
			
			launch ((IFile)resource, mode);
		}
	}


	protected void launch(IFile file, String mode){
		String fileName = file.getProjectRelativePath().toString();
		IExtensionRegistry reg = Platform.getExtensionRegistry();
		IConfigurationElement[] engineExtensionList = reg.getConfigurationElementsFor(ISimulationEngine.ENGINE_EXTENSION_POINT);
		for (int i=0, max = engineExtensionList.length; i<max;i++){
			IConfigurationElement launch  =engineExtensionList[i];
			String extension = launch.getAttribute("FileExtension");
			if (fileName.matches(extension)){
				launchEngine(file, mode, fileName, i);
			}
		}
	}

    private void launchEngine(IFile file, String mode, String fileName, int engineIndex) {
        ILaunchConfiguration config = null;
        final ILaunchManager launchManager = DebugPlugin.getDefault().getLaunchManager();
        final ILaunchConfigurationType configType = launchManager.getLaunchConfigurationType(
        	CONFIG_TYPE);
        ILaunchConfiguration[] configs;
        try {
        	configs = launchManager.getLaunchConfigurations(configType);
        	for (ILaunchConfiguration c : configs) {
        		String model = c.getAttribute(AbstractSimulationParameterSet.SimulationSystem, "");
        		if (fileName.equals(model)){
        			config = c;
        		}
        	}
        	if (config == null){
        	    ILaunchConfigurationWorkingCopy newConfig = configType.newInstance(null, launchManager.generateUniqueLaunchConfigurationNameFrom(file.getName()));
                newConfig.setAttribute(AbstractSimulationParameterSet.SimulationSystem, fileName);
                newConfig.setAttribute(AbstractSimulationParameterSet.InstanceNumber, 1);
                newConfig.setAttribute(YakinduMainTab.SELECTED_ENGINE, engineIndex);
                newConfig.setAttribute(YakinduMainTab.PROJECT_NAME, file.getProject().getName());
                config = newConfig.doSave();
        	}
        	if (config!= null){
        		DebugUITools.launch(config, mode);
        	}
        } catch (CoreException e) {
        	e.printStackTrace();
        }
    }
}
