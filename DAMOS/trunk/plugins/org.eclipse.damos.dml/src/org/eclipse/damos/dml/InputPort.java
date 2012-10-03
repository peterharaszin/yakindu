/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.damos.dml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Input Port</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.damos.dml.InputPort#getInput <em>Input</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.damos.dml.DMLPackage#getInputPort()
 * @model
 * @generated
 */
public interface InputPort extends Port, InputConnector {
	/**
	 * Returns the value of the '<em><b>Input</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.damos.dml.Input#getPorts <em>Ports</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input</em>' container reference.
	 * @see #setInput(Input)
	 * @see org.eclipse.damos.dml.DMLPackage#getInputPort_Input()
	 * @see org.eclipse.damos.dml.Input#getPorts
	 * @model opposite="ports" required="true" transient="false" ordered="false"
	 * @generated
	 */
	Input getInput();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.dml.InputPort#getInput <em>Input</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input</em>' container reference.
	 * @see #getInput()
	 * @generated
	 */
	void setInput(Input value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" ordered="false"
	 * @generated
	 */
	@Deprecated
	EList<Connection> getIncomingConnections();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false" contextRequired="true" contextOrdered="false"
	 * @generated
	 */
	@Deprecated
	Connection getIncomingConnection(Fragment context);

} // InputPort
