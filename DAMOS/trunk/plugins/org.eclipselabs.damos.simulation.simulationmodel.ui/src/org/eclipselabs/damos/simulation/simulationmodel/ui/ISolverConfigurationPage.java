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

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipselabs.damos.simulation.simulationmodel.SimulationModel;

/**
 * @author Andreas Unger
 *
 */
public interface ISolverConfigurationPage {
	
	void createControl(Composite parent);
	
	Control getControl();
	
	void initializeFrom(SimulationModel simulationModel);
	
	boolean performApply(SimulationModel simulationModel);
	
	String getErrorMessage();
	
	void addChangeListener(ISolverConfigurationPageChangeListener l);

	void removeChangeListener(ISolverConfigurationPageChangeListener l);
	
	void setEnabled(boolean enabled);
	
}
