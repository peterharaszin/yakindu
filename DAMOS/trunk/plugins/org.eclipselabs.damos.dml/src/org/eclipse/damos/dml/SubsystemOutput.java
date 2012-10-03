/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.damos.dml;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Subsystem Output</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.damos.dml.SubsystemOutput#getOutlet <em>Outlet</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.damos.dml.DMLPackage#getSubsystemOutput()
 * @model
 * @generated
 */
public interface SubsystemOutput extends Output, SubsystemInoutput {
	/**
	 * Returns the value of the '<em><b>Outlet</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outlet</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outlet</em>' reference.
	 * @see #setOutlet(Outlet)
	 * @see org.eclipse.damos.dml.DMLPackage#getSubsystemOutput_Outlet()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Outlet getOutlet();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.dml.SubsystemOutput#getOutlet <em>Outlet</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Outlet</em>' reference.
	 * @see #getOutlet()
	 * @generated
	 */
	void setOutlet(Outlet value);

} // SubsystemOutput
