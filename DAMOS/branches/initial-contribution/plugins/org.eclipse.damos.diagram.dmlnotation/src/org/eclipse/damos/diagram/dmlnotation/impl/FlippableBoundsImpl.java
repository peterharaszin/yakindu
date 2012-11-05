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
package org.eclipse.damos.diagram.dmlnotation.impl;

import org.eclipse.damos.diagram.dmlnotation.DMLNotationPackage;
import org.eclipse.damos.diagram.dmlnotation.FlippableBounds;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.gmf.runtime.notation.impl.BoundsImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Flippable Bounds</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.damos.diagram.dmlnotation.impl.FlippableBoundsImpl#isFlipped <em>Flipped</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FlippableBoundsImpl extends BoundsImpl implements FlippableBounds {
	/**
	 * The default value of the '{@link #isFlipped() <em>Flipped</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFlipped()
	 * @generated
	 * @ordered
	 */
	protected static final boolean FLIPPED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isFlipped() <em>Flipped</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFlipped()
	 * @generated
	 * @ordered
	 */
	protected boolean flipped = FLIPPED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FlippableBoundsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DMLNotationPackage.Literals.FLIPPABLE_BOUNDS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isFlipped() {
		return flipped;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFlipped(boolean newFlipped) {
		boolean oldFlipped = flipped;
		flipped = newFlipped;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DMLNotationPackage.FLIPPABLE_BOUNDS__FLIPPED, oldFlipped, flipped));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DMLNotationPackage.FLIPPABLE_BOUNDS__FLIPPED:
				return isFlipped();
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
			case DMLNotationPackage.FLIPPABLE_BOUNDS__FLIPPED:
				setFlipped((Boolean)newValue);
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
			case DMLNotationPackage.FLIPPABLE_BOUNDS__FLIPPED:
				setFlipped(FLIPPED_EDEFAULT);
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
			case DMLNotationPackage.FLIPPABLE_BOUNDS__FLIPPED:
				return flipped != FLIPPED_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (flipped: ");
		result.append(flipped);
		result.append(')');
		return result.toString();
	}

} //FlippableBoundsImpl
