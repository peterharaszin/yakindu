/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.damos.dml.impl;

import org.eclipse.damos.dml.DMLPackage;
import org.eclipse.damos.dml.Fragment;
import org.eclipse.damos.dml.FragmentElement;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EModelElementImpl;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fragment Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.damos.dml.impl.FragmentElementImpl#getOwningFragment <em>Owning Fragment</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class FragmentElementImpl extends EModelElementImpl implements FragmentElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FragmentElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DMLPackage.Literals.FRAGMENT_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Fragment getOwningFragment() {
		if (eContainerFeatureID() != DMLPackage.FRAGMENT_ELEMENT__OWNING_FRAGMENT) return null;
		return (Fragment)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningFragment(Fragment newOwningFragment, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningFragment, DMLPackage.FRAGMENT_ELEMENT__OWNING_FRAGMENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwningFragment(Fragment newOwningFragment) {
		if (newOwningFragment != eInternalContainer() || (eContainerFeatureID() != DMLPackage.FRAGMENT_ELEMENT__OWNING_FRAGMENT && newOwningFragment != null)) {
			if (EcoreUtil.isAncestor(this, newOwningFragment))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningFragment != null)
				msgs = ((InternalEObject)newOwningFragment).eInverseAdd(this, DMLPackage.FRAGMENT__FRAGMENT_ELEMENTS, Fragment.class, msgs);
			msgs = basicSetOwningFragment(newOwningFragment, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DMLPackage.FRAGMENT_ELEMENT__OWNING_FRAGMENT, newOwningFragment, newOwningFragment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Fragment getEnclosingFragment() {
		EObject container = eContainer();
		while (container != null) {
			if (container instanceof Fragment) {
				return (Fragment) container;
			}
			container = container.eContainer();
		}
		return null; 
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DMLPackage.FRAGMENT_ELEMENT__OWNING_FRAGMENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningFragment((Fragment)otherEnd, msgs);
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
			case DMLPackage.FRAGMENT_ELEMENT__OWNING_FRAGMENT:
				return basicSetOwningFragment(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case DMLPackage.FRAGMENT_ELEMENT__OWNING_FRAGMENT:
				return eInternalContainer().eInverseRemove(this, DMLPackage.FRAGMENT__FRAGMENT_ELEMENTS, Fragment.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DMLPackage.FRAGMENT_ELEMENT__OWNING_FRAGMENT:
				return getOwningFragment();
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
			case DMLPackage.FRAGMENT_ELEMENT__OWNING_FRAGMENT:
				setOwningFragment((Fragment)newValue);
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
			case DMLPackage.FRAGMENT_ELEMENT__OWNING_FRAGMENT:
				setOwningFragment((Fragment)null);
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
			case DMLPackage.FRAGMENT_ELEMENT__OWNING_FRAGMENT:
				return getOwningFragment() != null;
		}
		return super.eIsSet(featureID);
	}

} //FragmentElementImpl
