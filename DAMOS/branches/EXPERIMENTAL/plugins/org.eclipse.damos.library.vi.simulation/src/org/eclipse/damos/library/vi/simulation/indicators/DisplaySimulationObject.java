/****************************************************************************
 * Copyright (c) 2008, 2009 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipse.damos.library.vi.simulation.indicators;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.damos.mscript.interpreter.value.IValue;
import org.eclipse.damos.simulation.AbstractSimulationAgent;
import org.eclipse.damos.simulation.ISimulationAgent;
import org.eclipse.damos.simulation.ISimulationTracePoint;
import org.eclipse.damos.simulation.simulator.AbstractBlockSimulationObject;

/**
 * @author Andreas Unger
 *
 */
public class DisplaySimulationObject extends AbstractBlockSimulationObject {
	
	private IValue[] inputValues;
	private IValue[] values;
	
	private ISimulationTracePoint[] tracePoints;
	
	public void initialize(IProgressMonitor monitor) throws CoreException {
		int portCount = getComponent().getPrimaryInputPorts().size();
		
		inputValues = new IValue[portCount];
		values = new IValue[portCount];
		
		tracePoints = new ISimulationTracePoint[portCount];
		for (int i = 0; i < portCount; ++i) {
			tracePoints[i] = new SimulationTracePoint(i);
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.simulation.simulator.AbstractSimulationObject#setInputValue(int, int, org.eclipse.damos.mscript.computation.core.value.IValue)
	 */
	@Override
	public void setInputValue(int inputIndex, int portIndex, IValue value) {
		inputValues[portIndex] = value;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.simulation.simulator.AbstractSimulationObject#update(double)
	 */
	@Override
	public void update(double t) {
		System.arraycopy(inputValues, 0, values, 0, inputValues.length);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.simulation.simulator.AbstractSimulationObject#createAgent()
	 */
	@Override
	protected ISimulationAgent createAgent() {
		return new AbstractSimulationAgent(getComponent()) {
			
			/* (non-Javadoc)
			 * @see org.eclipse.damos.simulation.simulator.AbstractSimulationAgent#getTracePoints()
			 */
			@Override
			public ISimulationTracePoint[] getTracePoints() {
				return tracePoints;
			}
			
		};
	}

	private class SimulationTracePoint implements ISimulationTracePoint {
		
		private int index;

		/**
		 * 
		 */
		public SimulationTracePoint(int index) {
			this.index = index;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipse.damos.simulation.ISimulationTracePoint#getValue()
		 */
		public IValue getValue() {
			return values[index];
		}
		
	}
	
}
