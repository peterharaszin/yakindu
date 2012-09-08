/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dml;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parameterized Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.dml.ParameterizedElement#getArguments <em>Arguments</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.dml.DMLPackage#getParameterizedElement()
 * @model abstract="true"
 * @generated
 */
public interface ParameterizedElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Arguments</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.dml.Argument}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Arguments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arguments</em>' containment reference list.
	 * @see org.eclipselabs.damos.dml.DMLPackage#getParameterizedElement_Arguments()
	 * @model containment="true"
	 * @generated
	 */
	EList<Argument> getArguments();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false" parameterRequired="true" parameterOrdered="false"
	 * @generated
	 */
	Argument getArgument(Parameter parameter);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false" parameterNameRequired="true" parameterNameOrdered="false"
	 * @generated
	 */
	Argument getArgument(String parameterName);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false" parameterNameRequired="true" parameterNameOrdered="false"
	 * @generated
	 */
	String getArgumentStringValue(String parameterName);

} // ParameterizedElement
