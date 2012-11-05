/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.damos.dconfig;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Binding Resource Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.damos.dconfig.BindingResourceReference#getResourceDeclaration <em>Resource Declaration</em>}</li>
 *   <li>{@link org.eclipse.damos.dconfig.BindingResourceReference#getSubscript <em>Subscript</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.damos.dconfig.DconfigPackage#getBindingResourceReference()
 * @model
 * @generated
 */
public interface BindingResourceReference extends EObject {
	/**
	 * Returns the value of the '<em><b>Resource Declaration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource Declaration</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource Declaration</em>' reference.
	 * @see #setResourceDeclaration(ResourceDeclaration)
	 * @see org.eclipse.damos.dconfig.DconfigPackage#getBindingResourceReference_ResourceDeclaration()
	 * @model
	 * @generated
	 */
	ResourceDeclaration getResourceDeclaration();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.dconfig.BindingResourceReference#getResourceDeclaration <em>Resource Declaration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource Declaration</em>' reference.
	 * @see #getResourceDeclaration()
	 * @generated
	 */
	void setResourceDeclaration(ResourceDeclaration value);

	/**
	 * Returns the value of the '<em><b>Subscript</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subscript</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subscript</em>' containment reference.
	 * @see #isSetSubscript()
	 * @see #unsetSubscript()
	 * @see #setSubscript(BindingResourceSubscript)
	 * @see org.eclipse.damos.dconfig.DconfigPackage#getBindingResourceReference_Subscript()
	 * @model containment="true" unsettable="true"
	 * @generated
	 */
	BindingResourceSubscript getSubscript();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.dconfig.BindingResourceReference#getSubscript <em>Subscript</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Subscript</em>' containment reference.
	 * @see #isSetSubscript()
	 * @see #unsetSubscript()
	 * @see #getSubscript()
	 * @generated
	 */
	void setSubscript(BindingResourceSubscript value);

	/**
	 * Unsets the value of the '{@link org.eclipse.damos.dconfig.BindingResourceReference#getSubscript <em>Subscript</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSubscript()
	 * @see #getSubscript()
	 * @see #setSubscript(BindingResourceSubscript)
	 * @generated
	 */
	void unsetSubscript();

	/**
	 * Returns whether the value of the '{@link org.eclipse.damos.dconfig.BindingResourceReference#getSubscript <em>Subscript</em>}' containment reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Subscript</em>' containment reference is set.
	 * @see #unsetSubscript()
	 * @see #getSubscript()
	 * @see #setSubscript(BindingResourceSubscript)
	 * @generated
	 */
	boolean isSetSubscript();

} // BindingResourceReference
