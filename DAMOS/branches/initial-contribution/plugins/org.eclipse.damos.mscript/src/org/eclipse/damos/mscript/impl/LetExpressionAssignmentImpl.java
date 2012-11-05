/*******************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Andreas Unger - initial API and implementation
 *******************************************************************************/
package org.eclipse.damos.mscript.impl;

import java.util.Collection;

import org.eclipse.damos.mscript.Expression;
import org.eclipse.damos.mscript.LetExpressionAssignment;
import org.eclipse.damos.mscript.LetExpressionVariableDeclaration;
import org.eclipse.damos.mscript.MscriptPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Let Expression Variable Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.damos.mscript.impl.LetExpressionAssignmentImpl#getVariables <em>Variables</em>}</li>
 *   <li>{@link org.eclipse.damos.mscript.impl.LetExpressionAssignmentImpl#getAssignedExpression <em>Assigned Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LetExpressionAssignmentImpl extends MinimalEObjectImpl.Container implements LetExpressionAssignment {
	/**
	 * The cached value of the '{@link #getVariables() <em>Variables</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariables()
	 * @generated
	 * @ordered
	 */
	protected EList<LetExpressionVariableDeclaration> variables;

	/**
	 * The cached value of the '{@link #getAssignedExpression() <em>Assigned Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssignedExpression()
	 * @generated
	 * @ordered
	 */
	protected Expression assignedExpression;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LetExpressionAssignmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MscriptPackage.Literals.LET_EXPRESSION_ASSIGNMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LetExpressionVariableDeclaration> getVariables() {
		if (variables == null) {
			variables = new EObjectContainmentEList<LetExpressionVariableDeclaration>(LetExpressionVariableDeclaration.class, this, MscriptPackage.LET_EXPRESSION_ASSIGNMENT__VARIABLES);
		}
		return variables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getAssignedExpression() {
		return assignedExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAssignedExpression(Expression newAssignedExpression, NotificationChain msgs) {
		Expression oldAssignedExpression = assignedExpression;
		assignedExpression = newAssignedExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MscriptPackage.LET_EXPRESSION_ASSIGNMENT__ASSIGNED_EXPRESSION, oldAssignedExpression, newAssignedExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAssignedExpression(Expression newAssignedExpression) {
		if (newAssignedExpression != assignedExpression) {
			NotificationChain msgs = null;
			if (assignedExpression != null)
				msgs = ((InternalEObject)assignedExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MscriptPackage.LET_EXPRESSION_ASSIGNMENT__ASSIGNED_EXPRESSION, null, msgs);
			if (newAssignedExpression != null)
				msgs = ((InternalEObject)newAssignedExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MscriptPackage.LET_EXPRESSION_ASSIGNMENT__ASSIGNED_EXPRESSION, null, msgs);
			msgs = basicSetAssignedExpression(newAssignedExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MscriptPackage.LET_EXPRESSION_ASSIGNMENT__ASSIGNED_EXPRESSION, newAssignedExpression, newAssignedExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MscriptPackage.LET_EXPRESSION_ASSIGNMENT__VARIABLES:
				return ((InternalEList<?>)getVariables()).basicRemove(otherEnd, msgs);
			case MscriptPackage.LET_EXPRESSION_ASSIGNMENT__ASSIGNED_EXPRESSION:
				return basicSetAssignedExpression(null, msgs);
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
			case MscriptPackage.LET_EXPRESSION_ASSIGNMENT__VARIABLES:
				return getVariables();
			case MscriptPackage.LET_EXPRESSION_ASSIGNMENT__ASSIGNED_EXPRESSION:
				return getAssignedExpression();
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
			case MscriptPackage.LET_EXPRESSION_ASSIGNMENT__VARIABLES:
				getVariables().clear();
				getVariables().addAll((Collection<? extends LetExpressionVariableDeclaration>)newValue);
				return;
			case MscriptPackage.LET_EXPRESSION_ASSIGNMENT__ASSIGNED_EXPRESSION:
				setAssignedExpression((Expression)newValue);
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
			case MscriptPackage.LET_EXPRESSION_ASSIGNMENT__VARIABLES:
				getVariables().clear();
				return;
			case MscriptPackage.LET_EXPRESSION_ASSIGNMENT__ASSIGNED_EXPRESSION:
				setAssignedExpression((Expression)null);
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
			case MscriptPackage.LET_EXPRESSION_ASSIGNMENT__VARIABLES:
				return variables != null && !variables.isEmpty();
			case MscriptPackage.LET_EXPRESSION_ASSIGNMENT__ASSIGNED_EXPRESSION:
				return assignedExpression != null;
		}
		return super.eIsSet(featureID);
	}

} //LetExpressionVariableDeclarationImpl
