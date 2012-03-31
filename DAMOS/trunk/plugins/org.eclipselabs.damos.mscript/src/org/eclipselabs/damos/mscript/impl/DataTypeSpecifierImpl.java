/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.mscript.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.DataTypeSpecifier;
import org.eclipselabs.damos.mscript.MscriptPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Type Specifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.mscript.impl.DataTypeSpecifierImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.impl.DataTypeSpecifierImpl#getAnonymousType <em>Anonymous Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DataTypeSpecifierImpl extends MinimalEObjectImpl.Container implements DataTypeSpecifier {
	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected DataType type;
	/**
	 * The cached value of the '{@link #getAnonymousType() <em>Anonymous Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnonymousType()
	 * @generated
	 * @ordered
	 */
	protected DataType anonymousType;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataTypeSpecifierImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MscriptPackage.Literals.DATA_TYPE_SPECIFIER;
	}

	public DataType getType() {
		DataType type = getTypeGen();
		if (type == null) {
			type = getAnonymousType();
		}
		return type;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType getTypeGen() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject)type;
			type = (DataType)eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MscriptPackage.DATA_TYPE_SPECIFIER__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(DataType newType) {
		DataType oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MscriptPackage.DATA_TYPE_SPECIFIER__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType getAnonymousType() {
		return anonymousType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAnonymousType(DataType newAnonymousType, NotificationChain msgs) {
		DataType oldAnonymousType = anonymousType;
		anonymousType = newAnonymousType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MscriptPackage.DATA_TYPE_SPECIFIER__ANONYMOUS_TYPE, oldAnonymousType, newAnonymousType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAnonymousType(DataType newAnonymousType) {
		if (newAnonymousType != anonymousType) {
			NotificationChain msgs = null;
			if (anonymousType != null)
				msgs = ((InternalEObject)anonymousType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MscriptPackage.DATA_TYPE_SPECIFIER__ANONYMOUS_TYPE, null, msgs);
			if (newAnonymousType != null)
				msgs = ((InternalEObject)newAnonymousType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MscriptPackage.DATA_TYPE_SPECIFIER__ANONYMOUS_TYPE, null, msgs);
			msgs = basicSetAnonymousType(newAnonymousType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MscriptPackage.DATA_TYPE_SPECIFIER__ANONYMOUS_TYPE, newAnonymousType, newAnonymousType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MscriptPackage.DATA_TYPE_SPECIFIER__ANONYMOUS_TYPE:
				return basicSetAnonymousType(null, msgs);
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
			case MscriptPackage.DATA_TYPE_SPECIFIER__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case MscriptPackage.DATA_TYPE_SPECIFIER__ANONYMOUS_TYPE:
				return getAnonymousType();
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
			case MscriptPackage.DATA_TYPE_SPECIFIER__TYPE:
				setType((DataType)newValue);
				return;
			case MscriptPackage.DATA_TYPE_SPECIFIER__ANONYMOUS_TYPE:
				setAnonymousType((DataType)newValue);
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
			case MscriptPackage.DATA_TYPE_SPECIFIER__TYPE:
				setType((DataType)null);
				return;
			case MscriptPackage.DATA_TYPE_SPECIFIER__ANONYMOUS_TYPE:
				setAnonymousType((DataType)null);
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
			case MscriptPackage.DATA_TYPE_SPECIFIER__TYPE:
				return type != null;
			case MscriptPackage.DATA_TYPE_SPECIFIER__ANONYMOUS_TYPE:
				return anonymousType != null;
		}
		return super.eIsSet(featureID);
	}

} //DataTypeSpecifierImpl
