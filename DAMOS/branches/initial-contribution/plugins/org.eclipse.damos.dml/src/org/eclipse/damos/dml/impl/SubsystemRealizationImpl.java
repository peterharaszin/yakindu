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

import org.eclipse.damos.dml.DMLPackage;
import org.eclipse.damos.dml.Fragment;
import org.eclipse.damos.dml.Subsystem;
import org.eclipse.damos.dml.SubsystemRealization;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Subsystem Realization</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.damos.dml.impl.SubsystemRealizationImpl#getRealizedSubsystem <em>Realized Subsystem</em>}</li>
 *   <li>{@link org.eclipse.damos.dml.impl.SubsystemRealizationImpl#getRealizingFragment <em>Realizing Fragment</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SubsystemRealizationImpl extends FragmentElementImpl implements SubsystemRealization {
	/**
	 * The cached value of the '{@link #getRealizedSubsystem() <em>Realized Subsystem</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRealizedSubsystem()
	 * @generated
	 * @ordered
	 */
	protected Subsystem realizedSubsystem;

	/**
	 * The cached value of the '{@link #getRealizingFragment() <em>Realizing Fragment</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRealizingFragment()
	 * @generated
	 * @ordered
	 */
	protected Fragment realizingFragment;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SubsystemRealizationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DMLPackage.Literals.SUBSYSTEM_REALIZATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Subsystem getRealizedSubsystem() {
		if (realizedSubsystem != null && realizedSubsystem.eIsProxy()) {
			InternalEObject oldRealizedSubsystem = (InternalEObject)realizedSubsystem;
			realizedSubsystem = (Subsystem)eResolveProxy(oldRealizedSubsystem);
			if (realizedSubsystem != oldRealizedSubsystem) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DMLPackage.SUBSYSTEM_REALIZATION__REALIZED_SUBSYSTEM, oldRealizedSubsystem, realizedSubsystem));
			}
		}
		return realizedSubsystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Subsystem basicGetRealizedSubsystem() {
		return realizedSubsystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRealizedSubsystem(Subsystem newRealizedSubsystem) {
		Subsystem oldRealizedSubsystem = realizedSubsystem;
		realizedSubsystem = newRealizedSubsystem;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DMLPackage.SUBSYSTEM_REALIZATION__REALIZED_SUBSYSTEM, oldRealizedSubsystem, realizedSubsystem));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Fragment getRealizingFragment() {
		if (realizingFragment != null && realizingFragment.eIsProxy()) {
			InternalEObject oldRealizingFragment = (InternalEObject)realizingFragment;
			realizingFragment = (Fragment)eResolveProxy(oldRealizingFragment);
			if (realizingFragment != oldRealizingFragment) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DMLPackage.SUBSYSTEM_REALIZATION__REALIZING_FRAGMENT, oldRealizingFragment, realizingFragment));
			}
		}
		return realizingFragment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Fragment basicGetRealizingFragment() {
		return realizingFragment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRealizingFragment(Fragment newRealizingFragment) {
		Fragment oldRealizingFragment = realizingFragment;
		realizingFragment = newRealizingFragment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DMLPackage.SUBSYSTEM_REALIZATION__REALIZING_FRAGMENT, oldRealizingFragment, realizingFragment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DMLPackage.SUBSYSTEM_REALIZATION__REALIZED_SUBSYSTEM:
				if (resolve) return getRealizedSubsystem();
				return basicGetRealizedSubsystem();
			case DMLPackage.SUBSYSTEM_REALIZATION__REALIZING_FRAGMENT:
				if (resolve) return getRealizingFragment();
				return basicGetRealizingFragment();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DMLPackage.SUBSYSTEM_REALIZATION__REALIZED_SUBSYSTEM:
				setRealizedSubsystem((Subsystem)newValue);
				return;
			case DMLPackage.SUBSYSTEM_REALIZATION__REALIZING_FRAGMENT:
				setRealizingFragment((Fragment)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case DMLPackage.SUBSYSTEM_REALIZATION__REALIZED_SUBSYSTEM:
				setRealizedSubsystem((Subsystem)null);
				return;
			case DMLPackage.SUBSYSTEM_REALIZATION__REALIZING_FRAGMENT:
				setRealizingFragment((Fragment)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case DMLPackage.SUBSYSTEM_REALIZATION__REALIZED_SUBSYSTEM:
				return realizedSubsystem != null;
			case DMLPackage.SUBSYSTEM_REALIZATION__REALIZING_FRAGMENT:
				return realizingFragment != null;
		}
		return super.eIsSet(featureID);
	}

} //SubsystemRealizationImpl
