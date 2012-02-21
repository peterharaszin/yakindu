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
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipselabs.damos.dconfig.Binding;
import org.eclipselabs.damos.dconfig.ComponentConfiguration;
import org.eclipselabs.damos.dconfig.DconfigPackage;
import org.eclipselabs.damos.dconfig.FragmentConfiguration;
import org.eclipselabs.damos.dconfig.SubsystemConfiguration;
import org.eclipselabs.damos.dconfig.SystemConfiguration;
import org.eclipselabs.damos.dconfig.SystemConfigurationBody;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>System Configuration Body</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.dconfig.impl.SystemConfigurationBodyImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dconfig.impl.SystemConfigurationBodyImpl#getBindings <em>Bindings</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dconfig.impl.SystemConfigurationBodyImpl#getComponentConfigurations <em>Component Configurations</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dconfig.impl.SystemConfigurationBodyImpl#getFragmentConfigurations <em>Fragment Configurations</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dconfig.impl.SystemConfigurationBodyImpl#getSubsystemConfigurations <em>Subsystem Configurations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SystemConfigurationBodyImpl extends PropertyContainerImpl implements SystemConfigurationBody {
	/**
	 * The cached value of the '{@link #getBindings() <em>Bindings</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBindings()
	 * @generated
	 * @ordered
	 */
	protected EList<Binding> bindings;
	/**
	 * The cached value of the '{@link #getComponentConfigurations() <em>Component Configurations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponentConfigurations()
	 * @generated
	 * @ordered
	 */
	protected EList<ComponentConfiguration> componentConfigurations;
	/**
	 * The cached value of the '{@link #getFragmentConfigurations() <em>Fragment Configurations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFragmentConfigurations()
	 * @generated
	 * @ordered
	 */
	protected EList<FragmentConfiguration> fragmentConfigurations;
	/**
	 * The cached value of the '{@link #getSubsystemConfigurations() <em>Subsystem Configurations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubsystemConfigurations()
	 * @generated
	 * @ordered
	 */
	protected EList<SubsystemConfiguration> subsystemConfigurations;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SystemConfigurationBodyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DconfigPackage.Literals.SYSTEM_CONFIGURATION_BODY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystemConfiguration getOwner() {
		if (eContainerFeatureID() != DconfigPackage.SYSTEM_CONFIGURATION_BODY__OWNER) return null;
		return (SystemConfiguration)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwner(SystemConfiguration newOwner, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwner, DconfigPackage.SYSTEM_CONFIGURATION_BODY__OWNER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwner(SystemConfiguration newOwner) {
		if (newOwner != eInternalContainer() || (eContainerFeatureID() != DconfigPackage.SYSTEM_CONFIGURATION_BODY__OWNER && newOwner != null)) {
			if (EcoreUtil.isAncestor(this, newOwner))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwner != null)
				msgs = ((InternalEObject)newOwner).eInverseAdd(this, DconfigPackage.SYSTEM_CONFIGURATION__BODY, SystemConfiguration.class, msgs);
			msgs = basicSetOwner(newOwner, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DconfigPackage.SYSTEM_CONFIGURATION_BODY__OWNER, newOwner, newOwner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Binding> getBindings() {
		if (bindings == null) {
			bindings = new EObjectContainmentEList<Binding>(Binding.class, this, DconfigPackage.SYSTEM_CONFIGURATION_BODY__BINDINGS);
		}
		return bindings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ComponentConfiguration> getComponentConfigurations() {
		if (componentConfigurations == null) {
			componentConfigurations = new EObjectContainmentEList<ComponentConfiguration>(ComponentConfiguration.class, this, DconfigPackage.SYSTEM_CONFIGURATION_BODY__COMPONENT_CONFIGURATIONS);
		}
		return componentConfigurations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FragmentConfiguration> getFragmentConfigurations() {
		if (fragmentConfigurations == null) {
			fragmentConfigurations = new EObjectContainmentEList<FragmentConfiguration>(FragmentConfiguration.class, this, DconfigPackage.SYSTEM_CONFIGURATION_BODY__FRAGMENT_CONFIGURATIONS);
		}
		return fragmentConfigurations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SubsystemConfiguration> getSubsystemConfigurations() {
		if (subsystemConfigurations == null) {
			subsystemConfigurations = new EObjectContainmentEList<SubsystemConfiguration>(SubsystemConfiguration.class, this, DconfigPackage.SYSTEM_CONFIGURATION_BODY__SUBSYSTEM_CONFIGURATIONS);
		}
		return subsystemConfigurations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DconfigPackage.SYSTEM_CONFIGURATION_BODY__OWNER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwner((SystemConfiguration)otherEnd, msgs);
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
			case DconfigPackage.SYSTEM_CONFIGURATION_BODY__OWNER:
				return basicSetOwner(null, msgs);
			case DconfigPackage.SYSTEM_CONFIGURATION_BODY__BINDINGS:
				return ((InternalEList<?>)getBindings()).basicRemove(otherEnd, msgs);
			case DconfigPackage.SYSTEM_CONFIGURATION_BODY__COMPONENT_CONFIGURATIONS:
				return ((InternalEList<?>)getComponentConfigurations()).basicRemove(otherEnd, msgs);
			case DconfigPackage.SYSTEM_CONFIGURATION_BODY__FRAGMENT_CONFIGURATIONS:
				return ((InternalEList<?>)getFragmentConfigurations()).basicRemove(otherEnd, msgs);
			case DconfigPackage.SYSTEM_CONFIGURATION_BODY__SUBSYSTEM_CONFIGURATIONS:
				return ((InternalEList<?>)getSubsystemConfigurations()).basicRemove(otherEnd, msgs);
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
			case DconfigPackage.SYSTEM_CONFIGURATION_BODY__OWNER:
				return eInternalContainer().eInverseRemove(this, DconfigPackage.SYSTEM_CONFIGURATION__BODY, SystemConfiguration.class, msgs);
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
			case DconfigPackage.SYSTEM_CONFIGURATION_BODY__OWNER:
				return getOwner();
			case DconfigPackage.SYSTEM_CONFIGURATION_BODY__BINDINGS:
				return getBindings();
			case DconfigPackage.SYSTEM_CONFIGURATION_BODY__COMPONENT_CONFIGURATIONS:
				return getComponentConfigurations();
			case DconfigPackage.SYSTEM_CONFIGURATION_BODY__FRAGMENT_CONFIGURATIONS:
				return getFragmentConfigurations();
			case DconfigPackage.SYSTEM_CONFIGURATION_BODY__SUBSYSTEM_CONFIGURATIONS:
				return getSubsystemConfigurations();
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
			case DconfigPackage.SYSTEM_CONFIGURATION_BODY__OWNER:
				setOwner((SystemConfiguration)newValue);
				return;
			case DconfigPackage.SYSTEM_CONFIGURATION_BODY__BINDINGS:
				getBindings().clear();
				getBindings().addAll((Collection<? extends Binding>)newValue);
				return;
			case DconfigPackage.SYSTEM_CONFIGURATION_BODY__COMPONENT_CONFIGURATIONS:
				getComponentConfigurations().clear();
				getComponentConfigurations().addAll((Collection<? extends ComponentConfiguration>)newValue);
				return;
			case DconfigPackage.SYSTEM_CONFIGURATION_BODY__FRAGMENT_CONFIGURATIONS:
				getFragmentConfigurations().clear();
				getFragmentConfigurations().addAll((Collection<? extends FragmentConfiguration>)newValue);
				return;
			case DconfigPackage.SYSTEM_CONFIGURATION_BODY__SUBSYSTEM_CONFIGURATIONS:
				getSubsystemConfigurations().clear();
				getSubsystemConfigurations().addAll((Collection<? extends SubsystemConfiguration>)newValue);
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
			case DconfigPackage.SYSTEM_CONFIGURATION_BODY__OWNER:
				setOwner((SystemConfiguration)null);
				return;
			case DconfigPackage.SYSTEM_CONFIGURATION_BODY__BINDINGS:
				getBindings().clear();
				return;
			case DconfigPackage.SYSTEM_CONFIGURATION_BODY__COMPONENT_CONFIGURATIONS:
				getComponentConfigurations().clear();
				return;
			case DconfigPackage.SYSTEM_CONFIGURATION_BODY__FRAGMENT_CONFIGURATIONS:
				getFragmentConfigurations().clear();
				return;
			case DconfigPackage.SYSTEM_CONFIGURATION_BODY__SUBSYSTEM_CONFIGURATIONS:
				getSubsystemConfigurations().clear();
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
			case DconfigPackage.SYSTEM_CONFIGURATION_BODY__OWNER:
				return getOwner() != null;
			case DconfigPackage.SYSTEM_CONFIGURATION_BODY__BINDINGS:
				return bindings != null && !bindings.isEmpty();
			case DconfigPackage.SYSTEM_CONFIGURATION_BODY__COMPONENT_CONFIGURATIONS:
				return componentConfigurations != null && !componentConfigurations.isEmpty();
			case DconfigPackage.SYSTEM_CONFIGURATION_BODY__FRAGMENT_CONFIGURATIONS:
				return fragmentConfigurations != null && !fragmentConfigurations.isEmpty();
			case DconfigPackage.SYSTEM_CONFIGURATION_BODY__SUBSYSTEM_CONFIGURATIONS:
				return subsystemConfigurations != null && !subsystemConfigurations.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SystemConfigurationBodyImpl
