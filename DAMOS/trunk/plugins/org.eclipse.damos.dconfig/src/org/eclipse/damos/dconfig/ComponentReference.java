/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.damos.dconfig;

import org.eclipse.damos.dml.Component;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Binding Component Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.damos.dconfig.ComponentReference#getComponent <em>Component</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.damos.dconfig.DconfigPackage#getComponentReference()
 * @model
 * @generated
 */
public interface ComponentReference extends EObject {
	/**
	 * Returns the value of the '<em><b>Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Component</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Component</em>' reference.
	 * @see #setComponent(Component)
	 * @see org.eclipse.damos.dconfig.DconfigPackage#getComponentReference_Component()
	 * @model
	 * @generated
	 */
	Component getComponent();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.dconfig.ComponentReference#getComponent <em>Component</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Component</em>' reference.
	 * @see #getComponent()
	 * @generated
	 */
	void setComponent(Component value);

} // BindingComponentReference
