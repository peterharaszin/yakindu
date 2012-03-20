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

package org.eclipselabs.damos.codegen.c;

import java.io.IOException;
import java.util.Formatter;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipselabs.damos.codegen.c.internal.VariableAccessor;
import org.eclipselabs.damos.codegen.c.internal.rte.MessageQueueInfo;
import org.eclipselabs.damos.codegen.c.internal.util.InternalGeneratorUtil;
import org.eclipselabs.damos.codegen.c.rte.IRuntimeEnvironmentAPI;
import org.eclipselabs.damos.codegen.c.util.GeneratorConfigurationUtil;
import org.eclipselabs.damos.common.util.PrintAppendable;
import org.eclipselabs.damos.dml.Input;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.dml.Latch;
import org.eclipselabs.damos.dml.OutputPort;
import org.eclipselabs.damos.execution.datatype.IComponentSignature;
import org.eclipselabs.damos.execution.ComponentNode;
import org.eclipselabs.damos.execution.DataFlowEnd;
import org.eclipselabs.damos.execution.DataFlowTargetEnd;
import org.eclipselabs.damos.execution.Node;
import org.eclipselabs.damos.execution.TaskGraph;
import org.eclipselabs.damos.execution.TaskInputNode;
import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.codegen.c.util.MscriptGeneratorUtil;

import com.google.inject.Inject;

/**
 * @author Andreas Unger
 *
 */
public class DefaultTaskGenerator implements ITaskGenerator {
	
	private final IGraphGenerator graphGenerator;
	
	/**
	 * 
	 */
	@Inject
	DefaultTaskGenerator(IGraphGenerator graphGenerator) {
		this.graphGenerator = graphGenerator;
	}

	public void writeTaskInfoInclude(IGeneratorContext context, Appendable appendable, IProgressMonitor monitor) throws IOException {
		if (context.getExecutionFlow().getAsynchronousZoneCount() > 0) {
			IRuntimeEnvironmentAPI runtimeEnvironmentAPI = GeneratorConfigurationUtil.getRuntimeEnvironmentAPI(context.getConfiguration());
			if (runtimeEnvironmentAPI != null) {
				runtimeEnvironmentAPI.writeTaskInfoInclude(appendable);
			}
		}
	}
	
	public void writeMultitaskingIncludes(IGeneratorContext context, Appendable appendable, IProgressMonitor monitor) throws IOException {
		if (context.getExecutionFlow().getAsynchronousZoneCount() > 0) {
			IRuntimeEnvironmentAPI runtimeEnvironmentAPI = GeneratorConfigurationUtil.getRuntimeEnvironmentAPI(context.getConfiguration());
			if (runtimeEnvironmentAPI != null) {
				runtimeEnvironmentAPI.writeMultitaskingIncludes(appendable);
			}
		}
	}

	public void writeExternVariables(IGeneratorContext context, Appendable appendable, IProgressMonitor monitor) {
		if (!context.getExecutionFlow().getTaskGraphs().isEmpty()) {
			PrintAppendable out = new PrintAppendable(appendable);
			String prefix = GeneratorConfigurationUtil.getPrefix(context.getConfiguration());
			out.printf("#define %sTASK_COUNT %d\n", prefix.toUpperCase(), context.getExecutionFlow().getTaskGraphs().size());
			out.printf("extern const %s %staskInfos[];\n\n", GeneratorConfigurationUtil.getRuntimeEnvironmentAPI(context.getConfiguration()).getTaskInfoStructName(), prefix);
		}
	}

	public void writeTaskStructs(IGeneratorContext context, Appendable appendable, IProgressMonitor monitor) throws IOException {
		if (!context.getExecutionFlow().getTaskGraphs().isEmpty()) {
			PrintAppendable writer = new PrintAppendable(appendable);
			
			String prefix = GeneratorConfigurationUtil.getPrefix(context.getConfiguration());

			for (TaskGraph taskGraph : context.getExecutionFlow().getTaskGraphs()) {
				writer.append("static ");
				GeneratorConfigurationUtil.getRuntimeEnvironmentAPI(context.getConfiguration()).writeTaskSignature(writer, InternalGeneratorUtil.getTaskName(context.getConfiguration(), taskGraph));
				writer.append(";\n");
			}

			writer.println();
			writer.printf("const %s %staskInfos[] = {\n", GeneratorConfigurationUtil.getRuntimeEnvironmentAPI(context.getConfiguration()).getTaskInfoStructName(), prefix);
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
			
			writeTaskMessageStructs(context, appendable);
		}
	}
	
	private void writeTaskMessageStructs(IGeneratorContext context, Appendable appendable) throws IOException {
		PrintAppendable out = new PrintAppendable(appendable);
		for (TaskGraph taskGraph : context.getExecutionFlow().getTaskGraphs()) {
			EList<Input> inputSockets = getInputSockets(taskGraph);
			if (!inputSockets.isEmpty()) {
				out.append("typedef struct {\n");
				out.append("int kind;\n");
				out.append("union {\n");
				for (Input input : inputSockets) {
					if (!input.getPorts().isEmpty()) {
						ComponentNode componentNode = (ComponentNode) taskGraph.getInitialNodes().get(0);
						IComponentGenerator generator = InternalGeneratorUtil.getComponentGenerator(componentNode);
						IComponentSignature signature = generator.getContext().getComponentSignature();
						out.append(MscriptGeneratorUtil.getCDataType(GeneratorConfigurationUtil.getComputationModel(context.getConfiguration(), componentNode), signature.getInputDataType(input.getPorts().get(0))));
						out.append(" ");
						out.append(input.getName());
						out.append(";\n");
					}
				}
				out.append("} data;\n");
				out.printf("} %s_Message;\n\n", InternalGeneratorUtil.getTaskName(context.getConfiguration(), taskGraph));
			}
		}
	}

	public void writeTaskContexts(IGeneratorContext context, Appendable appendable, IProgressMonitor monitor) throws IOException {
		IRuntimeEnvironmentAPI runtimeEnvironmentAPI = GeneratorConfigurationUtil.getRuntimeEnvironmentAPI(context.getConfiguration());
		if (runtimeEnvironmentAPI != null) {
			for (TaskGraph taskGraph : context.getExecutionFlow().getTaskGraphs()) {
				String taskName = InternalGeneratorUtil.getTaskName(context.getConfiguration(), taskGraph);
				EList<TaskInputNode> inputNodes = taskGraph.getInputNodes();
				appendable.append("struct {\n");
				if (!inputNodes.isEmpty()) {
					if (getInputSockets(taskGraph).isEmpty()) {
						TaskInputNode inputNode = inputNodes.get(0);
						MessageQueueInfo messageQueueInfo = createMessageQueueInfoFor(context, inputNode);
						runtimeEnvironmentAPI.getMessageQueueGenerator().writeContextCode(appendable, "queue", messageQueueInfo);
					} else {
						MessageQueueInfo messageQueueInfo = createMessageQueueInfoFor(context, taskGraph);
						runtimeEnvironmentAPI.getMessageQueueGenerator().writeContextCode(appendable, "queue", messageQueueInfo);
					}
				}
				appendable.append("} ").append(taskName).append(";\n");
			}
		}
	}

	public void writeTasks(IGeneratorContext context, Appendable appendable,
			IProgressMonitor monitor) throws IOException {
		IRuntimeEnvironmentAPI runtimeEnvironmentAPI = GeneratorConfigurationUtil.getRuntimeEnvironmentAPI(context.getConfiguration());
		if (runtimeEnvironmentAPI != null) {
			PrintAppendable out = new PrintAppendable(appendable);
			for (TaskGraph taskGraph : context.getExecutionFlow().getTaskGraphs()) {
				String taskName = InternalGeneratorUtil.getTaskName(context.getConfiguration(), taskGraph);
				out.append("static ");
				runtimeEnvironmentAPI.writeTaskSignature(out, taskName);
				out.append(" {\n");
				graphGenerator.writeOutputVariableDeclarations(context, appendable, taskGraph, monitor);
				
				if (getInputSockets(taskGraph).isEmpty()) {
					TaskInputNode inputNode = taskGraph.getInputNodes().get(0);
					String taskInputVariableName = InternalGeneratorUtil.getTaskInputVariableName(context.getConfiguration(), inputNode);
					out.append(getCDataTypeFor(context, inputNode)).append(" ").append(taskInputVariableName).append(";\n");
				} else {
					out.append(InternalGeneratorUtil.getTaskName(context.getConfiguration(), taskGraph));
					out.append("_Message ");
					out.append(InternalGeneratorUtil.getTaskName(context.getConfiguration(), taskGraph));
					out.append("_message;\n");
				}
				
				out.append("for (;;) {\n");
				
				EList<TaskInputNode> inputNodes = taskGraph.getInputNodes();
				if (!inputNodes.isEmpty()) {
					String qualifier = getTaskContextVariable(context, taskName, false) + "." + "queue";
					if (getInputSockets(taskGraph).isEmpty()) {
						TaskInputNode inputNode = inputNodes.get(0);
						String taskInputVariableName = InternalGeneratorUtil.getTaskInputVariableName(context.getConfiguration(), inputNode);
						MessageQueueInfo messageQueueInfo = createMessageQueueInfoFor(context, inputNode);
						runtimeEnvironmentAPI.getMessageQueueGenerator().writeReceiveCode(out, qualifier, "&" + taskInputVariableName, messageQueueInfo);
					} else {
						String taskInputVariableName = InternalGeneratorUtil.getTaskName(context.getConfiguration(), taskGraph) + "_message";
						MessageQueueInfo messageQueueInfo = createMessageQueueInfoFor(context, taskGraph);
						runtimeEnvironmentAPI.getMessageQueueGenerator().writeReceiveCode(out, qualifier, "&" + taskInputVariableName, messageQueueInfo);
					}
				}

				graphGenerator.writeGraph(context, appendable, taskGraph, monitor);
								
				out.append("}\n");
				runtimeEnvironmentAPI.writeTaskReturnStatement(out, taskName);
				out.append("}\n");
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

	private MessageQueueInfo createMessageQueueInfoFor(IGeneratorContext context, TaskInputNode inputNode) {
		return new MessageQueueInfo("10", "sizeof(" + getCDataTypeFor(context, inputNode) + ")");
	}
	
	private MessageQueueInfo createMessageQueueInfoFor(IGeneratorContext context, TaskGraph taskGraph) {
		return new MessageQueueInfo("10", "sizeof(" + InternalGeneratorUtil.getTaskName(context.getConfiguration(), taskGraph) + "_Message)");
	}

	public void writeInitializeTasks(IGeneratorContext context, Appendable appendable, IProgressMonitor monitor) throws IOException {
		IRuntimeEnvironmentAPI runtimeEnvironmentAPI = GeneratorConfigurationUtil.getRuntimeEnvironmentAPI(context.getConfiguration());
		if (runtimeEnvironmentAPI != null) {
			PrintAppendable out = new PrintAppendable(appendable);
			for (TaskGraph taskGraph : context.getExecutionFlow().getTaskGraphs()) {
				String taskName = InternalGeneratorUtil.getTaskName(context.getConfiguration(), taskGraph);
				EList<TaskInputNode> inputNodes = taskGraph.getInputNodes();
				if (!inputNodes.isEmpty()) {
					out.append(" {\n");
					String qualifier = getTaskContextVariable(context, taskName, false) + "." + "queue";
					if (getInputSockets(taskGraph).isEmpty()) {
						TaskInputNode inputNode = inputNodes.get(0);
						MessageQueueInfo messageQueueInfo = createMessageQueueInfoFor(context, inputNode);
						runtimeEnvironmentAPI.getMessageQueueGenerator().writeInitializationCode(out, qualifier, messageQueueInfo);
					} else {
						MessageQueueInfo messageQueueInfo = createMessageQueueInfoFor(context, taskGraph);
						runtimeEnvironmentAPI.getMessageQueueGenerator().writeInitializationCode(out, qualifier, messageQueueInfo);
					}
					out.append("}\n");
				}
			}
		}
	}

	public void writeLatchUpdate(IGeneratorContext context, Appendable appendable, ComponentNode componentNode, IProgressMonitor monitor) throws IOException {
		PrintAppendable out = new PrintAppendable(appendable);
		for (DataFlowEnd end : componentNode.getDrivenEnds()) {
			if (end.getNode() instanceof ComponentNode) {
				ComponentNode otherComponentNode = (ComponentNode) end.getNode();
				if (otherComponentNode.getComponent() instanceof Latch) {
					String contextVariable = new VariableAccessor(context.getConfiguration(), otherComponentNode).getContextVariable(false);
					String variableName = contextVariable + "." + "lock";
					String outputVariable = new VariableAccessor(context.getConfiguration(), componentNode).getOutputVariable((OutputPort) end.getDataFlow().getSourceEnd().getConnector(), false);

					GeneratorConfigurationUtil.getRuntimeEnvironmentAPI(context.getConfiguration()).getFastLockGenerator().writeLockCode(out, variableName);
					new Formatter(out).format("%s.data = %s;\n", contextVariable, outputVariable);
					GeneratorConfigurationUtil.getRuntimeEnvironmentAPI(context.getConfiguration()).getFastLockGenerator().writeUnlockCode(out, variableName);
				}
			}
		}
	}

	public void writeMessageQueueSend(IGeneratorContext context, Appendable appendable, ComponentNode componentNode, IProgressMonitor monitor) throws IOException {
		PrintAppendable out = new PrintAppendable(appendable);
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
						out.append("{\n");
						out.append(InternalGeneratorUtil.getTaskName(context.getConfiguration(), inputNode.getTaskGraph()) + "_Message message;\n");
						out.printf("message.kind = %d;\n", input.getComponent().getInputSockets().indexOf(input));
						out.printf("message.data.%s = %s;\n", input.getName(), outputVariable);
						MessageQueueInfo messageQueueInfo = createMessageQueueInfoFor(context, inputNode.getTaskGraph());
						GeneratorConfigurationUtil.getRuntimeEnvironmentAPI(context.getConfiguration()).getMessageQueueGenerator().writeSendCode(out, qualifier, "&message", messageQueueInfo);
						out.append("}\n");
						continue;
					}
				}
				
				MessageQueueInfo messageQueueInfo = createMessageQueueInfoFor(context, inputNode);
				GeneratorConfigurationUtil.getRuntimeEnvironmentAPI(context.getConfiguration()).getMessageQueueGenerator().writeSendCode(out, qualifier, "&" + outputVariable, messageQueueInfo);
			}
		}
	}

	private String getCDataTypeFor(IGeneratorContext context, TaskInputNode inputNode) {
		DataFlowEnd end = inputNode.getDrivingEnds().get(0);
		IComponentGenerator componentGenerator = InternalGeneratorUtil.getComponentGenerator((ComponentNode) end.getNode());
		DataType dataType = componentGenerator.getContext().getComponentSignature().getOutputDataType((OutputPort) end.getConnector());
		return MscriptGeneratorUtil.getCDataType(GeneratorConfigurationUtil.getComputationModel(context.getConfiguration(), (ComponentNode) end.getNode()), dataType);
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
	
}
