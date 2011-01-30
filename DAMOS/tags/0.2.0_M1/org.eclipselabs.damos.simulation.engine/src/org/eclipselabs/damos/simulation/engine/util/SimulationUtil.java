/****************************************************************************
 * Copyright (c) 2008, 2010 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.simulation.engine.util;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.damos.execution.executiongraph.Node;
import org.eclipselabs.damos.simulation.engine.IComponentSimulationObject;
import org.eclipselabs.damos.simulation.engine.internal.ComponentSimulationObjectAdapter;
import org.eclipselabs.damos.simulation.simulationmodel.SimulationModel;

/**
 * @author Andreas Unger
 *
 */
public class SimulationUtil {

	public static long getStepCount(SimulationModel simulationModel) {
		return (long) Math.ceil(simulationModel.getSimulationTime() / simulationModel.getExecutionModel().getSampleTime()) + 1;
	}
	
	public static IComponentSimulationObject getComponentSimulationObject(Node node) {
		ComponentSimulationObjectAdapter adapter = (ComponentSimulationObjectAdapter) EcoreUtil.getAdapter(node.eAdapters(), ComponentSimulationObjectAdapter.class);
		return adapter != null ? adapter.getSimulationObject() : null;
	}
	
}
