/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dml;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Connection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.dml.Connection#getSourcePort <em>Source Port</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dml.Connection#getTargetPort <em>Target Port</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.dml.DMLPackage#getConnection()
 * @model
 * @generated
 */
public interface Connection extends FragmentElement {
	/**
	 * Returns the value of the '<em><b>Source Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Port</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Port</em>' reference.
	 * @see #setSourcePort(OutputPort)
	 * @see org.eclipselabs.damos.dml.DMLPackage#getConnection_SourcePort()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	OutputPort getSourcePort();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.dml.Connection#getSourcePort <em>Source Port</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Port</em>' reference.
	 * @see #getSourcePort()
	 * @generated
	 */
	void setSourcePort(OutputPort value);

	/**
	 * Returns the value of the '<em><b>Target Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Port</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Port</em>' reference.
	 * @see #setTargetPort(InputPort)
	 * @see org.eclipselabs.damos.dml.DMLPackage#getConnection_TargetPort()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	InputPort getTargetPort();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.dml.Connection#getTargetPort <em>Target Port</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Port</em>' reference.
	 * @see #getTargetPort()
	 * @generated
	 */
	void setTargetPort(InputPort value);

} // Connection
