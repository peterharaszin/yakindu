/**
 */
package org.eclipselabs.damos.dscript.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipselabs.damos.dml.impl.DataTypeSpecificationImpl;
import org.eclipselabs.damos.dscript.DscriptPackage;
import org.eclipselabs.damos.dscript.DscriptDataTypeSpecification;
import org.eclipselabs.damos.mscript.Type;
import org.eclipselabs.damos.mscript.TypeSpecifier;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mscript Data Type Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.dscript.impl.DscriptDataTypeSpecificationImpl#getTypeSpecifier <em>Type Specifier</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dscript.impl.DscriptDataTypeSpecificationImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DscriptDataTypeSpecificationImpl extends DataTypeSpecificationImpl implements DscriptDataTypeSpecification {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DscriptDataTypeSpecificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DscriptPackage.Literals.DSCRIPT_DATA_TYPE_SPECIFICATION;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DscriptPackage.DSCRIPT_DATA_TYPE_SPECIFICATION__TYPE_SPECIFIER, oldTypeSpecifier, newTypeSpecifier);
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
				msgs = ((InternalEObject)typeSpecifier).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DscriptPackage.DSCRIPT_DATA_TYPE_SPECIFICATION__TYPE_SPECIFIER, null, msgs);
			if (newTypeSpecifier != null)
				msgs = ((InternalEObject)newTypeSpecifier).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DscriptPackage.DSCRIPT_DATA_TYPE_SPECIFICATION__TYPE_SPECIFIER, null, msgs);
			msgs = basicSetTypeSpecifier(newTypeSpecifier, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DscriptPackage.DSCRIPT_DATA_TYPE_SPECIFICATION__TYPE_SPECIFIER, newTypeSpecifier, newTypeSpecifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type getType() {
		Type type = basicGetType();
		return type != null && type.eIsProxy() ? (Type)eResolveProxy((InternalEObject)type) : type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Type basicGetType() {
		TypeSpecifier typeSpecifier = getTypeSpecifier();
		return typeSpecifier != null ? typeSpecifier.getType() : null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DscriptPackage.DSCRIPT_DATA_TYPE_SPECIFICATION__TYPE_SPECIFIER:
				return basicSetTypeSpecifier(null, msgs);
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
			case DscriptPackage.DSCRIPT_DATA_TYPE_SPECIFICATION__TYPE_SPECIFIER:
				return getTypeSpecifier();
			case DscriptPackage.DSCRIPT_DATA_TYPE_SPECIFICATION__TYPE:
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
			case DscriptPackage.DSCRIPT_DATA_TYPE_SPECIFICATION__TYPE_SPECIFIER:
				setTypeSpecifier((TypeSpecifier)newValue);
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
			case DscriptPackage.DSCRIPT_DATA_TYPE_SPECIFICATION__TYPE_SPECIFIER:
				setTypeSpecifier((TypeSpecifier)null);
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
			case DscriptPackage.DSCRIPT_DATA_TYPE_SPECIFICATION__TYPE_SPECIFIER:
				return typeSpecifier != null;
			case DscriptPackage.DSCRIPT_DATA_TYPE_SPECIFICATION__TYPE:
				return basicGetType() != null;
		}
		return super.eIsSet(featureID);
	}

} //MscriptDataTypeSpecificationImpl
