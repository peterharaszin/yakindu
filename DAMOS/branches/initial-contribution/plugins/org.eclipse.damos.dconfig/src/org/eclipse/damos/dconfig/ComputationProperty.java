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

import org.eclipse.damos.mscript.computation.ComputationModel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Computation Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.damos.dconfig.ComputationProperty#getComputationModel <em>Computation Model</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.damos.dconfig.DconfigPackage#getComputationProperty()
 * @model
 * @generated
 */
public interface ComputationProperty extends Property {
	/**
	 * Returns the value of the '<em><b>Computation Model</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Computation Model</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Computation Model</em>' containment reference.
	 * @see #setComputationModel(ComputationModel)
	 * @see org.eclipse.damos.dconfig.DconfigPackage#getComputationProperty_ComputationModel()
	 * @model containment="true"
	 * @generated
	 */
	ComputationModel getComputationModel();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.dconfig.ComputationProperty#getComputationModel <em>Computation Model</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Computation Model</em>' containment reference.
	 * @see #getComputationModel()
	 * @generated
	 */
	void setComputationModel(ComputationModel value);

} // ComputationProperty
