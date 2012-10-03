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

package org.eclipse.damos.simulation.simulator.util;

import org.eclipse.damos.execution.Node;
import org.eclipse.damos.simulation.simulator.ISimulationObject;
import org.eclipse.damos.simulation.simulator.internal.SimulationObjectAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * @author Andreas Unger
 *
 */
public class SimulationUtil {

	public static ISimulationObject getSimulationObject(Node node) {
		SimulationObjectAdapter adapter = (SimulationObjectAdapter) EcoreUtil.getAdapter(node.eAdapters(), SimulationObjectAdapter.class);
		return adapter != null ? adapter.getSimulationObject() : null;
	}
	
}
