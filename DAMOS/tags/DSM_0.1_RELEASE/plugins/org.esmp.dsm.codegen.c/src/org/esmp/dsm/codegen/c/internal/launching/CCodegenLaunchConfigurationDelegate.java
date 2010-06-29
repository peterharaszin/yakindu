package org.esmp.dsm.codegen.c.internal.launching;

import java.util.List;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.ResourcesPlugin;
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
import org.esmp.dsm.codegen.c.DSMCodegenCPlugin;
import org.esmp.dsm.codegen.c.internal.CCodegenContextImpl;
import org.esmp.dsm.execution.datatype.InvalidDataTypeException;
import org.esmp.dsm.execution.executiongraph.ExecutionGraphDeadlockException;
import org.esmp.dsm.semantic.blockdiagram.Block;
import org.esmp.dsm.semantic.blockdiagram.BlockDiagram;
import org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage;

public class CCodegenLaunchConfigurationDelegate extends LaunchConfigurationDelegate {

	public static final String LAUNCH_CONFIGURATION_TYPE = "org.esmp.dsm.codegen.c.launching.codegen";
	
	public static final String ATTRIBUTE__BLOCK_DIAGRAM_PATH = "blockDiagramPath";
	public static final String ATTRIBUTE__TARGET_FOLDER_PATH = "targetFolderPath";
	public static final String ATTRIBUTE__SAMPLING_FREQUENCY = "samplingFrequency";
	
	public void launch(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor monitor) throws CoreException {
		String blockDiagramPathString = configuration.getAttribute(ATTRIBUTE__BLOCK_DIAGRAM_PATH, "");
		if (blockDiagramPathString.length() == 0) {
			throw new CoreException(new Status(IStatus.ERROR, DSMCodegenCPlugin.PLUGIN_ID, "No block diagram file specified"));
		}
		
		String targetFolderPathString = configuration.getAttribute(ATTRIBUTE__TARGET_FOLDER_PATH, "");
		if (targetFolderPathString.length() == 0) {
			throw new CoreException(new Status(IStatus.ERROR, DSMCodegenCPlugin.PLUGIN_ID, "No target folder specified"));
		}
		
		IFolder targetFolder = ResourcesPlugin.getWorkspace().getRoot().getFolder(new Path(targetFolderPathString));
		if (!targetFolder.exists()) {
			throw new CoreException(new Status(IStatus.ERROR, DSMCodegenCPlugin.PLUGIN_ID, "Target path '" + targetFolderPathString + "' does not exist"));
		}

		BlockDiagram blockDiagram = loadBlockDiagram(blockDiagramPathString);
		if (blockDiagram == null) {
			throw new CoreException(new Status(IStatus.ERROR, DSMCodegenCPlugin.PLUGIN_ID, "Could not load block diagram file '" + blockDiagramPathString + "'"));
		}
		
		CCodegenContextImpl context = new CCodegenContextImpl();
		context.setHeaderFolder(targetFolderPathString);
		context.setSourceFolder(targetFolderPathString);
		context.setPrefix(blockDiagram.getName());

		try {
			context.setSamplingFrequency(Long.parseLong(configuration.getAttribute(ATTRIBUTE__SAMPLING_FREQUENCY, "8000")));
		} catch (NumberFormatException e) {
			throw new CoreException(new Status(IStatus.ERROR, DSMCodegenCPlugin.PLUGIN_ID, "Invalid sampling frequency"));
		}

		try {
			String name = new Path(blockDiagramPathString).toFile().getName();
			new CCodegenProcess(launch, name).generate(blockDiagram, context);
		} catch (ExecutionGraphDeadlockException e) {
			String msg = "Execution graph deadlock encountered: " + blockListToString(e.getBacklog());
			throw new CoreException(new Status(IStatus.ERROR, DSMCodegenCPlugin.PLUGIN_ID, msg));
		} catch (UnknownBlockException e) {
			String msg = "Missing C code generators for: " + blockListToString(e.getUnknownBlocks());
			throw new CoreException(new Status(IStatus.ERROR, DSMCodegenCPlugin.PLUGIN_ID, msg));
		} catch (InvalidDataTypeException e) {
			String msg = "Invalid data types: " + blockListToString(e.getInvalidBlocks());
			throw new CoreException(new Status(IStatus.ERROR, DSMCodegenCPlugin.PLUGIN_ID, msg));
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
