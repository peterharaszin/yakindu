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

import org.eclipse.damos.mscript.interpreter.IComputationContext;
import org.eclipse.damos.mscript.interpreter.value.IValue;
import org.eclipse.damos.mscript.interpreter.value.Values;
import org.eclipse.damos.simulation.AbstractSimulationAgent;
import org.eclipse.damos.simulation.AbstractSimulationVariationPoint;
import org.eclipse.damos.simulation.ISimulationAgent;
import org.eclipse.damos.simulation.ISimulationVariationPoint;
import org.eclipse.damos.simulation.simulator.AbstractBlockSimulationObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * @author Andreas Unger
 *
 */
public class ButtonSimulationObject extends AbstractBlockSimulationObject {

	private boolean booleanOutputValue;
	private IValue outputValue;

	private final ISimulationVariationPoint[] variationPoints = { new AbstractSimulationVariationPoint() {

		public boolean getBooleanValue() {
			return booleanOutputValue;
		}
		
		public void setValue(boolean value) {
			booleanOutputValue = value;
		}

	} };
	
	public void computeOutputValues(double t, org.eclipse.damos.simulation.ISimulationMonitor monitor) throws org.eclipse.core.runtime.CoreException {
		outputValue = Values.valueOf(getComputationContext(), booleanOutputValue);
	}

	@Override
	public IValue getOutputValue(int outputIndex, int portIndex) {
		return outputValue;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.simulation.simulator.AbstractSimulationObject#createAgent()
	 */
	@Override
	protected ISimulationAgent createAgent() {
		return new AbstractSimulationAgent(EcoreUtil.getURI(getComponent()).toString()) {
			
			/* (non-Javadoc)
			 * @see org.eclipse.damos.simulation.simulator.ISimulationAgent#getComputationContext()
			 */
			public IComputationContext getComputationContext() {
				return ButtonSimulationObject.this.getComputationContext();
			}
			
			/* (non-Javadoc)
			 * @see org.eclipse.damos.simulation.simulator.AbstractSimulationAgent#getVariationPoints()
			 */
			@Override
			public ISimulationVariationPoint[] getVariationPoints() {
				return variationPoints;
			}
			
		};
	}
	
}
