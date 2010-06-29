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

package org.esmp.dsm.simulation;

import org.esmp.dsm.semantic.blockdiagram.Block;
import org.esmp.dsm.semantic.blockdiagram.InputPort;
import org.esmp.dsm.semantic.blockdiagram.OutputPort;

/**
 * @author Andreas Unger
 *
 */
public interface SimulationModel {

	Block getBlock();
	void setBlock(Block block);
	
	SimulationContext getContext();
	void setContext(SimulationContext context);
	
	void initialize() throws SimulationException;
	
	void consumeInputValue(InputPort inputPort, Value value) throws SimulationException;
	
	void computeOutputValues() throws SimulationException;

	Value getOutputValue(OutputPort outputPort) throws SimulationException;
	
	void update() throws SimulationException;

}
