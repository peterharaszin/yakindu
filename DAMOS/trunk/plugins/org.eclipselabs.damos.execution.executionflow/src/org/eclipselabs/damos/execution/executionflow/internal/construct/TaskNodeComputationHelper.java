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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.damos.dml.Latch;
import org.eclipselabs.damos.execution.executionflow.ComponentNode;
import org.eclipselabs.damos.execution.executionflow.DataFlow;
import org.eclipselabs.damos.execution.executionflow.DataFlowSourceEnd;
import org.eclipselabs.damos.execution.executionflow.DataFlowTargetEnd;
import org.eclipselabs.damos.execution.executionflow.Edge;
import org.eclipselabs.damos.execution.executionflow.ExecutionFlow;
import org.eclipselabs.damos.execution.executionflow.ExecutionFlowFactory;
import org.eclipselabs.damos.execution.executionflow.Graph;
import org.eclipselabs.damos.execution.executionflow.LatchNode;
import org.eclipselabs.damos.execution.executionflow.Node;
import org.eclipselabs.damos.execution.executionflow.TaskInputNode;
import org.eclipselabs.damos.execution.executionflow.TaskNode;

/**
 * @author Andreas Unger
 *
 */
public class TaskNodeComputationHelper {

	public void computeTaskNodes(ExecutionFlow executionFlow) throws CoreException {
		Graph graph = executionFlow.getGraph();
		
		List<TaskNode> taskNodes = new ArrayList<TaskNode>();
		List<ComponentNode> asynchronousNodes = new ArrayList<ComponentNode>();

		for (TreeIterator<Node> it = graph.getAllNodes(); it.hasNext();) {
			Node next = it.next();
			if (next instanceof TaskNode) {
				taskNodes.add((TaskNode) next);
				it.prune();
			} else if (next instanceof ComponentNode) {
				ComponentNode componentNode = (ComponentNode) next;
				if (isValidAsynchronousNode(componentNode)) {
					asynchronousNodes.add(componentNode);
				}
			}
		}
		
		for (TaskNode taskNode : taskNodes) {
			executionFlow.getTaskNodes().add(taskNode);
		}
		
		for (ComponentNode asynchronousNode : asynchronousNodes) {
			asynchronousNode.getGraph().getInitialNodes().remove(asynchronousNode);

			TaskNode taskNode = ExecutionFlowFactory.eINSTANCE.createTaskNode();
			taskNode.getNodes().add(asynchronousNode);
			taskNode.getInitialNodes().add(asynchronousNode);
			executionFlow.getTaskNodes().add(taskNode);

			for (Edge edge : new ArrayList<Edge>(asynchronousNode.getIncomingEdges())) {
				edge.setTarget(taskNode);
			}
			for (Edge edge : new ArrayList<Edge>(asynchronousNode.getOutgoingEdges())) {
				edge.setSource(taskNode);
			}
		}
		
		// Attach latch nodes to task nodes and create task input nodes
		for (TaskNode taskNode : executionFlow.getTaskNodes()) {
			List<DataFlowTargetEnd> targetEnds = new ArrayList<DataFlowTargetEnd>();
			for (Node node : taskNode.getNodes()) {
				for (DataFlowTargetEnd targetEnd : node.getIncomingDataFlows()) {
					Node sourceNode = targetEnd.getSourceEnd().getNode();
					if (!sourceNode.isEnclosedBy(taskNode)) {
						if (sourceNode instanceof LatchNode) {
							taskNode.getLatchNodes().add((LatchNode) sourceNode);
						} else {
							targetEnds.add(targetEnd);
						}
					}
				}
			}
			
			if (!targetEnds.isEmpty()) {
				Map<DataFlow, TaskInputNode> inputNodes = new HashMap<DataFlow, TaskInputNode>();
				for (DataFlowTargetEnd targetEnd : targetEnds) {
					TaskInputNode inputNode = inputNodes.get(targetEnd.getDataFlow());
					if (inputNode == null) {
						inputNode = ExecutionFlowFactory.eINSTANCE.createTaskInputNode();
						DataFlow inputDataFlow = ExecutionFlowFactory.eINSTANCE.createDataFlow();
						DataFlowSourceEnd sourceEnd = ExecutionFlowFactory.eINSTANCE.createDataFlowSourceEnd();
	
						sourceEnd.setNode(inputNode);
						inputDataFlow.setSourceEnd(sourceEnd);
						taskNode.getInputNodes().add(inputNode);

						executionFlow.getDataFlows().add(inputDataFlow);
						inputNodes.put(targetEnd.getDataFlow(), inputNode);
					}
					
					DataFlowTargetEnd newTargetEnd = ExecutionFlowFactory.eINSTANCE.createDataFlowTargetEnd();
					newTargetEnd.setNode(inputNode);
					EcoreUtil.replace(targetEnd, newTargetEnd);

					DataFlow inputDataFlow = inputNode.getOutgoingDataFlows().get(0).getDataFlow();
					inputDataFlow.getTargetEnds().add(targetEnd);
				}
			}
		}
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
