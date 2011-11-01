/****************************************************************************
 * Copyright (c) 2008, 2011 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.simulation.simulationmodel.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipselabs.damos.simulation.simulationmodel.SimulationModel;
import org.eclipselabs.damos.simulation.simulationmodel.SolverConfiguration;
import org.eclipselabs.damos.simulation.simulationmodel.ui.AbstractSolverConfigurationPage;
import org.eclipselabs.damos.simulation.simulationmodel.ui.SolverConfigurationPageChangeEvent;

/**
 * @author Andreas Unger
 *
 */
public class AdaptiveStepSizeSolverConfigurationPage extends AbstractSolverConfigurationPage {

	private Text minimumStepSizeText;
	private Text maximumStepSizeText;
	private Text initialStepSizeText;

	private Text absoluteToleranceText;
	private Text relativeToleranceText;

	private final ModifyListener modifyListener = new ModifyListener() {
		
		public void modifyText(ModifyEvent event) {
			fireChangeEvent(new SolverConfigurationPageChangeEvent(AdaptiveStepSizeSolverConfigurationPage.this));
		}
		
	};

	protected Control doCreateControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout(2, false);
		layout.marginWidth = 0;
		layout.marginHeight = 0;
		composite.setLayout(layout);
		
		GridData gridData;
		Label label;
		
		label = new Label(composite, SWT.NONE);
		label.setText("Minimum step size:");
		
		minimumStepSizeText = new Text(composite, SWT.SINGLE | SWT.BORDER);
		gridData = new GridData(GridData.FILL, GridData.BEGINNING, true, false);
		minimumStepSizeText.setLayoutData(gridData);
		minimumStepSizeText.addModifyListener(modifyListener);

		label = new Label(composite, SWT.NONE);
		label.setText("Maximum step size:");
		
		maximumStepSizeText = new Text(composite, SWT.SINGLE | SWT.BORDER);
		gridData = new GridData(GridData.FILL, GridData.BEGINNING, true, false);
		maximumStepSizeText.setLayoutData(gridData);
		maximumStepSizeText.addModifyListener(modifyListener);

		label = new Label(composite, SWT.NONE);
		label.setText("Initial step size:");
		
		initialStepSizeText = new Text(composite, SWT.SINGLE | SWT.BORDER);
		gridData = new GridData(GridData.FILL, GridData.BEGINNING, true, false);
		initialStepSizeText.setLayoutData(gridData);
		initialStepSizeText.addModifyListener(modifyListener);

		label = new Label(composite, SWT.NONE);
		label.setText("Absolute tolerance:");
		
		absoluteToleranceText = new Text(composite, SWT.SINGLE | SWT.BORDER);
		gridData = new GridData(GridData.FILL, GridData.BEGINNING, true, false);
		absoluteToleranceText.setLayoutData(gridData);
		absoluteToleranceText.addModifyListener(modifyListener);

		label = new Label(composite, SWT.NONE);
		label.setText("Relative tolerance:");
		
		relativeToleranceText = new Text(composite, SWT.SINGLE | SWT.BORDER);
		gridData = new GridData(GridData.FILL, GridData.BEGINNING, true, false);
		relativeToleranceText.setLayoutData(gridData);
		relativeToleranceText.addModifyListener(modifyListener);
		
		return composite;
	}

	public void initializeFrom(SimulationModel simulationModel) {
		SolverConfiguration solverConfiguration = simulationModel.getSolverConfiguration();
		initializeFromDoubleValueAttribute(solverConfiguration, "minimumStepSize", minimumStepSizeText);
		initializeFromDoubleValueAttribute(solverConfiguration, "maximumStepSize", maximumStepSizeText);
		initializeFromDoubleValueAttribute(solverConfiguration, "initialStepSize", initialStepSizeText);
		initializeFromDoubleValueAttribute(solverConfiguration, "absoluteTolerance", absoluteToleranceText);
		initializeFromDoubleValueAttribute(solverConfiguration, "relativeTolerance", relativeToleranceText);
	}

	public boolean performApply(SimulationModel simulationModel) {
		SolverConfiguration solverConfiguration = simulationModel.getSolverConfiguration();
		setErrorMessage(null);
		boolean ret = true;
		ret &= applyDoubleValueAttribute(solverConfiguration, "minimumStepSize", minimumStepSizeText, "minimum step size");
		ret &= applyDoubleValueAttribute(solverConfiguration, "maximumStepSize", maximumStepSizeText, "maximum step size");
		ret &= applyDoubleValueAttribute(solverConfiguration, "initialStepSize", initialStepSizeText, "initial step size");
		ret &= applyDoubleValueAttribute(solverConfiguration, "absoluteTolerance", absoluteToleranceText, "absolute tolerance");
		ret &= applyDoubleValueAttribute(solverConfiguration, "relativeTolerance", relativeToleranceText, "relative tolerance");
		return ret;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.simulationmodel.ui.AbstractSolverConfigurationPage#setEnabled(boolean)
	 */
	@Override
	public void setEnabled(boolean enabled) {
		for (Control control : ((Composite) getControl()).getChildren()) {
			control.setEnabled(enabled);
		}
	}

}
