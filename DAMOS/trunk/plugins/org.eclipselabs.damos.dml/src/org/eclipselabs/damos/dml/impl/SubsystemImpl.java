/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dml.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.Fragment;
import org.eclipselabs.damos.dml.Subsystem;
import org.eclipselabs.damos.dml.SubsystemRealization;
import org.eclipselabs.damos.dml.SystemInterface;
import org.eclipselabs.damos.dml.internal.operations.SubsystemOperations;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Subsystem</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.dml.impl.SubsystemImpl#getUsedInterfaces <em>Used Interfaces</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SubsystemImpl extends ComponentImpl implements Subsystem {
	/**
	 * The cached value of the '{@link #getUsedInterfaces() <em>Used Interfaces</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsedInterfaces()
	 * @generated
	 * @ordered
	 */
	protected EList<SystemInterface> usedInterfaces;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SubsystemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DMLPackage.Literals.SUBSYSTEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SystemInterface> getUsedInterfaces() {
		if (usedInterfaces == null) {
			usedInterfaces = new EObjectResolvingEList<SystemInterface>(SystemInterface.class, this, DMLPackage.SUBSYSTEM__USED_INTERFACES);
		}
		return usedInterfaces;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SubsystemRealization> getRealizations() {
		return SubsystemOperations.getRealizations(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubsystemRealization getRealization(Fragment context) {
		return SubsystemOperations.getRealization(this, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DMLPackage.SUBSYSTEM__USED_INTERFACES:
				return getUsedInterfaces();
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
			case DMLPackage.SUBSYSTEM__USED_INTERFACES:
				getUsedInterfaces().clear();
				getUsedInterfaces().addAll((Collection<? extends SystemInterface>)newValue);
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
			case DMLPackage.SUBSYSTEM__USED_INTERFACES:
				getUsedInterfaces().clear();
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
			case DMLPackage.SUBSYSTEM__USED_INTERFACES:
				return usedInterfaces != null && !usedInterfaces.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SubsystemImpl
