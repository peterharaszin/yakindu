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

package org.eclipselabs.damos.simulation.engine;

import org.eclipselabs.damos.execution.engine.IComponentExecutionInfo;
import org.eclipselabs.damos.simulation.simulationmodel.SimulationModel;

/**
 * @author Andreas Unger
 *
 */
public interface IComponentSimulationInfo extends IComponentExecutionInfo {
	
	SimulationModel getSimulationModel();
	
}
