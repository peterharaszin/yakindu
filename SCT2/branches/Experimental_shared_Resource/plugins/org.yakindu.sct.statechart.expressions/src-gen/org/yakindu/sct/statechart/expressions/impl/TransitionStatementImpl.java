/**
 * <copyright>
 * </copyright>
 *

 */
package org.yakindu.sct.statechart.expressions.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.yakindu.model.sct.statechart.Reaction;

import org.yakindu.sct.statechart.expressions.ExpressionsPackage;
import org.yakindu.sct.statechart.expressions.TransitionStatement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transition Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.yakindu.sct.statechart.expressions.impl.TransitionStatementImpl#getReaction <em>Reaction</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TransitionStatementImpl extends MinimalEObjectImpl.Container implements TransitionStatement
{
  /**
   * The cached value of the '{@link #getReaction() <em>Reaction</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReaction()
   * @generated
   * @ordered
   */
  protected Reaction reaction;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TransitionStatementImpl()
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
    return ExpressionsPackage.Literals.TRANSITION_STATEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Reaction getReaction()
  {
    return reaction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetReaction(Reaction newReaction, NotificationChain msgs)
  {
    Reaction oldReaction = reaction;
    reaction = newReaction;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionsPackage.TRANSITION_STATEMENT__REACTION, oldReaction, newReaction);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setReaction(Reaction newReaction)
  {
    if (newReaction != reaction)
    {
      NotificationChain msgs = null;
      if (reaction != null)
        msgs = ((InternalEObject)reaction).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.TRANSITION_STATEMENT__REACTION, null, msgs);
      if (newReaction != null)
        msgs = ((InternalEObject)newReaction).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.TRANSITION_STATEMENT__REACTION, null, msgs);
      msgs = basicSetReaction(newReaction, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.TRANSITION_STATEMENT__REACTION, newReaction, newReaction));
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
      case ExpressionsPackage.TRANSITION_STATEMENT__REACTION:
        return basicSetReaction(null, msgs);
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
      case ExpressionsPackage.TRANSITION_STATEMENT__REACTION:
        return getReaction();
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
      case ExpressionsPackage.TRANSITION_STATEMENT__REACTION:
        setReaction((Reaction)newValue);
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
      case ExpressionsPackage.TRANSITION_STATEMENT__REACTION:
        setReaction((Reaction)null);
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
      case ExpressionsPackage.TRANSITION_STATEMENT__REACTION:
        return reaction != null;
    }
    return super.eIsSet(featureID);
  }

} //TransitionStatementImpl
