/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dml.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipselabs.damos.dml.BooleanDirectFeedthroughPolicy;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.internal.operations.BooleanDirectFeedthroughPolicyOperations;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Boolean Direct Feedthrough Policy</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.dml.impl.BooleanDirectFeedthroughPolicyImpl#isDirectFeedthrough <em>Direct Feedthrough</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BooleanDirectFeedthroughPolicyImpl extends DirectFeedthroughPolicyImpl implements BooleanDirectFeedthroughPolicy {
	/**
	 * The default value of the '{@link #isDirectFeedthrough() <em>Direct Feedthrough</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDirectFeedthrough()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DIRECT_FEEDTHROUGH_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDirectFeedthrough() <em>Direct Feedthrough</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDirectFeedthrough()
	 * @generated
	 * @ordered
	 */
	protected boolean directFeedthrough = DIRECT_FEEDTHROUGH_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BooleanDirectFeedthroughPolicyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DMLPackage.Literals.BOOLEAN_DIRECT_FEEDTHROUGH_POLICY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDirectFeedthrough() {
		return directFeedthrough;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDirectFeedthrough(boolean newDirectFeedthrough) {
		boolean oldDirectFeedthrough = directFeedthrough;
		directFeedthrough = newDirectFeedthrough;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DMLPackage.BOOLEAN_DIRECT_FEEDTHROUGH_POLICY__DIRECT_FEEDTHROUGH, oldDirectFeedthrough, directFeedthrough));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public boolean computeDirectFeedthrough() {
		return BooleanDirectFeedthroughPolicyOperations.computeDirectFeedthrough(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DMLPackage.BOOLEAN_DIRECT_FEEDTHROUGH_POLICY__DIRECT_FEEDTHROUGH:
				return isDirectFeedthrough();
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
			case DMLPackage.BOOLEAN_DIRECT_FEEDTHROUGH_POLICY__DIRECT_FEEDTHROUGH:
				setDirectFeedthrough((Boolean)newValue);
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
			case DMLPackage.BOOLEAN_DIRECT_FEEDTHROUGH_POLICY__DIRECT_FEEDTHROUGH:
				setDirectFeedthrough(DIRECT_FEEDTHROUGH_EDEFAULT);
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
			case DMLPackage.BOOLEAN_DIRECT_FEEDTHROUGH_POLICY__DIRECT_FEEDTHROUGH:
				return directFeedthrough != DIRECT_FEEDTHROUGH_EDEFAULT;
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
		result.append(" (directFeedthrough: ");
		result.append(directFeedthrough);
		result.append(')');
		return result.toString();
	}

} //BooleanDirectFeedthroughPolicyImpl
