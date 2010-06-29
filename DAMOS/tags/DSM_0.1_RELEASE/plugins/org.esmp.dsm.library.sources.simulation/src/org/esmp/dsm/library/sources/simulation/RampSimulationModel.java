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
import org.esmp.dsm.library.sources.util.RampConstants;
import org.esmp.dsm.semantic.blockdiagram.OutputPort;
import org.esmp.dsm.semantic.blockdiagram.util.BlockDiagramUtil;
import org.esmp.dsm.simulation.AbstractSimulationModel;
import org.esmp.dsm.simulation.Value;
import org.esmp.dsm.simulation.ValueFactory;

/**
 * @author Andreas Unger
 *
 */
public class RampSimulationModel extends AbstractSimulationModel {

	private long samplingFrequency;

	private Value initialValue;
	private double startTime;
	private double slope;
	
	private int n;
	
	public void initialize() {
		DataType t = getBlockDataType();
		
		samplingFrequency = getContext().getSamplingFrequency();

		initialValue = ValueFactory.INSTANCE.newValue(this, t, BlockDiagramUtil.getParameterValue(getBlock(), RampConstants.PARAMETER__INITIAL_VALUE, ""), 0);
		startTime = BlockDiagramUtil.getParameterValueAsDouble(getBlock(), RampConstants.PARAMETER__START_TIME, 0);
		slope = BlockDiagramUtil.getParameterValueAsDouble(getBlock(), RampConstants.PARAMETER__SLOPE, 1);
		
		n = 0;
	}
	
	public Value getOutputValue(OutputPort outputPort) {
		DataType t = getBlockDataType();
		double time = (double) n / samplingFrequency;
		return time <= startTime ? initialValue : ValueFactory.INSTANCE.newValue(this, t, slope * (time - startTime));
	}
	
	public void update() {
		++n;
	}
	
}
