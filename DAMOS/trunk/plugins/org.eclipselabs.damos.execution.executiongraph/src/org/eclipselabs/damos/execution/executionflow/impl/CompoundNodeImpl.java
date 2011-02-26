/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.execution.executionflow.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipselabs.damos.dml.Compound;
import org.eclipselabs.damos.execution.executionflow.CompoundNode;
import org.eclipselabs.damos.execution.executionflow.ExecutionFlowPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Compound Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.execution.executionflow.impl.CompoundNodeImpl#getCompound <em>Compound</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CompoundNodeImpl extends SubgraphImpl implements CompoundNode {
	/**
	 * The cached value of the '{@link #getCompound() <em>Compound</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompound()
	 * @generated
	 * @ordered
	 */
	protected Compound compound;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompoundNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExecutionFlowPackage.Literals.COMPOUND_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Compound getCompound() {
		if (compound != null && compound.eIsProxy()) {
			InternalEObject oldCompound = (InternalEObject)compound;
			compound = (Compound)eResolveProxy(oldCompound);
			if (compound != oldCompound) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionFlowPackage.COMPOUND_NODE__COMPOUND, oldCompound, compound));
			}
		}
		return compound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Compound basicGetCompound() {
		return compound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompound(Compound newCompound) {
		Compound oldCompound = compound;
		compound = newCompound;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionFlowPackage.COMPOUND_NODE__COMPOUND, oldCompound, compound));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ExecutionFlowPackage.COMPOUND_NODE__COMPOUND:
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
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ExecutionFlowPackage.COMPOUND_NODE__COMPOUND:
				setCompound((Compound)newValue);
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
			case ExecutionFlowPackage.COMPOUND_NODE__COMPOUND:
				setCompound((Compound)null);
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
			case ExecutionFlowPackage.COMPOUND_NODE__COMPOUND:
				return compound != null;
		}
		return super.eIsSet(featureID);
	}

} //CompoundNodeImpl
