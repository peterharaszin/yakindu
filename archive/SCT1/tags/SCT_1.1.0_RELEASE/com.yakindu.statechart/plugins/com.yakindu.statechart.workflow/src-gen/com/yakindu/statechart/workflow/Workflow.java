/**
 * <copyright>
 * </copyright>
 *

 */
package com.yakindu.statechart.workflow;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Workflow</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.yakindu.statechart.workflow.Workflow#getModels <em>Models</em>}</li>
 *   <li>{@link com.yakindu.statechart.workflow.Workflow#getTarget <em>Target</em>}</li>
 *   <li>{@link com.yakindu.statechart.workflow.Workflow#getPlatform <em>Platform</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.yakindu.statechart.workflow.WorkflowPackage#getWorkflow()
 * @model
 * @generated
 */
public interface Workflow extends EObject
{
  /**
   * Returns the value of the '<em><b>Models</b></em>' containment reference list.
   * The list contents are of type {@link com.yakindu.statechart.workflow.Model}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Models</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Models</em>' containment reference list.
   * @see com.yakindu.statechart.workflow.WorkflowPackage#getWorkflow_Models()
   * @model containment="true"
   * @generated
   */
  EList<Model> getModels();

  /**
   * Returns the value of the '<em><b>Target</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Target</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Target</em>' containment reference.
   * @see #setTarget(Target)
   * @see com.yakindu.statechart.workflow.WorkflowPackage#getWorkflow_Target()
   * @model containment="true"
   * @generated
   */
  Target getTarget();

  /**
   * Sets the value of the '{@link com.yakindu.statechart.workflow.Workflow#getTarget <em>Target</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target</em>' containment reference.
   * @see #getTarget()
   * @generated
   */
  void setTarget(Target value);

  /**
   * Returns the value of the '<em><b>Platform</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Platform</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Platform</em>' containment reference.
   * @see #setPlatform(TargetPlatform)
   * @see com.yakindu.statechart.workflow.WorkflowPackage#getWorkflow_Platform()
   * @model containment="true"
   * @generated
   */
  TargetPlatform getPlatform();

  /**
   * Sets the value of the '{@link com.yakindu.statechart.workflow.Workflow#getPlatform <em>Platform</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Platform</em>' containment reference.
   * @see #getPlatform()
   * @generated
   */
  void setPlatform(TargetPlatform value);

} // Workflow
