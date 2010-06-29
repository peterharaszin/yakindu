package org.esmp.dsm.library.signal.simulation;

import org.esmp.dsm.semantic.blockdiagram.InputPort;
import org.esmp.dsm.semantic.blockdiagram.OutputPort;
import org.esmp.dsm.simulation.AbstractSimulationModel;
import org.esmp.dsm.simulation.Value;

public class DataTypeConversionSimulationModel extends AbstractSimulationModel {

	private Value inputValue;
	
	public void consumeInputValue(InputPort inputPort, Value value) {
		inputValue = value;
	}
	
	public Value getOutputValue(OutputPort outputPort) {
		return inputValue.cast(this, getBlockDataType());
	}
	
}
