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
package org.eclipse.damos.mscript.function;

import java.util.Map;

import org.eclipse.damos.mscript.Equation;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Equation Descriptor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.damos.mscript.function.EquationDescription#getFunctionDescription <em>Function Description</em>}</li>
 *   <li>{@link org.eclipse.damos.mscript.function.EquationDescription#getEquation <em>Equation</em>}</li>
 *   <li>{@link org.eclipse.damos.mscript.function.EquationDescription#getSides <em>Sides</em>}</li>
 *   <li>{@link org.eclipse.damos.mscript.function.EquationDescription#getLeftHandSide <em>Left Hand Side</em>}</li>
 *   <li>{@link org.eclipse.damos.mscript.function.EquationDescription#getRightHandSide <em>Right Hand Side</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.damos.mscript.function.FunctionPackage#getEquationDescription()
 * @model
 * @generated
 */
public interface EquationDescription extends EObject {
	/**
	 * Returns the value of the '<em><b>Function Description</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.damos.mscript.function.FunctionDescription#getEquationDescriptions <em>Equation Descriptions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Function Descriptor</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Function Description</em>' container reference.
	 * @see #setFunctionDescription(FunctionDescription)
	 * @see org.eclipse.damos.mscript.function.FunctionPackage#getEquationDescription_FunctionDescription()
	 * @see org.eclipse.damos.mscript.function.FunctionDescription#getEquationDescriptions
	 * @model opposite="equationDescriptions" required="true" transient="false"
	 * @generated
	 */
	FunctionDescription getFunctionDescription();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.mscript.function.EquationDescription#getFunctionDescription <em>Function Description</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Function Description</em>' container reference.
	 * @see #getFunctionDescription()
	 * @generated
	 */
	void setFunctionDescription(FunctionDescription value);

	/**
	 * Returns the value of the '<em><b>Equation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Equation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Equation</em>' reference.
	 * @see #setEquation(Equation)
	 * @see org.eclipse.damos.mscript.function.FunctionPackage#getEquationDescription_Equation()
	 * @model required="true"
	 * @generated
	 */
	Equation getEquation();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.mscript.function.EquationDescription#getEquation <em>Equation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Equation</em>' reference.
	 * @see #getEquation()
	 * @generated
	 */
	void setEquation(Equation value);

	/**
	 * Returns the value of the '<em><b>Sides</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.damos.mscript.function.EquationSide}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.damos.mscript.function.EquationSide#getEquationDescription <em>Equation Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sides</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sides</em>' containment reference list.
	 * @see org.eclipse.damos.mscript.function.FunctionPackage#getEquationDescription_Sides()
	 * @see org.eclipse.damos.mscript.function.EquationSide#getEquationDescription
	 * @model opposite="equationDescription" containment="true" lower="2" upper="2"
	 * @generated
	 */
	EList<EquationSide> getSides();

	/**
	 * Returns the value of the '<em><b>Left Hand Side</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Left Hand Side</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left Hand Side</em>' reference.
	 * @see org.eclipse.damos.mscript.function.FunctionPackage#getEquationDescription_LeftHandSide()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EquationSide getLeftHandSide();

	/**
	 * Returns the value of the '<em><b>Right Hand Side</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Right Hand Side</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right Hand Side</em>' reference.
	 * @see org.eclipse.damos.mscript.function.FunctionPackage#getEquationDescription_RightHandSide()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EquationSide getRightHandSide();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	boolean isLeftHandSideValid(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	boolean isRightHandSideValid(DiagnosticChain diagnostics, Map<Object, Object> context);

} // EquationDescription
