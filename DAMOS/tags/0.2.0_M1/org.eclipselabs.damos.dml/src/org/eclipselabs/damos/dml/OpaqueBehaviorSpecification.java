/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dml;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Opaque Behavior Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.dml.OpaqueBehaviorSpecification#getBehavior <em>Behavior</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.dml.DMLPackage#getOpaqueBehaviorSpecification()
 * @model
 * @generated
 */
public interface OpaqueBehaviorSpecification extends BehaviorSpecification {
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

} // OpaqueBehaviorSpecification
