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
package org.eclipse.damos.mscript.computation;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Floating Point Format</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.damos.mscript.computation.FloatingPointFormat#getKind <em>Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.damos.mscript.computation.ComputationPackage#getFloatingPointFormat()
 * @model
 * @generated
 */
public interface FloatingPointFormat extends NumberFormat {
	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.damos.mscript.computation.FloatingPointFormatKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see org.eclipse.damos.mscript.computation.FloatingPointFormatKind
	 * @see #setKind(FloatingPointFormatKind)
	 * @see org.eclipse.damos.mscript.computation.ComputationPackage#getFloatingPointFormat_Kind()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	FloatingPointFormatKind getKind();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.mscript.computation.FloatingPointFormat#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see org.eclipse.damos.mscript.computation.FloatingPointFormatKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(FloatingPointFormatKind value);

} // FloatingPointFormat
