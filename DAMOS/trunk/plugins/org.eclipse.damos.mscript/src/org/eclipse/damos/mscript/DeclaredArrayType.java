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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Declared Array Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.damos.mscript.DeclaredArrayType#getElementTypeDeclaration <em>Element Type Declaration</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.damos.mscript.MscriptPackage#getDeclaredArrayType()
 * @model
 * @generated
 */
public interface DeclaredArrayType extends ArrayType {
	/**
	 * Returns the value of the '<em><b>Element Type Declaration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element Type Declaration</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element Type Declaration</em>' reference.
	 * @see #setElementTypeDeclaration(TypeDeclaration)
	 * @see org.eclipse.damos.mscript.MscriptPackage#getDeclaredArrayType_ElementTypeDeclaration()
	 * @model
	 * @generated
	 */
	TypeDeclaration getElementTypeDeclaration();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.mscript.DeclaredArrayType#getElementTypeDeclaration <em>Element Type Declaration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element Type Declaration</em>' reference.
	 * @see #getElementTypeDeclaration()
	 * @generated
	 */
	void setElementTypeDeclaration(TypeDeclaration value);

} // DeclaredArrayType
