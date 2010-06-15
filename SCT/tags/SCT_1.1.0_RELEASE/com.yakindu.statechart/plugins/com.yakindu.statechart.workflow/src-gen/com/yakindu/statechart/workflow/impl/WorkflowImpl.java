/**
 * <copyright>
 * </copyright>
 *

 */
package com.yakindu.statechart.workflow.impl;

import com.yakindu.statechart.workflow.Model;
import com.yakindu.statechart.workflow.Target;
import com.yakindu.statechart.workflow.TargetPlatform;
import com.yakindu.statechart.workflow.Workflow;
import com.yakindu.statechart.workflow.WorkflowPackage;

import java.util.Collection;

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
 * An implementation of the model object '<em><b>Workflow</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.yakindu.statechart.workflow.impl.WorkflowImpl#getModels <em>Models</em>}</li>
 *   <li>{@link com.yakindu.statechart.workflow.impl.WorkflowImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link com.yakindu.statechart.workflow.impl.WorkflowImpl#getPlatform <em>Platform</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WorkflowImpl extends MinimalEObjectImpl.Container implements Workflow
{
  /**
   * The cached value of the '{@link #getModels() <em>Models</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getModels()
   * @generated
   * @ordered
   */
  protected EList<Model> models;

  /**
   * The cached value of the '{@link #getTarget() <em>Target</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTarget()
   * @generated
   * @ordered
   */
  protected Target target;

  /**
   * The cached value of the '{@link #getPlatform() <em>Platform</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPlatform()
   * @generated
   * @ordered
   */
  protected TargetPlatform platform;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected WorkflowImpl()
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
    return WorkflowPackage.Literals.WORKFLOW;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Model> getModels()
  {
    if (models == null)
    {
      models = new EObjectContainmentEList<Model>(Model.class, this, WorkflowPackage.WORKFLOW__MODELS);
    }
    return models;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Target getTarget()
  {
    return target;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTarget(Target newTarget, NotificationChain msgs)
  {
    Target oldTarget = target;
    target = newTarget;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WorkflowPackage.WORKFLOW__TARGET, oldTarget, newTarget);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTarget(Target newTarget)
  {
    if (newTarget != target)
    {
      NotificationChain msgs = null;
      if (target != null)
        msgs = ((InternalEObject)target).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - WorkflowPackage.WORKFLOW__TARGET, null, msgs);
      if (newTarget != null)
        msgs = ((InternalEObject)newTarget).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - WorkflowPackage.WORKFLOW__TARGET, null, msgs);
      msgs = basicSetTarget(newTarget, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.WORKFLOW__TARGET, newTarget, newTarget));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TargetPlatform getPlatform()
  {
    return platform;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPlatform(TargetPlatform newPlatform, NotificationChain msgs)
  {
    TargetPlatform oldPlatform = platform;
    platform = newPlatform;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WorkflowPackage.WORKFLOW__PLATFORM, oldPlatform, newPlatform);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPlatform(TargetPlatform newPlatform)
  {
    if (newPlatform != platform)
    {
      NotificationChain msgs = null;
      if (platform != null)
        msgs = ((InternalEObject)platform).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - WorkflowPackage.WORKFLOW__PLATFORM, null, msgs);
      if (newPlatform != null)
        msgs = ((InternalEObject)newPlatform).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - WorkflowPackage.WORKFLOW__PLATFORM, null, msgs);
      msgs = basicSetPlatform(newPlatform, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.WORKFLOW__PLATFORM, newPlatform, newPlatform));
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
      case WorkflowPackage.WORKFLOW__MODELS:
        return ((InternalEList<?>)getModels()).basicRemove(otherEnd, msgs);
      case WorkflowPackage.WORKFLOW__TARGET:
        return basicSetTarget(null, msgs);
      case WorkflowPackage.WORKFLOW__PLATFORM:
        return basicSetPlatform(null, msgs);
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
      case WorkflowPackage.WORKFLOW__MODELS:
        return getModels();
      case WorkflowPackage.WORKFLOW__TARGET:
        return getTarget();
      case WorkflowPackage.WORKFLOW__PLATFORM:
        return getPlatform();
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
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case WorkflowPackage.WORKFLOW__MODELS:
        getModels().clear();
        getModels().addAll((Collection<? extends Model>)newValue);
        return;
      case WorkflowPackage.WORKFLOW__TARGET:
        setTarget((Target)newValue);
        return;
      case WorkflowPackage.WORKFLOW__PLATFORM:
        setPlatform((TargetPlatform)newValue);
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
      case WorkflowPackage.WORKFLOW__MODELS:
        getModels().clear();
        return;
      case WorkflowPackage.WORKFLOW__TARGET:
        setTarget((Target)null);
        return;
      case WorkflowPackage.WORKFLOW__PLATFORM:
        setPlatform((TargetPlatform)null);
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
      case WorkflowPackage.WORKFLOW__MODELS:
        return models != null && !models.isEmpty();
      case WorkflowPackage.WORKFLOW__TARGET:
        return target != null;
      case WorkflowPackage.WORKFLOW__PLATFORM:
        return platform != null;
    }
    return super.eIsSet(featureID);
  }

} //WorkflowImpl
