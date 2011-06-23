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

package org.eclipselabs.damos.simulation.simulator.internal.providers;

import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.Inoutport;
import org.eclipselabs.damos.dml.Memory;
import org.eclipselabs.damos.simulation.simulator.ISimulationObject;
import org.eclipselabs.damos.simulation.simulator.ISimulationObjectProvider;
import org.eclipselabs.damos.simulation.simulator.internal.simulationobjects.InoutportSimulationObject;
import org.eclipselabs.damos.simulation.simulator.internal.simulationobjects.MemorySimulationObject;

/**
 * @author Andreas Unger
 *
 */
public class BuiltinSimulationObjectProvider implements ISimulationObjectProvider {

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.simulator.ISimulationObjectProvider#createSimulationObject(org.eclipselabs.damos.dml.Component)
	 */
	public ISimulationObject createSimulationObject(Component component) {
		if (component instanceof Inoutport) {
			return new InoutportSimulationObject();
		}
		if (component instanceof Memory) {
			return new MemorySimulationObject();
		}
		return null;
	}
	
}
