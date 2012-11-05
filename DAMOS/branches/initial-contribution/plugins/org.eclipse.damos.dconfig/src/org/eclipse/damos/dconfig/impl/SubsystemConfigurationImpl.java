/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.damos.dconfig.impl;

import org.eclipse.damos.dconfig.DconfigPackage;
import org.eclipse.damos.dconfig.SubsystemConfiguration;
import org.eclipse.damos.dconfig.SystemConfiguration;
import org.eclipse.damos.dconfig.SystemConfigurationBody;
import org.eclipse.damos.dml.Subsystem;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Subsystem Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.damos.dconfig.impl.SubsystemConfigurationImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link org.eclipse.damos.dconfig.impl.SubsystemConfigurationImpl#getSubsystem <em>Subsystem</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SubsystemConfigurationImpl extends SystemConfigurationImpl implements SubsystemConfiguration {
	/**
	 * The cached value of the '{@link #getSubsystem() <em>Subsystem</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubsystem()
	 * @generated
	 * @ordered
	 */
	protected Subsystem subsystem;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SubsystemConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DconfigPackage.Literals.SUBSYSTEM_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Subsystem getSubsystem() {
		if (subsystem != null && subsystem.eIsProxy()) {
			InternalEObject oldSubsystem = (InternalEObject)subsystem;
			subsystem = (Subsystem)eResolveProxy(oldSubsystem);
			if (subsystem != oldSubsystem) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DconfigPackage.SUBSYSTEM_CONFIGURATION__SUBSYSTEM, oldSubsystem, subsystem));
			}
		}
		return subsystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Subsystem basicGetSubsystem() {
		return subsystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubsystem(Subsystem newSubsystem) {
		Subsystem oldSubsystem = subsystem;
		subsystem = newSubsystem;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DconfigPackage.SUBSYSTEM_CONFIGURATION__SUBSYSTEM, oldSubsystem, subsystem));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystemConfiguration getParent() {
		SystemConfiguration parent = basicGetParent();
		return parent != null && parent.eIsProxy() ? (SystemConfiguration)eResolveProxy((InternalEObject)parent) : parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public SystemConfiguration basicGetParent() {
		EObject container = eContainer();
		if (container instanceof SystemConfigurationBody) {
			return ((SystemConfigurationBody) container).getOwner();
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DconfigPackage.SUBSYSTEM_CONFIGURATION__PARENT:
				if (resolve) return getParent();
				return basicGetParent();
			case DconfigPackage.SUBSYSTEM_CONFIGURATION__SUBSYSTEM:
				if (resolve) return getSubsystem();
				return basicGetSubsystem();
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
			case DconfigPackage.SUBSYSTEM_CONFIGURATION__SUBSYSTEM:
				setSubsystem((Subsystem)newValue);
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
			case DconfigPackage.SUBSYSTEM_CONFIGURATION__SUBSYSTEM:
				setSubsystem((Subsystem)null);
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
			case DconfigPackage.SUBSYSTEM_CONFIGURATION__PARENT:
				return basicGetParent() != null;
			case DconfigPackage.SUBSYSTEM_CONFIGURATION__SUBSYSTEM:
				return subsystem != null;
		}
		return super.eIsSet(featureID);
	}

} //SubsystemConfigurationImpl
