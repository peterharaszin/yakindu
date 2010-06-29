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

import org.esmp.dsm.expressions.DataType;
import org.esmp.dsm.library.math.util.GainConstants;
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
public class GainSimulationModel extends AbstractSimulationModel {
	
	private Value gain;
	private Value inputValue;
	
	public void initialize() {
		DataType t = getBlockDataType();
		gain = ValueFactory.INSTANCE.newValue(this, t, BlockDiagramUtil.getParameterValue(getBlock(), GainConstants.PARAMETER__GAIN, ""), 1);
		inputValue = ValueFactory.INSTANCE.newValue(this, t, 0);
	}
	
	public void consumeInputValue(InputPort inputPort, Value value) {
		inputValue = value;
	}
	
	public Value getOutputValue(OutputPort outputPort) {
		return inputValue.multiply(this, gain);
	}

}
