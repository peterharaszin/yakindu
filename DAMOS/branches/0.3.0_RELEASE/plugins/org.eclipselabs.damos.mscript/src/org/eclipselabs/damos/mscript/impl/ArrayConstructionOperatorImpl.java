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
import org.eclipselabs.damos.mscript.ArrayConstructionIterationClause;
import org.eclipselabs.damos.mscript.ArrayConstructionOperator;
import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.MscriptPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Array Construction Operator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.mscript.impl.ArrayConstructionOperatorImpl#getExpressions <em>Expressions</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.impl.ArrayConstructionOperatorImpl#getIterationClauses <em>Iteration Clauses</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ArrayConstructionOperatorImpl extends ExpressionImpl implements ArrayConstructionOperator {
	/**
	 * The cached value of the '{@link #getExpressions() <em>Expressions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpressions()
	 * @generated
	 * @ordered
	 */
	protected EList<Expression> expressions;

	/**
	 * The cached value of the '{@link #getIterationClauses() <em>Iteration Clauses</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIterationClauses()
	 * @generated
	 * @ordered
	 */
	protected EList<ArrayConstructionIterationClause> iterationClauses;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ArrayConstructionOperatorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MscriptPackage.Literals.ARRAY_CONSTRUCTION_OPERATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Expression> getExpressions() {
		if (expressions == null) {
			expressions = new EObjectContainmentEList<Expression>(Expression.class, this, MscriptPackage.ARRAY_CONSTRUCTION_OPERATOR__EXPRESSIONS);
		}
		return expressions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ArrayConstructionIterationClause> getIterationClauses() {
		if (iterationClauses == null) {
			iterationClauses = new EObjectContainmentEList<ArrayConstructionIterationClause>(ArrayConstructionIterationClause.class, this, MscriptPackage.ARRAY_CONSTRUCTION_OPERATOR__ITERATION_CLAUSES);
		}
		return iterationClauses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MscriptPackage.ARRAY_CONSTRUCTION_OPERATOR__EXPRESSIONS:
				return ((InternalEList<?>)getExpressions()).basicRemove(otherEnd, msgs);
			case MscriptPackage.ARRAY_CONSTRUCTION_OPERATOR__ITERATION_CLAUSES:
				return ((InternalEList<?>)getIterationClauses()).basicRemove(otherEnd, msgs);
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
			case MscriptPackage.ARRAY_CONSTRUCTION_OPERATOR__EXPRESSIONS:
				return getExpressions();
			case MscriptPackage.ARRAY_CONSTRUCTION_OPERATOR__ITERATION_CLAUSES:
				return getIterationClauses();
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
			case MscriptPackage.ARRAY_CONSTRUCTION_OPERATOR__EXPRESSIONS:
				getExpressions().clear();
				getExpressions().addAll((Collection<? extends Expression>)newValue);
				return;
			case MscriptPackage.ARRAY_CONSTRUCTION_OPERATOR__ITERATION_CLAUSES:
				getIterationClauses().clear();
				getIterationClauses().addAll((Collection<? extends ArrayConstructionIterationClause>)newValue);
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
			case MscriptPackage.ARRAY_CONSTRUCTION_OPERATOR__EXPRESSIONS:
				getExpressions().clear();
				return;
			case MscriptPackage.ARRAY_CONSTRUCTION_OPERATOR__ITERATION_CLAUSES:
				getIterationClauses().clear();
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
			case MscriptPackage.ARRAY_CONSTRUCTION_OPERATOR__EXPRESSIONS:
				return expressions != null && !expressions.isEmpty();
			case MscriptPackage.ARRAY_CONSTRUCTION_OPERATOR__ITERATION_CLAUSES:
				return iterationClauses != null && !iterationClauses.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ArrayConstructionOperatorImpl
