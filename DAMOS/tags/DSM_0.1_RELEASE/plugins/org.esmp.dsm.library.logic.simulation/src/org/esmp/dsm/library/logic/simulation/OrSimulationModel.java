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

import org.esmp.dsm.expressions.DataType;
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
public class OrSimulationModel extends AbstractSimulationModel {

	private Value[] inputValues;

	public void initialize() {
		inputValues = new Value[getBlock().getInputs().get(0).getPorts().size()];
	}

	public void consumeInputValue(InputPort inputPort, Value value) {
		inputValues[BlockDiagramUtil.getIndex(inputPort)] = value;
	}

	public Value getOutputValue(OutputPort outputPort) {
		DataType t = getBlockDataType();
		for (int i = 0; i < inputValues.length; ++i) {
			if (inputValues[i] != null && inputValues[i].compareTo(ValueFactory.INSTANCE.newValue(this, t, 0)) != 0) {
				return ValueFactory.INSTANCE.newValue(this, t, 1);
			}
		}
		return ValueFactory.INSTANCE.newValue(this, t, 0);
	}

}
