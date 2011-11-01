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

package org.eclipselabs.damos.simulation.ide.core.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Collections;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipselabs.damos.dml.Fragment;
import org.eclipselabs.damos.execution.executionmodel.ExecutionModel;
import org.eclipselabs.damos.execution.executionmodel.ExecutionModelFactory;
import org.eclipselabs.damos.simulation.ide.core.SimulationIDECorePlugin;
import org.eclipselabs.damos.simulation.ide.core.internal.launch.SimulationLaunchConfigurationDelegate;
import org.eclipselabs.damos.simulation.simulationmodel.SimulationModel;
import org.eclipselabs.damos.simulation.simulationmodel.SimulationModelFactory;
import org.eclipselabs.damos.simulation.simulationmodel.SolverConfiguration;
import org.eclipselabs.damos.simulation.simulationmodel.SolverType;
import org.eclipselabs.damos.simulation.simulationmodel.registry.ISolverTypeDescriptor;
import org.eclipselabs.damos.simulation.simulationmodel.registry.ISolverTypeRegistry;
import org.eclipselabs.damos.simulation.simulationmodel.util.SimulationModelUtil;

/**
 * @author Andreas Unger
 *
 */
public class LaunchConfigurationUtil {

	private static final String TEMPORARY_SIMULATIONMODEL_FILE_NAME = "temp.xmi";

	public static SimulationModel loadSimulationModel(ILaunchConfiguration configuration) throws CoreException {
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.createResource(URI.createURI(TEMPORARY_SIMULATIONMODEL_FILE_NAME));
		ByteArrayInputStream inputStream = new ByteArrayInputStream(configuration.getAttribute(SimulationLaunchConfigurationDelegate.ATTRIBUTE__SIMULATION_MODEL, "").getBytes());

		try {
			resource.load(inputStream, Collections.emptyMap());
		} catch (IOException e) {
			throw new CoreException(new Status(IStatus.ERROR, SimulationIDECorePlugin.PLUGIN_ID, "Loading resource failed", e));
		}

		if (resource.getContents().isEmpty() || !(resource.getContents().get(0) instanceof SimulationModel)) {
			throw new CoreException(new Status(IStatus.ERROR, SimulationIDECorePlugin.PLUGIN_ID, "Invalid simulation model stored in launch configuration"));
		}

		return (SimulationModel) resource.getContents().get(0);
	}

	public static void storeSimulationModel(ILaunchConfigurationWorkingCopy configuration, SimulationModel simulationModel) {
		try {
			ResourceSet resourceSet = new ResourceSetImpl();
			Resource resource = resourceSet.createResource(URI.createURI(TEMPORARY_SIMULATIONMODEL_FILE_NAME));
			resource.getContents().add(simulationModel);
			resource.getContents().add(simulationModel.getExecutionModel());
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			resource.save(outputStream, Collections.emptyMap());
			configuration.setAttribute(SimulationLaunchConfigurationDelegate.ATTRIBUTE__SIMULATION_MODEL, outputStream.toString("UTF-8"));
		} catch (IOException e) {
			SimulationIDECorePlugin.getDefault().getLog().log(new Status(IStatus.ERROR, SimulationIDECorePlugin.PLUGIN_ID, "Storing simulation model failed", e));
		}
	}
	
	public static SimulationModel createDefaultSimulationModel(Fragment topLevelFragment) {
		SimulationModel simulationModel = SimulationModelFactory.eINSTANCE.createSimulationModel();
		ExecutionModel executionModel = ExecutionModelFactory.eINSTANCE.createExecutionModel();
		simulationModel.setExecutionModel(executionModel);
		simulationModel.setTopLevelFragment(topLevelFragment);
		SimulationModelUtil.setSimulationTime(simulationModel, SimulationLaunchConfigurationDelegate.DEFAULT_SIMULATION_TIME);
		
		ISolverTypeDescriptor solverTypeDescriptor = ISolverTypeRegistry.INSTANCE.getSolverType(SimulationLaunchConfigurationDelegate.DEFAULT_SOLVER_TYPE);
		if (solverTypeDescriptor != null) {
			EObject eObject = topLevelFragment.eResource().getResourceSet().getEObject(solverTypeDescriptor.getURI(), true);
			if (eObject instanceof SolverType) {
				SolverType solverType = (SolverType) eObject;
				SolverConfiguration solverConfiguration = SimulationModelFactory.eINSTANCE.createSolverConfiguration();
				solverConfiguration.setType(solverType);
				SimulationModelUtil.setSolverArgumentValue(solverConfiguration, "minimumStepSize", 1e-10);
				SimulationModelUtil.setSolverArgumentValue(solverConfiguration, "absoluteTolerance", 1e-10);
				SimulationModelUtil.setSolverArgumentValue(solverConfiguration, "relativeTolerance", 1e-10);
				simulationModel.setSolverConfiguration(solverConfiguration);
			}
		}
		
		return simulationModel;
	}

}
