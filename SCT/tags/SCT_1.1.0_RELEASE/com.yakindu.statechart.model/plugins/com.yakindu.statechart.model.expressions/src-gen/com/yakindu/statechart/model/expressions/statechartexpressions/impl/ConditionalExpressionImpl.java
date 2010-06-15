/**
 * Copyright (c) 2010 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package com.yakindu.statechart.model.expressions.statechartexpressions.impl;

import com.yakindu.statechart.model.expressions.statechartexpressions.BooleanOrExpression;
import com.yakindu.statechart.model.expressions.statechartexpressions.ConditionalExpression;
import com.yakindu.statechart.model.expressions.statechartexpressions.ShiftExpression;
import com.yakindu.statechart.model.expressions.statechartexpressions.StatechartexpressionsPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Conditional Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.yakindu.statechart.model.expressions.statechartexpressions.impl.ConditionalExpressionImpl#getOperand1 <em>Operand1</em>}</li>
 *   <li>{@link com.yakindu.statechart.model.expressions.statechartexpressions.impl.ConditionalExpressionImpl#getOperand2 <em>Operand2</em>}</li>
 *   <li>{@link com.yakindu.statechart.model.expressions.statechartexpressions.impl.ConditionalExpressionImpl#getOperand3 <em>Operand3</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConditionalExpressionImpl extends MinimalEObjectImpl.Container implements ConditionalExpression
{
  /**
   * The cached value of the '{@link #getOperand1() <em>Operand1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperand1()
   * @generated
   * @ordered
   */
  protected BooleanOrExpression operand1;

  /**
   * The cached value of the '{@link #getOperand2() <em>Operand2</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperand2()
   * @generated
   * @ordered
   */
  protected ShiftExpression operand2;

  /**
   * The cached value of the '{@link #getOperand3() <em>Operand3</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperand3()
   * @generated
   * @ordered
   */
  protected ShiftExpression operand3;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ConditionalExpressionImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return StatechartexpressionsPackage.Literals.CONDITIONAL_EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BooleanOrExpression getOperand1()
  {
    return operand1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOperand1(BooleanOrExpression newOperand1, NotificationChain msgs)
  {
    BooleanOrExpression oldOperand1 = operand1;
    operand1 = newOperand1;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StatechartexpressionsPackage.CONDITIONAL_EXPRESSION__OPERAND1, oldOperand1, newOperand1);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOperand1(BooleanOrExpression newOperand1)
  {
    if (newOperand1 != operand1)
    {
      NotificationChain msgs = null;
      if (operand1 != null)
        msgs = ((InternalEObject)operand1).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StatechartexpressionsPackage.CONDITIONAL_EXPRESSION__OPERAND1, null, msgs);
      if (newOperand1 != null)
        msgs = ((InternalEObject)newOperand1).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StatechartexpressionsPackage.CONDITIONAL_EXPRESSION__OPERAND1, null, msgs);
      msgs = basicSetOperand1(newOperand1, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, StatechartexpressionsPackage.CONDITIONAL_EXPRESSION__OPERAND1, newOperand1, newOperand1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ShiftExpression getOperand2()
  {
    return operand2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOperand2(ShiftExpression newOperand2, NotificationChain msgs)
  {
    ShiftExpression oldOperand2 = operand2;
    operand2 = newOperand2;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StatechartexpressionsPackage.CONDITIONAL_EXPRESSION__OPERAND2, oldOperand2, newOperand2);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOperand2(ShiftExpression newOperand2)
  {
    if (newOperand2 != operand2)
    {
      NotificationChain msgs = null;
      if (operand2 != null)
        msgs = ((InternalEObject)operand2).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StatechartexpressionsPackage.CONDITIONAL_EXPRESSION__OPERAND2, null, msgs);
      if (newOperand2 != null)
        msgs = ((InternalEObject)newOperand2).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StatechartexpressionsPackage.CONDITIONAL_EXPRESSION__OPERAND2, null, msgs);
      msgs = basicSetOperand2(newOperand2, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, StatechartexpressionsPackage.CONDITIONAL_EXPRESSION__OPERAND2, newOperand2, newOperand2));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ShiftExpression getOperand3()
  {
    return operand3;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOperand3(ShiftExpression newOperand3, NotificationChain msgs)
  {
    ShiftExpression oldOperand3 = operand3;
    operand3 = newOperand3;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StatechartexpressionsPackage.CONDITIONAL_EXPRESSION__OPERAND3, oldOperand3, newOperand3);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOperand3(ShiftExpression newOperand3)
  {
    if (newOperand3 != operand3)
    {
      NotificationChain msgs = null;
      if (operand3 != null)
        msgs = ((InternalEObject)operand3).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StatechartexpressionsPackage.CONDITIONAL_EXPRESSION__OPERAND3, null, msgs);
      if (newOperand3 != null)
        msgs = ((InternalEObject)newOperand3).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StatechartexpressionsPackage.CONDITIONAL_EXPRESSION__OPERAND3, null, msgs);
      msgs = basicSetOperand3(newOperand3, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, StatechartexpressionsPackage.CONDITIONAL_EXPRESSION__OPERAND3, newOperand3, newOperand3));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case StatechartexpressionsPackage.CONDITIONAL_EXPRESSION__OPERAND1:
        return basicSetOperand1(null, msgs);
      case StatechartexpressionsPackage.CONDITIONAL_EXPRESSION__OPERAND2:
        return basicSetOperand2(null, msgs);
      case StatechartexpressionsPackage.CONDITIONAL_EXPRESSION__OPERAND3:
        return basicSetOperand3(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case StatechartexpressionsPackage.CONDITIONAL_EXPRESSION__OPERAND1:
        return getOperand1();
      case StatechartexpressionsPackage.CONDITIONAL_EXPRESSION__OPERAND2:
        return getOperand2();
      case StatechartexpressionsPackage.CONDITIONAL_EXPRESSION__OPERAND3:
        return getOperand3();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case StatechartexpressionsPackage.CONDITIONAL_EXPRESSION__OPERAND1:
        setOperand1((BooleanOrExpression)newValue);
        return;
      case StatechartexpressionsPackage.CONDITIONAL_EXPRESSION__OPERAND2:
        setOperand2((ShiftExpression)newValue);
        return;
      case StatechartexpressionsPackage.CONDITIONAL_EXPRESSION__OPERAND3:
        setOperand3((ShiftExpression)newValue);
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
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case StatechartexpressionsPackage.CONDITIONAL_EXPRESSION__OPERAND1:
        setOperand1((BooleanOrExpression)null);
        return;
      case StatechartexpressionsPackage.CONDITIONAL_EXPRESSION__OPERAND2:
        setOperand2((ShiftExpression)null);
        return;
      case StatechartexpressionsPackage.CONDITIONAL_EXPRESSION__OPERAND3:
        setOperand3((ShiftExpression)null);
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
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case StatechartexpressionsPackage.CONDITIONAL_EXPRESSION__OPERAND1:
        return operand1 != null;
      case StatechartexpressionsPackage.CONDITIONAL_EXPRESSION__OPERAND2:
        return operand2 != null;
      case StatechartexpressionsPackage.CONDITIONAL_EXPRESSION__OPERAND3:
        return operand3 != null;
    }
    return super.eIsSet(featureID);
  }

} //ConditionalExpressionImpl
