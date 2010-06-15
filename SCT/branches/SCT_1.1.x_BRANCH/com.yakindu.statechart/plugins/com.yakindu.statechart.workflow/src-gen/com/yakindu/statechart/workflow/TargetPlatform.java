/**
 * <copyright>
 * </copyright>
 *

 */
package com.yakindu.statechart.workflow;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Target Platform</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.yakindu.statechart.workflow.TargetPlatform#getTargetplatform <em>Targetplatform</em>}</li>
 *   <li>{@link com.yakindu.statechart.workflow.TargetPlatform#isDefensive <em>Defensive</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.yakindu.statechart.workflow.WorkflowPackage#getTargetPlatform()
 * @model
 * @generated
 */
public interface TargetPlatform extends EObject
{
  /**
   * Returns the value of the '<em><b>Targetplatform</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Targetplatform</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Targetplatform</em>' attribute.
   * @see #setTargetplatform(String)
   * @see com.yakindu.statechart.workflow.WorkflowPackage#getTargetPlatform_Targetplatform()
   * @model
   * @generated
   */
  String getTargetplatform();

  /**
   * Sets the value of the '{@link com.yakindu.statechart.workflow.TargetPlatform#getTargetplatform <em>Targetplatform</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Targetplatform</em>' attribute.
   * @see #getTargetplatform()
   * @generated
   */
  void setTargetplatform(String value);

  /**
   * Returns the value of the '<em><b>Defensive</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Defensive</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Defensive</em>' attribute.
   * @see #setDefensive(boolean)
   * @see com.yakindu.statechart.workflow.WorkflowPackage#getTargetPlatform_Defensive()
   * @model
   * @generated
   */
  boolean isDefensive();

  /**
   * Sets the value of the '{@link com.yakindu.statechart.workflow.TargetPlatform#isDefensive <em>Defensive</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Defensive</em>' attribute.
   * @see #isDefensive()
   * @generated
   */
  void setDefensive(boolean value);

} // TargetPlatform
