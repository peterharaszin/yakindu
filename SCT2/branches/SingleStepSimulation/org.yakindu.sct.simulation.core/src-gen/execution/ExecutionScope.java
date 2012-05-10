/**
 * Copyright (c) 2012 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 *   committers of YAKINDU - initial API and implementation
 *  
 */
package execution;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Scope</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link execution.ExecutionScope#getDeclaredEvents <em>Declared Events</em>}</li>
 *   <li>{@link execution.ExecutionScope#getVariables <em>Variables</em>}</li>
 * </ul>
 * </p>
 *
 * @see execution.ExecutionPackage#getExecutionScope()
 * @model
 * @generated
 */
public interface ExecutionScope extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2012 committers of YAKINDU and others.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\nContributors:\r\n  committers of YAKINDU - initial API and implementation\r\n ";

	/**
	 * Returns the value of the '<em><b>Declared Events</b></em>' containment reference list.
	 * The list contents are of type {@link execution.ExecutionEvent}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Declared Events</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Declared Events</em>' containment reference list.
	 * @see execution.ExecutionPackage#getExecutionScope_DeclaredEvents()
	 * @model containment="true"
	 * @generated
	 */
	EList<ExecutionEvent> getDeclaredEvents();

	/**
	 * Returns the value of the '<em><b>Variables</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variables</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variables</em>' reference.
	 * @see #setVariables(ExecutionVariable)
	 * @see execution.ExecutionPackage#getExecutionScope_Variables()
	 * @model
	 * @generated
	 */
	ExecutionVariable getVariables();

	/**
	 * Sets the value of the '{@link execution.ExecutionScope#getVariables <em>Variables</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variables</em>' reference.
	 * @see #getVariables()
	 * @generated
	 */
	void setVariables(ExecutionVariable value);

} // ExecutionScope
