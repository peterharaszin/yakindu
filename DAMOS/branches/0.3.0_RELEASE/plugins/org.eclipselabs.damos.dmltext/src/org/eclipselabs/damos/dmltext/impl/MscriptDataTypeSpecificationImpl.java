/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dmltext.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipselabs.damos.dml.DataTypeSpecification;
import org.eclipselabs.damos.dml.impl.DataTypeSpecificationImpl;
import org.eclipselabs.damos.dmltext.DMLTextPackage;
import org.eclipselabs.damos.dmltext.MscriptDataTypeSpecification;
import org.eclipselabs.damos.dmltext.internal.operations.MscriptDataTypeSpecificationOperations;
import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.DataTypeSpecifier;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mscript Data Type Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.dmltext.impl.MscriptDataTypeSpecificationImpl#getSpecifier <em>Specifier</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dmltext.impl.MscriptDataTypeSpecificationImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MscriptDataTypeSpecificationImpl extends DataTypeSpecificationImpl implements MscriptDataTypeSpecification {
	/**
	 * The cached value of the '{@link #getSpecifier() <em>Specifier</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecifier()
	 * @generated
	 * @ordered
	 */
	protected DataTypeSpecifier specifier;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MscriptDataTypeSpecificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DMLTextPackage.Literals.MSCRIPT_DATA_TYPE_SPECIFICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataTypeSpecifier getSpecifier() {
		return specifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSpecifier(DataTypeSpecifier newSpecifier, NotificationChain msgs) {
		DataTypeSpecifier oldSpecifier = specifier;
		specifier = newSpecifier;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DMLTextPackage.MSCRIPT_DATA_TYPE_SPECIFICATION__SPECIFIER, oldSpecifier, newSpecifier);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpecifier(DataTypeSpecifier newSpecifier) {
		if (newSpecifier != specifier) {
			NotificationChain msgs = null;
			if (specifier != null)
				msgs = ((InternalEObject)specifier).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DMLTextPackage.MSCRIPT_DATA_TYPE_SPECIFICATION__SPECIFIER, null, msgs);
			if (newSpecifier != null)
				msgs = ((InternalEObject)newSpecifier).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DMLTextPackage.MSCRIPT_DATA_TYPE_SPECIFICATION__SPECIFIER, null, msgs);
			msgs = basicSetSpecifier(newSpecifier, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DMLTextPackage.MSCRIPT_DATA_TYPE_SPECIFICATION__SPECIFIER, newSpecifier, newSpecifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType getType() {
		DataType type = basicGetType();
		return type != null && type.eIsProxy() ? (DataType)eResolveProxy((InternalEObject)type) : type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public DataType basicGetType() {
		DataTypeSpecifier specifier = getSpecifier();
		return specifier != null ? specifier.getType() : null;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.dml.impl.DataTypeSpecificationImpl#copy()
	 */
	@Override
	public DataTypeSpecification copy() {
		return MscriptDataTypeSpecificationOperations.copy(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DMLTextPackage.MSCRIPT_DATA_TYPE_SPECIFICATION__SPECIFIER:
				return basicSetSpecifier(null, msgs);
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
			case DMLTextPackage.MSCRIPT_DATA_TYPE_SPECIFICATION__SPECIFIER:
				return getSpecifier();
			case DMLTextPackage.MSCRIPT_DATA_TYPE_SPECIFICATION__TYPE:
				if (resolve) return getType();
				return basicGetType();
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
			case DMLTextPackage.MSCRIPT_DATA_TYPE_SPECIFICATION__SPECIFIER:
				setSpecifier((DataTypeSpecifier)newValue);
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
			case DMLTextPackage.MSCRIPT_DATA_TYPE_SPECIFICATION__SPECIFIER:
				setSpecifier((DataTypeSpecifier)null);
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
			case DMLTextPackage.MSCRIPT_DATA_TYPE_SPECIFICATION__SPECIFIER:
				return specifier != null;
			case DMLTextPackage.MSCRIPT_DATA_TYPE_SPECIFICATION__TYPE:
				return basicGetType() != null;
		}
		return super.eIsSet(featureID);
	}

} //MscriptDataTypeSpecificationImpl
