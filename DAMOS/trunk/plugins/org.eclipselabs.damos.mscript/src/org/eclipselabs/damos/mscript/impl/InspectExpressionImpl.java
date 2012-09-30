/**
 */
package org.eclipselabs.damos.mscript.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.IExpressionVisitor;
import org.eclipselabs.damos.mscript.InspectExpression;
import org.eclipselabs.damos.mscript.InspectWhenClause;
import org.eclipselabs.damos.mscript.MscriptPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>When Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.mscript.impl.InspectExpressionImpl#getUnionExpression <em>Union Expression</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.impl.InspectExpressionImpl#getWhenClauses <em>When Clauses</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InspectExpressionImpl extends ExpressionImpl implements InspectExpression {
	/**
	 * The cached value of the '{@link #getUnionExpression() <em>Union Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnionExpression()
	 * @generated
	 * @ordered
	 */
	protected Expression unionExpression;

	/**
	 * The cached value of the '{@link #getWhenClauses() <em>When Clauses</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWhenClauses()
	 * @generated
	 * @ordered
	 */
	protected EList<InspectWhenClause> whenClauses;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InspectExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MscriptPackage.Literals.INSPECT_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getUnionExpression() {
		return unionExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnionExpression(Expression newUnionExpression, NotificationChain msgs) {
		Expression oldUnionExpression = unionExpression;
		unionExpression = newUnionExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MscriptPackage.INSPECT_EXPRESSION__UNION_EXPRESSION, oldUnionExpression, newUnionExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnionExpression(Expression newUnionExpression) {
		if (newUnionExpression != unionExpression) {
			NotificationChain msgs = null;
			if (unionExpression != null)
				msgs = ((InternalEObject)unionExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MscriptPackage.INSPECT_EXPRESSION__UNION_EXPRESSION, null, msgs);
			if (newUnionExpression != null)
				msgs = ((InternalEObject)newUnionExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MscriptPackage.INSPECT_EXPRESSION__UNION_EXPRESSION, null, msgs);
			msgs = basicSetUnionExpression(newUnionExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MscriptPackage.INSPECT_EXPRESSION__UNION_EXPRESSION, newUnionExpression, newUnionExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InspectWhenClause> getWhenClauses() {
		if (whenClauses == null) {
			whenClauses = new EObjectContainmentWithInverseEList<InspectWhenClause>(InspectWhenClause.class, this, MscriptPackage.INSPECT_EXPRESSION__WHEN_CLAUSES, MscriptPackage.INSPECT_WHEN_CLAUSE__OWNER);
		}
		return whenClauses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MscriptPackage.INSPECT_EXPRESSION__WHEN_CLAUSES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getWhenClauses()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MscriptPackage.INSPECT_EXPRESSION__UNION_EXPRESSION:
				return basicSetUnionExpression(null, msgs);
			case MscriptPackage.INSPECT_EXPRESSION__WHEN_CLAUSES:
				return ((InternalEList<?>)getWhenClauses()).basicRemove(otherEnd, msgs);
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
			case MscriptPackage.INSPECT_EXPRESSION__UNION_EXPRESSION:
				return getUnionExpression();
			case MscriptPackage.INSPECT_EXPRESSION__WHEN_CLAUSES:
				return getWhenClauses();
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
			case MscriptPackage.INSPECT_EXPRESSION__UNION_EXPRESSION:
				setUnionExpression((Expression)newValue);
				return;
			case MscriptPackage.INSPECT_EXPRESSION__WHEN_CLAUSES:
				getWhenClauses().clear();
				getWhenClauses().addAll((Collection<? extends InspectWhenClause>)newValue);
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
			case MscriptPackage.INSPECT_EXPRESSION__UNION_EXPRESSION:
				setUnionExpression((Expression)null);
				return;
			case MscriptPackage.INSPECT_EXPRESSION__WHEN_CLAUSES:
				getWhenClauses().clear();
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
			case MscriptPackage.INSPECT_EXPRESSION__UNION_EXPRESSION:
				return unionExpression != null;
			case MscriptPackage.INSPECT_EXPRESSION__WHEN_CLAUSES:
				return whenClauses != null && !whenClauses.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	public <R, C> R accept(C context, IExpressionVisitor<R, C> visitor) {
		return visitor.visit(context, this);
	}

} //WhenExpressionImpl
