/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.damos.execution;

import org.eclipse.damos.dml.InputConnector;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Flow Target End</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.damos.execution.DataFlowTargetEnd#getNode <em>Node</em>}</li>
 *   <li>{@link org.eclipse.damos.execution.DataFlowTargetEnd#getDataFlow <em>Data Flow</em>}</li>
 *   <li>{@link org.eclipse.damos.execution.DataFlowTargetEnd#getConnector <em>Connector</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.damos.execution.ExecutionPackage#getDataFlowTargetEnd()
 * @model
 * @generated
 */
public interface DataFlowTargetEnd extends DataFlowEnd {
	/**
	 * Returns the value of the '<em><b>Node</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.damos.execution.Node#getIncomingDataFlows <em>Incoming Data Flows</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Node</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Node</em>' reference.
	 * @see #setNode(Node)
	 * @see org.eclipse.damos.execution.ExecutionPackage#getDataFlowTargetEnd_Node()
	 * @see org.eclipse.damos.execution.Node#getIncomingDataFlows
	 * @model opposite="incomingDataFlows" required="true" ordered="false"
	 * @generated
	 */
	Node getNode();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.execution.DataFlowTargetEnd#getNode <em>Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Node</em>' reference.
	 * @see #getNode()
	 * @generated
	 */
	void setNode(Node value);

	/**
	 * Returns the value of the '<em><b>Data Flow</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.damos.execution.DataFlow#getTargetEnds <em>Target Ends</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Flow</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Flow</em>' container reference.
	 * @see #setDataFlow(DataFlow)
	 * @see org.eclipse.damos.execution.ExecutionPackage#getDataFlowTargetEnd_DataFlow()
	 * @see org.eclipse.damos.execution.DataFlow#getTargetEnds
	 * @model opposite="targetEnds" required="true" transient="false" ordered="false"
	 * @generated
	 */
	DataFlow getDataFlow();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.execution.DataFlowTargetEnd#getDataFlow <em>Data Flow</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Flow</em>' container reference.
	 * @see #getDataFlow()
	 * @generated
	 */
	void setDataFlow(DataFlow value);

	/**
	 * Returns the value of the '<em><b>Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connector</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connector</em>' reference.
	 * @see #setConnector(InputConnector)
	 * @see org.eclipse.damos.execution.ExecutionPackage#getDataFlowTargetEnd_Connector()
	 * @model ordered="false"
	 * @generated
	 */
	InputConnector getConnector();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.execution.DataFlowTargetEnd#getConnector <em>Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Connector</em>' reference.
	 * @see #getConnector()
	 * @generated
	 */
	void setConnector(InputConnector value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	DataFlowSourceEnd getSourceEnd();

} // DataFlowTargetEnd
