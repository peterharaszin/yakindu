package org.esmp.dsm.simulation.internal.launching;

import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.LaunchConfigurationDelegate;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.esmp.dsm.execution.datatype.InvalidDataTypeException;
import org.esmp.dsm.execution.executiongraph.ExecutionGraphDeadlockException;
import org.esmp.dsm.semantic.blockdiagram.Block;
import org.esmp.dsm.semantic.blockdiagram.BlockDiagram;
import org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage;
import org.esmp.dsm.simulation.DSMSimulationPlugin;
import org.esmp.dsm.simulation.internal.SimulationContextImpl;

public class SimulationLaunchConfigurationDelegate extends LaunchConfigurationDelegate {

	public static final String LAUNCH_CONFIGURATION_TYPE = "org.esmp.dsm.simulation.launching.simulation";
	
	public static final String ATTRIBUTE__BLOCK_DIAGRAM_PATH = "blockDiagramPath";
	public static final String ATTRIBUTE__SAMPLING_FREQUENCY = "samplingFrequency";
	public static final String ATTRIBUTE__SIMULATION_TIME = "simulationTime";
	
	public void launch(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor monitor) throws CoreException {
		String blockDiagramPath = configuration.getAttribute(ATTRIBUTE__BLOCK_DIAGRAM_PATH, "");
		if (blockDiagramPath.length() == 0) {
			throw new CoreException(new Status(IStatus.ERROR, DSMSimulationPlugin.PLUGIN_ID, "No block diagram file specified"));
		}
		
		BlockDiagram blockDiagram = loadBlockDiagram(blockDiagramPath);
		if (blockDiagram == null) {
			throw new CoreException(new Status(IStatus.ERROR, DSMSimulationPlugin.PLUGIN_ID, "Could not load block diagram file '" + blockDiagramPath + "'"));
		}

		SimulationContextImpl context = new SimulationContextImpl();
		
		try {
			context.setSamplingFrequency(Long.parseLong(configuration.getAttribute(ATTRIBUTE__SAMPLING_FREQUENCY, "8000")));
		} catch (NumberFormatException e) {
			throw new CoreException(new Status(IStatus.ERROR, DSMSimulationPlugin.PLUGIN_ID, "Invalid sampling frequency"));
		}
		
		try {
			context.setSimulationTime(Double.parseDouble(configuration.getAttribute(ATTRIBUTE__SIMULATION_TIME, "10")));
		} catch (NumberFormatException e) {
			throw new CoreException(new Status(IStatus.ERROR, DSMSimulationPlugin.PLUGIN_ID, "Invalid simulation time"));
		}
		
		try {
			String name = new Path(blockDiagramPath).toFile().getName();
			new SimulationProcess(launch, name).simulate(context, blockDiagram);
		} catch (ExecutionGraphDeadlockException e) {
			String msg = "Execution graph deadlock encountered: " + blockListToString(e.getBacklog());
			throw new CoreException(new Status(IStatus.ERROR, DSMSimulationPlugin.PLUGIN_ID, msg));
		} catch (MissingSimulationModelException e) {
			String msg = "Missing simulation models for: " + blockListToString(e.getMissingSimulationModelBlocks());
			throw new CoreException(new Status(IStatus.ERROR, DSMSimulationPlugin.PLUGIN_ID, msg));
		} catch (InvalidDataTypeException e) {
			String msg = "Invalid data types: " + blockListToString(e.getInvalidBlocks());
			throw new CoreException(new Status(IStatus.ERROR, DSMSimulationPlugin.PLUGIN_ID, msg));
		}
	}
	
	public boolean buildForLaunch(ILaunchConfiguration configuration, String mode, IProgressMonitor monitor) throws CoreException {
		return false;
	}
	
	private String blockListToString(List<Block> blocks) {
		StringBuilder sb = new StringBuilder();
		for (Block block : blocks) {
			if (sb.length() > 0) {
				sb.append(" ");
			}
			sb.append(block.getName());
		}
		return sb.toString();
	}
	
	private BlockDiagram loadBlockDiagram(String blockDiagramPath) {
		try {
			ResourceSet rs = new ResourceSetImpl();
			URI uri = URI.createPlatformResourceURI(blockDiagramPath, false);
			Resource r = rs.getResource(uri, true);
			return (BlockDiagram) EcoreUtil.getObjectByType(r.getContents(), BlockDiagramPackage.eINSTANCE.getBlockDiagram());
		} catch (Exception e) {
			// Ignore
		}
		return null;
	}

}
