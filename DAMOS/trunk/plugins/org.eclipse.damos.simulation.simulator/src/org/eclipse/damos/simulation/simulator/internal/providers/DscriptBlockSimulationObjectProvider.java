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

package org.eclipse.damos.simulation.simulator.internal.providers;

import org.eclipse.damos.dml.Block;
import org.eclipse.damos.dml.TimingKind;
import org.eclipse.damos.dscript.DscriptBlockType;
import org.eclipse.damos.execution.ComponentNode;
import org.eclipse.damos.simulation.simulator.ISimulationObject;
import org.eclipse.damos.simulation.simulator.ISimulationObjectProvider;
import org.eclipse.damos.simulation.simulator.internal.simulationobjects.ContinuousBlockSimulationObject;
import org.eclipse.damos.simulation.simulator.internal.simulationobjects.DscriptBlockSimulationObject;

/**
 * @author Andreas Unger
 *
 */
public class DscriptBlockSimulationObjectProvider implements ISimulationObjectProvider {

	public ISimulationObject createSimulationObject(ComponentNode node) {
		if (node.getComponent() instanceof Block) {
			Block block = (Block) node.getComponent();
			if (block.getType() instanceof DscriptBlockType) {
				DscriptBlockType blockType = (DscriptBlockType) block.getType();
				if (blockType.getBehavior() != null) {
					if (blockType.getTiming() == TimingKind.CONTINUOUS) {
						return new ContinuousBlockSimulationObject();
					}
					return new DscriptBlockSimulationObject();
				}
			}
		}
		return null;
	}
	
}
