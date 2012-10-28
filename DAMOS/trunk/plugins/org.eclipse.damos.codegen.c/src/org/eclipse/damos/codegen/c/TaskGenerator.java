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

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.damos.codegen.c.codefragments.TaskContext;
import org.eclipse.damos.codegen.c.internal.IVariableAccessorFactory;
import org.eclipse.damos.codegen.c.internal.rte.MessageQueueInfo;
import org.eclipse.damos.codegen.c.internal.util.TaskGeneratorHelper;
import org.eclipse.damos.codegen.c.rte.IRuntimeEnvironmentAPI;
import org.eclipse.damos.codegen.c.util.GeneratorConfigurationExtensions;
import org.eclipse.damos.common.util.PrintAppendable;
import org.eclipse.damos.dml.Input;
import org.eclipse.damos.dml.InputPort;
import org.eclipse.damos.dml.Latch;
import org.eclipse.damos.dml.OutputPort;
import org.eclipse.damos.execution.ComponentNode;
import org.eclipse.damos.execution.DataFlowEnd;
import org.eclipse.damos.execution.DataFlowTargetEnd;
import org.eclipse.damos.execution.TaskGraph;
import org.eclipse.damos.execution.TaskInputNode;
import org.eclipse.damos.mscript.codegen.c.codefragments.ContextStruct;
import org.eclipse.emf.common.util.EList;

import com.google.inject.Inject;

/**
 * @author Andreas Unger
 *
 */
public class TaskGenerator implements ITaskGenerator {
	
	@Inject
	private TaskGeneratorHelper taskGeneratorHelper;
	
	@Inject
	private IVariableAccessorFactory variableAccessorFactory;

	public void addTaskContexts(IGeneratorContext context, ContextStruct contextStruct, IProgressMonitor monitor) {
		IRuntimeEnvironmentAPI runtimeEnvironmentAPI = GeneratorConfigurationExtensions.getRuntimeEnvironmentAPI(context.getConfiguration());
		if (runtimeEnvironmentAPI != null) {
			for (TaskGraph taskGraph : context.getExecutionFlow().getTaskGraphs()) {
				String taskName = taskGeneratorHelper.getTaskName(context.getConfiguration(), taskGraph);
				EList<TaskInputNode> inputNodes = taskGraph.getInputNodes();
				StringBuilder sb = new StringBuilder();
				sb.append("struct {\n");
				if (!inputNodes.isEmpty()) {
					if (taskGeneratorHelper.getInputSockets(taskGraph).isEmpty()) {
						TaskInputNode inputNode = inputNodes.get(0);
						MessageQueueInfo messageQueueInfo = taskGeneratorHelper.createMessageQueueInfoFor(context, inputNode);
						sb.append(runtimeEnvironmentAPI.getMessageQueueGenerator().generateContextCode(context, "queue", messageQueueInfo));
					} else {
						MessageQueueInfo messageQueueInfo = taskGeneratorHelper.createMessageQueueInfoFor(context, taskGraph);
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
				String taskName = taskGeneratorHelper.getTaskName(context.getConfiguration(), taskGraph);
				EList<TaskInputNode> inputNodes = taskGraph.getInputNodes();
				if (!inputNodes.isEmpty()) {
					sb.append(" {\n");
					String qualifier = taskGeneratorHelper.getTaskContextVariable(context, taskName, false) + "." + "queue";
					if (taskGeneratorHelper.getInputSockets(taskGraph).isEmpty()) {
						TaskInputNode inputNode = inputNodes.get(0);
						MessageQueueInfo messageQueueInfo = taskGeneratorHelper.createMessageQueueInfoFor(context, inputNode);
						sb.append(runtimeEnvironmentAPI.getMessageQueueGenerator().generateInitializationCode(context, qualifier, messageQueueInfo));
					} else {
						MessageQueueInfo messageQueueInfo = taskGeneratorHelper.createMessageQueueInfoFor(context, taskGraph);
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
					String contextVariable = variableAccessorFactory.create(context.getConfiguration(), otherComponentNode).generateContextVariableReference(false);
					String variableName = contextVariable + "." + "lock";
					String outputVariable = variableAccessorFactory.create(context.getConfiguration(), componentNode).generateOutputVariableReference((OutputPort) end.getDataFlow().getSourceEnd().getConnector(), false);

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
				
				String taskName = taskGeneratorHelper.getTaskName(context.getConfiguration(), inputNode.getTaskGraph());
				String qualifier = taskGeneratorHelper.getTaskContextVariable(context, taskName, false) + "." + "queue";
				String outputVariable = variableAccessorFactory.create(context.getConfiguration(), componentNode).generateOutputVariableReference((OutputPort) end.getDataFlow().getSourceEnd().getConnector(), false);

				DataFlowTargetEnd firstEnd = inputNode.getDrivenEnds().get(0);
				if (firstEnd.getConnector() instanceof InputPort) {
					InputPort inputPort = (InputPort) firstEnd.getConnector();
					Input input = inputPort.getInput();
					if (input.isSocket()) {
						out.print("{\n");
						out.print(taskGeneratorHelper.createMessageUnionTypeDeclaration(context, inputNode.getTaskGraph()).getName() + " message;\n");
						out.printf("message.tag = %d;\n", input.getComponent().getInputSockets().indexOf(input));
						out.printf("message.value.%s = %s;\n", input.getName(), outputVariable);
						MessageQueueInfo messageQueueInfo = taskGeneratorHelper.createMessageQueueInfoFor(context, inputNode.getTaskGraph());
						out.print(GeneratorConfigurationExtensions.getRuntimeEnvironmentAPI(context.getConfiguration()).getMessageQueueGenerator().generateSendCode(context, qualifier, "&message", messageQueueInfo));
						out.print("}\n");
						continue;
					}
				}
				
				MessageQueueInfo messageQueueInfo = taskGeneratorHelper.createMessageQueueInfoFor(context, inputNode);
				out.print(GeneratorConfigurationExtensions.getRuntimeEnvironmentAPI(context.getConfiguration()).getMessageQueueGenerator().generateSendCode(context, qualifier, "&" + outputVariable, messageQueueInfo));
			}
		}
		return sb;
	}

}
