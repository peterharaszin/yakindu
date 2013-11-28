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

import com.yakindu.statechart.model.expressions.statechartexpressions.Procedure;
import com.yakindu.statechart.model.expressions.statechartexpressions.ProcedureCall;
import com.yakindu.statechart.model.expressions.statechartexpressions.StatechartexpressionsPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Procedure Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.yakindu.statechart.model.expressions.statechartexpressions.impl.ProcedureCallImpl#getProcedure <em>Procedure</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProcedureCallImpl extends StatementImpl implements ProcedureCall
{
  /**
   * The cached value of the '{@link #getProcedure() <em>Procedure</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProcedure()
   * @generated
   * @ordered
   */
  protected Procedure procedure;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ProcedureCallImpl()
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
    return StatechartexpressionsPackage.Literals.PROCEDURE_CALL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Procedure getProcedure()
  {
    return procedure;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetProcedure(Procedure newProcedure, NotificationChain msgs)
  {
    Procedure oldProcedure = procedure;
    procedure = newProcedure;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StatechartexpressionsPackage.PROCEDURE_CALL__PROCEDURE, oldProcedure, newProcedure);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setProcedure(Procedure newProcedure)
  {
    if (newProcedure != procedure)
    {
      NotificationChain msgs = null;
      if (procedure != null)
        msgs = ((InternalEObject)procedure).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StatechartexpressionsPackage.PROCEDURE_CALL__PROCEDURE, null, msgs);
      if (newProcedure != null)
        msgs = ((InternalEObject)newProcedure).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StatechartexpressionsPackage.PROCEDURE_CALL__PROCEDURE, null, msgs);
      msgs = basicSetProcedure(newProcedure, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, StatechartexpressionsPackage.PROCEDURE_CALL__PROCEDURE, newProcedure, newProcedure));
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
      case StatechartexpressionsPackage.PROCEDURE_CALL__PROCEDURE:
        return basicSetProcedure(null, msgs);
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
      case StatechartexpressionsPackage.PROCEDURE_CALL__PROCEDURE:
        return getProcedure();
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
      case StatechartexpressionsPackage.PROCEDURE_CALL__PROCEDURE:
        setProcedure((Procedure)newValue);
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
      case StatechartexpressionsPackage.PROCEDURE_CALL__PROCEDURE:
        setProcedure((Procedure)null);
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
      case StatechartexpressionsPackage.PROCEDURE_CALL__PROCEDURE:
        return procedure != null;
    }
    return super.eIsSet(featureID);
  }

} //ProcedureCallImpl
