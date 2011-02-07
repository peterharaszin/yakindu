/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dml.impl;

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
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.Inlet;
import org.eclipselabs.damos.dml.Outlet;
import org.eclipselabs.damos.dml.SystemInterface;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>System Interface</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.dml.impl.SystemInterfaceImpl#getInlets <em>Inlets</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dml.impl.SystemInterfaceImpl#getOutlets <em>Outlets</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dml.impl.SystemInterfaceImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SystemInterfaceImpl extends EObjectImpl implements SystemInterface {
	/**
	 * The cached value of the '{@link #getInlets() <em>Inlets</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInlets()
	 * @generated
	 * @ordered
	 */
	protected EList<Inlet> inlets;

	/**
	 * The cached value of the '{@link #getOutlets() <em>Outlets</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutlets()
	 * @generated
	 * @ordered
	 */
	protected EList<Outlet> outlets;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SystemInterfaceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DMLPackage.Literals.SYSTEM_INTERFACE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Inlet> getInlets() {
		if (inlets == null) {
			inlets = new EObjectContainmentEList<Inlet>(Inlet.class, this, DMLPackage.SYSTEM_INTERFACE__INLETS);
		}
		return inlets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Outlet> getOutlets() {
		if (outlets == null) {
			outlets = new EObjectContainmentEList<Outlet>(Outlet.class, this, DMLPackage.SYSTEM_INTERFACE__OUTLETS);
		}
		return outlets;
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
			eNotify(new ENotificationImpl(this, Notification.SET, DMLPackage.SYSTEM_INTERFACE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DMLPackage.SYSTEM_INTERFACE__INLETS:
				return ((InternalEList<?>)getInlets()).basicRemove(otherEnd, msgs);
			case DMLPackage.SYSTEM_INTERFACE__OUTLETS:
				return ((InternalEList<?>)getOutlets()).basicRemove(otherEnd, msgs);
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
			case DMLPackage.SYSTEM_INTERFACE__INLETS:
				return getInlets();
			case DMLPackage.SYSTEM_INTERFACE__OUTLETS:
				return getOutlets();
			case DMLPackage.SYSTEM_INTERFACE__NAME:
				return getName();
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
			case DMLPackage.SYSTEM_INTERFACE__INLETS:
				getInlets().clear();
				getInlets().addAll((Collection<? extends Inlet>)newValue);
				return;
			case DMLPackage.SYSTEM_INTERFACE__OUTLETS:
				getOutlets().clear();
				getOutlets().addAll((Collection<? extends Outlet>)newValue);
				return;
			case DMLPackage.SYSTEM_INTERFACE__NAME:
				setName((String)newValue);
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
			case DMLPackage.SYSTEM_INTERFACE__INLETS:
				getInlets().clear();
				return;
			case DMLPackage.SYSTEM_INTERFACE__OUTLETS:
				getOutlets().clear();
				return;
			case DMLPackage.SYSTEM_INTERFACE__NAME:
				setName(NAME_EDEFAULT);
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
			case DMLPackage.SYSTEM_INTERFACE__INLETS:
				return inlets != null && !inlets.isEmpty();
			case DMLPackage.SYSTEM_INTERFACE__OUTLETS:
				return outlets != null && !outlets.isEmpty();
			case DMLPackage.SYSTEM_INTERFACE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		}
		return super.eIsSet(featureID);
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

} //SystemInterfaceImpl
