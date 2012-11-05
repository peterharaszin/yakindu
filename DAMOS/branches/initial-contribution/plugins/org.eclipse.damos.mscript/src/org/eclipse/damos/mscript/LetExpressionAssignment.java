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
package org.eclipse.damos.mscript;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Let Expression Variable Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.damos.mscript.LetExpressionAssignment#getVariables <em>Variables</em>}</li>
 *   <li>{@link org.eclipse.damos.mscript.LetExpressionAssignment#getAssignedExpression <em>Assigned Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.damos.mscript.MscriptPackage#getLetExpressionAssignment()
 * @model
 * @generated
 */
public interface LetExpressionAssignment extends EObject {
	/**
	 * Returns the value of the '<em><b>Variables</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.damos.mscript.LetExpressionVariableDeclaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variables</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variables</em>' containment reference list.
	 * @see org.eclipse.damos.mscript.MscriptPackage#getLetExpressionAssignment_Variables()
	 * @model containment="true"
	 * @generated
	 */
	EList<LetExpressionVariableDeclaration> getVariables();

	/**
	 * Returns the value of the '<em><b>Assigned Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assigned Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assigned Expression</em>' containment reference.
	 * @see #setAssignedExpression(Expression)
	 * @see org.eclipse.damos.mscript.MscriptPackage#getLetExpressionAssignment_AssignedExpression()
	 * @model containment="true"
	 * @generated
	 */
	Expression getAssignedExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.mscript.LetExpressionAssignment#getAssignedExpression <em>Assigned Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Assigned Expression</em>' containment reference.
	 * @see #getAssignedExpression()
	 * @generated
	 */
	void setAssignedExpression(Expression value);

} // LetExpressionVariableDeclaration
