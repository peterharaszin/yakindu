/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.damos.execution;

import org.eclipse.damos.dml.OutputConnector;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Flow Source End</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.damos.execution.DataFlowSourceEnd#getNode <em>Node</em>}</li>
 *   <li>{@link org.eclipse.damos.execution.DataFlowSourceEnd#getDataFlow <em>Data Flow</em>}</li>
 *   <li>{@link org.eclipse.damos.execution.DataFlowSourceEnd#getConnector <em>Connector</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.damos.execution.ExecutionPackage#getDataFlowSourceEnd()
 * @model
 * @generated
 */
public interface DataFlowSourceEnd extends DataFlowEnd {
	/**
	 * Returns the value of the '<em><b>Data Flow</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.damos.execution.DataFlow#getSourceEnd <em>Source End</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Flow</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Flow</em>' container reference.
	 * @see #setDataFlow(DataFlow)
	 * @see org.eclipse.damos.execution.ExecutionPackage#getDataFlowSourceEnd_DataFlow()
	 * @see org.eclipse.damos.execution.DataFlow#getSourceEnd
	 * @model opposite="sourceEnd" required="true" transient="false" ordered="false"
	 * @generated
	 */
	DataFlow getDataFlow();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.execution.DataFlowSourceEnd#getDataFlow <em>Data Flow</em>}' container reference.
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
	 * @see #setConnector(OutputConnector)
	 * @see org.eclipse.damos.execution.ExecutionPackage#getDataFlowSourceEnd_Connector()
	 * @model ordered="false"
	 * @generated
	 */
	OutputConnector getConnector();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.execution.DataFlowSourceEnd#getConnector <em>Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Connector</em>' reference.
	 * @see #getConnector()
	 * @generated
	 */
	void setConnector(OutputConnector value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	EList<DataFlowTargetEnd> getTargetEnds();

	/**
	 * Returns the value of the '<em><b>Node</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.damos.execution.Node#getOutgoingDataFlows <em>Outgoing Data Flows</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Node</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Node</em>' reference.
	 * @see #setNode(Node)
	 * @see org.eclipse.damos.execution.ExecutionPackage#getDataFlowSourceEnd_Node()
	 * @see org.eclipse.damos.execution.Node#getOutgoingDataFlows
	 * @model opposite="outgoingDataFlows" required="true" ordered="false"
	 * @generated
	 */
	Node getNode();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.execution.DataFlowSourceEnd#getNode <em>Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Node</em>' reference.
	 * @see #getNode()
	 * @generated
	 */
	void setNode(Node value);

} // DataFlowSourceEnd
