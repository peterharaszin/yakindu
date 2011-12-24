/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dml.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.Inlet;
import org.eclipselabs.damos.dml.Inoutlet;
import org.eclipselabs.damos.dml.SubsystemInput;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Subsystem Input</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.dml.impl.SubsystemInputImpl#getInlet <em>Inlet</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SubsystemInputImpl extends InputImpl implements SubsystemInput {
	/**
	 * The cached value of the '{@link #getInlet() <em>Inlet</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInlet()
	 * @generated
	 * @ordered
	 */
	protected Inlet inlet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SubsystemInputImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DMLPackage.Literals.SUBSYSTEM_INPUT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Inlet getInlet() {
		if (inlet != null && inlet.eIsProxy()) {
			InternalEObject oldInlet = (InternalEObject)inlet;
			inlet = (Inlet)eResolveProxy(oldInlet);
			if (inlet != oldInlet) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DMLPackage.SUBSYSTEM_INPUT__INLET, oldInlet, inlet));
			}
		}
		return inlet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Inlet basicGetInlet() {
		return inlet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInlet(Inlet newInlet) {
		Inlet oldInlet = inlet;
		inlet = newInlet;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DMLPackage.SUBSYSTEM_INPUT__INLET, oldInlet, inlet));
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Inoutlet getInoutlet() {
		return getInlet();
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.dml.impl.InputImpl#getName()
	 */
	@Override
	public String getName() {
		Inlet inlet = getInlet();
		return inlet != null ? inlet.getName() : super.getName();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DMLPackage.SUBSYSTEM_INPUT__INLET:
				if (resolve) return getInlet();
				return basicGetInlet();
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
			case DMLPackage.SUBSYSTEM_INPUT__INLET:
				setInlet((Inlet)newValue);
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
			case DMLPackage.SUBSYSTEM_INPUT__INLET:
				setInlet((Inlet)null);
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
			case DMLPackage.SUBSYSTEM_INPUT__INLET:
				return inlet != null;
		}
		return super.eIsSet(featureID);
	}

} //SubsystemInputImpl
