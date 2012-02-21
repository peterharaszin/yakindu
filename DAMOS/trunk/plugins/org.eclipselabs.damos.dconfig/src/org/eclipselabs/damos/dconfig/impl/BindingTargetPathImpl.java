/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dconfig.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipselabs.damos.dconfig.BindingPropertyReference;
import org.eclipselabs.damos.dconfig.BindingSubscript;
import org.eclipselabs.damos.dconfig.BindingTargetPath;
import org.eclipselabs.damos.dconfig.DconfigPackage;
import org.eclipselabs.damos.dconfig.ResourceDeclaration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Binding Target Path</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.dconfig.impl.BindingTargetPathImpl#getPropertyReferences <em>Property References</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dconfig.impl.BindingTargetPathImpl#getResource <em>Resource</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dconfig.impl.BindingTargetPathImpl#getSubscript <em>Subscript</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BindingTargetPathImpl extends EObjectImpl implements BindingTargetPath {
	/**
	 * The cached value of the '{@link #getPropertyReferences() <em>Property References</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyReferences()
	 * @generated
	 * @ordered
	 */
	protected EList<BindingPropertyReference> propertyReferences;

	/**
	 * The cached value of the '{@link #getResource() <em>Resource</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResource()
	 * @generated
	 * @ordered
	 */
	protected ResourceDeclaration resource;

	/**
	 * The cached value of the '{@link #getSubscript() <em>Subscript</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubscript()
	 * @generated
	 * @ordered
	 */
	protected BindingSubscript subscript;

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
	protected BindingTargetPathImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DconfigPackage.Literals.BINDING_TARGET_PATH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BindingPropertyReference> getPropertyReferences() {
		if (propertyReferences == null) {
			propertyReferences = new EObjectContainmentEList<BindingPropertyReference>(BindingPropertyReference.class, this, DconfigPackage.BINDING_TARGET_PATH__PROPERTY_REFERENCES);
		}
		return propertyReferences;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceDeclaration getResource() {
		if (resource != null && resource.eIsProxy()) {
			InternalEObject oldResource = (InternalEObject)resource;
			resource = (ResourceDeclaration)eResolveProxy(oldResource);
			if (resource != oldResource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DconfigPackage.BINDING_TARGET_PATH__RESOURCE, oldResource, resource));
			}
		}
		return resource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceDeclaration basicGetResource() {
		return resource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResource(ResourceDeclaration newResource) {
		ResourceDeclaration oldResource = resource;
		resource = newResource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DconfigPackage.BINDING_TARGET_PATH__RESOURCE, oldResource, resource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BindingSubscript getSubscript() {
		return subscript;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSubscript(BindingSubscript newSubscript, NotificationChain msgs) {
		BindingSubscript oldSubscript = subscript;
		subscript = newSubscript;
		boolean oldSubscriptESet = subscriptESet;
		subscriptESet = true;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DconfigPackage.BINDING_TARGET_PATH__SUBSCRIPT, oldSubscript, newSubscript, !oldSubscriptESet);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubscript(BindingSubscript newSubscript) {
		if (newSubscript != subscript) {
			NotificationChain msgs = null;
			if (subscript != null)
				msgs = ((InternalEObject)subscript).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DconfigPackage.BINDING_TARGET_PATH__SUBSCRIPT, null, msgs);
			if (newSubscript != null)
				msgs = ((InternalEObject)newSubscript).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DconfigPackage.BINDING_TARGET_PATH__SUBSCRIPT, null, msgs);
			msgs = basicSetSubscript(newSubscript, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else {
			boolean oldSubscriptESet = subscriptESet;
			subscriptESet = true;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.SET, DconfigPackage.BINDING_TARGET_PATH__SUBSCRIPT, newSubscript, newSubscript, !oldSubscriptESet));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicUnsetSubscript(NotificationChain msgs) {
		BindingSubscript oldSubscript = subscript;
		subscript = null;
		boolean oldSubscriptESet = subscriptESet;
		subscriptESet = false;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.UNSET, DconfigPackage.BINDING_TARGET_PATH__SUBSCRIPT, oldSubscript, null, oldSubscriptESet);
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
			msgs = ((InternalEObject)subscript).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DconfigPackage.BINDING_TARGET_PATH__SUBSCRIPT, null, msgs);
			msgs = basicUnsetSubscript(msgs);
			if (msgs != null) msgs.dispatch();
		}
		else {
			boolean oldSubscriptESet = subscriptESet;
			subscriptESet = false;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.UNSET, DconfigPackage.BINDING_TARGET_PATH__SUBSCRIPT, null, null, oldSubscriptESet));
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
			case DconfigPackage.BINDING_TARGET_PATH__PROPERTY_REFERENCES:
				return ((InternalEList<?>)getPropertyReferences()).basicRemove(otherEnd, msgs);
			case DconfigPackage.BINDING_TARGET_PATH__SUBSCRIPT:
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
			case DconfigPackage.BINDING_TARGET_PATH__PROPERTY_REFERENCES:
				return getPropertyReferences();
			case DconfigPackage.BINDING_TARGET_PATH__RESOURCE:
				if (resolve) return getResource();
				return basicGetResource();
			case DconfigPackage.BINDING_TARGET_PATH__SUBSCRIPT:
				return getSubscript();
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
			case DconfigPackage.BINDING_TARGET_PATH__PROPERTY_REFERENCES:
				getPropertyReferences().clear();
				getPropertyReferences().addAll((Collection<? extends BindingPropertyReference>)newValue);
				return;
			case DconfigPackage.BINDING_TARGET_PATH__RESOURCE:
				setResource((ResourceDeclaration)newValue);
				return;
			case DconfigPackage.BINDING_TARGET_PATH__SUBSCRIPT:
				setSubscript((BindingSubscript)newValue);
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
			case DconfigPackage.BINDING_TARGET_PATH__PROPERTY_REFERENCES:
				getPropertyReferences().clear();
				return;
			case DconfigPackage.BINDING_TARGET_PATH__RESOURCE:
				setResource((ResourceDeclaration)null);
				return;
			case DconfigPackage.BINDING_TARGET_PATH__SUBSCRIPT:
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
			case DconfigPackage.BINDING_TARGET_PATH__PROPERTY_REFERENCES:
				return propertyReferences != null && !propertyReferences.isEmpty();
			case DconfigPackage.BINDING_TARGET_PATH__RESOURCE:
				return resource != null;
			case DconfigPackage.BINDING_TARGET_PATH__SUBSCRIPT:
				return isSetSubscript();
		}
		return super.eIsSet(featureID);
	}

} //BindingTargetPathImpl
