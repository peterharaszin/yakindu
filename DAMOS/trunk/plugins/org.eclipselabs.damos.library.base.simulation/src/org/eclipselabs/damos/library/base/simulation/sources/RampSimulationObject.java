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
import org.eclipselabs.damos.library.base.sources.util.RampConstants;
import org.eclipselabs.damos.simulation.engine.AbstractBlockSimulationObject;
import org.eclipselabs.mscript.computation.engine.ComputationContext;
import org.eclipselabs.mscript.computation.engine.IComputationContext;
import org.eclipselabs.mscript.computation.engine.value.ISimpleNumericValue;
import org.eclipselabs.mscript.computation.engine.value.IValue;
import org.eclipselabs.mscript.computation.engine.value.ValueConstructor;
import org.eclipselabs.mscript.computation.engine.value.ValueTransformer;
import org.eclipselabs.mscript.typesystem.RealType;
import org.eclipselabs.mscript.typesystem.TypeSystemFactory;
import org.eclipselabs.mscript.typesystem.UnitSymbol;
import org.eclipselabs.mscript.typesystem.util.TypeSystemUtil;

/**
 * @author Andreas Unger
 *
 */
public class RampSimulationObject extends AbstractBlockSimulationObject {

	private ValueConstructor valueConstructor = new ValueConstructor();
	private ValueTransformer valueTransformer = new ValueTransformer();
	
	private IComputationContext defaultComputationContext;
	private IComputationContext outputComputationContext;
	
	private RealType timeDataType;
	
	private ISimpleNumericValue initialValue;
	private ISimpleNumericValue startTime;
	private ISimpleNumericValue slope;

	private double sampleTime;
	
	private int n;
	
	@Override
	public void initialize() throws CoreException {
		defaultComputationContext = new ComputationContext();
		outputComputationContext = new ComputationContext(getComputationModel());
		
		timeDataType = TypeSystemFactory.eINSTANCE.createRealType();
		timeDataType.setUnit(TypeSystemUtil.createUnit(UnitSymbol.SECOND));
		
		initialValue = ExpressionUtil.evaluateSimpleNumericArgument(getComponent(), RampConstants.PARAMETER__INITIAL_VALUE);
		startTime = ExpressionUtil.evaluateSimpleNumericArgument(getComponent(), RampConstants.PARAMETER__START_TIME);
		slope = ExpressionUtil.evaluateSimpleNumericArgument(getComponent(), RampConstants.PARAMETER__SLOPE);
		
		sampleTime = getExecutionModel().getSampleTime();
		
		n = 0;
	}
	
	@Override
	public IValue getOutputValue(int outputIndex, int portIndex) throws CoreException {
		ISimpleNumericValue time = valueConstructor.createRealValue(defaultComputationContext, timeDataType, n * sampleTime);
		IValue value = initialValue;
		if (time.doubleValue() > startTime.doubleValue()) {
			value = value.add(slope.multiply(time.subtract(startTime)));
		}
		return valueTransformer.transform(outputComputationContext, value);
	}
	
	@Override
	public void update() throws CoreException {
		++n;
	}
	
}
