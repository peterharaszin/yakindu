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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;
import org.mda4e.simulation.core.ISimulationEngine;

public class YakinduLaunchConfigurationTabGroup extends
		AbstractLaunchConfigurationTabGroup {

	public YakinduLaunchConfigurationTabGroup() {
	}

	public void createTabs(final ILaunchConfigurationDialog dialog, final String mode) {
		IExtensionRegistry reg = Platform.getExtensionRegistry();
		IConfigurationElement[] engineExtensionList = reg
				.getConfigurationElementsFor(ISimulationEngine.ENGINE_EXTENSION_POINT);
		List<ILaunchConfigurationTab> tabList = new ArrayList<ILaunchConfigurationTab>();
		tabList.add(new YakinduMainTab());
		for (int i = 0; i < engineExtensionList.length; i++) {
			ILaunchConfigurationTab tab;
			try {
				tab = (AbstractLaunchConfigurationTab) engineExtensionList[i]
						.createExecutableExtension("ParameterTab");
				tabList.add(tab);
			} catch (CoreException e) {
			}
		}

		ILaunchConfigurationTab[] tabArray = new ILaunchConfigurationTab[tabList
				.size()];
		for (int i = 0; i < tabList.size(); i++) {
			tabArray[i] = tabList.get(i);
		}
		setTabs(tabArray);

	}

}
