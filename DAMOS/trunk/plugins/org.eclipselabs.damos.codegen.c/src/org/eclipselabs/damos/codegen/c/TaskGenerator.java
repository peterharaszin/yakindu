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

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipselabs.damos.codegen.c.codefragments.TaskContext;
import org.eclipselabs.damos.codegen.c.internal.VariableAccessor;
import org.eclipselabs.damos.codegen.c.internal.rte.MessageQueueInfo;
import org.eclipselabs.damos.codegen.c.internal.util.TaskGeneratorUtil;
import org.eclipselabs.damos.codegen.c.rte.IRuntimeEnvironmentAPI;
import org.eclipselabs.damos.codegen.c.util.GeneratorConfigurationExtensions;
import org.eclipselabs.damos.common.util.PrintAppendable;
import org.eclipselabs.damos.dml.Input;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.dml.Latch;
import org.eclipselabs.damos.dml.OutputPort;
import org.eclipselabs.damos.execution.ComponentNode;
import org.eclipselabs.damos.execution.DataFlowEnd;
import org.eclipselabs.damos.execution.DataFlowTargetEnd;
import org.eclipselabs.damos.execution.TaskGraph;
import org.eclipselabs.damos.execution.TaskInputNode;
import org.eclipselabs.damos.mscript.codegen.c.codefragments.ContextStruct;

/**
 * @author Andreas Unger
 *
 */
public class TaskGenerator implements ITaskGenerator {
	
	public void addTaskContexts(IGeneratorContext context, ContextStruct contextStruct, IProgressMonitor monitor) {
		IRuntimeEnvironmentAPI runtimeEnvironmentAPI = GeneratorConfigurationExtensions.getRuntimeEnvironmentAPI(context.getConfiguration());
		if (runtimeEnvironmentAPI != null) {
			for (TaskGraph taskGraph : context.getExecutionFlow().getTaskGraphs()) {
				String taskName = TaskGeneratorUtil.getTaskName(context.getConfiguration(), taskGraph);
				EList<TaskInputNode> inputNodes = taskGraph.getInputNodes();
				StringBuilder sb = new StringBuilder();
				sb.append("struct {\n");
				if (!inputNodes.isEmpty()) {
					if (TaskGeneratorUtil.getInputSockets(taskGraph).isEmpty()) {
						TaskInputNode inputNode = inputNodes.get(0);
						MessageQueueInfo messageQueueInfo = TaskGeneratorUtil.createMessageQueueInfoFor(context, inputNode);
						sb.append(runtimeEnvironmentAPI.getMessageQueueGenerator().generateContextCode(context, "queue", messageQueueInfo));
					} else {
						MessageQueueInfo messageQueueInfo = TaskGeneratorUtil.createMessageQueueInfoFor(context, taskGraph);
						sb.append(runtimeEnvironmentAPI.getMessageQueueGenerator().generateContextCode(context, "queue", messageQueueInfo));
					}
				}
				sb.append("} ").append(taskName).append(";\n");
				contextStruct.addMember(new TaskContext(sb));
			}
		}
	}

	public CharSequence generateInitializeTasks(IGeneratorContext context, IProgressMonitor monitor) {
		StringBuilder sb = new StringBuilder();
		IRuntimeEnvironmentAPI runtimeEnvironmentAPI = GeneratorConfigurationExtensions.getRuntimeEnvironmentAPI(context.getConfiguration());
		if (runtimeEnvironmentAPI != null) {
			for (TaskGraph taskGraph : context.getExecutionFlow().getTaskGraphs()) {
				String taskName = TaskGeneratorUtil.getTaskName(context.getConfiguration(), taskGraph);
				EList<TaskInputNode> inputNodes = taskGraph.getInputNodes();
				if (!inputNodes.isEmpty()) {
					sb.append(" {\n");
					String qualifier = TaskGeneratorUtil.getTaskContextVariable(context, taskName, false) + "." + "queue";
					if (TaskGeneratorUtil.getInputSockets(taskGraph).isEmpty()) {
						TaskInputNode inputNode = inputNodes.get(0);
						MessageQueueInfo messageQueueInfo = TaskGeneratorUtil.createMessageQueueInfoFor(context, inputNode);
						sb.append(runtimeEnvironmentAPI.getMessageQueueGenerator().generateInitializationCode(context, qualifier, messageQueueInfo));
					} else {
						MessageQueueInfo messageQueueInfo = TaskGeneratorUtil.createMessageQueueInfoFor(context, taskGraph);
						sb.append(runtimeEnvironmentAPI.getMessageQueueGenerator().generateInitializationCode(context, qualifier, messageQueueInfo));
					}
					sb.append("}\n");
				}
			}
		}
		return sb;
	}

	public boolean contributesLatchUpdate(IGeneratorContext context, ComponentNode componentNode) {
		for (DataFlowEnd end : componentNode.getDrivenEnds()) {
			if (end.getNode() instanceof ComponentNode) {
				ComponentNode otherComponentNode = (ComponentNode) end.getNode();
				if (otherComponentNode.getComponent() instanceof Latch) {
					return true;
				}
			}
		}
		return false;
	}

	public CharSequence generateLatchUpdate(IGeneratorContext context, ComponentNode componentNode, IProgressMonitor monitor) {
		StringBuilder sb = new StringBuilder();
		PrintAppendable out = new PrintAppendable(sb);
		for (DataFlowEnd end : componentNode.getDrivenEnds()) {
			if (end.getNode() instanceof ComponentNode) {
				ComponentNode otherComponentNode = (ComponentNode) end.getNode();
				if (otherComponentNode.getComponent() instanceof Latch) {
					String contextVariable = new VariableAccessor(context.getConfiguration(), otherComponentNode).generateContextVariableReference(false);
					String variableName = contextVariable + "." + "lock";
					String outputVariable = new VariableAccessor(context.getConfiguration(), componentNode).generateOutputVariableReference((OutputPort) end.getDataFlow().getSourceEnd().getConnector(), false);

					out.print(GeneratorConfigurationExtensions.getRuntimeEnvironmentAPI(context.getConfiguration()).getFastLockGenerator().generateLockCode(variableName));
					out.printf("%s.data = %s;\n", contextVariable, outputVariable);
					out.print(GeneratorConfigurationExtensions.getRuntimeEnvironmentAPI(context.getConfiguration()).getFastLockGenerator().generateUnlockCode(variableName));
				}
			}
		}
		return sb;
	}

	public boolean contributesMessageQueueSend(IGeneratorContext context, ComponentNode componentNode) {
		for (DataFlowEnd end : componentNode.getDrivenEnds()) {
			if (end.getNode() instanceof TaskInputNode) {
				return true;
			}
		}
		return false;
	}

	public CharSequence generateMessageQueueSend(IGeneratorContext context, ComponentNode componentNode, IProgressMonitor monitor) {
		StringBuilder sb = new StringBuilder();
		PrintAppendable out = new PrintAppendable(sb);
		for (DataFlowEnd end : componentNode.getDrivenEnds()) {
			if (end.getNode() instanceof TaskInputNode) {
				TaskInputNode inputNode = (TaskInputNode) end.getNode();
				
				String taskName = TaskGeneratorUtil.getTaskName(context.getConfiguration(), inputNode.getTaskGraph());
				String qualifier = TaskGeneratorUtil.getTaskContextVariable(context, taskName, false) + "." + "queue";
				String outputVariable = new VariableAccessor(context.getConfiguration(), componentNode).generateOutputVariableReference((OutputPort) end.getDataFlow().getSourceEnd().getConnector(), false);

				DataFlowTargetEnd firstEnd = inputNode.getDrivenEnds().get(0);
				if (firstEnd.getConnector() instanceof InputPort) {
					InputPort inputPort = (InputPort) firstEnd.getConnector();
					Input input = inputPort.getInput();
					if (input.isSocket()) {
						out.print("{\n");
						out.print(TaskGeneratorUtil.createMessageUnionTypeDeclaration(context, inputNode.getTaskGraph()).getName() + " message;\n");
						out.printf("message.tag = %d;\n", input.getComponent().getInputSockets().indexOf(input));
						out.printf("message.value.%s = %s;\n", input.getName(), outputVariable);
						MessageQueueInfo messageQueueInfo = TaskGeneratorUtil.createMessageQueueInfoFor(context, inputNode.getTaskGraph());
						out.print(GeneratorConfigurationExtensions.getRuntimeEnvironmentAPI(context.getConfiguration()).getMessageQueueGenerator().generateSendCode(context, qualifier, "&message", messageQueueInfo));
						out.print("}\n");
						continue;
					}
				}
				
				MessageQueueInfo messageQueueInfo = TaskGeneratorUtil.createMessageQueueInfoFor(context, inputNode);
				out.print(GeneratorConfigurationExtensions.getRuntimeEnvironmentAPI(context.getConfiguration()).getMessageQueueGenerator().generateSendCode(context, qualifier, "&" + outputVariable, messageQueueInfo));
			}
		}
		return sb;
	}

}
