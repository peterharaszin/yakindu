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

package org.eclipselabs.damos.simulation.engine;

import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.Component;

/**
 * @author Andreas Unger
 *
 */
public abstract class AbstractBlockSimulationObject extends AbstractComponentSimulationObject {

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.engine.AbstractSimulationObject#getComponent()
	 */
	@Override
	public Block getComponent() {
		return (Block) super.getComponent();
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.engine.AbstractSimulationObject#setComponent(org.eclipselabs.damos.dml.Component)
	 */
	@Override
	public void setComponent(Component component) {
		if (!(component instanceof Block)) {
			throw new IllegalArgumentException("Component must be instance of Block");
		}
		super.setComponent(component);
	}
		
}
