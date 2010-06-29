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

package org.esmp.dsm.library.logic.simulation;

import org.esmp.dsm.execution.datatype.util.DataTypeUtil;
import org.esmp.dsm.expressions.DataType;
import org.esmp.dsm.library.logic.util.SchmittTriggerConstants;
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
public class SchmittTriggerSimulationModel extends AbstractSimulationModel {

	private Value one;
	private Value zero;

	private Value upperThreshold;
	private Value lowerThreshold;

	private Value outputValue;
	
	public void initialize() {
		DataType t = getBlockDataType();

		one = ValueFactory.INSTANCE.newValue(this, t, true);
		zero = ValueFactory.INSTANCE.newValue(this, t, false);
		
		DataType inputDataType = DataTypeUtil.getDataType(getBlock().getInputPorts().get(0));
		
		upperThreshold = ValueFactory.INSTANCE.newValue(this, inputDataType, BlockDiagramUtil.getParameterValue(getBlock(), SchmittTriggerConstants.PARAMETER__UPPER_THRESHOLD, ""), 1);
		lowerThreshold = ValueFactory.INSTANCE.newValue(this, inputDataType, BlockDiagramUtil.getParameterValue(getBlock(), SchmittTriggerConstants.PARAMETER__LOWER_THRESHOLD, ""), -1);
		outputValue = BlockDiagramUtil.getParameterValueAsBoolean(getBlock(), SchmittTriggerConstants.PARAMETER__INITIAL_OUTPUT, false) ? one : zero;
	}
	
	public void consumeInputValue(InputPort inputPort, Value value) {
		if (value.compareTo(lowerThreshold) < 0) {
			outputValue = zero;
		} else if (value.compareTo(upperThreshold) > 0) {
			outputValue = one;
		}
	}
	
	public Value getOutputValue(OutputPort outputPort) {
		return outputValue;
	}
	
}
