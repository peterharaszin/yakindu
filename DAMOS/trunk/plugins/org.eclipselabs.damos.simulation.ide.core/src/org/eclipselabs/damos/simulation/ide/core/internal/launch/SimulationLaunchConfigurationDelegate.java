package org.eclipselabs.damos.simulation.ide.core.internal.launch;

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
import org.eclipselabs.damos.simulation.ide.core.SimulationIDECorePlugin;
import org.eclipselabs.damos.simulation.ide.core.util.LaunchConfigurationUtil;
import org.eclipselabs.damos.simulation.simulationmodel.SimulationModel;
import org.eclipselabs.damos.simulation.simulationmodel.SimulationModelPackage;
import org.eclipselabs.damos.simulation.simulator.Simulator;

public class SimulationLaunchConfigurationDelegate extends LaunchConfigurationDelegate {

	public static final String LAUNCH_CONFIGURATION_TYPE = "org.eclipselabs.damos.simulation.ide.core.simulation";
	
	public static final String ATTRIBUTE__CREATE_SIMULATION_MODEL = "createSimulationModel";

	public static final String ATTRIBUTE__SIMULATION_MODEL = "simulationModel";
	public static final String ATTRIBUTE__SIMULATION_MODEL_PATH = "simulationModelPath";
	
	public static final double DEFAULT_SIMULATION_TIME = 10;
	public static final String DEFAULT_SOLVER_TYPE = "damos::solvers::DormandPrince54";

	public void launch(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor progressMonitor) throws CoreException {
		boolean createSimulationModel = configuration.getAttribute(ATTRIBUTE__CREATE_SIMULATION_MODEL, true);
		
		SimulationModel simulationModel;
		
		if (createSimulationModel) {
			simulationModel = LaunchConfigurationUtil.loadSimulationModel(configuration);
		} else {
			String simulationModelPath = configuration.getAttribute(ATTRIBUTE__SIMULATION_MODEL_PATH, "");
			if (simulationModelPath.trim().length() == 0) {
				throw new CoreException(new Status(IStatus.ERROR, SimulationIDECorePlugin.PLUGIN_ID, "No simulation model path set"));
			}
			
			URI uri;
			try {
				uri = URI.createPlatformResourceURI(simulationModelPath, true);
			} catch (IllegalArgumentException e) {
				throw new CoreException(new Status(IStatus.ERROR, SimulationIDECorePlugin.PLUGIN_ID, "Invalid simulation model path specified"));
			}

			ResourceSet resourceSet = new ResourceSetImpl();
			Resource resource = resourceSet.getResource(uri, true);
			simulationModel = (SimulationModel) EcoreUtil.getObjectByType(resource.getContents(), SimulationModelPackage.eINSTANCE.getSimulationModel());
			if (simulationModel == null) {
				throw new CoreException(new Status(IStatus.ERROR, SimulationIDECorePlugin.PLUGIN_ID, "No simulation model found in '" + simulationModelPath + "'"));
			}
		}
		
		Simulator simulator = new Simulator();
		simulator.initialize(simulationModel, progressMonitor);
		if (progressMonitor != null && progressMonitor.isCanceled()) {
			return;
		}
		new SimulationProcess(launch, simulator.getSimulationEngine()).run();
	}

	public boolean buildForLaunch(ILaunchConfiguration configuration, String mode, IProgressMonitor monitor) throws CoreException {
		return false;
	}
	
}
