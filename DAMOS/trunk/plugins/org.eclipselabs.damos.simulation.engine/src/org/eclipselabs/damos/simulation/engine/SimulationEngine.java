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
import org.eclipselabs.damos.execution.executionflow.DataFlowSourceEnd;
import org.eclipselabs.damos.execution.executionflow.DataFlowTargetEnd;
import org.eclipselabs.damos.execution.executionflow.Node;
import org.eclipselabs.damos.execution.executionflow.PortInfo;
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
		for (Node node : context.getExecutionFlow().getGraph().getNodes()) {
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
			for (Node node : context.getExecutionFlow().getGraph().getNodes()) {
				if (monitor.isCanceled()) {
					break;
				}
				IComponentSimulationObject simulationObject = SimulationUtil.getComponentSimulationObject(node);
				simulationObject.computeOutputValues();
				for (DataFlowSourceEnd sourceEnd : node.getOutgoingDataFlows()) {
					PortInfo sourcePortInfo = (PortInfo) sourceEnd.getConnectorInfo();
					IValue value = simulationObject.getOutputValue(sourcePortInfo.getInoutputIndex(), sourcePortInfo.getPortIndex());
					for (DataFlowTargetEnd targetEnd : sourceEnd.getDataFlow().getTargetEnds()) {
						IComponentSimulationObject targetSimulationObject = SimulationUtil.getComponentSimulationObject(targetEnd.getNode());
						PortInfo targetPortInfo = (PortInfo) targetEnd.getConnectorInfo();
						targetSimulationObject.setInputValue(targetPortInfo.getInoutputIndex(), targetPortInfo.getPortIndex(), value);
					}
				}
			}
			for (Node node : context.getExecutionFlow().getGraph().getNodes()) {
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
