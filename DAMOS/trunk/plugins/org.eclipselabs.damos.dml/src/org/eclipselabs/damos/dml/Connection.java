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
 *   <li>{@link org.eclipselabs.damos.dml.Connection#getSource <em>Source</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dml.Connection#getTarget <em>Target</em>}</li>
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
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(OutputConnector)
	 * @see org.eclipselabs.damos.dml.DMLPackage#getConnection_Source()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	OutputConnector getSource();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.dml.Connection#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(OutputConnector value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(InputConnector)
	 * @see org.eclipselabs.damos.dml.DMLPackage#getConnection_Target()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	InputConnector getTarget();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.dml.Connection#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(InputConnector value);

	/**
	 * Returns the value of the '<em><b>Source Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * @deprecated Use {@link #getSource()} instead.
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Port</em>' reference.
	 * @see #setSourcePort(OutputPort)
	 * @see org.eclipselabs.damos.dml.DMLPackage#getConnection_SourcePort()
	 * @model volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	@Deprecated
	OutputPort getSourcePort();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.dml.Connection#getSourcePort <em>Source Port</em>}' reference.
	 * <!-- begin-user-doc -->
	 * @deprecated Use {@link #setSource(ConnectableElement)} instead.
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Port</em>' reference.
	 * @see #getSourcePort()
	 * @generated
	 */
	@Deprecated
	void setSourcePort(OutputPort value);

	/**
	 * Returns the value of the '<em><b>Target Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * @deprecated Use {@link #getTarget()} instead.
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Port</em>' reference.
	 * @see #setTargetPort(InputPort)
	 * @see org.eclipselabs.damos.dml.DMLPackage#getConnection_TargetPort()
	 * @model volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	@Deprecated
	InputPort getTargetPort();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.dml.Connection#getTargetPort <em>Target Port</em>}' reference.
	 * <!-- begin-user-doc -->
	 * @deprecated Use {@link #setTarget(ConnectableElement value)} instead.
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Port</em>' reference.
	 * @see #getTargetPort()
	 * @generated
	 */
	@Deprecated
	void setTargetPort(InputPort value);

} // Connection
