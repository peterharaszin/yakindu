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

package org.eclipselabs.damos.simulation.engine.internal.providers;

import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.Inoutport;
import org.eclipselabs.damos.simulation.engine.IComponentSimulationObject;
import org.eclipselabs.damos.simulation.engine.IComponentSimulationObjectProvider;
import org.eclipselabs.damos.simulation.engine.internal.simulationobjects.InoutportSimulationObject;

/**
 * @author Andreas Unger
 *
 */
public class InoutportSimulationObjectProvider implements IComponentSimulationObjectProvider {

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.engine.IComponentSimulationObjectProvider#createSimulationObject(org.eclipselabs.damos.dml.Component)
	 */
	public IComponentSimulationObject createSimulationObject(Component component) {
		if (component instanceof Inoutport) {
			return new InoutportSimulationObject();
		}
		return null;
	}
	
}
