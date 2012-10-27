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
 * A representation of the model object '<em><b>Anonymous Array Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.damos.mscript.AnonymousArrayType#getElementType <em>Element Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.damos.mscript.MscriptPackage#getAnonymousArrayType()
 * @model
 * @generated
 */
public interface AnonymousArrayType extends ArrayType {
	/**
	 * Returns the value of the '<em><b>Element Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element Type</em>' containment reference.
	 * @see #setElementType(Type)
	 * @see org.eclipse.damos.mscript.MscriptPackage#getAnonymousArrayType_ElementType()
	 * @model containment="true"
	 * @generated
	 */
	Type getElementType();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.mscript.AnonymousArrayType#getElementType <em>Element Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element Type</em>' containment reference.
	 * @see #getElementType()
	 * @generated
	 */
	void setElementType(Type value);

} // AnonymousArrayType
