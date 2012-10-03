/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.damos.dml;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Connection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.damos.dml.Connection#getSource <em>Source</em>}</li>
 *   <li>{@link org.eclipse.damos.dml.Connection#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.damos.dml.DMLPackage#getConnection()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='ValidCompoundConnection'"
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
	 * @see org.eclipse.damos.dml.DMLPackage#getConnection_Source()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	OutputConnector getSource();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.dml.Connection#getSource <em>Source</em>}' reference.
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
	 * @see org.eclipse.damos.dml.DMLPackage#getConnection_Target()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	InputConnector getTarget();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.dml.Connection#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(InputConnector value);

} // Connection
