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

package org.eclipselabs.damos.codegen.c.generator;

import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.execution.executionflow.ComponentNode;

/**
 * @author Andreas Unger
 *
 */
public abstract class AbstractBlockGenerator extends AbstractComponentGenerator {

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.generator.AbstractComponentGenerator#getComponent()
	 */
	@Override
	public Block getComponent() {
		return (Block) super.getComponent();
	}
	
	@Override
	public void setNode(ComponentNode node) {
		if (!(node.getComponent() instanceof Block)) {
			throw new IllegalArgumentException("Component must be instance of Block");
		}
		super.setNode(node);
	}
	
}
