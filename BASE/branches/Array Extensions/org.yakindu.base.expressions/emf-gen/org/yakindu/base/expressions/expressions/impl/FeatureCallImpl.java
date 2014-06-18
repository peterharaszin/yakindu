/**
 */
package org.yakindu.base.expressions.expressions.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.yakindu.base.expressions.expressions.Expression;
import org.yakindu.base.expressions.expressions.ExpressionsPackage;
import org.yakindu.base.expressions.expressions.FeatureCall;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Feature Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.yakindu.base.expressions.expressions.impl.FeatureCallImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link org.yakindu.base.expressions.expressions.impl.FeatureCallImpl#getFeature <em>Feature</em>}</li>
 *   <li>{@link org.yakindu.base.expressions.expressions.impl.FeatureCallImpl#isOperationCall <em>Operation Call</em>}</li>
 *   <li>{@link org.yakindu.base.expressions.expressions.impl.FeatureCallImpl#getArgs <em>Args</em>}</li>
 *   <li>{@link org.yakindu.base.expressions.expressions.impl.FeatureCallImpl#isArrayAccess <em>Array Access</em>}</li>
 *   <li>{@link org.yakindu.base.expressions.expressions.impl.FeatureCallImpl#getArraySelector <em>Array Selector</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FeatureCallImpl extends ExpressionImpl implements FeatureCall {
	/**
	 * The cached value of the '{@link #getOwner() <em>Owner</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwner()
	 * @generated
	 * @ordered
	 */
	protected Expression owner;

	/**
	 * The cached value of the '{@link #getFeature() <em>Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeature()
	 * @generated
	 * @ordered
	 */
	protected EObject feature;

	/**
	 * The default value of the '{@link #isOperationCall() <em>Operation Call</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOperationCall()
	 * @generated
	 * @ordered
	 */
	protected static final boolean OPERATION_CALL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isOperationCall() <em>Operation Call</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOperationCall()
	 * @generated
	 * @ordered
	 */
	protected boolean operationCall = OPERATION_CALL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getArgs() <em>Args</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArgs()
	 * @generated
	 * @ordered
	 */
	protected EList<Expression> args;

	/**
	 * The default value of the '{@link #isArrayAccess() <em>Array Access</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isArrayAccess()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ARRAY_ACCESS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isArrayAccess() <em>Array Access</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isArrayAccess()
	 * @generated
	 * @ordered
	 */
	protected boolean arrayAccess = ARRAY_ACCESS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getArraySelector() <em>Array Selector</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArraySelector()
	 * @generated
	 * @ordered
	 */
	protected EList<Expression> arraySelector;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FeatureCallImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExpressionsPackage.Literals.FEATURE_CALL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getOwner() {
		return owner;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwner(Expression newOwner, NotificationChain msgs) {
		Expression oldOwner = owner;
		owner = newOwner;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionsPackage.FEATURE_CALL__OWNER, oldOwner, newOwner);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwner(Expression newOwner) {
		if (newOwner != owner) {
			NotificationChain msgs = null;
			if (owner != null)
				msgs = ((InternalEObject)owner).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.FEATURE_CALL__OWNER, null, msgs);
			if (newOwner != null)
				msgs = ((InternalEObject)newOwner).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.FEATURE_CALL__OWNER, null, msgs);
			msgs = basicSetOwner(newOwner, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.FEATURE_CALL__OWNER, newOwner, newOwner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getFeature() {
		if (feature != null && feature.eIsProxy()) {
			InternalEObject oldFeature = (InternalEObject)feature;
			feature = eResolveProxy(oldFeature);
			if (feature != oldFeature) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExpressionsPackage.FEATURE_CALL__FEATURE, oldFeature, feature));
			}
		}
		return feature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetFeature() {
		return feature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeature(EObject newFeature) {
		EObject oldFeature = feature;
		feature = newFeature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.FEATURE_CALL__FEATURE, oldFeature, feature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isOperationCall() {
		return operationCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperationCall(boolean newOperationCall) {
		boolean oldOperationCall = operationCall;
		operationCall = newOperationCall;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.FEATURE_CALL__OPERATION_CALL, oldOperationCall, operationCall));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Expression> getArgs() {
		if (args == null) {
			args = new EObjectContainmentEList<Expression>(Expression.class, this, ExpressionsPackage.FEATURE_CALL__ARGS);
		}
		return args;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isArrayAccess() {
		return arrayAccess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setArrayAccess(boolean newArrayAccess) {
		boolean oldArrayAccess = arrayAccess;
		arrayAccess = newArrayAccess;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.FEATURE_CALL__ARRAY_ACCESS, oldArrayAccess, arrayAccess));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Expression> getArraySelector() {
		if (arraySelector == null) {
			arraySelector = new EObjectContainmentEList<Expression>(Expression.class, this, ExpressionsPackage.FEATURE_CALL__ARRAY_SELECTOR);
		}
		return arraySelector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ExpressionsPackage.FEATURE_CALL__OWNER:
				return basicSetOwner(null, msgs);
			case ExpressionsPackage.FEATURE_CALL__ARGS:
				return ((InternalEList<?>)getArgs()).basicRemove(otherEnd, msgs);
			case ExpressionsPackage.FEATURE_CALL__ARRAY_SELECTOR:
				return ((InternalEList<?>)getArraySelector()).basicRemove(otherEnd, msgs);
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
			case ExpressionsPackage.FEATURE_CALL__OWNER:
				return getOwner();
			case ExpressionsPackage.FEATURE_CALL__FEATURE:
				if (resolve) return getFeature();
				return basicGetFeature();
			case ExpressionsPackage.FEATURE_CALL__OPERATION_CALL:
				return isOperationCall();
			case ExpressionsPackage.FEATURE_CALL__ARGS:
				return getArgs();
			case ExpressionsPackage.FEATURE_CALL__ARRAY_ACCESS:
				return isArrayAccess();
			case ExpressionsPackage.FEATURE_CALL__ARRAY_SELECTOR:
				return getArraySelector();
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
			case ExpressionsPackage.FEATURE_CALL__OWNER:
				setOwner((Expression)newValue);
				return;
			case ExpressionsPackage.FEATURE_CALL__FEATURE:
				setFeature((EObject)newValue);
				return;
			case ExpressionsPackage.FEATURE_CALL__OPERATION_CALL:
				setOperationCall((Boolean)newValue);
				return;
			case ExpressionsPackage.FEATURE_CALL__ARGS:
				getArgs().clear();
				getArgs().addAll((Collection<? extends Expression>)newValue);
				return;
			case ExpressionsPackage.FEATURE_CALL__ARRAY_ACCESS:
				setArrayAccess((Boolean)newValue);
				return;
			case ExpressionsPackage.FEATURE_CALL__ARRAY_SELECTOR:
				getArraySelector().clear();
				getArraySelector().addAll((Collection<? extends Expression>)newValue);
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
			case ExpressionsPackage.FEATURE_CALL__OWNER:
				setOwner((Expression)null);
				return;
			case ExpressionsPackage.FEATURE_CALL__FEATURE:
				setFeature((EObject)null);
				return;
			case ExpressionsPackage.FEATURE_CALL__OPERATION_CALL:
				setOperationCall(OPERATION_CALL_EDEFAULT);
				return;
			case ExpressionsPackage.FEATURE_CALL__ARGS:
				getArgs().clear();
				return;
			case ExpressionsPackage.FEATURE_CALL__ARRAY_ACCESS:
				setArrayAccess(ARRAY_ACCESS_EDEFAULT);
				return;
			case ExpressionsPackage.FEATURE_CALL__ARRAY_SELECTOR:
				getArraySelector().clear();
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
			case ExpressionsPackage.FEATURE_CALL__OWNER:
				return owner != null;
			case ExpressionsPackage.FEATURE_CALL__FEATURE:
				return feature != null;
			case ExpressionsPackage.FEATURE_CALL__OPERATION_CALL:
				return operationCall != OPERATION_CALL_EDEFAULT;
			case ExpressionsPackage.FEATURE_CALL__ARGS:
				return args != null && !args.isEmpty();
			case ExpressionsPackage.FEATURE_CALL__ARRAY_ACCESS:
				return arrayAccess != ARRAY_ACCESS_EDEFAULT;
			case ExpressionsPackage.FEATURE_CALL__ARRAY_SELECTOR:
				return arraySelector != null && !arraySelector.isEmpty();
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
		result.append(" (operationCall: ");
		result.append(operationCall);
		result.append(", arrayAccess: ");
		result.append(arrayAccess);
		result.append(')');
		return result.toString();
	}

} //FeatureCallImpl
