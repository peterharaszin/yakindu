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

package org.eclipse.damos.execution.transform;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.damos.dml.ChoiceInputPort;
import org.eclipse.damos.dml.Fragment;
import org.eclipse.damos.dml.InputConnector;
import org.eclipse.damos.dml.InputPort;
import org.eclipse.damos.dml.Outport;
import org.eclipse.damos.execution.ActionNode;
import org.eclipse.damos.execution.ComponentNode;
import org.eclipse.damos.execution.CompoundNode;
import org.eclipse.damos.execution.DataFlowSourceEnd;
import org.eclipse.damos.execution.DataFlowTargetEnd;
import org.eclipse.damos.execution.Edge;
import org.eclipse.damos.execution.ExecutionFactory;
import org.eclipse.damos.execution.ExecutionFlow;
import org.eclipse.damos.execution.Graph;
import org.eclipse.damos.execution.Node;
import org.eclipse.damos.execution.Subgraph;
import org.eclipse.damos.execution.internal.ExecutionPlugin;
import org.eclipse.damos.execution.internal.transform.FlattenerHelper;
import org.eclipse.damos.execution.internal.transform.TaskNodeComputationHelper;
import org.eclipse.damos.execution.internal.transform.TimingContraintPropagationHelper;

/**
 * @author Andreas Unger
 *
 */
public class ExecutionFlowBuilder {
	
	private final TimingContraintPropagationHelper timingContraintPropagationHelper = new TimingContraintPropagationHelper();
	private final TaskNodeComputationHelper taskNodeComputationHelper = new TaskNodeComputationHelper();

	public ExecutionFlow build(Fragment topLevelFragment, IProgressMonitor monitor) throws CoreException {
		Context context = new Context();
		context.flow = ExecutionFactory.eINSTANCE.createExecutionFlow();
		context.flow.setTopLevelFragment(topLevelFragment);
		context.flow.setGraph(ExecutionFactory.eINSTANCE.createGraph());
		context.flattenerHelper = new FlattenerHelper(context.flow);
		context.flattenerHelper.flatten();
		
		List<Node> backlog = doConstruct(context, context.flow.getGraph());
		
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
			throw new CoreException(new DeadlockStatus(
					IStatus.ERROR, ExecutionPlugin.PLUGIN_ID, 0, message, null, backlog));
		}
		
		timingContraintPropagationHelper.propagateTimingConstraints(context.flow);
		taskNodeComputationHelper.computeTaskNodes(context.flow);
		
		return context.flow;
	}

	/**
	 * @param context
	 * @param flattenerHelper
	 * @return
	 */
	private List<Node> doConstruct(Context context, Graph graph) {
		List<Node> backlog = new LinkedList<Node>(context.flattenerHelper.getNodes(graph));

		boolean changed;
		do {
			changed = false;
			for (Iterator<Node> it = backlog.iterator(); it.hasNext();) {
				Node node = it.next();
				List<Node> drivingNodes = getDrivingNodes(context, node);
				if (drivingNodes.isEmpty()) {
					addDrivingNodeToExecutionFlow(context, graph, node);
					it.remove();
					changed = true;
				} else if (drivingNodesInExecutionFlow(context, drivingNodes)) {
					addDrivenNodeToExecutionFlow(context, graph, node, drivingNodes);
					it.remove();
					changed = true;
				}
			}
		} while (changed);
		
		for (Node node : graph.getNodes()) {
			if (node instanceof Graph) {
				backlog.addAll(doConstruct(context, (Graph) node));
			}
		}
		
		return backlog;
	}
	
	private List<Node> getDrivingNodes(Context context, Node drivenNode) {
		List<Node> drivingNodes = new ArrayList<Node>();
		getDrivingNodes(context, drivenNode, drivenNode, drivingNodes);
		return drivingNodes;
	}
	
	private void getDrivingNodes(Context context, Node node, Node drivenNode, List<Node> drivingNodes) {
		for (DataFlowTargetEnd targetEnd : node.getIncomingDataFlows()) {
			DataFlowSourceEnd sourceEnd = targetEnd.getDataFlow().getSourceEnd();
			
			if (isChild(context, drivenNode, sourceEnd.getNode())) {
				continue;
			}
			
			boolean driving = true;
			InputConnector target = targetEnd.getConnector();
			if (target instanceof InputPort && !(target instanceof ChoiceInputPort)) {
				InputPort targetPort = (InputPort) target;
				driving = targetPort.getInput().isDirectFeedthrough() || targetPort.getComponent() instanceof Outport;
			}
			
			if (driving) {
				Node drivingNode = getActualDrivingNode(context, drivenNode, sourceEnd.getNode());
				if (drivingNode != null) {
					drivingNodes.add(drivingNode);
				}
			}
		}
				
		if (node instanceof CompoundNode) {
			CompoundNode compoundNode = (CompoundNode) node;
			
			if (compoundNode instanceof ActionNode) {
				ActionNode actionNode = (ActionNode) compoundNode;
				if (actionNode.getChoiceNode() != null) {
					drivingNodes.add(actionNode.getChoiceNode());
				}
			}

			for (Node memberNode : context.flattenerHelper.getNodes(compoundNode)) {
				getDrivingNodes(context, memberNode, drivenNode, drivingNodes);
			}
		}
	}
	
	private Node getActualDrivingNode(Context context, Node drivenNode, Node drivingNode) {
		Graph drivenNodeGraph = context.flattenerHelper.getGraph(drivenNode);
		for (;;) {
			Graph drivingNodeGraph = context.flattenerHelper.getGraph(drivingNode);
			if (drivingNodeGraph == drivenNodeGraph) {
				return drivingNode;
			}
			if (drivingNodeGraph instanceof Subgraph) {
				drivingNode = (Subgraph) drivingNodeGraph;
			} else {
				break;
			}
		}
		return null;
	}
	
	/**
	 * @param parentNode
	 * @param node
	 * @return
	 */
	private boolean isChild(Context context, Node parentNode, Node node) {
		if (parentNode instanceof CompoundNode) {
			CompoundNode compoundNode = (CompoundNode) parentNode;
			for (Node child : context.flattenerHelper.getNodes(compoundNode)) {
				if (child == node || isChild(context, child, node)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean drivingNodesInExecutionFlow(Context context, List<Node> drivingNodes) {
		for (Node drivingNode : drivingNodes) {
			if (!context.nodes.contains(drivingNode)) {
				return false;
			}
		}
		return true;
	}

	private void addDrivingNodeToExecutionFlow(Context context, Graph graph, Node node) {
		graph.getNodes().add(node);
		graph.getInitialNodes().add(node);
		context.nodes.add(node);
	}
	
	private void addDrivenNodeToExecutionFlow(Context context, Graph graph, Node node, List<Node> drivingNodes) {
		graph.getNodes().add(node);

		for (Node drivingNode : drivingNodes) {
			Edge edge = ExecutionFactory.eINSTANCE.createEdge();
			graph.getEdges().add(edge);
			edge.setSource(drivingNode);
			edge.setTarget(node);
		}
		
		context.nodes.add(node);
	}
	
	private static class Context {
		
		private ExecutionFlow flow;

		private Set<Node> nodes = new HashSet<Node>();
		
		private FlattenerHelper flattenerHelper;

	}

}
