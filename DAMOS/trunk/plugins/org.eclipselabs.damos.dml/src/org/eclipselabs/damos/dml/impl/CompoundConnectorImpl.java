/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dml.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipselabs.damos.dml.Compound;
import org.eclipselabs.damos.dml.CompoundConnector;
import org.eclipselabs.damos.dml.DMLPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Compound Connector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.dml.impl.CompoundConnectorImpl#getCompound <em>Compound</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class CompoundConnectorImpl extends ConnectorImpl implements CompoundConnector {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompoundConnectorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DMLPackage.Literals.COMPOUND_CONNECTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Compound getCompound() {
		Compound compound = basicGetCompound();
		return compound != null && compound.eIsProxy() ? (Compound)eResolveProxy((InternalEObject)compound) : compound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Compound basicGetCompound() {
		EObject internalContainer = eInternalContainer();
		return internalContainer instanceof Compound ? (Compound) internalContainer : null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DMLPackage.COMPOUND_CONNECTOR__COMPOUND:
				if (resolve) return getCompound();
				return basicGetCompound();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case DMLPackage.COMPOUND_CONNECTOR__COMPOUND:
				return basicGetCompound() != null;
		}
		return super.eIsSet(featureID);
	}

} //CompoundConnectorImpl
