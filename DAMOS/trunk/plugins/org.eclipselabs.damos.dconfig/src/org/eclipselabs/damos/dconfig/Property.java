/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dconfig;

import org.eclipse.emf.ecore.EObject;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.dconfig.Property#isPropagate <em>Propagate</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.dconfig.DconfigPackage#getProperty()
 * @model abstract="true"
 * @generated
 */
public interface Property extends EObject {
	/**
	 * Returns the value of the '<em><b>Propagate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Propagate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Propagate</em>' attribute.
	 * @see #setPropagate(boolean)
	 * @see org.eclipselabs.damos.dconfig.DconfigPackage#getProperty_Propagate()
	 * @model
	 * @generated
	 */
	boolean isPropagate();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.dconfig.Property#isPropagate <em>Propagate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Propagate</em>' attribute.
	 * @see #isPropagate()
	 * @generated
	 */
	void setPropagate(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	String getId();

} // Property
