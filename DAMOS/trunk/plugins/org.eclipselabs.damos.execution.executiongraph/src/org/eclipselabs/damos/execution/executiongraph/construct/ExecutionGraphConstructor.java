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

package org.eclipselabs.damos.execution.executiongraph.construct;

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
import org.eclipselabs.damos.execution.executiongraph.DataFlowTargetEnd;
import org.eclipselabs.damos.execution.executiongraph.ExecutionGraph;
import org.eclipselabs.damos.execution.executiongraph.ExecutionGraphFactory;
import org.eclipselabs.damos.execution.executiongraph.Link;
import org.eclipselabs.damos.execution.executiongraph.Node;
import org.eclipselabs.damos.execution.executiongraph.internal.construct.FlattenerHelper;

/**
 * @author Andreas Unger
 *
 */
public class ExecutionGraphConstructor {

	private ExecutionGraph graph;

	private Set<Node> nodes;

	public ExecutionGraph construct(Fragment topLevelFragment, IProgressMonitor monitor) throws CoreException {
		return createExecutionGraph(topLevelFragment);
	}
	
	protected ExecutionGraph createExecutionGraph(Fragment topLevelFragment) throws CoreException {
		graph = ExecutionGraphFactory.eINSTANCE.createExecutionGraph();
		graph.setTopLevelFragment(topLevelFragment);
		nodes = new HashSet<Node>();

		FlattenerHelper flattenerHelper = new FlattenerHelper(graph);
		flattenerHelper.flatten();
		List<Node> backlog = new LinkedList<Node>(flattenerHelper.getNodes());

		boolean changed;
		do {
			changed = false;
			for (Iterator<Node> it = backlog.iterator(); it.hasNext();) {
				Node node = it.next();
				List<Node> drivingNodes = getDrivingNodes(node);
				if (drivingNodes.isEmpty()) {
					addDrivingNodeToExecutionGraph(node);
					it.remove();
					changed = true;
				} else if (drivingNodesInExecutionGraph(drivingNodes)) {
					addDrivenNodeToExecutionGraph(node, drivingNodes);
					it.remove();
					changed = true;
				}
			}
		} while (changed);

		if (!backlog.isEmpty()) {
			String message = "Deadlock occurred between component";
			if (backlog.size() == 1) {
				message += " '" + backlog.get(0).getComponent().getName() + "'";
			} else {
				StringBuilder sb = new StringBuilder(message);
				sb.append("s ");
				boolean first = true;
				for (Node node : backlog) {
					if (first) {
						first = false;
					} else {
						sb.append(", ");
					}
					sb.append("'");
					sb.append(node.getComponent().getName());
					sb.append("'");
				}
			}
			throw new CoreException(new ExecutionGraphDeadlockStatus(
					IStatus.ERROR, ExecutionPlugin.PLUGIN_ID, 0, message, null, backlog));
		}
		
		return graph;
	}

	private List<Node> getDrivingNodes(Node node) {
		List<Node> drivingNodes = new ArrayList<Node>();
		for (DataFlowTargetEnd targetEnd : node.getIncomingDataFlows()) {
			if (targetEnd.getPort().getInput().isDirectFeedthrough()) {
				drivingNodes.add(targetEnd.getDataFlow().getSourceEnd().getNode());
			}
		}
		return drivingNodes;
	}
	
	private boolean drivingNodesInExecutionGraph(List<Node> drivingNodes) {
		for (Node drivingNode : drivingNodes) {
			if (!nodes.contains(drivingNode)) {
				return false;
			}
		}
		return true;
	}

	private void addDrivingNodeToExecutionGraph(Node node) {
		graph.getNodes().add(node);
		graph.getInitialNodes().add(node);
		nodes.add(node);
	}
	
	private void addDrivenNodeToExecutionGraph(Node node, List<Node> drivingNodes) {
		graph.getNodes().add(node);

		for (Node drivingNode : drivingNodes) {
			Link link = ExecutionGraphFactory.eINSTANCE.createLink();
			graph.getLinks().add(link);
			link.setSourceNode(drivingNode);
			link.setTargetNode(node);
		}
		
		nodes.add(node);
	}

}
