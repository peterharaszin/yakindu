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
package org.eclipse.damos.dscript;

import org.eclipse.damos.dml.BlockType;
import org.eclipse.damos.dml.SystemInterface;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.damos.dscript.Root#getBlockTypes <em>Block Types</em>}</li>
 *   <li>{@link org.eclipse.damos.dscript.Root#getSystemInterfaces <em>System Interfaces</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.damos.dscript.DscriptPackage#getRoot()
 * @model abstract="true"
 * @generated
 */
public interface Root extends EObject {
	/**
	 * Returns the value of the '<em><b>Block Types</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.damos.dml.BlockType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Block Types</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Block Types</em>' containment reference list.
	 * @see org.eclipse.damos.dscript.DscriptPackage#getRoot_BlockTypes()
	 * @model containment="true"
	 * @generated
	 */
	EList<BlockType> getBlockTypes();

	/**
	 * Returns the value of the '<em><b>System Interfaces</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.damos.dml.SystemInterface}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>System Interfaces</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>System Interfaces</em>' containment reference list.
	 * @see org.eclipse.damos.dscript.DscriptPackage#getRoot_SystemInterfaces()
	 * @model containment="true"
	 * @generated
	 */
	EList<SystemInterface> getSystemInterfaces();

} // Root
