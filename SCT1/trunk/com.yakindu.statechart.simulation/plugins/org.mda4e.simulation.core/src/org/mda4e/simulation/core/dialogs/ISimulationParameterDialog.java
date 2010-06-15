/**
 * Copyright (c) 2006-2009 committers of mda4e and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of mda4e (http://www.mda4e.org/) - initial API and implementation
 *
 */
package org.mda4e.simulation.core.dialogs;

import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.swt.widgets.Composite;

public interface ISimulationParameterDialog {
	/**
	 * Creates the top level control for this parameter dialog
	 * under the given parent composite. This method is called
	 * once on dialog creation.
	 * 
	 * <p>
	 * Implementors are responsible for ensuring that
	 * the created control can be accessed via <code>getControl</code>
	 * </p>
	 *
	 * @param parent the parent composite
	 */
	public void createControl(Composite parent);
	
	/**
	 * Returns the name of this dialog.
	 * 
	 * @return the name of this dialog
	 */
	public String getName();
	
	/**
	 * Initializes this dialog's controls with values from the given
	 * launch configuration. This method is called when
	 * a configuration is selected to view or edit, after this
	 * dialog's control has been created.
	 * 
	 * @param configuration launch configuration
	 */
	public void initializeFrom(ILaunchConfiguration configuration);
	
	/**
	 * Copies values from this dialog into the given 
	 * launch configuration.
	 * 
	 * @param configuration launch configuration
	 */
	public void performApply(ILaunchConfigurationWorkingCopy configuration);
	
	/**
	 * Initializes the given launch configuration with
	 * default values for this dialog. This method
	 * is called when a new launch configuration is created
	 * such that the configuration can be initialized with
	 * meaningful values. This method may be called before this
	 * dialogs's control is created.
	 * 
	 * @param configuration launch configuration
	 */
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration);
	
	/**
	 * Returns whether this dialog is in a valid state in the context of the specified launch configuration.
	 * <p>
	 * This information is typically used by the launch configuration
	 * dialog to decide when it is okay to launch.
	 * </p>
	 *
	 * @param launchConfig launch configuration which provides context for validating this dialog.
	 *         This value must not be <code>null</code>.
	 *
	 * @return whether this dialog is in a valid state
	 */
	public boolean isValid(ILaunchConfiguration launchConfig);
}
