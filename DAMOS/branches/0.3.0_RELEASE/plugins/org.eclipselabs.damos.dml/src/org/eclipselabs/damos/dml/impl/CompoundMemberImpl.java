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
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipselabs.damos.dml.Compound;
import org.eclipselabs.damos.dml.CompoundMember;
import org.eclipselabs.damos.dml.DMLPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Compound Member</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.dml.impl.CompoundMemberImpl#getOwningCompound <em>Owning Compound</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class CompoundMemberImpl extends EObjectImpl implements CompoundMember {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompoundMemberImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DMLPackage.Literals.COMPOUND_MEMBER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Compound getOwningCompound() {
		Compound owningCompound = basicGetOwningCompound();
		return owningCompound != null && owningCompound.eIsProxy() ? (Compound)eResolveProxy((InternalEObject)owningCompound) : owningCompound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Compound basicGetOwningCompound() {
		EObject container = eInternalContainer();
		if (container instanceof Compound) {
			return (Compound) container;
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
			case DMLPackage.COMPOUND_MEMBER__OWNING_COMPOUND:
				if (resolve) return getOwningCompound();
				return basicGetOwningCompound();
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
			case DMLPackage.COMPOUND_MEMBER__OWNING_COMPOUND:
				return basicGetOwningCompound() != null;
		}
		return super.eIsSet(featureID);
	}

} //CompoundMemberImpl
