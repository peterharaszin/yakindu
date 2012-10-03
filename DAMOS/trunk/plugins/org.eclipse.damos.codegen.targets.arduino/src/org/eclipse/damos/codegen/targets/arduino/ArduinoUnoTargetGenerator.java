/****************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger. All rights reserved.
 ****************************************************************************/

package org.eclipse.damos.codegen.targets.arduino;

import java.io.ByteArrayInputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.damos.codegen.c.AbstractTargetGenerator;
import org.eclipse.damos.codegen.c.IComponentGenerator;
import org.eclipse.damos.codegen.c.IGeneratorContext;
import org.eclipse.damos.codegen.c.util.GeneratorConfigurationExtensions;
import org.eclipse.damos.codegen.targets.arduino.internal.registry.ShieldGeneratorDescriptor;
import org.eclipse.damos.codegen.targets.arduino.internal.registry.ShieldGeneratorRegistry;
import org.eclipse.damos.common.util.NumberedList;
import org.eclipse.damos.dconfig.Binding;
import org.eclipse.damos.dconfig.BindingResourceSubscript;
import org.eclipse.damos.dconfig.Configuration;
import org.eclipse.damos.dconfig.util.PropertyPath;
import org.eclipse.damos.dml.Component;
import org.eclipse.damos.dml.DMLPackage;
import org.eclipse.damos.dml.Fragment;
import org.eclipse.damos.dml.InputPort;
import org.eclipse.damos.dml.OutputPort;
import org.eclipse.damos.execution.ComponentNode;
import org.eclipse.emf.ecore.util.EcoreUtil;

public class ArduinoUnoTargetGenerator extends AbstractTargetGenerator {

	private static final PropertyPath TARGET_PROPERTY_PATH = PropertyPath.create("damos.codegen.target");
	private static final PropertyPath SHIELD_PROPERTY_PATH = PropertyPath.create("damos.codegen.target/shield");
	
	private final InoFileGenerator inoFileGenerator = new InoFileGenerator();
	
	@Override
	public Configuration createConfiguration(Configuration baseConfiguration, IProgressMonitor monitor) throws CoreException {
		Fragment contextFragment = baseConfiguration.getContextFragment();
		if (contextFragment != null) {
			if (EcoreUtil.getObjectByType(contextFragment.getAllComponents(), DMLPackage.eINSTANCE.getInoutport()) != null) {
				throw new CoreException(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Top-level fragment must not contain inports or outports"));
			}
		}
		return null;
	}
	
	@Override
	public IComponentGenerator createBoundaryComponentGenerator(IGeneratorContext context, ComponentNode node) {
		NumberedList<String> shieldNames = context.getConfiguration().getPropertySelectionNames(SHIELD_PROPERTY_PATH);
		for (NumberedList.Entry<String> entry : shieldNames.entries()) {
			Binding binding = context.getConfiguration().getBinding(SHIELD_PROPERTY_PATH.setIndex(entry.getNumber()), node.getSystemPath());
			if (binding != null && binding.getTarget() != null) {
				IShieldGenerator shieldGenerator = getShieldGenerator(entry.getValue());
				if (shieldGenerator == null) {
					return null;
				}
				return shieldGenerator.createBoundaryComponentGenerator(context, node, binding);
			}
		}
		
		if (isDataIn(node.getComponent())) {
			return new DataInComponentGenerator(getPinIndex(context.getConfiguration(), node));
		}
		if (isDataOut(node.getComponent())) {
			return new DataOutComponentGenerator(getPinIndex(context.getConfiguration(), node));
		}
		
		return null;
	}

	@Override
	public void generate(IGeneratorContext context, IProgressMonitor monitor) throws CoreException {
		NumberedList<String> shieldNames = context.getConfiguration().getPropertySelectionNames(SHIELD_PROPERTY_PATH);
		for (NumberedList.Entry<String> entry : shieldNames.entries()) {
			IShieldGenerator shieldGenerator = getShieldGenerator(entry.getValue());
			if (shieldGenerator != null) {
				shieldGenerator.generate(context, monitor);
			}
		}
		
		String project = GeneratorConfigurationExtensions.getProjectName(context.getConfiguration());
		if (project == null) {
			return;
		}
		String sourceFolder = GeneratorConfigurationExtensions.getSourceFolder(context.getConfiguration());
		if (sourceFolder == null) {
			return;
		}
		IFolder folder = ResourcesPlugin.getWorkspace().getRoot().getProject(project).getFolder(sourceFolder);
		if (!folder.exists()) {
			return;
		}
		
		CharSequence content = inoFileGenerator.generate(context, monitor);

		// The name of the .ino file must be the name of the source folder + '.ino',
		// otherwise the folder is not recognized as a sketchbook by the Arduino IDE.
		IFile file = folder.getFile(sourceFolder + ".ino");
		ByteArrayInputStream is = new ByteArrayInputStream(content.toString().getBytes());
		if (file.exists()) {
			file.setContents(is, true, true, monitor);
		} else {
			file.create(is, true, monitor);
		}
	}

	/**
	 * @return
	 */
	private boolean isDataIn(Component component) {
		int n = 0;
		for (OutputPort outputPort : component.getOutputPorts()) {
			if (!outputPort.getOutput().isTestPoint()) {
				++n;
			}
		}
		return n == 1;
	}

	/**
	 * @return
	 */
	private boolean isDataOut(Component component) {
		int n = 0;
		for (InputPort inputPort : component.getInputPorts()) {
			if (!inputPort.getInput().isTestPoint()) {
				++n;
			}
		}
		return n == 1;
	}
	
	private static int getPinIndex(Configuration configuration, ComponentNode node) {
		Binding binding = configuration.getBinding(TARGET_PROPERTY_PATH, node.getSystemPath());
		if (binding == null || binding.getTarget() == null) {
			return -1;
		}
		BindingResourceSubscript subscript = binding.getTarget().getSubscript();
		if (subscript == null) {
			return 0;
		}
		return subscript.getIndex();
	}

	private IShieldGenerator getShieldGenerator(String name) {
		ShieldGeneratorDescriptor generatorDescriptor = ShieldGeneratorRegistry.getInstance().getGenerator(name);
		if (generatorDescriptor != null) {
			return generatorDescriptor.createGenerator();
		}
		return null;
	}

}
