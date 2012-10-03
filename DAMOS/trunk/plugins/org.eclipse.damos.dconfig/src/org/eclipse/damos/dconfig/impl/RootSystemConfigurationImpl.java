/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.damos.dconfig.impl;

import org.eclipse.damos.dconfig.DconfigPackage;
import org.eclipse.damos.dconfig.RootSystemConfiguration;
import org.eclipse.damos.dml.Fragment;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Root System Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.damos.dconfig.impl.RootSystemConfigurationImpl#getContextFragment <em>Context Fragment</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RootSystemConfigurationImpl extends SystemConfigurationImpl implements RootSystemConfiguration {
	/**
	 * The cached value of the '{@link #getContextFragment() <em>Context Fragment</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContextFragment()
	 * @generated
	 * @ordered
	 */
	protected Fragment contextFragment;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RootSystemConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DconfigPackage.Literals.ROOT_SYSTEM_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Fragment getContextFragment() {
		if (contextFragment != null && contextFragment.eIsProxy()) {
			InternalEObject oldContextFragment = (InternalEObject)contextFragment;
			contextFragment = (Fragment)eResolveProxy(oldContextFragment);
			if (contextFragment != oldContextFragment) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DconfigPackage.ROOT_SYSTEM_CONFIGURATION__CONTEXT_FRAGMENT, oldContextFragment, contextFragment));
			}
		}
		return contextFragment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Fragment basicGetContextFragment() {
		return contextFragment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContextFragment(Fragment newContextFragment) {
		Fragment oldContextFragment = contextFragment;
		contextFragment = newContextFragment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DconfigPackage.ROOT_SYSTEM_CONFIGURATION__CONTEXT_FRAGMENT, oldContextFragment, contextFragment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DconfigPackage.ROOT_SYSTEM_CONFIGURATION__CONTEXT_FRAGMENT:
				if (resolve) return getContextFragment();
				return basicGetContextFragment();
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
			case DconfigPackage.ROOT_SYSTEM_CONFIGURATION__CONTEXT_FRAGMENT:
				setContextFragment((Fragment)newValue);
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
			case DconfigPackage.ROOT_SYSTEM_CONFIGURATION__CONTEXT_FRAGMENT:
				setContextFragment((Fragment)null);
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
			case DconfigPackage.ROOT_SYSTEM_CONFIGURATION__CONTEXT_FRAGMENT:
				return contextFragment != null;
		}
		return super.eIsSet(featureID);
	}

} //RootSystemConfigurationImpl
