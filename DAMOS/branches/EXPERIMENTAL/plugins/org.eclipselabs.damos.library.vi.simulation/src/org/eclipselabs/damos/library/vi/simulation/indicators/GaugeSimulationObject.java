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

package org.eclipselabs.damos.library.vi.simulation.indicators;

import org.eclipselabs.damos.mscript.interpreter.value.IValue;
import org.eclipselabs.damos.simulation.AbstractSimulationAgent;
import org.eclipselabs.damos.simulation.ISimulationAgent;
import org.eclipselabs.damos.simulation.ISimulationTracePoint;
import org.eclipselabs.damos.simulation.simulator.AbstractBlockSimulationObject;

/**
 * @author Andreas Unger
 *
 */
public class GaugeSimulationObject extends AbstractBlockSimulationObject {
	
	private IValue inputValue;
	private IValue value;
	
	private ISimulationTracePoint[] tracePoints = new ISimulationTracePoint[] { new ISimulationTracePoint() {

		public IValue getValue() {
			return value;
		}

	} };
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.simulator.AbstractSimulationObject#setInputValue(int, int, org.eclipselabs.mscript.computation.core.value.IValue)
	 */
	@Override
	public void setInputValue(int inputIndex, int portIndex, IValue value) {
		inputValue = value;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.simulator.AbstractSimulationObject#update(double)
	 */
	@Override
	public void update(double t) {
		value = inputValue;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.simulator.AbstractSimulationObject#createAgent()
	 */
	@Override
	protected ISimulationAgent createAgent() {
		return new AbstractSimulationAgent(getComponent()) {
			
			/* (non-Javadoc)
			 * @see org.eclipselabs.damos.simulation.simulator.AbstractSimulationAgent#getTracePoints()
			 */
			@Override
			public ISimulationTracePoint[] getTracePoints() {
				return tracePoints;
			}
			
		};
	}

}
