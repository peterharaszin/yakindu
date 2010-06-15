/**
 * <copyright>
 * </copyright>
 *

 */
package com.yakindu.statechart.workflow;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see com.yakindu.statechart.workflow.WorkflowFactory
 * @model kind="package"
 * @generated
 */
public interface WorkflowPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "workflow";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.yakindu.com/statechart/Workflow";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "workflow";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  WorkflowPackage eINSTANCE = com.yakindu.statechart.workflow.impl.WorkflowPackageImpl.init();

  /**
   * The meta object id for the '{@link com.yakindu.statechart.workflow.impl.WorkflowImpl <em>Workflow</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.yakindu.statechart.workflow.impl.WorkflowImpl
   * @see com.yakindu.statechart.workflow.impl.WorkflowPackageImpl#getWorkflow()
   * @generated
   */
  int WORKFLOW = 0;

  /**
   * The feature id for the '<em><b>Models</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WORKFLOW__MODELS = 0;

  /**
   * The feature id for the '<em><b>Target</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WORKFLOW__TARGET = 1;

  /**
   * The feature id for the '<em><b>Platform</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WORKFLOW__PLATFORM = 2;

  /**
   * The number of structural features of the '<em>Workflow</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WORKFLOW_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link com.yakindu.statechart.workflow.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.yakindu.statechart.workflow.impl.ModelImpl
   * @see com.yakindu.statechart.workflow.impl.WorkflowPackageImpl#getModel()
   * @generated
   */
  int MODEL = 1;

  /**
   * The feature id for the '<em><b>Model</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__MODEL = 0;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link com.yakindu.statechart.workflow.impl.TargetImpl <em>Target</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.yakindu.statechart.workflow.impl.TargetImpl
   * @see com.yakindu.statechart.workflow.impl.WorkflowPackageImpl#getTarget()
   * @generated
   */
  int TARGET = 2;

  /**
   * The feature id for the '<em><b>Target</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TARGET__TARGET = 0;

  /**
   * The number of structural features of the '<em>Target</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TARGET_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link com.yakindu.statechart.workflow.impl.TargetPlatformImpl <em>Target Platform</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.yakindu.statechart.workflow.impl.TargetPlatformImpl
   * @see com.yakindu.statechart.workflow.impl.WorkflowPackageImpl#getTargetPlatform()
   * @generated
   */
  int TARGET_PLATFORM = 3;

  /**
   * The feature id for the '<em><b>Targetplatform</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TARGET_PLATFORM__TARGETPLATFORM = 0;

  /**
   * The feature id for the '<em><b>Defensive</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TARGET_PLATFORM__DEFENSIVE = 1;

  /**
   * The number of structural features of the '<em>Target Platform</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TARGET_PLATFORM_FEATURE_COUNT = 2;


  /**
   * Returns the meta object for class '{@link com.yakindu.statechart.workflow.Workflow <em>Workflow</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Workflow</em>'.
   * @see com.yakindu.statechart.workflow.Workflow
   * @generated
   */
  EClass getWorkflow();

  /**
   * Returns the meta object for the containment reference list '{@link com.yakindu.statechart.workflow.Workflow#getModels <em>Models</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Models</em>'.
   * @see com.yakindu.statechart.workflow.Workflow#getModels()
   * @see #getWorkflow()
   * @generated
   */
  EReference getWorkflow_Models();

  /**
   * Returns the meta object for the containment reference '{@link com.yakindu.statechart.workflow.Workflow#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Target</em>'.
   * @see com.yakindu.statechart.workflow.Workflow#getTarget()
   * @see #getWorkflow()
   * @generated
   */
  EReference getWorkflow_Target();

  /**
   * Returns the meta object for the containment reference '{@link com.yakindu.statechart.workflow.Workflow#getPlatform <em>Platform</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Platform</em>'.
   * @see com.yakindu.statechart.workflow.Workflow#getPlatform()
   * @see #getWorkflow()
   * @generated
   */
  EReference getWorkflow_Platform();

  /**
   * Returns the meta object for class '{@link com.yakindu.statechart.workflow.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see com.yakindu.statechart.workflow.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the attribute '{@link com.yakindu.statechart.workflow.Model#getModel <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Model</em>'.
   * @see com.yakindu.statechart.workflow.Model#getModel()
   * @see #getModel()
   * @generated
   */
  EAttribute getModel_Model();

  /**
   * Returns the meta object for class '{@link com.yakindu.statechart.workflow.Target <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Target</em>'.
   * @see com.yakindu.statechart.workflow.Target
   * @generated
   */
  EClass getTarget();

  /**
   * Returns the meta object for the attribute '{@link com.yakindu.statechart.workflow.Target#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Target</em>'.
   * @see com.yakindu.statechart.workflow.Target#getTarget()
   * @see #getTarget()
   * @generated
   */
  EAttribute getTarget_Target();

  /**
   * Returns the meta object for class '{@link com.yakindu.statechart.workflow.TargetPlatform <em>Target Platform</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Target Platform</em>'.
   * @see com.yakindu.statechart.workflow.TargetPlatform
   * @generated
   */
  EClass getTargetPlatform();

  /**
   * Returns the meta object for the attribute '{@link com.yakindu.statechart.workflow.TargetPlatform#getTargetplatform <em>Targetplatform</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Targetplatform</em>'.
   * @see com.yakindu.statechart.workflow.TargetPlatform#getTargetplatform()
   * @see #getTargetPlatform()
   * @generated
   */
  EAttribute getTargetPlatform_Targetplatform();

  /**
   * Returns the meta object for the attribute '{@link com.yakindu.statechart.workflow.TargetPlatform#isDefensive <em>Defensive</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Defensive</em>'.
   * @see com.yakindu.statechart.workflow.TargetPlatform#isDefensive()
   * @see #getTargetPlatform()
   * @generated
   */
  EAttribute getTargetPlatform_Defensive();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  WorkflowFactory getWorkflowFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link com.yakindu.statechart.workflow.impl.WorkflowImpl <em>Workflow</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.yakindu.statechart.workflow.impl.WorkflowImpl
     * @see com.yakindu.statechart.workflow.impl.WorkflowPackageImpl#getWorkflow()
     * @generated
     */
    EClass WORKFLOW = eINSTANCE.getWorkflow();

    /**
     * The meta object literal for the '<em><b>Models</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference WORKFLOW__MODELS = eINSTANCE.getWorkflow_Models();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference WORKFLOW__TARGET = eINSTANCE.getWorkflow_Target();

    /**
     * The meta object literal for the '<em><b>Platform</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference WORKFLOW__PLATFORM = eINSTANCE.getWorkflow_Platform();

    /**
     * The meta object literal for the '{@link com.yakindu.statechart.workflow.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.yakindu.statechart.workflow.impl.ModelImpl
     * @see com.yakindu.statechart.workflow.impl.WorkflowPackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '<em><b>Model</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL__MODEL = eINSTANCE.getModel_Model();

    /**
     * The meta object literal for the '{@link com.yakindu.statechart.workflow.impl.TargetImpl <em>Target</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.yakindu.statechart.workflow.impl.TargetImpl
     * @see com.yakindu.statechart.workflow.impl.WorkflowPackageImpl#getTarget()
     * @generated
     */
    EClass TARGET = eINSTANCE.getTarget();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TARGET__TARGET = eINSTANCE.getTarget_Target();

    /**
     * The meta object literal for the '{@link com.yakindu.statechart.workflow.impl.TargetPlatformImpl <em>Target Platform</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.yakindu.statechart.workflow.impl.TargetPlatformImpl
     * @see com.yakindu.statechart.workflow.impl.WorkflowPackageImpl#getTargetPlatform()
     * @generated
     */
    EClass TARGET_PLATFORM = eINSTANCE.getTargetPlatform();

    /**
     * The meta object literal for the '<em><b>Targetplatform</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TARGET_PLATFORM__TARGETPLATFORM = eINSTANCE.getTargetPlatform_Targetplatform();

    /**
     * The meta object literal for the '<em><b>Defensive</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TARGET_PLATFORM__DEFENSIVE = eINSTANCE.getTargetPlatform_Defensive();

  }

} //WorkflowPackage
