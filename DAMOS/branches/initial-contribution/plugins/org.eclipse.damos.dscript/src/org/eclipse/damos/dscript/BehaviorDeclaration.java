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
/**
 */
package org.eclipse.damos.dscript;

import org.eclipse.damos.mscript.FunctionDeclaration;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Behavior Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.damos.dscript.BehaviorDeclaration#getBlockType <em>Block Type</em>}</li>
 *   <li>{@link org.eclipse.damos.dscript.BehaviorDeclaration#getAllImplicitInputParameterDeclarations <em>All Implicit Input Parameter Declarations</em>}</li>
 *   <li>{@link org.eclipse.damos.dscript.BehaviorDeclaration#getAllImplicitOutputParameterDeclarations <em>All Implicit Output Parameter Declarations</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.damos.dscript.DscriptPackage#getBehaviorDeclaration()
 * @model
 * @generated
 */
public interface BehaviorDeclaration extends FunctionDeclaration {

	/**
	 * Returns the value of the '<em><b>Block Type</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.damos.dscript.DscriptBlockType#getBehavior <em>Behavior</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Block Type</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Block Type</em>' container reference.
	 * @see #setBlockType(DscriptBlockType)
	 * @see org.eclipse.damos.dscript.DscriptPackage#getBehaviorDeclaration_BlockType()
	 * @see org.eclipse.damos.dscript.DscriptBlockType#getBehavior
	 * @model opposite="behavior" transient="false"
	 * @generated
	 */
	DscriptBlockType getBlockType();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.dscript.BehaviorDeclaration#getBlockType <em>Block Type</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Block Type</em>' container reference.
	 * @see #getBlockType()
	 * @generated
	 */
	void setBlockType(DscriptBlockType value);

	/**
	 * Returns the value of the '<em><b>All Implicit Input Parameter Declarations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.damos.dscript.ImplicitInputParameterDeclaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>All Implicit Input Parameter Declarations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>All Implicit Input Parameter Declarations</em>' containment reference list.
	 * @see org.eclipse.damos.dscript.DscriptPackage#getBehaviorDeclaration_AllImplicitInputParameterDeclarations()
	 * @model containment="true"
	 * @generated
	 */
	EList<ImplicitInputParameterDeclaration> getAllImplicitInputParameterDeclarations();

	/**
	 * Returns the value of the '<em><b>All Implicit Output Parameter Declarations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.damos.dscript.ImplicitOutputParameterDeclaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>All Implicit Output Parameter Declarations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>All Implicit Output Parameter Declarations</em>' containment reference list.
	 * @see org.eclipse.damos.dscript.DscriptPackage#getBehaviorDeclaration_AllImplicitOutputParameterDeclarations()
	 * @model containment="true"
	 * @generated
	 */
	EList<ImplicitOutputParameterDeclaration> getAllImplicitOutputParameterDeclarations();
} // BehaviorDeclaration
