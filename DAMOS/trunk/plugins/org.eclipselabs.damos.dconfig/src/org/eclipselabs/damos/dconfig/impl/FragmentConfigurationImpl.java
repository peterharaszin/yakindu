/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dconfig.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipselabs.damos.dconfig.DconfigPackage;
import org.eclipselabs.damos.dconfig.FragmentConfiguration;
import org.eclipselabs.damos.dconfig.FragmentConfigurationBody;
import org.eclipselabs.damos.dml.Fragment;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fragment Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.dconfig.impl.FragmentConfigurationImpl#getStartFragment <em>Start Fragment</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dconfig.impl.FragmentConfigurationImpl#getEndFragment <em>End Fragment</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dconfig.impl.FragmentConfigurationImpl#isRange <em>Range</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dconfig.impl.FragmentConfigurationImpl#getBody <em>Body</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FragmentConfigurationImpl extends EObjectImpl implements FragmentConfiguration {
	/**
	 * The cached value of the '{@link #getStartFragment() <em>Start Fragment</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartFragment()
	 * @generated
	 * @ordered
	 */
	protected Fragment startFragment;

	/**
	 * The cached value of the '{@link #getEndFragment() <em>End Fragment</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndFragment()
	 * @generated
	 * @ordered
	 */
	protected Fragment endFragment;

	/**
	 * The default value of the '{@link #isRange() <em>Range</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRange()
	 * @generated
	 * @ordered
	 */
	protected static final boolean RANGE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isRange() <em>Range</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRange()
	 * @generated
	 * @ordered
	 */
	protected boolean range = RANGE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBody() <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBody()
	 * @generated
	 * @ordered
	 */
	protected FragmentConfigurationBody body;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FragmentConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DconfigPackage.Literals.FRAGMENT_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Fragment getStartFragment() {
		if (startFragment != null && startFragment.eIsProxy()) {
			InternalEObject oldStartFragment = (InternalEObject)startFragment;
			startFragment = (Fragment)eResolveProxy(oldStartFragment);
			if (startFragment != oldStartFragment) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DconfigPackage.FRAGMENT_CONFIGURATION__START_FRAGMENT, oldStartFragment, startFragment));
			}
		}
		return startFragment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Fragment basicGetStartFragment() {
		return startFragment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartFragment(Fragment newStartFragment) {
		Fragment oldStartFragment = startFragment;
		startFragment = newStartFragment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DconfigPackage.FRAGMENT_CONFIGURATION__START_FRAGMENT, oldStartFragment, startFragment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Fragment getEndFragment() {
		if (endFragment != null && endFragment.eIsProxy()) {
			InternalEObject oldEndFragment = (InternalEObject)endFragment;
			endFragment = (Fragment)eResolveProxy(oldEndFragment);
			if (endFragment != oldEndFragment) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DconfigPackage.FRAGMENT_CONFIGURATION__END_FRAGMENT, oldEndFragment, endFragment));
			}
		}
		return endFragment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Fragment basicGetEndFragment() {
		return endFragment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndFragment(Fragment newEndFragment) {
		Fragment oldEndFragment = endFragment;
		endFragment = newEndFragment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DconfigPackage.FRAGMENT_CONFIGURATION__END_FRAGMENT, oldEndFragment, endFragment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRange() {
		return range;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRange(boolean newRange) {
		boolean oldRange = range;
		range = newRange;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DconfigPackage.FRAGMENT_CONFIGURATION__RANGE, oldRange, range));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FragmentConfigurationBody getBody() {
		return body;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBody(FragmentConfigurationBody newBody, NotificationChain msgs) {
		FragmentConfigurationBody oldBody = body;
		body = newBody;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DconfigPackage.FRAGMENT_CONFIGURATION__BODY, oldBody, newBody);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBody(FragmentConfigurationBody newBody) {
		if (newBody != body) {
			NotificationChain msgs = null;
			if (body != null)
				msgs = ((InternalEObject)body).eInverseRemove(this, DconfigPackage.FRAGMENT_CONFIGURATION_BODY__OWNER, FragmentConfigurationBody.class, msgs);
			if (newBody != null)
				msgs = ((InternalEObject)newBody).eInverseAdd(this, DconfigPackage.FRAGMENT_CONFIGURATION_BODY__OWNER, FragmentConfigurationBody.class, msgs);
			msgs = basicSetBody(newBody, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DconfigPackage.FRAGMENT_CONFIGURATION__BODY, newBody, newBody));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DconfigPackage.FRAGMENT_CONFIGURATION__BODY:
				if (body != null)
					msgs = ((InternalEObject)body).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DconfigPackage.FRAGMENT_CONFIGURATION__BODY, null, msgs);
				return basicSetBody((FragmentConfigurationBody)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DconfigPackage.FRAGMENT_CONFIGURATION__BODY:
				return basicSetBody(null, msgs);
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
			case DconfigPackage.FRAGMENT_CONFIGURATION__START_FRAGMENT:
				if (resolve) return getStartFragment();
				return basicGetStartFragment();
			case DconfigPackage.FRAGMENT_CONFIGURATION__END_FRAGMENT:
				if (resolve) return getEndFragment();
				return basicGetEndFragment();
			case DconfigPackage.FRAGMENT_CONFIGURATION__RANGE:
				return isRange();
			case DconfigPackage.FRAGMENT_CONFIGURATION__BODY:
				return getBody();
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
			case DconfigPackage.FRAGMENT_CONFIGURATION__START_FRAGMENT:
				setStartFragment((Fragment)newValue);
				return;
			case DconfigPackage.FRAGMENT_CONFIGURATION__END_FRAGMENT:
				setEndFragment((Fragment)newValue);
				return;
			case DconfigPackage.FRAGMENT_CONFIGURATION__RANGE:
				setRange((Boolean)newValue);
				return;
			case DconfigPackage.FRAGMENT_CONFIGURATION__BODY:
				setBody((FragmentConfigurationBody)newValue);
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
			case DconfigPackage.FRAGMENT_CONFIGURATION__START_FRAGMENT:
				setStartFragment((Fragment)null);
				return;
			case DconfigPackage.FRAGMENT_CONFIGURATION__END_FRAGMENT:
				setEndFragment((Fragment)null);
				return;
			case DconfigPackage.FRAGMENT_CONFIGURATION__RANGE:
				setRange(RANGE_EDEFAULT);
				return;
			case DconfigPackage.FRAGMENT_CONFIGURATION__BODY:
				setBody((FragmentConfigurationBody)null);
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
			case DconfigPackage.FRAGMENT_CONFIGURATION__START_FRAGMENT:
				return startFragment != null;
			case DconfigPackage.FRAGMENT_CONFIGURATION__END_FRAGMENT:
				return endFragment != null;
			case DconfigPackage.FRAGMENT_CONFIGURATION__RANGE:
				return range != RANGE_EDEFAULT;
			case DconfigPackage.FRAGMENT_CONFIGURATION__BODY:
				return body != null;
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
		result.append(" (range: ");
		result.append(range);
		result.append(')');
		return result.toString();
	}

} //FragmentConfigurationImpl
