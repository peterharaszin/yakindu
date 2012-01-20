/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.mscript.computationmodel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipselabs.damos.mscript.DataTypeSpecifier;
import org.eclipselabs.damos.mscript.computationmodel.ComputationModelPackage;
import org.eclipselabs.damos.mscript.computationmodel.NumberFormat;
import org.eclipselabs.damos.mscript.computationmodel.NumberFormatMapping;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Number Format Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.mscript.computationmodel.impl.NumberFormatMappingImpl#getTypeSpecifier <em>Type Specifier</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.computationmodel.impl.NumberFormatMappingImpl#getNumberFormat <em>Number Format</em>}</li>
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
	protected DataTypeSpecifier typeSpecifier;

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
		return ComputationModelPackage.Literals.NUMBER_FORMAT_MAPPING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataTypeSpecifier getTypeSpecifier() {
		return typeSpecifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTypeSpecifier(DataTypeSpecifier newTypeSpecifier, NotificationChain msgs) {
		DataTypeSpecifier oldTypeSpecifier = typeSpecifier;
		typeSpecifier = newTypeSpecifier;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ComputationModelPackage.NUMBER_FORMAT_MAPPING__TYPE_SPECIFIER, oldTypeSpecifier, newTypeSpecifier);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypeSpecifier(DataTypeSpecifier newTypeSpecifier) {
		if (newTypeSpecifier != typeSpecifier) {
			NotificationChain msgs = null;
			if (typeSpecifier != null)
				msgs = ((InternalEObject)typeSpecifier).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ComputationModelPackage.NUMBER_FORMAT_MAPPING__TYPE_SPECIFIER, null, msgs);
			if (newTypeSpecifier != null)
				msgs = ((InternalEObject)newTypeSpecifier).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ComputationModelPackage.NUMBER_FORMAT_MAPPING__TYPE_SPECIFIER, null, msgs);
			msgs = basicSetTypeSpecifier(newTypeSpecifier, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComputationModelPackage.NUMBER_FORMAT_MAPPING__TYPE_SPECIFIER, newTypeSpecifier, newTypeSpecifier));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ComputationModelPackage.NUMBER_FORMAT_MAPPING__NUMBER_FORMAT, oldNumberFormat, newNumberFormat);
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
				msgs = ((InternalEObject)numberFormat).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ComputationModelPackage.NUMBER_FORMAT_MAPPING__NUMBER_FORMAT, null, msgs);
			if (newNumberFormat != null)
				msgs = ((InternalEObject)newNumberFormat).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ComputationModelPackage.NUMBER_FORMAT_MAPPING__NUMBER_FORMAT, null, msgs);
			msgs = basicSetNumberFormat(newNumberFormat, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComputationModelPackage.NUMBER_FORMAT_MAPPING__NUMBER_FORMAT, newNumberFormat, newNumberFormat));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ComputationModelPackage.NUMBER_FORMAT_MAPPING__TYPE_SPECIFIER:
				return basicSetTypeSpecifier(null, msgs);
			case ComputationModelPackage.NUMBER_FORMAT_MAPPING__NUMBER_FORMAT:
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
			case ComputationModelPackage.NUMBER_FORMAT_MAPPING__TYPE_SPECIFIER:
				return getTypeSpecifier();
			case ComputationModelPackage.NUMBER_FORMAT_MAPPING__NUMBER_FORMAT:
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
			case ComputationModelPackage.NUMBER_FORMAT_MAPPING__TYPE_SPECIFIER:
				setTypeSpecifier((DataTypeSpecifier)newValue);
				return;
			case ComputationModelPackage.NUMBER_FORMAT_MAPPING__NUMBER_FORMAT:
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
			case ComputationModelPackage.NUMBER_FORMAT_MAPPING__TYPE_SPECIFIER:
				setTypeSpecifier((DataTypeSpecifier)null);
				return;
			case ComputationModelPackage.NUMBER_FORMAT_MAPPING__NUMBER_FORMAT:
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
			case ComputationModelPackage.NUMBER_FORMAT_MAPPING__TYPE_SPECIFIER:
				return typeSpecifier != null;
			case ComputationModelPackage.NUMBER_FORMAT_MAPPING__NUMBER_FORMAT:
				return numberFormat != null;
		}
		return super.eIsSet(featureID);
	}

} //NumberFormatMappingImpl
