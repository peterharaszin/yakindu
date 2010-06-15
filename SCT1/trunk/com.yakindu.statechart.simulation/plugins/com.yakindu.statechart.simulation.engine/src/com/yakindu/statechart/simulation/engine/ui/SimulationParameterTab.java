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
package com.yakindu.statechart.simulation.engine.ui;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.yakindu.simulation.engine.statechart.engine.SimulationParameterSet;
import com.yakindu.simulation.engine.statechart.nls.Messages;
import com.yakindu.simulation.engine.statechart.properties.PluginProperties;

/**
 * Allows the definition of a engine specific parameter tab, which will be shown
 * in the "Run Configuration..." view.
 * 
 * @author Philipp Richter
 */
public class SimulationParameterTab extends AbstractLaunchConfigurationTab {

	/** Defines the instance to log informations and errors. */
	private static final Logger log =
			Logger.getLogger(SimulationParameterTab.class);

	/** Defines the time scaling of the simulation. */
	private Text tTimeScaling = null;

	/** Defines the scheduler interval. */
	private Text tSchedulerInterval = null;

	/**
	 * Creates a new instance of this class.
	 */
	public SimulationParameterTab() {

	}

	/**
	 * @param parent defines the parent composite
	 */
	public void createControl(final Composite parent) {

		// Set main composite which is shown in tab
		final Composite comp = new Composite(parent, SWT.NONE);
		comp.setLayout(new GridLayout());
		setControl(comp);

		/*
		 * Yakindu Statechart Simulator group
		 * 
		 * Set composite with two columns to display all parameters of the
		 * simulation engine.
		 */
		final Group statechartGroup = new Group(comp, SWT.NONE);

		statechartGroup.setText(PluginProperties.project_name + ":");

		statechartGroup.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		final GridLayout groupLayout = new GridLayout();
		groupLayout.numColumns = 2;
		statechartGroup.setLayout(groupLayout);

		// Add all parameter controls
		createParameterControls(statechartGroup);
	}

	/**
	 * Creates all controls which are required to configure all parameters of
	 * the simulation engine.
	 * 
	 * @param parent defines the composite which contains shall be contain the
	 *            parameter controls
	 */
	private void createParameterControls(final Composite parent) {

		final GridData gd = new GridData(GridData.FILL_HORIZONTAL);

		// Add time scaling controls
		final Label lTimeScaling = new Label(parent, SWT.NONE);
		lTimeScaling.setText(Messages.SimulationParameterTab_timescaling);

		tTimeScaling = new Text(parent, SWT.BORDER | SWT.FILL | SWT.RIGHT);
		tTimeScaling.setLayoutData(gd);
		tTimeScaling
			.setToolTipText(Messages.SimulationParameterTab_timescalingtooltip);
		tTimeScaling.addModifyListener(getUpdateListener());

		// Add scheduler interval controls
		final Label lSchedulerInterval = new Label(parent, SWT.NONE);
		lSchedulerInterval
			.setText(Messages.SimulationParameterTab_schedulerinterval);

		tSchedulerInterval =
				new Text(parent, SWT.BORDER | SWT.FILL | SWT.RIGHT);
		tSchedulerInterval.setLayoutData(gd);
		tSchedulerInterval
			.setToolTipText(Messages.SimulationParameterTab_schedulerintervaltooltip);
		tSchedulerInterval.addModifyListener(getUpdateListener());
	}

	/**
	 * Provides a <code>ModifyListener</code> which calls the function
	 * {@link #updateLaunchConfigurationDialog()} if the text of a control was
	 * changed.
	 * 
	 * @return The a new <code>ModifyListener</code> implementation instance.
	 * 
	 * @see ModifyListener
	 */
	private ModifyListener getUpdateListener() {

		return new ModifyListener() {

			public void modifyText(final ModifyEvent e) {

				updateLaunchConfigurationDialog();
			}
		};
	}

	/**
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#getName()
	 */
	public String getName() {

		return PluginProperties.project_name;
	}

	/**
	 * @see org.eclipse.debug.ui.AbstractLaunchConfigurationTab#isValid(org.eclipse.debug.core.ILaunchConfiguration)
	 */
	@Override
	public boolean isValid(final ILaunchConfiguration launchConfig) {

		// Reset error message
		setErrorMessage(null);

		boolean result = false;

		result = validateTimeScaling();

		if (result) {
			result = validateSchedulerInterval();
		}

		if(result) {
			setDirty(true);
		}
		
		return result;
	}

	/**
	 * Validates the scheduler interval value.
	 * 
	 * @return The result is <code>true</code>, if the scheduler interval is
	 *         valid.
	 */
	private boolean validateSchedulerInterval() {

		boolean result = true;
		Long interval = 0l;

		if ( tSchedulerInterval.getText() != null && tSchedulerInterval.getText().trim().length() > 0) {
			try {
				interval = Long.valueOf(tSchedulerInterval.getText());
			} catch (final NumberFormatException e) {
				setErrorMessage(Messages.SimulationParameterTab_schedulerintervalerror);
				result = false;
			}
		
			// Value must be a number greater than or equal to 0, but must not be infinity
			if (Double.isInfinite(interval)) {
		
				setErrorMessage(String.format(
					Messages.SimulationParameterTab_schedulerintervalinfinityerror,
					0,
					Double.MAX_VALUE));
				result = false;
		
			} else if (interval < 0 || interval.toString().length() != tSchedulerInterval.getText().length() || Double.isNaN(interval)) {
		
				setErrorMessage(Messages.SimulationParameterTab_schedulerintervalerror);
				result = false;
			}
		}
		
		return result;
	}

	/**
	 * Validates the time scaling value.
	 * 
	 * @return The result is <code>true</code>, if the time scaling is valid.
	 */
	private boolean validateTimeScaling() {

		boolean result = true;
		double scaling = 0.0;

		if ( tTimeScaling.getText() != null && tTimeScaling.getText().trim().length() > 0) {
			try {
				scaling = Double.valueOf(tTimeScaling.getText());
			} catch (final NumberFormatException e) {
				setErrorMessage(Messages.SimulationParameterTab_timescalingerror);
				result = false;
			}
	
			// Value must be a number greater than 0.0, but must not be infinity
			if (Double.isInfinite(scaling)) {
	
				setErrorMessage(String.format(
					Messages.SimulationParameterTab_timescalinginfinityerror,
					0.0,
					Double.MAX_VALUE));
				result = false;
	
			} else if (scaling <= 0.0 || Double.isNaN(scaling)) {
	
				setErrorMessage(Messages.SimulationParameterTab_timescalingerror);
				result = false;
			}
		}

		return result;
	}

	/**
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#initializeFrom(org.eclipse.debug.core.ILaunchConfiguration)
	 */
	public void initializeFrom(final ILaunchConfiguration configuration) {

		try {

			// Time scaling
			tTimeScaling.setText(configuration.getAttribute(
				SimulationParameterSet.TIME_SCALING,
				""));
		
		} catch (final CoreException e) {
			tTimeScaling.setText("");
			if (Level.DEBUG.equals(log.getLevel())) {
				log.warn(e.getMessage());
			}
		}
		
		try {
			// Scheduler interval
			tSchedulerInterval.setText(configuration.getAttribute(
				SimulationParameterSet.SCHEDULER_INTERVAL,
				""));

		} catch (final CoreException e) {
			tSchedulerInterval.setText("");
			if (Level.DEBUG.equals(log.getLevel())) {
				log.warn(e.getMessage());
			}
		}
	}

	/**
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#performApply(org.eclipse.debug.core.ILaunchConfigurationWorkingCopy)
	 */
	public void performApply(final ILaunchConfigurationWorkingCopy configuration) {

		// Time scaling
		configuration.setAttribute(
			SimulationParameterSet.TIME_SCALING,
			tTimeScaling.getText());

		// Scheduler interval
		configuration.setAttribute(
			SimulationParameterSet.SCHEDULER_INTERVAL,
			tSchedulerInterval.getText());
	}

	/**
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#setDefaults(org.eclipse.debug.core.ILaunchConfigurationWorkingCopy)
	 */
	public void setDefaults(final ILaunchConfigurationWorkingCopy configuration) {

		// Time scaling
		configuration.setAttribute(SimulationParameterSet.TIME_SCALING, SimulationParameterSet.TIME_SCALING_DEFAULT);
		
		// Scheduler interval
		configuration.setAttribute(SimulationParameterSet.SCHEDULER_INTERVAL, SimulationParameterSet.SCHEDULER_INTERVAL_DEFAULT);
	}
}