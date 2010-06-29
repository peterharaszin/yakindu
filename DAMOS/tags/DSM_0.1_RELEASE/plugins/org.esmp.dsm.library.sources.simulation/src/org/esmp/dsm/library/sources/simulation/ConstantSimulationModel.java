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
import org.esmp.dsm.library.sources.util.ConstantConstants;
import org.esmp.dsm.semantic.blockdiagram.OutputPort;
import org.esmp.dsm.semantic.blockdiagram.util.BlockDiagramUtil;
import org.esmp.dsm.simulation.AbstractSimulationModel;
import org.esmp.dsm.simulation.Value;
import org.esmp.dsm.simulation.ValueFactory;

/**
 * @author Andreas Unger
 *
 */
public class ConstantSimulationModel extends AbstractSimulationModel {

	private Value value;
	
	public void initialize() {
		DataType t = getBlockDataType();
		value = ValueFactory.INSTANCE.newValue(this, t, BlockDiagramUtil.getParameterValue(getBlock(), ConstantConstants.PARAMETER__VALUE, ""), 0);
	}
	
	public Value getOutputValue(OutputPort outputPort) {
		return value;
	}
	
}
