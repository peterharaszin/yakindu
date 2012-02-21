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
import org.eclipselabs.damos.dconfig.Binding;
import org.eclipselabs.damos.dconfig.BindingBody;
import org.eclipselabs.damos.dconfig.BindingSubscript;
import org.eclipselabs.damos.dconfig.BindingTargetPath;
import org.eclipselabs.damos.dconfig.DconfigPackage;
import org.eclipselabs.damos.dml.Component;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Binding</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.dconfig.impl.BindingImpl#getSource <em>Source</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dconfig.impl.BindingImpl#getTargetPath <em>Target Path</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dconfig.impl.BindingImpl#getSubscript <em>Subscript</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dconfig.impl.BindingImpl#getBody <em>Body</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BindingImpl extends EObjectImpl implements Binding {
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
	 * The cached value of the '{@link #getTargetPath() <em>Target Path</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetPath()
	 * @generated
	 * @ordered
	 */
	protected BindingTargetPath targetPath;

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
	 * The cached value of the '{@link #getBody() <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBody()
	 * @generated
	 * @ordered
	 */
	protected BindingBody body;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BindingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DconfigPackage.Literals.BINDING;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DconfigPackage.BINDING__SOURCE, oldSource, source));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DconfigPackage.BINDING__SOURCE, oldSource, source));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BindingTargetPath getTargetPath() {
		return targetPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTargetPath(BindingTargetPath newTargetPath, NotificationChain msgs) {
		BindingTargetPath oldTargetPath = targetPath;
		targetPath = newTargetPath;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DconfigPackage.BINDING__TARGET_PATH, oldTargetPath, newTargetPath);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetPath(BindingTargetPath newTargetPath) {
		if (newTargetPath != targetPath) {
			NotificationChain msgs = null;
			if (targetPath != null)
				msgs = ((InternalEObject)targetPath).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DconfigPackage.BINDING__TARGET_PATH, null, msgs);
			if (newTargetPath != null)
				msgs = ((InternalEObject)newTargetPath).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DconfigPackage.BINDING__TARGET_PATH, null, msgs);
			msgs = basicSetTargetPath(newTargetPath, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DconfigPackage.BINDING__TARGET_PATH, newTargetPath, newTargetPath));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DconfigPackage.BINDING__SUBSCRIPT, oldSubscript, newSubscript, !oldSubscriptESet);
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
				msgs = ((InternalEObject)subscript).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DconfigPackage.BINDING__SUBSCRIPT, null, msgs);
			if (newSubscript != null)
				msgs = ((InternalEObject)newSubscript).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DconfigPackage.BINDING__SUBSCRIPT, null, msgs);
			msgs = basicSetSubscript(newSubscript, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else {
			boolean oldSubscriptESet = subscriptESet;
			subscriptESet = true;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.SET, DconfigPackage.BINDING__SUBSCRIPT, newSubscript, newSubscript, !oldSubscriptESet));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.UNSET, DconfigPackage.BINDING__SUBSCRIPT, oldSubscript, null, oldSubscriptESet);
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
			msgs = ((InternalEObject)subscript).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DconfigPackage.BINDING__SUBSCRIPT, null, msgs);
			msgs = basicUnsetSubscript(msgs);
			if (msgs != null) msgs.dispatch();
		}
		else {
			boolean oldSubscriptESet = subscriptESet;
			subscriptESet = false;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.UNSET, DconfigPackage.BINDING__SUBSCRIPT, null, null, oldSubscriptESet));
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
	public BindingBody getBody() {
		return body;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBody(BindingBody newBody, NotificationChain msgs) {
		BindingBody oldBody = body;
		body = newBody;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DconfigPackage.BINDING__BODY, oldBody, newBody);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBody(BindingBody newBody) {
		if (newBody != body) {
			NotificationChain msgs = null;
			if (body != null)
				msgs = ((InternalEObject)body).eInverseRemove(this, DconfigPackage.BINDING_BODY__OWNER, BindingBody.class, msgs);
			if (newBody != null)
				msgs = ((InternalEObject)newBody).eInverseAdd(this, DconfigPackage.BINDING_BODY__OWNER, BindingBody.class, msgs);
			msgs = basicSetBody(newBody, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DconfigPackage.BINDING__BODY, newBody, newBody));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DconfigPackage.BINDING__BODY:
				if (body != null)
					msgs = ((InternalEObject)body).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DconfigPackage.BINDING__BODY, null, msgs);
				return basicSetBody((BindingBody)otherEnd, msgs);
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
			case DconfigPackage.BINDING__TARGET_PATH:
				return basicSetTargetPath(null, msgs);
			case DconfigPackage.BINDING__SUBSCRIPT:
				return basicUnsetSubscript(msgs);
			case DconfigPackage.BINDING__BODY:
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
			case DconfigPackage.BINDING__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
			case DconfigPackage.BINDING__TARGET_PATH:
				return getTargetPath();
			case DconfigPackage.BINDING__SUBSCRIPT:
				return getSubscript();
			case DconfigPackage.BINDING__BODY:
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
			case DconfigPackage.BINDING__SOURCE:
				setSource((Component)newValue);
				return;
			case DconfigPackage.BINDING__TARGET_PATH:
				setTargetPath((BindingTargetPath)newValue);
				return;
			case DconfigPackage.BINDING__SUBSCRIPT:
				setSubscript((BindingSubscript)newValue);
				return;
			case DconfigPackage.BINDING__BODY:
				setBody((BindingBody)newValue);
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
			case DconfigPackage.BINDING__SOURCE:
				setSource((Component)null);
				return;
			case DconfigPackage.BINDING__TARGET_PATH:
				setTargetPath((BindingTargetPath)null);
				return;
			case DconfigPackage.BINDING__SUBSCRIPT:
				unsetSubscript();
				return;
			case DconfigPackage.BINDING__BODY:
				setBody((BindingBody)null);
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
			case DconfigPackage.BINDING__SOURCE:
				return source != null;
			case DconfigPackage.BINDING__TARGET_PATH:
				return targetPath != null;
			case DconfigPackage.BINDING__SUBSCRIPT:
				return isSetSubscript();
			case DconfigPackage.BINDING__BODY:
				return body != null;
		}
		return super.eIsSet(featureID);
	}

} //BindingImpl
