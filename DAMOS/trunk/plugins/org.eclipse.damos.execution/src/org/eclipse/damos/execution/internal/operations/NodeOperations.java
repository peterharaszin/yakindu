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

package org.eclipse.damos.execution.internal.operations;

import org.eclipse.damos.dml.InputConnector;
import org.eclipse.damos.dml.OutputConnector;
import org.eclipse.damos.execution.DataFlowSourceEnd;
import org.eclipse.damos.execution.DataFlowTargetEnd;
import org.eclipse.damos.execution.Graph;
import org.eclipse.damos.execution.Node;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

public class NodeOperations {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NodeOperations() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static  DataFlowTargetEnd getIncomingDataFlow(Node node, InputConnector source) {
		for (DataFlowTargetEnd targetEnd : node.getIncomingDataFlows()) {
			if (targetEnd.getConnector() == source) {
				return targetEnd;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static  DataFlowSourceEnd getOutgoingDataFlow(Node node, OutputConnector target) {
		for (DataFlowSourceEnd sourceEnd : node.getOutgoingDataFlows()) {
			if (sourceEnd.getConnector() == target) {
				return sourceEnd;
			}
		}
		return null;
	}
	
	public static EList<Node> getDrivingNodes(Node node) {
		EList<Node> drivingNodes = new BasicEList<Node>();
		for (DataFlowTargetEnd targetEnd : node.getIncomingDataFlows()) {
			drivingNodes.add(targetEnd.getDataFlow().getSourceEnd().getNode());
		}
		return drivingNodes;
	}

	public static EList<Node> getDrivenNodes(Node node) {
		EList<Node> drivenNodes = new BasicEList<Node>();
		for (DataFlowSourceEnd sourceEnd : node.getOutgoingDataFlows()) {
			for (DataFlowTargetEnd targetEnd : sourceEnd.getDataFlow().getTargetEnds()) {
				drivenNodes.add(targetEnd.getNode());
			}
		}
		return drivenNodes;
	}

	public static EList<DataFlowSourceEnd> getDrivingEnds(Node node) {
		EList<DataFlowSourceEnd> drivingEnds = new BasicEList<DataFlowSourceEnd>();
		for (DataFlowTargetEnd targetEnd : node.getIncomingDataFlows()) {
			drivingEnds.add(targetEnd.getDataFlow().getSourceEnd());
		}
		return drivingEnds;
	}

	public static EList<DataFlowTargetEnd> getDrivenEnds(Node node) {
		EList<DataFlowTargetEnd> drivenEnds = new BasicEList<DataFlowTargetEnd>();
		for (DataFlowSourceEnd sourceEnd : node.getOutgoingDataFlows()) {
			for (DataFlowTargetEnd targetEnd : sourceEnd.getDataFlow().getTargetEnds()) {
				drivenEnds.add(targetEnd);
			}
		}
		return drivenEnds;
	}

	public static boolean isEnclosedBy(Node node, Graph graph) {
		EObject container = node.eContainer();
		while (container != null && container != graph) {
			container = container.eContainer();
		}
		return container != null;
	}

} // NodeOperations