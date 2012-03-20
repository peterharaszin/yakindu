/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.execution;

import org.eclipse.emf.ecore.EObject;
import org.eclipselabs.damos.dml.Connector;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Flow End</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.execution.DataFlowEnd#getConnectorInfo <em>Connector Info</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.execution.ExecutionPackage#getDataFlowEnd()
 * @model abstract="true"
 * @generated
 */
public interface DataFlowEnd extends EObject {

	/**
	 * Returns the value of the '<em><b>Connector Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connector Info</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connector Info</em>' containment reference.
	 * @see #setConnectorInfo(ConnectorInfo)
	 * @see org.eclipselabs.damos.execution.ExecutionPackage#getDataFlowEnd_ConnectorInfo()
	 * @model containment="true"
	 * @generated
	 */
	ConnectorInfo getConnectorInfo();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.execution.DataFlowEnd#getConnectorInfo <em>Connector Info</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Connector Info</em>' containment reference.
	 * @see #getConnectorInfo()
	 * @generated
	 */
	void setConnectorInfo(ConnectorInfo value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	Node getNode();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	DataFlow getDataFlow();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	Connector getConnector();

} // DataFlowEnd
