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

import java.util.LinkedList;
import java.util.Queue;

import org.esmp.dsm.expressions.DataType;
import org.esmp.dsm.library.discrete.util.DelayConstants;
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
public class DelaySimulationModel extends AbstractSimulationModel {

	private Queue<Value> inputQueue;
	
	public void initialize() {
		DataType t = getBlockDataType();
		Value initialCondition = ValueFactory.INSTANCE.newValue(this, t, BlockDiagramUtil.getParameterValue(getBlock(), DelayConstants.PARAMETER__INITIAL_CONDITION, ""), 0);
		int delay = BlockDiagramUtil.getParameterValueAsInteger(getBlock(), DelayConstants.PARAMETER__DELAY, 1);

		if (delay < 1) {
			delay = 1;
		}
		
		inputQueue = new LinkedList<Value>();
		for (int i = 0; i < delay; ++i) {
			inputQueue.add(initialCondition);
		}
	}
	
	public void consumeInputValue(InputPort inputPort, Value value) {
		inputQueue.add(value);
	}
	
	public Value getOutputValue(OutputPort outputPort) {
		return inputQueue.peek();
	}
	
	public void update() {
		if (!inputQueue.isEmpty()) {
			inputQueue.remove();
		}
	}
	
}
