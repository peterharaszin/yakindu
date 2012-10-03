/****************************************************************************
 * Copyright (c) 2008, 2011 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipse.damos.dml.internal.operations;

import org.eclipse.damos.dml.Block;
import org.eclipse.damos.dml.BlockInput;
import org.eclipse.damos.dml.BlockOutput;
import org.eclipse.damos.dml.BlockType;
import org.eclipse.damos.dml.DMLFactory;
import org.eclipse.damos.dml.InputDefinition;
import org.eclipse.damos.dml.OutputDefinition;
import org.eclipse.damos.dml.internal.util.ConfigureUtil;

public class BlockTypeOperations {

	public static Block newInstance(BlockType blockType, String name) {
		Block block = DMLFactory.eINSTANCE.createBlock();
		block.setType(blockType);
		block.setName(name);
		
		switch (blockType.getTiming()) {
		case CONTINUOUS:
			block.setTimingConstraint(DMLFactory.eINSTANCE.createContinuousTimingConstraint());
			break;
		case ASYNCHRONOUS:
			block.setTimingConstraint(DMLFactory.eINSTANCE.createAsynchronousTimingConstraint());
			break;
		default:
			break;
		}
		
		ConfigureUtil.configureParameters(block);
		
		for (InputDefinition definition : block.getType().getInputDefinitions()) {
			BlockInput input = DMLFactory.eINSTANCE.createBlockInput();
			input.setDefinition(definition);
			block.getInputs().add(input);

			int portCount = Math.max(definition.getDefaultPortCount(), definition.getMinimumPortCount());
			for (int i = 0; i < portCount; ++i) {
				input.createPort();
			}
		}
		
		for (OutputDefinition definition : block.getType().getOutputDefinitions()) {
			BlockOutput output = DMLFactory.eINSTANCE.createBlockOutput();
			output.setDefinition(definition);
			block.getOutputs().add(output);
			
			int portCount = Math.max(definition.getDefaultPortCount(), definition.getMinimumPortCount());
			for (int i = 0; i < portCount; ++i) {
				output.createPort();
			}
		}
		
		return block;
	}

}
