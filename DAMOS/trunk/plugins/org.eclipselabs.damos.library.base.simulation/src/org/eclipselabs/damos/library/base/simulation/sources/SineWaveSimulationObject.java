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
import org.eclipselabs.damos.execution.engine.util.ExpressionUtil;
import org.eclipselabs.damos.library.base.sources.util.SineWaveConstants;
import org.eclipselabs.damos.simulation.engine.AbstractBlockSimulationObject;
import org.eclipselabs.mscript.computation.engine.ComputationContext;
import org.eclipselabs.mscript.computation.engine.IComputationContext;
import org.eclipselabs.mscript.computation.engine.value.INumericValue;
import org.eclipselabs.mscript.computation.engine.value.ISimpleNumericValue;
import org.eclipselabs.mscript.computation.engine.value.IValue;
import org.eclipselabs.mscript.computation.engine.value.IValueConstructor;
import org.eclipselabs.mscript.computation.engine.value.ValueConstructor;
import org.eclipselabs.mscript.computation.engine.value.ValueTransformer;
import org.eclipselabs.mscript.typesystem.RealType;
import org.eclipselabs.mscript.typesystem.TypeSystemFactory;
import org.eclipselabs.mscript.typesystem.util.TypeSystemUtil;

/**
 * @author Andreas Unger
 *
 */
public class SineWaveSimulationObject extends AbstractBlockSimulationObject {

	private IValueConstructor valueConstructor = new ValueConstructor();
	private ValueTransformer valueTransformer = new ValueTransformer();

	private IComputationContext defaultComputationContext;
	private IComputationContext outputComputationContext;

	private RealType sineDataType;

	private ISimpleNumericValue amplitude;
	private ISimpleNumericValue bias;
	private double frequency;
	private double phase;
	
	private double sampleTime;

	private int n;
	
	private IValue value;
	
	@Override
	public void initialize() throws CoreException {
		defaultComputationContext = new ComputationContext();
		outputComputationContext = new ComputationContext(getComputationModel());

		sineDataType = TypeSystemFactory.eINSTANCE.createRealType();
		sineDataType.setUnit(TypeSystemUtil.createUnit());

		amplitude = ExpressionUtil.evaluateSimpleNumericArgument(getComponent(), SineWaveConstants.PARAMETER__AMPLITUDE);
		bias = ExpressionUtil.evaluateSimpleNumericArgument(getComponent(), SineWaveConstants.PARAMETER__BIAS);
		frequency = ExpressionUtil.evaluateSimpleNumericArgument(getComponent(), SineWaveConstants.PARAMETER__FREQUENCY).doubleValue();
		phase = ExpressionUtil.evaluateSimpleNumericArgument(getComponent(), SineWaveConstants.PARAMETER__PHASE).doubleValue();
		
		sampleTime = getExecutionModel().getSampleTime();
		
		n = 0;
		updateValue();
	}
		
	public IValue getOutputValue(int outputIndex, int portIndex) throws CoreException {
		return value;
	}
	
	public void update() throws CoreException {
		++n;
		updateValue();
	}

	private void updateValue() throws CoreException {
		INumericValue sineValue = valueConstructor.construct(defaultComputationContext, sineDataType,
				Math.sin(2 * Math.PI * frequency * n * sampleTime + Math.toRadians(phase)));
		value = valueTransformer.transform(outputComputationContext, amplitude.multiply(sineValue).add(bias));
	}

}
