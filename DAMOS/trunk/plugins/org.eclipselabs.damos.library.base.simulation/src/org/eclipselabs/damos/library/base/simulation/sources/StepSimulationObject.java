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
import org.eclipselabs.damos.library.base.sources.util.StepConstants;
import org.eclipselabs.damos.simulation.engine.AbstractBlockSimulationObject;
import org.eclipselabs.mscript.computation.engine.ComputationContext;
import org.eclipselabs.mscript.computation.engine.IComputationContext;
import org.eclipselabs.mscript.computation.engine.value.ISimpleNumericValue;
import org.eclipselabs.mscript.computation.engine.value.IValue;
import org.eclipselabs.mscript.computation.engine.value.ValueTransformer;

/**
 * @author Andreas Unger
 *
 */
public class StepSimulationObject extends AbstractBlockSimulationObject {

	private IValue initialValue;
	private IValue finalValue;
	private ISimpleNumericValue stepTime;
	
	private double sampleTime;
	
	private int n;

	@Override
	public void initialize() throws CoreException {
		initialValue = ExpressionUtil.evaluateSimpleNumericArgument(getComponent(), StepConstants.PARAMETER__INITIAL_VALUE);
		finalValue = ExpressionUtil.evaluateSimpleNumericArgument(getComponent(), StepConstants.PARAMETER__FINAL_VALUE);
		stepTime = ExpressionUtil.evaluateSimpleNumericArgument(getComponent(), StepConstants.PARAMETER__STEP_TIME);

		IComputationContext computationContext = new ComputationContext(getComputationModel(), getOverflowMonitor());
		ValueTransformer valueTransformer = new ValueTransformer();
		
		initialValue = valueTransformer.transform(computationContext, initialValue);
		finalValue = valueTransformer.transform(computationContext, finalValue);
		
		sampleTime = getExecutionModel().getSampleTime();
		
		n = 0;
	}
	
	@Override
	public IValue getOutputValue(int outputIndex, int portIndex) throws CoreException {
		return n * sampleTime <= stepTime.doubleValue() ? initialValue : finalValue;
	}
	
	@Override
	public void update() throws CoreException {
		++n;
	}
	
}
