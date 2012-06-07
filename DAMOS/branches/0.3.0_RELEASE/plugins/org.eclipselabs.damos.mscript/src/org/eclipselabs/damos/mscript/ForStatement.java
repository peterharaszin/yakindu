/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.mscript;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>For Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.mscript.ForStatement#getIterationVariable <em>Iteration Variable</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.ForStatement#getCollectionExpression <em>Collection Expression</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.ForStatement#getBody <em>Body</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.mscript.MscriptPackage#getForStatement()
 * @model
 * @generated
 */
public interface ForStatement extends Statement {
	/**
	 * Returns the value of the '<em><b>Iteration Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Iteration Variable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Iteration Variable</em>' containment reference.
	 * @see #setIterationVariable(IterationVariableDeclaration)
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#getForStatement_IterationVariable()
	 * @model containment="true"
	 * @generated
	 */
	IterationVariableDeclaration getIterationVariable();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.mscript.ForStatement#getIterationVariable <em>Iteration Variable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Iteration Variable</em>' containment reference.
	 * @see #getIterationVariable()
	 * @generated
	 */
	void setIterationVariable(IterationVariableDeclaration value);

	/**
	 * Returns the value of the '<em><b>Collection Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Collection Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Collection Expression</em>' containment reference.
	 * @see #setCollectionExpression(Expression)
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#getForStatement_CollectionExpression()
	 * @model containment="true"
	 * @generated
	 */
	Expression getCollectionExpression();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.mscript.ForStatement#getCollectionExpression <em>Collection Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Collection Expression</em>' containment reference.
	 * @see #getCollectionExpression()
	 * @generated
	 */
	void setCollectionExpression(Expression value);

	/**
	 * Returns the value of the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body</em>' containment reference.
	 * @see #setBody(Statement)
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#getForStatement_Body()
	 * @model containment="true"
	 * @generated
	 */
	Statement getBody();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.mscript.ForStatement#getBody <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' containment reference.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(Statement value);

} // ForStatement
