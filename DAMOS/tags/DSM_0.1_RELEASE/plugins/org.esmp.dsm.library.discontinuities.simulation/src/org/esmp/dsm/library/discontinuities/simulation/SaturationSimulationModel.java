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

package org.esmp.dsm.library.discontinuities.simulation;

import org.esmp.dsm.expressions.DataType;
import org.esmp.dsm.library.discontinuities.util.SaturationConstants;
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
public class SaturationSimulationModel extends AbstractSimulationModel {
	
	private Value upperLimit;
	private Value lowerLimit;
	private Value inputValue;
	
	public void initialize() {
		DataType t = getBlockDataType();
		upperLimit = ValueFactory.INSTANCE.newValue(this, t, BlockDiagramUtil.getParameterValue(getBlock(), SaturationConstants.PARAMETER__UPPER_LIMIT, ""), 1);
		lowerLimit = ValueFactory.INSTANCE.newValue(this, t, BlockDiagramUtil.getParameterValue(getBlock(), SaturationConstants.PARAMETER__LOWER_LIMIT, ""), -1);
	}
	
	public void consumeInputValue(InputPort inputPort, Value value) {
		inputValue = value;
	}
	
	public Value getOutputValue(OutputPort outputPort) {
		if (inputValue.compareTo(upperLimit) > 0) {
			return upperLimit;
		}
		if (inputValue.compareTo(lowerLimit) < 0) {
			return lowerLimit;
		}
		return inputValue;
	}

}
