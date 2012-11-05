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
package org.eclipse.damos.mscript.computation.impl;

import org.eclipse.damos.mscript.TypeSpecifier;
import org.eclipse.damos.mscript.computation.ComputationPackage;
import org.eclipse.damos.mscript.computation.NumberFormat;
import org.eclipse.damos.mscript.computation.NumberFormatMapping;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Number Format Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.damos.mscript.computation.impl.NumberFormatMappingImpl#getTypeSpecifier <em>Type Specifier</em>}</li>
 *   <li>{@link org.eclipse.damos.mscript.computation.impl.NumberFormatMappingImpl#getNumberFormat <em>Number Format</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NumberFormatMappingImpl extends EObjectImpl implements NumberFormatMapping {
	/**
	 * The cached value of the '{@link #getTypeSpecifier() <em>Type Specifier</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeSpecifier()
	 * @generated
	 * @ordered
	 */
	protected TypeSpecifier typeSpecifier;

	/**
	 * The cached value of the '{@link #getNumberFormat() <em>Number Format</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberFormat()
	 * @generated
	 * @ordered
	 */
	protected NumberFormat numberFormat;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NumberFormatMappingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ComputationPackage.Literals.NUMBER_FORMAT_MAPPING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeSpecifier getTypeSpecifier() {
		return typeSpecifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTypeSpecifier(TypeSpecifier newTypeSpecifier, NotificationChain msgs) {
		TypeSpecifier oldTypeSpecifier = typeSpecifier;
		typeSpecifier = newTypeSpecifier;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ComputationPackage.NUMBER_FORMAT_MAPPING__TYPE_SPECIFIER, oldTypeSpecifier, newTypeSpecifier);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypeSpecifier(TypeSpecifier newTypeSpecifier) {
		if (newTypeSpecifier != typeSpecifier) {
			NotificationChain msgs = null;
			if (typeSpecifier != null)
				msgs = ((InternalEObject)typeSpecifier).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ComputationPackage.NUMBER_FORMAT_MAPPING__TYPE_SPECIFIER, null, msgs);
			if (newTypeSpecifier != null)
				msgs = ((InternalEObject)newTypeSpecifier).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ComputationPackage.NUMBER_FORMAT_MAPPING__TYPE_SPECIFIER, null, msgs);
			msgs = basicSetTypeSpecifier(newTypeSpecifier, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComputationPackage.NUMBER_FORMAT_MAPPING__TYPE_SPECIFIER, newTypeSpecifier, newTypeSpecifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NumberFormat getNumberFormat() {
		return numberFormat;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNumberFormat(NumberFormat newNumberFormat, NotificationChain msgs) {
		NumberFormat oldNumberFormat = numberFormat;
		numberFormat = newNumberFormat;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ComputationPackage.NUMBER_FORMAT_MAPPING__NUMBER_FORMAT, oldNumberFormat, newNumberFormat);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumberFormat(NumberFormat newNumberFormat) {
		if (newNumberFormat != numberFormat) {
			NotificationChain msgs = null;
			if (numberFormat != null)
				msgs = ((InternalEObject)numberFormat).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ComputationPackage.NUMBER_FORMAT_MAPPING__NUMBER_FORMAT, null, msgs);
			if (newNumberFormat != null)
				msgs = ((InternalEObject)newNumberFormat).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ComputationPackage.NUMBER_FORMAT_MAPPING__NUMBER_FORMAT, null, msgs);
			msgs = basicSetNumberFormat(newNumberFormat, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComputationPackage.NUMBER_FORMAT_MAPPING__NUMBER_FORMAT, newNumberFormat, newNumberFormat));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ComputationPackage.NUMBER_FORMAT_MAPPING__TYPE_SPECIFIER:
				return basicSetTypeSpecifier(null, msgs);
			case ComputationPackage.NUMBER_FORMAT_MAPPING__NUMBER_FORMAT:
				return basicSetNumberFormat(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ComputationPackage.NUMBER_FORMAT_MAPPING__TYPE_SPECIFIER:
				return getTypeSpecifier();
			case ComputationPackage.NUMBER_FORMAT_MAPPING__NUMBER_FORMAT:
				return getNumberFormat();
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
			case ComputationPackage.NUMBER_FORMAT_MAPPING__TYPE_SPECIFIER:
				setTypeSpecifier((TypeSpecifier)newValue);
				return;
			case ComputationPackage.NUMBER_FORMAT_MAPPING__NUMBER_FORMAT:
				setNumberFormat((NumberFormat)newValue);
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
			case ComputationPackage.NUMBER_FORMAT_MAPPING__TYPE_SPECIFIER:
				setTypeSpecifier((TypeSpecifier)null);
				return;
			case ComputationPackage.NUMBER_FORMAT_MAPPING__NUMBER_FORMAT:
				setNumberFormat((NumberFormat)null);
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
			case ComputationPackage.NUMBER_FORMAT_MAPPING__TYPE_SPECIFIER:
				return typeSpecifier != null;
			case ComputationPackage.NUMBER_FORMAT_MAPPING__NUMBER_FORMAT:
				return numberFormat != null;
		}
		return super.eIsSet(featureID);
	}

} //NumberFormatMappingImpl
