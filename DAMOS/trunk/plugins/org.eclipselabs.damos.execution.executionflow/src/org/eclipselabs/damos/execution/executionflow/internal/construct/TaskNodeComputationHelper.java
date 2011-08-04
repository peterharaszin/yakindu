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

package org.eclipselabs.damos.execution.executionflow.internal.construct;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipselabs.damos.dml.AsynchronousTimingConstraint;
import org.eclipselabs.damos.dml.Latch;
import org.eclipselabs.damos.execution.executionflow.ComponentNode;
import org.eclipselabs.damos.execution.executionflow.ExecutionFlow;
import org.eclipselabs.damos.execution.executionflow.ExecutionFlowFactory;
import org.eclipselabs.damos.execution.executionflow.Graph;
import org.eclipselabs.damos.execution.executionflow.Node;
import org.eclipselabs.damos.execution.executionflow.TaskNode;

/**
 * @author Andreas Unger
 *
 */
public class TaskNodeComputationHelper {

	public void computeTaskNodes(ExecutionFlow executionFlow) {
		Graph graph = executionFlow.getGraph();
		
		List<ComponentNode> asynchronousNodes = new LinkedList<ComponentNode>();
		for (Node node : graph.getNodes()) {
			if (node instanceof ComponentNode) {
				ComponentNode componentNode = (ComponentNode) node;
				if (isValidAsynchronousNode(componentNode)) {
					asynchronousNodes.add(componentNode);
				}
			}
		}
		
		if (asynchronousNodes.isEmpty()) {
			return;
		}
		
		Map<Node, TaskNode> taskNodes = new HashMap<Node, TaskNode>();

		for (Iterator<ComponentNode> it = asynchronousNodes.iterator(); it.hasNext();) {
			ComponentNode next = it.next();
			if (next.getComponent().getTimingConstraint() instanceof AsynchronousTimingConstraint) {
				TaskNode taskNode = ExecutionFlowFactory.eINSTANCE.createTaskNode();
				taskNode.getNodes().add(next);
				executionFlow.getTaskNodes().add(taskNode);
				taskNodes.put(next, taskNode);
				it.remove();
			}
		}
		
		while (!asynchronousNodes.isEmpty()) {
			boolean changed;
			do {
				changed = false;
				for (Iterator<ComponentNode> it = asynchronousNodes.iterator(); it.hasNext();) {
					Node node = it.next();
					
					TaskNode taskNode = computeTaskNode(executionFlow, taskNodes, node.getDrivingNodes());
					if (taskNode == null) {
						taskNode = computeTaskNode(executionFlow, taskNodes, node.getDrivenNodes());
					}

					if (taskNode != null) {
						taskNode.getNodes().add(node);
						taskNodes.put(node, taskNode);
						it.remove();
						changed = true;
					}
				}
			} while (changed);
			
			// If nothing changed, we ran into a loop.
			// Simply pick any component node and create a task node for it,
			// and then try again.
			if (!changed && !asynchronousNodes.isEmpty()) {
				ComponentNode node = asynchronousNodes.remove(0);
				TaskNode taskNode = ExecutionFlowFactory.eINSTANCE.createTaskNode();
				taskNode.getNodes().add(node);
				executionFlow.getTaskNodes().add(taskNode);
				taskNodes.put(node, taskNode);
			}
		}
	}

	private TaskNode computeTaskNode(ExecutionFlow executionFlow, Map<Node, TaskNode> taskNodes, EList<Node> drivingNodes) {
		TaskNode taskNode = null;
		for (Node sourceNode : drivingNodes) {
			if (!(sourceNode instanceof ComponentNode)) {
				continue;
			}
			if (!isValidAsynchronousNode((ComponentNode) sourceNode)) {
				continue;
			}
			TaskNode otherTaskNode = taskNodes.get(sourceNode);
			if (otherTaskNode == null) {
				continue;
			}
			if (taskNode == null) {
				taskNode = otherTaskNode;
			} else if (taskNode != otherTaskNode) {
				taskNode = ExecutionFlowFactory.eINSTANCE.createTaskNode();
				executionFlow.getTaskNodes().add(taskNode);
				break;
			}
		}
		return taskNode;
	}
	
	/**
	 * @param componentNode
	 * @return
	 */
	private boolean isValidAsynchronousNode(ComponentNode componentNode) {
		return componentNode.getSampleTime() == Double.POSITIVE_INFINITY
				&& !(componentNode.getComponent() instanceof Latch);
	}
	
}
