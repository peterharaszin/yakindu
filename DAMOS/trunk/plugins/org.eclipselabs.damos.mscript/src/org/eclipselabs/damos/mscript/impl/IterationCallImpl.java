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
import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.IterationAccumulator;
import org.eclipselabs.damos.mscript.IterationCall;
import org.eclipselabs.damos.mscript.IterationVariableDeclaration;
import org.eclipselabs.damos.mscript.MscriptPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Iteration Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.mscript.impl.IterationCallImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.impl.IterationCallImpl#getIdentifier <em>Identifier</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.impl.IterationCallImpl#getIterationVariables <em>Iteration Variables</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.impl.IterationCallImpl#getAccumulator <em>Accumulator</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.impl.IterationCallImpl#getBreakCondition <em>Break Condition</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.impl.IterationCallImpl#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IterationCallImpl extends ExpressionImpl implements IterationCall {
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
	 * The default value of the '{@link #getIdentifier() <em>Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdentifier()
	 * @generated
	 * @ordered
	 */
	protected static final String IDENTIFIER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIdentifier() <em>Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdentifier()
	 * @generated
	 * @ordered
	 */
	protected String identifier = IDENTIFIER_EDEFAULT;

	/**
	 * The cached value of the '{@link #getIterationVariables() <em>Iteration Variables</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIterationVariables()
	 * @generated
	 * @ordered
	 */
	protected EList<IterationVariableDeclaration> iterationVariables;

	/**
	 * The cached value of the '{@link #getAccumulator() <em>Accumulator</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAccumulator()
	 * @generated
	 * @ordered
	 */
	protected IterationAccumulator accumulator;

	/**
	 * The cached value of the '{@link #getBreakCondition() <em>Break Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBreakCondition()
	 * @generated
	 * @ordered
	 */
	protected Expression breakCondition;

	/**
	 * The cached value of the '{@link #getExpression() <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpression()
	 * @generated
	 * @ordered
	 */
	protected Expression expression;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IterationCallImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MscriptPackage.Literals.ITERATION_CALL;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MscriptPackage.ITERATION_CALL__TARGET, oldTarget, newTarget);
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
				msgs = ((InternalEObject)target).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MscriptPackage.ITERATION_CALL__TARGET, null, msgs);
			if (newTarget != null)
				msgs = ((InternalEObject)newTarget).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MscriptPackage.ITERATION_CALL__TARGET, null, msgs);
			msgs = basicSetTarget(newTarget, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MscriptPackage.ITERATION_CALL__TARGET, newTarget, newTarget));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIdentifier() {
		return identifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdentifier(String newIdentifier) {
		String oldIdentifier = identifier;
		identifier = newIdentifier;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MscriptPackage.ITERATION_CALL__IDENTIFIER, oldIdentifier, identifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IterationVariableDeclaration> getIterationVariables() {
		if (iterationVariables == null) {
			iterationVariables = new EObjectContainmentEList<IterationVariableDeclaration>(IterationVariableDeclaration.class, this, MscriptPackage.ITERATION_CALL__ITERATION_VARIABLES);
		}
		return iterationVariables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IterationAccumulator getAccumulator() {
		return accumulator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAccumulator(IterationAccumulator newAccumulator, NotificationChain msgs) {
		IterationAccumulator oldAccumulator = accumulator;
		accumulator = newAccumulator;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MscriptPackage.ITERATION_CALL__ACCUMULATOR, oldAccumulator, newAccumulator);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAccumulator(IterationAccumulator newAccumulator) {
		if (newAccumulator != accumulator) {
			NotificationChain msgs = null;
			if (accumulator != null)
				msgs = ((InternalEObject)accumulator).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MscriptPackage.ITERATION_CALL__ACCUMULATOR, null, msgs);
			if (newAccumulator != null)
				msgs = ((InternalEObject)newAccumulator).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MscriptPackage.ITERATION_CALL__ACCUMULATOR, null, msgs);
			msgs = basicSetAccumulator(newAccumulator, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MscriptPackage.ITERATION_CALL__ACCUMULATOR, newAccumulator, newAccumulator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getBreakCondition() {
		return breakCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBreakCondition(Expression newBreakCondition, NotificationChain msgs) {
		Expression oldBreakCondition = breakCondition;
		breakCondition = newBreakCondition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MscriptPackage.ITERATION_CALL__BREAK_CONDITION, oldBreakCondition, newBreakCondition);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBreakCondition(Expression newBreakCondition) {
		if (newBreakCondition != breakCondition) {
			NotificationChain msgs = null;
			if (breakCondition != null)
				msgs = ((InternalEObject)breakCondition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MscriptPackage.ITERATION_CALL__BREAK_CONDITION, null, msgs);
			if (newBreakCondition != null)
				msgs = ((InternalEObject)newBreakCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MscriptPackage.ITERATION_CALL__BREAK_CONDITION, null, msgs);
			msgs = basicSetBreakCondition(newBreakCondition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MscriptPackage.ITERATION_CALL__BREAK_CONDITION, newBreakCondition, newBreakCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getExpression() {
		return expression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExpression(Expression newExpression, NotificationChain msgs) {
		Expression oldExpression = expression;
		expression = newExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MscriptPackage.ITERATION_CALL__EXPRESSION, oldExpression, newExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpression(Expression newExpression) {
		if (newExpression != expression) {
			NotificationChain msgs = null;
			if (expression != null)
				msgs = ((InternalEObject)expression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MscriptPackage.ITERATION_CALL__EXPRESSION, null, msgs);
			if (newExpression != null)
				msgs = ((InternalEObject)newExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MscriptPackage.ITERATION_CALL__EXPRESSION, null, msgs);
			msgs = basicSetExpression(newExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MscriptPackage.ITERATION_CALL__EXPRESSION, newExpression, newExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MscriptPackage.ITERATION_CALL__TARGET:
				return basicSetTarget(null, msgs);
			case MscriptPackage.ITERATION_CALL__ITERATION_VARIABLES:
				return ((InternalEList<?>)getIterationVariables()).basicRemove(otherEnd, msgs);
			case MscriptPackage.ITERATION_CALL__ACCUMULATOR:
				return basicSetAccumulator(null, msgs);
			case MscriptPackage.ITERATION_CALL__BREAK_CONDITION:
				return basicSetBreakCondition(null, msgs);
			case MscriptPackage.ITERATION_CALL__EXPRESSION:
				return basicSetExpression(null, msgs);
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
			case MscriptPackage.ITERATION_CALL__TARGET:
				return getTarget();
			case MscriptPackage.ITERATION_CALL__IDENTIFIER:
				return getIdentifier();
			case MscriptPackage.ITERATION_CALL__ITERATION_VARIABLES:
				return getIterationVariables();
			case MscriptPackage.ITERATION_CALL__ACCUMULATOR:
				return getAccumulator();
			case MscriptPackage.ITERATION_CALL__BREAK_CONDITION:
				return getBreakCondition();
			case MscriptPackage.ITERATION_CALL__EXPRESSION:
				return getExpression();
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
			case MscriptPackage.ITERATION_CALL__TARGET:
				setTarget((Expression)newValue);
				return;
			case MscriptPackage.ITERATION_CALL__IDENTIFIER:
				setIdentifier((String)newValue);
				return;
			case MscriptPackage.ITERATION_CALL__ITERATION_VARIABLES:
				getIterationVariables().clear();
				getIterationVariables().addAll((Collection<? extends IterationVariableDeclaration>)newValue);
				return;
			case MscriptPackage.ITERATION_CALL__ACCUMULATOR:
				setAccumulator((IterationAccumulator)newValue);
				return;
			case MscriptPackage.ITERATION_CALL__BREAK_CONDITION:
				setBreakCondition((Expression)newValue);
				return;
			case MscriptPackage.ITERATION_CALL__EXPRESSION:
				setExpression((Expression)newValue);
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
			case MscriptPackage.ITERATION_CALL__TARGET:
				setTarget((Expression)null);
				return;
			case MscriptPackage.ITERATION_CALL__IDENTIFIER:
				setIdentifier(IDENTIFIER_EDEFAULT);
				return;
			case MscriptPackage.ITERATION_CALL__ITERATION_VARIABLES:
				getIterationVariables().clear();
				return;
			case MscriptPackage.ITERATION_CALL__ACCUMULATOR:
				setAccumulator((IterationAccumulator)null);
				return;
			case MscriptPackage.ITERATION_CALL__BREAK_CONDITION:
				setBreakCondition((Expression)null);
				return;
			case MscriptPackage.ITERATION_CALL__EXPRESSION:
				setExpression((Expression)null);
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
			case MscriptPackage.ITERATION_CALL__TARGET:
				return target != null;
			case MscriptPackage.ITERATION_CALL__IDENTIFIER:
				return IDENTIFIER_EDEFAULT == null ? identifier != null : !IDENTIFIER_EDEFAULT.equals(identifier);
			case MscriptPackage.ITERATION_CALL__ITERATION_VARIABLES:
				return iterationVariables != null && !iterationVariables.isEmpty();
			case MscriptPackage.ITERATION_CALL__ACCUMULATOR:
				return accumulator != null;
			case MscriptPackage.ITERATION_CALL__BREAK_CONDITION:
				return breakCondition != null;
			case MscriptPackage.ITERATION_CALL__EXPRESSION:
				return expression != null;
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
		result.append(" (identifier: ");
		result.append(identifier);
		result.append(')');
		return result.toString();
	}

} //IterationCallImpl
