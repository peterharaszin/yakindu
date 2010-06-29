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

package org.esmp.dsm.simulation.internal.util;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.esmp.dsm.semantic.blockdiagram.Block;
import org.esmp.dsm.simulation.SimulationAdapter;
import org.esmp.dsm.simulation.SimulationModel;

/**
 * @author Andreas Unger
 *
 */
public class SimulationUtil {

	public static SimulationModel getSimulationModel(Block block) {
		SimulationAdapter simulationAdapter = (SimulationAdapter) EcoreUtil.getAdapter(block.eAdapters(), SimulationAdapter.class);
		if (simulationAdapter != null) {
			return simulationAdapter.getSimulationModel();
		}
		return null;
	}
	
}
