/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dml.internal.operations;

import org.eclipselabs.damos.dml.ExpressionParameter;
import org.eclipselabs.damos.dml.PredefinedExpressionEntry;
import org.eclipselabs.damos.dml.ValueSpecification;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Expression Parameter</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.dml.ExpressionParameter#getPredefinedExpression(java.lang.String) <em>Get Predefined Expression</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dml.ExpressionParameter#getPredefinedExpressionByAlias(java.lang.String) <em>Get Predefined Expression By Alias</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dml.ExpressionParameter#getDefaultValue() <em>Get Default Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExpressionParameterOperations extends ParameterOperations {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExpressionParameterOperations() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static  PredefinedExpressionEntry getPredefinedExpression(ExpressionParameter expressionParameter, String expression) {
		for (PredefinedExpressionEntry entry : expressionParameter.getPredefinedExpressions()) {
			if (entry.getExpression() != null && expression.equals(entry.getExpression().getExpression())) {
				return entry;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static  PredefinedExpressionEntry getPredefinedExpressionByAlias(ExpressionParameter expressionParameter, String alias) {
		for (PredefinedExpressionEntry entry : expressionParameter.getPredefinedExpressions()) {
			if (alias.equals(entry.getAlias())) {
				return entry;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static  ValueSpecification getDefaultValue(ExpressionParameter expressionParameter) {
		return expressionParameter.getDefaultExpression();
	}

} // ExpressionParameterOperations