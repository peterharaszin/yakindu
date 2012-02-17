/**
 * <copyright>
 * </copyright>
 *

 */
package org.yakindu.sct.model.stext.stext.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.yakindu.base.types.Feature;

import org.yakindu.sct.model.stext.stext.Expression;
import org.yakindu.sct.model.stext.stext.FeatureCall;
import org.yakindu.sct.model.stext.stext.StextPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Feature Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.stext.stext.impl.FeatureCallImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link org.yakindu.sct.model.stext.stext.impl.FeatureCallImpl#getFeature <em>Feature</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FeatureCallImpl extends ExpressionImpl implements FeatureCall
{
  /**
   * The cached value of the '{@link #getOwner() <em>Owner</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOwner()
   * @generated
   * @ordered
   */
  protected Expression owner;

  /**
   * The cached value of the '{@link #getFeature() <em>Feature</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFeature()
   * @generated
   * @ordered
   */
  protected Feature feature;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FeatureCallImpl()
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
    return StextPackage.Literals.FEATURE_CALL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getOwner()
  {
    return owner;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOwner(Expression newOwner, NotificationChain msgs)
  {
    Expression oldOwner = owner;
    owner = newOwner;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StextPackage.FEATURE_CALL__OWNER, oldOwner, newOwner);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOwner(Expression newOwner)
  {
    if (newOwner != owner)
    {
      NotificationChain msgs = null;
      if (owner != null)
        msgs = ((InternalEObject)owner).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StextPackage.FEATURE_CALL__OWNER, null, msgs);
      if (newOwner != null)
        msgs = ((InternalEObject)newOwner).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StextPackage.FEATURE_CALL__OWNER, null, msgs);
      msgs = basicSetOwner(newOwner, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, StextPackage.FEATURE_CALL__OWNER, newOwner, newOwner));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Feature getFeature()
  {
    if (feature != null && feature.eIsProxy())
    {
      InternalEObject oldFeature = (InternalEObject)feature;
      feature = (Feature)eResolveProxy(oldFeature);
      if (feature != oldFeature)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, StextPackage.FEATURE_CALL__FEATURE, oldFeature, feature));
      }
    }
    return feature;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Feature basicGetFeature()
  {
    return feature;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFeature(Feature newFeature)
  {
    Feature oldFeature = feature;
    feature = newFeature;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, StextPackage.FEATURE_CALL__FEATURE, oldFeature, feature));
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
      case StextPackage.FEATURE_CALL__OWNER:
        return basicSetOwner(null, msgs);
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
      case StextPackage.FEATURE_CALL__OWNER:
        return getOwner();
      case StextPackage.FEATURE_CALL__FEATURE:
        if (resolve) return getFeature();
        return basicGetFeature();
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
      case StextPackage.FEATURE_CALL__OWNER:
        setOwner((Expression)newValue);
        return;
      case StextPackage.FEATURE_CALL__FEATURE:
        setFeature((Feature)newValue);
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
      case StextPackage.FEATURE_CALL__OWNER:
        setOwner((Expression)null);
        return;
      case StextPackage.FEATURE_CALL__FEATURE:
        setFeature((Feature)null);
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
      case StextPackage.FEATURE_CALL__OWNER:
        return owner != null;
      case StextPackage.FEATURE_CALL__FEATURE:
        return feature != null;
    }
    return super.eIsSet(featureID);
  }

} //FeatureCallImpl
