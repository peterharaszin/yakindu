/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.mscript;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Postfix Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.mscript.PostfixExpression#getOperand <em>Operand</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.PostfixExpression#getOperator <em>Operator</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.mscript.MscriptPackage#getPostfixExpression()
 * @model
 * @generated
 */
public interface PostfixExpression extends Expression {
	/**
	 * Returns the value of the '<em><b>Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operand</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operand</em>' containment reference.
	 * @see #setOperand(Expression)
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#getPostfixExpression_Operand()
	 * @model containment="true"
	 * @generated
	 */
	Expression getOperand();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.mscript.PostfixExpression#getOperand <em>Operand</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operand</em>' containment reference.
	 * @see #getOperand()
	 * @generated
	 */
	void setOperand(Expression value);

	/**
	 * Returns the value of the '<em><b>Operator</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipselabs.damos.mscript.PostfixOperator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operator</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operator</em>' attribute.
	 * @see org.eclipselabs.damos.mscript.PostfixOperator
	 * @see #setOperator(PostfixOperator)
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#getPostfixExpression_Operator()
	 * @model
	 * @generated
	 */
	PostfixOperator getOperator();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.mscript.PostfixExpression#getOperator <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operator</em>' attribute.
	 * @see org.eclipselabs.damos.mscript.PostfixOperator
	 * @see #getOperator()
	 * @generated
	 */
	void setOperator(PostfixOperator value);

} // PostfixExpression
