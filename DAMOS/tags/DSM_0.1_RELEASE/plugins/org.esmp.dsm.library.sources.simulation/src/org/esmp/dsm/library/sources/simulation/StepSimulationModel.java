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
import org.esmp.dsm.library.sources.util.StepConstants;
import org.esmp.dsm.semantic.blockdiagram.OutputPort;
import org.esmp.dsm.semantic.blockdiagram.util.BlockDiagramUtil;
import org.esmp.dsm.simulation.AbstractSimulationModel;
import org.esmp.dsm.simulation.Value;
import org.esmp.dsm.simulation.ValueFactory;

/**
 * @author Andreas Unger
 *
 */
public class StepSimulationModel extends AbstractSimulationModel {

	private Value initialValue;
	private Value finalValue;
	private double stepTime;
	
	private long samplingFrequency;
	
	private int n;
	
	public void initialize() {
		DataType t = getBlockDataType();
		initialValue = ValueFactory.INSTANCE.newValue(this, t, BlockDiagramUtil.getParameterValue(getBlock(), StepConstants.PARAMETER__INITIAL_VALUE, ""), 0);
		finalValue = ValueFactory.INSTANCE.newValue(this, t, BlockDiagramUtil.getParameterValue(getBlock(), StepConstants.PARAMETER__FINAL_VALUE, ""), 1);
		stepTime = BlockDiagramUtil.getParameterValueAsDouble(getBlock(), StepConstants.PARAMETER__STEP_TIME, 1);
		
		samplingFrequency = getContext().getSamplingFrequency();
		
		n = 0;
	}
	
	public Value getOutputValue(OutputPort outputPort) {
		return (double) n / samplingFrequency <= stepTime ? initialValue : finalValue;
	}
	
	public void update() {
		++n;
	}
	
}
