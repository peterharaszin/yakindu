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

import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.TimingKind;
import org.eclipselabs.damos.dmltext.MscriptBlockType;
import org.eclipselabs.damos.simulation.simulator.ISimulationObject;
import org.eclipselabs.damos.simulation.simulator.ISimulationObjectProvider;
import org.eclipselabs.damos.simulation.simulator.internal.simulationobjects.BehavioredBlockSimulationObject;
import org.eclipselabs.damos.simulation.simulator.internal.simulationobjects.ContinuousBlockSimulationObject;

/**
 * @author Andreas Unger
 *
 */
public class BehavioredBlockSimulationObjectProvider implements ISimulationObjectProvider {

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.simulator.ISimulationObjectProvider#createSimulationObject(org.eclipselabs.damos.dml.Component)
	 */
	public ISimulationObject createSimulationObject(Component component) {
		if (component instanceof Block) {
			Block block = (Block) component;
			if (block.getType() instanceof MscriptBlockType) {
				MscriptBlockType blockType = (MscriptBlockType) block.getType();
				if (!blockType.getDeclarations().isEmpty()) {
					if (blockType.getTiming() == TimingKind.CONTINUOUS) {
						return new ContinuousBlockSimulationObject();
					}
					return new BehavioredBlockSimulationObject();
				}
			}
		}
		return null;
	}
	
}
