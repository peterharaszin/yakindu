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
import org.eclipselabs.damos.library.base.sources.util.SineWaveConstants;
import org.eclipselabs.damos.simulation.core.ISimulationMonitor;
import org.eclipselabs.damos.simulation.simulator.AbstractBlockSimulationObject;
import org.eclipselabs.mscript.computation.core.ComputationContext;
import org.eclipselabs.mscript.computation.core.IComputationContext;
import org.eclipselabs.mscript.computation.core.value.INumericValue;
import org.eclipselabs.mscript.computation.core.value.ISimpleNumericValue;
import org.eclipselabs.mscript.computation.core.value.IValue;
import org.eclipselabs.mscript.computation.core.value.Values;
import org.eclipselabs.mscript.typesystem.RealType;
import org.eclipselabs.mscript.typesystem.TypeSystemFactory;
import org.eclipselabs.mscript.typesystem.util.TypeSystemUtil;

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
	
	@Override
	public void initialize(IProgressMonitor monitor) throws CoreException {
		defaultComputationContext = new ComputationContext();

		sineDataType = TypeSystemFactory.eINSTANCE.createRealType();
		sineDataType.setUnit(TypeSystemUtil.createUnit());

		amplitude = ExpressionUtil.evaluateSimpleNumericArgument(getComponent(), SineWaveConstants.PARAMETER__AMPLITUDE);
		bias = ExpressionUtil.evaluateSimpleNumericArgument(getComponent(), SineWaveConstants.PARAMETER__BIAS);
		frequency = ExpressionUtil.evaluateSimpleNumericArgument(getComponent(), SineWaveConstants.PARAMETER__FREQUENCY).doubleValue();
		phase = ExpressionUtil.evaluateSimpleNumericArgument(getComponent(), SineWaveConstants.PARAMETER__PHASE).doubleValue();
	}

	@Override
	public IValue getOutputValue(int outputIndex, int portIndex) {
		return outputValue;
	}
	
	@Override
	public void computeOutputValues(double t, ISimulationMonitor monitor) throws CoreException {
		INumericValue sineValue = Values.valueOf(defaultComputationContext, sineDataType,
				Math.sin(2 * Math.PI * frequency * t + Math.toRadians(phase)));
		outputValue = Values.transform(getComputationContext(), amplitude.multiply(sineValue).add(bias));
	}
	
}
