package org.eclipselabs.damos.simulation.ide.core.internal.launch;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.LaunchConfigurationDelegate;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipselabs.damos.dml.Fragment;
import org.eclipselabs.damos.execution.executiongraph.ExecutionGraph;
import org.eclipselabs.damos.execution.executiongraph.construct.ExecutionGraphConstructor;
import org.eclipselabs.damos.execution.executionmodel.ExecutionModel;
import org.eclipselabs.damos.execution.executionmodel.ExecutionModelFactory;
import org.eclipselabs.damos.simulation.engine.ComponentSimulationObjectAdaptor;
import org.eclipselabs.damos.simulation.engine.SimulationEnginePlugin;
import org.eclipselabs.damos.simulation.simulationmodel.SimulationModel;
import org.eclipselabs.damos.simulation.simulationmodel.SimulationModelFactory;
import org.eclipselabs.mscript.computation.computationmodel.ComputationModel;
import org.eclipselabs.mscript.computation.computationmodel.util.ComputationModelUtil;

public class SimulationLaunchConfigurationDelegate extends LaunchConfigurationDelegate {

	public static final String LAUNCH_CONFIGURATION_TYPE = "org.eclipselabs.damos.simulation.ide.core.simulation";
	
	public static final String ATTRIBUTE__FRAGMENT_URI = "fragmentURI";
	public static final String ATTRIBUTE__SAMPLE_RATE = "sampleRate";
	public static final String ATTRIBUTE__SIMULATION_TIME = "simulationTime";
	
	public void launch(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor monitor) throws CoreException {
		String fragmentURIString = configuration.getAttribute(ATTRIBUTE__FRAGMENT_URI, "");
		if (fragmentURIString.length() == 0) {
			throw new CoreException(new Status(IStatus.ERROR, SimulationEnginePlugin.PLUGIN_ID, "No fragment specified"));
		}
		
		Fragment fragment = loadFragment(fragmentURIString);
		if (fragment == null) {
			throw new CoreException(new Status(IStatus.ERROR, SimulationEnginePlugin.PLUGIN_ID, "Could not load fragment '" + fragmentURIString + "'"));
		}
		
		ComputationModel computationModel = ComputationModelUtil.constructDefaultComputationModel();
		
		ExecutionModel executionModel = ExecutionModelFactory.eINSTANCE.createExecutionModel();
		executionModel.setComputationModel(computationModel);

		SimulationModel simulationModel = SimulationModelFactory.eINSTANCE.createSimulationModel();
		simulationModel.setExecutionModel(executionModel);
		
		try {
			executionModel.setSampleTime(1.0 / Long.parseLong(configuration.getAttribute(ATTRIBUTE__SAMPLE_RATE, "8000")));
		} catch (NumberFormatException e) {
			throw new CoreException(new Status(IStatus.ERROR, SimulationEnginePlugin.PLUGIN_ID, "Invalid sample rate"));
		}
		
		try {
			simulationModel.setSimulationTime(Double.parseDouble(configuration.getAttribute(ATTRIBUTE__SIMULATION_TIME, "10")));
		} catch (NumberFormatException e) {
			throw new CoreException(new Status(IStatus.ERROR, SimulationEnginePlugin.PLUGIN_ID, "Invalid simulation time"));
		}
		
		String name = new Path(fragmentURIString).toFile().getName();
		
		ExecutionGraph executionGraph = new ExecutionGraphConstructor().construct(fragment, monitor);
		new ComponentSimulationObjectAdaptor().adaptSimulationObjects(simulationModel, executionGraph, monitor);
		
		new SimulationProcess(launch, name).simulate(simulationModel, executionGraph);
	}
	
	public boolean buildForLaunch(ILaunchConfiguration configuration, String mode, IProgressMonitor monitor) throws CoreException {
		return false;
	}
	
	private Fragment loadFragment(String fragmentURIString) {
		try {
			ResourceSet rs = new ResourceSetImpl();
			URI uri = URI.createURI(fragmentURIString, false);
			return (Fragment) rs.getEObject(uri, true);
		} catch (Exception e) {
			// Ignore
		}
		return null;
	}

}
