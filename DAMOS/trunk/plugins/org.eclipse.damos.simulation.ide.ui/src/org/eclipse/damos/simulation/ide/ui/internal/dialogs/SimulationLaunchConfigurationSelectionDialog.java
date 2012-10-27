/****************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipse.damos.simulation.ide.ui.internal.dialogs;

import java.util.Collection;

import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ListDialog;

/**
 * @author Andreas Unger
 *
 */
public class SimulationLaunchConfigurationSelectionDialog extends ListDialog {

	private ILabelProvider labelProvider = new LabelProvider() {
		
		public String getText(Object element) {
			if (element instanceof ILaunchConfiguration) {
				return ((ILaunchConfiguration) element).getName();
			}
			return null;
		}
		
	};
	
	/**
	 * @param parentShell
	 */
	public SimulationLaunchConfigurationSelectionDialog(Shell parentShell, String name, Collection<ILaunchConfiguration> launchConfigurations) {
		super(parentShell);
		setLabelProvider(labelProvider);
		setContentProvider(new ArrayContentProvider());
		setInput(launchConfigurations);
		setTitle("Run As");
		setMessage("Select a launch configuration to simulate '" + name + "':");
	}

}
