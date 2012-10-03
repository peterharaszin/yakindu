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

package org.eclipse.damos.library.base.simulation.sources;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.damos.execution.util.ExpressionUtil;
import org.eclipse.damos.library.base.util.sources.RampConstants;
import org.eclipse.damos.mscript.MscriptFactory;
import org.eclipse.damos.mscript.RealType;
import org.eclipse.damos.mscript.interpreter.ComputationContext;
import org.eclipse.damos.mscript.interpreter.IComputationContext;
import org.eclipse.damos.mscript.interpreter.value.ISimpleNumericValue;
import org.eclipse.damos.mscript.interpreter.value.IValue;
import org.eclipse.damos.mscript.interpreter.value.Values;
import org.eclipse.damos.mscript.util.TypeUtil;
import org.eclipse.damos.simulation.ISimulationMonitor;
import org.eclipse.damos.simulation.simulator.AbstractBlockSimulationObject;

/**
 * @author Andreas Unger
 *
 */
public class RampSimulationObject extends AbstractBlockSimulationObject {

	private IComputationContext defaultComputationContext;
	
	private RealType timeDataType;
	
	private ISimpleNumericValue initialValue;
	private ISimpleNumericValue startTime;
	private ISimpleNumericValue slope;

	private IValue outputValue;
	
	@Override
	public void initialize(IProgressMonitor monitor) throws CoreException {
		defaultComputationContext = new ComputationContext();
		
		timeDataType = MscriptFactory.eINSTANCE.createRealType();
		timeDataType.setUnit(TypeUtil.createUnit(getComponent().eResource().getResourceSet(), TypeUtil.SECOND_UNIT));
		
		initialValue = ExpressionUtil.evaluateSimpleNumericArgument(getComponent(), RampConstants.PARAMETER__INITIAL_VALUE);
		startTime = ExpressionUtil.evaluateSimpleNumericArgument(getComponent(), RampConstants.PARAMETER__START_TIME);
		slope = ExpressionUtil.evaluateSimpleNumericArgument(getComponent(), RampConstants.PARAMETER__SLOPE);
	}
	
	@Override
	public IValue getOutputValue(int outputIndex, int portIndex) {
		return outputValue;
	}
	
	@Override
	public void computeOutputValues(double t, ISimulationMonitor monitor) throws CoreException {
		ISimpleNumericValue time = Values.valueOf(defaultComputationContext, timeDataType, t);
		IValue value = initialValue;
		if (time.doubleValue() > startTime.doubleValue()) {
			value = value.add(slope.multiply(time.subtract(startTime)));
		}
		outputValue = Values.transform(getComputationContext(), value);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.simulation.simulator.AbstractSimulationObject#getZeroCrossingTime(double)
	 */
	@Override
	public double computeZeroCrossingTime(double t) {
		return startTime.doubleValue();
	}

}
