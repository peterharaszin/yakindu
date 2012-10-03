/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.damos.dml.impl;

import java.util.Collection;

import org.eclipse.damos.dml.DMLPackage;
import org.eclipse.damos.dml.DataTypeSpecification;
import org.eclipse.damos.dml.Parameter;
import org.eclipse.damos.dml.ParameterPredefinedValue;
import org.eclipse.damos.dml.ParameterVisibilityKind;
import org.eclipse.damos.dml.ValueSpecification;
import org.eclipse.damos.dml.internal.operations.ParameterOperations;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.damos.dml.impl.ParameterImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.damos.dml.impl.ParameterImpl#getDataType <em>Data Type</em>}</li>
 *   <li>{@link org.eclipse.damos.dml.impl.ParameterImpl#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link org.eclipse.damos.dml.impl.ParameterImpl#getOwnedDefaultValue <em>Owned Default Value</em>}</li>
 *   <li>{@link org.eclipse.damos.dml.impl.ParameterImpl#getPredefinedValues <em>Predefined Values</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ParameterImpl extends EObjectImpl implements Parameter {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDataType() <em>Data Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataType()
	 * @generated
	 * @ordered
	 */
	protected DataTypeSpecification dataType;
	/**
	 * The default value of the '{@link #getVisibility() <em>Visibility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVisibility()
	 * @generated
	 * @ordered
	 */
	protected static final ParameterVisibilityKind VISIBILITY_EDEFAULT = ParameterVisibilityKind.PUBLIC;
	/**
	 * The cached value of the '{@link #getVisibility() <em>Visibility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVisibility()
	 * @generated
	 * @ordered
	 */
	protected ParameterVisibilityKind visibility = VISIBILITY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOwnedDefaultValue() <em>Owned Default Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedDefaultValue()
	 * @generated
	 * @ordered
	 */
	protected ValueSpecification ownedDefaultValue;
	/**
	 * The cached value of the '{@link #getPredefinedValues() <em>Predefined Values</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPredefinedValues()
	 * @generated
	 * @ordered
	 */
	protected EList<ParameterPredefinedValue> predefinedValues;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParameterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DMLPackage.Literals.PARAMETER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DMLPackage.PARAMETER__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataTypeSpecification getDataType() {
		return dataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDataType(DataTypeSpecification newDataType, NotificationChain msgs) {
		DataTypeSpecification oldDataType = dataType;
		dataType = newDataType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DMLPackage.PARAMETER__DATA_TYPE, oldDataType, newDataType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDataType(DataTypeSpecification newDataType) {
		if (newDataType != dataType) {
			NotificationChain msgs = null;
			if (dataType != null)
				msgs = ((InternalEObject)dataType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DMLPackage.PARAMETER__DATA_TYPE, null, msgs);
			if (newDataType != null)
				msgs = ((InternalEObject)newDataType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DMLPackage.PARAMETER__DATA_TYPE, null, msgs);
			msgs = basicSetDataType(newDataType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DMLPackage.PARAMETER__DATA_TYPE, newDataType, newDataType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterVisibilityKind getVisibility() {
		return visibility;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVisibility(ParameterVisibilityKind newVisibility) {
		ParameterVisibilityKind oldVisibility = visibility;
		visibility = newVisibility == null ? VISIBILITY_EDEFAULT : newVisibility;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DMLPackage.PARAMETER__VISIBILITY, oldVisibility, visibility));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueSpecification getOwnedDefaultValue() {
		return ownedDefaultValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedDefaultValue(ValueSpecification newOwnedDefaultValue, NotificationChain msgs) {
		ValueSpecification oldOwnedDefaultValue = ownedDefaultValue;
		ownedDefaultValue = newOwnedDefaultValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DMLPackage.PARAMETER__OWNED_DEFAULT_VALUE, oldOwnedDefaultValue, newOwnedDefaultValue);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwnedDefaultValue(ValueSpecification newOwnedDefaultValue) {
		if (newOwnedDefaultValue != ownedDefaultValue) {
			NotificationChain msgs = null;
			if (ownedDefaultValue != null)
				msgs = ((InternalEObject)ownedDefaultValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DMLPackage.PARAMETER__OWNED_DEFAULT_VALUE, null, msgs);
			if (newOwnedDefaultValue != null)
				msgs = ((InternalEObject)newOwnedDefaultValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DMLPackage.PARAMETER__OWNED_DEFAULT_VALUE, null, msgs);
			msgs = basicSetOwnedDefaultValue(newOwnedDefaultValue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DMLPackage.PARAMETER__OWNED_DEFAULT_VALUE, newOwnedDefaultValue, newOwnedDefaultValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ParameterPredefinedValue> getPredefinedValues() {
		if (predefinedValues == null) {
			predefinedValues = new EObjectContainmentEList<ParameterPredefinedValue>(ParameterPredefinedValue.class, this, DMLPackage.PARAMETER__PREDEFINED_VALUES);
		}
		return predefinedValues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ValueSpecification getDefaultValue() {
		return ParameterOperations.getDefaultValue(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ParameterPredefinedValue getPredefinedValue(String stringValue) {
		return ParameterOperations.getPredefinedValue(this, stringValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ParameterPredefinedValue getPredefinedValueByAlias(String alias) {
		return ParameterOperations.getPredefinedValueByAlias(this, alias);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DMLPackage.PARAMETER__DATA_TYPE:
				return basicSetDataType(null, msgs);
			case DMLPackage.PARAMETER__OWNED_DEFAULT_VALUE:
				return basicSetOwnedDefaultValue(null, msgs);
			case DMLPackage.PARAMETER__PREDEFINED_VALUES:
				return ((InternalEList<?>)getPredefinedValues()).basicRemove(otherEnd, msgs);
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
			case DMLPackage.PARAMETER__NAME:
				return getName();
			case DMLPackage.PARAMETER__DATA_TYPE:
				return getDataType();
			case DMLPackage.PARAMETER__VISIBILITY:
				return getVisibility();
			case DMLPackage.PARAMETER__OWNED_DEFAULT_VALUE:
				return getOwnedDefaultValue();
			case DMLPackage.PARAMETER__PREDEFINED_VALUES:
				return getPredefinedValues();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DMLPackage.PARAMETER__NAME:
				setName((String)newValue);
				return;
			case DMLPackage.PARAMETER__DATA_TYPE:
				setDataType((DataTypeSpecification)newValue);
				return;
			case DMLPackage.PARAMETER__VISIBILITY:
				setVisibility((ParameterVisibilityKind)newValue);
				return;
			case DMLPackage.PARAMETER__OWNED_DEFAULT_VALUE:
				setOwnedDefaultValue((ValueSpecification)newValue);
				return;
			case DMLPackage.PARAMETER__PREDEFINED_VALUES:
				getPredefinedValues().clear();
				getPredefinedValues().addAll((Collection<? extends ParameterPredefinedValue>)newValue);
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
			case DMLPackage.PARAMETER__NAME:
				setName(NAME_EDEFAULT);
				return;
			case DMLPackage.PARAMETER__DATA_TYPE:
				setDataType((DataTypeSpecification)null);
				return;
			case DMLPackage.PARAMETER__VISIBILITY:
				setVisibility(VISIBILITY_EDEFAULT);
				return;
			case DMLPackage.PARAMETER__OWNED_DEFAULT_VALUE:
				setOwnedDefaultValue((ValueSpecification)null);
				return;
			case DMLPackage.PARAMETER__PREDEFINED_VALUES:
				getPredefinedValues().clear();
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
			case DMLPackage.PARAMETER__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case DMLPackage.PARAMETER__DATA_TYPE:
				return dataType != null;
			case DMLPackage.PARAMETER__VISIBILITY:
				return visibility != VISIBILITY_EDEFAULT;
			case DMLPackage.PARAMETER__OWNED_DEFAULT_VALUE:
				return ownedDefaultValue != null;
			case DMLPackage.PARAMETER__PREDEFINED_VALUES:
				return predefinedValues != null && !predefinedValues.isEmpty();
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
		result.append(" (name: ");
		result.append(name);
		result.append(", visibility: ");
		result.append(visibility);
		result.append(')');
		return result.toString();
	}

} //ParameterImpl
