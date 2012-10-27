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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.damos.mscript.NumericType;
import org.eclipse.damos.mscript.Type;
import org.eclipse.damos.mscript.interpreter.IComputationContext;
import org.eclipse.damos.mscript.interpreter.value.IValue;
import org.eclipse.damos.mscript.interpreter.value.Values;
import org.eclipse.damos.simulation.AbstractSimulationAgent;
import org.eclipse.damos.simulation.ISimulationAgent;
import org.eclipse.damos.simulation.ISimulationVariationPoint;
import org.eclipse.damos.simulation.simulator.AbstractBlockSimulationObject;

/**
 * @author Andreas Unger
 *
 */
public class SliderSimulationObject extends AbstractBlockSimulationObject {

	private IValue outputValue;

	private Type outputDataType;

	private ISimulationVariationPoint[] variationPoints = new ISimulationVariationPoint[] { new ISimulationVariationPoint() {

		public Type getDataType() {
			return outputDataType;
		}
		
		public IValue getValue() {
			return outputValue;
		}
		
		public void setValue(IValue value) {
			outputValue = value;
		}

	} };

	@Override
	public void initialize(IProgressMonitor monitor) throws CoreException {
		outputDataType = getComponentSignature().getOutputDataType(getComponent().getFirstOutputPort());
		outputValue = Values.valueOf(getComputationContext(), (NumericType) outputDataType, 0.0);
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
		return new AbstractSimulationAgent(getComponent()) {
			
			/* (non-Javadoc)
			 * @see org.eclipse.damos.simulation.simulator.ISimulationAgent#getComputationContext()
			 */
			public IComputationContext getComputationContext() {
				return SliderSimulationObject.this.getComputationContext();
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
