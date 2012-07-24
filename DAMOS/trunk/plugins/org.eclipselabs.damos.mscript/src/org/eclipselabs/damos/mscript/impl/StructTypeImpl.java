/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.mscript.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipselabs.damos.mscript.MscriptPackage;
import org.eclipselabs.damos.mscript.OperatorKind;
import org.eclipselabs.damos.mscript.StructMember;
import org.eclipselabs.damos.mscript.StructType;
import org.eclipselabs.damos.mscript.Type;
import org.eclipselabs.damos.mscript.internal.operations.StructTypeOperations;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Struct Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.mscript.impl.StructTypeImpl#getLabel <em>Label</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.impl.StructTypeImpl#isAnyLabel <em>Any Label</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.impl.StructTypeImpl#getMembers <em>Members</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StructTypeImpl extends DataTypeImpl implements StructType {
	/**
	 * The default value of the '{@link #getLabel() <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected static final String LABEL_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getLabel() <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected String label = LABEL_EDEFAULT;
	/**
	 * The default value of the '{@link #isAnyLabel() <em>Any Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAnyLabel()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ANY_LABEL_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isAnyLabel() <em>Any Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAnyLabel()
	 * @generated
	 * @ordered
	 */
	protected boolean anyLabel = ANY_LABEL_EDEFAULT;
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
	public String getLabel() {
		return label;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLabel(String newLabel) {
		String oldLabel = label;
		label = newLabel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MscriptPackage.STRUCT_TYPE__LABEL, oldLabel, label));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAnyLabel() {
		return anyLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAnyLabel(boolean newAnyLabel) {
		boolean oldAnyLabel = anyLabel;
		anyLabel = newAnyLabel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MscriptPackage.STRUCT_TYPE__ANY_LABEL, oldAnyLabel, anyLabel));
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
	public Type evaluate(OperatorKind operator, Type other) {
		return StructTypeOperations.evaluate(this, operator, other);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.impl.DataTypeImpl#evaluate(org.eclipselabs.damos.mscript.OperatorKind, int)
	 */
	@Override
	public Type evaluate(OperatorKind operator, int n) {
		return StructTypeOperations.evaluate(this, operator, n);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.impl.DataTypeImpl#isAssignableFrom(org.eclipselabs.damos.mscript.DataType)
	 */
	@Override
	public boolean isAssignableFrom(Type other) {
		return StructTypeOperations.isAssignableFrom(this, other);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.impl.DataTypeImpl#isEquivalentTo(org.eclipselabs.damos.mscript.DataType)
	 */
	@Override
	public boolean isEquivalentTo(Type other) {
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
			case MscriptPackage.STRUCT_TYPE__LABEL:
				return getLabel();
			case MscriptPackage.STRUCT_TYPE__ANY_LABEL:
				return isAnyLabel();
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
			case MscriptPackage.STRUCT_TYPE__LABEL:
				setLabel((String)newValue);
				return;
			case MscriptPackage.STRUCT_TYPE__ANY_LABEL:
				setAnyLabel((Boolean)newValue);
				return;
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
			case MscriptPackage.STRUCT_TYPE__LABEL:
				setLabel(LABEL_EDEFAULT);
				return;
			case MscriptPackage.STRUCT_TYPE__ANY_LABEL:
				setAnyLabel(ANY_LABEL_EDEFAULT);
				return;
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
			case MscriptPackage.STRUCT_TYPE__LABEL:
				return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals(label);
			case MscriptPackage.STRUCT_TYPE__ANY_LABEL:
				return anyLabel != ANY_LABEL_EDEFAULT;
			case MscriptPackage.STRUCT_TYPE__MEMBERS:
				return members != null && !members.isEmpty();
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
		result.append(" (label: ");
		result.append(label);
		result.append(", anyLabel: ");
		result.append(anyLabel);
		result.append(')');
		return result.toString();
	}

} //StructTypeImpl
