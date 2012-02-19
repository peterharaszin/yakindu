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
import org.eclipselabs.damos.dconfig.DconfigPackage;
import org.eclipselabs.damos.dconfig.MappingPropertyReference;
import org.eclipselabs.damos.dconfig.MappingTargetPath;
import org.eclipselabs.damos.dconfig.ResourceDeclaration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping Target Path</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.dconfig.impl.MappingTargetPathImpl#getPropertyReferences <em>Property References</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dconfig.impl.MappingTargetPathImpl#getResource <em>Resource</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MappingTargetPathImpl extends EObjectImpl implements MappingTargetPath {
	/**
	 * The cached value of the '{@link #getPropertyReferences() <em>Property References</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyReferences()
	 * @generated
	 * @ordered
	 */
	protected EList<MappingPropertyReference> propertyReferences;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingTargetPathImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DconfigPackage.Literals.MAPPING_TARGET_PATH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MappingPropertyReference> getPropertyReferences() {
		if (propertyReferences == null) {
			propertyReferences = new EObjectContainmentEList<MappingPropertyReference>(MappingPropertyReference.class, this, DconfigPackage.MAPPING_TARGET_PATH__PROPERTY_REFERENCES);
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DconfigPackage.MAPPING_TARGET_PATH__RESOURCE, oldResource, resource));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DconfigPackage.MAPPING_TARGET_PATH__RESOURCE, oldResource, resource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DconfigPackage.MAPPING_TARGET_PATH__PROPERTY_REFERENCES:
				return ((InternalEList<?>)getPropertyReferences()).basicRemove(otherEnd, msgs);
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
			case DconfigPackage.MAPPING_TARGET_PATH__PROPERTY_REFERENCES:
				return getPropertyReferences();
			case DconfigPackage.MAPPING_TARGET_PATH__RESOURCE:
				if (resolve) return getResource();
				return basicGetResource();
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
			case DconfigPackage.MAPPING_TARGET_PATH__PROPERTY_REFERENCES:
				getPropertyReferences().clear();
				getPropertyReferences().addAll((Collection<? extends MappingPropertyReference>)newValue);
				return;
			case DconfigPackage.MAPPING_TARGET_PATH__RESOURCE:
				setResource((ResourceDeclaration)newValue);
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
			case DconfigPackage.MAPPING_TARGET_PATH__PROPERTY_REFERENCES:
				getPropertyReferences().clear();
				return;
			case DconfigPackage.MAPPING_TARGET_PATH__RESOURCE:
				setResource((ResourceDeclaration)null);
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
			case DconfigPackage.MAPPING_TARGET_PATH__PROPERTY_REFERENCES:
				return propertyReferences != null && !propertyReferences.isEmpty();
			case DconfigPackage.MAPPING_TARGET_PATH__RESOURCE:
				return resource != null;
		}
		return super.eIsSet(featureID);
	}

} //MappingTargetPathImpl
