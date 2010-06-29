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
import org.esmp.dsm.simulation.AbstractSimulationModel;
import org.esmp.dsm.simulation.Value;
import org.esmp.dsm.simulation.ValueFactory;

/**
 * @author Andreas Unger
 *
 */
public class InverterSimulationModel extends AbstractSimulationModel {

	private Value inputValue;
	
	public void consumeInputValue(InputPort inputPort, Value value) {
		inputValue = value;
	}
	
	public Value getOutputValue(OutputPort outputPort) {
		DataType t = getBlockDataType();
		return inputValue != null && inputValue.compareTo(ValueFactory.INSTANCE.newValue(this, t, 0)) == 0 ? ValueFactory.INSTANCE.newValue(this, t, 1) : ValueFactory.INSTANCE.newValue(this, t, 0);
	}
	
}
