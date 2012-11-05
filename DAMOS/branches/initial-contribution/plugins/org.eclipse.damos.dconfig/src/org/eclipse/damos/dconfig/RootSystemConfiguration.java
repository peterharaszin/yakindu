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

import org.eclipse.damos.dml.Fragment;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Root System Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.damos.dconfig.RootSystemConfiguration#getContextFragment <em>Context Fragment</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.damos.dconfig.DconfigPackage#getRootSystemConfiguration()
 * @model
 * @generated
 */
public interface RootSystemConfiguration extends SystemConfiguration {
	/**
	 * Returns the value of the '<em><b>Context Fragment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context Fragment</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context Fragment</em>' reference.
	 * @see #setContextFragment(Fragment)
	 * @see org.eclipse.damos.dconfig.DconfigPackage#getRootSystemConfiguration_ContextFragment()
	 * @model
	 * @generated
	 */
	Fragment getContextFragment();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.dconfig.RootSystemConfiguration#getContextFragment <em>Context Fragment</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Context Fragment</em>' reference.
	 * @see #getContextFragment()
	 * @generated
	 */
	void setContextFragment(Fragment value);

} // RootSystemConfiguration
