/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dconfig.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipselabs.damos.dconfig.DconfigPackage;
import org.eclipselabs.damos.dconfig.PropertyDeclaration;
import org.eclipselabs.damos.dconfig.PropertyDeclarationContainer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property Declaration Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.dconfig.impl.PropertyDeclarationContainerImpl#getPropertyDeclarations <em>Property Declarations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class PropertyDeclarationContainerImpl extends EObjectImpl implements PropertyDeclarationContainer {
	/**
	 * The cached value of the '{@link #getPropertyDeclarations() <em>Property Declarations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyDeclarations()
	 * @generated
	 * @ordered
	 */
	protected EList<PropertyDeclaration> propertyDeclarations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PropertyDeclarationContainerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DconfigPackage.Literals.PROPERTY_DECLARATION_CONTAINER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PropertyDeclaration> getPropertyDeclarations() {
		if (propertyDeclarations == null) {
			propertyDeclarations = new EObjectContainmentEList<PropertyDeclaration>(PropertyDeclaration.class, this, DconfigPackage.PROPERTY_DECLARATION_CONTAINER__PROPERTY_DECLARATIONS);
		}
		return propertyDeclarations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DconfigPackage.PROPERTY_DECLARATION_CONTAINER__PROPERTY_DECLARATIONS:
				return ((InternalEList<?>)getPropertyDeclarations()).basicRemove(otherEnd, msgs);
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
			case DconfigPackage.PROPERTY_DECLARATION_CONTAINER__PROPERTY_DECLARATIONS:
				return getPropertyDeclarations();
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
			case DconfigPackage.PROPERTY_DECLARATION_CONTAINER__PROPERTY_DECLARATIONS:
				getPropertyDeclarations().clear();
				getPropertyDeclarations().addAll((Collection<? extends PropertyDeclaration>)newValue);
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
			case DconfigPackage.PROPERTY_DECLARATION_CONTAINER__PROPERTY_DECLARATIONS:
				getPropertyDeclarations().clear();
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
			case DconfigPackage.PROPERTY_DECLARATION_CONTAINER__PROPERTY_DECLARATIONS:
				return propertyDeclarations != null && !propertyDeclarations.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //PropertyDeclarationContainerImpl
