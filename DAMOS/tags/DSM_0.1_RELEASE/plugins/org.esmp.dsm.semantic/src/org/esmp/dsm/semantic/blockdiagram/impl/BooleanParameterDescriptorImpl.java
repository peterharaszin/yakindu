/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.esmp.dsm.semantic.blockdiagram.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage;
import org.esmp.dsm.semantic.blockdiagram.BooleanParameterDescriptor;
import org.esmp.dsm.semantic.blockdiagram.BooleanValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Boolean Parameter Descriptor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.impl.BooleanParameterDescriptorImpl#getDefaultBooleanValue <em>Default Boolean Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BooleanParameterDescriptorImpl extends ParameterDescriptorImpl implements BooleanParameterDescriptor {
	/**
	 * The default value of the '{@link #getDefaultBooleanValue() <em>Default Boolean Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultBooleanValue()
	 * @generated
	 * @ordered
	 */
	protected static final BooleanValue DEFAULT_BOOLEAN_VALUE_EDEFAULT = BooleanValue.FALSE;

	/**
	 * The cached value of the '{@link #getDefaultBooleanValue() <em>Default Boolean Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultBooleanValue()
	 * @generated
	 * @ordered
	 */
	protected BooleanValue defaultBooleanValue = DEFAULT_BOOLEAN_VALUE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BooleanParameterDescriptorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BlockDiagramPackage.Literals.BOOLEAN_PARAMETER_DESCRIPTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanValue getDefaultBooleanValue() {
		return defaultBooleanValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultBooleanValue(BooleanValue newDefaultBooleanValue) {
		BooleanValue oldDefaultBooleanValue = defaultBooleanValue;
		defaultBooleanValue = newDefaultBooleanValue == null ? DEFAULT_BOOLEAN_VALUE_EDEFAULT : newDefaultBooleanValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BlockDiagramPackage.BOOLEAN_PARAMETER_DESCRIPTOR__DEFAULT_BOOLEAN_VALUE, oldDefaultBooleanValue, defaultBooleanValue));
	}

	public String getDefaultValue() {
		switch (getDefaultBooleanValue()) {
		case TRUE:
			return Boolean.toString(true);
		case FALSE:
			return Boolean.toString(false);
		}
		return "";
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BlockDiagramPackage.BOOLEAN_PARAMETER_DESCRIPTOR__DEFAULT_BOOLEAN_VALUE:
				return getDefaultBooleanValue();
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
			case BlockDiagramPackage.BOOLEAN_PARAMETER_DESCRIPTOR__DEFAULT_BOOLEAN_VALUE:
				setDefaultBooleanValue((BooleanValue)newValue);
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
			case BlockDiagramPackage.BOOLEAN_PARAMETER_DESCRIPTOR__DEFAULT_BOOLEAN_VALUE:
				setDefaultBooleanValue(DEFAULT_BOOLEAN_VALUE_EDEFAULT);
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
			case BlockDiagramPackage.BOOLEAN_PARAMETER_DESCRIPTOR__DEFAULT_BOOLEAN_VALUE:
				return defaultBooleanValue != DEFAULT_BOOLEAN_VALUE_EDEFAULT;
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
		result.append(" (defaultBooleanValue: ");
		result.append(defaultBooleanValue);
		result.append(')');
		return result.toString();
	}

} //BooleanParameterDescriptorImpl
