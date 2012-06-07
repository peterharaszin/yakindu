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
 * A representation of the model object '<em><b>Binding</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.dconfig.Binding#getTarget <em>Target</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dconfig.Binding#getSource <em>Source</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dconfig.Binding#getBody <em>Body</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.dconfig.DconfigPackage#getBinding()
 * @model
 * @generated
 */
public interface Binding extends EObject {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' containment reference.
	 * @see #setTarget(BindingResourceReference)
	 * @see org.eclipselabs.damos.dconfig.DconfigPackage#getBinding_Target()
	 * @model containment="true"
	 * @generated
	 */
	BindingResourceReference getTarget();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.dconfig.Binding#getTarget <em>Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' containment reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(BindingResourceReference value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' containment reference.
	 * @see #setSource(ComponentPath)
	 * @see org.eclipselabs.damos.dconfig.DconfigPackage#getBinding_Source()
	 * @model containment="true"
	 * @generated
	 */
	ComponentPath getSource();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.dconfig.Binding#getSource <em>Source</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' containment reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(ComponentPath value);

	/**
	 * Returns the value of the '<em><b>Body</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipselabs.damos.dconfig.BindingBody#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body</em>' containment reference.
	 * @see #setBody(BindingBody)
	 * @see org.eclipselabs.damos.dconfig.DconfigPackage#getBinding_Body()
	 * @see org.eclipselabs.damos.dconfig.BindingBody#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	BindingBody getBody();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.dconfig.Binding#getBody <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' containment reference.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(BindingBody value);

} // Binding
