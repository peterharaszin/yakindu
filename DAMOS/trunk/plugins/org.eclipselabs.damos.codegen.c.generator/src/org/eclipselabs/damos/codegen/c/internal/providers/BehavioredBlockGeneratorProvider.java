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
import org.eclipselabs.damos.codegen.c.internal.generators.BehavioredBlockGenerator;
import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dmltext.MscriptBlockType;

/**
 * @author Andreas Unger
 *
 */
public class BehavioredBlockGeneratorProvider implements IComponentGeneratorProvider {

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.IComponentGeneratorProvider#createGenerator(org.eclipselabs.damos.dml.Component)
	 */
	public IComponentGenerator createGenerator(Component component) {
		if (component instanceof Block) {
			Block block = (Block) component;
			if (block.getType() instanceof MscriptBlockType) {
				MscriptBlockType mscriptBlockType = (MscriptBlockType) block.getType();
				if (!mscriptBlockType.getDeclarations().isEmpty()) {
					return new BehavioredBlockGenerator();
				}
			}
		}
		return null;
	}

}
