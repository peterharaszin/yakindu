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
import org.eclipse.damos.mscript.interpreter.value.IValue;
import org.eclipse.damos.mscript.interpreter.value.Values;
import org.eclipse.damos.simulation.AbstractSimulationAgent;
import org.eclipse.damos.simulation.AbstractSimulationVariationPoint;
import org.eclipse.damos.simulation.ISimulationAgent;
import org.eclipse.damos.simulation.ISimulationMonitor;
import org.eclipse.damos.simulation.ISimulationVariationPoint;
import org.eclipse.damos.simulation.simulator.AbstractBlockSimulationObject;

/**
 * @author Andreas Unger
 *
 */
public class SliderSimulationObject extends AbstractBlockSimulationObject {

	private double doubleOutputValue;
	private IValue outputValue;

	private NumericType outputDataType;

	private final ISimulationVariationPoint[] variationPoints = new ISimulationVariationPoint[] { new AbstractSimulationVariationPoint() {

		public double getDoubleValue() {
			return doubleOutputValue;
		}
		
		public void setValue(double value) {
			doubleOutputValue = value;
		}

	} };

	@Override
	public void initialize(IProgressMonitor monitor) throws CoreException {
		outputDataType = (NumericType) getComponentSignature().getOutputDataType(getComponent().getFirstOutputPort());
	}
	
	@Override
	public void computeOutputValues(double t, ISimulationMonitor monitor) throws CoreException {
		outputValue = Values.valueOf(getComputationContext(), outputDataType, doubleOutputValue);
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
		return new AbstractSimulationAgent(getNode().getSystemPath().toURIPath()) {
			
			@Override
			public ISimulationVariationPoint[] getVariationPoints() {
				return variationPoints;
			}
			
		};
	}
	
}
