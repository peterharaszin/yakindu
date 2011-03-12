/****************************************************************************
 * Copyright (c) 2008, 2009 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.execution.executionflow.construct;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipselabs.damos.dml.Fragment;
import org.eclipselabs.damos.dml.InputConnector;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.execution.executionflow.ComponentNode;
import org.eclipselabs.damos.execution.executionflow.CompoundNode;
import org.eclipselabs.damos.execution.executionflow.DataFlowSourceEnd;
import org.eclipselabs.damos.execution.executionflow.DataFlowTargetEnd;
import org.eclipselabs.damos.execution.executionflow.Edge;
import org.eclipselabs.damos.execution.executionflow.ExecutionFlow;
import org.eclipselabs.damos.execution.executionflow.ExecutionFlowFactory;
import org.eclipselabs.damos.execution.executionflow.Graph;
import org.eclipselabs.damos.execution.executionflow.Node;
import org.eclipselabs.damos.execution.executionflow.Subgraph;
import org.eclipselabs.damos.execution.executionflow.internal.construct.FlattenerHelper;

/**
 * @author Andreas Unger
 *
 */
public class ExecutionFlowConstructor {

	public ExecutionFlow construct(Fragment topLevelFragment, IProgressMonitor monitor) throws CoreException {
		Context context = new Context();
		context.flow = ExecutionFlowFactory.eINSTANCE.createExecutionFlow();
		context.flow.setTopLevelFragment(topLevelFragment);
		context.flow.setGraph(ExecutionFlowFactory.eINSTANCE.createGraph());

		FlattenerHelper flattenerHelper = new FlattenerHelper(context.flow);
		flattenerHelper.flatten();
		List<Node> backlog = new LinkedList<Node>(flattenerHelper.getNodes());

		boolean changed;
		do {
			changed = false;
			for (Iterator<Node> it = backlog.iterator(); it.hasNext();) {
				Node node = it.next();
				List<Node> drivingNodes = getDrivingNodes(node);
				if (drivingNodes.isEmpty()) {
					addDrivingNodeToExecutionFlow(context, node);
					it.remove();
					changed = true;
				} else if (drivingNodesInExecutionFlow(context, drivingNodes)) {
					addDrivenNodeToExecutionFlow(context, node, drivingNodes);
					it.remove();
					changed = true;
				}
			}
		} while (changed);

		if (!backlog.isEmpty()) {
			String message = "Deadlock occurred between component";
			if (backlog.size() == 1) {
				Node node = backlog.get(0);
				if (node instanceof ComponentNode) {
					ComponentNode componentNode = (ComponentNode) node;
					message += " '" + componentNode.getComponent().getName() + "'";
				} else {
					// TODO
				}
			} else {
				StringBuilder sb = new StringBuilder(message);
				sb.append("s ");
				boolean first = true;
				for (Node node : backlog) {
					if (!(node instanceof ComponentNode)) {
						continue;
					}

					ComponentNode componentNode = (ComponentNode) node;
					
					if (first) {
						first = false;
					} else {
						sb.append(", ");
					}
					sb.append("'");
					sb.append(componentNode.getComponent().getName());
					sb.append("'");
				}
			}
			throw new CoreException(new ExecutionFlowDeadlockStatus(
					IStatus.ERROR, ExecutionFlowPlugin.PLUGIN_ID, 0, message, null, backlog));
		}
		
		return context.flow;
	}
	
	private List<Node> getDrivingNodes(Node node) {
		List<Node> drivingNodes = new ArrayList<Node>();
		getDrivingNodes(node.getGraph(), node, drivingNodes);
		return drivingNodes;
	}
	
	private void getDrivingNodes(Graph sourceGraph, Node node, List<Node> drivingNodes) {
		for (DataFlowTargetEnd targetEnd : node.getIncomingDataFlows()) {
			DataFlowSourceEnd sourceEnd = targetEnd.getDataFlow().getSourceEnd();
			if (sourceEnd.getNode().getGraph() != sourceGraph) {
				continue;
			}
			
			boolean driving = true;
			InputConnector target = targetEnd.getConnector();
			if (target instanceof InputPort) {
				InputPort targetPort = (InputPort) target;
				driving = targetPort.getInput().isDirectFeedthrough();
			}
			
			if (driving) {
				drivingNodes.add(getActualDrivingNode(node, sourceEnd.getNode()));
			}
		}
		
		if (node instanceof CompoundNode) {
			CompoundNode compoundNode = (CompoundNode) node;
			for (Node memberNode : compoundNode.getNodes()) {
				getDrivingNodes(sourceGraph, memberNode, drivingNodes);
			}
		}
	}
	
	private Node getActualDrivingNode(Node drivenNode, Node drivingNode) {
		while (drivingNode.getGraph() != drivenNode.getGraph()) {
			Graph graph = drivingNode.getGraph();
			if (graph instanceof Subgraph) {
				drivingNode = (Subgraph) graph;
			} else {
				break;
			}
		}
		return drivingNode;
	}
	
	private boolean drivingNodesInExecutionFlow(Context context, List<Node> drivingNodes) {
		for (Node drivingNode : drivingNodes) {
			if (!context.nodes.contains(drivingNode)) {
				return false;
			}
		}
		return true;
	}

	private void addDrivingNodeToExecutionFlow(Context context, Node node) {
		context.flow.getGraph().getNodes().add(node);
		context.flow.getGraph().getInitialNodes().add(node);
		context.nodes.add(node);
	}
	
	private void addDrivenNodeToExecutionFlow(Context context, Node node, List<Node> drivingNodes) {
		context.flow.getGraph().getNodes().add(node);

		for (Node drivingNode : drivingNodes) {
			Edge edge = ExecutionFlowFactory.eINSTANCE.createEdge();
			context.flow.getGraph().getEdges().add(edge);
			edge.setSource(drivingNode);
			edge.setTarget(node);
		}
		
		context.nodes.add(node);
	}
	
	private static class Context {
		
		private ExecutionFlow flow;

		private Set<Node> nodes = new HashSet<Node>();

	}

}
