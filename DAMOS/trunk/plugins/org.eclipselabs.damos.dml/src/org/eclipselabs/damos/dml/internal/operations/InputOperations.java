/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dml.internal.operations;

import org.eclipselabs.damos.dml.Input;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Input</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.dml.Input#isDirectFeedthrough() <em>Is Direct Feedthrough</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InputOperations {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InputOperations() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static  boolean isDirectFeedthrough(Input input) {
		return !input.getComponent().isSink();
	}

} // InputOperations