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
import org.eclipselabs.damos.dconfig.Mapping;
import org.eclipselabs.damos.dconfig.MappingBody;
import org.eclipselabs.damos.dconfig.MappingSubscript;
import org.eclipselabs.damos.dconfig.ResourceDeclaration;
import org.eclipselabs.damos.dconfig.SelectionProperty;
import org.eclipselabs.damos.dml.Component;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.dconfig.impl.MappingImpl#getSource <em>Source</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dconfig.impl.MappingImpl#getTargetProperty <em>Target Property</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dconfig.impl.MappingImpl#getTargetResource <em>Target Resource</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dconfig.impl.MappingImpl#getSubscript <em>Subscript</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dconfig.impl.MappingImpl#getBody <em>Body</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MappingImpl extends EObjectImpl implements Mapping {
	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected Component source;

	/**
	 * The cached value of the '{@link #getTargetProperty() <em>Target Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetProperty()
	 * @generated
	 * @ordered
	 */
	protected SelectionProperty targetProperty;

	/**
	 * The cached value of the '{@link #getTargetResource() <em>Target Resource</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetResource()
	 * @generated
	 * @ordered
	 */
	protected ResourceDeclaration targetResource;

	/**
	 * The cached value of the '{@link #getSubscript() <em>Subscript</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubscript()
	 * @generated
	 * @ordered
	 */
	protected MappingSubscript subscript;

	/**
	 * This is true if the Subscript containment reference has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean subscriptESet;

	/**
	 * The cached value of the '{@link #getBody() <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBody()
	 * @generated
	 * @ordered
	 */
	protected MappingBody body;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DconfigPackage.Literals.MAPPING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Component getSource() {
		if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject)source;
			source = (Component)eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DconfigPackage.MAPPING__SOURCE, oldSource, source));
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Component basicGetSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(Component newSource) {
		Component oldSource = source;
		source = newSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DconfigPackage.MAPPING__SOURCE, oldSource, source));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SelectionProperty getTargetProperty() {
		if (targetProperty != null && targetProperty.eIsProxy()) {
			InternalEObject oldTargetProperty = (InternalEObject)targetProperty;
			targetProperty = (SelectionProperty)eResolveProxy(oldTargetProperty);
			if (targetProperty != oldTargetProperty) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DconfigPackage.MAPPING__TARGET_PROPERTY, oldTargetProperty, targetProperty));
			}
		}
		return targetProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SelectionProperty basicGetTargetProperty() {
		return targetProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetProperty(SelectionProperty newTargetProperty) {
		SelectionProperty oldTargetProperty = targetProperty;
		targetProperty = newTargetProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DconfigPackage.MAPPING__TARGET_PROPERTY, oldTargetProperty, targetProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceDeclaration getTargetResource() {
		if (targetResource != null && targetResource.eIsProxy()) {
			InternalEObject oldTargetResource = (InternalEObject)targetResource;
			targetResource = (ResourceDeclaration)eResolveProxy(oldTargetResource);
			if (targetResource != oldTargetResource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DconfigPackage.MAPPING__TARGET_RESOURCE, oldTargetResource, targetResource));
			}
		}
		return targetResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceDeclaration basicGetTargetResource() {
		return targetResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetResource(ResourceDeclaration newTargetResource) {
		ResourceDeclaration oldTargetResource = targetResource;
		targetResource = newTargetResource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DconfigPackage.MAPPING__TARGET_RESOURCE, oldTargetResource, targetResource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingSubscript getSubscript() {
		return subscript;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSubscript(MappingSubscript newSubscript, NotificationChain msgs) {
		MappingSubscript oldSubscript = subscript;
		subscript = newSubscript;
		boolean oldSubscriptESet = subscriptESet;
		subscriptESet = true;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DconfigPackage.MAPPING__SUBSCRIPT, oldSubscript, newSubscript, !oldSubscriptESet);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubscript(MappingSubscript newSubscript) {
		if (newSubscript != subscript) {
			NotificationChain msgs = null;
			if (subscript != null)
				msgs = ((InternalEObject)subscript).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DconfigPackage.MAPPING__SUBSCRIPT, null, msgs);
			if (newSubscript != null)
				msgs = ((InternalEObject)newSubscript).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DconfigPackage.MAPPING__SUBSCRIPT, null, msgs);
			msgs = basicSetSubscript(newSubscript, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else {
			boolean oldSubscriptESet = subscriptESet;
			subscriptESet = true;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.SET, DconfigPackage.MAPPING__SUBSCRIPT, newSubscript, newSubscript, !oldSubscriptESet));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicUnsetSubscript(NotificationChain msgs) {
		MappingSubscript oldSubscript = subscript;
		subscript = null;
		boolean oldSubscriptESet = subscriptESet;
		subscriptESet = false;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.UNSET, DconfigPackage.MAPPING__SUBSCRIPT, oldSubscript, null, oldSubscriptESet);
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
			msgs = ((InternalEObject)subscript).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DconfigPackage.MAPPING__SUBSCRIPT, null, msgs);
			msgs = basicUnsetSubscript(msgs);
			if (msgs != null) msgs.dispatch();
		}
		else {
			boolean oldSubscriptESet = subscriptESet;
			subscriptESet = false;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.UNSET, DconfigPackage.MAPPING__SUBSCRIPT, null, null, oldSubscriptESet));
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
	public MappingBody getBody() {
		return body;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBody(MappingBody newBody, NotificationChain msgs) {
		MappingBody oldBody = body;
		body = newBody;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DconfigPackage.MAPPING__BODY, oldBody, newBody);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBody(MappingBody newBody) {
		if (newBody != body) {
			NotificationChain msgs = null;
			if (body != null)
				msgs = ((InternalEObject)body).eInverseRemove(this, DconfigPackage.MAPPING_BODY__OWNER, MappingBody.class, msgs);
			if (newBody != null)
				msgs = ((InternalEObject)newBody).eInverseAdd(this, DconfigPackage.MAPPING_BODY__OWNER, MappingBody.class, msgs);
			msgs = basicSetBody(newBody, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DconfigPackage.MAPPING__BODY, newBody, newBody));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DconfigPackage.MAPPING__BODY:
				if (body != null)
					msgs = ((InternalEObject)body).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DconfigPackage.MAPPING__BODY, null, msgs);
				return basicSetBody((MappingBody)otherEnd, msgs);
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
			case DconfigPackage.MAPPING__SUBSCRIPT:
				return basicUnsetSubscript(msgs);
			case DconfigPackage.MAPPING__BODY:
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
			case DconfigPackage.MAPPING__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
			case DconfigPackage.MAPPING__TARGET_PROPERTY:
				if (resolve) return getTargetProperty();
				return basicGetTargetProperty();
			case DconfigPackage.MAPPING__TARGET_RESOURCE:
				if (resolve) return getTargetResource();
				return basicGetTargetResource();
			case DconfigPackage.MAPPING__SUBSCRIPT:
				return getSubscript();
			case DconfigPackage.MAPPING__BODY:
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
			case DconfigPackage.MAPPING__SOURCE:
				setSource((Component)newValue);
				return;
			case DconfigPackage.MAPPING__TARGET_PROPERTY:
				setTargetProperty((SelectionProperty)newValue);
				return;
			case DconfigPackage.MAPPING__TARGET_RESOURCE:
				setTargetResource((ResourceDeclaration)newValue);
				return;
			case DconfigPackage.MAPPING__SUBSCRIPT:
				setSubscript((MappingSubscript)newValue);
				return;
			case DconfigPackage.MAPPING__BODY:
				setBody((MappingBody)newValue);
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
			case DconfigPackage.MAPPING__SOURCE:
				setSource((Component)null);
				return;
			case DconfigPackage.MAPPING__TARGET_PROPERTY:
				setTargetProperty((SelectionProperty)null);
				return;
			case DconfigPackage.MAPPING__TARGET_RESOURCE:
				setTargetResource((ResourceDeclaration)null);
				return;
			case DconfigPackage.MAPPING__SUBSCRIPT:
				unsetSubscript();
				return;
			case DconfigPackage.MAPPING__BODY:
				setBody((MappingBody)null);
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
			case DconfigPackage.MAPPING__SOURCE:
				return source != null;
			case DconfigPackage.MAPPING__TARGET_PROPERTY:
				return targetProperty != null;
			case DconfigPackage.MAPPING__TARGET_RESOURCE:
				return targetResource != null;
			case DconfigPackage.MAPPING__SUBSCRIPT:
				return isSetSubscript();
			case DconfigPackage.MAPPING__BODY:
				return body != null;
		}
		return super.eIsSet(featureID);
	}

} //MappingImpl
