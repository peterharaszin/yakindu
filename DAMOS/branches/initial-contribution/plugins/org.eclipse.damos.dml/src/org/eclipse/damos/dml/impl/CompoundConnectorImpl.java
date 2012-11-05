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
package org.eclipse.damos.dml.impl;

import org.eclipse.damos.dml.Compound;
import org.eclipse.damos.dml.CompoundConnector;
import org.eclipse.damos.dml.DMLPackage;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Compound Connector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.damos.dml.impl.CompoundConnectorImpl#getCompound <em>Compound</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class CompoundConnectorImpl extends ConnectorImpl implements CompoundConnector {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompoundConnectorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DMLPackage.Literals.COMPOUND_CONNECTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Compound getCompound() {
		Compound compound = basicGetCompound();
		return compound != null && compound.eIsProxy() ? (Compound)eResolveProxy((InternalEObject)compound) : compound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Compound basicGetCompound() {
		EObject internalContainer = eInternalContainer();
		return internalContainer instanceof Compound ? (Compound) internalContainer : null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DMLPackage.COMPOUND_CONNECTOR__COMPOUND:
				if (resolve) return getCompound();
				return basicGetCompound();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case DMLPackage.COMPOUND_CONNECTOR__COMPOUND:
				return basicGetCompound() != null;
		}
		return super.eIsSet(featureID);
	}

} //CompoundConnectorImpl
