/*******************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Andreas Unger - initial API and implementation
 *******************************************************************************/
package org.eclipse.damos.dconfig.impl;

import java.util.Collection;

import org.eclipse.damos.dconfig.ConfigurationDefinition;
import org.eclipse.damos.dconfig.ConfigurationDefinitionMember;
import org.eclipse.damos.dconfig.DconfigPackage;
import org.eclipse.damos.dconfig.ResourceDeclaration;
import org.eclipse.damos.dconfig.SelectionPropertyDeclaration;
import org.eclipse.damos.dconfig.SelectionPropertyOption;
import org.eclipse.damos.dconfig.internal.operations.ConfigurationDefinitionMemberOperations;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Selection Property Option</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.damos.dconfig.impl.SelectionPropertyOptionImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link org.eclipse.damos.dconfig.impl.SelectionPropertyOptionImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.damos.dconfig.impl.SelectionPropertyOptionImpl#getQualifiedName <em>Qualified Name</em>}</li>
 *   <li>{@link org.eclipse.damos.dconfig.impl.SelectionPropertyOptionImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.eclipse.damos.dconfig.impl.SelectionPropertyOptionImpl#getResourceDeclarations <em>Resource Declarations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SelectionPropertyOptionImpl extends PropertyDeclarationContainerImpl implements SelectionPropertyOption {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getQualifiedName() <em>Qualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQualifiedName()
	 * @generated
	 * @ordered
	 */
	protected static final String QUALIFIED_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected SelectionPropertyDeclaration target;

	/**
	 * The cached value of the '{@link #getResourceDeclarations() <em>Resource Declarations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceDeclarations()
	 * @generated
	 * @ordered
	 */
	protected EList<ResourceDeclaration> resourceDeclarations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SelectionPropertyOptionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DconfigPackage.Literals.SELECTION_PROPERTY_OPTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfigurationDefinition getOwner() {
		if (eContainerFeatureID() != DconfigPackage.SELECTION_PROPERTY_OPTION__OWNER) return null;
		return (ConfigurationDefinition)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwner(ConfigurationDefinition newOwner, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwner, DconfigPackage.SELECTION_PROPERTY_OPTION__OWNER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwner(ConfigurationDefinition newOwner) {
		if (newOwner != eInternalContainer() || (eContainerFeatureID() != DconfigPackage.SELECTION_PROPERTY_OPTION__OWNER && newOwner != null)) {
			if (EcoreUtil.isAncestor(this, newOwner))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwner != null)
				msgs = ((InternalEObject)newOwner).eInverseAdd(this, DconfigPackage.CONFIGURATION_DEFINITION__MEMBERS, ConfigurationDefinition.class, msgs);
			msgs = basicSetOwner(newOwner, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DconfigPackage.SELECTION_PROPERTY_OPTION__OWNER, newOwner, newOwner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DconfigPackage.SELECTION_PROPERTY_OPTION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getQualifiedName() {
		return ConfigurationDefinitionMemberOperations.getQualifiedName(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SelectionPropertyDeclaration getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = (SelectionPropertyDeclaration)eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DconfigPackage.SELECTION_PROPERTY_OPTION__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SelectionPropertyDeclaration basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(SelectionPropertyDeclaration newTarget) {
		SelectionPropertyDeclaration oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DconfigPackage.SELECTION_PROPERTY_OPTION__TARGET, oldTarget, target));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ResourceDeclaration> getResourceDeclarations() {
		if (resourceDeclarations == null) {
			resourceDeclarations = new EObjectContainmentEList<ResourceDeclaration>(ResourceDeclaration.class, this, DconfigPackage.SELECTION_PROPERTY_OPTION__RESOURCE_DECLARATIONS);
		}
		return resourceDeclarations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DconfigPackage.SELECTION_PROPERTY_OPTION__OWNER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwner((ConfigurationDefinition)otherEnd, msgs);
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
			case DconfigPackage.SELECTION_PROPERTY_OPTION__OWNER:
				return basicSetOwner(null, msgs);
			case DconfigPackage.SELECTION_PROPERTY_OPTION__RESOURCE_DECLARATIONS:
				return ((InternalEList<?>)getResourceDeclarations()).basicRemove(otherEnd, msgs);
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
			case DconfigPackage.SELECTION_PROPERTY_OPTION__OWNER:
				return eInternalContainer().eInverseRemove(this, DconfigPackage.CONFIGURATION_DEFINITION__MEMBERS, ConfigurationDefinition.class, msgs);
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
			case DconfigPackage.SELECTION_PROPERTY_OPTION__OWNER:
				return getOwner();
			case DconfigPackage.SELECTION_PROPERTY_OPTION__NAME:
				return getName();
			case DconfigPackage.SELECTION_PROPERTY_OPTION__QUALIFIED_NAME:
				return getQualifiedName();
			case DconfigPackage.SELECTION_PROPERTY_OPTION__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
			case DconfigPackage.SELECTION_PROPERTY_OPTION__RESOURCE_DECLARATIONS:
				return getResourceDeclarations();
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
			case DconfigPackage.SELECTION_PROPERTY_OPTION__OWNER:
				setOwner((ConfigurationDefinition)newValue);
				return;
			case DconfigPackage.SELECTION_PROPERTY_OPTION__NAME:
				setName((String)newValue);
				return;
			case DconfigPackage.SELECTION_PROPERTY_OPTION__TARGET:
				setTarget((SelectionPropertyDeclaration)newValue);
				return;
			case DconfigPackage.SELECTION_PROPERTY_OPTION__RESOURCE_DECLARATIONS:
				getResourceDeclarations().clear();
				getResourceDeclarations().addAll((Collection<? extends ResourceDeclaration>)newValue);
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
			case DconfigPackage.SELECTION_PROPERTY_OPTION__OWNER:
				setOwner((ConfigurationDefinition)null);
				return;
			case DconfigPackage.SELECTION_PROPERTY_OPTION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case DconfigPackage.SELECTION_PROPERTY_OPTION__TARGET:
				setTarget((SelectionPropertyDeclaration)null);
				return;
			case DconfigPackage.SELECTION_PROPERTY_OPTION__RESOURCE_DECLARATIONS:
				getResourceDeclarations().clear();
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
			case DconfigPackage.SELECTION_PROPERTY_OPTION__OWNER:
				return getOwner() != null;
			case DconfigPackage.SELECTION_PROPERTY_OPTION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case DconfigPackage.SELECTION_PROPERTY_OPTION__QUALIFIED_NAME:
				return QUALIFIED_NAME_EDEFAULT == null ? getQualifiedName() != null : !QUALIFIED_NAME_EDEFAULT.equals(getQualifiedName());
			case DconfigPackage.SELECTION_PROPERTY_OPTION__TARGET:
				return target != null;
			case DconfigPackage.SELECTION_PROPERTY_OPTION__RESOURCE_DECLARATIONS:
				return resourceDeclarations != null && !resourceDeclarations.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == ConfigurationDefinitionMember.class) {
			switch (derivedFeatureID) {
				case DconfigPackage.SELECTION_PROPERTY_OPTION__OWNER: return DconfigPackage.CONFIGURATION_DEFINITION_MEMBER__OWNER;
				case DconfigPackage.SELECTION_PROPERTY_OPTION__NAME: return DconfigPackage.CONFIGURATION_DEFINITION_MEMBER__NAME;
				case DconfigPackage.SELECTION_PROPERTY_OPTION__QUALIFIED_NAME: return DconfigPackage.CONFIGURATION_DEFINITION_MEMBER__QUALIFIED_NAME;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == ConfigurationDefinitionMember.class) {
			switch (baseFeatureID) {
				case DconfigPackage.CONFIGURATION_DEFINITION_MEMBER__OWNER: return DconfigPackage.SELECTION_PROPERTY_OPTION__OWNER;
				case DconfigPackage.CONFIGURATION_DEFINITION_MEMBER__NAME: return DconfigPackage.SELECTION_PROPERTY_OPTION__NAME;
				case DconfigPackage.CONFIGURATION_DEFINITION_MEMBER__QUALIFIED_NAME: return DconfigPackage.SELECTION_PROPERTY_OPTION__QUALIFIED_NAME;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //SelectionPropertyOptionImpl
