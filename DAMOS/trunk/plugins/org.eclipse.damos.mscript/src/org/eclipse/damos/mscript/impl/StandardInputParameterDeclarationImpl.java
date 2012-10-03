/**
 */
package org.eclipse.damos.mscript.impl;

import org.eclipse.damos.mscript.Expression;
import org.eclipse.damos.mscript.MscriptPackage;
import org.eclipse.damos.mscript.StandardInputParameterDeclaration;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Standard Input Parameter Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.damos.mscript.impl.StandardInputParameterDeclarationImpl#isConstant <em>Constant</em>}</li>
 *   <li>{@link org.eclipse.damos.mscript.impl.StandardInputParameterDeclarationImpl#getDefaultExpression <em>Default Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StandardInputParameterDeclarationImpl extends StandardParameterDeclarationImpl implements StandardInputParameterDeclaration {
	/**
	 * The default value of the '{@link #isConstant() <em>Constant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isConstant()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CONSTANT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isConstant() <em>Constant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isConstant()
	 * @generated
	 * @ordered
	 */
	protected boolean constant = CONSTANT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDefaultExpression() <em>Default Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultExpression()
	 * @generated
	 * @ordered
	 */
	protected Expression defaultExpression;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StandardInputParameterDeclarationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MscriptPackage.Literals.STANDARD_INPUT_PARAMETER_DECLARATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isConstant() {
		return constant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConstant(boolean newConstant) {
		boolean oldConstant = constant;
		constant = newConstant;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MscriptPackage.STANDARD_INPUT_PARAMETER_DECLARATION__CONSTANT, oldConstant, constant));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getDefaultExpression() {
		return defaultExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDefaultExpression(Expression newDefaultExpression, NotificationChain msgs) {
		Expression oldDefaultExpression = defaultExpression;
		defaultExpression = newDefaultExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MscriptPackage.STANDARD_INPUT_PARAMETER_DECLARATION__DEFAULT_EXPRESSION, oldDefaultExpression, newDefaultExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultExpression(Expression newDefaultExpression) {
		if (newDefaultExpression != defaultExpression) {
			NotificationChain msgs = null;
			if (defaultExpression != null)
				msgs = ((InternalEObject)defaultExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MscriptPackage.STANDARD_INPUT_PARAMETER_DECLARATION__DEFAULT_EXPRESSION, null, msgs);
			if (newDefaultExpression != null)
				msgs = ((InternalEObject)newDefaultExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MscriptPackage.STANDARD_INPUT_PARAMETER_DECLARATION__DEFAULT_EXPRESSION, null, msgs);
			msgs = basicSetDefaultExpression(newDefaultExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MscriptPackage.STANDARD_INPUT_PARAMETER_DECLARATION__DEFAULT_EXPRESSION, newDefaultExpression, newDefaultExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MscriptPackage.STANDARD_INPUT_PARAMETER_DECLARATION__DEFAULT_EXPRESSION:
				return basicSetDefaultExpression(null, msgs);
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
			case MscriptPackage.STANDARD_INPUT_PARAMETER_DECLARATION__CONSTANT:
				return isConstant();
			case MscriptPackage.STANDARD_INPUT_PARAMETER_DECLARATION__DEFAULT_EXPRESSION:
				return getDefaultExpression();
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
			case MscriptPackage.STANDARD_INPUT_PARAMETER_DECLARATION__CONSTANT:
				setConstant((Boolean)newValue);
				return;
			case MscriptPackage.STANDARD_INPUT_PARAMETER_DECLARATION__DEFAULT_EXPRESSION:
				setDefaultExpression((Expression)newValue);
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
			case MscriptPackage.STANDARD_INPUT_PARAMETER_DECLARATION__CONSTANT:
				setConstant(CONSTANT_EDEFAULT);
				return;
			case MscriptPackage.STANDARD_INPUT_PARAMETER_DECLARATION__DEFAULT_EXPRESSION:
				setDefaultExpression((Expression)null);
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
			case MscriptPackage.STANDARD_INPUT_PARAMETER_DECLARATION__CONSTANT:
				return constant != CONSTANT_EDEFAULT;
			case MscriptPackage.STANDARD_INPUT_PARAMETER_DECLARATION__DEFAULT_EXPRESSION:
				return defaultExpression != null;
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
		result.append(" (constant: ");
		result.append(constant);
		result.append(')');
		return result.toString();
	}

} //StandardInputParameterDeclarationImpl
