/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.execution.executiongraph;

import org.eclipselabs.damos.dml.OutputPort;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Flow Source End</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.execution.executiongraph.DataFlowSourceEnd#getPort <em>Port</em>}</li>
 *   <li>{@link org.eclipselabs.damos.execution.executiongraph.DataFlowSourceEnd#getDataFlow <em>Data Flow</em>}</li>
 *   <li>{@link org.eclipselabs.damos.execution.executiongraph.DataFlowSourceEnd#getNode <em>Node</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.execution.executiongraph.ExecutionGraphPackage#getDataFlowSourceEnd()
 * @model
 * @generated
 */
public interface DataFlowSourceEnd extends DataFlowEnd {
	/**
	 * Returns the value of the '<em><b>Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Port</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Port</em>' reference.
	 * @see #setPort(OutputPort)
	 * @see org.eclipselabs.damos.execution.executiongraph.ExecutionGraphPackage#getDataFlowSourceEnd_Port()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	OutputPort getPort();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.execution.executiongraph.DataFlowSourceEnd#getPort <em>Port</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Port</em>' reference.
	 * @see #getPort()
	 * @generated
	 */
	void setPort(OutputPort value);

	/**
	 * Returns the value of the '<em><b>Data Flow</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipselabs.damos.execution.executiongraph.DataFlow#getSourceEnd <em>Source End</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Flow</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Flow</em>' container reference.
	 * @see #setDataFlow(DataFlow)
	 * @see org.eclipselabs.damos.execution.executiongraph.ExecutionGraphPackage#getDataFlowSourceEnd_DataFlow()
	 * @see org.eclipselabs.damos.execution.executiongraph.DataFlow#getSourceEnd
	 * @model opposite="sourceEnd" required="true" transient="false" ordered="false"
	 * @generated
	 */
	DataFlow getDataFlow();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.execution.executiongraph.DataFlowSourceEnd#getDataFlow <em>Data Flow</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Flow</em>' container reference.
	 * @see #getDataFlow()
	 * @generated
	 */
	void setDataFlow(DataFlow value);

	/**
	 * Returns the value of the '<em><b>Node</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipselabs.damos.execution.executiongraph.Node#getOutgoingDataFlows <em>Outgoing Data Flows</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Node</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Node</em>' reference.
	 * @see #setNode(Node)
	 * @see org.eclipselabs.damos.execution.executiongraph.ExecutionGraphPackage#getDataFlowSourceEnd_Node()
	 * @see org.eclipselabs.damos.execution.executiongraph.Node#getOutgoingDataFlows
	 * @model opposite="outgoingDataFlows" required="true" ordered="false"
	 * @generated
	 */
	Node getNode();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.execution.executiongraph.DataFlowSourceEnd#getNode <em>Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Node</em>' reference.
	 * @see #getNode()
	 * @generated
	 */
	void setNode(Node value);

} // DataFlowSourceEnd
