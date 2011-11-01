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

package org.eclipselabs.damos.simulation.simulationmodel.internal.operations;

import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.simulation.simulationmodel.SolverArgument;
import org.eclipselabs.damos.simulation.simulationmodel.SolverConfiguration;

/**
 * @author Andreas Unger
 *
 */
public class SolverConfigurationOperations {

	public static SolverArgument getArgument(SolverConfiguration solverConfiguration, String name) {
		for (SolverArgument argument : solverConfiguration.getArguments()) {
			if (name.equals(argument.getParameter().getName())) {
				return argument;
			}
		}
		return null;
	}

	public static Expression getArgumentValue(SolverConfiguration solverConfiguration, String name) {
		SolverArgument argument = getArgument(solverConfiguration, name);
		return argument != null ? argument.getValue() : null;
	}

}
