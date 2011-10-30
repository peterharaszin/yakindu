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

package org.eclipselabs.damos.codegen.c.generator.internal.providers;

import org.eclipselabs.damos.codegen.c.generator.IComponentGenerator;
import org.eclipselabs.damos.codegen.c.generator.IComponentGeneratorProvider;
import org.eclipselabs.damos.codegen.c.generator.internal.generators.BehavioredBlockGenerator;
import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dmltext.MscriptBehaviorSpecification;

/**
 * @author Andreas Unger
 *
 */
public class BehavioredBlockGeneratorProvider implements IComponentGeneratorProvider {

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.generator.IComponentGeneratorProvider#createGenerator(org.eclipselabs.damos.dml.Component)
	 */
	public IComponentGenerator createGenerator(Component component) {
		if (component instanceof Block) {
			Block block = (Block) component;
			if (block.getType().getBehavior() instanceof MscriptBehaviorSpecification) {
				return new BehavioredBlockGenerator();
			}
		}
		return null;
	}

}
