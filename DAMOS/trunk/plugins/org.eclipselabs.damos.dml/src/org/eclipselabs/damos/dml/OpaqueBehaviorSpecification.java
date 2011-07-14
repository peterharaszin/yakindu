/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dml;

import org.eclipse.emf.ecore.EObject;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Opaque Behavior Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.dml.OpaqueBehaviorSpecification#getBehavior <em>Behavior</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dml.OpaqueBehaviorSpecification#getModel <em>Model</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.dml.DMLPackage#getOpaqueBehaviorSpecification()
 * @model
 * @generated
 */
public interface OpaqueBehaviorSpecification extends BehaviorSpecification, ITextualElement {
	/**
	 * Returns the value of the '<em><b>Behavior</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Behavior</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Behavior</em>' attribute.
	 * @see #setBehavior(String)
	 * @see org.eclipselabs.damos.dml.DMLPackage#getOpaqueBehaviorSpecification_Behavior()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getBehavior();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.dml.OpaqueBehaviorSpecification#getBehavior <em>Behavior</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Behavior</em>' attribute.
	 * @see #getBehavior()
	 * @generated
	 */
	void setBehavior(String value);

	/**
	 * Returns the value of the '<em><b>Model</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model</em>' containment reference.
	 * @see #setModel(EObject)
	 * @see org.eclipselabs.damos.dml.DMLPackage#getOpaqueBehaviorSpecification_Model()
	 * @model containment="true" transient="true" derived="true"
	 * @generated
	 */
	EObject getModel();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.dml.OpaqueBehaviorSpecification#getModel <em>Model</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model</em>' containment reference.
	 * @see #getModel()
	 * @generated
	 */
	void setModel(EObject value);

} // OpaqueBehaviorSpecification
