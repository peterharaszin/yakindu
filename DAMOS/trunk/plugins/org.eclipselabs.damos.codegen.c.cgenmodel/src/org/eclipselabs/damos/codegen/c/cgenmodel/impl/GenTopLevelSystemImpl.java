/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.codegen.c.cgenmodel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipselabs.damos.codegen.c.cgenmodel.CGenModelPackage;
import org.eclipselabs.damos.codegen.c.cgenmodel.GenTopLevelSystem;
import org.eclipselabs.damos.dml.Fragment;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gen Top Level System</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.codegen.c.cgenmodel.impl.GenTopLevelSystemImpl#getFragment <em>Fragment</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GenTopLevelSystemImpl extends GenSystemImpl implements GenTopLevelSystem {
	/**
	 * The cached value of the '{@link #getFragment() <em>Fragment</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFragment()
	 * @generated
	 * @ordered
	 */
	protected Fragment fragment;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GenTopLevelSystemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CGenModelPackage.Literals.GEN_TOP_LEVEL_SYSTEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Fragment getFragment() {
		if (fragment != null && fragment.eIsProxy()) {
			InternalEObject oldFragment = (InternalEObject)fragment;
			fragment = (Fragment)eResolveProxy(oldFragment);
			if (fragment != oldFragment) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CGenModelPackage.GEN_TOP_LEVEL_SYSTEM__FRAGMENT, oldFragment, fragment));
			}
		}
		return fragment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Fragment basicGetFragment() {
		return fragment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFragment(Fragment newFragment) {
		Fragment oldFragment = fragment;
		fragment = newFragment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CGenModelPackage.GEN_TOP_LEVEL_SYSTEM__FRAGMENT, oldFragment, fragment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CGenModelPackage.GEN_TOP_LEVEL_SYSTEM__FRAGMENT:
				if (resolve) return getFragment();
				return basicGetFragment();
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
			case CGenModelPackage.GEN_TOP_LEVEL_SYSTEM__FRAGMENT:
				setFragment((Fragment)newValue);
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
			case CGenModelPackage.GEN_TOP_LEVEL_SYSTEM__FRAGMENT:
				setFragment((Fragment)null);
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
			case CGenModelPackage.GEN_TOP_LEVEL_SYSTEM__FRAGMENT:
				return fragment != null;
		}
		return super.eIsSet(featureID);
	}

} //GenTopLevelSystemImpl
