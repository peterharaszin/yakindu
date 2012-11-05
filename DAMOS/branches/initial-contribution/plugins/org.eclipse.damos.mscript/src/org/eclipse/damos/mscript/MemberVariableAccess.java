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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Member Variable Access</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.damos.mscript.MemberVariableAccess#getTarget <em>Target</em>}</li>
 *   <li>{@link org.eclipse.damos.mscript.MemberVariableAccess#getMemberVariable <em>Member Variable</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.damos.mscript.MscriptPackage#getMemberVariableAccess()
 * @model
 * @generated
 */
public interface MemberVariableAccess extends Expression {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' containment reference.
	 * @see #setTarget(Expression)
	 * @see org.eclipse.damos.mscript.MscriptPackage#getMemberVariableAccess_Target()
	 * @model containment="true"
	 * @generated
	 */
	Expression getTarget();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.mscript.MemberVariableAccess#getTarget <em>Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' containment reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Expression value);

	/**
	 * Returns the value of the '<em><b>Member Variable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Member Variable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Member Variable</em>' attribute.
	 * @see #setMemberVariable(String)
	 * @see org.eclipse.damos.mscript.MscriptPackage#getMemberVariableAccess_MemberVariable()
	 * @model
	 * @generated
	 */
	String getMemberVariable();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.mscript.MemberVariableAccess#getMemberVariable <em>Member Variable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Member Variable</em>' attribute.
	 * @see #getMemberVariable()
	 * @generated
	 */
	void setMemberVariable(String value);

} // MemberVariableAccess
