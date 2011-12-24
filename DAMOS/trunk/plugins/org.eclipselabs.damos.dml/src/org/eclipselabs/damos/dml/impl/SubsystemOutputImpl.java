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
import org.eclipselabs.damos.dml.Inoutlet;
import org.eclipselabs.damos.dml.Outlet;
import org.eclipselabs.damos.dml.SubsystemOutput;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Subsystem Output</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.dml.impl.SubsystemOutputImpl#getOutlet <em>Outlet</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SubsystemOutputImpl extends OutputImpl implements SubsystemOutput {
	/**
	 * The cached value of the '{@link #getOutlet() <em>Outlet</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutlet()
	 * @generated
	 * @ordered
	 */
	protected Outlet outlet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SubsystemOutputImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DMLPackage.Literals.SUBSYSTEM_OUTPUT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Outlet getOutlet() {
		if (outlet != null && outlet.eIsProxy()) {
			InternalEObject oldOutlet = (InternalEObject)outlet;
			outlet = (Outlet)eResolveProxy(oldOutlet);
			if (outlet != oldOutlet) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DMLPackage.SUBSYSTEM_OUTPUT__OUTLET, oldOutlet, outlet));
			}
		}
		return outlet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Outlet basicGetOutlet() {
		return outlet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutlet(Outlet newOutlet) {
		Outlet oldOutlet = outlet;
		outlet = newOutlet;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DMLPackage.SUBSYSTEM_OUTPUT__OUTLET, oldOutlet, outlet));
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Inoutlet getInoutlet() {
		return getOutlet();
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.dml.impl.OutputImpl#getName()
	 */
	@Override
	public String getName() {
		Outlet outlet = getOutlet();
		return outlet != null ? outlet.getName() : super.getName();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DMLPackage.SUBSYSTEM_OUTPUT__OUTLET:
				if (resolve) return getOutlet();
				return basicGetOutlet();
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
			case DMLPackage.SUBSYSTEM_OUTPUT__OUTLET:
				setOutlet((Outlet)newValue);
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
			case DMLPackage.SUBSYSTEM_OUTPUT__OUTLET:
				setOutlet((Outlet)null);
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
			case DMLPackage.SUBSYSTEM_OUTPUT__OUTLET:
				return outlet != null;
		}
		return super.eIsSet(featureID);
	}

} //SubsystemOutputImpl
