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

package org.eclipselabs.damos.simulation.simulationmodel.registry;

import java.util.Collection;

import org.eclipselabs.damos.simulation.simulationmodel.internal.registry.SolverTypeRegistry;

/**
 * @author Andreas Unger
 *
 */
public interface ISolverTypeRegistry {

	ISolverTypeRegistry INSTANCE = new SolverTypeRegistry();
	
	Collection<ISolverTypeDescriptor> getSolverTypes();
	ISolverTypeDescriptor getSolverType(String id);

}