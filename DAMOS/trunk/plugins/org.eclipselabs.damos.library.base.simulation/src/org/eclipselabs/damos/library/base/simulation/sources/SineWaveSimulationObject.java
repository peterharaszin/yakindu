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
import org.eclipselabs.damos.library.base.util.sources.SineWaveConstants;
import org.eclipselabs.damos.mscript.MscriptFactory;
import org.eclipselabs.damos.mscript.RealType;
import org.eclipselabs.damos.mscript.interpreter.ComputationContext;
import org.eclipselabs.damos.mscript.interpreter.IComputationContext;
import org.eclipselabs.damos.mscript.interpreter.value.ISimpleNumericValue;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;
import org.eclipselabs.damos.mscript.interpreter.value.Values;
import org.eclipselabs.damos.mscript.util.TypeUtil;
import org.eclipselabs.damos.simulation.ISimulationMonitor;
import org.eclipselabs.damos.simulation.simulator.AbstractBlockSimulationObject;

/**
 * @author Andreas Unger
 *
 */
public class SineWaveSimulationObject extends AbstractBlockSimulationObject {

	private IComputationContext defaultComputationContext;

	private RealType sineDataType;

	private ISimpleNumericValue amplitude;
	private ISimpleNumericValue bias;
	private double frequency;
	private double phase;
	
	private IValue outputValue;
	
	private double minimalStepSize;
	
	@Override
	public void initialize(IProgressMonitor monitor) throws CoreException {
		defaultComputationContext = new ComputationContext();

		sineDataType = MscriptFactory.eINSTANCE.createRealType();
		sineDataType.setUnit(TypeUtil.createUnit());

		amplitude = ExpressionUtil.evaluateSimpleNumericArgument(getComponent(), SineWaveConstants.PARAMETER__AMPLITUDE);
		bias = ExpressionUtil.evaluateSimpleNumericArgument(getComponent(), SineWaveConstants.PARAMETER__BIAS);
		frequency = ExpressionUtil.evaluateSimpleNumericArgument(getComponent(), SineWaveConstants.PARAMETER__FREQUENCY).doubleValue();
		phase = ExpressionUtil.evaluateSimpleNumericArgument(getComponent(), SineWaveConstants.PARAMETER__PHASE).doubleValue();
		
		minimalStepSize = 0.01 / frequency;
	}

	@Override
	public IValue getOutputValue(int outputIndex, int portIndex) {
		return outputValue;
	}
	
	@Override
	public void computeOutputValues(double t, ISimulationMonitor monitor) throws CoreException {
		ISimpleNumericValue sineValue = Values.valueOf(defaultComputationContext, sineDataType,
				Math.sin(2 * Math.PI * frequency * t + Math.toRadians(phase)));
		outputValue = Values.transform(getComputationContext(), amplitude.multiply(sineValue).add(bias));
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.simulator.AbstractSimulationObject#computeZeroCrossingTime(double)
	 */
	@Override
	public double computeZeroCrossingTime(double t) {
		return t + minimalStepSize;
	}
	
}
