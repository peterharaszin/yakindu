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

import org.eclipse.damos.codegen.c.internal.util.InternalGeneratorUtil;
import org.eclipse.damos.codegen.c.internal.util.TaskGeneratorHelper;
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
import org.eclipse.damos.mscript.codegen.c.StructGenerator;
import org.eclipse.xtext.xbase.lib.StringExtensions;

import com.google.inject.Inject;

/**
 * @author Andreas Unger
 *
 */
public class VariableAccessor implements IVariableAccessor {

	@Inject
	private TaskGeneratorHelper taskGeneratorHelper;
	
	@Inject
	private StructGenerator structGenerator;

	private Configuration configuration;
	private ComponentNode node;
	
	/**
	 * 
	 */
	protected VariableAccessor(Configuration configuration, ComponentNode node) {
		this.node = node;
		this.configuration = configuration;
	}
	
	public CharSequence generateContextVariableReference(boolean pointer) {
		StringBuilder sb = new StringBuilder();

		if (pointer) {
			sb.append("&");
		}

		if (GeneratorConfigurationExtensions.isSingleton(configuration)) {
			String prefix = GeneratorConfigurationExtensions.getPrefix(configuration);
			if (prefix != null) {
				sb.append(prefix);
			}
			sb.append(structGenerator.generateMemberAccess("context", false));
		} else {
			sb.append(structGenerator.generateMemberAccess("context", true));
		}

		sb.append(GeneratorConfigurationExtensions.getPrefix(configuration, node));
		sb.append(node.getComponent().getName());
		
		return sb;
	}

	public CharSequence generateInputVariableReference(InputPort inputPort, boolean pointer) {
		DataFlowTargetEnd targetEnd = node.getIncomingDataFlow(inputPort);
		DataFlowSourceEnd sourceEnd = targetEnd.getDataFlow().getSourceEnd();
		if (sourceEnd.getNode() instanceof TaskInputNode) {
			TaskInputNode inputNode = (TaskInputNode) sourceEnd.getNode();
			Input input = inputPort.getInput();
			if (input.isSocket()) {
				return taskGeneratorHelper.getTaskName(configuration, inputNode.getTaskGraph()) + "_message";
			}
			return taskGeneratorHelper.getTaskInputVariableName(configuration, inputNode);
		}
		OutputPort sourcePort = (OutputPort) sourceEnd.getConnector();
		return generateOutputVariableReference(sourcePort, pointer, sourceEnd.getNode());
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.codegen.c.IVariableAccessor#getOutputVariable(boolean)
	 */
	public CharSequence generateOutputVariableReference(OutputPort outputPort, boolean pointer) {
		if (InternalGeneratorUtil.isConnectedToOutportOnly(outputPort, node)) {
			StringBuilder sb = new StringBuilder();
			if (pointer) {
				sb.append("&");
			}
			sb.append(structGenerator.generateMemberAccess("output", true));
			
			Node otherNode = node.getOutgoingDataFlow(outputPort).getTargetEnds().get(0).getNode();
			ComponentNode componentNode = (ComponentNode) otherNode;
			Component outport = componentNode.getComponent();

			sb.append(StringExtensions.toFirstLower(outport.getName()));
			return sb.toString();
		}
		return generateOutputVariableReference(outputPort, pointer, node);
	}
	
	private CharSequence generateOutputVariableReference(OutputPort outputPort, boolean pointer, Node node) {
		StringBuilder sb = new StringBuilder();
		if (pointer) {
			sb.append("&");
		}
		if (outputPort.getComponent() instanceof Inport) {
			sb.append(structGenerator.generateMemberAccess("input", true));
			sb.append(StringExtensions.toFirstLower(outputPort.getComponent().getName()));
		} else {
			sb.append(GeneratorConfigurationExtensions.getPrefix(configuration, node));
			sb.append(outputPort.getComponent().getName());
			sb.append("_");
			sb.append(InternalGeneratorUtil.getOutputPortName(outputPort));
		}
		return sb.toString();
	}
	
	public CharSequence generateMessageKindVariableReference(boolean pointer) {
		StringBuilder sb = new StringBuilder();
		if (pointer) {
			sb.append("&");
		}
		sb.append(taskGeneratorHelper.getTaskName(configuration, DMLUtil.getOwner(node, TaskGraph.class)));
		sb.append("_message");
		return sb.toString();
	}
	
}
