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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Boolean Direct Feedthrough Policy</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.damos.dml.BooleanDirectFeedthroughPolicy#isDirectFeedthrough <em>Direct Feedthrough</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.damos.dml.DMLPackage#getBooleanDirectFeedthroughPolicy()
 * @model
 * @generated
 */
public interface BooleanDirectFeedthroughPolicy extends DirectFeedthroughPolicy {
	/**
	 * Returns the value of the '<em><b>Direct Feedthrough</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Direct Feedthrough</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Direct Feedthrough</em>' attribute.
	 * @see #setDirectFeedthrough(boolean)
	 * @see org.eclipse.damos.dml.DMLPackage#getBooleanDirectFeedthroughPolicy_DirectFeedthrough()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	boolean isDirectFeedthrough();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.dml.BooleanDirectFeedthroughPolicy#isDirectFeedthrough <em>Direct Feedthrough</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Direct Feedthrough</em>' attribute.
	 * @see #isDirectFeedthrough()
	 * @generated
	 */
	void setDirectFeedthrough(boolean value);

} // BooleanDirectFeedthroughPolicy
