/****************************************************************************
 * Copyright (c) 2008, 2010 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.esmp.dsm.library.signal.simulation;

import org.esmp.dsm.expressions.BooleanDataType;
import org.esmp.dsm.library.signal.util.SwitchConstants;
import org.esmp.dsm.semantic.blockdiagram.InputPort;
import org.esmp.dsm.semantic.blockdiagram.OutputPort;
import org.esmp.dsm.simulation.AbstractSimulationModel;
import org.esmp.dsm.simulation.Value;
import org.esmp.dsm.simulation.ValueFactory;

/**
 * @author Andreas Unger
 *
 */
public class SwitchSimulationModel extends AbstractSimulationModel {

	private Value falseValue;
	
	private Value controlInputValue;
	private Value onTrueInputValue;
	private Value onFalseInputValue;
	
	public void consumeInputValue(InputPort inputPort, Value value) {
		falseValue = ValueFactory.INSTANCE.newValue(this, new BooleanDataType(), false);
		
		String inputName = inputPort.getInput().getSpecification().getName();
		if (SwitchConstants.INPUT__CONTROL.equals(inputName)) {
			controlInputValue = value;
		} else if (SwitchConstants.INPUT__ON_TRUE.equals(inputName)) {
			onTrueInputValue = value;
		} else if (SwitchConstants.INPUT__ON_FALSE.equals(inputName)) {
			onFalseInputValue = value;
		}
	}
	
	public Value getOutputValue(OutputPort outputPort) {
		return controlInputValue.compareTo(falseValue) != 0 ? onTrueInputValue : onFalseInputValue;
	}

}
