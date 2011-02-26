/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.execution.executionflow;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipselabs.damos.dml.InputConnector;
import org.eclipselabs.damos.dml.OutputConnector;
import org.eclipselabs.damos.dml.Subsystem;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.execution.executionflow.Node#getIncomingEdges <em>Incoming Edges</em>}</li>
 *   <li>{@link org.eclipselabs.damos.execution.executionflow.Node#getOutgoingEdges <em>Outgoing Edges</em>}</li>
 *   <li>{@link org.eclipselabs.damos.execution.executionflow.Node#getEnclosingSubsystems <em>Enclosing Subsystems</em>}</li>
 *   <li>{@link org.eclipselabs.damos.execution.executionflow.Node#getIncomingDataFlows <em>Incoming Data Flows</em>}</li>
 *   <li>{@link org.eclipselabs.damos.execution.executionflow.Node#getOutgoingDataFlows <em>Outgoing Data Flows</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.execution.executionflow.ExecutionFlowPackage#getNode()
 * @model abstract="true"
 * @generated
 */
public interface Node extends EObject {
	/**
	 * Returns the value of the '<em><b>Incoming Edges</b></em>' reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.execution.executionflow.Edge}.
	 * It is bidirectional and its opposite is '{@link org.eclipselabs.damos.execution.executionflow.Edge#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incoming Edges</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming Edges</em>' reference list.
	 * @see org.eclipselabs.damos.execution.executionflow.ExecutionFlowPackage#getNode_IncomingEdges()
	 * @see org.eclipselabs.damos.execution.executionflow.Edge#getTarget
	 * @model opposite="target"
	 * @generated
	 */
	EList<Edge> getIncomingEdges();

	/**
	 * Returns the value of the '<em><b>Outgoing Edges</b></em>' reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.execution.executionflow.Edge}.
	 * It is bidirectional and its opposite is '{@link org.eclipselabs.damos.execution.executionflow.Edge#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoing Edges</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing Edges</em>' reference list.
	 * @see org.eclipselabs.damos.execution.executionflow.ExecutionFlowPackage#getNode_OutgoingEdges()
	 * @see org.eclipselabs.damos.execution.executionflow.Edge#getSource
	 * @model opposite="source"
	 * @generated
	 */
	EList<Edge> getOutgoingEdges();

	/**
	 * Returns the value of the '<em><b>Enclosing Subsystems</b></em>' reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.dml.Subsystem}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enclosing Subsystems</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enclosing Subsystems</em>' reference list.
	 * @see org.eclipselabs.damos.execution.executionflow.ExecutionFlowPackage#getNode_EnclosingSubsystems()
	 * @model
	 * @generated
	 */
	EList<Subsystem> getEnclosingSubsystems();

	/**
	 * Returns the value of the '<em><b>Incoming Data Flows</b></em>' reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.execution.executionflow.DataFlowTargetEnd}.
	 * It is bidirectional and its opposite is '{@link org.eclipselabs.damos.execution.executionflow.DataFlowTargetEnd#getNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incoming Data Flows</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming Data Flows</em>' reference list.
	 * @see org.eclipselabs.damos.execution.executionflow.ExecutionFlowPackage#getNode_IncomingDataFlows()
	 * @see org.eclipselabs.damos.execution.executionflow.DataFlowTargetEnd#getNode
	 * @model opposite="node"
	 * @generated
	 */
	EList<DataFlowTargetEnd> getIncomingDataFlows();

	/**
	 * Returns the value of the '<em><b>Outgoing Data Flows</b></em>' reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.execution.executionflow.DataFlowSourceEnd}.
	 * It is bidirectional and its opposite is '{@link org.eclipselabs.damos.execution.executionflow.DataFlowSourceEnd#getNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoing Data Flows</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing Data Flows</em>' reference list.
	 * @see org.eclipselabs.damos.execution.executionflow.ExecutionFlowPackage#getNode_OutgoingDataFlows()
	 * @see org.eclipselabs.damos.execution.executionflow.DataFlowSourceEnd#getNode
	 * @model opposite="node"
	 * @generated
	 */
	EList<DataFlowSourceEnd> getOutgoingDataFlows();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ordered="false" targetRequired="true" targetOrdered="false"
	 * @generated
	 */
	DataFlowTargetEnd getIncomingDataFlow(InputConnector target);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ordered="false" sourceRequired="true" sourceOrdered="false"
	 * @generated
	 */
	DataFlowSourceEnd getOutgoingDataFlow(OutputConnector source);

} // Node
