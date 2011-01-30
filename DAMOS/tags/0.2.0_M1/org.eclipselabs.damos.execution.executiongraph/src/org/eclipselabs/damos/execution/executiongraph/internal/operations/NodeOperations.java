/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.execution.executiongraph.internal.operations;

import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.dml.OutputPort;
import org.eclipselabs.damos.execution.executiongraph.DataFlowSourceEnd;
import org.eclipselabs.damos.execution.executiongraph.DataFlowTargetEnd;
import org.eclipselabs.damos.execution.executiongraph.Node;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Node</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.execution.executiongraph.Node#getIncomingDataFlow(org.eclipselabs.damos.dml.InputPort) <em>Get Incoming Data Flow</em>}</li>
 *   <li>{@link org.eclipselabs.damos.execution.executiongraph.Node#getOutgoingDataFlow(org.eclipselabs.damos.dml.OutputPort) <em>Get Outgoing Data Flow</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
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
	public static  DataFlowTargetEnd getIncomingDataFlow(Node node, InputPort inputPort) {
		for (DataFlowTargetEnd targetEnd : node.getIncomingDataFlows()) {
			if (targetEnd.getPort() == inputPort) {
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
	public static  DataFlowSourceEnd getOutgoingDataFlow(Node node, OutputPort outputPort) {
		for (DataFlowSourceEnd sourceEnd : node.getOutgoingDataFlows()) {
			if (sourceEnd.getPort() == outputPort) {
				return sourceEnd;
			}
		}
		return null;
	}

} // NodeOperations