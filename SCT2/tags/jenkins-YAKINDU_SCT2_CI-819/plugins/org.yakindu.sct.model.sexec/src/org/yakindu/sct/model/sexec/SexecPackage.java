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
	int EXECUTION_FLOW = 2;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sexec.impl.NamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sexec.impl.NamedElementImpl
	 * @see org.yakindu.sct.model.sexec.impl.SexecPackageImpl#getNamedElement()
	 * @generated
	 */
	int NAMED_ELEMENT = 0;

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
	 * The meta object id for the '{@link org.yakindu.sct.model.sexec.impl.MappedElementImpl <em>Mapped Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sexec.impl.MappedElementImpl
	 * @see org.yakindu.sct.model.sexec.impl.SexecPackageImpl#getMappedElement()
	 * @generated
	 */
	int MAPPED_ELEMENT = 1;

	/**
	 * The feature id for the '<em><b>Source Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_ELEMENT__SOURCE_ELEMENT = 0;

	/**
	 * The number of structural features of the '<em>Mapped Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Scopes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_FLOW__SCOPES = SGraphPackage.SCOPED_ELEMENT__SCOPES;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_FLOW__NAMESPACE = SGraphPackage.SCOPED_ELEMENT__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_FLOW__NAME = SGraphPackage.SCOPED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_FLOW__SOURCE_ELEMENT = SGraphPackage.SCOPED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>State Vector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_FLOW__STATE_VECTOR = SGraphPackage.SCOPED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Sub Scopes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_FLOW__SUB_SCOPES = SGraphPackage.SCOPED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Super Scope</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_FLOW__SUPER_SCOPE = SGraphPackage.SCOPED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Enter Sequence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_FLOW__ENTER_SEQUENCE = SGraphPackage.SCOPED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Exit Sequence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_FLOW__EXIT_SEQUENCE = SGraphPackage.SCOPED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>States</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_FLOW__STATES = SGraphPackage.SCOPED_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_FLOW__NODES = SGraphPackage.SCOPED_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Regions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_FLOW__REGIONS = SGraphPackage.SCOPED_ELEMENT_FEATURE_COUNT + 9;

	/**
	 * The number of structural features of the '<em>Execution Flow</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_FLOW_FEATURE_COUNT = SGraphPackage.SCOPED_ELEMENT_FEATURE_COUNT + 10;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sexec.impl.ExecutionNodeImpl <em>Execution Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sexec.impl.ExecutionNodeImpl
	 * @see org.yakindu.sct.model.sexec.impl.SexecPackageImpl#getExecutionNode()
	 * @generated
	 */
	int EXECUTION_NODE = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_NODE__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Source Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_NODE__SOURCE_ELEMENT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Reactions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_NODE__REACTIONS = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Simple Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_NODE__SIMPLE_NAME = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>React Sequence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_NODE__REACT_SEQUENCE = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Execution Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_NODE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sexec.impl.ExecutionStateImpl <em>Execution State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sexec.impl.ExecutionStateImpl
	 * @see org.yakindu.sct.model.sexec.impl.SexecPackageImpl#getExecutionState()
	 * @generated
	 */
	int EXECUTION_STATE = 4;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sexec.impl.ReactionImpl <em>Reaction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sexec.impl.ReactionImpl
	 * @see org.yakindu.sct.model.sexec.impl.SexecPackageImpl#getReaction()
	 * @generated
	 */
	int REACTION = 9;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sexec.impl.StepImpl <em>Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sexec.impl.StepImpl
	 * @see org.yakindu.sct.model.sexec.impl.SexecPackageImpl#getStep()
	 * @generated
	 */
	int STEP = 12;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sexec.impl.SequenceImpl <em>Sequence</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sexec.impl.SequenceImpl
	 * @see org.yakindu.sct.model.sexec.impl.SexecPackageImpl#getSequence()
	 * @generated
	 */
	int SEQUENCE = 13;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sexec.impl.CheckImpl <em>Check</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sexec.impl.CheckImpl
	 * @see org.yakindu.sct.model.sexec.impl.SexecPackageImpl#getCheck()
	 * @generated
	 */
	int CHECK = 14;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sexec.impl.IfImpl <em>If</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sexec.impl.IfImpl
	 * @see org.yakindu.sct.model.sexec.impl.SexecPackageImpl#getIf()
	 * @generated
	 */
	int IF = 16;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sexec.impl.ExecutionImpl <em>Execution</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sexec.impl.ExecutionImpl
	 * @see org.yakindu.sct.model.sexec.impl.SexecPackageImpl#getExecution()
	 * @generated
	 */
	int EXECUTION = 17;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sexec.impl.EnterStateImpl <em>Enter State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sexec.impl.EnterStateImpl
	 * @see org.yakindu.sct.model.sexec.impl.SexecPackageImpl#getEnterState()
	 * @generated
	 */
	int ENTER_STATE = 18;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sexec.impl.ExitStateImpl <em>Exit State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sexec.impl.ExitStateImpl
	 * @see org.yakindu.sct.model.sexec.impl.SexecPackageImpl#getExitState()
	 * @generated
	 */
	int EXIT_STATE = 19;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sexec.impl.StateVectorImpl <em>State Vector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sexec.impl.StateVectorImpl
	 * @see org.yakindu.sct.model.sexec.impl.SexecPackageImpl#getStateVector()
	 * @generated
	 */
	int STATE_VECTOR = 10;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sexec.impl.TimeEventImpl <em>Time Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sexec.impl.TimeEventImpl
	 * @see org.yakindu.sct.model.sexec.impl.SexecPackageImpl#getTimeEvent()
	 * @generated
	 */
	int TIME_EVENT = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_STATE__NAME = EXECUTION_NODE__NAME;

	/**
	 * The feature id for the '<em><b>Source Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_STATE__SOURCE_ELEMENT = EXECUTION_NODE__SOURCE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Reactions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_STATE__REACTIONS = EXECUTION_NODE__REACTIONS;

	/**
	 * The feature id for the '<em><b>Simple Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_STATE__SIMPLE_NAME = EXECUTION_NODE__SIMPLE_NAME;

	/**
	 * The feature id for the '<em><b>React Sequence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_STATE__REACT_SEQUENCE = EXECUTION_NODE__REACT_SEQUENCE;

	/**
	 * The feature id for the '<em><b>State Vector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_STATE__STATE_VECTOR = EXECUTION_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Sub Scopes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_STATE__SUB_SCOPES = EXECUTION_NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Super Scope</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_STATE__SUPER_SCOPE = EXECUTION_NODE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Enter Sequence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_STATE__ENTER_SEQUENCE = EXECUTION_NODE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Exit Sequence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_STATE__EXIT_SEQUENCE = EXECUTION_NODE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Leaf</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_STATE__LEAF = EXECUTION_NODE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Entry Action</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_STATE__ENTRY_ACTION = EXECUTION_NODE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Exit Action</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_STATE__EXIT_ACTION = EXECUTION_NODE_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Execution State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_STATE_FEATURE_COUNT = EXECUTION_NODE_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sexec.impl.ExecutionScopeImpl <em>Execution Scope</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sexec.impl.ExecutionScopeImpl
	 * @see org.yakindu.sct.model.sexec.impl.SexecPackageImpl#getExecutionScope()
	 * @generated
	 */
	int EXECUTION_SCOPE = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_SCOPE__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Source Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_SCOPE__SOURCE_ELEMENT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>State Vector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_SCOPE__STATE_VECTOR = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Sub Scopes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_SCOPE__SUB_SCOPES = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Super Scope</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_SCOPE__SUPER_SCOPE = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Enter Sequence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_SCOPE__ENTER_SEQUENCE = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Exit Sequence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_SCOPE__EXIT_SEQUENCE = NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Execution Scope</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_SCOPE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sexec.impl.ExecutionRegionImpl <em>Execution Region</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sexec.impl.ExecutionRegionImpl
	 * @see org.yakindu.sct.model.sexec.impl.SexecPackageImpl#getExecutionRegion()
	 * @generated
	 */
	int EXECUTION_REGION = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_REGION__NAME = EXECUTION_SCOPE__NAME;

	/**
	 * The feature id for the '<em><b>Source Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_REGION__SOURCE_ELEMENT = EXECUTION_SCOPE__SOURCE_ELEMENT;

	/**
	 * The feature id for the '<em><b>State Vector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_REGION__STATE_VECTOR = EXECUTION_SCOPE__STATE_VECTOR;

	/**
	 * The feature id for the '<em><b>Sub Scopes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_REGION__SUB_SCOPES = EXECUTION_SCOPE__SUB_SCOPES;

	/**
	 * The feature id for the '<em><b>Super Scope</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_REGION__SUPER_SCOPE = EXECUTION_SCOPE__SUPER_SCOPE;

	/**
	 * The feature id for the '<em><b>Enter Sequence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_REGION__ENTER_SEQUENCE = EXECUTION_SCOPE__ENTER_SEQUENCE;

	/**
	 * The feature id for the '<em><b>Exit Sequence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_REGION__EXIT_SEQUENCE = EXECUTION_SCOPE__EXIT_SEQUENCE;

	/**
	 * The number of structural features of the '<em>Execution Region</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_REGION_FEATURE_COUNT = EXECUTION_SCOPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sexec.impl.ExecutionEntryImpl <em>Execution Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sexec.impl.ExecutionEntryImpl
	 * @see org.yakindu.sct.model.sexec.impl.SexecPackageImpl#getExecutionEntry()
	 * @generated
	 */
	int EXECUTION_ENTRY = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_ENTRY__NAME = EXECUTION_NODE__NAME;

	/**
	 * The feature id for the '<em><b>Source Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_ENTRY__SOURCE_ELEMENT = EXECUTION_NODE__SOURCE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Reactions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_ENTRY__REACTIONS = EXECUTION_NODE__REACTIONS;

	/**
	 * The feature id for the '<em><b>Simple Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_ENTRY__SIMPLE_NAME = EXECUTION_NODE__SIMPLE_NAME;

	/**
	 * The feature id for the '<em><b>React Sequence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_ENTRY__REACT_SEQUENCE = EXECUTION_NODE__REACT_SEQUENCE;

	/**
	 * The number of structural features of the '<em>Execution Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_ENTRY_FEATURE_COUNT = EXECUTION_NODE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sexec.impl.ExecutionChoiceImpl <em>Execution Choice</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sexec.impl.ExecutionChoiceImpl
	 * @see org.yakindu.sct.model.sexec.impl.SexecPackageImpl#getExecutionChoice()
	 * @generated
	 */
	int EXECUTION_CHOICE = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_CHOICE__NAME = EXECUTION_NODE__NAME;

	/**
	 * The feature id for the '<em><b>Source Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_CHOICE__SOURCE_ELEMENT = EXECUTION_NODE__SOURCE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Reactions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_CHOICE__REACTIONS = EXECUTION_NODE__REACTIONS;

	/**
	 * The feature id for the '<em><b>Simple Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_CHOICE__SIMPLE_NAME = EXECUTION_NODE__SIMPLE_NAME;

	/**
	 * The feature id for the '<em><b>React Sequence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_CHOICE__REACT_SEQUENCE = EXECUTION_NODE__REACT_SEQUENCE;

	/**
	 * The number of structural features of the '<em>Execution Choice</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_CHOICE_FEATURE_COUNT = EXECUTION_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REACTION__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Source Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REACTION__SOURCE_ELEMENT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Check</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REACTION__CHECK = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Effect</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REACTION__EFFECT = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Transition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REACTION__TRANSITION = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Reaction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REACTION_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 4;

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
	int TIME_EVENT__NAME = SGraphPackage.EVENT__NAME;

	/**
	 * The feature id for the '<em><b>Periodic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_EVENT__PERIODIC = SGraphPackage.EVENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Time Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_EVENT_FEATURE_COUNT = SGraphPackage.EVENT_FEATURE_COUNT + 1;

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
	 * The feature id for the '<em><b>Caller</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEP__CALLER = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEP_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 2;

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
	 * The feature id for the '<em><b>Caller</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE__CALLER = STEP__CALLER;

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
	 * The feature id for the '<em><b>Caller</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK__CALLER = STEP__CALLER;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK__CONDITION = STEP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK__REFS = STEP_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Check</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK_FEATURE_COUNT = STEP_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sexec.impl.CallImpl <em>Call</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sexec.impl.CallImpl
	 * @see org.yakindu.sct.model.sexec.impl.SexecPackageImpl#getCall()
	 * @generated
	 */
	int CALL = 20;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sexec.impl.ScheduleTimeEventImpl <em>Schedule Time Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sexec.impl.ScheduleTimeEventImpl
	 * @see org.yakindu.sct.model.sexec.impl.SexecPackageImpl#getScheduleTimeEvent()
	 * @generated
	 */
	int SCHEDULE_TIME_EVENT = 21;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sexec.impl.UnscheduleTimeEventImpl <em>Unschedule Time Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sexec.impl.UnscheduleTimeEventImpl
	 * @see org.yakindu.sct.model.sexec.impl.SexecPackageImpl#getUnscheduleTimeEvent()
	 * @generated
	 */
	int UNSCHEDULE_TIME_EVENT = 22;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sexec.impl.CheckRefImpl <em>Check Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sexec.impl.CheckRefImpl
	 * @see org.yakindu.sct.model.sexec.impl.SexecPackageImpl#getCheckRef()
	 * @generated
	 */
	int CHECK_REF = 15;

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
	 * The feature id for the '<em><b>Caller</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK_REF__CALLER = CHECK__CALLER;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK_REF__CONDITION = CHECK__CONDITION;

	/**
	 * The feature id for the '<em><b>Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK_REF__REFS = CHECK__REFS;

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
	 * The feature id for the '<em><b>Caller</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF__CALLER = STEP__CALLER;

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
	 * The feature id for the '<em><b>Caller</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION__CALLER = STEP__CALLER;

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
	 * The feature id for the '<em><b>Caller</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTER_STATE__CALLER = STEP__CALLER;

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
	 * The feature id for the '<em><b>Caller</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXIT_STATE__CALLER = STEP__CALLER;

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
	 * The feature id for the '<em><b>Caller</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL__CALLER = STEP__CALLER;

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
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULE_TIME_EVENT__NAME = STEP__NAME;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULE_TIME_EVENT__COMMENT = STEP__COMMENT;

	/**
	 * The feature id for the '<em><b>Caller</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULE_TIME_EVENT__CALLER = STEP__CALLER;

	/**
	 * The feature id for the '<em><b>Time Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULE_TIME_EVENT__TIME_EVENT = STEP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Time Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULE_TIME_EVENT__TIME_VALUE = STEP_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Schedule Time Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULE_TIME_EVENT_FEATURE_COUNT = STEP_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSCHEDULE_TIME_EVENT__NAME = STEP__NAME;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSCHEDULE_TIME_EVENT__COMMENT = STEP__COMMENT;

	/**
	 * The feature id for the '<em><b>Caller</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSCHEDULE_TIME_EVENT__CALLER = STEP__CALLER;

	/**
	 * The feature id for the '<em><b>Time Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSCHEDULE_TIME_EVENT__TIME_EVENT = STEP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Unschedule Time Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSCHEDULE_TIME_EVENT_FEATURE_COUNT = STEP_FEATURE_COUNT + 1;


	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sexec.impl.StateSwitchImpl <em>State Switch</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sexec.impl.StateSwitchImpl
	 * @see org.yakindu.sct.model.sexec.impl.SexecPackageImpl#getStateSwitch()
	 * @generated
	 */
	int STATE_SWITCH = 23;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_SWITCH__NAME = STEP__NAME;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_SWITCH__COMMENT = STEP__COMMENT;

	/**
	 * The feature id for the '<em><b>Caller</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_SWITCH__CALLER = STEP__CALLER;

	/**
	 * The feature id for the '<em><b>Cases</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_SWITCH__CASES = STEP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>State Configuration Idx</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_SWITCH__STATE_CONFIGURATION_IDX = STEP_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>State Switch</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_SWITCH_FEATURE_COUNT = STEP_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sexec.impl.StateCaseImpl <em>State Case</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sexec.impl.StateCaseImpl
	 * @see org.yakindu.sct.model.sexec.impl.SexecPackageImpl#getStateCase()
	 * @generated
	 */
	int STATE_CASE = 24;

	/**
	 * The feature id for the '<em><b>State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_CASE__STATE = 0;

	/**
	 * The feature id for the '<em><b>Step</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_CASE__STEP = 1;

	/**
	 * The number of structural features of the '<em>State Case</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_CASE_FEATURE_COUNT = 2;


	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sexec.impl.TraceImpl <em>Trace</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sexec.impl.TraceImpl
	 * @see org.yakindu.sct.model.sexec.impl.SexecPackageImpl#getTrace()
	 * @generated
	 */
	int TRACE = 25;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE__NAME = STEP__NAME;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE__COMMENT = STEP__COMMENT;

	/**
	 * The feature id for the '<em><b>Caller</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE__CALLER = STEP__CALLER;

	/**
	 * The number of structural features of the '<em>Trace</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_FEATURE_COUNT = STEP_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sexec.impl.TraceNodeExecutedImpl <em>Trace Node Executed</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sexec.impl.TraceNodeExecutedImpl
	 * @see org.yakindu.sct.model.sexec.impl.SexecPackageImpl#getTraceNodeExecuted()
	 * @generated
	 */
	int TRACE_NODE_EXECUTED = 26;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_NODE_EXECUTED__NAME = TRACE__NAME;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_NODE_EXECUTED__COMMENT = TRACE__COMMENT;

	/**
	 * The feature id for the '<em><b>Caller</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_NODE_EXECUTED__CALLER = TRACE__CALLER;

	/**
	 * The feature id for the '<em><b>Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_NODE_EXECUTED__NODE = TRACE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Trace Node Executed</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_NODE_EXECUTED_FEATURE_COUNT = TRACE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sexec.impl.ReactionFiredImpl <em>Reaction Fired</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sexec.impl.ReactionFiredImpl
	 * @see org.yakindu.sct.model.sexec.impl.SexecPackageImpl#getReactionFired()
	 * @generated
	 */
	int REACTION_FIRED = 27;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REACTION_FIRED__NAME = TRACE__NAME;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REACTION_FIRED__COMMENT = TRACE__COMMENT;

	/**
	 * The feature id for the '<em><b>Caller</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REACTION_FIRED__CALLER = TRACE__CALLER;

	/**
	 * The feature id for the '<em><b>Reaction</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REACTION_FIRED__REACTION = TRACE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Reaction Fired</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REACTION_FIRED_FEATURE_COUNT = TRACE_FEATURE_COUNT + 1;


	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sexec.impl.TraceStateEnteredImpl <em>Trace State Entered</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sexec.impl.TraceStateEnteredImpl
	 * @see org.yakindu.sct.model.sexec.impl.SexecPackageImpl#getTraceStateEntered()
	 * @generated
	 */
	int TRACE_STATE_ENTERED = 28;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_STATE_ENTERED__NAME = TRACE__NAME;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_STATE_ENTERED__COMMENT = TRACE__COMMENT;

	/**
	 * The feature id for the '<em><b>Caller</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_STATE_ENTERED__CALLER = TRACE__CALLER;

	/**
	 * The feature id for the '<em><b>State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_STATE_ENTERED__STATE = TRACE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Trace State Entered</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_STATE_ENTERED_FEATURE_COUNT = TRACE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sexec.impl.TraceStateExitedImpl <em>Trace State Exited</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sexec.impl.TraceStateExitedImpl
	 * @see org.yakindu.sct.model.sexec.impl.SexecPackageImpl#getTraceStateExited()
	 * @generated
	 */
	int TRACE_STATE_EXITED = 29;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_STATE_EXITED__NAME = TRACE__NAME;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_STATE_EXITED__COMMENT = TRACE__COMMENT;

	/**
	 * The feature id for the '<em><b>Caller</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_STATE_EXITED__CALLER = TRACE__CALLER;

	/**
	 * The feature id for the '<em><b>State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_STATE_EXITED__STATE = TRACE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Trace State Exited</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_STATE_EXITED_FEATURE_COUNT = TRACE_FEATURE_COUNT + 1;


	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sexec.impl.TraceRegionExitedImpl <em>Trace Region Exited</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sexec.impl.TraceRegionExitedImpl
	 * @see org.yakindu.sct.model.sexec.impl.SexecPackageImpl#getTraceRegionExited()
	 * @generated
	 */
	int TRACE_REGION_EXITED = 30;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_REGION_EXITED__NAME = TRACE__NAME;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_REGION_EXITED__COMMENT = TRACE__COMMENT;

	/**
	 * The feature id for the '<em><b>Caller</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_REGION_EXITED__CALLER = TRACE__CALLER;

	/**
	 * The feature id for the '<em><b>Region</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_REGION_EXITED__REGION = TRACE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Trace Region Exited</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_REGION_EXITED_FEATURE_COUNT = TRACE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sexec.impl.TraceRegionEnteredImpl <em>Trace Region Entered</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sexec.impl.TraceRegionEnteredImpl
	 * @see org.yakindu.sct.model.sexec.impl.SexecPackageImpl#getTraceRegionEntered()
	 * @generated
	 */
	int TRACE_REGION_ENTERED = 31;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_REGION_ENTERED__NAME = TRACE__NAME;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_REGION_ENTERED__COMMENT = TRACE__COMMENT;

	/**
	 * The feature id for the '<em><b>Caller</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_REGION_ENTERED__CALLER = TRACE__CALLER;

	/**
	 * The feature id for the '<em><b>Region</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_REGION_ENTERED__REGION = TRACE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Trace Region Entered</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_REGION_ENTERED_FEATURE_COUNT = TRACE_FEATURE_COUNT + 1;


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
	 * Returns the meta object for the containment reference list '{@link org.yakindu.sct.model.sexec.ExecutionFlow#getNodes <em>Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Nodes</em>'.
	 * @see org.yakindu.sct.model.sexec.ExecutionFlow#getNodes()
	 * @see #getExecutionFlow()
	 * @generated
	 */
	EReference getExecutionFlow_Nodes();

	/**
	 * Returns the meta object for the containment reference list '{@link org.yakindu.sct.model.sexec.ExecutionFlow#getRegions <em>Regions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Regions</em>'.
	 * @see org.yakindu.sct.model.sexec.ExecutionFlow#getRegions()
	 * @see #getExecutionFlow()
	 * @generated
	 */
	EReference getExecutionFlow_Regions();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sexec.ExecutionNode <em>Execution Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Execution Node</em>'.
	 * @see org.yakindu.sct.model.sexec.ExecutionNode
	 * @generated
	 */
	EClass getExecutionNode();

	/**
	 * Returns the meta object for the containment reference list '{@link org.yakindu.sct.model.sexec.ExecutionNode#getReactions <em>Reactions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Reactions</em>'.
	 * @see org.yakindu.sct.model.sexec.ExecutionNode#getReactions()
	 * @see #getExecutionNode()
	 * @generated
	 */
	EReference getExecutionNode_Reactions();

	/**
	 * Returns the meta object for the attribute '{@link org.yakindu.sct.model.sexec.ExecutionNode#getSimpleName <em>Simple Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Simple Name</em>'.
	 * @see org.yakindu.sct.model.sexec.ExecutionNode#getSimpleName()
	 * @see #getExecutionNode()
	 * @generated
	 */
	EAttribute getExecutionNode_SimpleName();

	/**
	 * Returns the meta object for the containment reference '{@link org.yakindu.sct.model.sexec.ExecutionNode#getReactSequence <em>React Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>React Sequence</em>'.
	 * @see org.yakindu.sct.model.sexec.ExecutionNode#getReactSequence()
	 * @see #getExecutionNode()
	 * @generated
	 */
	EReference getExecutionNode_ReactSequence();

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
	 * Returns the meta object for the containment reference '{@link org.yakindu.sct.model.sexec.ExecutionState#getEntryAction <em>Entry Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Entry Action</em>'.
	 * @see org.yakindu.sct.model.sexec.ExecutionState#getEntryAction()
	 * @see #getExecutionState()
	 * @generated
	 */
	EReference getExecutionState_EntryAction();

	/**
	 * Returns the meta object for the containment reference '{@link org.yakindu.sct.model.sexec.ExecutionState#getExitAction <em>Exit Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Exit Action</em>'.
	 * @see org.yakindu.sct.model.sexec.ExecutionState#getExitAction()
	 * @see #getExecutionState()
	 * @generated
	 */
	EReference getExecutionState_ExitAction();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sexec.ExecutionScope <em>Execution Scope</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Execution Scope</em>'.
	 * @see org.yakindu.sct.model.sexec.ExecutionScope
	 * @generated
	 */
	EClass getExecutionScope();

	/**
	 * Returns the meta object for the containment reference '{@link org.yakindu.sct.model.sexec.ExecutionScope#getStateVector <em>State Vector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>State Vector</em>'.
	 * @see org.yakindu.sct.model.sexec.ExecutionScope#getStateVector()
	 * @see #getExecutionScope()
	 * @generated
	 */
	EReference getExecutionScope_StateVector();

	/**
	 * Returns the meta object for the reference list '{@link org.yakindu.sct.model.sexec.ExecutionScope#getSubScopes <em>Sub Scopes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Sub Scopes</em>'.
	 * @see org.yakindu.sct.model.sexec.ExecutionScope#getSubScopes()
	 * @see #getExecutionScope()
	 * @generated
	 */
	EReference getExecutionScope_SubScopes();

	/**
	 * Returns the meta object for the reference '{@link org.yakindu.sct.model.sexec.ExecutionScope#getSuperScope <em>Super Scope</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Super Scope</em>'.
	 * @see org.yakindu.sct.model.sexec.ExecutionScope#getSuperScope()
	 * @see #getExecutionScope()
	 * @generated
	 */
	EReference getExecutionScope_SuperScope();

	/**
	 * Returns the meta object for the containment reference '{@link org.yakindu.sct.model.sexec.ExecutionScope#getEnterSequence <em>Enter Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Enter Sequence</em>'.
	 * @see org.yakindu.sct.model.sexec.ExecutionScope#getEnterSequence()
	 * @see #getExecutionScope()
	 * @generated
	 */
	EReference getExecutionScope_EnterSequence();

	/**
	 * Returns the meta object for the containment reference '{@link org.yakindu.sct.model.sexec.ExecutionScope#getExitSequence <em>Exit Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Exit Sequence</em>'.
	 * @see org.yakindu.sct.model.sexec.ExecutionScope#getExitSequence()
	 * @see #getExecutionScope()
	 * @generated
	 */
	EReference getExecutionScope_ExitSequence();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sexec.ExecutionRegion <em>Execution Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Execution Region</em>'.
	 * @see org.yakindu.sct.model.sexec.ExecutionRegion
	 * @generated
	 */
	EClass getExecutionRegion();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sexec.ExecutionEntry <em>Execution Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Execution Entry</em>'.
	 * @see org.yakindu.sct.model.sexec.ExecutionEntry
	 * @generated
	 */
	EClass getExecutionEntry();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sexec.ExecutionChoice <em>Execution Choice</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Execution Choice</em>'.
	 * @see org.yakindu.sct.model.sexec.ExecutionChoice
	 * @generated
	 */
	EClass getExecutionChoice();

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
	 * Returns the meta object for the attribute '{@link org.yakindu.sct.model.sexec.Reaction#isTransition <em>Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Transition</em>'.
	 * @see org.yakindu.sct.model.sexec.Reaction#isTransition()
	 * @see #getReaction()
	 * @generated
	 */
	EAttribute getReaction_Transition();

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
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sexec.MappedElement <em>Mapped Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapped Element</em>'.
	 * @see org.yakindu.sct.model.sexec.MappedElement
	 * @generated
	 */
	EClass getMappedElement();

	/**
	 * Returns the meta object for the reference '{@link org.yakindu.sct.model.sexec.MappedElement#getSourceElement <em>Source Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source Element</em>'.
	 * @see org.yakindu.sct.model.sexec.MappedElement#getSourceElement()
	 * @see #getMappedElement()
	 * @generated
	 */
	EReference getMappedElement_SourceElement();

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
	 * Returns the meta object for the reference list '{@link org.yakindu.sct.model.sexec.Check#getRefs <em>Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Refs</em>'.
	 * @see org.yakindu.sct.model.sexec.Check#getRefs()
	 * @see #getCheck()
	 * @generated
	 */
	EReference getCheck_Refs();

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
	 * Returns the meta object for the reference list '{@link org.yakindu.sct.model.sexec.Step#getCaller <em>Caller</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Caller</em>'.
	 * @see org.yakindu.sct.model.sexec.Step#getCaller()
	 * @see #getStep()
	 * @generated
	 */
	EReference getStep_Caller();

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
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sexec.ScheduleTimeEvent <em>Schedule Time Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Schedule Time Event</em>'.
	 * @see org.yakindu.sct.model.sexec.ScheduleTimeEvent
	 * @generated
	 */
	EClass getScheduleTimeEvent();

	/**
	 * Returns the meta object for the reference '{@link org.yakindu.sct.model.sexec.ScheduleTimeEvent#getTimeEvent <em>Time Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Time Event</em>'.
	 * @see org.yakindu.sct.model.sexec.ScheduleTimeEvent#getTimeEvent()
	 * @see #getScheduleTimeEvent()
	 * @generated
	 */
	EReference getScheduleTimeEvent_TimeEvent();

	/**
	 * Returns the meta object for the containment reference '{@link org.yakindu.sct.model.sexec.ScheduleTimeEvent#getTimeValue <em>Time Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Time Value</em>'.
	 * @see org.yakindu.sct.model.sexec.ScheduleTimeEvent#getTimeValue()
	 * @see #getScheduleTimeEvent()
	 * @generated
	 */
	EReference getScheduleTimeEvent_TimeValue();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sexec.UnscheduleTimeEvent <em>Unschedule Time Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unschedule Time Event</em>'.
	 * @see org.yakindu.sct.model.sexec.UnscheduleTimeEvent
	 * @generated
	 */
	EClass getUnscheduleTimeEvent();

	/**
	 * Returns the meta object for the reference '{@link org.yakindu.sct.model.sexec.UnscheduleTimeEvent#getTimeEvent <em>Time Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Time Event</em>'.
	 * @see org.yakindu.sct.model.sexec.UnscheduleTimeEvent#getTimeEvent()
	 * @see #getUnscheduleTimeEvent()
	 * @generated
	 */
	EReference getUnscheduleTimeEvent_TimeEvent();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sexec.StateSwitch <em>State Switch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State Switch</em>'.
	 * @see org.yakindu.sct.model.sexec.StateSwitch
	 * @generated
	 */
	EClass getStateSwitch();

	/**
	 * Returns the meta object for the containment reference list '{@link org.yakindu.sct.model.sexec.StateSwitch#getCases <em>Cases</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Cases</em>'.
	 * @see org.yakindu.sct.model.sexec.StateSwitch#getCases()
	 * @see #getStateSwitch()
	 * @generated
	 */
	EReference getStateSwitch_Cases();

	/**
	 * Returns the meta object for the attribute '{@link org.yakindu.sct.model.sexec.StateSwitch#getStateConfigurationIdx <em>State Configuration Idx</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>State Configuration Idx</em>'.
	 * @see org.yakindu.sct.model.sexec.StateSwitch#getStateConfigurationIdx()
	 * @see #getStateSwitch()
	 * @generated
	 */
	EAttribute getStateSwitch_StateConfigurationIdx();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sexec.StateCase <em>State Case</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State Case</em>'.
	 * @see org.yakindu.sct.model.sexec.StateCase
	 * @generated
	 */
	EClass getStateCase();

	/**
	 * Returns the meta object for the reference '{@link org.yakindu.sct.model.sexec.StateCase#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>State</em>'.
	 * @see org.yakindu.sct.model.sexec.StateCase#getState()
	 * @see #getStateCase()
	 * @generated
	 */
	EReference getStateCase_State();

	/**
	 * Returns the meta object for the containment reference '{@link org.yakindu.sct.model.sexec.StateCase#getStep <em>Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Step</em>'.
	 * @see org.yakindu.sct.model.sexec.StateCase#getStep()
	 * @see #getStateCase()
	 * @generated
	 */
	EReference getStateCase_Step();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sexec.Trace <em>Trace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Trace</em>'.
	 * @see org.yakindu.sct.model.sexec.Trace
	 * @generated
	 */
	EClass getTrace();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sexec.TraceNodeExecuted <em>Trace Node Executed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Trace Node Executed</em>'.
	 * @see org.yakindu.sct.model.sexec.TraceNodeExecuted
	 * @generated
	 */
	EClass getTraceNodeExecuted();

	/**
	 * Returns the meta object for the reference '{@link org.yakindu.sct.model.sexec.TraceNodeExecuted#getNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Node</em>'.
	 * @see org.yakindu.sct.model.sexec.TraceNodeExecuted#getNode()
	 * @see #getTraceNodeExecuted()
	 * @generated
	 */
	EReference getTraceNodeExecuted_Node();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sexec.ReactionFired <em>Reaction Fired</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reaction Fired</em>'.
	 * @see org.yakindu.sct.model.sexec.ReactionFired
	 * @generated
	 */
	EClass getReactionFired();

	/**
	 * Returns the meta object for the reference '{@link org.yakindu.sct.model.sexec.ReactionFired#getReaction <em>Reaction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Reaction</em>'.
	 * @see org.yakindu.sct.model.sexec.ReactionFired#getReaction()
	 * @see #getReactionFired()
	 * @generated
	 */
	EReference getReactionFired_Reaction();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sexec.TraceStateEntered <em>Trace State Entered</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Trace State Entered</em>'.
	 * @see org.yakindu.sct.model.sexec.TraceStateEntered
	 * @generated
	 */
	EClass getTraceStateEntered();

	/**
	 * Returns the meta object for the reference '{@link org.yakindu.sct.model.sexec.TraceStateEntered#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>State</em>'.
	 * @see org.yakindu.sct.model.sexec.TraceStateEntered#getState()
	 * @see #getTraceStateEntered()
	 * @generated
	 */
	EReference getTraceStateEntered_State();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sexec.TraceStateExited <em>Trace State Exited</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Trace State Exited</em>'.
	 * @see org.yakindu.sct.model.sexec.TraceStateExited
	 * @generated
	 */
	EClass getTraceStateExited();

	/**
	 * Returns the meta object for the reference '{@link org.yakindu.sct.model.sexec.TraceStateExited#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>State</em>'.
	 * @see org.yakindu.sct.model.sexec.TraceStateExited#getState()
	 * @see #getTraceStateExited()
	 * @generated
	 */
	EReference getTraceStateExited_State();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sexec.TraceRegionExited <em>Trace Region Exited</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Trace Region Exited</em>'.
	 * @see org.yakindu.sct.model.sexec.TraceRegionExited
	 * @generated
	 */
	EClass getTraceRegionExited();

	/**
	 * Returns the meta object for the reference '{@link org.yakindu.sct.model.sexec.TraceRegionExited#getRegion <em>Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Region</em>'.
	 * @see org.yakindu.sct.model.sexec.TraceRegionExited#getRegion()
	 * @see #getTraceRegionExited()
	 * @generated
	 */
	EReference getTraceRegionExited_Region();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sexec.TraceRegionEntered <em>Trace Region Entered</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Trace Region Entered</em>'.
	 * @see org.yakindu.sct.model.sexec.TraceRegionEntered
	 * @generated
	 */
	EClass getTraceRegionEntered();

	/**
	 * Returns the meta object for the reference '{@link org.yakindu.sct.model.sexec.TraceRegionEntered#getRegion <em>Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Region</em>'.
	 * @see org.yakindu.sct.model.sexec.TraceRegionEntered#getRegion()
	 * @see #getTraceRegionEntered()
	 * @generated
	 */
	EReference getTraceRegionEntered_Region();

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
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sexec.TimeEvent <em>Time Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Time Event</em>'.
	 * @see org.yakindu.sct.model.sexec.TimeEvent
	 * @generated
	 */
	EClass getTimeEvent();

	/**
	 * Returns the meta object for the attribute '{@link org.yakindu.sct.model.sexec.TimeEvent#isPeriodic <em>Periodic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Periodic</em>'.
	 * @see org.yakindu.sct.model.sexec.TimeEvent#isPeriodic()
	 * @see #getTimeEvent()
	 * @generated
	 */
	EAttribute getTimeEvent_Periodic();

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
		 * The meta object literal for the '<em><b>Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION_FLOW__NODES = eINSTANCE.getExecutionFlow_Nodes();

		/**
		 * The meta object literal for the '<em><b>Regions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION_FLOW__REGIONS = eINSTANCE.getExecutionFlow_Regions();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.sexec.impl.ExecutionNodeImpl <em>Execution Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sexec.impl.ExecutionNodeImpl
		 * @see org.yakindu.sct.model.sexec.impl.SexecPackageImpl#getExecutionNode()
		 * @generated
		 */
		EClass EXECUTION_NODE = eINSTANCE.getExecutionNode();

		/**
		 * The meta object literal for the '<em><b>Reactions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION_NODE__REACTIONS = eINSTANCE.getExecutionNode_Reactions();

		/**
		 * The meta object literal for the '<em><b>Simple Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXECUTION_NODE__SIMPLE_NAME = eINSTANCE.getExecutionNode_SimpleName();

		/**
		 * The meta object literal for the '<em><b>React Sequence</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION_NODE__REACT_SEQUENCE = eINSTANCE.getExecutionNode_ReactSequence();

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
		 * The meta object literal for the '<em><b>Entry Action</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION_STATE__ENTRY_ACTION = eINSTANCE.getExecutionState_EntryAction();

		/**
		 * The meta object literal for the '<em><b>Exit Action</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION_STATE__EXIT_ACTION = eINSTANCE.getExecutionState_ExitAction();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.sexec.impl.ExecutionScopeImpl <em>Execution Scope</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sexec.impl.ExecutionScopeImpl
		 * @see org.yakindu.sct.model.sexec.impl.SexecPackageImpl#getExecutionScope()
		 * @generated
		 */
		EClass EXECUTION_SCOPE = eINSTANCE.getExecutionScope();

		/**
		 * The meta object literal for the '<em><b>State Vector</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION_SCOPE__STATE_VECTOR = eINSTANCE.getExecutionScope_StateVector();

		/**
		 * The meta object literal for the '<em><b>Sub Scopes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION_SCOPE__SUB_SCOPES = eINSTANCE.getExecutionScope_SubScopes();

		/**
		 * The meta object literal for the '<em><b>Super Scope</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION_SCOPE__SUPER_SCOPE = eINSTANCE.getExecutionScope_SuperScope();

		/**
		 * The meta object literal for the '<em><b>Enter Sequence</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION_SCOPE__ENTER_SEQUENCE = eINSTANCE.getExecutionScope_EnterSequence();

		/**
		 * The meta object literal for the '<em><b>Exit Sequence</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION_SCOPE__EXIT_SEQUENCE = eINSTANCE.getExecutionScope_ExitSequence();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.sexec.impl.ExecutionRegionImpl <em>Execution Region</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sexec.impl.ExecutionRegionImpl
		 * @see org.yakindu.sct.model.sexec.impl.SexecPackageImpl#getExecutionRegion()
		 * @generated
		 */
		EClass EXECUTION_REGION = eINSTANCE.getExecutionRegion();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.sexec.impl.ExecutionEntryImpl <em>Execution Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sexec.impl.ExecutionEntryImpl
		 * @see org.yakindu.sct.model.sexec.impl.SexecPackageImpl#getExecutionEntry()
		 * @generated
		 */
		EClass EXECUTION_ENTRY = eINSTANCE.getExecutionEntry();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.sexec.impl.ExecutionChoiceImpl <em>Execution Choice</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sexec.impl.ExecutionChoiceImpl
		 * @see org.yakindu.sct.model.sexec.impl.SexecPackageImpl#getExecutionChoice()
		 * @generated
		 */
		EClass EXECUTION_CHOICE = eINSTANCE.getExecutionChoice();

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
		 * The meta object literal for the '<em><b>Transition</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REACTION__TRANSITION = eINSTANCE.getReaction_Transition();

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
		 * The meta object literal for the '{@link org.yakindu.sct.model.sexec.impl.MappedElementImpl <em>Mapped Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sexec.impl.MappedElementImpl
		 * @see org.yakindu.sct.model.sexec.impl.SexecPackageImpl#getMappedElement()
		 * @generated
		 */
		EClass MAPPED_ELEMENT = eINSTANCE.getMappedElement();

		/**
		 * The meta object literal for the '<em><b>Source Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPED_ELEMENT__SOURCE_ELEMENT = eINSTANCE.getMappedElement_SourceElement();

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
		 * The meta object literal for the '<em><b>Refs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHECK__REFS = eINSTANCE.getCheck_Refs();

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
		 * The meta object literal for the '<em><b>Caller</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STEP__CALLER = eINSTANCE.getStep_Caller();

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
		 * The meta object literal for the '{@link org.yakindu.sct.model.sexec.impl.ScheduleTimeEventImpl <em>Schedule Time Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sexec.impl.ScheduleTimeEventImpl
		 * @see org.yakindu.sct.model.sexec.impl.SexecPackageImpl#getScheduleTimeEvent()
		 * @generated
		 */
		EClass SCHEDULE_TIME_EVENT = eINSTANCE.getScheduleTimeEvent();

		/**
		 * The meta object literal for the '<em><b>Time Event</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULE_TIME_EVENT__TIME_EVENT = eINSTANCE.getScheduleTimeEvent_TimeEvent();

		/**
		 * The meta object literal for the '<em><b>Time Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULE_TIME_EVENT__TIME_VALUE = eINSTANCE.getScheduleTimeEvent_TimeValue();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.sexec.impl.UnscheduleTimeEventImpl <em>Unschedule Time Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sexec.impl.UnscheduleTimeEventImpl
		 * @see org.yakindu.sct.model.sexec.impl.SexecPackageImpl#getUnscheduleTimeEvent()
		 * @generated
		 */
		EClass UNSCHEDULE_TIME_EVENT = eINSTANCE.getUnscheduleTimeEvent();

		/**
		 * The meta object literal for the '<em><b>Time Event</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNSCHEDULE_TIME_EVENT__TIME_EVENT = eINSTANCE.getUnscheduleTimeEvent_TimeEvent();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.sexec.impl.StateSwitchImpl <em>State Switch</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sexec.impl.StateSwitchImpl
		 * @see org.yakindu.sct.model.sexec.impl.SexecPackageImpl#getStateSwitch()
		 * @generated
		 */
		EClass STATE_SWITCH = eINSTANCE.getStateSwitch();

		/**
		 * The meta object literal for the '<em><b>Cases</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE_SWITCH__CASES = eINSTANCE.getStateSwitch_Cases();

		/**
		 * The meta object literal for the '<em><b>State Configuration Idx</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATE_SWITCH__STATE_CONFIGURATION_IDX = eINSTANCE.getStateSwitch_StateConfigurationIdx();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.sexec.impl.StateCaseImpl <em>State Case</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sexec.impl.StateCaseImpl
		 * @see org.yakindu.sct.model.sexec.impl.SexecPackageImpl#getStateCase()
		 * @generated
		 */
		EClass STATE_CASE = eINSTANCE.getStateCase();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE_CASE__STATE = eINSTANCE.getStateCase_State();

		/**
		 * The meta object literal for the '<em><b>Step</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE_CASE__STEP = eINSTANCE.getStateCase_Step();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.sexec.impl.TraceImpl <em>Trace</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sexec.impl.TraceImpl
		 * @see org.yakindu.sct.model.sexec.impl.SexecPackageImpl#getTrace()
		 * @generated
		 */
		EClass TRACE = eINSTANCE.getTrace();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.sexec.impl.TraceNodeExecutedImpl <em>Trace Node Executed</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sexec.impl.TraceNodeExecutedImpl
		 * @see org.yakindu.sct.model.sexec.impl.SexecPackageImpl#getTraceNodeExecuted()
		 * @generated
		 */
		EClass TRACE_NODE_EXECUTED = eINSTANCE.getTraceNodeExecuted();

		/**
		 * The meta object literal for the '<em><b>Node</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE_NODE_EXECUTED__NODE = eINSTANCE.getTraceNodeExecuted_Node();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.sexec.impl.ReactionFiredImpl <em>Reaction Fired</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sexec.impl.ReactionFiredImpl
		 * @see org.yakindu.sct.model.sexec.impl.SexecPackageImpl#getReactionFired()
		 * @generated
		 */
		EClass REACTION_FIRED = eINSTANCE.getReactionFired();

		/**
		 * The meta object literal for the '<em><b>Reaction</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REACTION_FIRED__REACTION = eINSTANCE.getReactionFired_Reaction();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.sexec.impl.TraceStateEnteredImpl <em>Trace State Entered</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sexec.impl.TraceStateEnteredImpl
		 * @see org.yakindu.sct.model.sexec.impl.SexecPackageImpl#getTraceStateEntered()
		 * @generated
		 */
		EClass TRACE_STATE_ENTERED = eINSTANCE.getTraceStateEntered();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE_STATE_ENTERED__STATE = eINSTANCE.getTraceStateEntered_State();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.sexec.impl.TraceStateExitedImpl <em>Trace State Exited</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sexec.impl.TraceStateExitedImpl
		 * @see org.yakindu.sct.model.sexec.impl.SexecPackageImpl#getTraceStateExited()
		 * @generated
		 */
		EClass TRACE_STATE_EXITED = eINSTANCE.getTraceStateExited();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE_STATE_EXITED__STATE = eINSTANCE.getTraceStateExited_State();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.sexec.impl.TraceRegionExitedImpl <em>Trace Region Exited</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sexec.impl.TraceRegionExitedImpl
		 * @see org.yakindu.sct.model.sexec.impl.SexecPackageImpl#getTraceRegionExited()
		 * @generated
		 */
		EClass TRACE_REGION_EXITED = eINSTANCE.getTraceRegionExited();

		/**
		 * The meta object literal for the '<em><b>Region</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE_REGION_EXITED__REGION = eINSTANCE.getTraceRegionExited_Region();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.sexec.impl.TraceRegionEnteredImpl <em>Trace Region Entered</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sexec.impl.TraceRegionEnteredImpl
		 * @see org.yakindu.sct.model.sexec.impl.SexecPackageImpl#getTraceRegionEntered()
		 * @generated
		 */
		EClass TRACE_REGION_ENTERED = eINSTANCE.getTraceRegionEntered();

		/**
		 * The meta object literal for the '<em><b>Region</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE_REGION_ENTERED__REGION = eINSTANCE.getTraceRegionEntered_Region();

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

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.sexec.impl.TimeEventImpl <em>Time Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sexec.impl.TimeEventImpl
		 * @see org.yakindu.sct.model.sexec.impl.SexecPackageImpl#getTimeEvent()
		 * @generated
		 */
		EClass TIME_EVENT = eINSTANCE.getTimeEvent();

		/**
		 * The meta object literal for the '<em><b>Periodic</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TIME_EVENT__PERIODIC = eINSTANCE.getTimeEvent_Periodic();

	}

} //SexecPackage
