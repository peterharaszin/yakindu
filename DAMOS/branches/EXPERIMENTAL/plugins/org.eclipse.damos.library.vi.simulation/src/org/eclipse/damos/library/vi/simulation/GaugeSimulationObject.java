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

package org.eclipse.damos.library.vi.simulation;

import org.eclipse.damos.mscript.interpreter.value.ISimpleNumericValue;
import org.eclipse.damos.mscript.interpreter.value.IValue;
import org.eclipse.damos.simulation.AbstractSimulationAgent;
import org.eclipse.damos.simulation.AbstractSimulationTracePoint;
import org.eclipse.damos.simulation.ISimulationAgent;
import org.eclipse.damos.simulation.ISimulationTracePoint;
import org.eclipse.damos.simulation.simulator.AbstractBlockSimulationObject;

/**
 * @author Andreas Unger
 *
 */
public class GaugeSimulationObject extends AbstractBlockSimulationObject {
	
	private IValue inputValue;
	private double value;
	
	private final ISimulationTracePoint[] tracePoints = new ISimulationTracePoint[] { new AbstractSimulationTracePoint("value", Double.TYPE) {

		public double getDoubleValue() {
			return value;
		}

	} };
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.simulation.simulator.AbstractSimulationObject#setInputValue(int, int, org.eclipse.damos.mscript.computation.core.value.IValue)
	 */
	@Override
	public void setInputValue(int inputIndex, int portIndex, IValue value) {
		inputValue = value;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.simulation.simulator.AbstractSimulationObject#update(double)
	 */
	@Override
	public void update(double t) {
		if (inputValue instanceof ISimpleNumericValue) {
			value = ((ISimpleNumericValue) inputValue).doubleValue();
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.simulation.simulator.AbstractSimulationObject#createAgent()
	 */
	@Override
	protected ISimulationAgent createAgent() {
		return new AbstractSimulationAgent(getNode().getSystemPath().toURIPath()) {
			
			@Override
			public ISimulationTracePoint[] getTracePoints() {
				return tracePoints;
			}
			
		};
	}

}
