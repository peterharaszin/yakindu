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
import org.esmp.dsm.library.logic.util.CompareConstants;
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
public class CompareSimulationModel extends AbstractSimulationModel {

	private static final int EQUAL = 0;
	private static final int NOT_EQUAL = 1;
	private static final int LESS_THAN = 2;
	private static final int LESS_THAN_OR_EQUAL = 3;
	private static final int GREATER_THAN_OR_EQUAL = 4;
	private static final int GREATER_THAN = 5;
	
	private Value one;
	private Value zero;
	
	private int operator;
	private Value[] inputValues;

	public void initialize() {
		DataType t = getBlockDataType();
		
		one = ValueFactory.INSTANCE.newValue(this, t, 1);
		zero = ValueFactory.INSTANCE.newValue(this, t, 0);

		String operatorParameter = getBlock().getParameterValue(CompareConstants.PARAMETER__OPERATOR);
		if (CompareConstants.PARAMETER__OPERATOR__EQUAL.equals(operatorParameter)) {
			operator = EQUAL;
		} else if (CompareConstants.PARAMETER__OPERATOR__NOT_EQUAL.equals(operatorParameter)) {
			operator = NOT_EQUAL;
		} else if (CompareConstants.PARAMETER__OPERATOR__LESS_THAN.equals(operatorParameter)) {
			operator = LESS_THAN;
		} else if (CompareConstants.PARAMETER__OPERATOR__LESS_THAN_OR_EQUAL.equals(operatorParameter)) {
			operator = LESS_THAN_OR_EQUAL;
		} else if (CompareConstants.PARAMETER__OPERATOR__GREATER_THAN_OR_EQUAL.equals(operatorParameter)) {
			operator = GREATER_THAN_OR_EQUAL;
		} else if (CompareConstants.PARAMETER__OPERATOR__GREATER_THAN.equals(operatorParameter)) {
			operator = GREATER_THAN;
		}
		
		inputValues = new Value[] {
				ValueFactory.INSTANCE.newValue(this, DataTypeUtil.getDataType(getBlock().getInputPorts().get(0)), 0),
				ValueFactory.INSTANCE.newValue(this, DataTypeUtil.getDataType(getBlock().getInputPorts().get(1)), 0) };
	}

	public void consumeInputValue(InputPort inputPort, Value value) {
		inputValues[BlockDiagramUtil.getIndex(inputPort.getInput())] = value;
	}

	public Value getOutputValue(OutputPort outputPort) {
		int result = inputValues[0].compareTo(inputValues[1]);
		switch (operator) {
		case EQUAL:
			return result == 0 ? one : zero;
		case NOT_EQUAL:
			return result != 0 ? one : zero;
		case LESS_THAN:
			return result < 0 ? one : zero;
		case LESS_THAN_OR_EQUAL:
			return result < 0 || result == 0 ? one : zero;
		case GREATER_THAN_OR_EQUAL:
			return result > 0 || result == 0 ? one : zero;
		case GREATER_THAN:
			return result > 0 ? one : zero;
		}
		return zero;
	}

}
