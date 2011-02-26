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

package org.eclipselabs.damos.execution.executionflow.internal.operations;

import org.eclipselabs.damos.dml.InputConnector;
import org.eclipselabs.damos.dml.OutputConnector;
import org.eclipselabs.damos.execution.executionflow.DataFlowSourceEnd;
import org.eclipselabs.damos.execution.executionflow.DataFlowTargetEnd;
import org.eclipselabs.damos.execution.executionflow.Node;

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

} // NodeOperations