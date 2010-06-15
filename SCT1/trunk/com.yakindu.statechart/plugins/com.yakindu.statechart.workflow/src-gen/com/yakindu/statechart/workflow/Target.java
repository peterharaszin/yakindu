/**
 * <copyright>
 * </copyright>
 *

 */
package com.yakindu.statechart.workflow;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Target</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.yakindu.statechart.workflow.Target#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.yakindu.statechart.workflow.WorkflowPackage#getTarget()
 * @model
 * @generated
 */
public interface Target extends EObject
{
  /**
   * Returns the value of the '<em><b>Target</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Target</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Target</em>' attribute.
   * @see #setTarget(String)
   * @see com.yakindu.statechart.workflow.WorkflowPackage#getTarget_Target()
   * @model
   * @generated
   */
  String getTarget();

  /**
   * Sets the value of the '{@link com.yakindu.statechart.workflow.Target#getTarget <em>Target</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target</em>' attribute.
   * @see #getTarget()
   * @generated
   */
  void setTarget(String value);

} // Target
