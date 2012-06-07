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

package org.eclipselabs.damos.codegen.c.internal.util;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipselabs.damos.codegen.c.IComponentGenerator;
import org.eclipselabs.damos.codegen.c.IGeneratorContext;
import org.eclipselabs.damos.codegen.c.internal.rte.MessageQueueInfo;
import org.eclipselabs.damos.codegen.c.util.GeneratorConfigurationUtil;
import org.eclipselabs.damos.dconfig.Configuration;
import org.eclipselabs.damos.dml.Input;
import org.eclipselabs.damos.dml.OutputPort;
import org.eclipselabs.damos.execution.ComponentNode;
import org.eclipselabs.damos.execution.DataFlowEnd;
import org.eclipselabs.damos.execution.Node;
import org.eclipselabs.damos.execution.TaskGraph;
import org.eclipselabs.damos.execution.TaskInputNode;
import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.codegen.c.util.MscriptGeneratorUtil;

/**
 * @author Andreas Unger
 *
 */
public class TaskGeneratorUtil {

	public static EList<Input> getInputSockets(TaskGraph taskGraph) {
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

	public static String getCDataTypeFor(IGeneratorContext context, TaskInputNode inputNode) {
		DataFlowEnd end = inputNode.getDrivingEnds().get(0);
		IComponentGenerator componentGenerator = InternalGeneratorUtil.getComponentGenerator((ComponentNode) end.getNode());
		DataType dataType = componentGenerator.getContext().getComponentSignature().getOutputDataType((OutputPort) end.getConnector());
		return MscriptGeneratorUtil.getCDataType(GeneratorConfigurationUtil.getComputationModel(context.getConfiguration(), (ComponentNode) end.getNode()), context, dataType, null);
	}

	public static String getTaskContextVariable(IGeneratorContext context, String taskName, boolean pointer) {
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

	public static MessageQueueInfo createMessageQueueInfoFor(IGeneratorContext context, TaskInputNode inputNode) {
		return new MessageQueueInfo("10", "sizeof(" + getCDataTypeFor(context, inputNode) + ")");
	}
	
	public static MessageQueueInfo createMessageQueueInfoFor(IGeneratorContext context, TaskGraph taskGraph) {
		return new MessageQueueInfo("10", "sizeof(" + TaskGeneratorUtil.getTaskName(context.getConfiguration(), taskGraph) + "_Message)");
	}

	public static String getTaskName(Configuration configuration, TaskGraph taskGraph) {
		return InternalGeneratorUtil.getPrefix(configuration, taskGraph.getInitialNodes().get(0)) + ((ComponentNode) taskGraph.getInitialNodes().get(0)).getComponent().getName() + "_Task";
	}
	
	public static String getTaskInputVariableName(Configuration configuration, TaskInputNode inputNode) {
		TaskGraph taskGraph = inputNode.getTaskGraph();
		String taskInputVariableName = getTaskName(configuration, taskGraph) + "_input";
		if (taskGraph.getInputNodes().size() > 1) {
			taskInputVariableName += taskGraph.getInputNodes().indexOf(inputNode);
		}
		return taskInputVariableName;
	}

}
