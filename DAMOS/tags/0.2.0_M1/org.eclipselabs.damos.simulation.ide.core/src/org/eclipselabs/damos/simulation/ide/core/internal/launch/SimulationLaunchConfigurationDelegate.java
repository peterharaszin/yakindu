package org.eclipselabs.damos.simulation.ide.core.internal.launch;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.LaunchConfigurationDelegate;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.damos.dml.Fragment;
import org.eclipselabs.damos.execution.executiongraph.ExecutionGraph;
import org.eclipselabs.damos.execution.executiongraph.construct.ExecutionGraphConstructor;
import org.eclipselabs.damos.execution.executionmodel.ExecutionModel;
import org.eclipselabs.damos.execution.executionmodel.ExecutionModelFactory;
import org.eclipselabs.damos.simulation.engine.ComponentSimulationObjectAdaptor;
import org.eclipselabs.damos.simulation.engine.SimulationEnginePlugin;
import org.eclipselabs.damos.simulation.simulationmodel.SimulationModel;
import org.eclipselabs.damos.simulation.simulationmodel.SimulationModelFactory;
import org.eclipselabs.damos.simulation.simulationmodel.SimulationModelPackage;
import org.eclipselabs.mscript.computation.computationmodel.ComputationModel;
import org.eclipselabs.mscript.computation.computationmodel.util.ComputationModelUtil;

public class SimulationLaunchConfigurationDelegate extends LaunchConfigurationDelegate {

	public static final String LAUNCH_CONFIGURATION_TYPE = "org.eclipselabs.damos.simulation.ide.core.simulation";
	
	public static final String ATTRIBUTE__CREATE_SIMULATION_MODEL = "createSimulationModel";

	public static final String ATTRIBUTE__FRAGMENT_URI = "fragmentURI";
	public static final String ATTRIBUTE__SAMPLE_TIME = "sampleRate";
	public static final String ATTRIBUTE__SIMULATION_TIME = "simulationTime";
	
	public static final String ATTRIBUTE__SIMULATION_MODEL_PATH = "simulationModelPath";

	public static final String DEFAULT_SAMPLE_TIME = "auto";
	public static final String DEFAULT_SIMULATION_TIME = "10";
	
	private static final int DEFAULT_STEP_COUNT = 1000;

	public void launch(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor monitor) throws CoreException {
		boolean createSimulationModel = configuration.getAttribute(ATTRIBUTE__CREATE_SIMULATION_MODEL, true);
		
		SimulationModel simulationModel;
		
		if (createSimulationModel) {
			String fragmentURIString = configuration.getAttribute(ATTRIBUTE__FRAGMENT_URI, "");
			if (fragmentURIString.length() == 0) {
				throw new CoreException(new Status(IStatus.ERROR, SimulationEnginePlugin.PLUGIN_ID, "No fragment specified"));
			}
			
			Fragment topLevelFragment = loadFragment(fragmentURIString);
			if (topLevelFragment == null) {
				throw new CoreException(new Status(IStatus.ERROR, SimulationEnginePlugin.PLUGIN_ID, "Could not load fragment '" + fragmentURIString + "'"));
			}
			
			ComputationModel computationModel = ComputationModelUtil.constructDefaultComputationModel();
			
			ExecutionModel executionModel = ExecutionModelFactory.eINSTANCE.createExecutionModel();
			executionModel.setComputationModel(computationModel);
	
			simulationModel = SimulationModelFactory.eINSTANCE.createSimulationModel();
			simulationModel.setExecutionModel(executionModel);
			simulationModel.setTopLevelFragment(topLevelFragment);
			
			try {
				simulationModel.setSimulationTime(Double.parseDouble(configuration.getAttribute(ATTRIBUTE__SIMULATION_TIME, "10")));
			} catch (NumberFormatException e) {
				throw new CoreException(new Status(IStatus.ERROR, SimulationEnginePlugin.PLUGIN_ID, "Invalid simulation time"));
			}
	
			String sampleTimeString = configuration.getAttribute(ATTRIBUTE__SAMPLE_TIME, DEFAULT_SAMPLE_TIME);
			if (DEFAULT_SAMPLE_TIME.equals(sampleTimeString)) {
				executionModel.setSampleTime(simulationModel.getSimulationTime() / DEFAULT_STEP_COUNT);
			} else {
				try {
					executionModel.setSampleTime(Double.parseDouble(sampleTimeString));
				} catch (NumberFormatException e) {
					throw new CoreException(new Status(IStatus.ERROR, SimulationEnginePlugin.PLUGIN_ID, "Invalid sample time"));
				}
			}
		} else {
			String simulationModelPath = configuration.getAttribute(ATTRIBUTE__SIMULATION_MODEL_PATH, "");
			if (StringUtils.isBlank(simulationModelPath)) {
				throw new CoreException(new Status(IStatus.ERROR, SimulationEnginePlugin.PLUGIN_ID, "No simulation model path set"));
			}
			
			URI uri;
			try {
				uri = URI.createPlatformResourceURI(simulationModelPath, true);
			} catch (IllegalArgumentException e) {
				throw new CoreException(new Status(IStatus.ERROR, SimulationEnginePlugin.PLUGIN_ID, "Invalid simulation model path specified"));
			}

			ResourceSet resourceSet = new ResourceSetImpl();
			Resource resource = resourceSet.getResource(uri, true);
			simulationModel = (SimulationModel) EcoreUtil.getObjectByType(resource.getContents(), SimulationModelPackage.eINSTANCE.getSimulationModel());
			if (simulationModel == null) {
				throw new CoreException(new Status(IStatus.ERROR, SimulationEnginePlugin.PLUGIN_ID, "No simulation model found in '" + simulationModelPath + "'"));
			}
		}
		
		ExecutionGraph executionGraph = new ExecutionGraphConstructor().construct(simulationModel.getTopLevelFragment(), monitor);
		new ComponentSimulationObjectAdaptor().adaptSimulationObjects(simulationModel, executionGraph, monitor);
		
		new SimulationProcess(launch, simulationModel.getTopLevelFragment().getName()).run(simulationModel, executionGraph);
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
