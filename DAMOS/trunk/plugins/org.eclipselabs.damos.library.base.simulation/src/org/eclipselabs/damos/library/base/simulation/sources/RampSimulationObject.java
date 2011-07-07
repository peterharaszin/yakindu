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

package org.eclipselabs.damos.library.base.simulation.sources;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipselabs.damos.execution.core.util.ExpressionUtil;
import org.eclipselabs.damos.library.base.sources.util.RampConstants;
import org.eclipselabs.damos.simulation.core.ISimulationMonitor;
import org.eclipselabs.damos.simulation.simulator.AbstractBlockSimulationObject;
import org.eclipselabs.mscript.computation.core.ComputationContext;
import org.eclipselabs.mscript.computation.core.IComputationContext;
import org.eclipselabs.mscript.computation.core.value.ISimpleNumericValue;
import org.eclipselabs.mscript.computation.core.value.IValue;
import org.eclipselabs.mscript.computation.core.value.Values;
import org.eclipselabs.mscript.typesystem.RealType;
import org.eclipselabs.mscript.typesystem.TypeSystemFactory;
import org.eclipselabs.mscript.typesystem.UnitSymbol;
import org.eclipselabs.mscript.typesystem.util.TypeSystemUtil;

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
		
		timeDataType = TypeSystemFactory.eINSTANCE.createRealType();
		timeDataType.setUnit(TypeSystemUtil.createUnit(UnitSymbol.SECOND));
		
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
	 * @see org.eclipselabs.damos.simulation.simulator.AbstractSimulationObject#getZeroCrossingTime(double)
	 */
	@Override
	public double computeZeroCrossingTime(double t) {
		return startTime.doubleValue();
	}

}
