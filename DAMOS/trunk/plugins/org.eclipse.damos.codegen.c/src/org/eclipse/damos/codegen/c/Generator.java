/****************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipse.damos.codegen.c;

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
import org.eclipse.damos.codegen.AbstractGenerator;
import org.eclipse.damos.codegen.c.codefragments.ExecuteFunction;
import org.eclipse.damos.codegen.c.codefragments.ITaskInfoStruct;
import org.eclipse.damos.codegen.c.codefragments.InitializeFunction;
import org.eclipse.damos.codegen.c.codefragments.InputStruct;
import org.eclipse.damos.codegen.c.codefragments.OutputStruct;
import org.eclipse.damos.codegen.c.codefragments.TaskInfoArray;
import org.eclipse.damos.codegen.c.codefragments.factories.IContextVariableFactory;
import org.eclipse.damos.codegen.c.codefragments.factories.IExecuteFunctionFactory;
import org.eclipse.damos.codegen.c.codefragments.factories.IInitializeFunctionFactory;
import org.eclipse.damos.codegen.c.codefragments.factories.IInputStructFactory;
import org.eclipse.damos.codegen.c.codefragments.factories.IOutputStructFactory;
import org.eclipse.damos.codegen.c.codefragments.factories.ITaskInfoArrayFactory;
import org.eclipse.damos.codegen.c.internal.ComponentGeneratorAdaptor;
import org.eclipse.damos.codegen.c.internal.ComponentGeneratorContext;
import org.eclipse.damos.codegen.c.internal.GeneratorContext;
import org.eclipse.damos.codegen.c.internal.util.InternalGeneratorUtil;
import org.eclipse.damos.codegen.c.util.GeneratorConfigurationExtensions;
import org.eclipse.damos.codegen.c.util.GeneratorNodeExtensions;
import org.eclipse.damos.dconfig.Configuration;
import org.eclipse.damos.dml.Component;
import org.eclipse.damos.dml.Fragment;
import org.eclipse.damos.execution.ComponentNode;
import org.eclipse.damos.execution.ExecutionFlow;
import org.eclipse.damos.execution.Node;
import org.eclipse.damos.execution.datatype.DataTypeResolver;
import org.eclipse.damos.execution.datatype.DataTypeResolverResult;
import org.eclipse.damos.execution.datatype.IComponentSignature;
import org.eclipse.damos.execution.transform.ExecutionFlowBuilder;
import org.eclipse.damos.mscript.codegen.c.CHeader;
import org.eclipse.damos.mscript.codegen.c.CModule;
import org.eclipse.damos.mscript.codegen.c.CModuleEntry.Visibility;
import org.eclipse.damos.mscript.codegen.c.CModuleSet;
import org.eclipse.damos.mscript.codegen.c.CSource;
import org.eclipse.damos.mscript.codegen.c.ICModuleGenerator;
import org.eclipse.damos.mscript.codegen.c.ICodeFragment;
import org.eclipse.damos.mscript.codegen.c.codefragments.ContextStruct;
import org.eclipse.damos.mscript.codegen.c.codefragments.StringIteratorDeclaration;
import org.eclipse.damos.mscript.codegen.c.codefragments.StringIteratorInitializeFunction;
import org.eclipse.damos.mscript.codegen.c.codefragments.factories.IContextStructFactory;
import org.eclipse.xtext.util.StringInputStream;

import com.google.inject.Inject;

/**
 * @author Andreas Unger
 *
 */
public class Generator extends AbstractGenerator {

	@Inject
	private DataTypeResolver dataTypeResolver;
	
	@Inject
	@CHeader
	private ICModuleGenerator headerGenerator;

	@Inject
	@CSource
	private ICModuleGenerator sourceGenerator;
	
	@Inject
	private IInputStructFactory inputStructFactory;
	
	@Inject
	private IOutputStructFactory outputStructFactory;
	
	@Inject
	private IContextStructFactory contextStructFactory;
	
	@Inject
	private IContextVariableFactory contextVariableFactory;
	
	@Inject
	private ITaskGenerator taskGenerator;
	
	@Inject
	private ITaskInfoArrayFactory taskInfoArrayFactory;
	
	@Inject
	private IInitializeFunctionFactory initializeFunctionFactory;

	@Inject
	private IExecuteFunctionFactory executeFunctionFactory;
		
	@Inject
	private IVariableAccessorFactory variableAccessorFactory;
	
	@Inject
	private ComponentGeneratorAdaptor componentGeneratorAdaptor;

	public void generate(Configuration configuration, final IProgressMonitor monitor) throws CoreException {
		Fragment contextFragment = configuration.getContextFragment();
		if (contextFragment == null) {
			throw new CoreException(new Status(IStatus.ERROR, CodegenCPlugin.PLUGIN_ID, "No system configuration specified"));
		}
		
		ITargetGenerator targetGenerator = GeneratorConfigurationExtensions.getTargetGenerator(configuration);
		if (targetGenerator != null) {
			Configuration newConfiguration = targetGenerator.createConfiguration(configuration, monitor);
			if (newConfiguration != null) {
				configuration = newConfiguration;
			}
		}

		String projectName = GeneratorConfigurationExtensions.getProjectName(configuration);
		if (projectName == null) {
			throw new CoreException(new Status(IStatus.ERROR, CodegenCPlugin.PLUGIN_ID, "Missing configuration property projectName"));
		}

		final IGeneratorContext context = createContext(configuration, monitor);
		
		String sourceFolder = GeneratorConfigurationExtensions.getSourceFolder(configuration);
		String headerFolder = GeneratorConfigurationExtensions.getHeaderFolder(configuration);
		
		String systemSourceFile = GeneratorConfigurationExtensions.getSystemSourceFile(context.getConfiguration());
		String systemHeaderFile = GeneratorConfigurationExtensions.getSystemHeaderFile(context.getConfiguration());
		
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
			if (codeFragment instanceof InputStruct
					|| codeFragment instanceof OutputStruct
					|| codeFragment instanceof InitializeFunction
					|| codeFragment instanceof ExecuteFunction
					|| codeFragment instanceof TaskInfoArray
					|| codeFragment instanceof ITaskInfoStruct
					|| codeFragment instanceof StringIteratorDeclaration
					|| codeFragment instanceof StringIteratorInitializeFunction
					|| (codeFragment instanceof ContextStruct && !GeneratorConfigurationExtensions
							.isSingleton(configuration))) {
				module.addEntry(codeFragment, Visibility.PUBLIC);
			} else {
				module.addEntry(codeFragment, Visibility.PRIVATE);
			}
		}
		
		generateHeader(module, headerFile, monitor);
		generateSource(module, sourceFile, monitor);
	}

	/**
	 * @param module
	 * @param headerFile
	 * @param monitor
	 * @throws CoreException
	 */
	protected void generateHeader(CModule module, IFile headerFile, final IProgressMonitor monitor) throws CoreException {
		InputStream is = new StringInputStream(headerGenerator.generate(module).toString());
		if (headerFile.exists()) {
			headerFile.setContents(is, true, true, monitor);
		} else {
			headerFile.create(is, true, monitor);
		}
	}

	/**
	 * @param module
	 * @param sourceFile
	 * @param monitor
	 * @throws CoreException
	 */
	protected void generateSource(CModule module, IFile sourceFile, final IProgressMonitor monitor) throws CoreException {
		InputStream is = new StringInputStream(sourceGenerator.generate(module).toString());
		if (sourceFile.exists()) {
			sourceFile.setContents(is, true, true, monitor);
		} else {
			sourceFile.create(is, true, monitor);
		}
	}

	/**
	 * @param context
	 * @param monitor
	 */
	protected void addCodeFragments(IGeneratorContext context, IProgressMonitor monitor) {
		if (!InternalGeneratorUtil.getInportNodes(context).isEmpty()) {
			context.addCodeFragment(inputStructFactory.create(), monitor);
		}
		
		if (!InternalGeneratorUtil.getOutportNodes(context).isEmpty()) {
			context.addCodeFragment(outputStructFactory.create(), monitor);
		}
		
		if (!context.getExecutionFlow().getTaskGraphs().isEmpty()) {
			context.addCodeFragment(taskInfoArrayFactory.create(), monitor);
		}
		
		addContextStruct(context, monitor);
		
		if (GeneratorConfigurationExtensions.isSingleton(context.getConfiguration())) {
			context.addCodeFragment(contextVariableFactory.create(), monitor);
		}

		// TODO: Right now, we need to added the execute function first, so that all sub-initialize functions
		// get initialized by the ComputeFunction fragment, may we should change this.
		context.addCodeFragment(executeFunctionFactory.create(), monitor);
		context.addCodeFragment(initializeFunctionFactory.create(), monitor);
	}

	/**
	 * @param context
	 * @param monitor
	 */
	private void addContextStruct(IGeneratorContext context, IProgressMonitor monitor) {
		ContextStruct contextStruct = (ContextStruct) context.addCodeFragment(contextStructFactory.create(null, null, GeneratorConfigurationExtensions.isSingleton(context.getConfiguration())), monitor);
		
		for (Node node : context.getExecutionFlow().getAllNodes()) {
			if (node instanceof ComponentNode) {
				IComponentGenerator componentGenerator = GeneratorNodeExtensions.getComponentGenerator((ComponentNode) node);
				if (componentGenerator != null) {
					componentGenerator.addContextStructMembers(contextStruct, monitor);
				}
			}
		}
		
		taskGenerator.addTaskContexts(context, contextStruct, monitor);
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
		if (dataTypeResolverResult.getStatus().getSeverity() > IStatus.WARNING) {
			throw new CoreException(dataTypeResolverResult.getStatus());
		}
		return dataTypeResolverResult.getSignatures();
	}
	
	protected IGeneratorContext createContext(Configuration configuration, IProgressMonitor monitor) throws CoreException {
		Fragment contextFragment = configuration.getContextFragment();
		if (contextFragment == null) {
			throw new CoreException(new Status(IStatus.ERROR, CodegenCPlugin.PLUGIN_ID, "No root system specification found in configuration"));
		}
		
		ExecutionFlow executionFlow = new ExecutionFlowBuilder().build(contextFragment, monitor);
		IGeneratorContext context = new GeneratorContext(configuration, executionFlow);
		componentGeneratorAdaptor.adaptGenerators(context, monitor);

		if (executionFlow.getAsynchronousZoneCount() > 0 && GeneratorConfigurationExtensions.getRuntimeEnvironmentAPI(context.getConfiguration()) == null) {
			throw new CoreException(new Status(IStatus.ERROR, CodegenCPlugin.PLUGIN_ID, "A runtime must be specified in the configuration for systems containing asynchronous components"));
		}

		Map<Component, IComponentSignature> signatures = resolveDataTypes(context);
		for (Node node : context.getExecutionFlow().getAllNodes()) {
			if (node instanceof ComponentNode) {
				ComponentNode componentNode = (ComponentNode) node;
				IComponentGenerator generator = GeneratorNodeExtensions.getComponentGenerator(componentNode);
				IVariableAccessor variableAccessor = variableAccessorFactory.create(configuration, componentNode);
				IComponentSignature componentSignature = signatures.get(componentNode.getComponent());
				ComponentGeneratorContext componentGeneratorContext = new ComponentGeneratorContext(componentNode, componentSignature, variableAccessor, configuration, context);
				generator.initialize(componentGeneratorContext, monitor);
			}
		}

		return context;
	}
	
}
