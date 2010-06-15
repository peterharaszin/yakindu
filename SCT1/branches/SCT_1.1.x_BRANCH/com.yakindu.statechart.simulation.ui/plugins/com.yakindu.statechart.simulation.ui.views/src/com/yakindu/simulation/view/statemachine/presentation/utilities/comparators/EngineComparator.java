/**
 * Copyright (c) 2010 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package com.yakindu.simulation.view.statemachine.presentation.utilities.comparators;

import java.io.Serializable;
import java.util.Comparator;

import org.mda4e.simulation.core.ISimulationEngine;

/**
 * Helps to compare {@link ISimulationEngine}s with the help of the system
 * names.
 * 
 * @author Philipp Richter
 */
public class EngineComparator implements Comparator<ISimulationEngine>, Serializable {

	/** */
	private static final long serialVersionUID = -7424666230005027470L;

	/**
	 * Compares the engines with the help of the system name. First of all the
	 * comparison is case insensitive, if the result is zero, the system names
	 * are compared case sensitive. If the result is zero again the result is 1.
	 * 
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	public int compare(final ISimulationEngine engine1,
			final ISimulationEngine engine2) {

		final String name1 = engine1.getSystemName();
		final String name2 = engine2.getSystemName();

		// Case insensitive
		int result = name1.compareToIgnoreCase(name2);

		if (result == 0) {

			// Case sensitive
			result = name1.compareTo(name2);

			// If equal -> name1 is "greater than" name2
			if (result == 0) {
				result = 1;
			}
		}

		return result;
	}
}
