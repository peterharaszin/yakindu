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

package org.eclipselabs.damos.codegen.c.generator;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.AbstractTreeIterator;
import org.eclipselabs.damos.codegen.c.cgenmodel.GenModel;
import org.eclipselabs.damos.codegen.c.generator.internal.ComponentGeneratorAdaptor;
import org.eclipselabs.damos.codegen.c.generator.internal.ComponentGeneratorContext;
import org.eclipselabs.damos.codegen.c.generator.internal.VariableAccessor;
import org.eclipselabs.damos.codegen.c.generator.internal.util.InternalGeneratorUtil;
import org.eclipselabs.damos.dml.Action;
import org.eclipselabs.damos.dml.ActionLink;
import org.eclipselabs.damos.dml.Choice;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.Inoutport;
import org.eclipselabs.damos.dml.Inport;
import org.eclipselabs.damos.dml.InputConnector;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.dml.Join;
import org.eclipselabs.damos.dml.Memory;
import org.eclipselabs.damos.dml.Outport;
import org.eclipselabs.damos.dml.Output;
import org.eclipselabs.damos.dml.OutputPort;
import org.eclipselabs.damos.dml.WhileLoop;
import org.eclipselabs.damos.dml.util.DMLUtil;
import org.eclipselabs.damos.execution.core.DataTypeResolver;
import org.eclipselabs.damos.execution.core.DataTypeResolverResult;
import org.eclipselabs.damos.execution.core.IComponentSignature;
import org.eclipselabs.damos.execution.core.util.ExpressionUtil;
import org.eclipselabs.damos.execution.executionflow.ActionNode;
import org.eclipselabs.damos.execution.executionflow.ComponentNode;
import org.eclipselabs.damos.execution.executionflow.CompoundNode;
import org.eclipselabs.damos.execution.executionflow.DataFlowSourceEnd;
import org.eclipselabs.damos.execution.executionflow.DataFlowTargetEnd;
import org.eclipselabs.damos.execution.executionflow.ExecutionFlow;
import org.eclipselabs.damos.execution.executionflow.Graph;
import org.eclipselabs.damos.execution.executionflow.Node;
import org.eclipselabs.damos.execution.executionflow.build.ExecutionFlowBuilder;
import org.eclipselabs.mscript.codegen.c.ExpressionGenerator;
import org.eclipselabs.mscript.codegen.c.IVariableAccessStrategy;
import org.eclipselabs.mscript.codegen.c.MscriptGeneratorContext;
import org.eclipselabs.mscript.codegen.c.util.MscriptGeneratorUtil;
import org.eclipselabs.mscript.computation.computationmodel.ComputationModel;
import org.eclipselabs.mscript.computation.computationmodel.util.ComputationModelUtil;
import org.eclipselabs.mscript.language.il.VariableAccess;
import org.eclipselabs.mscript.language.interpreter.StaticEvaluationContext;
import org.eclipselabs.mscript.typesystem.DataType;
import org.eclipselabs.mscript.typesystem.Expression;

/**
 * @author Andreas Unger
 *
 */
public class Generator {

	private final DataTypeResolver dataTypeResolver = new DataTypeResolver();

	public void generate(final GenModel genModel, final IProgressMonitor monitor) throws CoreException {
		final ExecutionFlow executionFlow = constructExecutionFlow(genModel, monitor);
		
		Map<Component, IComponentSignature> signatures = resolveDataTypes(genModel, executionFlow);
		
		for (Node node : getAllNodes(executionFlow.getGraph())) {
			if (node instanceof ComponentNode) {
				ComponentNode componentNode = (ComponentNode) node;
				IComponentGenerator generator = InternalGeneratorUtil.getComponentGenerator(componentNode);
				IVariableAccessor variableAccessor = new VariableAccessor(genModel, componentNode);
				ComponentGeneratorContext context = new ComponentGeneratorContext(componentNode, signatures.get(componentNode.getComponent()), variableAccessor, genModel);
				generator.initialize(context, monitor);
			}
		}
		
		IPath headerPath = new Path(genModel.getHeaderDirectory());
		IFolder headerFolder = ResourcesPlugin.getWorkspace().getRoot().getFolder(headerPath);
		
		IFile headerFile = headerFolder.getFile(genModel.getMainHeaderFile());
		new FileWriter() {
			
			@Override
			protected void write(Writer writer) throws CoreException {
				try {
					generateHeaderFile(genModel, executionFlow, new PrintWriter(writer), monitor);
				} catch (IOException e) {
					throw new CoreException(new Status(IStatus.ERROR, CodegenCGeneratorPlugin.PLUGIN_ID, "I/O error occurred", e));
				}
			}
			
		}.write(headerFile, monitor);

		
		IPath sourcePath = new Path(genModel.getSourceDirectory());
		IFolder sourceFolder = ResourcesPlugin.getWorkspace().getRoot().getFolder(sourcePath);
		IFile sourceFile = sourceFolder.getFile(genModel.getMainSourceFile());		
		new FileWriter() {
			
			@Override
			protected void write(Writer writer) throws CoreException {
				try {
					generateSourceFile(genModel, executionFlow, new PrintWriter(writer), monitor);
				} catch (IOException e) {
					throw new CoreException(new Status(IStatus.ERROR, CodegenCGeneratorPlugin.PLUGIN_ID, "I/O error occurred", e));
				}
			}
			
		}.write(sourceFile, monitor);
	}
	
	private Map<Component, IComponentSignature> resolveDataTypes(GenModel genModel, ExecutionFlow executionFlow) throws CoreException {
		DataTypeResolverResult dataTypeResolverResult = dataTypeResolver.resolve(executionFlow.getTopLevelFragment(), true);
		if (!dataTypeResolverResult.getStatus().isOK()) {
			throw new CoreException(dataTypeResolverResult.getStatus());
		}
		return dataTypeResolverResult.getSignatures();
	}
	
	private ExecutionFlow constructExecutionFlow(GenModel genModel, IProgressMonitor monitor) throws CoreException {
		ExecutionFlow executionFlow = new ExecutionFlowBuilder().build(genModel.getGenTopLevelSystem().getFragment(), monitor);
		new ComponentGeneratorAdaptor().adaptGenerators(genModel, executionFlow, monitor);
		return executionFlow;
	}
	
	private void generateHeaderFile(GenModel genModel, ExecutionFlow executionFlow, PrintWriter writer, IProgressMonitor monitor) throws CoreException, IOException {
		String headerFileName = new Path(genModel.getMainHeaderFile()).lastSegment();
		String headerMacro = headerFileName.replaceAll("\\W", "_").toUpperCase() + "_";
		
		String prefix = genModel.getGenTopLevelSystem().getPrefix();
		if (prefix == null) {
			prefix = "";
		}
		
		writer.printf("#ifndef %s\n", headerMacro);
		writer.printf("#define %s\n", headerMacro);
		writer.println();
		
		writer.println("#include <stdint.h>");

		writer.println();

		writer.println("typedef struct {");
		for (Node node : executionFlow.getGraph().getNodes()) {
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
			writer.printf("%s;\n", MscriptGeneratorUtil.getCVariableDeclaration(getComputationModel(genModel, componentNode), dataType, InternalGeneratorUtil.uncapitalize(componentNode.getComponent().getName()), false));
		}
		writer.printf("} %sInput;\n", prefix);
		
		writer.println();

		writer.println("typedef struct {");
		for (Node node : executionFlow.getGraph().getNodes()) {
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
			writer.printf("%s;\n", MscriptGeneratorUtil.getCVariableDeclaration(getComputationModel(genModel, componentNode), dataType, InternalGeneratorUtil.uncapitalize(componentNode.getComponent().getName()), false));
		}
		writer.printf("} %sOutput;\n", prefix);

		writer.println();
		writer.printf("void %sinitialize(void);\n", prefix);
		writer.printf("void %sexecute(const %sInput *input, %sOutput *output);\n", prefix, prefix, prefix);

		writer.println();
		writer.printf("#endif /* %s */\n", headerMacro);
	}
	
	private void generateSourceFile(GenModel genModel, ExecutionFlow executionFlow, PrintWriter writer, IProgressMonitor monitor) throws CoreException, IOException {
		String prefix = genModel.getGenTopLevelSystem().getPrefix();
		if (prefix == null) {
			prefix = "";
		}

		writer.println("#include <math.h>");
		writer.println("#include <string.h>\n");
		writer.printf("#include \"%s\"\n", genModel.getMainHeaderFile());

		writer.println();
		
		boolean hasContext = hasContext(executionFlow);
		Graph graph = executionFlow.getGraph();
		if (hasContext) {
			for (Node node : getAllNodes(graph)) {
				if (!(node instanceof ComponentNode)) {
					continue;
				}
				ComponentNode componentNode = (ComponentNode) node;
				IComponentGenerator generator = InternalGeneratorUtil.getComponentGenerator(componentNode);
				if (generator.contributesContextStructCode()) {
					String typeName = InternalGeneratorUtil.getPrefix(genModel, node) + componentNode.getComponent().getName() + "_Context";
					generator.writeContextStructCode(writer, typeName, monitor);
				}
			}
			writer.println("typedef struct {");
			for (Node node : getAllNodes(graph)) {
				if (!(node instanceof ComponentNode)) {
					continue;
				}
				ComponentNode componentNode = (ComponentNode) node;
				IComponentGenerator generator = InternalGeneratorUtil.getComponentGenerator(componentNode);
				if (generator.contributesContextStructCode()) {
					writer.printf("%s%s_Context %s;\n", InternalGeneratorUtil.getPrefix(genModel, node), componentNode.getComponent().getName(), InternalGeneratorUtil.getPrefix(genModel, node) + componentNode.getComponent().getName());
				}
			}
			writer.printf("} %sContext;\n\n", prefix);
			writer.printf("static %sContext %scontext;\n\n", prefix, prefix);
		}
		
		writer.printf("void %sinitialize(void) {\n", prefix);
		for (Node node : getAllNodes(graph)) {
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
				for (OutputPort outputPort : output.getPorts()) {
					String cDataType = MscriptGeneratorUtil.getCDataType(getComputationModel(genModel, componentNode), generator.getContext().getComponentSignature().getOutputDataType(outputPort));
					writer.printf("%s %s;\n", cDataType, getOutputVariableName(genModel, componentNode, outputPort));
				}
			}
		}
		writer.println();

		generateGraph(genModel, graph, writer, monitor);
		
		writer.println("}");
	}

	/**
	 * @param genModel
	 * @param graph
	 * @param writer
	 * @param monitor
	 * @throws CoreException
	 * @throws IOException 
	 */
	private void generateGraph(GenModel genModel, Graph graph, PrintWriter writer, IProgressMonitor monitor)
			throws CoreException, IOException {
		boolean hasChoices = false;
		for (Node node : getAllNodes(graph)) {
			if (node instanceof ComponentNode) {
				ComponentNode componentNode = (ComponentNode) node;
				Component component = componentNode.getComponent();
				
				if (component instanceof Choice) {
					writer.printf("uint_fast8_t %s;\n", getChoiceVariableName(genModel, componentNode));
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
				generateCompoundCode(genModel, (CompoundNode) node, writer, monitor);
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
				
				String incomingVariableName = getIncomingVariableName(genModel, componentNode, choice.getFirstInputPort());
				String choiceResult = getChoiceVariableName(genModel, componentNode);
				
				int i = 0;
				for (ActionLink actionLink : choice.getActionLinks()) {
					if (actionLink.getCondition() != null) {
						String condition = actionLink.getCondition().stringCondition();
						if (i > 0) {
							writer.print("} else ");
						}
						writer.printf("if (%s == (", incomingVariableName);
						
						Expression conditionExpression = ExpressionUtil.parseExpression(condition);
						
						ComputationModel computationModel = getComputationModel(genModel, componentNode);
						new ExpressionGenerator().generate(new MscriptGeneratorContext(new StaticEvaluationContext(), computationModel, writer), new IVariableAccessStrategy() {

							public String getVariableAccessString(VariableAccess variableAccess) {
								return "";
							}
							
						}, conditionExpression);

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
							variableNameMap.put(DMLUtil.indexOf(action.getLink()), getIncomingVariableName(genModel, componentNode, inputPort));
							choiceNode = actionNode.getChoiceNode();
						}
					}
				}
				writer.printf("switch (%s) {\n", getChoiceVariableName(genModel, choiceNode));
				for (Entry<Integer, String> entry : variableNameMap.entrySet()) {
					writer.printf("case %d:\n", entry.getKey());
					writer.printf("%s = %s;\n", getOutputVariableName(genModel, componentNode, component.getFirstOutputPort()), entry.getValue());
					writer.println("break;");
				}
				writer.println("}\n");
			} else if (component instanceof Memory) {
				writer.printf("/* %s */\n", componentNode.getComponent().getName());
				writer.println("{");
				writer.printf("%s = %s;\n", getOutputVariableName(genModel, componentNode, component.getFirstOutputPort()), getMemoryPreviousValueVariableName(genModel, componentNode));
				writer.println("}\n");
			} else {
				IComponentGenerator generator = InternalGeneratorUtil.getComponentGenerator(componentNode);
				if (generator.contributesComputeOutputsCode()) {
					writer.printf("/* %s */\n", componentNode.getComponent().getName());
					writer.println("{");
					generator.writeComputeOutputsCode(writer, monitor);
					writer.println("}\n");
				}
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
				writer.printf("%s = %s;\n", getMemoryPreviousValueVariableName(genModel, componentNode), getIncomingVariableName(genModel, componentNode, component.getInputPorts().get(1)));
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

	private String getChoiceVariableName(GenModel genModel, ComponentNode componentNode) {
		return String.format("%s%s_result", InternalGeneratorUtil.getPrefix(genModel, componentNode), componentNode.getComponent().getName());
	}
	
	/**
	 * @param genModel
	 * @param compoundNode
	 * @param writer
	 * @param monitor
	 * @throws CoreException 
	 * @throws IOException 
	 */
	private void generateCompoundCode(GenModel genModel, CompoundNode compoundNode, PrintWriter writer, IProgressMonitor monitor) throws CoreException, IOException {
		if (compoundNode instanceof ActionNode) {
			ActionNode actionNode = (ActionNode) compoundNode;
			Action action = (Action) actionNode.getCompound();
			
			if (actionNode.getChoiceNode() != null) {
				Choice choice = (Choice) actionNode.getChoiceNode().getComponent();
				int index = getActionIndex(choice, action);
				writer.printf("if (%s%s_result == %d) ", InternalGeneratorUtil.getPrefix(genModel, compoundNode), choice.getName(), index);
			}
			
			writer.print("{\n");
			
			for (Node node : compoundNode.getNodes()) {
				if (node instanceof ComponentNode) {
					ComponentNode componentNode = (ComponentNode) node;
					if (componentNode.getComponent() instanceof Memory) {
						Memory memory = (Memory) componentNode.getComponent();
						IComponentGenerator generator = InternalGeneratorUtil.getComponentGenerator(componentNode);
						String cDataType = MscriptGeneratorUtil.getCDataType(getComputationModel(genModel, componentNode), generator.getContext().getComponentSignature().getOutputDataType(memory.getFirstOutputPort()));
						
						String initializer = getIncomingVariableName(genModel, componentNode, memory.getFirstInputPort());
						
						writer.printf("%s %s = %s;\n", cDataType, getMemoryPreviousValueVariableName(genModel, componentNode), initializer);
					}
				}
			}

			if (action instanceof WhileLoop) {
				writer.print("do {\n");
			}
			
			generateGraph(genModel, compoundNode, writer, monitor);
			
			if (action instanceof WhileLoop) {
				WhileLoop whileLoop = (WhileLoop) action;

				InputConnector inputConnector = whileLoop.getCondition();
				String condition = getIncomingVariableName(genModel, actionNode, inputConnector);
				if (condition == null) {
					condition = "0";
				}
				
				writer.printf("} while (%s);\n", condition);
			}

			writer.print("}\n");
		}
	}
	
	private String getMemoryPreviousValueVariableName(GenModel genModel, ComponentNode componentNode) {
		return String.format("%s%s_previousValue", InternalGeneratorUtil.getPrefix(genModel, componentNode), componentNode.getComponent().getName());
	}

	/**
	 * @param genModel
	 * @param node
	 * @param inputConnector
	 * @return
	 */
	private String getIncomingVariableName(GenModel genModel, Node node, InputConnector inputConnector) {
		DataFlowTargetEnd targetEnd = node.getIncomingDataFlow(inputConnector);
		if (targetEnd != null) {
			DataFlowSourceEnd sourceEnd = targetEnd.getDataFlow().getSourceEnd();
			Node sourceNode = sourceEnd.getNode();
			if (sourceNode instanceof ComponentNode && sourceEnd.getConnector() instanceof OutputPort) {
				OutputPort outputPort = (OutputPort) sourceEnd.getConnector();
				ComponentNode componentNode = (ComponentNode) sourceNode;
				return new VariableAccessor(genModel, componentNode).getOutputVariable(outputPort, false);
			}
		}
		return null;
	}
	
	private String getOutputVariableName(GenModel genModel, ComponentNode componentNode, OutputPort outputPort) {
		return String.format("%s%s_%s", InternalGeneratorUtil.getPrefix(genModel, componentNode), componentNode.getComponent().getName(), InternalGeneratorUtil.getOutputPortName(outputPort));
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
		for (Node node : getAllNodes(executionFlow.getGraph())) {
			if (node instanceof ComponentNode) {
				ComponentNode componentNode = (ComponentNode) node;
				IComponentGenerator generator = InternalGeneratorUtil.getComponentGenerator(componentNode);
				if (generator.contributesContextStructCode()) {
					return true;
				}
			}
		}
		return false;
	}
	
	private ComputationModel getComputationModel(GenModel genModel, ComponentNode node) {
		ComputationModel computationModel = genModel.getExecutionModel().getComputationModel(node.getComponent().getOwningFragment());
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
				throw new CoreException(new Status(IStatus.ERROR, CodegenCGeneratorPlugin.PLUGIN_ID, "Writing file '" + targetFile.getName() + "' failed", e));
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
						status = new Status(IStatus.ERROR, CodegenCGeneratorPlugin.PLUGIN_ID, "Closing file '" + targetFile.getName() + "' failed", e);
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
				return new GraphIterator(graph);
			}
			
		};
	}
	
	private static class GraphIterator extends AbstractTreeIterator<Node> {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public GraphIterator(Graph graph) {
			super(graph, false);
		}

		/* (non-Javadoc)
		 * @see org.eclipse.emf.common.util.AbstractTreeIterator#getChildren(java.lang.Object)
		 */
		@Override
		protected Iterator<? extends Node> getChildren(Object object) {
			if (object instanceof Graph) {
				Graph graph = (Graph) object;
				return graph.getNodes().iterator();
			}
			return Collections.<Node>emptyList().iterator();
		}
		
	}
	
}
