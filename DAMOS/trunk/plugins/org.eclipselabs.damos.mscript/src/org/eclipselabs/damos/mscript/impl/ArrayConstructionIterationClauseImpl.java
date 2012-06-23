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
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipselabs.damos.mscript.ArrayConstructionIterationClause;
import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.IterationVariableDeclaration;
import org.eclipselabs.damos.mscript.MscriptPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Array Construction Iteration Clause</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.mscript.impl.ArrayConstructionIterationClauseImpl#getIterationVariable <em>Iteration Variable</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.impl.ArrayConstructionIterationClauseImpl#getCollectionExpression <em>Collection Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ArrayConstructionIterationClauseImpl extends MinimalEObjectImpl.Container implements ArrayConstructionIterationClause {
	/**
	 * The cached value of the '{@link #getIterationVariable() <em>Iteration Variable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIterationVariable()
	 * @generated
	 * @ordered
	 */
	protected IterationVariableDeclaration iterationVariable;

	/**
	 * The cached value of the '{@link #getCollectionExpression() <em>Collection Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCollectionExpression()
	 * @generated
	 * @ordered
	 */
	protected Expression collectionExpression;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ArrayConstructionIterationClauseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MscriptPackage.Literals.ARRAY_CONSTRUCTION_ITERATION_CLAUSE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IterationVariableDeclaration getIterationVariable() {
		return iterationVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIterationVariable(IterationVariableDeclaration newIterationVariable, NotificationChain msgs) {
		IterationVariableDeclaration oldIterationVariable = iterationVariable;
		iterationVariable = newIterationVariable;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MscriptPackage.ARRAY_CONSTRUCTION_ITERATION_CLAUSE__ITERATION_VARIABLE, oldIterationVariable, newIterationVariable);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIterationVariable(IterationVariableDeclaration newIterationVariable) {
		if (newIterationVariable != iterationVariable) {
			NotificationChain msgs = null;
			if (iterationVariable != null)
				msgs = ((InternalEObject)iterationVariable).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MscriptPackage.ARRAY_CONSTRUCTION_ITERATION_CLAUSE__ITERATION_VARIABLE, null, msgs);
			if (newIterationVariable != null)
				msgs = ((InternalEObject)newIterationVariable).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MscriptPackage.ARRAY_CONSTRUCTION_ITERATION_CLAUSE__ITERATION_VARIABLE, null, msgs);
			msgs = basicSetIterationVariable(newIterationVariable, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MscriptPackage.ARRAY_CONSTRUCTION_ITERATION_CLAUSE__ITERATION_VARIABLE, newIterationVariable, newIterationVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getCollectionExpression() {
		return collectionExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCollectionExpression(Expression newCollectionExpression, NotificationChain msgs) {
		Expression oldCollectionExpression = collectionExpression;
		collectionExpression = newCollectionExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MscriptPackage.ARRAY_CONSTRUCTION_ITERATION_CLAUSE__COLLECTION_EXPRESSION, oldCollectionExpression, newCollectionExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCollectionExpression(Expression newCollectionExpression) {
		if (newCollectionExpression != collectionExpression) {
			NotificationChain msgs = null;
			if (collectionExpression != null)
				msgs = ((InternalEObject)collectionExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MscriptPackage.ARRAY_CONSTRUCTION_ITERATION_CLAUSE__COLLECTION_EXPRESSION, null, msgs);
			if (newCollectionExpression != null)
				msgs = ((InternalEObject)newCollectionExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MscriptPackage.ARRAY_CONSTRUCTION_ITERATION_CLAUSE__COLLECTION_EXPRESSION, null, msgs);
			msgs = basicSetCollectionExpression(newCollectionExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MscriptPackage.ARRAY_CONSTRUCTION_ITERATION_CLAUSE__COLLECTION_EXPRESSION, newCollectionExpression, newCollectionExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MscriptPackage.ARRAY_CONSTRUCTION_ITERATION_CLAUSE__ITERATION_VARIABLE:
				return basicSetIterationVariable(null, msgs);
			case MscriptPackage.ARRAY_CONSTRUCTION_ITERATION_CLAUSE__COLLECTION_EXPRESSION:
				return basicSetCollectionExpression(null, msgs);
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
			case MscriptPackage.ARRAY_CONSTRUCTION_ITERATION_CLAUSE__ITERATION_VARIABLE:
				return getIterationVariable();
			case MscriptPackage.ARRAY_CONSTRUCTION_ITERATION_CLAUSE__COLLECTION_EXPRESSION:
				return getCollectionExpression();
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
			case MscriptPackage.ARRAY_CONSTRUCTION_ITERATION_CLAUSE__ITERATION_VARIABLE:
				setIterationVariable((IterationVariableDeclaration)newValue);
				return;
			case MscriptPackage.ARRAY_CONSTRUCTION_ITERATION_CLAUSE__COLLECTION_EXPRESSION:
				setCollectionExpression((Expression)newValue);
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
			case MscriptPackage.ARRAY_CONSTRUCTION_ITERATION_CLAUSE__ITERATION_VARIABLE:
				setIterationVariable((IterationVariableDeclaration)null);
				return;
			case MscriptPackage.ARRAY_CONSTRUCTION_ITERATION_CLAUSE__COLLECTION_EXPRESSION:
				setCollectionExpression((Expression)null);
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
			case MscriptPackage.ARRAY_CONSTRUCTION_ITERATION_CLAUSE__ITERATION_VARIABLE:
				return iterationVariable != null;
			case MscriptPackage.ARRAY_CONSTRUCTION_ITERATION_CLAUSE__COLLECTION_EXPRESSION:
				return collectionExpression != null;
		}
		return super.eIsSet(featureID);
	}

} //ArrayConstructionIterationClauseImpl
