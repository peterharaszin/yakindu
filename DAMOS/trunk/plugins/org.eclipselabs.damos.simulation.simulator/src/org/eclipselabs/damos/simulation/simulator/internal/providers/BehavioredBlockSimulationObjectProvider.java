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
import org.eclipselabs.damos.dml.TimingKind;
import org.eclipselabs.damos.dscript.DscriptBlockType;
import org.eclipselabs.damos.execution.ComponentNode;
import org.eclipselabs.damos.simulation.simulator.ISimulationObject;
import org.eclipselabs.damos.simulation.simulator.ISimulationObjectProvider;
import org.eclipselabs.damos.simulation.simulator.internal.simulationobjects.BehavioredBlockSimulationObject;
import org.eclipselabs.damos.simulation.simulator.internal.simulationobjects.ContinuousBlockSimulationObject;

/**
 * @author Andreas Unger
 *
 */
public class BehavioredBlockSimulationObjectProvider implements ISimulationObjectProvider {

	public ISimulationObject createSimulationObject(ComponentNode node) {
		if (node.getComponent() instanceof Block) {
			Block block = (Block) node.getComponent();
			if (block.getType() instanceof DscriptBlockType) {
				DscriptBlockType blockType = (DscriptBlockType) block.getType();
				if (blockType.getBehavior() != null) {
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
