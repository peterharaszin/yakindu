/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.model.sgraph;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see org.yakindu.sct.model.sgraph.SGraphFactory
 * @model kind="package"
 * @generated
 */
public interface SGraphPackage extends EPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2011 committers of YAKINDU and others.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\nContributors:\r\ncommitters of YAKINDU - initial API and implementation\r\n";

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "sgraph";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.yakindu.org/sct/sgraph/2.0.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "sgraph";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SGraphPackage eINSTANCE = org.yakindu.sct.model.sgraph.impl.SGraphPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sgraph.impl.NamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sgraph.impl.NamedElementImpl
	 * @see org.yakindu.sct.model.sgraph.impl.SGraphPackageImpl#getNamedElement()
	 * @generated
	 */
	int NAMED_ELEMENT = 2;

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
	 * The meta object id for the '{@link org.yakindu.sct.model.sgraph.impl.VertexImpl <em>Vertex</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sgraph.impl.VertexImpl
	 * @see org.yakindu.sct.model.sgraph.impl.SGraphPackageImpl#getVertex()
	 * @generated
	 */
	int VERTEX = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTEX__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Parent Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTEX__PARENT_REGION = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Incoming Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTEX__INCOMING_TRANSITIONS = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Outgoing Transitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTEX__OUTGOING_TRANSITIONS = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Vertex</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTEX_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sgraph.impl.PseudostateImpl <em>Pseudostate</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sgraph.impl.PseudostateImpl
	 * @see org.yakindu.sct.model.sgraph.impl.SGraphPackageImpl#getPseudostate()
	 * @generated
	 */
	int PSEUDOSTATE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSEUDOSTATE__NAME = VERTEX__NAME;

	/**
	 * The feature id for the '<em><b>Parent Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSEUDOSTATE__PARENT_REGION = VERTEX__PARENT_REGION;

	/**
	 * The feature id for the '<em><b>Incoming Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSEUDOSTATE__INCOMING_TRANSITIONS = VERTEX__INCOMING_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing Transitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSEUDOSTATE__OUTGOING_TRANSITIONS = VERTEX__OUTGOING_TRANSITIONS;

	/**
	 * The number of structural features of the '<em>Pseudostate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSEUDOSTATE_FEATURE_COUNT = VERTEX_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sgraph.impl.RegionImpl <em>Region</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sgraph.impl.RegionImpl
	 * @see org.yakindu.sct.model.sgraph.impl.SGraphPackageImpl#getRegion()
	 * @generated
	 */
	int REGION = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Vertices</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION__VERTICES = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION__PRIORITY = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Composite</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION__COMPOSITE = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Region</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sgraph.impl.ExpressionElementImpl <em>Expression Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sgraph.impl.ExpressionElementImpl
	 * @see org.yakindu.sct.model.sgraph.impl.SGraphPackageImpl#getExpressionElement()
	 * @generated
	 */
	int EXPRESSION_ELEMENT = 13;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_ELEMENT__EXPRESSION = 0;

	/**
	 * The number of structural features of the '<em>Expression Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sgraph.impl.TransitionImpl <em>Transition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sgraph.impl.TransitionImpl
	 * @see org.yakindu.sct.model.sgraph.impl.SGraphPackageImpl#getTransition()
	 * @generated
	 */
	int TRANSITION = 4;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__EXPRESSION = EXPRESSION_ELEMENT__EXPRESSION;

	/**
	 * The feature id for the '<em><b>Trigger</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__TRIGGER = EXPRESSION_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Effect</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__EFFECT = EXPRESSION_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__TARGET = EXPRESSION_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Source</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__SOURCE = EXPRESSION_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__PRIORITY = EXPRESSION_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_FEATURE_COUNT = EXPRESSION_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sgraph.impl.RegularStateImpl <em>Regular State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sgraph.impl.RegularStateImpl
	 * @see org.yakindu.sct.model.sgraph.impl.SGraphPackageImpl#getRegularState()
	 * @generated
	 */
	int REGULAR_STATE = 23;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGULAR_STATE__NAME = VERTEX__NAME;

	/**
	 * The feature id for the '<em><b>Parent Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGULAR_STATE__PARENT_REGION = VERTEX__PARENT_REGION;

	/**
	 * The feature id for the '<em><b>Incoming Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGULAR_STATE__INCOMING_TRANSITIONS = VERTEX__INCOMING_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing Transitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGULAR_STATE__OUTGOING_TRANSITIONS = VERTEX__OUTGOING_TRANSITIONS;

	/**
	 * The number of structural features of the '<em>Regular State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGULAR_STATE_FEATURE_COUNT = VERTEX_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sgraph.impl.StateImpl <em>State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sgraph.impl.StateImpl
	 * @see org.yakindu.sct.model.sgraph.impl.SGraphPackageImpl#getState()
	 * @generated
	 */
	int STATE = 21;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sgraph.impl.FinalStateImpl <em>Final State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sgraph.impl.FinalStateImpl
	 * @see org.yakindu.sct.model.sgraph.impl.SGraphPackageImpl#getFinalState()
	 * @generated
	 */
	int FINAL_STATE = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE__NAME = REGULAR_STATE__NAME;

	/**
	 * The feature id for the '<em><b>Parent Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE__PARENT_REGION = REGULAR_STATE__PARENT_REGION;

	/**
	 * The feature id for the '<em><b>Incoming Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE__INCOMING_TRANSITIONS = REGULAR_STATE__INCOMING_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing Transitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE__OUTGOING_TRANSITIONS = REGULAR_STATE__OUTGOING_TRANSITIONS;

	/**
	 * The number of structural features of the '<em>Final State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE_FEATURE_COUNT = REGULAR_STATE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sgraph.impl.DeclarationImpl <em>Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sgraph.impl.DeclarationImpl
	 * @see org.yakindu.sct.model.sgraph.impl.SGraphPackageImpl#getDeclaration()
	 * @generated
	 */
	int DECLARATION = 14;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECLARATION__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECLARATION_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sgraph.impl.VariableImpl <em>Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sgraph.impl.VariableImpl
	 * @see org.yakindu.sct.model.sgraph.impl.SGraphPackageImpl#getVariable()
	 * @generated
	 */
	int VARIABLE = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__NAME = DECLARATION__NAME;

	/**
	 * The number of structural features of the '<em>Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_FEATURE_COUNT = DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sgraph.impl.EventImpl <em>Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sgraph.impl.EventImpl
	 * @see org.yakindu.sct.model.sgraph.impl.SGraphPackageImpl#getEvent()
	 * @generated
	 */
	int EVENT = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__NAME = DECLARATION__NAME;

	/**
	 * The number of structural features of the '<em>Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_FEATURE_COUNT = DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sgraph.impl.ChoiceImpl <em>Choice</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sgraph.impl.ChoiceImpl
	 * @see org.yakindu.sct.model.sgraph.impl.SGraphPackageImpl#getChoice()
	 * @generated
	 */
	int CHOICE = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE__NAME = PSEUDOSTATE__NAME;

	/**
	 * The feature id for the '<em><b>Parent Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE__PARENT_REGION = PSEUDOSTATE__PARENT_REGION;

	/**
	 * The feature id for the '<em><b>Incoming Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE__INCOMING_TRANSITIONS = PSEUDOSTATE__INCOMING_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing Transitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE__OUTGOING_TRANSITIONS = PSEUDOSTATE__OUTGOING_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE__KIND = PSEUDOSTATE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Choice</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_FEATURE_COUNT = PSEUDOSTATE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sgraph.impl.StatechartImpl <em>Statechart</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sgraph.impl.StatechartImpl
	 * @see org.yakindu.sct.model.sgraph.impl.SGraphPackageImpl#getStatechart()
	 * @generated
	 */
	int STATECHART = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATECHART__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATECHART__EXPRESSION = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Reactions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATECHART__REACTIONS = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Local Reactions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATECHART__LOCAL_REACTIONS = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Scopes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATECHART__SCOPES = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATECHART__NAMESPACE = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Regions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATECHART__REGIONS = NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Statechart</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATECHART_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sgraph.impl.EntryImpl <em>Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sgraph.impl.EntryImpl
	 * @see org.yakindu.sct.model.sgraph.impl.SGraphPackageImpl#getEntry()
	 * @generated
	 */
	int ENTRY = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY__NAME = PSEUDOSTATE__NAME;

	/**
	 * The feature id for the '<em><b>Parent Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY__PARENT_REGION = PSEUDOSTATE__PARENT_REGION;

	/**
	 * The feature id for the '<em><b>Incoming Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY__INCOMING_TRANSITIONS = PSEUDOSTATE__INCOMING_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing Transitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY__OUTGOING_TRANSITIONS = PSEUDOSTATE__OUTGOING_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY__KIND = PSEUDOSTATE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_FEATURE_COUNT = PSEUDOSTATE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sgraph.impl.TriggerImpl <em>Trigger</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sgraph.impl.TriggerImpl
	 * @see org.yakindu.sct.model.sgraph.impl.SGraphPackageImpl#getTrigger()
	 * @generated
	 */
	int TRIGGER = 11;

	/**
	 * The number of structural features of the '<em>Trigger</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGER_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sgraph.impl.EffectImpl <em>Effect</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sgraph.impl.EffectImpl
	 * @see org.yakindu.sct.model.sgraph.impl.SGraphPackageImpl#getEffect()
	 * @generated
	 */
	int EFFECT = 12;

	/**
	 * The number of structural features of the '<em>Effect</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFFECT_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sgraph.impl.ReactionImpl <em>Reaction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sgraph.impl.ReactionImpl
	 * @see org.yakindu.sct.model.sgraph.impl.SGraphPackageImpl#getReaction()
	 * @generated
	 */
	int REACTION = 15;

	/**
	 * The feature id for the '<em><b>Trigger</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REACTION__TRIGGER = 0;

	/**
	 * The feature id for the '<em><b>Effect</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REACTION__EFFECT = 1;

	/**
	 * The number of structural features of the '<em>Reaction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REACTION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sgraph.impl.ReactiveElementImpl <em>Reactive Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sgraph.impl.ReactiveElementImpl
	 * @see org.yakindu.sct.model.sgraph.impl.SGraphPackageImpl#getReactiveElement()
	 * @generated
	 */
	int REACTIVE_ELEMENT = 16;

	/**
	 * The feature id for the '<em><b>Reactions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REACTIVE_ELEMENT__REACTIONS = 0;

	/**
	 * The feature id for the '<em><b>Local Reactions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REACTIVE_ELEMENT__LOCAL_REACTIONS = 1;

	/**
	 * The number of structural features of the '<em>Reactive Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REACTIVE_ELEMENT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sgraph.impl.ExitImpl <em>Exit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sgraph.impl.ExitImpl
	 * @see org.yakindu.sct.model.sgraph.impl.SGraphPackageImpl#getExit()
	 * @generated
	 */
	int EXIT = 17;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXIT__NAME = PSEUDOSTATE__NAME;

	/**
	 * The feature id for the '<em><b>Parent Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXIT__PARENT_REGION = PSEUDOSTATE__PARENT_REGION;

	/**
	 * The feature id for the '<em><b>Incoming Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXIT__INCOMING_TRANSITIONS = PSEUDOSTATE__INCOMING_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing Transitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXIT__OUTGOING_TRANSITIONS = PSEUDOSTATE__OUTGOING_TRANSITIONS;

	/**
	 * The number of structural features of the '<em>Exit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXIT_FEATURE_COUNT = PSEUDOSTATE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sgraph.impl.ScopeImpl <em>Scope</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sgraph.impl.ScopeImpl
	 * @see org.yakindu.sct.model.sgraph.impl.SGraphPackageImpl#getScope()
	 * @generated
	 */
	int SCOPE = 18;

	/**
	 * The feature id for the '<em><b>Declarations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPE__DECLARATIONS = 0;

	/**
	 * The feature id for the '<em><b>Events</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPE__EVENTS = 1;

	/**
	 * The feature id for the '<em><b>Variables</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPE__VARIABLES = 2;

	/**
	 * The number of structural features of the '<em>Scope</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sgraph.impl.ScopedElementImpl <em>Scoped Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sgraph.impl.ScopedElementImpl
	 * @see org.yakindu.sct.model.sgraph.impl.SGraphPackageImpl#getScopedElement()
	 * @generated
	 */
	int SCOPED_ELEMENT = 19;

	/**
	 * The feature id for the '<em><b>Scopes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPED_ELEMENT__SCOPES = 0;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPED_ELEMENT__NAMESPACE = 1;

	/**
	 * The number of structural features of the '<em>Scoped Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPED_ELEMENT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sgraph.impl.SynchronizationImpl <em>Synchronization</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sgraph.impl.SynchronizationImpl
	 * @see org.yakindu.sct.model.sgraph.impl.SGraphPackageImpl#getSynchronization()
	 * @generated
	 */
	int SYNCHRONIZATION = 20;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNCHRONIZATION__NAME = PSEUDOSTATE__NAME;

	/**
	 * The feature id for the '<em><b>Parent Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNCHRONIZATION__PARENT_REGION = PSEUDOSTATE__PARENT_REGION;

	/**
	 * The feature id for the '<em><b>Incoming Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNCHRONIZATION__INCOMING_TRANSITIONS = PSEUDOSTATE__INCOMING_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing Transitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNCHRONIZATION__OUTGOING_TRANSITIONS = PSEUDOSTATE__OUTGOING_TRANSITIONS;

	/**
	 * The number of structural features of the '<em>Synchronization</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNCHRONIZATION_FEATURE_COUNT = PSEUDOSTATE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__EXPRESSION = EXPRESSION_ELEMENT__EXPRESSION;

	/**
	 * The feature id for the '<em><b>Reactions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__REACTIONS = EXPRESSION_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Local Reactions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__LOCAL_REACTIONS = EXPRESSION_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Scopes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__SCOPES = EXPRESSION_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__NAMESPACE = EXPRESSION_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__NAME = EXPRESSION_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Parent Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__PARENT_REGION = EXPRESSION_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Incoming Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__INCOMING_TRANSITIONS = EXPRESSION_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Outgoing Transitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__OUTGOING_TRANSITIONS = EXPRESSION_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Regions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__REGIONS = EXPRESSION_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Orthogonal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__ORTHOGONAL = EXPRESSION_ELEMENT_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Substatechart</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__SUBSTATECHART = EXPRESSION_ELEMENT_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Substatechart Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__SUBSTATECHART_ID = EXPRESSION_ELEMENT_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Subchart</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__SUBCHART = EXPRESSION_ELEMENT_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Simple</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__SIMPLE = EXPRESSION_ELEMENT_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Composite</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__COMPOSITE = EXPRESSION_ELEMENT_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>Leaf</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__LEAF = EXPRESSION_ELEMENT_FEATURE_COUNT + 15;

	/**
	 * The number of structural features of the '<em>State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_FEATURE_COUNT = EXPRESSION_ELEMENT_FEATURE_COUNT + 16;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sgraph.impl.StatementImpl <em>Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sgraph.impl.StatementImpl
	 * @see org.yakindu.sct.model.sgraph.impl.SGraphPackageImpl#getStatement()
	 * @generated
	 */
	int STATEMENT = 22;

	/**
	 * The number of structural features of the '<em>Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sgraph.impl.CompositeElementImpl <em>Composite Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sgraph.impl.CompositeElementImpl
	 * @see org.yakindu.sct.model.sgraph.impl.SGraphPackageImpl#getCompositeElement()
	 * @generated
	 */
	int COMPOSITE_ELEMENT = 24;

	/**
	 * The feature id for the '<em><b>Regions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_ELEMENT__REGIONS = 0;

	/**
	 * The number of structural features of the '<em>Composite Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sgraph.EntryKind <em>Entry Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sgraph.EntryKind
	 * @see org.yakindu.sct.model.sgraph.impl.SGraphPackageImpl#getEntryKind()
	 * @generated
	 */
	int ENTRY_KIND = 25;


	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sgraph.ChoiceKind <em>Choice Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sgraph.ChoiceKind
	 * @see org.yakindu.sct.model.sgraph.impl.SGraphPackageImpl#getChoiceKind()
	 * @generated
	 */
	int CHOICE_KIND = 26;


	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sgraph.Pseudostate <em>Pseudostate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pseudostate</em>'.
	 * @see org.yakindu.sct.model.sgraph.Pseudostate
	 * @generated
	 */
	EClass getPseudostate();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sgraph.Vertex <em>Vertex</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Vertex</em>'.
	 * @see org.yakindu.sct.model.sgraph.Vertex
	 * @generated
	 */
	EClass getVertex();

	/**
	 * Returns the meta object for the container reference '{@link org.yakindu.sct.model.sgraph.Vertex#getParentRegion <em>Parent Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent Region</em>'.
	 * @see org.yakindu.sct.model.sgraph.Vertex#getParentRegion()
	 * @see #getVertex()
	 * @generated
	 */
	EReference getVertex_ParentRegion();

	/**
	 * Returns the meta object for the reference list '{@link org.yakindu.sct.model.sgraph.Vertex#getIncomingTransitions <em>Incoming Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Incoming Transitions</em>'.
	 * @see org.yakindu.sct.model.sgraph.Vertex#getIncomingTransitions()
	 * @see #getVertex()
	 * @generated
	 */
	EReference getVertex_IncomingTransitions();

	/**
	 * Returns the meta object for the containment reference list '{@link org.yakindu.sct.model.sgraph.Vertex#getOutgoingTransitions <em>Outgoing Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Outgoing Transitions</em>'.
	 * @see org.yakindu.sct.model.sgraph.Vertex#getOutgoingTransitions()
	 * @see #getVertex()
	 * @generated
	 */
	EReference getVertex_OutgoingTransitions();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sgraph.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see org.yakindu.sct.model.sgraph.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link org.yakindu.sct.model.sgraph.NamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.yakindu.sct.model.sgraph.NamedElement#getName()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Name();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sgraph.Region <em>Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Region</em>'.
	 * @see org.yakindu.sct.model.sgraph.Region
	 * @generated
	 */
	EClass getRegion();

	/**
	 * Returns the meta object for the containment reference list '{@link org.yakindu.sct.model.sgraph.Region#getVertices <em>Vertices</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Vertices</em>'.
	 * @see org.yakindu.sct.model.sgraph.Region#getVertices()
	 * @see #getRegion()
	 * @generated
	 */
	EReference getRegion_Vertices();

	/**
	 * Returns the meta object for the attribute '{@link org.yakindu.sct.model.sgraph.Region#getPriority <em>Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Priority</em>'.
	 * @see org.yakindu.sct.model.sgraph.Region#getPriority()
	 * @see #getRegion()
	 * @generated
	 */
	EAttribute getRegion_Priority();

	/**
	 * Returns the meta object for the container reference '{@link org.yakindu.sct.model.sgraph.Region#getComposite <em>Composite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Composite</em>'.
	 * @see org.yakindu.sct.model.sgraph.Region#getComposite()
	 * @see #getRegion()
	 * @generated
	 */
	EReference getRegion_Composite();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sgraph.Transition <em>Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transition</em>'.
	 * @see org.yakindu.sct.model.sgraph.Transition
	 * @generated
	 */
	EClass getTransition();

	/**
	 * Returns the meta object for the reference '{@link org.yakindu.sct.model.sgraph.Transition#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.yakindu.sct.model.sgraph.Transition#getTarget()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_Target();

	/**
	 * Returns the meta object for the container reference '{@link org.yakindu.sct.model.sgraph.Transition#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Source</em>'.
	 * @see org.yakindu.sct.model.sgraph.Transition#getSource()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_Source();

	/**
	 * Returns the meta object for the attribute '{@link org.yakindu.sct.model.sgraph.Transition#getPriority <em>Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Priority</em>'.
	 * @see org.yakindu.sct.model.sgraph.Transition#getPriority()
	 * @see #getTransition()
	 * @generated
	 */
	EAttribute getTransition_Priority();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sgraph.FinalState <em>Final State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Final State</em>'.
	 * @see org.yakindu.sct.model.sgraph.FinalState
	 * @generated
	 */
	EClass getFinalState();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sgraph.State <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State</em>'.
	 * @see org.yakindu.sct.model.sgraph.State
	 * @generated
	 */
	EClass getState();

	/**
	 * Returns the meta object for the attribute '{@link org.yakindu.sct.model.sgraph.State#isOrthogonal <em>Orthogonal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Orthogonal</em>'.
	 * @see org.yakindu.sct.model.sgraph.State#isOrthogonal()
	 * @see #getState()
	 * @generated
	 */
	EAttribute getState_Orthogonal();

	/**
	 * Returns the meta object for the reference '{@link org.yakindu.sct.model.sgraph.State#getSubstatechart <em>Substatechart</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Substatechart</em>'.
	 * @see org.yakindu.sct.model.sgraph.State#getSubstatechart()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_Substatechart();

	/**
	 * Returns the meta object for the attribute '{@link org.yakindu.sct.model.sgraph.State#getSubstatechartId <em>Substatechart Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Substatechart Id</em>'.
	 * @see org.yakindu.sct.model.sgraph.State#getSubstatechartId()
	 * @see #getState()
	 * @generated
	 */
	EAttribute getState_SubstatechartId();

	/**
	 * Returns the meta object for the attribute '{@link org.yakindu.sct.model.sgraph.State#isSubchart <em>Subchart</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Subchart</em>'.
	 * @see org.yakindu.sct.model.sgraph.State#isSubchart()
	 * @see #getState()
	 * @generated
	 */
	EAttribute getState_Subchart();

	/**
	 * Returns the meta object for the attribute '{@link org.yakindu.sct.model.sgraph.State#isSimple <em>Simple</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Simple</em>'.
	 * @see org.yakindu.sct.model.sgraph.State#isSimple()
	 * @see #getState()
	 * @generated
	 */
	EAttribute getState_Simple();

	/**
	 * Returns the meta object for the attribute '{@link org.yakindu.sct.model.sgraph.State#isComposite <em>Composite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Composite</em>'.
	 * @see org.yakindu.sct.model.sgraph.State#isComposite()
	 * @see #getState()
	 * @generated
	 */
	EAttribute getState_Composite();

	/**
	 * Returns the meta object for the attribute '{@link org.yakindu.sct.model.sgraph.State#isLeaf <em>Leaf</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Leaf</em>'.
	 * @see org.yakindu.sct.model.sgraph.State#isLeaf()
	 * @see #getState()
	 * @generated
	 */
	EAttribute getState_Leaf();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sgraph.Statement <em>Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Statement</em>'.
	 * @see org.yakindu.sct.model.sgraph.Statement
	 * @generated
	 */
	EClass getStatement();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sgraph.RegularState <em>Regular State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Regular State</em>'.
	 * @see org.yakindu.sct.model.sgraph.RegularState
	 * @generated
	 */
	EClass getRegularState();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sgraph.CompositeElement <em>Composite Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite Element</em>'.
	 * @see org.yakindu.sct.model.sgraph.CompositeElement
	 * @generated
	 */
	EClass getCompositeElement();

	/**
	 * Returns the meta object for the containment reference list '{@link org.yakindu.sct.model.sgraph.CompositeElement#getRegions <em>Regions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Regions</em>'.
	 * @see org.yakindu.sct.model.sgraph.CompositeElement#getRegions()
	 * @see #getCompositeElement()
	 * @generated
	 */
	EReference getCompositeElement_Regions();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sgraph.Variable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable</em>'.
	 * @see org.yakindu.sct.model.sgraph.Variable
	 * @generated
	 */
	EClass getVariable();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sgraph.Event <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event</em>'.
	 * @see org.yakindu.sct.model.sgraph.Event
	 * @generated
	 */
	EClass getEvent();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sgraph.Choice <em>Choice</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Choice</em>'.
	 * @see org.yakindu.sct.model.sgraph.Choice
	 * @generated
	 */
	EClass getChoice();

	/**
	 * Returns the meta object for the attribute '{@link org.yakindu.sct.model.sgraph.Choice#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.yakindu.sct.model.sgraph.Choice#getKind()
	 * @see #getChoice()
	 * @generated
	 */
	EAttribute getChoice_Kind();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sgraph.Statechart <em>Statechart</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Statechart</em>'.
	 * @see org.yakindu.sct.model.sgraph.Statechart
	 * @generated
	 */
	EClass getStatechart();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sgraph.Entry <em>Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entry</em>'.
	 * @see org.yakindu.sct.model.sgraph.Entry
	 * @generated
	 */
	EClass getEntry();

	/**
	 * Returns the meta object for the attribute '{@link org.yakindu.sct.model.sgraph.Entry#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.yakindu.sct.model.sgraph.Entry#getKind()
	 * @see #getEntry()
	 * @generated
	 */
	EAttribute getEntry_Kind();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sgraph.Trigger <em>Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Trigger</em>'.
	 * @see org.yakindu.sct.model.sgraph.Trigger
	 * @generated
	 */
	EClass getTrigger();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sgraph.Effect <em>Effect</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Effect</em>'.
	 * @see org.yakindu.sct.model.sgraph.Effect
	 * @generated
	 */
	EClass getEffect();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sgraph.ExpressionElement <em>Expression Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression Element</em>'.
	 * @see org.yakindu.sct.model.sgraph.ExpressionElement
	 * @generated
	 */
	EClass getExpressionElement();

	/**
	 * Returns the meta object for the attribute '{@link org.yakindu.sct.model.sgraph.ExpressionElement#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expression</em>'.
	 * @see org.yakindu.sct.model.sgraph.ExpressionElement#getExpression()
	 * @see #getExpressionElement()
	 * @generated
	 */
	EAttribute getExpressionElement_Expression();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sgraph.Declaration <em>Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Declaration</em>'.
	 * @see org.yakindu.sct.model.sgraph.Declaration
	 * @generated
	 */
	EClass getDeclaration();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sgraph.Reaction <em>Reaction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reaction</em>'.
	 * @see org.yakindu.sct.model.sgraph.Reaction
	 * @generated
	 */
	EClass getReaction();

	/**
	 * Returns the meta object for the containment reference '{@link org.yakindu.sct.model.sgraph.Reaction#getTrigger <em>Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Trigger</em>'.
	 * @see org.yakindu.sct.model.sgraph.Reaction#getTrigger()
	 * @see #getReaction()
	 * @generated
	 */
	EReference getReaction_Trigger();

	/**
	 * Returns the meta object for the containment reference '{@link org.yakindu.sct.model.sgraph.Reaction#getEffect <em>Effect</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Effect</em>'.
	 * @see org.yakindu.sct.model.sgraph.Reaction#getEffect()
	 * @see #getReaction()
	 * @generated
	 */
	EReference getReaction_Effect();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sgraph.ReactiveElement <em>Reactive Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reactive Element</em>'.
	 * @see org.yakindu.sct.model.sgraph.ReactiveElement
	 * @generated
	 */
	EClass getReactiveElement();

	/**
	 * Returns the meta object for the reference list '{@link org.yakindu.sct.model.sgraph.ReactiveElement#getReactions <em>Reactions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Reactions</em>'.
	 * @see org.yakindu.sct.model.sgraph.ReactiveElement#getReactions()
	 * @see #getReactiveElement()
	 * @generated
	 */
	EReference getReactiveElement_Reactions();

	/**
	 * Returns the meta object for the reference list '{@link org.yakindu.sct.model.sgraph.ReactiveElement#getLocalReactions <em>Local Reactions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Local Reactions</em>'.
	 * @see org.yakindu.sct.model.sgraph.ReactiveElement#getLocalReactions()
	 * @see #getReactiveElement()
	 * @generated
	 */
	EReference getReactiveElement_LocalReactions();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sgraph.Exit <em>Exit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Exit</em>'.
	 * @see org.yakindu.sct.model.sgraph.Exit
	 * @generated
	 */
	EClass getExit();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sgraph.Scope <em>Scope</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scope</em>'.
	 * @see org.yakindu.sct.model.sgraph.Scope
	 * @generated
	 */
	EClass getScope();

	/**
	 * Returns the meta object for the containment reference list '{@link org.yakindu.sct.model.sgraph.Scope#getDeclarations <em>Declarations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Declarations</em>'.
	 * @see org.yakindu.sct.model.sgraph.Scope#getDeclarations()
	 * @see #getScope()
	 * @generated
	 */
	EReference getScope_Declarations();

	/**
	 * Returns the meta object for the reference list '{@link org.yakindu.sct.model.sgraph.Scope#getEvents <em>Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Events</em>'.
	 * @see org.yakindu.sct.model.sgraph.Scope#getEvents()
	 * @see #getScope()
	 * @generated
	 */
	EReference getScope_Events();

	/**
	 * Returns the meta object for the reference list '{@link org.yakindu.sct.model.sgraph.Scope#getVariables <em>Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Variables</em>'.
	 * @see org.yakindu.sct.model.sgraph.Scope#getVariables()
	 * @see #getScope()
	 * @generated
	 */
	EReference getScope_Variables();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sgraph.ScopedElement <em>Scoped Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scoped Element</em>'.
	 * @see org.yakindu.sct.model.sgraph.ScopedElement
	 * @generated
	 */
	EClass getScopedElement();

	/**
	 * Returns the meta object for the containment reference list '{@link org.yakindu.sct.model.sgraph.ScopedElement#getScopes <em>Scopes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Scopes</em>'.
	 * @see org.yakindu.sct.model.sgraph.ScopedElement#getScopes()
	 * @see #getScopedElement()
	 * @generated
	 */
	EReference getScopedElement_Scopes();

	/**
	 * Returns the meta object for the attribute '{@link org.yakindu.sct.model.sgraph.ScopedElement#getNamespace <em>Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Namespace</em>'.
	 * @see org.yakindu.sct.model.sgraph.ScopedElement#getNamespace()
	 * @see #getScopedElement()
	 * @generated
	 */
	EAttribute getScopedElement_Namespace();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sgraph.Synchronization <em>Synchronization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Synchronization</em>'.
	 * @see org.yakindu.sct.model.sgraph.Synchronization
	 * @generated
	 */
	EClass getSynchronization();

	/**
	 * Returns the meta object for enum '{@link org.yakindu.sct.model.sgraph.EntryKind <em>Entry Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Entry Kind</em>'.
	 * @see org.yakindu.sct.model.sgraph.EntryKind
	 * @generated
	 */
	EEnum getEntryKind();

	/**
	 * Returns the meta object for enum '{@link org.yakindu.sct.model.sgraph.ChoiceKind <em>Choice Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Choice Kind</em>'.
	 * @see org.yakindu.sct.model.sgraph.ChoiceKind
	 * @generated
	 */
	EEnum getChoiceKind();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SGraphFactory getSGraphFactory();

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
		 * The meta object literal for the '{@link org.yakindu.sct.model.sgraph.impl.PseudostateImpl <em>Pseudostate</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sgraph.impl.PseudostateImpl
		 * @see org.yakindu.sct.model.sgraph.impl.SGraphPackageImpl#getPseudostate()
		 * @generated
		 */
		EClass PSEUDOSTATE = eINSTANCE.getPseudostate();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.sgraph.impl.VertexImpl <em>Vertex</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sgraph.impl.VertexImpl
		 * @see org.yakindu.sct.model.sgraph.impl.SGraphPackageImpl#getVertex()
		 * @generated
		 */
		EClass VERTEX = eINSTANCE.getVertex();

		/**
		 * The meta object literal for the '<em><b>Parent Region</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VERTEX__PARENT_REGION = eINSTANCE.getVertex_ParentRegion();

		/**
		 * The meta object literal for the '<em><b>Incoming Transitions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VERTEX__INCOMING_TRANSITIONS = eINSTANCE.getVertex_IncomingTransitions();

		/**
		 * The meta object literal for the '<em><b>Outgoing Transitions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VERTEX__OUTGOING_TRANSITIONS = eINSTANCE.getVertex_OutgoingTransitions();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.sgraph.impl.NamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sgraph.impl.NamedElementImpl
		 * @see org.yakindu.sct.model.sgraph.impl.SGraphPackageImpl#getNamedElement()
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
		 * The meta object literal for the '{@link org.yakindu.sct.model.sgraph.impl.RegionImpl <em>Region</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sgraph.impl.RegionImpl
		 * @see org.yakindu.sct.model.sgraph.impl.SGraphPackageImpl#getRegion()
		 * @generated
		 */
		EClass REGION = eINSTANCE.getRegion();

		/**
		 * The meta object literal for the '<em><b>Vertices</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REGION__VERTICES = eINSTANCE.getRegion_Vertices();

		/**
		 * The meta object literal for the '<em><b>Priority</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REGION__PRIORITY = eINSTANCE.getRegion_Priority();

		/**
		 * The meta object literal for the '<em><b>Composite</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REGION__COMPOSITE = eINSTANCE.getRegion_Composite();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.sgraph.impl.TransitionImpl <em>Transition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sgraph.impl.TransitionImpl
		 * @see org.yakindu.sct.model.sgraph.impl.SGraphPackageImpl#getTransition()
		 * @generated
		 */
		EClass TRANSITION = eINSTANCE.getTransition();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION__TARGET = eINSTANCE.getTransition_Target();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION__SOURCE = eINSTANCE.getTransition_Source();

		/**
		 * The meta object literal for the '<em><b>Priority</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSITION__PRIORITY = eINSTANCE.getTransition_Priority();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.sgraph.impl.FinalStateImpl <em>Final State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sgraph.impl.FinalStateImpl
		 * @see org.yakindu.sct.model.sgraph.impl.SGraphPackageImpl#getFinalState()
		 * @generated
		 */
		EClass FINAL_STATE = eINSTANCE.getFinalState();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.sgraph.impl.StateImpl <em>State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sgraph.impl.StateImpl
		 * @see org.yakindu.sct.model.sgraph.impl.SGraphPackageImpl#getState()
		 * @generated
		 */
		EClass STATE = eINSTANCE.getState();

		/**
		 * The meta object literal for the '<em><b>Orthogonal</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATE__ORTHOGONAL = eINSTANCE.getState_Orthogonal();

		/**
		 * The meta object literal for the '<em><b>Substatechart</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__SUBSTATECHART = eINSTANCE.getState_Substatechart();

		/**
		 * The meta object literal for the '<em><b>Substatechart Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATE__SUBSTATECHART_ID = eINSTANCE.getState_SubstatechartId();

		/**
		 * The meta object literal for the '<em><b>Subchart</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATE__SUBCHART = eINSTANCE.getState_Subchart();

		/**
		 * The meta object literal for the '<em><b>Simple</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATE__SIMPLE = eINSTANCE.getState_Simple();

		/**
		 * The meta object literal for the '<em><b>Composite</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATE__COMPOSITE = eINSTANCE.getState_Composite();

		/**
		 * The meta object literal for the '<em><b>Leaf</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATE__LEAF = eINSTANCE.getState_Leaf();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.sgraph.impl.StatementImpl <em>Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sgraph.impl.StatementImpl
		 * @see org.yakindu.sct.model.sgraph.impl.SGraphPackageImpl#getStatement()
		 * @generated
		 */
		EClass STATEMENT = eINSTANCE.getStatement();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.sgraph.impl.RegularStateImpl <em>Regular State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sgraph.impl.RegularStateImpl
		 * @see org.yakindu.sct.model.sgraph.impl.SGraphPackageImpl#getRegularState()
		 * @generated
		 */
		EClass REGULAR_STATE = eINSTANCE.getRegularState();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.sgraph.impl.CompositeElementImpl <em>Composite Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sgraph.impl.CompositeElementImpl
		 * @see org.yakindu.sct.model.sgraph.impl.SGraphPackageImpl#getCompositeElement()
		 * @generated
		 */
		EClass COMPOSITE_ELEMENT = eINSTANCE.getCompositeElement();

		/**
		 * The meta object literal for the '<em><b>Regions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_ELEMENT__REGIONS = eINSTANCE.getCompositeElement_Regions();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.sgraph.impl.VariableImpl <em>Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sgraph.impl.VariableImpl
		 * @see org.yakindu.sct.model.sgraph.impl.SGraphPackageImpl#getVariable()
		 * @generated
		 */
		EClass VARIABLE = eINSTANCE.getVariable();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.sgraph.impl.EventImpl <em>Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sgraph.impl.EventImpl
		 * @see org.yakindu.sct.model.sgraph.impl.SGraphPackageImpl#getEvent()
		 * @generated
		 */
		EClass EVENT = eINSTANCE.getEvent();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.sgraph.impl.ChoiceImpl <em>Choice</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sgraph.impl.ChoiceImpl
		 * @see org.yakindu.sct.model.sgraph.impl.SGraphPackageImpl#getChoice()
		 * @generated
		 */
		EClass CHOICE = eINSTANCE.getChoice();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHOICE__KIND = eINSTANCE.getChoice_Kind();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.sgraph.impl.StatechartImpl <em>Statechart</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sgraph.impl.StatechartImpl
		 * @see org.yakindu.sct.model.sgraph.impl.SGraphPackageImpl#getStatechart()
		 * @generated
		 */
		EClass STATECHART = eINSTANCE.getStatechart();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.sgraph.impl.EntryImpl <em>Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sgraph.impl.EntryImpl
		 * @see org.yakindu.sct.model.sgraph.impl.SGraphPackageImpl#getEntry()
		 * @generated
		 */
		EClass ENTRY = eINSTANCE.getEntry();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTRY__KIND = eINSTANCE.getEntry_Kind();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.sgraph.impl.TriggerImpl <em>Trigger</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sgraph.impl.TriggerImpl
		 * @see org.yakindu.sct.model.sgraph.impl.SGraphPackageImpl#getTrigger()
		 * @generated
		 */
		EClass TRIGGER = eINSTANCE.getTrigger();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.sgraph.impl.EffectImpl <em>Effect</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sgraph.impl.EffectImpl
		 * @see org.yakindu.sct.model.sgraph.impl.SGraphPackageImpl#getEffect()
		 * @generated
		 */
		EClass EFFECT = eINSTANCE.getEffect();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.sgraph.impl.ExpressionElementImpl <em>Expression Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sgraph.impl.ExpressionElementImpl
		 * @see org.yakindu.sct.model.sgraph.impl.SGraphPackageImpl#getExpressionElement()
		 * @generated
		 */
		EClass EXPRESSION_ELEMENT = eINSTANCE.getExpressionElement();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPRESSION_ELEMENT__EXPRESSION = eINSTANCE.getExpressionElement_Expression();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.sgraph.impl.DeclarationImpl <em>Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sgraph.impl.DeclarationImpl
		 * @see org.yakindu.sct.model.sgraph.impl.SGraphPackageImpl#getDeclaration()
		 * @generated
		 */
		EClass DECLARATION = eINSTANCE.getDeclaration();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.sgraph.impl.ReactionImpl <em>Reaction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sgraph.impl.ReactionImpl
		 * @see org.yakindu.sct.model.sgraph.impl.SGraphPackageImpl#getReaction()
		 * @generated
		 */
		EClass REACTION = eINSTANCE.getReaction();

		/**
		 * The meta object literal for the '<em><b>Trigger</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REACTION__TRIGGER = eINSTANCE.getReaction_Trigger();

		/**
		 * The meta object literal for the '<em><b>Effect</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REACTION__EFFECT = eINSTANCE.getReaction_Effect();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.sgraph.impl.ReactiveElementImpl <em>Reactive Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sgraph.impl.ReactiveElementImpl
		 * @see org.yakindu.sct.model.sgraph.impl.SGraphPackageImpl#getReactiveElement()
		 * @generated
		 */
		EClass REACTIVE_ELEMENT = eINSTANCE.getReactiveElement();

		/**
		 * The meta object literal for the '<em><b>Reactions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REACTIVE_ELEMENT__REACTIONS = eINSTANCE.getReactiveElement_Reactions();

		/**
		 * The meta object literal for the '<em><b>Local Reactions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REACTIVE_ELEMENT__LOCAL_REACTIONS = eINSTANCE.getReactiveElement_LocalReactions();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.sgraph.impl.ExitImpl <em>Exit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sgraph.impl.ExitImpl
		 * @see org.yakindu.sct.model.sgraph.impl.SGraphPackageImpl#getExit()
		 * @generated
		 */
		EClass EXIT = eINSTANCE.getExit();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.sgraph.impl.ScopeImpl <em>Scope</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sgraph.impl.ScopeImpl
		 * @see org.yakindu.sct.model.sgraph.impl.SGraphPackageImpl#getScope()
		 * @generated
		 */
		EClass SCOPE = eINSTANCE.getScope();

		/**
		 * The meta object literal for the '<em><b>Declarations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCOPE__DECLARATIONS = eINSTANCE.getScope_Declarations();

		/**
		 * The meta object literal for the '<em><b>Events</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCOPE__EVENTS = eINSTANCE.getScope_Events();

		/**
		 * The meta object literal for the '<em><b>Variables</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCOPE__VARIABLES = eINSTANCE.getScope_Variables();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.sgraph.impl.ScopedElementImpl <em>Scoped Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sgraph.impl.ScopedElementImpl
		 * @see org.yakindu.sct.model.sgraph.impl.SGraphPackageImpl#getScopedElement()
		 * @generated
		 */
		EClass SCOPED_ELEMENT = eINSTANCE.getScopedElement();

		/**
		 * The meta object literal for the '<em><b>Scopes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCOPED_ELEMENT__SCOPES = eINSTANCE.getScopedElement_Scopes();

		/**
		 * The meta object literal for the '<em><b>Namespace</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCOPED_ELEMENT__NAMESPACE = eINSTANCE.getScopedElement_Namespace();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.sgraph.impl.SynchronizationImpl <em>Synchronization</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sgraph.impl.SynchronizationImpl
		 * @see org.yakindu.sct.model.sgraph.impl.SGraphPackageImpl#getSynchronization()
		 * @generated
		 */
		EClass SYNCHRONIZATION = eINSTANCE.getSynchronization();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.sgraph.EntryKind <em>Entry Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sgraph.EntryKind
		 * @see org.yakindu.sct.model.sgraph.impl.SGraphPackageImpl#getEntryKind()
		 * @generated
		 */
		EEnum ENTRY_KIND = eINSTANCE.getEntryKind();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.sgraph.ChoiceKind <em>Choice Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sgraph.ChoiceKind
		 * @see org.yakindu.sct.model.sgraph.impl.SGraphPackageImpl#getChoiceKind()
		 * @generated
		 */
		EEnum CHOICE_KIND = eINSTANCE.getChoiceKind();

	}

} //SGraphPackage
