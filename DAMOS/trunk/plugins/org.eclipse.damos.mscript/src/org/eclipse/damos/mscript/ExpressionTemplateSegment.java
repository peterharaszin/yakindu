/*******************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Andreas Unger - initial API and implementation
 *******************************************************************************/
/**
 */
package org.eclipse.damos.mscript;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dynamic String Segment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.damos.mscript.ExpressionTemplateSegment#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.eclipse.damos.mscript.ExpressionTemplateSegment#getIndentation <em>Indentation</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.damos.mscript.MscriptPackage#getExpressionTemplateSegment()
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
	 * @see org.eclipse.damos.mscript.MscriptPackage#getExpressionTemplateSegment_Expression()
	 * @model containment="true"
	 * @generated
	 */
	Expression getExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.mscript.ExpressionTemplateSegment#getExpression <em>Expression</em>}' containment reference.
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
	 * @see org.eclipse.damos.mscript.MscriptPackage#getExpressionTemplateSegment_Indentation()
	 * @model transient="true"
	 * @generated
	 */
	String getIndentation();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.mscript.ExpressionTemplateSegment#getIndentation <em>Indentation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Indentation</em>' attribute.
	 * @see #getIndentation()
	 * @generated
	 */
	void setIndentation(String value);

} // DynamicStringSegment
