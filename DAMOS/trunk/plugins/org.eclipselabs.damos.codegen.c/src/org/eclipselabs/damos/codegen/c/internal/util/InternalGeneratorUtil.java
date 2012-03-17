/****************************************************************************
 * Copyright (c) 2008, 2010 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.codegen.c.internal.util;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.damos.codegen.c.IComponentGenerator;
import org.eclipselabs.damos.codegen.c.internal.ComponentGeneratorAdapter;
import org.eclipselabs.damos.codegen.c.internal.VariableAccessor;
import org.eclipselabs.damos.dconfig.Configuration;
import org.eclipselabs.damos.dml.BlockOutput;
import org.eclipselabs.damos.dml.InputConnector;
import org.eclipselabs.damos.dml.Output;
import org.eclipselabs.damos.dml.OutputPort;
import org.eclipselabs.damos.dml.util.DMLUtil;
import org.eclipselabs.damos.dml.util.SystemPath;
import org.eclipselabs.damos.execution.executionflow.ComponentNode;
import org.eclipselabs.damos.execution.executionflow.DataFlowSourceEnd;
import org.eclipselabs.damos.execution.executionflow.DataFlowTargetEnd;
import org.eclipselabs.damos.execution.executionflow.Node;
import org.eclipselabs.damos.execution.executionflow.TaskGraph;
import org.eclipselabs.damos.execution.executionflow.TaskInputNode;
import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.StringLiteral;

/**
 * @author Andreas Unger
 *
 */
public class InternalGeneratorUtil {

	public static IComponentGenerator getComponentGenerator(ComponentNode node) {
		ComponentGeneratorAdapter adapter = (ComponentGeneratorAdapter) EcoreUtil.getAdapter(node.eAdapters(), ComponentGeneratorAdapter.class);
		return adapter != null ? adapter.getGenerator() : null;
	}
	
	public static String getPrefix(Configuration configuration) {
		Expression prefixValue = configuration.getPropertyValue(SystemPath.create(configuration.getContextFragment()), "damos.codegen.c.prefix");
		if (prefixValue instanceof StringLiteral) {
			return ((StringLiteral) prefixValue).getValue();
		}
		return "";
	}

	public static String getPrefix(Configuration configuration, Node node) {
		Expression prefixValue = configuration.getPropertyValue(node.getSystemPath(), "damos.codegen.c.prefix");
		if (prefixValue instanceof StringLiteral) {
			return ((StringLiteral) prefixValue).getValue();
		}
		return "";
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

	public static String getIncomingVariableName(Configuration configuration, Node node, InputConnector inputConnector) {
		DataFlowTargetEnd targetEnd = node.getIncomingDataFlow(inputConnector);
		if (targetEnd != null) {
			DataFlowSourceEnd sourceEnd = targetEnd.getDataFlow().getSourceEnd();
			Node sourceNode = sourceEnd.getNode();
			if (sourceNode instanceof ComponentNode && sourceEnd.getConnector() instanceof OutputPort) {
				OutputPort outputPort = (OutputPort) sourceEnd.getConnector();
				ComponentNode componentNode = (ComponentNode) sourceNode;
				return new VariableAccessor(configuration, componentNode).getOutputVariable(outputPort, false);
			}
		}
		return null;
	}

	public static String getOutputVariableName(Configuration configuration, ComponentNode componentNode, OutputPort outputPort) {
		return String.format("%s%s_%s", InternalGeneratorUtil.getPrefix(configuration, componentNode), componentNode.getComponent().getName(), InternalGeneratorUtil.getOutputPortName(outputPort));
	}

	public static String getChoiceVariableName(Configuration configuration, ComponentNode componentNode) {
		return String.format("%s%s_result", InternalGeneratorUtil.getPrefix(configuration, componentNode), componentNode.getComponent().getName());
	}

	public static String getMemoryPreviousValueVariableName(Configuration configuration, ComponentNode componentNode) {
		return String.format("%s%s_previousValue", InternalGeneratorUtil.getPrefix(configuration, componentNode), componentNode.getComponent().getName());
	}

	public static String uncapitalize(String s) {
		if (s == null) {
			return "";
		}
		if (s.length() == 0) {
			return s;
		}
		return s.substring(0, 1).toLowerCase() + s.substring(1);
	}

	public static String capitalize(String s) {
		if (s == null) {
			return "";
		}
		if (s.length() == 0) {
			return s;
		}
		return s.substring(0, 1).toUpperCase() + s.substring(1);
	}
	
	public static String getOutputPortName(OutputPort outputPort) {
		StringBuilder sb = new StringBuilder();
		Output output = outputPort.getOutput();
		if (output instanceof BlockOutput) {
			BlockOutput blockOutput = (BlockOutput) output;
			sb.append(blockOutput.getDefinition().getName());
		} else {
			sb.append("output");
			if (output.getComponent().getOutputs().size() > 1) {
				sb.append(DMLUtil.indexOf(output));
				sb.append("_");
			}
		}
		if (output.getPorts().size() > 1) {
			sb.append(outputPort.getIndex());
		}
		return sb.toString();
	}

}
