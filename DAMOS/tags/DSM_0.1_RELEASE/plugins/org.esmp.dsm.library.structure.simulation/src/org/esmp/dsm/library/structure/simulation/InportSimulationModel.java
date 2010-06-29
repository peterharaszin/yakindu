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

package org.esmp.dsm.library.structure.simulation;

import org.esmp.dsm.semantic.blockdiagram.InputPort;
import org.esmp.dsm.semantic.blockdiagram.OutputPort;
import org.esmp.dsm.simulation.AbstractSimulationModel;
import org.esmp.dsm.simulation.Value;
import org.esmp.dsm.simulation.ValueFactory;

/**
 * @author Andreas Unger
 *
 */
public class InportSimulationModel extends AbstractSimulationModel {

	private Value outputValue;
	
	public void initialize() {
		outputValue = ValueFactory.INSTANCE.newValue(this, getBlockDataType(), 0);
	}
	
	public void consumeInputValue(InputPort inputPort, Value value) {
		outputValue = value;
	}
	
	public Value getOutputValue(OutputPort outputPort) {
		return outputValue.cast(this, getBlockDataType());
	}
	
}
