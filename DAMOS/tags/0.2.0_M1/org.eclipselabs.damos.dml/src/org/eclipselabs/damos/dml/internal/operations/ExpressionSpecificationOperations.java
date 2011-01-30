/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dml.internal.operations;

import org.eclipselabs.damos.dml.ExpressionSpecification;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Expression Specification</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.dml.ExpressionSpecification#stringValue() <em>String Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExpressionSpecificationOperations extends ValueSpecificationOperations {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExpressionSpecificationOperations() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static  String stringValue(ExpressionSpecification expressionSpecification) {
		return expressionSpecification.getExpression();
	}

} // ExpressionSpecificationOperations