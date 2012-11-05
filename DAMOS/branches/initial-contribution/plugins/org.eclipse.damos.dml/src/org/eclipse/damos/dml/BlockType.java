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
package org.eclipse.damos.dml;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EModelElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Block Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.damos.dml.BlockType#getInputDefinitions <em>Input Definitions</em>}</li>
 *   <li>{@link org.eclipse.damos.dml.BlockType#getOutputDefinitions <em>Output Definitions</em>}</li>
 *   <li>{@link org.eclipse.damos.dml.BlockType#getTiming <em>Timing</em>}</li>
 *   <li>{@link org.eclipse.damos.dml.BlockType#isBoundary <em>Boundary</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.damos.dml.DMLPackage#getBlockType()
 * @model
 * @generated
 */
public interface BlockType extends EModelElement, QualifiedElement, CategorizedElement, ParameterableElement {
	/**
	 * Returns the value of the '<em><b>Input Definitions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.damos.dml.InputDefinition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Definitions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Definitions</em>' containment reference list.
	 * @see org.eclipse.damos.dml.DMLPackage#getBlockType_InputDefinitions()
	 * @model containment="true"
	 * @generated
	 */
	EList<InputDefinition> getInputDefinitions();

	/**
	 * Returns the value of the '<em><b>Output Definitions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.damos.dml.OutputDefinition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Definitions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Definitions</em>' containment reference list.
	 * @see org.eclipse.damos.dml.DMLPackage#getBlockType_OutputDefinitions()
	 * @model containment="true"
	 * @generated
	 */
	EList<OutputDefinition> getOutputDefinitions();

	/**
	 * Returns the value of the '<em><b>Timing</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.damos.dml.TimingKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sample Time Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Timing</em>' attribute.
	 * @see org.eclipse.damos.dml.TimingKind
	 * @see #setTiming(TimingKind)
	 * @see org.eclipse.damos.dml.DMLPackage#getBlockType_Timing()
	 * @model required="true"
	 * @generated
	 */
	TimingKind getTiming();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.dml.BlockType#getTiming <em>Timing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Timing</em>' attribute.
	 * @see org.eclipse.damos.dml.TimingKind
	 * @see #getTiming()
	 * @generated
	 */
	void setTiming(TimingKind value);

	/**
	 * Returns the value of the '<em><b>Boundary</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Boundary</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Boundary</em>' attribute.
	 * @see #setBoundary(boolean)
	 * @see org.eclipse.damos.dml.DMLPackage#getBlockType_Boundary()
	 * @model
	 * @generated
	 */
	boolean isBoundary();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.dml.BlockType#isBoundary <em>Boundary</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Boundary</em>' attribute.
	 * @see #isBoundary()
	 * @generated
	 */
	void setBoundary(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ordered="false" nameRequired="true" nameOrdered="false"
	 * @generated
	 */
	Block newInstance(String name);

} // BlockType
