/**
 */
package org.eclipselabs.damos.mscript;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dynamic String Segment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.mscript.ExpressionTemplateSegment#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.ExpressionTemplateSegment#getIndentation <em>Indentation</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.mscript.MscriptPackage#getExpressionTemplateSegment()
 * @model
 * @generated
 */
public interface ExpressionTemplateSegment extends TemplateSegment {
	/**
	 * Returns the value of the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' containment reference.
	 * @see #setExpression(Expression)
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#getExpressionTemplateSegment_Expression()
	 * @model containment="true"
	 * @generated
	 */
	Expression getExpression();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.mscript.ExpressionTemplateSegment#getExpression <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' containment reference.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(Expression value);

	/**
	 * Returns the value of the '<em><b>Indentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Indentation</em>' attribute.
	 * @see #setIndentation(String)
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#getExpressionTemplateSegment_Indentation()
	 * @model transient="true"
	 * @generated
	 */
	String getIndentation();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.mscript.ExpressionTemplateSegment#getIndentation <em>Indentation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Indentation</em>' attribute.
	 * @see #getIndentation()
	 * @generated
	 */
	void setIndentation(String value);

} // DynamicStringSegment
