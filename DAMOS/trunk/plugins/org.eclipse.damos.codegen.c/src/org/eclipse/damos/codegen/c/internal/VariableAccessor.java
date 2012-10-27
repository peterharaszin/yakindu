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

package org.eclipse.damos.codegen.c.internal;

import org.eclipse.damos.codegen.c.IVariableAccessor;
import org.eclipse.damos.codegen.c.internal.util.InternalGeneratorUtil;
import org.eclipse.damos.codegen.c.internal.util.TaskGeneratorUtil;
import org.eclipse.damos.codegen.c.util.GeneratorConfigurationExtensions;
import org.eclipse.damos.dconfig.Configuration;
import org.eclipse.damos.dml.Component;
import org.eclipse.damos.dml.Inport;
import org.eclipse.damos.dml.Input;
import org.eclipse.damos.dml.InputPort;
import org.eclipse.damos.dml.OutputPort;
import org.eclipse.damos.dml.util.DMLUtil;
import org.eclipse.damos.execution.ComponentNode;
import org.eclipse.damos.execution.DataFlowSourceEnd;
import org.eclipse.damos.execution.DataFlowTargetEnd;
import org.eclipse.damos.execution.Node;
import org.eclipse.damos.execution.TaskGraph;
import org.eclipse.damos.execution.TaskInputNode;
import org.eclipse.xtext.xbase.lib.StringExtensions;

/**
 * @author Andreas Unger
 *
 */
public class VariableAccessor implements IVariableAccessor {

	private Configuration configuration;
	private ComponentNode node;
	
	/**
	 * 
	 */
	public VariableAccessor(Configuration configuration, ComponentNode node) {
		this.node = node;
		this.configuration = configuration;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.codegen.c.IVariableAccessor#getContextVariable(boolean)
	 */
	public String generateContextVariableReference(boolean pointer) {
		StringBuilder sb = new StringBuilder();

		if (pointer) {
			sb.append("&");
		}

		if (GeneratorConfigurationExtensions.isSingleton(configuration)) {
			String prefix = GeneratorConfigurationExtensions.getPrefix(configuration);
			if (prefix != null) {
				sb.append(prefix);
			}
			sb.append("context.");
			sb.append(GeneratorConfigurationExtensions.getPrefix(configuration, node) + node.getComponent().getName());
		} else {
			sb.append("context->");
			sb.append(GeneratorConfigurationExtensions.getPrefix(configuration, node) + node.getComponent().getName());
		}
		
		return sb.toString();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.codegen.c.IVariableAccessor#getInputVariable(boolean)
	 */
	public String generateInputVariableReference(InputPort inputPort, boolean pointer) {
		DataFlowTargetEnd targetEnd = node.getIncomingDataFlow(inputPort);
		DataFlowSourceEnd sourceEnd = targetEnd.getDataFlow().getSourceEnd();
		if (sourceEnd.getNode() instanceof TaskInputNode) {
			TaskInputNode inputNode = (TaskInputNode) sourceEnd.getNode();
			Input input = inputPort.getInput();
			if (input.isSocket()) {
				return TaskGeneratorUtil.getTaskName(configuration, inputNode.getTaskGraph()) + "_message";
			}
			return TaskGeneratorUtil.getTaskInputVariableName(configuration, inputNode);
		}
		OutputPort sourcePort = (OutputPort) sourceEnd.getConnector();
		return getOutputVariable(sourcePort, pointer, sourceEnd.getNode());
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.codegen.c.IVariableAccessor#getOutputVariable(boolean)
	 */
	public String generateOutputVariableReference(OutputPort outputPort, boolean pointer) {
		if (InternalGeneratorUtil.isConnectedToOutportOnly(outputPort, node)) {
			StringBuilder sb = new StringBuilder();
			if (pointer) {
				sb.append("&");
			}
			sb.append("output->");
			
			Node otherNode = node.getOutgoingDataFlow(outputPort).getTargetEnds().get(0).getNode();
			ComponentNode componentNode = (ComponentNode) otherNode;
			Component outport = componentNode.getComponent();

			sb.append(StringExtensions.toFirstLower(outport.getName()));
			return sb.toString();
		}
		return getOutputVariable(outputPort, pointer, node);
	}
	
	private String getOutputVariable(OutputPort outputPort, boolean pointer, Node node) {
		StringBuilder sb = new StringBuilder();
		if (pointer) {
			sb.append("&");
		}
		if (outputPort.getComponent() instanceof Inport) {
			sb.append("input->");
			sb.append(StringExtensions.toFirstLower(outputPort.getComponent().getName()));
		} else {
			sb.append(GeneratorConfigurationExtensions.getPrefix(configuration, node));
			sb.append(outputPort.getComponent().getName());
			sb.append("_");
			sb.append(InternalGeneratorUtil.getOutputPortName(outputPort));
		}
		return sb.toString();
	}
	
	public String generateMessageKindVariableReference(boolean pointer) {
		StringBuilder sb = new StringBuilder();
		if (pointer) {
			sb.append("&");
		}
		sb.append(TaskGeneratorUtil.getTaskName(configuration, DMLUtil.getOwner(node, TaskGraph.class)));
		sb.append("_message");
		return sb.toString();
	}
	
}
