/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dml;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Predefined Expression Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.dml.PredefinedExpressionEntry#getAlias <em>Alias</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dml.PredefinedExpressionEntry#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.dml.DMLPackage#getPredefinedExpressionEntry()
 * @model
 * @generated
 */
public interface PredefinedExpressionEntry extends EObject {
	/**
	 * Returns the value of the '<em><b>Alias</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Alias</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Alias</em>' attribute.
	 * @see #isSetAlias()
	 * @see #unsetAlias()
	 * @see #setAlias(String)
	 * @see org.eclipselabs.damos.dml.DMLPackage#getPredefinedExpressionEntry_Alias()
	 * @model unsettable="true" ordered="false"
	 * @generated
	 */
	String getAlias();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.dml.PredefinedExpressionEntry#getAlias <em>Alias</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Alias</em>' attribute.
	 * @see #isSetAlias()
	 * @see #unsetAlias()
	 * @see #getAlias()
	 * @generated
	 */
	void setAlias(String value);

	/**
	 * Unsets the value of the '{@link org.eclipselabs.damos.dml.PredefinedExpressionEntry#getAlias <em>Alias</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetAlias()
	 * @see #getAlias()
	 * @see #setAlias(String)
	 * @generated
	 */
	void unsetAlias();

	/**
	 * Returns whether the value of the '{@link org.eclipselabs.damos.dml.PredefinedExpressionEntry#getAlias <em>Alias</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Alias</em>' attribute is set.
	 * @see #unsetAlias()
	 * @see #getAlias()
	 * @see #setAlias(String)
	 * @generated
	 */
	boolean isSetAlias();

	/**
	 * Returns the value of the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' containment reference.
	 * @see #setExpression(ExpressionSpecification)
	 * @see org.eclipselabs.damos.dml.DMLPackage#getPredefinedExpressionEntry_Expression()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	ExpressionSpecification getExpression();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.dml.PredefinedExpressionEntry#getExpression <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' containment reference.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(ExpressionSpecification value);

} // PredefinedExpressionEntry
