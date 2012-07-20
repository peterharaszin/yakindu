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

import java.util.ArrayList;
import java.util.List;

import org.eclipselabs.damos.codegen.c.IGeneratorContext;
import org.eclipselabs.damos.dml.BlockOutput;
import org.eclipselabs.damos.dml.Inport;
import org.eclipselabs.damos.dml.Outport;
import org.eclipselabs.damos.dml.Output;
import org.eclipselabs.damos.dml.OutputPort;
import org.eclipselabs.damos.dml.util.DMLUtil;
import org.eclipselabs.damos.execution.ComponentNode;
import org.eclipselabs.damos.execution.DataFlowSourceEnd;
import org.eclipselabs.damos.execution.Node;

/**
 * @author Andreas Unger
 *
 */
public class InternalGeneratorUtil {
	
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

	public static boolean isConnectedToOutportOnly(OutputPort outputPort, Node node) {
		DataFlowSourceEnd sourceEnd = node.getOutgoingDataFlow(outputPort);
		if (sourceEnd != null && sourceEnd.getTargetEnds().size() == 1) {
			Node otherNode = sourceEnd.getTargetEnds().get(0).getNode();
			return otherNode instanceof ComponentNode && ((ComponentNode) otherNode).getComponent() instanceof Outport;
		}
		return false;
	}

	public static List<ComponentNode> getInportNodes(IGeneratorContext context) {
		List<ComponentNode> inportNodes = new ArrayList<ComponentNode>();
		for (Node node : context.getExecutionFlow().getGraph().getNodes()) {
			if (node instanceof ComponentNode) {
				ComponentNode componentNode = (ComponentNode) node;
				if (componentNode.getComponent() instanceof Inport) {
					inportNodes.add(componentNode);
				}
			}
		}
		return inportNodes;
	}

	public static List<ComponentNode> getOutportNodes(IGeneratorContext context) {
		List<ComponentNode> outportNodes = new ArrayList<ComponentNode>();
		for (Node node : context.getExecutionFlow().getGraph().getNodes()) {
			if (node instanceof ComponentNode) {
				ComponentNode componentNode = (ComponentNode) node;
				if (componentNode.getComponent() instanceof Outport) {
					outportNodes.add(componentNode);
				}
			}
		}
		return outportNodes;
	}

}
