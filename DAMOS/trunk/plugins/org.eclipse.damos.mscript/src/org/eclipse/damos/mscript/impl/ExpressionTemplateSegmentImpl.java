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
/**
 */
package org.eclipse.damos.mscript.impl;

import org.eclipse.damos.mscript.Expression;
import org.eclipse.damos.mscript.ExpressionTemplateSegment;
import org.eclipse.damos.mscript.MscriptPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Expression Template Segment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.damos.mscript.impl.ExpressionTemplateSegmentImpl#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.eclipse.damos.mscript.impl.ExpressionTemplateSegmentImpl#getIndentation <em>Indentation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExpressionTemplateSegmentImpl extends TemplateSegmentImpl implements ExpressionTemplateSegment {
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
	 * The default value of the '{@link #getIndentation() <em>Indentation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndentation()
	 * @generated
	 * @ordered
	 */
	protected static final String INDENTATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIndentation() <em>Indentation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndentation()
	 * @generated
	 * @ordered
	 */
	protected String indentation = INDENTATION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExpressionTemplateSegmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MscriptPackage.Literals.EXPRESSION_TEMPLATE_SEGMENT;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MscriptPackage.EXPRESSION_TEMPLATE_SEGMENT__EXPRESSION, oldExpression, newExpression);
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
				msgs = ((InternalEObject)expression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MscriptPackage.EXPRESSION_TEMPLATE_SEGMENT__EXPRESSION, null, msgs);
			if (newExpression != null)
				msgs = ((InternalEObject)newExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MscriptPackage.EXPRESSION_TEMPLATE_SEGMENT__EXPRESSION, null, msgs);
			msgs = basicSetExpression(newExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MscriptPackage.EXPRESSION_TEMPLATE_SEGMENT__EXPRESSION, newExpression, newExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIndentation() {
		return indentation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIndentation(String newIndentation) {
		String oldIndentation = indentation;
		indentation = newIndentation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MscriptPackage.EXPRESSION_TEMPLATE_SEGMENT__INDENTATION, oldIndentation, indentation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MscriptPackage.EXPRESSION_TEMPLATE_SEGMENT__EXPRESSION:
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
			case MscriptPackage.EXPRESSION_TEMPLATE_SEGMENT__EXPRESSION:
				return getExpression();
			case MscriptPackage.EXPRESSION_TEMPLATE_SEGMENT__INDENTATION:
				return getIndentation();
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
			case MscriptPackage.EXPRESSION_TEMPLATE_SEGMENT__EXPRESSION:
				setExpression((Expression)newValue);
				return;
			case MscriptPackage.EXPRESSION_TEMPLATE_SEGMENT__INDENTATION:
				setIndentation((String)newValue);
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
			case MscriptPackage.EXPRESSION_TEMPLATE_SEGMENT__EXPRESSION:
				setExpression((Expression)null);
				return;
			case MscriptPackage.EXPRESSION_TEMPLATE_SEGMENT__INDENTATION:
				setIndentation(INDENTATION_EDEFAULT);
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
			case MscriptPackage.EXPRESSION_TEMPLATE_SEGMENT__EXPRESSION:
				return expression != null;
			case MscriptPackage.EXPRESSION_TEMPLATE_SEGMENT__INDENTATION:
				return INDENTATION_EDEFAULT == null ? indentation != null : !INDENTATION_EDEFAULT.equals(indentation);
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
		result.append(" (indentation: ");
		result.append(indentation);
		result.append(')');
		return result.toString();
	}

} //ExpressionTemplateSegmentImpl
