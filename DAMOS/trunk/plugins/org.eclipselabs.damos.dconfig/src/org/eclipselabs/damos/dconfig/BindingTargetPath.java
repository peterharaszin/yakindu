/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dconfig;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Binding Target Path</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.dconfig.BindingTargetPath#getPropertyReferences <em>Property References</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dconfig.BindingTargetPath#getResource <em>Resource</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dconfig.BindingTargetPath#getSubscript <em>Subscript</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.dconfig.DconfigPackage#getBindingTargetPath()
 * @model
 * @generated
 */
public interface BindingTargetPath extends EObject {
	/**
	 * Returns the value of the '<em><b>Property References</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.dconfig.BindingPropertyReference}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property References</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property References</em>' containment reference list.
	 * @see org.eclipselabs.damos.dconfig.DconfigPackage#getBindingTargetPath_PropertyReferences()
	 * @model containment="true"
	 * @generated
	 */
	EList<BindingPropertyReference> getPropertyReferences();

	/**
	 * Returns the value of the '<em><b>Resource</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource</em>' reference.
	 * @see #setResource(ResourceDeclaration)
	 * @see org.eclipselabs.damos.dconfig.DconfigPackage#getBindingTargetPath_Resource()
	 * @model
	 * @generated
	 */
	ResourceDeclaration getResource();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.dconfig.BindingTargetPath#getResource <em>Resource</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource</em>' reference.
	 * @see #getResource()
	 * @generated
	 */
	void setResource(ResourceDeclaration value);

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
	 * @see #setSubscript(BindingSubscript)
	 * @see org.eclipselabs.damos.dconfig.DconfigPackage#getBindingTargetPath_Subscript()
	 * @model containment="true" unsettable="true"
	 * @generated
	 */
	BindingSubscript getSubscript();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.dconfig.BindingTargetPath#getSubscript <em>Subscript</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Subscript</em>' containment reference.
	 * @see #isSetSubscript()
	 * @see #unsetSubscript()
	 * @see #getSubscript()
	 * @generated
	 */
	void setSubscript(BindingSubscript value);

	/**
	 * Unsets the value of the '{@link org.eclipselabs.damos.dconfig.BindingTargetPath#getSubscript <em>Subscript</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSubscript()
	 * @see #getSubscript()
	 * @see #setSubscript(BindingSubscript)
	 * @generated
	 */
	void unsetSubscript();

	/**
	 * Returns whether the value of the '{@link org.eclipselabs.damos.dconfig.BindingTargetPath#getSubscript <em>Subscript</em>}' containment reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Subscript</em>' containment reference is set.
	 * @see #unsetSubscript()
	 * @see #getSubscript()
	 * @see #setSubscript(BindingSubscript)
	 * @generated
	 */
	boolean isSetSubscript();

} // BindingTargetPath
