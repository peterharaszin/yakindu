/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.damos.dconfig.impl;

import org.eclipse.damos.dconfig.BindingResourceReference;
import org.eclipse.damos.dconfig.BindingResourceSubscript;
import org.eclipse.damos.dconfig.DconfigPackage;
import org.eclipse.damos.dconfig.ResourceDeclaration;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Binding Resource Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.damos.dconfig.impl.BindingResourceReferenceImpl#getResourceDeclaration <em>Resource Declaration</em>}</li>
 *   <li>{@link org.eclipse.damos.dconfig.impl.BindingResourceReferenceImpl#getSubscript <em>Subscript</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BindingResourceReferenceImpl extends EObjectImpl implements BindingResourceReference {
	/**
	 * The cached value of the '{@link #getResourceDeclaration() <em>Resource Declaration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceDeclaration()
	 * @generated
	 * @ordered
	 */
	protected ResourceDeclaration resourceDeclaration;

	/**
	 * The cached value of the '{@link #getSubscript() <em>Subscript</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubscript()
	 * @generated
	 * @ordered
	 */
	protected BindingResourceSubscript subscript;

	/**
	 * This is true if the Subscript containment reference has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean subscriptESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BindingResourceReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DconfigPackage.Literals.BINDING_RESOURCE_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceDeclaration getResourceDeclaration() {
		if (resourceDeclaration != null && resourceDeclaration.eIsProxy()) {
			InternalEObject oldResourceDeclaration = (InternalEObject)resourceDeclaration;
			resourceDeclaration = (ResourceDeclaration)eResolveProxy(oldResourceDeclaration);
			if (resourceDeclaration != oldResourceDeclaration) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DconfigPackage.BINDING_RESOURCE_REFERENCE__RESOURCE_DECLARATION, oldResourceDeclaration, resourceDeclaration));
			}
		}
		return resourceDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceDeclaration basicGetResourceDeclaration() {
		return resourceDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResourceDeclaration(ResourceDeclaration newResourceDeclaration) {
		ResourceDeclaration oldResourceDeclaration = resourceDeclaration;
		resourceDeclaration = newResourceDeclaration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DconfigPackage.BINDING_RESOURCE_REFERENCE__RESOURCE_DECLARATION, oldResourceDeclaration, resourceDeclaration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BindingResourceSubscript getSubscript() {
		return subscript;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSubscript(BindingResourceSubscript newSubscript, NotificationChain msgs) {
		BindingResourceSubscript oldSubscript = subscript;
		subscript = newSubscript;
		boolean oldSubscriptESet = subscriptESet;
		subscriptESet = true;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DconfigPackage.BINDING_RESOURCE_REFERENCE__SUBSCRIPT, oldSubscript, newSubscript, !oldSubscriptESet);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubscript(BindingResourceSubscript newSubscript) {
		if (newSubscript != subscript) {
			NotificationChain msgs = null;
			if (subscript != null)
				msgs = ((InternalEObject)subscript).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DconfigPackage.BINDING_RESOURCE_REFERENCE__SUBSCRIPT, null, msgs);
			if (newSubscript != null)
				msgs = ((InternalEObject)newSubscript).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DconfigPackage.BINDING_RESOURCE_REFERENCE__SUBSCRIPT, null, msgs);
			msgs = basicSetSubscript(newSubscript, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else {
			boolean oldSubscriptESet = subscriptESet;
			subscriptESet = true;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.SET, DconfigPackage.BINDING_RESOURCE_REFERENCE__SUBSCRIPT, newSubscript, newSubscript, !oldSubscriptESet));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicUnsetSubscript(NotificationChain msgs) {
		BindingResourceSubscript oldSubscript = subscript;
		subscript = null;
		boolean oldSubscriptESet = subscriptESet;
		subscriptESet = false;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.UNSET, DconfigPackage.BINDING_RESOURCE_REFERENCE__SUBSCRIPT, oldSubscript, null, oldSubscriptESet);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSubscript() {
		if (subscript != null) {
			NotificationChain msgs = null;
			msgs = ((InternalEObject)subscript).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DconfigPackage.BINDING_RESOURCE_REFERENCE__SUBSCRIPT, null, msgs);
			msgs = basicUnsetSubscript(msgs);
			if (msgs != null) msgs.dispatch();
		}
		else {
			boolean oldSubscriptESet = subscriptESet;
			subscriptESet = false;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.UNSET, DconfigPackage.BINDING_RESOURCE_REFERENCE__SUBSCRIPT, null, null, oldSubscriptESet));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSubscript() {
		return subscriptESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DconfigPackage.BINDING_RESOURCE_REFERENCE__SUBSCRIPT:
				return basicUnsetSubscript(msgs);
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
			case DconfigPackage.BINDING_RESOURCE_REFERENCE__RESOURCE_DECLARATION:
				if (resolve) return getResourceDeclaration();
				return basicGetResourceDeclaration();
			case DconfigPackage.BINDING_RESOURCE_REFERENCE__SUBSCRIPT:
				return getSubscript();
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
			case DconfigPackage.BINDING_RESOURCE_REFERENCE__RESOURCE_DECLARATION:
				setResourceDeclaration((ResourceDeclaration)newValue);
				return;
			case DconfigPackage.BINDING_RESOURCE_REFERENCE__SUBSCRIPT:
				setSubscript((BindingResourceSubscript)newValue);
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
			case DconfigPackage.BINDING_RESOURCE_REFERENCE__RESOURCE_DECLARATION:
				setResourceDeclaration((ResourceDeclaration)null);
				return;
			case DconfigPackage.BINDING_RESOURCE_REFERENCE__SUBSCRIPT:
				unsetSubscript();
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
			case DconfigPackage.BINDING_RESOURCE_REFERENCE__RESOURCE_DECLARATION:
				return resourceDeclaration != null;
			case DconfigPackage.BINDING_RESOURCE_REFERENCE__SUBSCRIPT:
				return isSetSubscript();
		}
		return super.eIsSet(featureID);
	}

} //BindingResourceReferenceImpl
