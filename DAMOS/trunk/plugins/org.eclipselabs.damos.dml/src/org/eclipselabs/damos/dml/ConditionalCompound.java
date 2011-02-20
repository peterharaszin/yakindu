/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dml;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Conditional Compound</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.dml.ConditionalCompound#getCondition <em>Condition</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.dml.DMLPackage#getConditionalCompound()
 * @model
 * @generated
 */
public interface ConditionalCompound extends Compound {
	/**
	 * Returns the value of the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' containment reference.
	 * @see #setCondition(ConditionalCompoundCondition)
	 * @see org.eclipselabs.damos.dml.DMLPackage#getConditionalCompound_Condition()
	 * @model containment="true"
	 * @generated
	 */
	ConditionalCompoundCondition getCondition();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.dml.ConditionalCompound#getCondition <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' containment reference.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(ConditionalCompoundCondition value);

} // ConditionalCompound
