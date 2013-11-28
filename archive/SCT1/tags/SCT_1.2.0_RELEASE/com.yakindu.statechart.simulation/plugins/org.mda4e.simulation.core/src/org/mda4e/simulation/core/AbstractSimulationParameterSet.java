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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.debug.core.ILaunchConfiguration;

/**
 * The <code>abstract</code> class defines all possible properties of a simulation
 * engine. The engine will get this parameter set before it can be initialized.
 */
public abstract class AbstractSimulationParameterSet implements ISimulationParameterSet{
	
	/**
	 * Defines the constant to be able to read the simulation system.
	 * 
	 * @see #simulationSystemFile
	 * @see ILaunchConfiguration
	 */
	public static final String SimulationSystem = "SimulationSystem";
	
	/**
	 * Defines the constant to be able to read the instance number.
	 * 
	 * @see #instanceNumber
	 * @see ILaunchConfiguration
	 */
	public static final String InstanceNumber = "InstanceNumber";
	
	/**
	 * Defines the <code>File</code> which contains the system which shall be
	 * simulated.
	 */
	private File simulationSystemFile;
	
	/**
	 * Defines the instance number of the system which shall be simulated.
	 * The instance number is required, if more than one instances of the
	 * same system must be simulated.
	 */
	private int instanceNumber;
	
	/*
	 * @see org.mda4e.simulation.core.ISimulationParameterSet#getSimulationSystem()
	 */
	public File getSimulationSystem() {
		return simulationSystemFile;
	}
	
	/*
	 * @see org.mda4e.simulation.core.ISimulationParameterSet#getInstanceNumber()
	 */
	public int getInstanceNumber(){
		return instanceNumber;
	}
	
	/**
	 * Allows to specify the default parameter set which is declared by this class
	 * of the simulation engine. All simulation engine specific parameters are defined
	 * by the method {@link #setEngineSpecificParameters(ILaunchConfiguration)}.
	 * 
	 * @param configuration		defines the parameter set for the simulation engine
	 * 
	 * @throws CoreException	will be thrown, if the {@link ILaunchConfiguration}
	 * 							is not valid
	 */
	public void setEngineBaseParameters(ILaunchConfiguration configuration) throws CoreException {
		String projectName = configuration.getAttribute("PROJECT_NAME", "");
		String fileName = configuration.getAttribute(SimulationSystem, "");
		IFile file = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName).getFile(Path.fromOSString(fileName));
		simulationSystemFile = file.getRawLocation().toFile();
		instanceNumber = configuration.getAttribute(InstanceNumber, 1);
	}
	
	/**
	 * Allows to define the engine specific parameters which are not declared in this class and
	 * can be implemented in sub classes.
	 * 
	 * @param configuration		defines the engine specific parameter set for the simulation engine
	 * 
	 * @throws CoreException	will be thrown, if the {@link ILaunchConfiguration}
	 * 							is not valid
	 */
	public abstract void setEngineSpecificParameters(ILaunchConfiguration configuration) throws CoreException;
	
}