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

package org.eclipselabs.damos.simulation.simulationmodel.ui.internal;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipselabs.damos.simulation.simulationmodel.FixedStepSizeSolverConfiguration;
import org.eclipselabs.damos.simulation.simulationmodel.SimulationModel;
import org.eclipselabs.damos.simulation.simulationmodel.SimulationModelPackage;
import org.eclipselabs.damos.simulation.simulationmodel.SolverConfiguration;
import org.eclipselabs.damos.simulation.simulationmodel.ui.AbstractSolverConfigurationPage;
import org.eclipselabs.damos.simulation.simulationmodel.ui.SolverConfigurationPageChangeEvent;

/**
 * @author Andreas Unger
 *
 */
public class FixedStepSizeSolverConfigurationPage extends AbstractSolverConfigurationPage {

	private Text stepSizeText;
	
	private final ModifyListener modifyListener = new ModifyListener() {
		
		public void modifyText(ModifyEvent event) {
			fireChangeEvent(new SolverConfigurationPageChangeEvent(FixedStepSizeSolverConfigurationPage.this));
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
		label.setText("Step size:");
		
		stepSizeText = new Text(composite, SWT.SINGLE | SWT.BORDER);
		gridData = new GridData(GridData.FILL, GridData.BEGINNING, true, false);
		stepSizeText.setLayoutData(gridData);
		stepSizeText.addModifyListener(modifyListener);
		
		return composite;
	}

	public void initializeFrom(SimulationModel simulationModel) {
		SolverConfiguration solverConfiguration = simulationModel.getSolverConfiguration();
		initializeFromDoubleValueAttribute(solverConfiguration, SimulationModelPackage.eINSTANCE.getFixedStepSizeSolverConfiguration_StepSize(), stepSizeText);
	}

	public boolean performApply(SimulationModel simulationModel) {
		FixedStepSizeSolverConfiguration solverConfiguration = (FixedStepSizeSolverConfiguration) simulationModel.getSolverConfiguration();
		setErrorMessage(null);
		boolean ret = true;
		SimulationModelPackage p = SimulationModelPackage.eINSTANCE;
		ret &= applyDoubleValueAttribute(solverConfiguration, p.getFixedStepSizeSolverConfiguration_StepSize(), stepSizeText, "step size");
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
