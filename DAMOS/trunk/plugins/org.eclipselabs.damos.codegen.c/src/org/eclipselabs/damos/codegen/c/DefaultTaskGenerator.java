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
import org.eclipse.emf.common.util.EList;
import org.eclipselabs.damos.codegen.c.internal.VariableAccessor;
import org.eclipselabs.damos.codegen.c.internal.rte.MessageQueueInfo;
import org.eclipselabs.damos.codegen.c.internal.util.TaskGeneratorUtil;
import org.eclipselabs.damos.codegen.c.rte.IRuntimeEnvironmentAPI;
import org.eclipselabs.damos.codegen.c.util.GeneratorConfigurationUtil;
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

/**
 * @author Andreas Unger
 *
 */
public class DefaultTaskGenerator implements ITaskGenerator {
	
	public void writeTaskContexts(IGeneratorContext context, Appendable appendable, IProgressMonitor monitor) throws IOException {
		IRuntimeEnvironmentAPI runtimeEnvironmentAPI = GeneratorConfigurationUtil.getRuntimeEnvironmentAPI(context.getConfiguration());
		if (runtimeEnvironmentAPI != null) {
			for (TaskGraph taskGraph : context.getExecutionFlow().getTaskGraphs()) {
				String taskName = TaskGeneratorUtil.getTaskName(context.getConfiguration(), taskGraph);
				EList<TaskInputNode> inputNodes = taskGraph.getInputNodes();
				appendable.append("struct {\n");
				if (!inputNodes.isEmpty()) {
					if (TaskGeneratorUtil.getInputSockets(taskGraph).isEmpty()) {
						TaskInputNode inputNode = inputNodes.get(0);
						MessageQueueInfo messageQueueInfo = TaskGeneratorUtil.createMessageQueueInfoFor(context, inputNode);
						appendable.append(runtimeEnvironmentAPI.getMessageQueueGenerator().generateContextCode(context, "queue", messageQueueInfo));
					} else {
						MessageQueueInfo messageQueueInfo = TaskGeneratorUtil.createMessageQueueInfoFor(context, taskGraph);
						appendable.append(runtimeEnvironmentAPI.getMessageQueueGenerator().generateContextCode(context, "queue", messageQueueInfo));
					}
				}
				appendable.append("} ").append(taskName).append(";\n");
			}
		}
	}

	public void writeInitializeTasks(IGeneratorContext context, Appendable appendable, IProgressMonitor monitor) throws IOException {
		IRuntimeEnvironmentAPI runtimeEnvironmentAPI = GeneratorConfigurationUtil.getRuntimeEnvironmentAPI(context.getConfiguration());
		if (runtimeEnvironmentAPI != null) {
			for (TaskGraph taskGraph : context.getExecutionFlow().getTaskGraphs()) {
				String taskName = TaskGeneratorUtil.getTaskName(context.getConfiguration(), taskGraph);
				EList<TaskInputNode> inputNodes = taskGraph.getInputNodes();
				if (!inputNodes.isEmpty()) {
					appendable.append(" {\n");
					String qualifier = TaskGeneratorUtil.getTaskContextVariable(context, taskName, false) + "." + "queue";
					if (TaskGeneratorUtil.getInputSockets(taskGraph).isEmpty()) {
						TaskInputNode inputNode = inputNodes.get(0);
						MessageQueueInfo messageQueueInfo = TaskGeneratorUtil.createMessageQueueInfoFor(context, inputNode);
						appendable.append(runtimeEnvironmentAPI.getMessageQueueGenerator().generateInitializationCode(context, qualifier, messageQueueInfo));
					} else {
						MessageQueueInfo messageQueueInfo = TaskGeneratorUtil.createMessageQueueInfoFor(context, taskGraph);
						appendable.append(runtimeEnvironmentAPI.getMessageQueueGenerator().generateInitializationCode(context, qualifier, messageQueueInfo));
					}
					appendable.append("}\n");
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

					out.print(GeneratorConfigurationUtil.getRuntimeEnvironmentAPI(context.getConfiguration()).getFastLockGenerator().generateLockCode(variableName));
					new Formatter(out).format("%s.data = %s;\n", contextVariable, outputVariable);
					out.print(GeneratorConfigurationUtil.getRuntimeEnvironmentAPI(context.getConfiguration()).getFastLockGenerator().generateUnlockCode(variableName));
				}
			}
		}
	}

	public void writeMessageQueueSend(IGeneratorContext context, Appendable appendable, ComponentNode componentNode, IProgressMonitor monitor) throws IOException {
		PrintAppendable out = new PrintAppendable(appendable);
		for (DataFlowEnd end : componentNode.getDrivenEnds()) {
			if (end.getNode() instanceof TaskInputNode) {
				TaskInputNode inputNode = (TaskInputNode) end.getNode();
				
				String taskName = TaskGeneratorUtil.getTaskName(context.getConfiguration(), inputNode.getTaskGraph());
				String qualifier = TaskGeneratorUtil.getTaskContextVariable(context, taskName, false) + "." + "queue";
				String outputVariable = new VariableAccessor(context.getConfiguration(), componentNode).getOutputVariable((OutputPort) end.getDataFlow().getSourceEnd().getConnector(), false);

				DataFlowTargetEnd firstEnd = inputNode.getDrivenEnds().get(0);
				if (firstEnd.getConnector() instanceof InputPort) {
					InputPort inputPort = (InputPort) firstEnd.getConnector();
					Input input = inputPort.getInput();
					if (input.isSocket()) {
						out.append("{\n");
						out.append(TaskGeneratorUtil.getTaskName(context.getConfiguration(), inputNode.getTaskGraph()) + "_Message message;\n");
						out.printf("message.kind = %d;\n", input.getComponent().getInputSockets().indexOf(input));
						out.printf("message.data.%s = %s;\n", input.getName(), outputVariable);
						MessageQueueInfo messageQueueInfo = TaskGeneratorUtil.createMessageQueueInfoFor(context, inputNode.getTaskGraph());
						out.print(GeneratorConfigurationUtil.getRuntimeEnvironmentAPI(context.getConfiguration()).getMessageQueueGenerator().generateSendCode(context, qualifier, "&message", messageQueueInfo));
						out.append("}\n");
						continue;
					}
				}
				
				MessageQueueInfo messageQueueInfo = TaskGeneratorUtil.createMessageQueueInfoFor(context, inputNode);
				out.print(GeneratorConfigurationUtil.getRuntimeEnvironmentAPI(context.getConfiguration()).getMessageQueueGenerator().generateSendCode(context, qualifier, "&" + outputVariable, messageQueueInfo));
			}
		}
	}

}
