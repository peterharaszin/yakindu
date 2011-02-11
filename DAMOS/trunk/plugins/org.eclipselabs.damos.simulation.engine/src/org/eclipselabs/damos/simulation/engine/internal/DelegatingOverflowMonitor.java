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

package org.eclipselabs.damos.simulation.engine.internal;

import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.simulation.engine.IComponentOverflowMonitor;
import org.eclipselabs.damos.simulation.engine.ISimulationContext;
import org.eclipselabs.mscript.computation.engine.IOverflowMonitor;
import org.eclipselabs.mscript.computation.engine.OverflowInfo;

/**
 * @author Andreas Unger
 *
 */
public class DelegatingOverflowMonitor implements IOverflowMonitor {

	private ISimulationContext context;
	private Component component;
	private IComponentOverflowMonitor componentOverflowMonitor;
	
	/**
	 * 
	 */
	public DelegatingOverflowMonitor(ISimulationContext context, Component component, IComponentOverflowMonitor componentOverflowMonitor) {
		this.context = context;
		this.component = component;
		this.componentOverflowMonitor = componentOverflowMonitor;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.computation.engine.IOverflowMonitor#handleOverflow(org.eclipselabs.mscript.computation.engine.OverflowInfo)
	 */
	public void handleOverflow(OverflowInfo info) {
		componentOverflowMonitor.handleOverflow(context, component, info);
	}

}
