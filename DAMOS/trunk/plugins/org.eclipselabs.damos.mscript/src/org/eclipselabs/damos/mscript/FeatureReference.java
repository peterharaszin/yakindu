/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.mscript;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.mscript.FeatureReference#getFeature <em>Feature</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.FeatureReference#getStepExpression <em>Step Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.mscript.MscriptPackage#getFeatureReference()
 * @model
 * @generated
 */
public interface FeatureReference extends Expression {
	/**
	 * Returns the value of the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature</em>' reference.
	 * @see #setFeature(CallableElement)
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#getFeatureReference_Feature()
	 * @model
	 * @generated
	 */
	CallableElement getFeature();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.mscript.FeatureReference#getFeature <em>Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature</em>' reference.
	 * @see #getFeature()
	 * @generated
	 */
	void setFeature(CallableElement value);

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
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#getFeatureReference_StepExpression()
	 * @model containment="true"
	 * @generated
	 */
	StepExpression getStepExpression();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.mscript.FeatureReference#getStepExpression <em>Step Expression</em>}' containment reference.
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

} // FeatureReference
