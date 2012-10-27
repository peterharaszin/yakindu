/****************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipse.damos.simulation.simulator.internal.providers;

import org.eclipse.damos.dml.Component;
import org.eclipse.damos.dml.Inoutport;
import org.eclipse.damos.dml.Join;
import org.eclipse.damos.dml.Latch;
import org.eclipse.damos.dml.Memory;
import org.eclipse.damos.execution.ComponentNode;
import org.eclipse.damos.simulation.simulator.ISimulationObject;
import org.eclipse.damos.simulation.simulator.ISimulationObjectProvider;
import org.eclipse.damos.simulation.simulator.internal.simulationobjects.InoutportSimulationObject;
import org.eclipse.damos.simulation.simulator.internal.simulationobjects.JoinSimulationObject;
import org.eclipse.damos.simulation.simulator.internal.simulationobjects.LatchSimulationObject;
import org.eclipse.damos.simulation.simulator.internal.simulationobjects.MemorySimulationObject;

/**
 * @author Andreas Unger
 *
 */
public class BuiltinSimulationObjectProvider implements ISimulationObjectProvider {

	public ISimulationObject createSimulationObject(ComponentNode node) {
		Component component = node.getComponent();
		if (component instanceof Inoutport) {
			return new InoutportSimulationObject();
		}
		if (component instanceof Memory) {
			return new MemorySimulationObject();
		}
		if (component instanceof Join) {
			return new JoinSimulationObject();
		}
		if (component instanceof Latch) {
			return new LatchSimulationObject();
		}
		return null;
	}
	
}
