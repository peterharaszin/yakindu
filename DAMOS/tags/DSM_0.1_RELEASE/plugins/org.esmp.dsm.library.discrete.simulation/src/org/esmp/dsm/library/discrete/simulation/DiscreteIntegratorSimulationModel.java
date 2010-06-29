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

package org.esmp.dsm.library.discrete.simulation;

import org.esmp.dsm.expressions.DataType;
import org.esmp.dsm.library.discrete.util.DiscreteIntegratorConstants;
import org.esmp.dsm.semantic.blockdiagram.InputPort;
import org.esmp.dsm.semantic.blockdiagram.OutputPort;
import org.esmp.dsm.semantic.blockdiagram.util.BlockDiagramUtil;
import org.esmp.dsm.simulation.AbstractSimulationModel;
import org.esmp.dsm.simulation.Value;
import org.esmp.dsm.simulation.ValueFactory;

/**
 * @author Andreas Unger
 *
 */
public class DiscreteIntegratorSimulationModel extends AbstractSimulationModel {

	private Value samplingFrequency;
	private Value gain;
	private boolean accumulation;

	private Value sum;
	private Value inputValue;
	
	public void initialize() {
		DataType t = getBlockDataType();
		
		samplingFrequency = ValueFactory.INSTANCE.newValue(this, t, getContext().getSamplingFrequency());
		sum = ValueFactory.INSTANCE.newValue(this, t, BlockDiagramUtil.getParameterValue(getBlock(), DiscreteIntegratorConstants.PARAMETER__INITIAL_VALUE, ""), 0);
		gain = ValueFactory.INSTANCE.newValue(this, t, BlockDiagramUtil.getParameterValue(getBlock(), DiscreteIntegratorConstants.PARAMETER__GAIN, ""), 1);
		accumulation = BlockDiagramUtil.getParameterValueAsBoolean(getBlock(), DiscreteIntegratorConstants.PARAMETER__ACCUMULATION, false);
		
		if (!accumulation) {
			sum = sum.multiply(this, samplingFrequency);
		}
		
		inputValue = ValueFactory.INSTANCE.newValue(this, t, 0);
	}
	
	public void consumeInputValue(InputPort inputPort, Value value) {
		inputValue = value.multiply(this, gain);
	}
	
	public Value getOutputValue(OutputPort outputPort) {
		if (accumulation) {
			return sum;
		}
		return sum.divide(this, samplingFrequency);
	}
	
	public void update() {
		sum = sum.add(this, inputValue);
	}
	
}
