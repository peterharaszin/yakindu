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

package org.eclipselabs.damos.simulation.simulator;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipselabs.damos.dml.Block;

/**
 * @author Andreas Unger
 *
 */
public abstract class AbstractBlockSimulationObject extends AbstractSimulationObject {

	@Override
	public Block getComponent() {
		return (Block) super.getComponent();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.simulator.AbstractSimulationObject#initialize(org.eclipselabs.damos.simulation.simulator.ISimulationObjectContext, org.eclipselabs.damos.simulation.simulator.ISimulationMonitor)
	 */
	@Override
	public void initialize(ISimulationObjectContext context, IProgressMonitor monitor) throws CoreException {
		if (!(context.getNode().getComponent() instanceof Block)) {
			throw new IllegalArgumentException("Component must be instance of Block");
		}
		super.initialize(context, monitor);
	}

}
