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

package org.eclipselabs.damos.simulation.engine;

import org.eclipse.core.runtime.CoreException;
import org.eclipselabs.damos.execution.executiongraph.DataFlowSourceEnd;
import org.eclipselabs.damos.execution.executiongraph.DataFlowTargetEnd;
import org.eclipselabs.damos.execution.executiongraph.Node;
import org.eclipselabs.damos.simulation.engine.util.SimulationUtil;
import org.eclipselabs.mscript.computation.engine.value.IValue;

/**
 * @author Andreas Unger
 *
 */
public class SimulationEngine implements ISimulationEngine {
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.engine.ISimulationEngine#simulate(org.eclipselabs.damos.simulation.engine.ISimulationContext, org.eclipselabs.damos.simulation.engine.ISimulationMonitor)
	 */
	public void run(ISimulationContext context, ISimulationMonitor monitor) throws CoreException {
		long stepCount = SimulationUtil.getStepCount(context.getSimulationModel());
		
		monitor.fireSimulationEvent(new SimulationEvent(this, context, SimulationEvent.START));
		for (Node node : context.getExecutionGraph().getNodes()) {
			if (monitor.isCanceled()) {
				break;
			}
			IComponentSimulationObject simulationObject = SimulationUtil.getComponentSimulationObject(node);
			simulationObject.initialize();
		}
		
		long n;
		for (n = 0; n < stepCount; ++n) {
			monitor.fireSimulationEvent(new SimulationEvent(this, context, SimulationEvent.STEP));
			if (monitor.isCanceled()) {
				break;
			}
			for (Node node : context.getExecutionGraph().getNodes()) {
				if (monitor.isCanceled()) {
					break;
				}
				IComponentSimulationObject simulationObject = SimulationUtil.getComponentSimulationObject(node);
				simulationObject.computeOutputValues();
				for (DataFlowSourceEnd sourceEnd : node.getOutgoingDataFlows()) {
					IValue value = simulationObject.getOutputValue(sourceEnd.getInoutputIndex(), sourceEnd.getPortIndex());
					for (DataFlowTargetEnd targetEnd : sourceEnd.getDataFlow().getTargetEnds()) {
						IComponentSimulationObject targetSimulationObject = SimulationUtil.getComponentSimulationObject(targetEnd.getNode());
						targetSimulationObject.setInputValue(targetEnd.getInoutputIndex(), targetEnd.getPortIndex(), value);
					}
				}
			}
			for (Node node : context.getExecutionGraph().getNodes()) {
				if (monitor.isCanceled()) {
					break;
				}
				IComponentSimulationObject simulationObject = SimulationUtil.getComponentSimulationObject(node);
				simulationObject.update();
			}
		}
		
		int eventKind = monitor.isCanceled() ? SimulationEvent.CANCEL : SimulationEvent.FINISH;
		monitor.fireSimulationEvent(new SimulationEvent(this, context, eventKind));
	}

}
