/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.mscript;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable Access</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.mscript.VariableReference#getStepExpression <em>Step Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.mscript.MscriptPackage#getVariableReference()
 * @model
 * @generated
 */
public interface VariableReference extends FeatureCall {
	/**
	 * Returns the value of the '<em><b>Step Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Step Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Step Expression</em>' containment reference.
	 * @see #setStepExpression(StepExpression)
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#getVariableReference_StepExpression()
	 * @model containment="true"
	 * @generated
	 */
	StepExpression getStepExpression();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.mscript.VariableReference#getStepExpression <em>Step Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Step Expression</em>' containment reference.
	 * @see #getStepExpression()
	 * @generated
	 */
	void setStepExpression(StepExpression value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	boolean isInitial();

} // VariableAccess
