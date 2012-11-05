/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.damos.dml.impl;

import java.util.Collection;

import org.eclipse.damos.dml.DMLPackage;
import org.eclipse.damos.dml.Inlet;
import org.eclipse.damos.dml.Outlet;
import org.eclipse.damos.dml.SystemInterface;
import org.eclipse.damos.dml.internal.util.URIUtil;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>System Interface</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.damos.dml.impl.SystemInterfaceImpl#getInlets <em>Inlets</em>}</li>
 *   <li>{@link org.eclipse.damos.dml.impl.SystemInterfaceImpl#getOutlets <em>Outlets</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SystemInterfaceImpl extends QualifiedElementImpl implements SystemInterface {
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
		}
		return super.eIsSet(featureID);
	}

	@Override
	public EObject eObjectForURIFragmentSegment(String uriFragmentSegment) {
		EObject eObject = URIUtil.eObjectForURIFragmentSegment(this, uriFragmentSegment);
		return eObject != null ? eObject : super.eObjectForURIFragmentSegment(uriFragmentSegment);
	}
	
	@Override
	public String eURIFragmentSegment(EStructuralFeature eStructuralFeature, EObject eObject) {
		String fragmentSegment = URIUtil.eURIFragmentSegment(eStructuralFeature, eObject);
		return fragmentSegment != null ? fragmentSegment : super.eURIFragmentSegment(eStructuralFeature, eObject);
	}

} //SystemInterfaceImpl
