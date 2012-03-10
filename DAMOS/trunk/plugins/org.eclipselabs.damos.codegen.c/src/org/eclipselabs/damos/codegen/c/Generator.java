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
import java.io.OutputStreamWriter;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

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
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipselabs.damos.codegen.AbstractGenerator;
import org.eclipselabs.damos.codegen.c.internal.ComponentGeneratorAdaptor;
import org.eclipselabs.damos.codegen.c.internal.ComponentGeneratorContext;
import org.eclipselabs.damos.codegen.c.internal.GeneratorContext;
import org.eclipselabs.damos.codegen.c.internal.VariableAccessor;
import org.eclipselabs.damos.codegen.c.internal.registry.RuntimeEnvironmentAPIRegistry;
import org.eclipselabs.damos.codegen.c.internal.registry.TargetGeneratorDescriptor;
import org.eclipselabs.damos.codegen.c.internal.registry.TargetGeneratorRegistry;
import org.eclipselabs.damos.codegen.c.internal.rte.MessageQueueInfo;
import org.eclipselabs.damos.codegen.c.internal.util.InternalGeneratorUtil;
import org.eclipselabs.damos.codegen.c.rte.IRuntimeEnvironmentAPI;
import org.eclipselabs.damos.codegen.c.util.GeneratorConfigurationUtil;
import org.eclipselabs.damos.dconfig.Configuration;
import org.eclipselabs.damos.dml.Action;
import org.eclipselabs.damos.dml.ActionLink;
import org.eclipselabs.damos.dml.Choice;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.Fragment;
import org.eclipselabs.damos.dml.Inoutport;
import org.eclipselabs.damos.dml.Inport;
import org.eclipselabs.damos.dml.Input;
import org.eclipselabs.damos.dml.InputConnector;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.dml.Join;
import org.eclipselabs.damos.dml.Latch;
import org.eclipselabs.damos.dml.Memory;
import org.eclipselabs.damos.dml.Outport;
import org.eclipselabs.damos.dml.Output;
import org.eclipselabs.damos.dml.OutputPort;
import org.eclipselabs.damos.dml.WhileLoop;
import org.eclipselabs.damos.dml.util.DMLUtil;
import org.eclipselabs.damos.dmltext.MscriptValueSpecification;
import org.eclipselabs.damos.execution.DataTypeResolver;
import org.eclipselabs.damos.execution.DataTypeResolverResult;
import org.eclipselabs.damos.execution.IComponentSignature;
import org.eclipselabs.damos.execution.executionflow.ActionNode;
import org.eclipselabs.damos.execution.executionflow.ComponentNode;
import org.eclipselabs.damos.execution.executionflow.CompoundNode;
import org.eclipselabs.damos.execution.executionflow.DataFlowEnd;
import org.eclipselabs.damos.execution.executionflow.DataFlowSourceEnd;
import org.eclipselabs.damos.execution.executionflow.DataFlowTargetEnd;
import org.eclipselabs.damos.execution.executionflow.ExecutionFlow;
import org.eclipselabs.damos.execution.executionflow.Graph;
import org.eclipselabs.damos.execution.executionflow.Node;
import org.eclipselabs.damos.execution.executionflow.TaskGraph;
import org.eclipselabs.damos.execution.executionflow.TaskInputNode;
import org.eclipselabs.damos.execution.executionflow.build.ExecutionFlowBuilder;
import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.VariableReference;
import org.eclipselabs.damos.mscript.codegen.c.ExpressionGenerator;
import org.eclipselabs.damos.mscript.codegen.c.IVariableAccessStrategy;
import org.eclipselabs.damos.mscript.codegen.c.MscriptGeneratorContext;
import org.eclipselabs.damos.mscript.codegen.c.util.MscriptGeneratorUtil;
import org.eclipselabs.damos.mscript.computationmodel.ComputationModel;
import org.eclipselabs.damos.mscript.computationmodel.util.ComputationModelUtil;
import org.eclipselabs.damos.mscript.interpreter.StaticEvaluationContext;

/**
 * @author Andreas Unger
 *
 */
public class Generator extends AbstractGenerator {

	private final DataTypeResolver dataTypeResolver = new DataTypeResolver();

	public void generate(Configuration configuration, final IProgressMonitor monitor) throws CoreException {
		Fragment contextFragment = configuration.getContextFragment();
		if (contextFragment == null) {
			throw new CoreException(new Status(IStatus.ERROR, CodegenCPlugin.PLUGIN_ID, "No system configuration specified"));
		}
		
		ITargetGenerator targetGenerator = getTargetGenerator(configuration);
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

		IFile headerFile = headerContainer.getFile(new Path(systemHeaderFile));
		
		if (targetGenerator != null) {
			targetGenerator.generate(context, monitor);
		}

		new FileWriter() {
			
			@Override
			protected void write(Writer writer) throws CoreException {
				try {
					generateHeaderFile(context, new PrintWriter(writer), monitor);
				} catch (IOException e) {
					throw new CoreException(new Status(IStatus.ERROR, CodegenCPlugin.PLUGIN_ID, "I/O error occurred", e));
				}
			}
			
		}.write(headerFile, monitor);

		IFile sourceFile = sourceContainer.getFile(new Path(systemSourceFile));
		new FileWriter() {
			
			@Override
			protected void write(Writer writer) throws CoreException {
				try {
					generateSourceFile(context, new PrintWriter(writer), monitor);
				} catch (IOException e) {
					throw new CoreException(new Status(IStatus.ERROR, CodegenCPlugin.PLUGIN_ID, "I/O error occurred", e));
				}
			}
			
		}.write(sourceFile, monitor);
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

		if (executionFlow.getAsynchronousZoneCount() > 0 && getRuntimeEnvironmentAPI(context) == null) {
			throw new CoreException(new Status(IStatus.ERROR, CodegenCPlugin.PLUGIN_ID, "A runtime must be specified in the configuration for systems containing asynchronous components"));
		}

		Map<Component, IComponentSignature> signatures = resolveDataTypes(context);
		for (Node node : getAllNodes(context.getExecutionFlow())) {
			if (node instanceof ComponentNode) {
				ComponentNode componentNode = (ComponentNode) node;
				IComponentGenerator generator = InternalGeneratorUtil.getComponentGenerator(componentNode);
				IVariableAccessor variableAccessor = new VariableAccessor(configuration, componentNode);
				IComponentSignature componentSignature = signatures.get(componentNode.getComponent());
				ComponentGeneratorContext componentGeneratorContext = new ComponentGeneratorContext(componentNode, componentSignature, variableAccessor, configuration);
				generator.initialize(componentGeneratorContext, monitor);
			}
		}

		return context;
	}
	
	private void generateHeaderFile(IGeneratorContext context, PrintWriter writer, IProgressMonitor monitor) throws CoreException, IOException {
		String headerFileName = GeneratorConfigurationUtil.getSystemHeaderFile(context.getConfiguration());
		String headerMacro = headerFileName.replaceAll("\\W", "_").toUpperCase() + "_";
		
		String prefix = GeneratorConfigurationUtil.getPrefix(context.getConfiguration());
		
		writer.printf("#ifndef %s\n", headerMacro);
		writer.printf("#define %s\n", headerMacro);
		writer.println();
		
		writer.println("#include <stdint.h>");

		if (context.getExecutionFlow().getAsynchronousZoneCount() > 0) {
			IRuntimeEnvironmentAPI runtimeEnvironmentAPI = getRuntimeEnvironmentAPI(context);
			if (runtimeEnvironmentAPI != null) {
				runtimeEnvironmentAPI.writeTaskInfoInclude(writer);
			}
		}

		writer.println();
		writer.println("#ifdef __cplusplus");
		writer.println("extern \"C\" {");
		writer.println("#endif /* __cplusplus */");
		writer.println();
		
		if (!context.getExecutionFlow().getTaskGraphs().isEmpty()) {
			writer.printf("#define %sTASK_COUNT %d\n", prefix.toUpperCase(), context.getExecutionFlow().getTaskGraphs().size());
			writer.printf("extern const %s %staskInfos[];\n\n", getRuntimeEnvironmentAPI(context).getTaskInfoStructName(), prefix);
		}

		writer.println("typedef struct {");
		for (Node node : context.getExecutionFlow().getGraph().getNodes()) {
			if (!(node instanceof ComponentNode)) {
				continue;
			}
			ComponentNode componentNode = (ComponentNode) node;
			if (!(componentNode.getComponent() instanceof Inport)) {
				continue;
			}
			IComponentGenerator generator = InternalGeneratorUtil.getComponentGenerator(componentNode);
			IComponentSignature signature = generator.getContext().getComponentSignature();
			OutputPort outputPort = componentNode.getComponent().getFirstOutputPort();
			DataType dataType = signature.getOutputDataType(outputPort);
			writer.printf("%s;\n", MscriptGeneratorUtil.getCVariableDeclaration(getComputationModel(context, componentNode), dataType, InternalGeneratorUtil.uncapitalize(componentNode.getComponent().getName()), false));
		}
		writer.printf("} %sInput;\n", prefix);
		
		writer.println();

		writer.println("typedef struct {");
		for (Node node : context.getExecutionFlow().getGraph().getNodes()) {
			if (!(node instanceof ComponentNode)) {
				continue;
			}
			ComponentNode componentNode = (ComponentNode) node;
			if (!(componentNode.getComponent() instanceof Outport)) {
				continue;
			}
			IComponentGenerator generator = InternalGeneratorUtil.getComponentGenerator(componentNode);
			IComponentSignature signature = generator.getContext().getComponentSignature();
			OutputPort outputPort = componentNode.getComponent().getFirstOutputPort();
			DataType dataType = signature.getOutputDataType(outputPort);
			writer.printf("%s;\n", MscriptGeneratorUtil.getCVariableDeclaration(getComputationModel(context, componentNode), dataType, InternalGeneratorUtil.uncapitalize(componentNode.getComponent().getName()), false));
		}
		writer.printf("} %sOutput;\n", prefix);

		writer.println();
		writer.printf("void %sinitialize(void);\n", prefix);
		writer.printf("void %sexecute(const %sInput *input, %sOutput *output);\n", prefix, prefix, prefix);

		writer.println();
		writer.println("#ifdef __cplusplus");
		writer.println("}");
		writer.println("#endif /* __cplusplus */");
		writer.println();
		writer.printf("#endif /* %s */\n", headerMacro);
	}
	
	private void generateSourceFile(IGeneratorContext context, PrintWriter writer, IProgressMonitor monitor) throws CoreException, IOException {
		String prefix = GeneratorConfigurationUtil.getPrefix(context.getConfiguration());

		generateIncludes(context, writer);

		writer.println();
		
		if (!context.getExecutionFlow().getTaskGraphs().isEmpty()) {
			for (TaskGraph taskGraph : context.getExecutionFlow().getTaskGraphs()) {
				writer.append("static ");
				getRuntimeEnvironmentAPI(context).writeTaskSignature(writer, InternalGeneratorUtil.getTaskName(context.getConfiguration(), taskGraph));
				writer.append(";\n");
			}

			writer.println();
			writer.printf("const %s %staskInfos[] = {\n", getRuntimeEnvironmentAPI(context).getTaskInfoStructName(), prefix);
			boolean first = true;
			for (TaskGraph taskGraph : context.getExecutionFlow().getTaskGraphs()) {
				if (first) {
					first = false;
				} else {
					writer.append(",\n");
				}
				writer.append("{ ").append(InternalGeneratorUtil.getTaskName(context.getConfiguration(), taskGraph)).append(" }");
			}
			writer.println("\n};\n");
			
			for (TaskGraph taskGraph : context.getExecutionFlow().getTaskGraphs()) {
				EList<Input> inputSockets = getInputSockets(taskGraph);
				if (!inputSockets.isEmpty()) {
					writer.append("typedef struct {\n");
					writer.append("int kind;\n");
					writer.append("union {\n");
					for (Input input : inputSockets) {
						if (!input.getPorts().isEmpty()) {
							ComponentNode componentNode = (ComponentNode) taskGraph.getInitialNodes().get(0);
							IComponentGenerator generator = InternalGeneratorUtil.getComponentGenerator(componentNode);
							IComponentSignature signature = generator.getContext().getComponentSignature();
							writer.append(MscriptGeneratorUtil.getCDataType(getComputationModel(context, componentNode), signature.getInputDataType(input.getPorts().get(0))));
							writer.append(" ");
							writer.append(input.getName());
							writer.append(";\n");
						}
					}
					writer.append("} data;\n");
					writer.printf("} %s_Message;\n\n", InternalGeneratorUtil.getTaskName(context.getConfiguration(), taskGraph));
				}
			}
		}
		
		boolean hasContext = hasContext(context.getExecutionFlow());
		Graph graph = context.getExecutionFlow().getGraph();
		if (hasContext) {
			for (Node node : getAllNodes(context.getExecutionFlow())) {
				if (!(node instanceof ComponentNode)) {
					continue;
				}
				ComponentNode componentNode = (ComponentNode) node;
				IComponentGenerator generator = InternalGeneratorUtil.getComponentGenerator(componentNode);
				if (generator.contributesContextCode()) {
					String typeName = InternalGeneratorUtil.getPrefix(context.getConfiguration(), node) + componentNode.getComponent().getName() + "_Context";
					generator.writeContextCode(writer, typeName, monitor);
					writer.append("\n");
				}
			}
			writer.println("typedef struct {");
			generateTaskContexts(context, writer);
			for (Node node : getAllNodes(context.getExecutionFlow())) {
				if (!(node instanceof ComponentNode)) {
					continue;
				}
				ComponentNode componentNode = (ComponentNode) node;
				IComponentGenerator generator = InternalGeneratorUtil.getComponentGenerator(componentNode);
				if (generator.contributesContextCode()) {
					writer.printf("%s%s_Context %s;\n", InternalGeneratorUtil.getPrefix(context.getConfiguration(), node), componentNode.getComponent().getName(), InternalGeneratorUtil.getPrefix(context.getConfiguration(), node) + componentNode.getComponent().getName());
				}
			}
			writer.printf("} %sContext;\n\n", prefix);
			writer.printf("static %sContext %scontext;\n\n", prefix, prefix);
		}
		
		generateTasks(context, writer, monitor);
		
		writer.printf("void %sinitialize(void) {\n", prefix);
		generateInitializeTasks(context, writer);
		for (Node node : getAllNodes(context.getExecutionFlow())) {
			if (!(node instanceof ComponentNode)) {
				continue;
			}
			ComponentNode componentNode = (ComponentNode) node;
			IComponentGenerator generator = InternalGeneratorUtil.getComponentGenerator(componentNode);
			if (generator.contributesInitializationCode()) {
				writer.printf("/* %s */\n", componentNode.getComponent().getName());
				writer.println("{");
				generator.writeInitializationCode(writer, monitor);
				writer.println("}\n");
			}
		}
		writer.print("}\n\n");

		writer.printf("void %sexecute(const %sInput *input, %sOutput *output) {\n", prefix, prefix, prefix);
		
		generateOutputVariableDeclarations(context, graph, writer);
		writer.println();
		generateGraph(context, graph, writer, monitor);
		
		writer.println("}");
	}

	private void generateTaskContexts(IGeneratorContext context, PrintWriter writer) throws IOException {
		IRuntimeEnvironmentAPI runtimeEnvironmentAPI = getRuntimeEnvironmentAPI(context);
		if (runtimeEnvironmentAPI != null) {
			for (TaskGraph taskGraph : context.getExecutionFlow().getTaskGraphs()) {
				String taskName = InternalGeneratorUtil.getTaskName(context.getConfiguration(), taskGraph);
				EList<TaskInputNode> inputNodes = taskGraph.getInputNodes();
				writer.append("struct {\n");
				if (!inputNodes.isEmpty()) {
					if (getInputSockets(taskGraph).isEmpty()) {
						TaskInputNode inputNode = inputNodes.get(0);
						MessageQueueInfo messageQueueInfo = createMessageQueueInfoFor(context, inputNode);
						runtimeEnvironmentAPI.getMessageQueueGenerator().writeContextCode(writer, "queue", messageQueueInfo);
					} else {
						MessageQueueInfo messageQueueInfo = createMessageQueueInfoFor(context, taskGraph);
						runtimeEnvironmentAPI.getMessageQueueGenerator().writeContextCode(writer, "queue", messageQueueInfo);
					}
				}
				writer.append("} ").append(taskName).append(";\n");
			}
		}
	}

	/**
	 * @param configuration
	 * @param inputNode
	 * @return
	 */
	private MessageQueueInfo createMessageQueueInfoFor(IGeneratorContext context, TaskInputNode inputNode) {
		return new MessageQueueInfo("10", "sizeof(" + getCDataTypeFor(context, inputNode) + ")");
	}
	
	private MessageQueueInfo createMessageQueueInfoFor(IGeneratorContext context, TaskGraph taskGraph) {
		return new MessageQueueInfo("10", "sizeof(" + InternalGeneratorUtil.getTaskName(context.getConfiguration(), taskGraph) + "_Message)");
	}

	private void generateInitializeTasks(IGeneratorContext context, PrintWriter writer) throws IOException {
		IRuntimeEnvironmentAPI runtimeEnvironmentAPI = getRuntimeEnvironmentAPI(context);
		if (runtimeEnvironmentAPI != null) {
			for (TaskGraph taskGraph : context.getExecutionFlow().getTaskGraphs()) {
				String taskName = InternalGeneratorUtil.getTaskName(context.getConfiguration(), taskGraph);
				EList<TaskInputNode> inputNodes = taskGraph.getInputNodes();
				if (!inputNodes.isEmpty()) {
					writer.append(" {\n");
					String qualifier = getTaskContextVariable(context, taskName, false) + "." + "queue";
					if (getInputSockets(taskGraph).isEmpty()) {
						TaskInputNode inputNode = inputNodes.get(0);
						MessageQueueInfo messageQueueInfo = createMessageQueueInfoFor(context, inputNode);
						runtimeEnvironmentAPI.getMessageQueueGenerator().writeInitializationCode(writer, qualifier, messageQueueInfo);
					} else {
						MessageQueueInfo messageQueueInfo = createMessageQueueInfoFor(context, taskGraph);
						runtimeEnvironmentAPI.getMessageQueueGenerator().writeInitializationCode(writer, qualifier, messageQueueInfo);
					}
					writer.append("}\n");
				}
			}
		}
	}
	
	private String getCDataTypeFor(IGeneratorContext context, TaskInputNode inputNode) {
		DataFlowEnd end = inputNode.getDrivingEnds().get(0);
		IComponentGenerator componentGenerator = InternalGeneratorUtil.getComponentGenerator((ComponentNode) end.getNode());
		DataType dataType = componentGenerator.getContext().getComponentSignature().getOutputDataType((OutputPort) end.getConnector());
		return MscriptGeneratorUtil.getCDataType(getComputationModel(context, (ComponentNode) end.getNode()), dataType);
	}

	/**
	 * @param configuration
	 * @param executionFlow
	 * @param writer
	 * @throws IOException
	 */
	private void generateIncludes(IGeneratorContext context, PrintWriter writer)
			throws IOException {
		writer.println("#include <string.h>");
		writer.println("#include <math.h>");
//		writer.println("#include <damos/math.h>");
		
		ITargetGenerator targetGenerator = getTargetGenerator(context.getConfiguration());
		if (targetGenerator != null && targetGenerator.contributesIncludes(context)) {
			targetGenerator.writeIncludes(context, writer);
		}
		
		if (context.getExecutionFlow().getAsynchronousZoneCount() > 0) {
			IRuntimeEnvironmentAPI runtimeEnvironmentAPI = getRuntimeEnvironmentAPI(context);
			if (runtimeEnvironmentAPI != null) {
				runtimeEnvironmentAPI.writeMultitaskingIncludes(writer);
			}
		}
		
		writer.println();
		writer.printf("#include \"%s\"\n", GeneratorConfigurationUtil.getSystemHeaderFile(context.getConfiguration()));
	}

	/**
	 * @param configuration
	 * @param executionFlow
	 * @param writer
	 * @param monitor
	 * @throws IOException
	 * @throws CoreException
	 */
	private void generateTasks(IGeneratorContext context, PrintWriter writer,
			IProgressMonitor monitor) throws IOException, CoreException {
		IRuntimeEnvironmentAPI runtimeEnvironmentAPI = getRuntimeEnvironmentAPI(context);
		if (runtimeEnvironmentAPI != null) {
			for (TaskGraph taskGraph : context.getExecutionFlow().getTaskGraphs()) {
				String taskName = InternalGeneratorUtil.getTaskName(context.getConfiguration(), taskGraph);
				writer.append("static ");
				runtimeEnvironmentAPI.writeTaskSignature(writer, taskName);
				writer.append(" {\n");
				generateOutputVariableDeclarations(context, taskGraph, writer);
				
				if (getInputSockets(taskGraph).isEmpty()) {
					TaskInputNode inputNode = taskGraph.getInputNodes().get(0);
					String taskInputVariableName = InternalGeneratorUtil.getTaskInputVariableName(context.getConfiguration(), inputNode);
					writer.append(getCDataTypeFor(context, inputNode)).append(" ").append(taskInputVariableName).append(";\n");
				} else {
					writer.append(InternalGeneratorUtil.getTaskName(context.getConfiguration(), taskGraph));
					writer.append("_Message ");
					writer.append(InternalGeneratorUtil.getTaskName(context.getConfiguration(), taskGraph));
					writer.append("_message;\n");
				}
				
				writer.append("for (;;) {\n");
				
				EList<TaskInputNode> inputNodes = taskGraph.getInputNodes();
				if (!inputNodes.isEmpty()) {
					String qualifier = getTaskContextVariable(context, taskName, false) + "." + "queue";
					if (getInputSockets(taskGraph).isEmpty()) {
						TaskInputNode inputNode = inputNodes.get(0);
						String taskInputVariableName = InternalGeneratorUtil.getTaskInputVariableName(context.getConfiguration(), inputNode);
						MessageQueueInfo messageQueueInfo = createMessageQueueInfoFor(context, inputNode);
						runtimeEnvironmentAPI.getMessageQueueGenerator().writeReceiveCode(writer, qualifier, "&" + taskInputVariableName, messageQueueInfo);
					} else {
						String taskInputVariableName = InternalGeneratorUtil.getTaskName(context.getConfiguration(), taskGraph) + "_message";
						MessageQueueInfo messageQueueInfo = createMessageQueueInfoFor(context, taskGraph);
						runtimeEnvironmentAPI.getMessageQueueGenerator().writeReceiveCode(writer, qualifier, "&" + taskInputVariableName, messageQueueInfo);
					}
				}

				generateGraph(context, taskGraph, writer, monitor);
								
				writer.append("}\n");
				runtimeEnvironmentAPI.writeTaskReturnStatement(writer, taskName);
				writer.append("}\n");
			}
		}
	}

	private String getTaskContextVariable(IGeneratorContext context, String taskName, boolean pointer) {
		StringBuilder sb = new StringBuilder();
		if (pointer) {
			sb.append("(&");
		}
		String prefix = GeneratorConfigurationUtil.getPrefix(context.getConfiguration());
		if (prefix != null) {
			sb.append(prefix);
		}
		sb.append("context.");
		sb.append(taskName);
		if (pointer) {
			sb.append(")");
		}
		return sb.toString();
	}

	/**
	 * @param configuration
	 * @param graph
	 * @param writer
	 */
	private void generateOutputVariableDeclarations(IGeneratorContext context, Graph graph, PrintWriter writer) {
		for (Node node : getAllNodes(graph)) {
			if (!(node instanceof ComponentNode)) {
				continue;
			}
			ComponentNode componentNode = (ComponentNode) node;
			Component component = componentNode.getComponent();
			
			if (component instanceof Inoutport) {
				continue;
			}
			
			IComponentGenerator generator = InternalGeneratorUtil.getComponentGenerator(componentNode);
			for (Output output : component.getOutputs()) {
				if (output.isTestPoint()) {
					continue;
				}
				for (OutputPort outputPort : output.getPorts()) {
					ComputationModel computationModel = getComputationModel(context, componentNode);
					DataType outputDataType = generator.getContext().getComponentSignature().getOutputDataType(outputPort);
					String cDataType = MscriptGeneratorUtil.getCDataType(computationModel, outputDataType);
					writer.printf("%s %s;\n", cDataType, getOutputVariableName(context, componentNode, outputPort));
				}
			}
		}
	}

	/**
	 * @param configuration
	 * @param graph
	 * @param writer
	 * @param monitor
	 * @throws CoreException
	 * @throws IOException 
	 */
	private void generateGraph(IGeneratorContext context, Graph graph, PrintWriter writer, IProgressMonitor monitor)
			throws CoreException, IOException {
		boolean hasChoices = false;
		for (Node node : getAllNodes(graph)) {
			if (node instanceof ComponentNode) {
				ComponentNode componentNode = (ComponentNode) node;
				Component component = componentNode.getComponent();
				
				if (component instanceof Choice) {
					writer.printf("uint_fast8_t %s;\n", getChoiceVariableName(context, componentNode));
					hasChoices = true;
				}
			}
		}
		
		if (hasChoices) {
			writer.println();
		}

		writer.print("/*\n * Compute outputs\n */\n\n");
		for (Node node : graph.getNodes()) {
			if (node instanceof CompoundNode) {
				generateCompoundCode(context, (CompoundNode) node, writer, monitor);
				writer.println();
				continue;
			} else if (!(node instanceof ComponentNode)) {
				continue;
			}
			ComponentNode componentNode = (ComponentNode) node;
			Component component = componentNode.getComponent();
			
			// TODO move the following code to ChoiceGenerator class
			if (component instanceof Choice) {
				writer.printf("/* %s */\n", componentNode.getComponent().getName());

				Choice choice = (Choice) component;
				
				String incomingVariableName = getIncomingVariableName(context, componentNode, choice.getFirstInputPort());
				String choiceResult = getChoiceVariableName(context, componentNode);
				
				int i = 0;
				for (ActionLink actionLink : choice.getActionLinks()) {
					if (actionLink.getCondition() != null) {
						if (i > 0) {
							writer.print("} else ");
						}
						writer.printf("if (%s == (", incomingVariableName);
						
						if (actionLink.getCondition() instanceof MscriptValueSpecification) {
							MscriptValueSpecification condition = (MscriptValueSpecification) actionLink.getCondition();
							ComputationModel computationModel = getComputationModel(context, componentNode);
							ActionLinkConditionVariableAccessStrategy variableAccessStrategy = new ActionLinkConditionVariableAccessStrategy();
							new ExpressionGenerator().generate(new MscriptGeneratorContext(writer, computationModel, new StaticEvaluationContext(), variableAccessStrategy), condition.getExpression());
						} else {
							// TODO: Handle error
						}

						writer.println(")) {");
						writer.printf("%s = %d;\n", choiceResult, i);
						++i;
					}
				}
				i = 0;
				for (ActionLink actionLink : choice.getActionLinks()) {
					if (actionLink.getCondition() == null) {
						writer.println("} else {");
						writer.printf("%s = %d;\n", choiceResult, i);
					}
					++i;
				}
				writer.println("}\n");
			} else if (component instanceof Join) {
				writer.printf("/* %s */\n", componentNode.getComponent().getName());
				Map<Integer, String> variableNameMap = new TreeMap<Integer, String>();
				ComponentNode choiceNode = null;
				for (InputPort inputPort : component.getInputPorts()) {
					DataFlowTargetEnd targetEnd = componentNode.getIncomingDataFlow(inputPort);
					DataFlowSourceEnd sourceEnd = targetEnd.getDataFlow().getSourceEnd();
					CompoundNode enclosingCompoundNode = findEnclosingActionNodeWithActionLink(sourceEnd.getNode());
					if (enclosingCompoundNode instanceof ActionNode) {
						ActionNode actionNode = (ActionNode) enclosingCompoundNode;
						Action action = (Action) actionNode.getCompound();
						if (actionNode.getChoiceNode() != null) {
							variableNameMap.put(DMLUtil.indexOf(action.getLink()), getIncomingVariableName(context, componentNode, inputPort));
							choiceNode = actionNode.getChoiceNode();
						}
					}
				}
				writer.printf("switch (%s) {\n", getChoiceVariableName(context, choiceNode));
				for (Entry<Integer, String> entry : variableNameMap.entrySet()) {
					writer.printf("case %d:\n", entry.getKey());
					writer.printf("%s = %s;\n", getOutputVariableName(context, componentNode, component.getFirstOutputPort()), entry.getValue());
					writer.println("break;");
				}
				writer.println("}\n");
			} else if (component instanceof Memory) {
				writer.printf("/* %s */\n", componentNode.getComponent().getName());
				writer.println("{");
				writer.printf("%s = %s;\n", getOutputVariableName(context, componentNode, component.getFirstOutputPort()), getMemoryPreviousValueVariableName(context, componentNode));
				writer.println("}\n");
			} else {
				IComponentGenerator generator = InternalGeneratorUtil.getComponentGenerator(componentNode);
				if (generator.contributesComputeOutputsCode()) {
					writer.printf("/* %s */\n", componentNode.getComponent().getName());
					writer.println("{");
					generator.writeComputeOutputsCode(writer, monitor);
					writer.println("}\n");
				}
				generateLatchUpdate(context, componentNode, writer);
				generateMessageQueueSend(context, componentNode, writer);
			}
		}
		
		writer.print("\n/*\n * Update states\n */\n\n");
		for (Node node : graph.getNodes()) {
			if (!(node instanceof ComponentNode)) {
				continue;
			}
			ComponentNode componentNode = (ComponentNode) node;
			Component component = componentNode.getComponent();
			
			if (component instanceof Memory) {
				writer.printf("/* %s */\n", component.getName());
				writer.println("{");
				writer.printf("%s = %s;\n", getMemoryPreviousValueVariableName(context, componentNode), getIncomingVariableName(context, componentNode, component.getInputPorts().get(1)));
				writer.println("}");
			} else {
				IComponentGenerator generator = InternalGeneratorUtil.getComponentGenerator(componentNode);
				if (generator.contributesUpdateCode()) {
					writer.printf("/* %s */\n", componentNode.getComponent().getName());
					writer.println("{");
					generator.writeUpdateCode(writer, monitor);
					writer.println("}\n");
				}
			}
		}
	}

	/**
	 * @param configuration
	 * @param componentNode
	 * @param writer
	 */
	private void generateLatchUpdate(IGeneratorContext context, ComponentNode componentNode, PrintWriter writer) throws IOException {
		for (DataFlowEnd end : componentNode.getDrivenEnds()) {
			if (end.getNode() instanceof ComponentNode) {
				ComponentNode otherComponentNode = (ComponentNode) end.getNode();
				if (otherComponentNode.getComponent() instanceof Latch) {
					String contextVariable = new VariableAccessor(context.getConfiguration(), otherComponentNode).getContextVariable(false);
					String variableName = contextVariable + "." + "lock";
					String outputVariable = new VariableAccessor(context.getConfiguration(), componentNode).getOutputVariable((OutputPort) end.getDataFlow().getSourceEnd().getConnector(), false);

					getRuntimeEnvironmentAPI(context).getFastLockGenerator().writeLockCode(writer, variableName);
					new Formatter(writer).format("%s.data = %s;\n", contextVariable, outputVariable);
					getRuntimeEnvironmentAPI(context).getFastLockGenerator().writeUnlockCode(writer, variableName);
				}
			}
		}
	}

	/**
	 * @param configuration
	 * @param componentNode
	 * @param writer
	 */
	private void generateMessageQueueSend(IGeneratorContext context, ComponentNode componentNode, PrintWriter writer) throws IOException {
		for (DataFlowEnd end : componentNode.getDrivenEnds()) {
			if (end.getNode() instanceof TaskInputNode) {
				TaskInputNode inputNode = (TaskInputNode) end.getNode();
				
				String taskName = InternalGeneratorUtil.getTaskName(context.getConfiguration(), inputNode.getTaskGraph());
				String qualifier = getTaskContextVariable(context, taskName, false) + "." + "queue";
				String outputVariable = new VariableAccessor(context.getConfiguration(), componentNode).getOutputVariable((OutputPort) end.getDataFlow().getSourceEnd().getConnector(), false);

				DataFlowTargetEnd firstEnd = inputNode.getDrivenEnds().get(0);
				if (firstEnd.getConnector() instanceof InputPort) {
					InputPort inputPort = (InputPort) firstEnd.getConnector();
					Input input = inputPort.getInput();
					if (input.isSocket()) {
						writer.append("{\n");
						writer.append(InternalGeneratorUtil.getTaskName(context.getConfiguration(), inputNode.getTaskGraph()) + "_Message message;\n");
						writer.printf("message.kind = %d;\n", input.getComponent().getInputSockets().indexOf(input));
						writer.printf("message.data.%s = %s;\n", input.getName(), outputVariable);
						MessageQueueInfo messageQueueInfo = createMessageQueueInfoFor(context, inputNode.getTaskGraph());
						getRuntimeEnvironmentAPI(context).getMessageQueueGenerator().writeSendCode(writer, qualifier, "&message", messageQueueInfo);
						writer.append("}\n");
						continue;
					}
				}
				
				MessageQueueInfo messageQueueInfo = createMessageQueueInfoFor(context, inputNode);
				getRuntimeEnvironmentAPI(context).getMessageQueueGenerator().writeSendCode(writer, qualifier, "&" + outputVariable, messageQueueInfo);
			}
		}
	}

	private String getChoiceVariableName(IGeneratorContext context, ComponentNode componentNode) {
		return String.format("%s%s_result", InternalGeneratorUtil.getPrefix(context.getConfiguration(), componentNode), componentNode.getComponent().getName());
	}
	
	/**
	 * @param configuration
	 * @param compoundNode
	 * @param writer
	 * @param monitor
	 * @throws CoreException 
	 * @throws IOException 
	 */
	private void generateCompoundCode(IGeneratorContext context, CompoundNode compoundNode, PrintWriter writer, IProgressMonitor monitor) throws CoreException, IOException {
		if (compoundNode instanceof ActionNode) {
			ActionNode actionNode = (ActionNode) compoundNode;
			Action action = (Action) actionNode.getCompound();
			
			if (actionNode.getChoiceNode() != null) {
				Choice choice = (Choice) actionNode.getChoiceNode().getComponent();
				int index = getActionIndex(choice, action);
				writer.printf("if (%s%s_result == %d) ", InternalGeneratorUtil.getPrefix(context.getConfiguration(), compoundNode), choice.getName(), index);
			}
			
			writer.print("{\n");
			
			for (Node node : compoundNode.getNodes()) {
				if (node instanceof ComponentNode) {
					ComponentNode componentNode = (ComponentNode) node;
					if (componentNode.getComponent() instanceof Memory) {
						Memory memory = (Memory) componentNode.getComponent();
						IComponentGenerator generator = InternalGeneratorUtil.getComponentGenerator(componentNode);
						String cDataType = MscriptGeneratorUtil.getCDataType(getComputationModel(context, componentNode), generator.getContext().getComponentSignature().getOutputDataType(memory.getFirstOutputPort()));
						
						String initializer = getIncomingVariableName(context, componentNode, memory.getFirstInputPort());
						
						writer.printf("%s %s = %s;\n", cDataType, getMemoryPreviousValueVariableName(context, componentNode), initializer);
					}
				}
			}

			if (action instanceof WhileLoop) {
				writer.print("do {\n");
			}
			
			generateGraph(context, compoundNode, writer, monitor);
			
			if (action instanceof WhileLoop) {
				WhileLoop whileLoop = (WhileLoop) action;

				InputConnector inputConnector = whileLoop.getCondition();
				String condition = getIncomingVariableName(context, actionNode, inputConnector);
				if (condition == null) {
					condition = "0";
				}
				
				writer.printf("} while (%s);\n", condition);
			}

			writer.print("}\n");
		}
	}
	
	private String getMemoryPreviousValueVariableName(IGeneratorContext context, ComponentNode componentNode) {
		return String.format("%s%s_previousValue", InternalGeneratorUtil.getPrefix(context.getConfiguration(), componentNode), componentNode.getComponent().getName());
	}

	/**
	 * @param configuration
	 * @param node
	 * @param inputConnector
	 * @return
	 */
	private String getIncomingVariableName(IGeneratorContext context, Node node, InputConnector inputConnector) {
		DataFlowTargetEnd targetEnd = node.getIncomingDataFlow(inputConnector);
		if (targetEnd != null) {
			DataFlowSourceEnd sourceEnd = targetEnd.getDataFlow().getSourceEnd();
			Node sourceNode = sourceEnd.getNode();
			if (sourceNode instanceof ComponentNode && sourceEnd.getConnector() instanceof OutputPort) {
				OutputPort outputPort = (OutputPort) sourceEnd.getConnector();
				ComponentNode componentNode = (ComponentNode) sourceNode;
				return new VariableAccessor(context.getConfiguration(), componentNode).getOutputVariable(outputPort, false);
			}
		}
		return null;
	}
	
	private EList<Input> getInputSockets(TaskGraph taskGraph) {
		EList<Node> initialNodes = taskGraph.getInitialNodes();
		if (!initialNodes.isEmpty()) {
			Node node = initialNodes.get(0);
			if (node instanceof ComponentNode) {
				ComponentNode componentNode = (ComponentNode) node;
				return componentNode.getComponent().getInputSockets();
			}
		}
		return ECollections.emptyEList();
	}
	
	private String getOutputVariableName(IGeneratorContext context, ComponentNode componentNode, OutputPort outputPort) {
		return String.format("%s%s_%s", InternalGeneratorUtil.getPrefix(context.getConfiguration(), componentNode), componentNode.getComponent().getName(), InternalGeneratorUtil.getOutputPortName(outputPort));
	}

	/**
	 * @param choice
	 * @param action
	 * @return
	 */
	private int getActionIndex(Choice choice, Action action) {
		int index = 0;
		for (ActionLink actionLink : choice.getActionLinks()) {
			if (actionLink.getAction() == action) {
				break;
			}
			++index;
		}
		return index;
	}

	private boolean hasContext(ExecutionFlow executionFlow) {
		for (Node node : getAllNodes(executionFlow)) {
			if (node instanceof ComponentNode) {
				ComponentNode componentNode = (ComponentNode) node;
				IComponentGenerator generator = InternalGeneratorUtil.getComponentGenerator(componentNode);
				if (generator.contributesContextCode()) {
					return true;
				}
			}
		}
		return false;
	}
	
	private ComputationModel getComputationModel(IGeneratorContext context, ComponentNode node) {
		ComputationModel computationModel = context.getConfiguration().getComputationModel(node.getSystemPath());
		if (computationModel == null) {
			computationModel = ComputationModelUtil.constructDefaultComputationModel();
		}
		return computationModel;
	}
	
	private CompoundNode findEnclosingActionNodeWithActionLink(Node node) {
		Graph graph;
		for (;;) {
			graph = node.getGraph();
			if (graph instanceof CompoundNode) {
				CompoundNode compoundNode = (CompoundNode) graph;
				if (compoundNode.getCompound() instanceof Action) {
					Action action = (Action) compoundNode.getCompound();
					if (action.getLink() != null) {
						return compoundNode;
					}
				}
			}
			if (graph instanceof Node) {
				node = (Node) graph;
			} else {
				break;
			}
		}
		return null;
	}

	protected final IRuntimeEnvironmentAPI getRuntimeEnvironmentAPI(IGeneratorContext context) {
		String runtimeId = context.getConfiguration().getPropertySelectionName("damos.rte.runtime");
		if (runtimeId != null) {
			return RuntimeEnvironmentAPIRegistry.getInstance().getRuntimeEnvironmentAPI(runtimeId);
		}
		return null;
	}
	
	private ITargetGenerator getTargetGenerator(Configuration configuration) {
		String targetId = configuration.getPropertySelectionName("damos.codegen.target");
		if (targetId != null) {
			TargetGeneratorDescriptor targetGeneratorDescriptor = TargetGeneratorRegistry.getInstance().getGenerator(targetId);
			if (targetGeneratorDescriptor != null) {
				return targetGeneratorDescriptor.createGenerator();
			}
		}
		return null;
	}

	/**
	 * @author Andreas Unger
	 *
	 */
	private static final class ActionLinkConditionVariableAccessStrategy implements IVariableAccessStrategy {
		
		public String getVariableAccessString(VariableReference variableReference) {
			return "";
		}
		
	}

	private static abstract class FileWriter {

		/* (non-Javadoc)
		 * @see java.lang.Runnable#run()
		 */
		public void write(final IFile targetFile, final IProgressMonitor monitor) throws CoreException {
			final PipedInputStream pipedInputStream = new PipedInputStream();
			PipedOutputStream pipedOutputStream;
			try {
				pipedOutputStream = new PipedOutputStream(pipedInputStream);
			} catch (IOException e) {
				throw new CoreException(new Status(IStatus.ERROR, CodegenCPlugin.PLUGIN_ID, "Writing file '" + targetFile.getName() + "' failed", e));
			}

			Writer writer = new OutputStreamWriter(pipedOutputStream);
			WriterThread thread = new WriterThread(targetFile, pipedInputStream, monitor);
	
			thread.start();

			IStatus status = Status.OK_STATUS;
			try {
				write(writer);
			} catch (CoreException e) {
				status = e.getStatus();
			} finally {
				try {
					writer.close();
				} catch (IOException e) {
					if (status.isOK()) {
						status = new Status(IStatus.ERROR, CodegenCPlugin.PLUGIN_ID, "Closing file '" + targetFile.getName() + "' failed", e);
					}
				} finally {
					try {
						thread.join();
						if (status.isOK() && !thread.getStatus().isOK()) {
							status = thread.getStatus();
						}
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
					}
				}
			}
			if (status.getSeverity() > IStatus.WARNING) {
				throw new CoreException(status);
			}
		}
		
		protected abstract void write(Writer writer) throws CoreException;

		/**
		 * @author Andreas Unger
		 *
		 */
		private final class WriterThread extends Thread {
			/**
			 * 
			 */
			private final IFile targetFile;
			/**
			 * 
			 */
			private final IProgressMonitor monitor;
			/**
			 * 
			 */
			private final PipedInputStream pipedInputStream;
			
			private IStatus status = Status.OK_STATUS;
		
			/**
			 * @param targetFile
			 * @param pipedInputStream
			 * @param monitor
			 */
			private WriterThread(IFile targetFile, PipedInputStream pipedInputStream, IProgressMonitor monitor) {
				this.targetFile = targetFile;
				this.monitor = monitor;
				this.pipedInputStream = pipedInputStream;
			}
		
			@Override
			public void run() {
				try {
					if (targetFile.exists()) {
						targetFile.setContents(pipedInputStream, true, false, monitor);
					} else {
						targetFile.create(pipedInputStream, true, monitor);
					}
				} catch (CoreException e) {
					status = e.getStatus();
				}
			}
			
			/**
			 * @return the status
			 */
			public IStatus getStatus() {
				return status;
			}
			
		}
		
	}
	
	private static Iterable<Node> getAllNodes(final Graph graph) {
		return new Iterable<Node>() {
			
			public Iterator<Node> iterator() {
				return graph.getAllNodes();
			}
			
		};
	}

	private static Iterable<Node> getAllNodes(final ExecutionFlow executionFlow) {
		return new Iterable<Node>() {
			
			public Iterator<Node> iterator() {
				return executionFlow.getAllNodes();
			}
			
		};
	}

}
