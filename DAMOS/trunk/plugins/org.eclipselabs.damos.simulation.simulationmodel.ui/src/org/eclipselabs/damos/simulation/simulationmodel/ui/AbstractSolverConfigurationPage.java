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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;
import org.eclipselabs.damos.simulation.simulationmodel.SolverConfiguration;
import org.eclipselabs.damos.simulation.simulationmodel.util.SimulationModelUtil;

/**
 * @author Andreas Unger
 *
 */
public abstract class AbstractSolverConfigurationPage implements ISolverConfigurationPage {
	
	private Control control;
	private String errorMessage;
	private List<ISolverConfigurationPageChangeListener> changeListeners = new ArrayList<ISolverConfigurationPageChangeListener>();

	public final void createControl(Composite parent) {
		this.control = doCreateControl(parent);
	}

	public final Control getControl() {
		return control;
	}
	
	protected abstract Control doCreateControl(Composite parent);

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.simulationmodel.ui.ISolverConfigurationPage#getErrorMessage()
	 */
	public String getErrorMessage() {
		return errorMessage;
	}
	
	/**
	 * @param errorMessage the errorMessage to set
	 */
	protected void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.simulationmodel.ui.ISolverConfigurationPage#addChangeListener(org.eclipselabs.damos.simulation.simulationmodel.ui.ISolverConfigurationPageChangeListener)
	 */
	public void addChangeListener(ISolverConfigurationPageChangeListener l) {
		if (!changeListeners.contains(l)) {
			changeListeners.add(l);
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.simulationmodel.ui.ISolverConfigurationPage#removeChangeListener(org.eclipselabs.damos.simulation.simulationmodel.ui.ISolverConfigurationPageChangeListener)
	 */
	public void removeChangeListener(ISolverConfigurationPageChangeListener l) {
		changeListeners.remove(l);
	}
	
	protected void fireChangeEvent(SolverConfigurationPageChangeEvent changeEvent) {
		for (ISolverConfigurationPageChangeListener l : changeListeners) {
			l.solverConfigurationPageChanged(changeEvent);
		}
	}

	protected void initializeFromDoubleValueAttribute(SolverConfiguration solverConfiguration, String parameterName, Text text) {
		double value = SimulationModelUtil.getSolverArgumentDoubleValue(solverConfiguration, parameterName);
		if (!Double.isNaN(value)) {
			text.setText(Double.toString(value));
		}
	}

	protected boolean applyDoubleValueAttribute(SolverConfiguration solverConfiguration, String parameterName, Text text, String name) {
		String valueString = text.getText().trim();
		if (valueString.length() == 0) {
			return true;
		}
		try {
			double value = Double.parseDouble(valueString);
			SimulationModelUtil.setSolverArgumentValue(solverConfiguration, parameterName, value);
		} catch (NumberFormatException e) {
			setErrorMessage("Invalid " + name + " value specified");
			return false;
		}
		return true;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.simulationmodel.ui.ISolverConfigurationPage#setEnabled(boolean)
	 */
	public void setEnabled(boolean enabled) {
		getControl().setEnabled(enabled);
	}

}
