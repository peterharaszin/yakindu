/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dml.internal.operations;

import org.eclipselabs.damos.dml.Argument;
import org.eclipselabs.damos.dml.ParameterizedElement;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Parameterized Element</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.dml.ParameterizedElement#getArgument(java.lang.String) <em>Get Argument</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dml.ParameterizedElement#getArgumentStringValue(java.lang.String) <em>Get Argument String Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ParameterizedElementOperations {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParameterizedElementOperations() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static  Argument getArgument(ParameterizedElement parameterizedElement, String parameterName) {
		for (Argument argument : parameterizedElement.getArguments()) {
			if (argument.getParameter().getName().equals(parameterName)) {
				return argument;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static  String getArgumentStringValue(ParameterizedElement parameterizedElement, String parameterName) {
		Argument argument = parameterizedElement.getArgument(parameterName);
		if (argument != null && argument.isSetValue()) {
			return argument.getValue().stringValue();
		}
		return null;
	}

} // ParameterizedElementOperations