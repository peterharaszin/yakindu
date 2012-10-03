/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.damos.execution;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Port Info</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.damos.execution.PortInfo#getInoutputIndex <em>Inoutput Index</em>}</li>
 *   <li>{@link org.eclipse.damos.execution.PortInfo#getPortIndex <em>Port Index</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.damos.execution.ExecutionPackage#getPortInfo()
 * @model
 * @generated
 */
public interface PortInfo extends ConnectorInfo {
	/**
	 * Returns the value of the '<em><b>Inoutput Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inoutput Index</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inoutput Index</em>' attribute.
	 * @see #setInoutputIndex(int)
	 * @see org.eclipse.damos.execution.ExecutionPackage#getPortInfo_InoutputIndex()
	 * @model required="true"
	 * @generated
	 */
	int getInoutputIndex();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.execution.PortInfo#getInoutputIndex <em>Inoutput Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inoutput Index</em>' attribute.
	 * @see #getInoutputIndex()
	 * @generated
	 */
	void setInoutputIndex(int value);

	/**
	 * Returns the value of the '<em><b>Port Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Port Index</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Port Index</em>' attribute.
	 * @see #setPortIndex(int)
	 * @see org.eclipse.damos.execution.ExecutionPackage#getPortInfo_PortIndex()
	 * @model required="true"
	 * @generated
	 */
	int getPortIndex();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.execution.PortInfo#getPortIndex <em>Port Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Port Index</em>' attribute.
	 * @see #getPortIndex()
	 * @generated
	 */
	void setPortIndex(int value);

} // PortInfo
