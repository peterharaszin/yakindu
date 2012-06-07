/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.mscript.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.MscriptPackage;
import org.eclipselabs.damos.mscript.OperatorKind;
import org.eclipselabs.damos.mscript.StructMember;
import org.eclipselabs.damos.mscript.StructType;
import org.eclipselabs.damos.mscript.internal.operations.StructTypeOperations;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Struct Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.mscript.impl.StructTypeImpl#getMembers <em>Members</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StructTypeImpl extends DataTypeImpl implements StructType {
	/**
	 * The cached value of the '{@link #getMembers() <em>Members</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMembers()
	 * @generated
	 * @ordered
	 */
	protected EList<StructMember> members;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StructTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MscriptPackage.Literals.STRUCT_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<StructMember> getMembers() {
		if (members == null) {
			members = new EObjectContainmentEList<StructMember>(StructMember.class, this, MscriptPackage.STRUCT_TYPE__MEMBERS);
		}
		return members;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public StructMember getMember(String name) {
		return StructTypeOperations.getMember(this, name);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getMemberIndex(String name) {
		return StructTypeOperations.getMemberIndex(this, name);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.impl.DataTypeImpl#evaluate(org.eclipselabs.damos.mscript.OperatorKind, org.eclipselabs.damos.mscript.DataType)
	 */
	@Override
	public DataType evaluate(OperatorKind operator, DataType other) {
		return StructTypeOperations.evaluate(this, operator, other);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.impl.DataTypeImpl#evaluate(org.eclipselabs.damos.mscript.OperatorKind, int)
	 */
	@Override
	public DataType evaluate(OperatorKind operator, int n) {
		return StructTypeOperations.evaluate(this, operator, n);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.impl.DataTypeImpl#isAssignableFrom(org.eclipselabs.damos.mscript.DataType)
	 */
	@Override
	public boolean isAssignableFrom(DataType other) {
		return StructTypeOperations.isAssignableFrom(this, other);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.impl.DataTypeImpl#isEquivalentTo(org.eclipselabs.damos.mscript.DataType)
	 */
	@Override
	public boolean isEquivalentTo(DataType other) {
		return StructTypeOperations.isEquivalentTo(this, other);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MscriptPackage.STRUCT_TYPE__MEMBERS:
				return ((InternalEList<?>)getMembers()).basicRemove(otherEnd, msgs);
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
			case MscriptPackage.STRUCT_TYPE__MEMBERS:
				return getMembers();
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
			case MscriptPackage.STRUCT_TYPE__MEMBERS:
				getMembers().clear();
				getMembers().addAll((Collection<? extends StructMember>)newValue);
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
			case MscriptPackage.STRUCT_TYPE__MEMBERS:
				getMembers().clear();
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
			case MscriptPackage.STRUCT_TYPE__MEMBERS:
				return members != null && !members.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //StructTypeImpl
