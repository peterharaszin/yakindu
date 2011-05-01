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
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipselabs.damos.execution.engine.util.ExpressionUtil;
import org.eclipselabs.damos.library.base.continuous.util.IntegratorConstants;
import org.eclipselabs.damos.simulation.engine.AbstractBlockSimulationObject;
import org.eclipselabs.damos.simulation.engine.SimulationEnginePlugin;
import org.eclipselabs.mscript.computation.engine.ComputationContext;
import org.eclipselabs.mscript.computation.engine.value.ISimpleNumericValue;
import org.eclipselabs.mscript.computation.engine.value.IValue;
import org.eclipselabs.mscript.computation.engine.value.ValueConstructor;
import org.eclipselabs.mscript.typesystem.NumericType;

/**
 * @author Andreas Unger
 *
 */
public class IntegratorSimulationObject extends AbstractBlockSimulationObject {

	private double gain = 1;
	private double[] stateVector;
	private double inputValue;
	private IValue outputValue;
	private NumericType outputDataType;
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.engine.AbstractComponentSimulationObject#initialize()
	 */
	@Override
	public void initialize() throws CoreException {
		stateVector = new double[1];
		ISimpleNumericValue initialCondition = ExpressionUtil.evaluateSimpleNumericArgument(getComponent(), IntegratorConstants.PARAMETER__INITIAL_CONDITION);
		if (initialCondition != null) {
			stateVector[0] = initialCondition.doubleValue();
		}

		ISimpleNumericValue gainValue = ExpressionUtil.evaluateSimpleNumericArgument(getComponent(), IntegratorConstants.PARAMETER__GAIN);
		if (gainValue != null) {
			gain = gainValue.doubleValue();
		}
		
		outputDataType = (NumericType) getInfo().getComponentSignature().getOutputDataType(getComponent().getFirstOutputPort());
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.engine.AbstractComponentSimulationObject#setInputValue(int, int, org.eclipselabs.mscript.computation.engine.value.IValue)
	 */
	@Override
	public void setInputValue(int inputIndex, int portIndex, IValue value) throws CoreException {
		if (!(value instanceof ISimpleNumericValue)) {
			throw new CoreException(new Status(IStatus.ERROR, SimulationEnginePlugin.PLUGIN_ID, "Integrator input value must be numeric"));
		}
		ISimpleNumericValue numericValue = (ISimpleNumericValue) value;
		inputValue = numericValue.doubleValue();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.engine.AbstractComponentSimulationObject#getOutputValue(int, int)
	 */
	@Override
	public IValue getOutputValue(int outputIndex, int portIndex) throws CoreException {
		return outputValue;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.engine.AbstractComponentSimulationObject#computeOutputValues(double)
	 */
	@Override
	public void computeOutputValues(double t) throws CoreException {
		outputValue = new ValueConstructor().construct(new ComputationContext(getComputationModel()), outputDataType, gain * stateVector[0]);
	}
	
	@Override
	public double[] getStateVector() {
		return stateVector;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.engine.AbstractComponentSimulationObject#computeDerivatives(double, double[])
	 */
	@Override
	public void computeDerivatives(double t, double[] yDot) throws CoreException {
		yDot[0] = inputValue;
	}
	
}
