/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.yakindu.sct.model.sexec;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.yakindu.sct.model.sgraph.SGraphPackage;

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
 * @see org.yakindu.sct.model.sexec.SexecFactory
 * @model kind="package"
 * @generated
 */
public interface SexecPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "sexec";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.yakindu.org/sct/sexec/1.0.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "sexec";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SexecPackage eINSTANCE = org.yakindu.sct.model.sexec.impl.SexecPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sexec.impl.ExecutionFlowImpl <em>Execution Flow</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sexec.impl.ExecutionFlowImpl
	 * @see org.yakindu.sct.model.sexec.impl.SexecPackageImpl#getExecutionFlow()
	 * @generated
	 */
	int EXECUTION_FLOW = 0;

	/**
	 * The feature id for the '<em><b>Scopes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_FLOW__SCOPES = SGraphPackage.SCOPED_ELEMENT__SCOPES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_FLOW__NAME = SGraphPackage.SCOPED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>States</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_FLOW__STATES = SGraphPackage.SCOPED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Sequences</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_FLOW__SEQUENCES = SGraphPackage.SCOPED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Enter Sequence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_FLOW__ENTER_SEQUENCE = SGraphPackage.SCOPED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>State Vector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_FLOW__STATE_VECTOR = SGraphPackage.SCOPED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Execution Flow</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_FLOW_FEATURE_COUNT = SGraphPackage.SCOPED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sexec.impl.NamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sexec.impl.NamedElementImpl
	 * @see org.yakindu.sct.model.sexec.impl.SexecPackageImpl#getNamedElement()
	 * @generated
	 */
	int NAMED_ELEMENT = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__NAME = 0;

	/**
	 * The number of structural features of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sexec.impl.ExecutionStateImpl <em>Execution State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sexec.impl.ExecutionStateImpl
	 * @see org.yakindu.sct.model.sexec.impl.SexecPackageImpl#getExecutionState()
	 * @generated
	 */
	int EXECUTION_STATE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_STATE__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Simple Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_STATE__SIMPLE_NAME = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Cycle</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_STATE__CYCLE = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Reactions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_STATE__REACTIONS = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Leaf</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_STATE__LEAF = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Execution State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_STATE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sexec.impl.ReactionImpl <em>Reaction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sexec.impl.ReactionImpl
	 * @see org.yakindu.sct.model.sexec.impl.SexecPackageImpl#getReaction()
	 * @generated
	 */
	int REACTION = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REACTION__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Check</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REACTION__CHECK = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Effect</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REACTION__EFFECT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Reaction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REACTION_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sexec.impl.StepImpl <em>Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sexec.impl.StepImpl
	 * @see org.yakindu.sct.model.sexec.impl.SexecPackageImpl#getStep()
	 * @generated
	 */
	int STEP = 5;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sexec.impl.SequenceImpl <em>Sequence</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sexec.impl.SequenceImpl
	 * @see org.yakindu.sct.model.sexec.impl.SexecPackageImpl#getSequence()
	 * @generated
	 */
	int SEQUENCE = 6;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sexec.impl.CycleImpl <em>Cycle</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sexec.impl.CycleImpl
	 * @see org.yakindu.sct.model.sexec.impl.SexecPackageImpl#getCycle()
	 * @generated
	 */
	int CYCLE = 7;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sexec.impl.CheckImpl <em>Check</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sexec.impl.CheckImpl
	 * @see org.yakindu.sct.model.sexec.impl.SexecPackageImpl#getCheck()
	 * @generated
	 */
	int CHECK = 8;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sexec.impl.IfImpl <em>If</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sexec.impl.IfImpl
	 * @see org.yakindu.sct.model.sexec.impl.SexecPackageImpl#getIf()
	 * @generated
	 */
	int IF = 9;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sexec.impl.ExecutionImpl <em>Execution</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sexec.impl.ExecutionImpl
	 * @see org.yakindu.sct.model.sexec.impl.SexecPackageImpl#getExecution()
	 * @generated
	 */
	int EXECUTION = 10;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sexec.impl.EnterStateImpl <em>Enter State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sexec.impl.EnterStateImpl
	 * @see org.yakindu.sct.model.sexec.impl.SexecPackageImpl#getEnterState()
	 * @generated
	 */
	int ENTER_STATE = 11;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sexec.impl.ExitStateImpl <em>Exit State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sexec.impl.ExitStateImpl
	 * @see org.yakindu.sct.model.sexec.impl.SexecPackageImpl#getExitState()
	 * @generated
	 */
	int EXIT_STATE = 12;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sexec.impl.StateVectorImpl <em>State Vector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sexec.impl.StateVectorImpl
	 * @see org.yakindu.sct.model.sexec.impl.SexecPackageImpl#getStateVector()
	 * @generated
	 */
	int STATE_VECTOR = 3;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_VECTOR__SIZE = 0;

	/**
	 * The feature id for the '<em><b>Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_VECTOR__OFFSET = 1;

	/**
	 * The number of structural features of the '<em>State Vector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_VECTOR_FEATURE_COUNT = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEP__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEP__COMMENT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEP_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE__NAME = STEP__NAME;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE__COMMENT = STEP__COMMENT;

	/**
	 * The feature id for the '<em><b>Steps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE__STEPS = STEP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Sequence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_FEATURE_COUNT = STEP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CYCLE__NAME = SEQUENCE__NAME;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CYCLE__COMMENT = SEQUENCE__COMMENT;

	/**
	 * The feature id for the '<em><b>Steps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CYCLE__STEPS = SEQUENCE__STEPS;

	/**
	 * The number of structural features of the '<em>Cycle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CYCLE_FEATURE_COUNT = SEQUENCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK__NAME = STEP__NAME;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK__COMMENT = STEP__COMMENT;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK__CONDITION = STEP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Check</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK_FEATURE_COUNT = STEP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF__NAME = STEP__NAME;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF__COMMENT = STEP__COMMENT;

	/**
	 * The feature id for the '<em><b>Check</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF__CHECK = STEP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Then Step</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF__THEN_STEP = STEP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Else Step</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF__ELSE_STEP = STEP_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>If</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_FEATURE_COUNT = STEP_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION__NAME = STEP__NAME;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION__COMMENT = STEP__COMMENT;

	/**
	 * The feature id for the '<em><b>Statement</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION__STATEMENT = STEP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Execution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_FEATURE_COUNT = STEP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTER_STATE__NAME = STEP__NAME;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTER_STATE__COMMENT = STEP__COMMENT;

	/**
	 * The feature id for the '<em><b>State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTER_STATE__STATE = STEP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Enter State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTER_STATE_FEATURE_COUNT = STEP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXIT_STATE__NAME = STEP__NAME;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXIT_STATE__COMMENT = STEP__COMMENT;

	/**
	 * The feature id for the '<em><b>State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXIT_STATE__STATE = STEP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Exit State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXIT_STATE_FEATURE_COUNT = STEP_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sexec.impl.CallImpl <em>Call</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sexec.impl.CallImpl
	 * @see org.yakindu.sct.model.sexec.impl.SexecPackageImpl#getCall()
	 * @generated
	 */
	int CALL = 13;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL__NAME = STEP__NAME;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL__COMMENT = STEP__COMMENT;

	/**
	 * The feature id for the '<em><b>Step</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL__STEP = STEP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_FEATURE_COUNT = STEP_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sexec.impl.CheckRefImpl <em>Check Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sexec.impl.CheckRefImpl
	 * @see org.yakindu.sct.model.sexec.impl.SexecPackageImpl#getCheckRef()
	 * @generated
	 */
	int CHECK_REF = 14;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK_REF__NAME = CHECK__NAME;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK_REF__COMMENT = CHECK__COMMENT;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK_REF__CONDITION = CHECK__CONDITION;

	/**
	 * The feature id for the '<em><b>Check</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK_REF__CHECK = CHECK_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Check Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK_REF_FEATURE_COUNT = CHECK_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sexec.ExecutionFlow <em>Execution Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Execution Flow</em>'.
	 * @see org.yakindu.sct.model.sexec.ExecutionFlow
	 * @generated
	 */
	EClass getExecutionFlow();

	/**
	 * Returns the meta object for the containment reference list '{@link org.yakindu.sct.model.sexec.ExecutionFlow#getStates <em>States</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>States</em>'.
	 * @see org.yakindu.sct.model.sexec.ExecutionFlow#getStates()
	 * @see #getExecutionFlow()
	 * @generated
	 */
	EReference getExecutionFlow_States();

	/**
	 * Returns the meta object for the containment reference list '{@link org.yakindu.sct.model.sexec.ExecutionFlow#getSequences <em>Sequences</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sequences</em>'.
	 * @see org.yakindu.sct.model.sexec.ExecutionFlow#getSequences()
	 * @see #getExecutionFlow()
	 * @generated
	 */
	EReference getExecutionFlow_Sequences();

	/**
	 * Returns the meta object for the containment reference '{@link org.yakindu.sct.model.sexec.ExecutionFlow#getEnterSequence <em>Enter Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Enter Sequence</em>'.
	 * @see org.yakindu.sct.model.sexec.ExecutionFlow#getEnterSequence()
	 * @see #getExecutionFlow()
	 * @generated
	 */
	EReference getExecutionFlow_EnterSequence();

	/**
	 * Returns the meta object for the containment reference '{@link org.yakindu.sct.model.sexec.ExecutionFlow#getStateVector <em>State Vector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>State Vector</em>'.
	 * @see org.yakindu.sct.model.sexec.ExecutionFlow#getStateVector()
	 * @see #getExecutionFlow()
	 * @generated
	 */
	EReference getExecutionFlow_StateVector();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sexec.ExecutionState <em>Execution State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Execution State</em>'.
	 * @see org.yakindu.sct.model.sexec.ExecutionState
	 * @generated
	 */
	EClass getExecutionState();

	/**
	 * Returns the meta object for the attribute '{@link org.yakindu.sct.model.sexec.ExecutionState#getSimpleName <em>Simple Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Simple Name</em>'.
	 * @see org.yakindu.sct.model.sexec.ExecutionState#getSimpleName()
	 * @see #getExecutionState()
	 * @generated
	 */
	EAttribute getExecutionState_SimpleName();

	/**
	 * Returns the meta object for the containment reference '{@link org.yakindu.sct.model.sexec.ExecutionState#getCycle <em>Cycle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Cycle</em>'.
	 * @see org.yakindu.sct.model.sexec.ExecutionState#getCycle()
	 * @see #getExecutionState()
	 * @generated
	 */
	EReference getExecutionState_Cycle();

	/**
	 * Returns the meta object for the containment reference list '{@link org.yakindu.sct.model.sexec.ExecutionState#getReactions <em>Reactions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Reactions</em>'.
	 * @see org.yakindu.sct.model.sexec.ExecutionState#getReactions()
	 * @see #getExecutionState()
	 * @generated
	 */
	EReference getExecutionState_Reactions();

	/**
	 * Returns the meta object for the attribute '{@link org.yakindu.sct.model.sexec.ExecutionState#isLeaf <em>Leaf</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Leaf</em>'.
	 * @see org.yakindu.sct.model.sexec.ExecutionState#isLeaf()
	 * @see #getExecutionState()
	 * @generated
	 */
	EAttribute getExecutionState_Leaf();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sexec.Reaction <em>Reaction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reaction</em>'.
	 * @see org.yakindu.sct.model.sexec.Reaction
	 * @generated
	 */
	EClass getReaction();

	/**
	 * Returns the meta object for the containment reference '{@link org.yakindu.sct.model.sexec.Reaction#getCheck <em>Check</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Check</em>'.
	 * @see org.yakindu.sct.model.sexec.Reaction#getCheck()
	 * @see #getReaction()
	 * @generated
	 */
	EReference getReaction_Check();

	/**
	 * Returns the meta object for the containment reference '{@link org.yakindu.sct.model.sexec.Reaction#getEffect <em>Effect</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Effect</em>'.
	 * @see org.yakindu.sct.model.sexec.Reaction#getEffect()
	 * @see #getReaction()
	 * @generated
	 */
	EReference getReaction_Effect();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sexec.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see org.yakindu.sct.model.sexec.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link org.yakindu.sct.model.sexec.NamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.yakindu.sct.model.sexec.NamedElement#getName()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Name();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sexec.Cycle <em>Cycle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cycle</em>'.
	 * @see org.yakindu.sct.model.sexec.Cycle
	 * @generated
	 */
	EClass getCycle();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sexec.Check <em>Check</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Check</em>'.
	 * @see org.yakindu.sct.model.sexec.Check
	 * @generated
	 */
	EClass getCheck();

	/**
	 * Returns the meta object for the containment reference '{@link org.yakindu.sct.model.sexec.Check#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see org.yakindu.sct.model.sexec.Check#getCondition()
	 * @see #getCheck()
	 * @generated
	 */
	EReference getCheck_Condition();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sexec.Step <em>Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Step</em>'.
	 * @see org.yakindu.sct.model.sexec.Step
	 * @generated
	 */
	EClass getStep();

	/**
	 * Returns the meta object for the attribute '{@link org.yakindu.sct.model.sexec.Step#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment</em>'.
	 * @see org.yakindu.sct.model.sexec.Step#getComment()
	 * @see #getStep()
	 * @generated
	 */
	EAttribute getStep_Comment();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sexec.Sequence <em>Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sequence</em>'.
	 * @see org.yakindu.sct.model.sexec.Sequence
	 * @generated
	 */
	EClass getSequence();

	/**
	 * Returns the meta object for the containment reference list '{@link org.yakindu.sct.model.sexec.Sequence#getSteps <em>Steps</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Steps</em>'.
	 * @see org.yakindu.sct.model.sexec.Sequence#getSteps()
	 * @see #getSequence()
	 * @generated
	 */
	EReference getSequence_Steps();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sexec.If <em>If</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>If</em>'.
	 * @see org.yakindu.sct.model.sexec.If
	 * @generated
	 */
	EClass getIf();

	/**
	 * Returns the meta object for the containment reference '{@link org.yakindu.sct.model.sexec.If#getCheck <em>Check</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Check</em>'.
	 * @see org.yakindu.sct.model.sexec.If#getCheck()
	 * @see #getIf()
	 * @generated
	 */
	EReference getIf_Check();

	/**
	 * Returns the meta object for the containment reference '{@link org.yakindu.sct.model.sexec.If#getThenStep <em>Then Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Then Step</em>'.
	 * @see org.yakindu.sct.model.sexec.If#getThenStep()
	 * @see #getIf()
	 * @generated
	 */
	EReference getIf_ThenStep();

	/**
	 * Returns the meta object for the containment reference '{@link org.yakindu.sct.model.sexec.If#getElseStep <em>Else Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Else Step</em>'.
	 * @see org.yakindu.sct.model.sexec.If#getElseStep()
	 * @see #getIf()
	 * @generated
	 */
	EReference getIf_ElseStep();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sexec.Execution <em>Execution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Execution</em>'.
	 * @see org.yakindu.sct.model.sexec.Execution
	 * @generated
	 */
	EClass getExecution();

	/**
	 * Returns the meta object for the containment reference '{@link org.yakindu.sct.model.sexec.Execution#getStatement <em>Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Statement</em>'.
	 * @see org.yakindu.sct.model.sexec.Execution#getStatement()
	 * @see #getExecution()
	 * @generated
	 */
	EReference getExecution_Statement();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sexec.EnterState <em>Enter State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enter State</em>'.
	 * @see org.yakindu.sct.model.sexec.EnterState
	 * @generated
	 */
	EClass getEnterState();

	/**
	 * Returns the meta object for the reference '{@link org.yakindu.sct.model.sexec.EnterState#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>State</em>'.
	 * @see org.yakindu.sct.model.sexec.EnterState#getState()
	 * @see #getEnterState()
	 * @generated
	 */
	EReference getEnterState_State();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sexec.ExitState <em>Exit State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Exit State</em>'.
	 * @see org.yakindu.sct.model.sexec.ExitState
	 * @generated
	 */
	EClass getExitState();

	/**
	 * Returns the meta object for the reference '{@link org.yakindu.sct.model.sexec.ExitState#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>State</em>'.
	 * @see org.yakindu.sct.model.sexec.ExitState#getState()
	 * @see #getExitState()
	 * @generated
	 */
	EReference getExitState_State();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sexec.Call <em>Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Call</em>'.
	 * @see org.yakindu.sct.model.sexec.Call
	 * @generated
	 */
	EClass getCall();

	/**
	 * Returns the meta object for the reference '{@link org.yakindu.sct.model.sexec.Call#getStep <em>Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Step</em>'.
	 * @see org.yakindu.sct.model.sexec.Call#getStep()
	 * @see #getCall()
	 * @generated
	 */
	EReference getCall_Step();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sexec.CheckRef <em>Check Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Check Ref</em>'.
	 * @see org.yakindu.sct.model.sexec.CheckRef
	 * @generated
	 */
	EClass getCheckRef();

	/**
	 * Returns the meta object for the reference '{@link org.yakindu.sct.model.sexec.CheckRef#getCheck <em>Check</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Check</em>'.
	 * @see org.yakindu.sct.model.sexec.CheckRef#getCheck()
	 * @see #getCheckRef()
	 * @generated
	 */
	EReference getCheckRef_Check();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sexec.StateVector <em>State Vector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State Vector</em>'.
	 * @see org.yakindu.sct.model.sexec.StateVector
	 * @generated
	 */
	EClass getStateVector();

	/**
	 * Returns the meta object for the attribute '{@link org.yakindu.sct.model.sexec.StateVector#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see org.yakindu.sct.model.sexec.StateVector#getSize()
	 * @see #getStateVector()
	 * @generated
	 */
	EAttribute getStateVector_Size();

	/**
	 * Returns the meta object for the attribute '{@link org.yakindu.sct.model.sexec.StateVector#getOffset <em>Offset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Offset</em>'.
	 * @see org.yakindu.sct.model.sexec.StateVector#getOffset()
	 * @see #getStateVector()
	 * @generated
	 */
	EAttribute getStateVector_Offset();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SexecFactory getSexecFactory();

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
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.sexec.impl.ExecutionFlowImpl <em>Execution Flow</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sexec.impl.ExecutionFlowImpl
		 * @see org.yakindu.sct.model.sexec.impl.SexecPackageImpl#getExecutionFlow()
		 * @generated
		 */
		EClass EXECUTION_FLOW = eINSTANCE.getExecutionFlow();

		/**
		 * The meta object literal for the '<em><b>States</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION_FLOW__STATES = eINSTANCE.getExecutionFlow_States();

		/**
		 * The meta object literal for the '<em><b>Sequences</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION_FLOW__SEQUENCES = eINSTANCE.getExecutionFlow_Sequences();

		/**
		 * The meta object literal for the '<em><b>Enter Sequence</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION_FLOW__ENTER_SEQUENCE = eINSTANCE.getExecutionFlow_EnterSequence();

		/**
		 * The meta object literal for the '<em><b>State Vector</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION_FLOW__STATE_VECTOR = eINSTANCE.getExecutionFlow_StateVector();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.sexec.impl.ExecutionStateImpl <em>Execution State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sexec.impl.ExecutionStateImpl
		 * @see org.yakindu.sct.model.sexec.impl.SexecPackageImpl#getExecutionState()
		 * @generated
		 */
		EClass EXECUTION_STATE = eINSTANCE.getExecutionState();

		/**
		 * The meta object literal for the '<em><b>Simple Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXECUTION_STATE__SIMPLE_NAME = eINSTANCE.getExecutionState_SimpleName();

		/**
		 * The meta object literal for the '<em><b>Cycle</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION_STATE__CYCLE = eINSTANCE.getExecutionState_Cycle();

		/**
		 * The meta object literal for the '<em><b>Reactions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION_STATE__REACTIONS = eINSTANCE.getExecutionState_Reactions();

		/**
		 * The meta object literal for the '<em><b>Leaf</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXECUTION_STATE__LEAF = eINSTANCE.getExecutionState_Leaf();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.sexec.impl.ReactionImpl <em>Reaction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sexec.impl.ReactionImpl
		 * @see org.yakindu.sct.model.sexec.impl.SexecPackageImpl#getReaction()
		 * @generated
		 */
		EClass REACTION = eINSTANCE.getReaction();

		/**
		 * The meta object literal for the '<em><b>Check</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REACTION__CHECK = eINSTANCE.getReaction_Check();

		/**
		 * The meta object literal for the '<em><b>Effect</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REACTION__EFFECT = eINSTANCE.getReaction_Effect();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.sexec.impl.NamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sexec.impl.NamedElementImpl
		 * @see org.yakindu.sct.model.sexec.impl.SexecPackageImpl#getNamedElement()
		 * @generated
		 */
		EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__NAME = eINSTANCE.getNamedElement_Name();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.sexec.impl.CycleImpl <em>Cycle</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sexec.impl.CycleImpl
		 * @see org.yakindu.sct.model.sexec.impl.SexecPackageImpl#getCycle()
		 * @generated
		 */
		EClass CYCLE = eINSTANCE.getCycle();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.sexec.impl.CheckImpl <em>Check</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sexec.impl.CheckImpl
		 * @see org.yakindu.sct.model.sexec.impl.SexecPackageImpl#getCheck()
		 * @generated
		 */
		EClass CHECK = eINSTANCE.getCheck();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHECK__CONDITION = eINSTANCE.getCheck_Condition();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.sexec.impl.StepImpl <em>Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sexec.impl.StepImpl
		 * @see org.yakindu.sct.model.sexec.impl.SexecPackageImpl#getStep()
		 * @generated
		 */
		EClass STEP = eINSTANCE.getStep();

		/**
		 * The meta object literal for the '<em><b>Comment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STEP__COMMENT = eINSTANCE.getStep_Comment();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.sexec.impl.SequenceImpl <em>Sequence</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sexec.impl.SequenceImpl
		 * @see org.yakindu.sct.model.sexec.impl.SexecPackageImpl#getSequence()
		 * @generated
		 */
		EClass SEQUENCE = eINSTANCE.getSequence();

		/**
		 * The meta object literal for the '<em><b>Steps</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEQUENCE__STEPS = eINSTANCE.getSequence_Steps();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.sexec.impl.IfImpl <em>If</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sexec.impl.IfImpl
		 * @see org.yakindu.sct.model.sexec.impl.SexecPackageImpl#getIf()
		 * @generated
		 */
		EClass IF = eINSTANCE.getIf();

		/**
		 * The meta object literal for the '<em><b>Check</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF__CHECK = eINSTANCE.getIf_Check();

		/**
		 * The meta object literal for the '<em><b>Then Step</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF__THEN_STEP = eINSTANCE.getIf_ThenStep();

		/**
		 * The meta object literal for the '<em><b>Else Step</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF__ELSE_STEP = eINSTANCE.getIf_ElseStep();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.sexec.impl.ExecutionImpl <em>Execution</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sexec.impl.ExecutionImpl
		 * @see org.yakindu.sct.model.sexec.impl.SexecPackageImpl#getExecution()
		 * @generated
		 */
		EClass EXECUTION = eINSTANCE.getExecution();

		/**
		 * The meta object literal for the '<em><b>Statement</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION__STATEMENT = eINSTANCE.getExecution_Statement();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.sexec.impl.EnterStateImpl <em>Enter State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sexec.impl.EnterStateImpl
		 * @see org.yakindu.sct.model.sexec.impl.SexecPackageImpl#getEnterState()
		 * @generated
		 */
		EClass ENTER_STATE = eINSTANCE.getEnterState();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTER_STATE__STATE = eINSTANCE.getEnterState_State();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.sexec.impl.ExitStateImpl <em>Exit State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sexec.impl.ExitStateImpl
		 * @see org.yakindu.sct.model.sexec.impl.SexecPackageImpl#getExitState()
		 * @generated
		 */
		EClass EXIT_STATE = eINSTANCE.getExitState();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXIT_STATE__STATE = eINSTANCE.getExitState_State();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.sexec.impl.CallImpl <em>Call</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sexec.impl.CallImpl
		 * @see org.yakindu.sct.model.sexec.impl.SexecPackageImpl#getCall()
		 * @generated
		 */
		EClass CALL = eINSTANCE.getCall();

		/**
		 * The meta object literal for the '<em><b>Step</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CALL__STEP = eINSTANCE.getCall_Step();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.sexec.impl.CheckRefImpl <em>Check Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sexec.impl.CheckRefImpl
		 * @see org.yakindu.sct.model.sexec.impl.SexecPackageImpl#getCheckRef()
		 * @generated
		 */
		EClass CHECK_REF = eINSTANCE.getCheckRef();

		/**
		 * The meta object literal for the '<em><b>Check</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHECK_REF__CHECK = eINSTANCE.getCheckRef_Check();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.sexec.impl.StateVectorImpl <em>State Vector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sexec.impl.StateVectorImpl
		 * @see org.yakindu.sct.model.sexec.impl.SexecPackageImpl#getStateVector()
		 * @generated
		 */
		EClass STATE_VECTOR = eINSTANCE.getStateVector();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATE_VECTOR__SIZE = eINSTANCE.getStateVector_Size();

		/**
		 * The meta object literal for the '<em><b>Offset</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATE_VECTOR__OFFSET = eINSTANCE.getStateVector_Offset();

	}

} //SexecPackage
