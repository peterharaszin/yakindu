/**
 */
package org.eclipse.damos.mscript.impl;

import java.util.Collection;

import org.eclipse.damos.mscript.CompositeType;
import org.eclipse.damos.mscript.CompositeTypeMember;
import org.eclipse.damos.mscript.CompositeTypeMemberList;
import org.eclipse.damos.mscript.MscriptPackage;
import org.eclipse.damos.mscript.OperatorKind;
import org.eclipse.damos.mscript.Type;
import org.eclipse.damos.mscript.internal.operations.CompositeTypeOperations;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Composite Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.damos.mscript.impl.CompositeTypeImpl#getLabel <em>Label</em>}</li>
 *   <li>{@link org.eclipse.damos.mscript.impl.CompositeTypeImpl#isAnyLabel <em>Any Label</em>}</li>
 *   <li>{@link org.eclipse.damos.mscript.impl.CompositeTypeImpl#getMemberLists <em>Member Lists</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class CompositeTypeImpl extends DataTypeImpl implements CompositeType {
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
	 * The cached value of the '{@link #getMemberLists() <em>Member Lists</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMemberLists()
	 * @generated
	 * @ordered
	 */
	protected EList<CompositeTypeMemberList> memberLists;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompositeTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MscriptPackage.Literals.COMPOSITE_TYPE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, MscriptPackage.COMPOSITE_TYPE__LABEL, oldLabel, label));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MscriptPackage.COMPOSITE_TYPE__ANY_LABEL, oldAnyLabel, anyLabel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CompositeTypeMemberList> getMemberLists() {
		if (memberLists == null) {
			memberLists = new EObjectContainmentEList<CompositeTypeMemberList>(CompositeTypeMemberList.class, this, MscriptPackage.COMPOSITE_TYPE__MEMBER_LISTS);
		}
		return memberLists;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<CompositeTypeMember> getMembers() {
		return CompositeTypeOperations.getMembers(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public CompositeTypeMember getMember(String name) {
		return CompositeTypeOperations.getMember(this, name);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getMemberIndex(String name) {
		return CompositeTypeOperations.getMemberIndex(this, name);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.mscript.impl.TypeImpl#evaluate(org.eclipse.damos.mscript.OperatorKind, org.eclipse.damos.mscript.Type)
	 */
	@Override
	public Type evaluate(OperatorKind operator, Type other) {
		return CompositeTypeOperations.evaluate(this, operator, other);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.mscript.impl.TypeImpl#evaluate(org.eclipse.damos.mscript.OperatorKind, int)
	 */
	@Override
	public Type evaluate(OperatorKind operator, int n) {
		return CompositeTypeOperations.evaluate(this, operator, n);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.mscript.impl.TypeImpl#isAssignableFrom(org.eclipse.damos.mscript.Type)
	 */
	@Override
	public abstract boolean isAssignableFrom(Type other);
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MscriptPackage.COMPOSITE_TYPE__MEMBER_LISTS:
				return ((InternalEList<?>)getMemberLists()).basicRemove(otherEnd, msgs);
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
			case MscriptPackage.COMPOSITE_TYPE__LABEL:
				return getLabel();
			case MscriptPackage.COMPOSITE_TYPE__ANY_LABEL:
				return isAnyLabel();
			case MscriptPackage.COMPOSITE_TYPE__MEMBER_LISTS:
				return getMemberLists();
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
			case MscriptPackage.COMPOSITE_TYPE__LABEL:
				setLabel((String)newValue);
				return;
			case MscriptPackage.COMPOSITE_TYPE__ANY_LABEL:
				setAnyLabel((Boolean)newValue);
				return;
			case MscriptPackage.COMPOSITE_TYPE__MEMBER_LISTS:
				getMemberLists().clear();
				getMemberLists().addAll((Collection<? extends CompositeTypeMemberList>)newValue);
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
			case MscriptPackage.COMPOSITE_TYPE__LABEL:
				setLabel(LABEL_EDEFAULT);
				return;
			case MscriptPackage.COMPOSITE_TYPE__ANY_LABEL:
				setAnyLabel(ANY_LABEL_EDEFAULT);
				return;
			case MscriptPackage.COMPOSITE_TYPE__MEMBER_LISTS:
				getMemberLists().clear();
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
			case MscriptPackage.COMPOSITE_TYPE__LABEL:
				return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals(label);
			case MscriptPackage.COMPOSITE_TYPE__ANY_LABEL:
				return anyLabel != ANY_LABEL_EDEFAULT;
			case MscriptPackage.COMPOSITE_TYPE__MEMBER_LISTS:
				return memberLists != null && !memberLists.isEmpty();
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

} //CompositeTypeImpl
