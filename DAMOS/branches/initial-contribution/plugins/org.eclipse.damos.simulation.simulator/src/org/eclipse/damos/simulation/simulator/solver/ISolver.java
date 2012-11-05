/****************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipse.damos.simulation.simulator.solver;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.damos.simulation.ISimulationMonitor;
import org.eclipse.damos.simulation.simulator.internal.ISimulationContext;

/**
 * @author Andreas Unger
 *
 */
public interface ISolver {

	void initialize(ISimulationContext context, IProgressMonitor monitor) throws CoreException;
	
	void computeStep(ISimulationMonitor monitor) throws CoreException;
	
	double getTime();
	
}
