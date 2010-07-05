/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dml;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expression Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.dml.ExpressionParameter#getDefaultExpression <em>Default Expression</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dml.ExpressionParameter#getPredefinedExpressions <em>Predefined Expressions</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dml.ExpressionParameter#getDataType <em>Data Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.dml.DMLPackage#getExpressionParameter()
 * @model
 * @generated
 */
public interface ExpressionParameter extends Parameter {

	/**
	 * Returns the value of the '<em><b>Default Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Expression</em>' containment reference.
	 * @see #setDefaultExpression(ExpressionSpecification)
	 * @see org.eclipselabs.damos.dml.DMLPackage#getExpressionParameter_DefaultExpression()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	ExpressionSpecification getDefaultExpression();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.dml.ExpressionParameter#getDefaultExpression <em>Default Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Expression</em>' containment reference.
	 * @see #getDefaultExpression()
	 * @generated
	 */
	void setDefaultExpression(ExpressionSpecification value);

	/**
	 * Returns the value of the '<em><b>Predefined Expressions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.dml.PredefinedExpressionEntry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Predefined Expressions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Predefined Expressions</em>' containment reference list.
	 * @see org.eclipselabs.damos.dml.DMLPackage#getExpressionParameter_PredefinedExpressions()
	 * @model containment="true"
	 * @generated
	 */
	EList<PredefinedExpressionEntry> getPredefinedExpressions();

	/**
	 * Returns the value of the '<em><b>Data Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Type</em>' containment reference.
	 * @see #setDataType(DataTypeSpecification)
	 * @see org.eclipselabs.damos.dml.DMLPackage#getExpressionParameter_DataType()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	DataTypeSpecification getDataType();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.dml.ExpressionParameter#getDataType <em>Data Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Type</em>' containment reference.
	 * @see #getDataType()
	 * @generated
	 */
	void setDataType(DataTypeSpecification value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ordered="false" expressionRequired="true" expressionOrdered="false"
	 * @generated
	 */
	PredefinedExpressionEntry getPredefinedExpression(String expression);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ordered="false" aliasRequired="true" aliasOrdered="false"
	 * @generated
	 */
	PredefinedExpressionEntry getPredefinedExpressionByAlias(String alias);

} // ExpressionParameter
