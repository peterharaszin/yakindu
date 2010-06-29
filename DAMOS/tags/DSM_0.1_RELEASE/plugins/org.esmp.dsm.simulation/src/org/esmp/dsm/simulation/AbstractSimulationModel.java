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

package org.esmp.dsm.simulation;

import org.esmp.dsm.execution.datatype.util.DataTypeUtil;
import org.esmp.dsm.expressions.DataType;
import org.esmp.dsm.semantic.blockdiagram.Block;
import org.esmp.dsm.semantic.blockdiagram.InputPort;
import org.esmp.dsm.semantic.blockdiagram.OutputPort;

/**
 * @author Andreas Unger
 *
 */
public abstract class AbstractSimulationModel implements SimulationModel {
	
	private Block block;
	private SimulationContext context;
	
	public final Block getBlock() {
		return block;
	}
	
	public final void setBlock(Block block) {
		this.block = block;
	}

	public final SimulationContext getContext() {
		return context;
	}
	
	public final void setContext(SimulationContext context) {
		this.context = context;
	}
	
	public void initialize() throws SimulationException {
	}
	
	public void consumeInputValue(InputPort inputPort, Value value) throws SimulationException {
	}
	
	public void computeOutputValues() throws SimulationException {
	}

	public Value getOutputValue(OutputPort outputPort) throws SimulationException {
		return null;
	}
	
	public void update() throws SimulationException {
	}
		
	protected final DataType getBlockDataType() {
		return DataTypeUtil.getDataType(block);
	}
	
}