/**
 */
package org.eclipselabs.damos.mscript;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Standard Input Parameter Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.mscript.StandardInputParameterDeclaration#isConstant <em>Constant</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.StandardInputParameterDeclaration#getDefaultExpression <em>Default Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.mscript.MscriptPackage#getStandardInputParameterDeclaration()
 * @model
 * @generated
 */
public interface StandardInputParameterDeclaration extends StandardParameterDeclaration, InputParameterDeclaration {
	/**
	 * Returns the value of the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constant</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constant</em>' attribute.
	 * @see #setConstant(boolean)
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#getStandardInputParameterDeclaration_Constant()
	 * @model
	 * @generated
	 */
	boolean isConstant();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.mscript.StandardInputParameterDeclaration#isConstant <em>Constant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constant</em>' attribute.
	 * @see #isConstant()
	 * @generated
	 */
	void setConstant(boolean value);

	/**
	 * Returns the value of the '<em><b>Default Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Expression</em>' containment reference.
	 * @see #setDefaultExpression(Expression)
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#getStandardInputParameterDeclaration_DefaultExpression()
	 * @model containment="true"
	 * @generated
	 */
	Expression getDefaultExpression();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.mscript.StandardInputParameterDeclaration#getDefaultExpression <em>Default Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Expression</em>' containment reference.
	 * @see #getDefaultExpression()
	 * @generated
	 */
	void setDefaultExpression(Expression value);

} // StandardInputParameterDeclaration
