/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.mscript.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.MemberVariableAccess;
import org.eclipselabs.damos.mscript.MscriptPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Member Variable Access</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.mscript.impl.MemberVariableAccessImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.impl.MemberVariableAccessImpl#getMemberVariable <em>Member Variable</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MemberVariableAccessImpl extends ExpressionImpl implements MemberVariableAccess {
	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected Expression target;

	/**
	 * The default value of the '{@link #getMemberVariable() <em>Member Variable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMemberVariable()
	 * @generated
	 * @ordered
	 */
	protected static final String MEMBER_VARIABLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMemberVariable() <em>Member Variable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMemberVariable()
	 * @generated
	 * @ordered
	 */
	protected String memberVariable = MEMBER_VARIABLE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MemberVariableAccessImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MscriptPackage.Literals.MEMBER_VARIABLE_ACCESS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTarget(Expression newTarget, NotificationChain msgs) {
		Expression oldTarget = target;
		target = newTarget;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MscriptPackage.MEMBER_VARIABLE_ACCESS__TARGET, oldTarget, newTarget);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(Expression newTarget) {
		if (newTarget != target) {
			NotificationChain msgs = null;
			if (target != null)
				msgs = ((InternalEObject)target).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MscriptPackage.MEMBER_VARIABLE_ACCESS__TARGET, null, msgs);
			if (newTarget != null)
				msgs = ((InternalEObject)newTarget).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MscriptPackage.MEMBER_VARIABLE_ACCESS__TARGET, null, msgs);
			msgs = basicSetTarget(newTarget, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MscriptPackage.MEMBER_VARIABLE_ACCESS__TARGET, newTarget, newTarget));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMemberVariable() {
		return memberVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMemberVariable(String newMemberVariable) {
		String oldMemberVariable = memberVariable;
		memberVariable = newMemberVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MscriptPackage.MEMBER_VARIABLE_ACCESS__MEMBER_VARIABLE, oldMemberVariable, memberVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MscriptPackage.MEMBER_VARIABLE_ACCESS__TARGET:
				return basicSetTarget(null, msgs);
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
			case MscriptPackage.MEMBER_VARIABLE_ACCESS__TARGET:
				return getTarget();
			case MscriptPackage.MEMBER_VARIABLE_ACCESS__MEMBER_VARIABLE:
				return getMemberVariable();
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
			case MscriptPackage.MEMBER_VARIABLE_ACCESS__TARGET:
				setTarget((Expression)newValue);
				return;
			case MscriptPackage.MEMBER_VARIABLE_ACCESS__MEMBER_VARIABLE:
				setMemberVariable((String)newValue);
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
			case MscriptPackage.MEMBER_VARIABLE_ACCESS__TARGET:
				setTarget((Expression)null);
				return;
			case MscriptPackage.MEMBER_VARIABLE_ACCESS__MEMBER_VARIABLE:
				setMemberVariable(MEMBER_VARIABLE_EDEFAULT);
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
			case MscriptPackage.MEMBER_VARIABLE_ACCESS__TARGET:
				return target != null;
			case MscriptPackage.MEMBER_VARIABLE_ACCESS__MEMBER_VARIABLE:
				return MEMBER_VARIABLE_EDEFAULT == null ? memberVariable != null : !MEMBER_VARIABLE_EDEFAULT.equals(memberVariable);
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
		result.append(" (memberVariable: ");
		result.append(memberVariable);
		result.append(')');
		return result.toString();
	}

} //MemberVariableAccessImpl
