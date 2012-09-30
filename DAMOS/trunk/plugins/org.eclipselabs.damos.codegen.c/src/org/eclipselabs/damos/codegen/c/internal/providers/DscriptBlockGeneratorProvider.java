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

package org.eclipselabs.damos.codegen.c.internal.providers;

import org.eclipselabs.damos.codegen.c.IComponentGenerator;
import org.eclipselabs.damos.codegen.c.IComponentGeneratorProvider;
import org.eclipselabs.damos.codegen.c.internal.componentgenerators.DscriptBlockGenerator;
import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dscript.DscriptBlockType;
import org.eclipselabs.damos.execution.ComponentNode;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Andreas Unger
 *
 */
public class DscriptBlockGeneratorProvider implements IComponentGeneratorProvider {

	private final Provider<DscriptBlockGenerator> blockGeneratorProvider;
	
	@Inject
	DscriptBlockGeneratorProvider(Provider<DscriptBlockGenerator> blockGeneratorProvider) {
		this.blockGeneratorProvider = blockGeneratorProvider;
	}
	
	public IComponentGenerator createGenerator(ComponentNode node) {
		if (node.getComponent() instanceof Block) {
			Block block = (Block) node.getComponent();
			if (block.getType() instanceof DscriptBlockType) {
				DscriptBlockType blockType = (DscriptBlockType) block.getType();
				if (blockType.getBehavior() != null) {
					return blockGeneratorProvider.get();
				}
			}
		}
		return null;
	}

}
