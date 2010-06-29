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

package org.esmp.dsm.library.sources.simulation;

import org.esmp.dsm.expressions.DataType;
import org.esmp.dsm.library.sources.util.SineWaveConstants;
import org.esmp.dsm.semantic.blockdiagram.OutputPort;
import org.esmp.dsm.semantic.blockdiagram.util.BlockDiagramUtil;
import org.esmp.dsm.simulation.AbstractSimulationModel;
import org.esmp.dsm.simulation.Value;
import org.esmp.dsm.simulation.ValueFactory;

/**
 * @author Andreas Unger
 *
 */
public class SineWaveSimulationModel extends AbstractSimulationModel {

	private long samplingFrequency;

	private double amplitude;
	private double bias;
	private double frequency;
	private double phase;
	
	private int n;
	private Value value;
	
	public void initialize() {
		amplitude = BlockDiagramUtil.getParameterValueAsDouble(getBlock(), SineWaveConstants.PARAMETER__AMPLITUDE, 1);
		bias = BlockDiagramUtil.getParameterValueAsDouble(getBlock(), SineWaveConstants.PARAMETER__BIAS, 0);
		frequency = BlockDiagramUtil.getParameterValueAsDouble(getBlock(), SineWaveConstants.PARAMETER__FREQUENCY, 1);
		phase = BlockDiagramUtil.getParameterValueAsDouble(getBlock(), SineWaveConstants.PARAMETER__PHASE, 0);
		
		samplingFrequency = getContext().getSamplingFrequency();
		
		n = 0;
		updateValue();
	}
		
	public Value getOutputValue(OutputPort outputPort) {
		return value;
	}
	
	public void update() {
		++n;
		updateValue();
	}

	private void updateValue() {
		DataType t = getBlockDataType();
		value = ValueFactory.INSTANCE.newValue(this, t, amplitude * Math.sin(2 * Math.PI * frequency * n / samplingFrequency + Math.toRadians(phase)) + bias);
	}

}
