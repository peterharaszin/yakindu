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
import org.esmp.dsm.library.discrete.util.DiscreteDerivativeConstants;
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
public class DiscreteDerivativeSimulationModel extends AbstractSimulationModel {

	private Value samplingFrequency;
	private Value gain;
	private Value inputValue;
	private Value previousInputValue;
	
	public void initialize() {
		DataType t = getBlockDataType();
		samplingFrequency = ValueFactory.INSTANCE.newValue(this, t, getContext().getSamplingFrequency());
		previousInputValue = ValueFactory.INSTANCE.newValue(this, t, BlockDiagramUtil.getParameterValue(getBlock(), DiscreteDerivativeConstants.PARAMETER__INITIAL_CONDITION, ""), 0);
		gain = ValueFactory.INSTANCE.newValue(this, t, BlockDiagramUtil.getParameterValue(getBlock(), DiscreteDerivativeConstants.PARAMETER__GAIN, ""), 1);
	}
	
	public void consumeInputValue(InputPort inputPort, Value value) {
		inputValue = value;
	}
	
	public Value getOutputValue(OutputPort outputPort) {
		return inputValue.subtract(this, previousInputValue).multiply(this, samplingFrequency).multiply(this, gain);
	}
	
	public void update() {
		previousInputValue = inputValue;
	}
	
}
