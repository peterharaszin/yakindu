/**
 * <copyright>
 * </copyright>
 *

 */
package com.yakindu.statechart.workflow.impl;

import com.yakindu.statechart.workflow.TargetPlatform;
import com.yakindu.statechart.workflow.WorkflowPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Target Platform</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.yakindu.statechart.workflow.impl.TargetPlatformImpl#getTargetplatform <em>Targetplatform</em>}</li>
 *   <li>{@link com.yakindu.statechart.workflow.impl.TargetPlatformImpl#isDefensive <em>Defensive</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TargetPlatformImpl extends MinimalEObjectImpl.Container implements TargetPlatform
{
  /**
   * The default value of the '{@link #getTargetplatform() <em>Targetplatform</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTargetplatform()
   * @generated
   * @ordered
   */
  protected static final String TARGETPLATFORM_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTargetplatform() <em>Targetplatform</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTargetplatform()
   * @generated
   * @ordered
   */
  protected String targetplatform = TARGETPLATFORM_EDEFAULT;

  /**
   * The default value of the '{@link #isDefensive() <em>Defensive</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isDefensive()
   * @generated
   * @ordered
   */
  protected static final boolean DEFENSIVE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isDefensive() <em>Defensive</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isDefensive()
   * @generated
   * @ordered
   */
  protected boolean defensive = DEFENSIVE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TargetPlatformImpl()
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
    return WorkflowPackage.Literals.TARGET_PLATFORM;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getTargetplatform()
  {
    return targetplatform;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTargetplatform(String newTargetplatform)
  {
    String oldTargetplatform = targetplatform;
    targetplatform = newTargetplatform;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.TARGET_PLATFORM__TARGETPLATFORM, oldTargetplatform, targetplatform));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isDefensive()
  {
    return defensive;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDefensive(boolean newDefensive)
  {
    boolean oldDefensive = defensive;
    defensive = newDefensive;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.TARGET_PLATFORM__DEFENSIVE, oldDefensive, defensive));
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
      case WorkflowPackage.TARGET_PLATFORM__TARGETPLATFORM:
        return getTargetplatform();
      case WorkflowPackage.TARGET_PLATFORM__DEFENSIVE:
        return isDefensive();
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
      case WorkflowPackage.TARGET_PLATFORM__TARGETPLATFORM:
        setTargetplatform((String)newValue);
        return;
      case WorkflowPackage.TARGET_PLATFORM__DEFENSIVE:
        setDefensive((Boolean)newValue);
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
      case WorkflowPackage.TARGET_PLATFORM__TARGETPLATFORM:
        setTargetplatform(TARGETPLATFORM_EDEFAULT);
        return;
      case WorkflowPackage.TARGET_PLATFORM__DEFENSIVE:
        setDefensive(DEFENSIVE_EDEFAULT);
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
      case WorkflowPackage.TARGET_PLATFORM__TARGETPLATFORM:
        return TARGETPLATFORM_EDEFAULT == null ? targetplatform != null : !TARGETPLATFORM_EDEFAULT.equals(targetplatform);
      case WorkflowPackage.TARGET_PLATFORM__DEFENSIVE:
        return defensive != DEFENSIVE_EDEFAULT;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (targetplatform: ");
    result.append(targetplatform);
    result.append(", defensive: ");
    result.append(defensive);
    result.append(')');
    return result.toString();
  }

} //TargetPlatformImpl
