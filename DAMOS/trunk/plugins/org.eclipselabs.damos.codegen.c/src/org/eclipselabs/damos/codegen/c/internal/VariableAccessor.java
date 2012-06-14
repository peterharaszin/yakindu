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

package org.eclipselabs.damos.codegen.c.internal;

import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipselabs.damos.codegen.c.IVariableAccessor;
import org.eclipselabs.damos.codegen.c.internal.util.InternalGeneratorUtil;
import org.eclipselabs.damos.codegen.c.internal.util.TaskGeneratorUtil;
import org.eclipselabs.damos.codegen.c.util.GeneratorConfigurationExtensions;
import org.eclipselabs.damos.dconfig.Configuration;
import org.eclipselabs.damos.dml.Inport;
import org.eclipselabs.damos.dml.Input;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.dml.OutputPort;
import org.eclipselabs.damos.dml.util.DMLUtil;
import org.eclipselabs.damos.execution.ComponentNode;
import org.eclipselabs.damos.execution.DataFlowSourceEnd;
import org.eclipselabs.damos.execution.DataFlowTargetEnd;
import org.eclipselabs.damos.execution.Node;
import org.eclipselabs.damos.execution.TaskGraph;
import org.eclipselabs.damos.execution.TaskInputNode;

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
	 * @see org.eclipselabs.damos.codegen.c.IVariableAccessor#getContextVariable(boolean)
	 */
	public String generateContextVariableReference(boolean pointer) {
		StringBuilder sb = new StringBuilder();
		if (pointer) {
			sb.append("(&");
		}
		String prefix = GeneratorConfigurationExtensions.getPrefix(configuration);
		if (prefix != null) {
			sb.append(prefix);
		}
		sb.append("context.");
		sb.append(GeneratorConfigurationExtensions.getPrefix(configuration, node) + node.getComponent().getName());
		if (pointer) {
			sb.append(")");
		}
		return sb.toString();
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.IVariableAccessor#getInputVariable(boolean)
	 */
	public String generateInputVariableReference(InputPort inputPort, boolean pointer) {
		DataFlowTargetEnd targetEnd = node.getIncomingDataFlow(inputPort);
		DataFlowSourceEnd sourceEnd = targetEnd.getDataFlow().getSourceEnd();
		if (sourceEnd.getNode() instanceof TaskInputNode) {
			TaskInputNode inputNode = (TaskInputNode) sourceEnd.getNode();
			Input input = inputPort.getInput();
			if (input.isSocket()) {
				return TaskGeneratorUtil.getTaskName(configuration, inputNode.getTaskGraph()) + "_message.data." + input.getName();
			}
			return TaskGeneratorUtil.getTaskInputVariableName(configuration, inputNode);
		}
		OutputPort sourcePort = (OutputPort) sourceEnd.getConnector();
		return getOutputVariable(sourcePort, pointer, sourceEnd.getNode());
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.IVariableAccessor#getOutputVariable(boolean)
	 */
	public String generateOutputVariableReference(OutputPort outputPort, boolean pointer) {
		return getOutputVariable(outputPort, pointer, node);
	}
	
	private String getOutputVariable(OutputPort outputPort, boolean pointer, Node node) {
		StringBuilder sb = new StringBuilder();
		if (pointer) {
			sb.append("(&");
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
		if (pointer) {
			sb.append(")");
		}
		return sb.toString();
	}
	
	public String generateMessageKindVariableReference(boolean pointer) {
		StringBuilder sb = new StringBuilder();
		if (pointer) {
			sb.append("(&");
		}
		sb.append(TaskGeneratorUtil.getTaskName(configuration, DMLUtil.getOwner(node, TaskGraph.class)));
		sb.append("_message.kind");
		if (pointer) {
			sb.append(")");
		}
		return sb.toString();
	}
	
}
