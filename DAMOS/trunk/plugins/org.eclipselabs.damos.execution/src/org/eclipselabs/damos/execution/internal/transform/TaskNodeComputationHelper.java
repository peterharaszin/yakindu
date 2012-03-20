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

package org.eclipselabs.damos.execution.internal.transform;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.damos.dml.Latch;
import org.eclipselabs.damos.execution.ComponentNode;
import org.eclipselabs.damos.execution.DataFlow;
import org.eclipselabs.damos.execution.DataFlowSourceEnd;
import org.eclipselabs.damos.execution.DataFlowTargetEnd;
import org.eclipselabs.damos.execution.Edge;
import org.eclipselabs.damos.execution.ExecutionFactory;
import org.eclipselabs.damos.execution.ExecutionFlow;
import org.eclipselabs.damos.execution.Graph;
import org.eclipselabs.damos.execution.LatchNode;
import org.eclipselabs.damos.execution.Node;
import org.eclipselabs.damos.execution.TaskGraph;
import org.eclipselabs.damos.execution.TaskInputNode;

/**
 * @author Andreas Unger
 *
 */
public class TaskNodeComputationHelper {

	public void computeTaskNodes(ExecutionFlow executionFlow) throws CoreException {
		if (executionFlow.getAsynchronousZoneCount() == 0) {
			return;
		}
		
		Graph graph = executionFlow.getGraph();

		for (int i = 0; i < executionFlow.getAsynchronousZoneCount(); ++i) {
			executionFlow.getTaskGraphs().add(ExecutionFactory.eINSTANCE.createTaskGraph());
		}
		
		List<ComponentNode> asynchronousNodes = new LinkedList<ComponentNode>();
		for (Iterator<Node> it = graph.getAllNodesIterator(); it.hasNext();) {
			Node node = it.next();
			if (node instanceof ComponentNode) {
				ComponentNode componentNode = (ComponentNode) node;
				if (componentNode.getAsynchronousZone() >= 0 && !(componentNode.getComponent() instanceof Latch)) {
					asynchronousNodes.add(componentNode);
				}
			}
		}
		
		for (ComponentNode node : asynchronousNodes) {
			executionFlow.getTaskGraphs().get(node.getAsynchronousZone()).getNodes().add(node);
		}
		
		// Delete edges
		for (TaskGraph taskGraph : executionFlow.getTaskGraphs()) {
			for (Node node : taskGraph.getNodes()) {
				if (node.getIncomingEdges().isEmpty()) {
					taskGraph.getInitialNodes().add(node);
				} else {
					for (Edge edge : new ArrayList<Edge>(node.getIncomingEdges())) {
						Node source = edge.getSource();
						if (!source.isEnclosedBy(taskGraph)) {
							deleteEdge(edge);
							taskGraph.getInitialNodes().add(node);
						}
					}
				}
				for (Edge edge : new ArrayList<Edge>(node.getOutgoingEdges())) {
					Node target = edge.getTarget();
					if (!target.isEnclosedBy(taskGraph)) {
						deleteEdge(edge);
						target.getGraph().getInitialNodes().add(target);
					}
				}
			}
		}
		
		// Attach latch nodes to task nodes and create task input nodes
		for (TaskGraph taskGraph : executionFlow.getTaskGraphs()) {
			List<DataFlowTargetEnd> targetEnds = new ArrayList<DataFlowTargetEnd>();
			for (Node node : taskGraph.getNodes()) {
				for (DataFlowTargetEnd targetEnd : node.getIncomingDataFlows()) {
					Node sourceNode = targetEnd.getSourceEnd().getNode();
					if (!sourceNode.isEnclosedBy(taskGraph)) {
						if (sourceNode instanceof LatchNode) {
							taskGraph.getLatchNodes().add((LatchNode) sourceNode);
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
						inputNode = ExecutionFactory.eINSTANCE.createTaskInputNode();
						DataFlow inputDataFlow = ExecutionFactory.eINSTANCE.createDataFlow();
						DataFlowSourceEnd sourceEnd = ExecutionFactory.eINSTANCE.createDataFlowSourceEnd();
	
						sourceEnd.setNode(inputNode);
						inputDataFlow.setSourceEnd(sourceEnd);
						taskGraph.getInputNodes().add(inputNode);

						executionFlow.getDataFlows().add(inputDataFlow);
						inputNodes.put(targetEnd.getDataFlow(), inputNode);
					}
					
					DataFlowTargetEnd newTargetEnd = ExecutionFactory.eINSTANCE.createDataFlowTargetEnd();
					newTargetEnd.setNode(inputNode);
					EcoreUtil.replace(targetEnd, newTargetEnd);

					DataFlow inputDataFlow = inputNode.getOutgoingDataFlows().get(0).getDataFlow();
					inputDataFlow.getTargetEnds().add(targetEnd);
				}
			}
		}
	}
	
	private void deleteEdge(Edge edge) {
		edge.getSource().getOutgoingEdges().remove(edge);
		edge.getTarget().getIncomingEdges().remove(edge);
		edge.getGraph().getEdges().remove(edge);
	}

}
