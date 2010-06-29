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

package org.esmp.dsm.library.math.simulation;

import java.util.List;

import org.esmp.dsm.expressions.DataType;
import org.esmp.dsm.library.math.util.SumConstants;
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
public class SumSimulationModel extends AbstractSimulationModel {
	
	private int[] inputSigns;
	private Value sum;

	public void initialize() {
		DataType t = getBlockDataType();

		List<InputPort> inputPorts = getBlock().getInputs().get(0).getPorts();
		int inputPortCount = inputPorts.size();
		
		inputSigns = new int[inputPortCount];
		sum = ValueFactory.INSTANCE.newValue(this, t, 0);

		int i = 0;
		for (InputPort inputPort : inputPorts) {
			inputSigns[i] = BlockDiagramUtil.getParameterValueAsInteger(inputPort, SumConstants.PORT_PARAMETER__SIGN, 1);
			++i;
		}
	}
	
	public void consumeInputValue(InputPort inputPort, Value value) {
		if (inputSigns[BlockDiagramUtil.getIndex(inputPort)] >= 0) {
			sum = sum.add(this, value);
		} else {
			sum = sum.subtract(this, value);
		}
	}
	
	public Value getOutputValue(OutputPort outputPort) {
		return sum;
	}
	
	public void update() {
		DataType t = getBlockDataType();
		sum = ValueFactory.INSTANCE.newValue(this, t, 0);
	}

}
