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

package org.eclipselabs.damos.library.base.simulation.continuous;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipselabs.damos.execution.core.util.ExpressionUtil;
import org.eclipselabs.damos.library.base.util.continuous.IntegratorConstants;
import org.eclipselabs.damos.mscript.NumericType;
import org.eclipselabs.damos.mscript.interpreter.value.ISimpleNumericValue;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;
import org.eclipselabs.damos.mscript.interpreter.value.Values;
import org.eclipselabs.damos.simulation.ISimulationMonitor;
import org.eclipselabs.damos.simulation.simulator.AbstractBlockSimulationObject;

/**
 * @author Andreas Unger
 *
 */
public class IntegratorSimulationObject extends AbstractBlockSimulationObject {

	private double gain = 1;
	private NumericType outputDataType;
	
	private IValue outputValue;

	private double inputValue;
	private double[] stateVector;
	private double y;
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.simulator.AbstractSimulationObject#initialize()
	 */
	@Override
	public void initialize(IProgressMonitor monitor) throws CoreException {
		stateVector = new double[1];
		ISimpleNumericValue initialCondition = ExpressionUtil.evaluateSimpleNumericArgument(getComponent(), IntegratorConstants.PARAMETER__INITIAL_CONDITION);
		if (initialCondition != null) {
			stateVector[0] = initialCondition.doubleValue();
		}

		ISimpleNumericValue gainValue = ExpressionUtil.evaluateSimpleNumericArgument(getComponent(), IntegratorConstants.PARAMETER__GAIN);
		if (gainValue != null) {
			gain = gainValue.doubleValue();
		}
		
		outputDataType = (NumericType) getComponentSignature().getOutputDataType(getComponent().getFirstOutputPort());
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.simulator.AbstractSimulationObject#setInputValue(int, int, org.eclipselabs.mscript.computation.core.value.IValue)
	 */
	@Override
	public void setInputValue(int inputIndex, int portIndex, IValue value) {
		if (!(value instanceof ISimpleNumericValue)) {
			throw new IllegalArgumentException("Integrator input value must be numeric");
		}
		inputValue = ((ISimpleNumericValue) value).doubleValue();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.simulator.AbstractSimulationObject#getOutputValue(int, int)
	 */
	@Override
	public IValue getOutputValue(int outputIndex, int portIndex) {
		return outputValue;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.simulator.AbstractSimulationObject#computeOutputValues(double)
	 */
	@Override
	public void computeOutputValues(double t, ISimulationMonitor monitor) throws CoreException {
		outputValue = Values.valueOf(getComputationContext(), outputDataType, gain * y);
	}
	
	@Override
	public double[] getStateVector() {
		return stateVector;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.simulator.AbstractSimulationObject#computeDerivatives(double, double[])
	 */
	@Override
	public void computeDerivatives(double t, double[] y, double[] yDot) {
		yDot[0] = inputValue;
		this.y = y[0];
	}
	
}
