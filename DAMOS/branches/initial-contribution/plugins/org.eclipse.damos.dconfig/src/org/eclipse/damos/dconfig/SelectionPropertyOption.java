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
package org.eclipse.damos.dconfig;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Selection Property Option</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.damos.dconfig.SelectionPropertyOption#getTarget <em>Target</em>}</li>
 *   <li>{@link org.eclipse.damos.dconfig.SelectionPropertyOption#getResourceDeclarations <em>Resource Declarations</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.damos.dconfig.DconfigPackage#getSelectionPropertyOption()
 * @model
 * @generated
 */
public interface SelectionPropertyOption extends PropertyDeclarationContainer, ConfigurationDefinitionMember {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(SelectionPropertyDeclaration)
	 * @see org.eclipse.damos.dconfig.DconfigPackage#getSelectionPropertyOption_Target()
	 * @model
	 * @generated
	 */
	SelectionPropertyDeclaration getTarget();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.dconfig.SelectionPropertyOption#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(SelectionPropertyDeclaration value);

	/**
	 * Returns the value of the '<em><b>Resource Declarations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.damos.dconfig.ResourceDeclaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource Declarations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource Declarations</em>' containment reference list.
	 * @see org.eclipse.damos.dconfig.DconfigPackage#getSelectionPropertyOption_ResourceDeclarations()
	 * @model containment="true"
	 * @generated
	 */
	EList<ResourceDeclaration> getResourceDeclarations();

} // SelectionPropertyOption
