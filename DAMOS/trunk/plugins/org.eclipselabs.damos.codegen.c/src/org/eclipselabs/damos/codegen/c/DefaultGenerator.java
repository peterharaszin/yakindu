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

package org.eclipselabs.damos.codegen.c;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipselabs.damos.codegen.AbstractGenerator;
import org.eclipselabs.damos.codegen.c.internal.ComponentGeneratorAdaptor;
import org.eclipselabs.damos.codegen.c.internal.ComponentGeneratorContext;
import org.eclipselabs.damos.codegen.c.internal.GeneratorContext;
import org.eclipselabs.damos.codegen.c.internal.VariableAccessor;
import org.eclipselabs.damos.codegen.c.internal.util.InternalGeneratorUtil;
import org.eclipselabs.damos.codegen.c.util.GeneratorConfigurationUtil;
import org.eclipselabs.damos.dconfig.Configuration;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.Fragment;
import org.eclipselabs.damos.execution.ComponentNode;
import org.eclipselabs.damos.execution.ExecutionFlow;
import org.eclipselabs.damos.execution.Node;
import org.eclipselabs.damos.execution.datatype.DataTypeResolver;
import org.eclipselabs.damos.execution.datatype.DataTypeResolverResult;
import org.eclipselabs.damos.execution.datatype.IComponentSignature;
import org.eclipselabs.damos.execution.transform.ExecutionFlowBuilder;
import org.eclipselabs.damos.mscript.codegen.c.CModule;
import org.eclipselabs.damos.mscript.codegen.c.CModuleEntry.Visibility;
import org.eclipselabs.damos.mscript.codegen.c.CModuleSet;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragment;

import com.google.inject.Inject;

/**
 * @author Andreas Unger
 *
 */
public class DefaultGenerator extends AbstractGenerator {

	private final DataTypeResolver dataTypeResolver = new DataTypeResolver();
	
	private final IGraphGenerator graphGenerator;
	private final ITaskGenerator taskGenerator;
		
	/**
	 * 
	 */
	@Inject
	DefaultGenerator(IGraphGenerator graphGenerator, ITaskGenerator taskGenerator) {
		this.graphGenerator = graphGenerator;
		this.taskGenerator = taskGenerator;
	}

	public void generate(Configuration configuration, final IProgressMonitor monitor) throws CoreException {
		Fragment contextFragment = configuration.getContextFragment();
		if (contextFragment == null) {
			throw new CoreException(new Status(IStatus.ERROR, CodegenCPlugin.PLUGIN_ID, "No system configuration specified"));
		}
		
		ITargetGenerator targetGenerator = GeneratorConfigurationUtil.getTargetGenerator(configuration);
		if (targetGenerator != null) {
			Configuration newConfiguration = targetGenerator.createConfiguration(configuration, monitor);
			if (newConfiguration != null) {
				configuration = newConfiguration;
			}
		}

		String projectName = GeneratorConfigurationUtil.getPropertyStringValue(configuration, "damos.codegen.generator/projectName", null);
		if (projectName == null) {
			throw new CoreException(new Status(IStatus.ERROR, CodegenCPlugin.PLUGIN_ID, "Missing configuration property projectName"));
		}

		final IGeneratorContext context = createContext(configuration, monitor);
		
		String sourceFolder = GeneratorConfigurationUtil.getPropertyStringValue(configuration, "damos.codegen.generator/sourceFolder", null);
		String headerFolder = GeneratorConfigurationUtil.getPropertyStringValue(configuration, "damos.codegen.generator/headerFolder", sourceFolder);
		
		String systemSourceFile = GeneratorConfigurationUtil.getSystemSourceFile(context.getConfiguration());
		String systemHeaderFile = GeneratorConfigurationUtil.getSystemHeaderFile(context.getConfiguration());
		
		IProject project = getProject(projectName, monitor);
		IContainer sourceContainer = getContainer(monitor, project, sourceFolder);
		IContainer headerContainer = getContainer(monitor, project, headerFolder);

		if (targetGenerator != null) {
			targetGenerator.generate(context, monitor);
		}

		IFile headerFile = headerContainer.getFile(new Path(systemHeaderFile));
		IFile sourceFile = sourceContainer.getFile(new Path(systemSourceFile));

		addCodeFragments(context, monitor);
		
		CModuleSet moduleSet = new CModuleSet();
		CModule module = moduleSet.createModule(new Path(systemSourceFile).removeFileExtension().toString());
		
		List<ICodeFragment> codeFragments = new ArrayList<ICodeFragment>(context.getCodeFragments());
		
		for (ICodeFragment codeFragment : codeFragments) {
			if (codeFragment instanceof InputStruct || codeFragment instanceof OutputStruct
					|| codeFragment instanceof InitializeFunction || codeFragment instanceof ExecuteFunction
					|| codeFragment instanceof TaskInfo) {
				module.addEntry(codeFragment, Visibility.PUBLIC);
			} else {
				module.addEntry(codeFragment, Visibility.PRIVATE);
			}
		}
		
		try {
			final StringBuilder headerContent = new StringBuilder();
			module.writeHeader(headerContent);
			InputStream is = new StringInputStream(headerContent.toString());
			if (headerFile.exists()) {
				headerFile.setContents(is, true, true, monitor);
			} else {
				headerFile.create(is, true, monitor);
			}

			final StringBuilder sourceContent = new StringBuilder();
			module.writeSource(sourceContent);
			is = new StringInputStream(sourceContent.toString());
			if (sourceFile.exists()) {
				sourceFile.setContents(is, true, true, monitor);
			} else {
				sourceFile.create(is, true, monitor);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @param context
	 * @param monitor
	 */
	private void addCodeFragments(IGeneratorContext context, IProgressMonitor monitor) {
		if (!InternalGeneratorUtil.getInportNodes(context).isEmpty()) {
			context.addCodeFragment(new InputStruct(), monitor);
		}
		
		if (!InternalGeneratorUtil.getOutportNodes(context).isEmpty()) {
			context.addCodeFragment(new OutputStruct(), monitor);
		}
		
		if (!context.getExecutionFlow().getTaskGraphs().isEmpty()) {
			context.addCodeFragment(new TaskInfo(graphGenerator), monitor);
		}
		
		context.addCodeFragment(new ContextStruct(taskGenerator), monitor);
		context.addCodeFragment(new ContextVariable(), monitor);
		context.addCodeFragment(new InitializeFunction(taskGenerator), monitor);
		context.addCodeFragment(new ExecuteFunction(graphGenerator), monitor);
	}

	/**
	 * @param monitor
	 * @param project
	 * @param sourceFolder
	 * @return
	 * @throws CoreException
	 */
	private IContainer getContainer(final IProgressMonitor monitor, IProject project, String sourceFolder)
			throws CoreException {
		IContainer sourceContainer;
		if (sourceFolder != null) {
			sourceContainer = ensureFolderExists(project.getFolder(sourceFolder), monitor);
		} else {
			sourceContainer = project;
		}
		return sourceContainer;
	}

	/**
	 * @param projectName
	 * @param monitor
	 * @return
	 * @throws CoreException
	 */
	private IProject getProject(String projectName, final IProgressMonitor monitor) throws CoreException {
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
		if (project.exists()) {
			if (!project.isOpen()) {
				throw new CoreException(new Status(IStatus.ERROR, CodegenCPlugin.PLUGIN_ID, "Project " + projectName + " closed"));
			}
		} else {
			project.create(monitor);
			project.open(monitor);
		}
		return project;
	}
	
	private IFolder ensureFolderExists(IFolder folder, IProgressMonitor monitor) throws CoreException {
		if (!folder.exists()) {
			if (!folder.getParent().exists() && folder.getParent() instanceof IFolder) {
				ensureFolderExists((IFolder) folder.getParent(), monitor);
			}
			folder.create(true, true, monitor);
		}
		return folder;
	}

	private Map<Component, IComponentSignature> resolveDataTypes(IGeneratorContext context) throws CoreException {
		DataTypeResolverResult dataTypeResolverResult = dataTypeResolver.resolve(context.getExecutionFlow().getTopLevelFragment(), true);
		if (!dataTypeResolverResult.getStatus().isOK()) {
			throw new CoreException(dataTypeResolverResult.getStatus());
		}
		return dataTypeResolverResult.getSignatures();
	}
	
	private IGeneratorContext createContext(Configuration configuration, IProgressMonitor monitor) throws CoreException {
		Fragment contextFragment = configuration.getContextFragment();
		if (contextFragment == null) {
			throw new CoreException(new Status(IStatus.ERROR, CodegenCPlugin.PLUGIN_ID, "No root system specification found in configuration"));
		}
		
		ExecutionFlow executionFlow = new ExecutionFlowBuilder().build(contextFragment, monitor);
		IGeneratorContext context = new GeneratorContext(configuration, executionFlow);
		new ComponentGeneratorAdaptor().adaptGenerators(context, monitor);

		if (executionFlow.getAsynchronousZoneCount() > 0 && GeneratorConfigurationUtil.getRuntimeEnvironmentAPI(context.getConfiguration()) == null) {
			throw new CoreException(new Status(IStatus.ERROR, CodegenCPlugin.PLUGIN_ID, "A runtime must be specified in the configuration for systems containing asynchronous components"));
		}

		Map<Component, IComponentSignature> signatures = resolveDataTypes(context);
		for (Node node : context.getExecutionFlow().getAllNodes()) {
			if (node instanceof ComponentNode) {
				ComponentNode componentNode = (ComponentNode) node;
				IComponentGenerator generator = InternalGeneratorUtil.getComponentGenerator(componentNode);
				IVariableAccessor variableAccessor = new VariableAccessor(configuration, componentNode);
				IComponentSignature componentSignature = signatures.get(componentNode.getComponent());
				ComponentGeneratorContext componentGeneratorContext = new ComponentGeneratorContext(componentNode, componentSignature, variableAccessor, configuration, context);
				generator.initialize(componentGeneratorContext, monitor);
			}
		}

		return context;
	}
	
}
