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
import org.eclipselabs.damos.library.base.continuous.util.DerivativeConstants;
import org.eclipselabs.damos.simulation.core.ISimulationMonitor;
import org.eclipselabs.damos.simulation.simulator.AbstractBlockSimulationObject;
import org.eclipselabs.mscript.computation.core.value.ISimpleNumericValue;
import org.eclipselabs.mscript.computation.core.value.IValue;
import org.eclipselabs.mscript.computation.core.value.ValueConstructor;
import org.eclipselabs.mscript.typesystem.NumericType;

/**
 * @author Andreas Unger
 *
 */
public class DerivativeSimulationObject extends AbstractBlockSimulationObject {

	private double gain = 1;
	private double inputValue;
	private double inputValueTm1;
	private NumericType outputDataType;
	private IValue outputValue;
	private double tm1;
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.simulator.AbstractComponentSimulationObject#initialize()
	 */
	@Override
	public void initialize(IProgressMonitor monitor) throws CoreException {
		ISimpleNumericValue gainValue = ExpressionUtil.evaluateSimpleNumericArgument(getComponent(), DerivativeConstants.PARAMETER__GAIN);
		if (gainValue != null) {
			gain = gainValue.doubleValue();
		}
		
		outputDataType = (NumericType) getComponentSignature().getOutputDataType(getComponent().getFirstOutputPort());
		
		outputValue = new ValueConstructor().construct(getComputationContext(), outputDataType, 0.0);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.simulator.AbstractComponentSimulationObject#setInputValue(int, int, org.eclipselabs.mscript.computation.core.value.IValue)
	 */
	@Override
	public void setInputValue(int inputIndex, int portIndex, IValue value) {
		if (!(value instanceof ISimpleNumericValue)) {
			throw new IllegalArgumentException("Derivative input value must be numeric");
		}
		ISimpleNumericValue numericValue = (ISimpleNumericValue) value;
		inputValue = numericValue.doubleValue();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.simulator.AbstractComponentSimulationObject#getOutputValue(int, int)
	 */
	@Override
	public IValue getOutputValue(int outputIndex, int portIndex) {
		return outputValue;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.simulator.AbstractComponentSimulationObject#computeOutputValues(double)
	 */
	@Override
	public void computeOutputValues(double t, ISimulationMonitor monitor) throws CoreException {
		double dx = inputValue - inputValueTm1;
		double dt = t - tm1;
		if (dt != 0) {
			outputValue = new ValueConstructor().construct(getComputationContext(), outputDataType, gain * (dx / dt));
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.simulator.AbstractComponentSimulationObject#update()
	 */
	@Override
	public void update(double t) {
		tm1 = t;
		inputValueTm1 = inputValue;
	}
	
}
