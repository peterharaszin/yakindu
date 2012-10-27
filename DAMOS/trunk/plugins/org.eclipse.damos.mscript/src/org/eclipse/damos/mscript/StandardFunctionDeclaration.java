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
package org.eclipse.damos.mscript;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Standard Function Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.damos.mscript.StandardFunctionDeclaration#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.damos.mscript.StandardFunctionDeclaration#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipse.damos.mscript.StandardFunctionDeclaration#getInputParameterDeclarations <em>Input Parameter Declarations</em>}</li>
 *   <li>{@link org.eclipse.damos.mscript.StandardFunctionDeclaration#getOutputParameterDeclarations <em>Output Parameter Declarations</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.damos.mscript.MscriptPackage#getStandardFunctionDeclaration()
 * @model
 * @generated
 */
public interface StandardFunctionDeclaration extends FunctionDeclaration, CallableElement, TopLevelDeclaration {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.damos.mscript.MscriptPackage#getStandardFunctionDeclaration_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.mscript.StandardFunctionDeclaration#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.damos.mscript.FunctionKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see org.eclipse.damos.mscript.FunctionKind
	 * @see #setKind(FunctionKind)
	 * @see org.eclipse.damos.mscript.MscriptPackage#getStandardFunctionDeclaration_Kind()
	 * @model
	 * @generated
	 */
	FunctionKind getKind();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.mscript.StandardFunctionDeclaration#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see org.eclipse.damos.mscript.FunctionKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(FunctionKind value);

	/**
	 * Returns the value of the '<em><b>Input Parameter Declarations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.damos.mscript.InputParameterDeclaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Parameter Declarations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Parameter Declarations</em>' containment reference list.
	 * @see org.eclipse.damos.mscript.MscriptPackage#getStandardFunctionDeclaration_InputParameterDeclarations()
	 * @model containment="true"
	 * @generated
	 */
	EList<InputParameterDeclaration> getInputParameterDeclarations();

	/**
	 * Returns the value of the '<em><b>Output Parameter Declarations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.damos.mscript.OutputParameterDeclaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Parameter Declarations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Parameter Declarations</em>' containment reference list.
	 * @see org.eclipse.damos.mscript.MscriptPackage#getStandardFunctionDeclaration_OutputParameterDeclarations()
	 * @model containment="true"
	 * @generated
	 */
	EList<OutputParameterDeclaration> getOutputParameterDeclarations();

} // StandardFunctionDeclaration
