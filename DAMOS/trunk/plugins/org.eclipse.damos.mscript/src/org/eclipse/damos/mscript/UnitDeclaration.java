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
 * A representation of the model object '<em><b>Unit Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.damos.mscript.UnitDeclaration#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.damos.mscript.UnitDeclaration#getSymbols <em>Symbols</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.damos.mscript.MscriptPackage#getUnitDeclaration()
 * @model abstract="true"
 * @generated
 */
public interface UnitDeclaration extends TopLevelDeclaration {
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
	 * @see org.eclipse.damos.mscript.MscriptPackage#getUnitDeclaration_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.mscript.UnitDeclaration#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Symbols</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.damos.mscript.UnitSymbol}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.damos.mscript.UnitSymbol#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Symbols</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Symbols</em>' containment reference list.
	 * @see org.eclipse.damos.mscript.MscriptPackage#getUnitDeclaration_Symbols()
	 * @see org.eclipse.damos.mscript.UnitSymbol#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList<UnitSymbol> getSymbols();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model prefixRequired="true"
	 * @generated
	 */
	UnitSymbol getSymbol(UnitPrefix prefix);

} // UnitDeclaration
