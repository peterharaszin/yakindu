/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.damos.dml;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>While Loop</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.damos.dml.WhileLoop#getCondition <em>Condition</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.damos.dml.DMLPackage#getWhileLoop()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='ConditionSourceInWhileLoop'"
 * @generated
 */
public interface WhileLoop extends Action {
	/**
	 * Returns the value of the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' containment reference.
	 * @see #setCondition(WhileLoopCondition)
	 * @see org.eclipse.damos.dml.DMLPackage#getWhileLoop_Condition()
	 * @model containment="true"
	 * @generated
	 */
	WhileLoopCondition getCondition();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.dml.WhileLoop#getCondition <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' containment reference.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(WhileLoopCondition value);

} // WhileLoop
