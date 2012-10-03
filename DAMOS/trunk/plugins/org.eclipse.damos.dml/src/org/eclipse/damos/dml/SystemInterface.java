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
 * A representation of the model object '<em><b>System Interface</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.damos.dml.SystemInterface#getInlets <em>Inlets</em>}</li>
 *   <li>{@link org.eclipse.damos.dml.SystemInterface#getOutlets <em>Outlets</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.damos.dml.DMLPackage#getSystemInterface()
 * @model
 * @generated
 */
public interface SystemInterface extends QualifiedElement {
	/**
	 * Returns the value of the '<em><b>Inlets</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.damos.dml.Inlet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inlets</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inlets</em>' containment reference list.
	 * @see org.eclipse.damos.dml.DMLPackage#getSystemInterface_Inlets()
	 * @model containment="true"
	 * @generated
	 */
	EList<Inlet> getInlets();

	/**
	 * Returns the value of the '<em><b>Outlets</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.damos.dml.Outlet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outlets</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outlets</em>' containment reference list.
	 * @see org.eclipse.damos.dml.DMLPackage#getSystemInterface_Outlets()
	 * @model containment="true"
	 * @generated
	 */
	EList<Outlet> getOutlets();

} // SystemInterface
