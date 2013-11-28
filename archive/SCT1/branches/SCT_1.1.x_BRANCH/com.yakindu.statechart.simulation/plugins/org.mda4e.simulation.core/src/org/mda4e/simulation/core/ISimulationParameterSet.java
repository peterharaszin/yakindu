/**
 * Copyright (c) 2006-2009 committers of mda4e and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of mda4e (http://www.mda4e.org/) - initial API and implementation
 *
 */
package org.mda4e.simulation.core;

import java.io.File;

/**
 * This interface defines the required methods of a parameter set
 * for a {@link ISimulationEngine}.
 * 
 * @author Markus M�hlbrandt
 * @author Philipp Richter
 */
public interface ISimulationParameterSet {
	
	/**
	 * Allows to read the specified simulation system which shall
	 * be simulated.
	 * 
	 * @return 	The simulation system which shall be simulated. If
	 * 			system is undefined the result is <code>null</code>.
	 */
	public File getSimulationSystem();
	
	/**
	 * Provides the instance number. For more informations see
	 * {@link ISimulationEngine#getInstanceNumber()}.
	 * 
	 * @return 	The instance number of the system instance. If the
	 * 			instance number is unknown the result is -1.
	 */
	public int getInstanceNumber();
}
