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

package org.eclipselabs.damos.dml.internal.operations;

import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.BlockInput;
import org.eclipselabs.damos.dml.BlockOutput;
import org.eclipselabs.damos.dml.BlockType;
import org.eclipselabs.damos.dml.DMLFactory;
import org.eclipselabs.damos.dml.InputDefinition;
import org.eclipselabs.damos.dml.OutputDefinition;
import org.eclipselabs.damos.dml.internal.util.ConfigureUtil;

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
