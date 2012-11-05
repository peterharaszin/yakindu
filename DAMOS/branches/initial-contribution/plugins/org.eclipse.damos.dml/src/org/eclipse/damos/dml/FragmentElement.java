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

import org.eclipse.emf.ecore.EModelElement;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fragment Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.damos.dml.FragmentElement#getOwningFragment <em>Owning Fragment</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.damos.dml.DMLPackage#getFragmentElement()
 * @model abstract="true"
 * @generated
 */
public interface FragmentElement extends EModelElement {
	/**
	 * Returns the value of the '<em><b>Owning Fragment</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.damos.dml.Fragment#getFragmentElements <em>Fragment Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fragment</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Fragment</em>' container reference.
	 * @see #setOwningFragment(Fragment)
	 * @see org.eclipse.damos.dml.DMLPackage#getFragmentElement_OwningFragment()
	 * @see org.eclipse.damos.dml.Fragment#getFragmentElements
	 * @model opposite="fragmentElements" transient="false" ordered="false"
	 * @generated
	 */
	Fragment getOwningFragment();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.dml.FragmentElement#getOwningFragment <em>Owning Fragment</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Fragment</em>' container reference.
	 * @see #getOwningFragment()
	 * @generated
	 */
	void setOwningFragment(Fragment value);

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enclosing Fragment</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	Fragment getEnclosingFragment();

} // FragmentElement
