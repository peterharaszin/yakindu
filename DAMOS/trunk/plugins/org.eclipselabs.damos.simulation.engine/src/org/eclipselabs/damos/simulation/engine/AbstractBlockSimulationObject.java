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

/**
 * @author Andreas Unger
 *
 */
public abstract class AbstractBlockSimulationObject extends AbstractComponentSimulationObject {

	@Override
	public Block getComponent() {
		return (Block) super.getComponent();
	}

	@Override
	public void setInfo(IComponentSimulationInfo info) {
		if (!(info.getComponent() instanceof Block)) {
			throw new IllegalArgumentException("Component must be instance of Block");
		}
		super.setInfo(info);
	}
		
}
