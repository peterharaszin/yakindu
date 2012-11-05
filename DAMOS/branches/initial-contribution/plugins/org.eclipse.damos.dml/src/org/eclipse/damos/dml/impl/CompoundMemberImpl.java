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
import org.eclipse.damos.dml.CompoundMember;
import org.eclipse.damos.dml.DMLPackage;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Compound Member</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.damos.dml.impl.CompoundMemberImpl#getOwningCompound <em>Owning Compound</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class CompoundMemberImpl extends EObjectImpl implements CompoundMember {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompoundMemberImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DMLPackage.Literals.COMPOUND_MEMBER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Compound getOwningCompound() {
		Compound owningCompound = basicGetOwningCompound();
		return owningCompound != null && owningCompound.eIsProxy() ? (Compound)eResolveProxy((InternalEObject)owningCompound) : owningCompound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Compound basicGetOwningCompound() {
		EObject container = eInternalContainer();
		if (container instanceof Compound) {
			return (Compound) container;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DMLPackage.COMPOUND_MEMBER__OWNING_COMPOUND:
				if (resolve) return getOwningCompound();
				return basicGetOwningCompound();
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
			case DMLPackage.COMPOUND_MEMBER__OWNING_COMPOUND:
				return basicGetOwningCompound() != null;
		}
		return super.eIsSet(featureID);
	}

} //CompoundMemberImpl
