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

import org.eclipse.damos.mscript.Type;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Computation Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.damos.mscript.computation.ComputationModel#getQualifiedName <em>Qualified Name</em>}</li>
 *   <li>{@link org.eclipse.damos.mscript.computation.ComputationModel#getNumberFormatMappings <em>Number Format Mappings</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.damos.mscript.computation.ComputationPackage#getComputationModel()
 * @model
 * @generated
 */
public interface ComputationModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Number Format Mappings</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.damos.mscript.computation.NumberFormatMapping}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number Format Mappings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number Format Mappings</em>' containment reference list.
	 * @see org.eclipse.damos.mscript.computation.ComputationPackage#getComputationModel_NumberFormatMappings()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<NumberFormatMapping> getNumberFormatMappings();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false" typeRequired="true" typeOrdered="false"
	 * @generated
	 */
	NumberFormatMapping getNumberFormatMapping(Type type);

	/**
	 * Returns the value of the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Qualified Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Qualified Name</em>' attribute.
	 * @see #setQualifiedName(String)
	 * @see org.eclipse.damos.mscript.computation.ComputationPackage#getComputationModel_QualifiedName()
	 * @model
	 * @generated
	 */
	String getQualifiedName();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.mscript.computation.ComputationModel#getQualifiedName <em>Qualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Qualified Name</em>' attribute.
	 * @see #getQualifiedName()
	 * @generated
	 */
	void setQualifiedName(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false" typeRequired="true" typeOrdered="false"
	 * @generated
	 */
	NumberFormat getNumberFormat(Type type);

} // ComputationModel
