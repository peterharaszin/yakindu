/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.execution.executiongraph;

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
 * @see org.eclipselabs.damos.execution.executiongraph.ExecutionGraphFactory
 * @model kind="package"
 * @generated
 */
public interface ExecutionGraphPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "executiongraph";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipselabs.org/damos/ExecutionGraph/1.0.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "executiongraph";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ExecutionGraphPackage eINSTANCE = org.eclipselabs.damos.execution.executiongraph.impl.ExecutionGraphPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.execution.executiongraph.impl.ExecutionGraphImpl <em>Execution Graph</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.execution.executiongraph.impl.ExecutionGraphImpl
	 * @see org.eclipselabs.damos.execution.executiongraph.impl.ExecutionGraphPackageImpl#getExecutionGraph()
	 * @generated
	 */
	int EXECUTION_GRAPH = 0;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_GRAPH__NODES = 0;

	/**
	 * The feature id for the '<em><b>Initial Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_GRAPH__INITIAL_NODES = 1;

	/**
	 * The feature id for the '<em><b>Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_GRAPH__LINKS = 2;

	/**
	 * The feature id for the '<em><b>Top Level Fragment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_GRAPH__TOP_LEVEL_FRAGMENT = 3;

	/**
	 * The feature id for the '<em><b>Data Flows</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_GRAPH__DATA_FLOWS = 4;

	/**
	 * The number of structural features of the '<em>Execution Graph</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_GRAPH_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.execution.executiongraph.impl.NodeImpl <em>Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.execution.executiongraph.impl.NodeImpl
	 * @see org.eclipselabs.damos.execution.executiongraph.impl.ExecutionGraphPackageImpl#getNode()
	 * @generated
	 */
	int NODE = 1;

	/**
	 * The feature id for the '<em><b>Incoming Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__INCOMING_LINKS = 0;

	/**
	 * The feature id for the '<em><b>Outgoing Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__OUTGOING_LINKS = 1;

	/**
	 * The feature id for the '<em><b>Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__COMPONENT = 2;

	/**
	 * The feature id for the '<em><b>Outgoing Data Flows</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__OUTGOING_DATA_FLOWS = 3;

	/**
	 * The feature id for the '<em><b>Incoming Data Flows</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__INCOMING_DATA_FLOWS = 4;

	/**
	 * The feature id for the '<em><b>Enclosing Subsystems</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__ENCLOSING_SUBSYSTEMS = 5;

	/**
	 * The number of structural features of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.execution.executiongraph.impl.LinkImpl <em>Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.execution.executiongraph.impl.LinkImpl
	 * @see org.eclipselabs.damos.execution.executiongraph.impl.ExecutionGraphPackageImpl#getLink()
	 * @generated
	 */
	int LINK = 2;

	/**
	 * The feature id for the '<em><b>Source Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__SOURCE_NODE = 0;

	/**
	 * The feature id for the '<em><b>Target Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__TARGET_NODE = 1;

	/**
	 * The number of structural features of the '<em>Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.execution.executiongraph.impl.DataFlowEndImpl <em>Data Flow End</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.execution.executiongraph.impl.DataFlowEndImpl
	 * @see org.eclipselabs.damos.execution.executiongraph.impl.ExecutionGraphPackageImpl#getDataFlowEnd()
	 * @generated
	 */
	int DATA_FLOW_END = 4;

	/**
	 * The number of structural features of the '<em>Data Flow End</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FLOW_END_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.execution.executiongraph.impl.DataFlowSourceEndImpl <em>Data Flow Source End</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.execution.executiongraph.impl.DataFlowSourceEndImpl
	 * @see org.eclipselabs.damos.execution.executiongraph.impl.ExecutionGraphPackageImpl#getDataFlowSourceEnd()
	 * @generated
	 */
	int DATA_FLOW_SOURCE_END = 3;

	/**
	 * The feature id for the '<em><b>Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FLOW_SOURCE_END__PORT = DATA_FLOW_END_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Data Flow</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FLOW_SOURCE_END__DATA_FLOW = DATA_FLOW_END_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FLOW_SOURCE_END__NODE = DATA_FLOW_END_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Data Flow Source End</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FLOW_SOURCE_END_FEATURE_COUNT = DATA_FLOW_END_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.execution.executiongraph.impl.DataFlowImpl <em>Data Flow</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.execution.executiongraph.impl.DataFlowImpl
	 * @see org.eclipselabs.damos.execution.executiongraph.impl.ExecutionGraphPackageImpl#getDataFlow()
	 * @generated
	 */
	int DATA_FLOW = 5;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.execution.executiongraph.impl.DataFlowTargetEndImpl <em>Data Flow Target End</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.execution.executiongraph.impl.DataFlowTargetEndImpl
	 * @see org.eclipselabs.damos.execution.executiongraph.impl.ExecutionGraphPackageImpl#getDataFlowTargetEnd()
	 * @generated
	 */
	int DATA_FLOW_TARGET_END = 6;

	/**
	 * The feature id for the '<em><b>Target Ends</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FLOW__TARGET_ENDS = 0;

	/**
	 * The feature id for the '<em><b>Source End</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FLOW__SOURCE_END = 1;

	/**
	 * The number of structural features of the '<em>Data Flow</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FLOW_FEATURE_COUNT = 2;

	/**
	 * The feature id for the '<em><b>Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FLOW_TARGET_END__NODE = DATA_FLOW_END_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FLOW_TARGET_END__PORT = DATA_FLOW_END_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Data Flow</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FLOW_TARGET_END__DATA_FLOW = DATA_FLOW_END_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Data Flow Target End</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FLOW_TARGET_END_FEATURE_COUNT = DATA_FLOW_END_FEATURE_COUNT + 3;

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.execution.executiongraph.ExecutionGraph <em>Execution Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Execution Graph</em>'.
	 * @see org.eclipselabs.damos.execution.executiongraph.ExecutionGraph
	 * @generated
	 */
	EClass getExecutionGraph();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.execution.executiongraph.ExecutionGraph#getNodes <em>Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Nodes</em>'.
	 * @see org.eclipselabs.damos.execution.executiongraph.ExecutionGraph#getNodes()
	 * @see #getExecutionGraph()
	 * @generated
	 */
	EReference getExecutionGraph_Nodes();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipselabs.damos.execution.executiongraph.ExecutionGraph#getInitialNodes <em>Initial Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Initial Nodes</em>'.
	 * @see org.eclipselabs.damos.execution.executiongraph.ExecutionGraph#getInitialNodes()
	 * @see #getExecutionGraph()
	 * @generated
	 */
	EReference getExecutionGraph_InitialNodes();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.execution.executiongraph.ExecutionGraph#getLinks <em>Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Links</em>'.
	 * @see org.eclipselabs.damos.execution.executiongraph.ExecutionGraph#getLinks()
	 * @see #getExecutionGraph()
	 * @generated
	 */
	EReference getExecutionGraph_Links();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.damos.execution.executiongraph.ExecutionGraph#getTopLevelFragment <em>Top Level Fragment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Top Level Fragment</em>'.
	 * @see org.eclipselabs.damos.execution.executiongraph.ExecutionGraph#getTopLevelFragment()
	 * @see #getExecutionGraph()
	 * @generated
	 */
	EReference getExecutionGraph_TopLevelFragment();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.execution.executiongraph.ExecutionGraph#getDataFlows <em>Data Flows</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Data Flows</em>'.
	 * @see org.eclipselabs.damos.execution.executiongraph.ExecutionGraph#getDataFlows()
	 * @see #getExecutionGraph()
	 * @generated
	 */
	EReference getExecutionGraph_DataFlows();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.execution.executiongraph.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node</em>'.
	 * @see org.eclipselabs.damos.execution.executiongraph.Node
	 * @generated
	 */
	EClass getNode();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipselabs.damos.execution.executiongraph.Node#getIncomingLinks <em>Incoming Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Incoming Links</em>'.
	 * @see org.eclipselabs.damos.execution.executiongraph.Node#getIncomingLinks()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_IncomingLinks();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipselabs.damos.execution.executiongraph.Node#getOutgoingLinks <em>Outgoing Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outgoing Links</em>'.
	 * @see org.eclipselabs.damos.execution.executiongraph.Node#getOutgoingLinks()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_OutgoingLinks();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.damos.execution.executiongraph.Node#getComponent <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Component</em>'.
	 * @see org.eclipselabs.damos.execution.executiongraph.Node#getComponent()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_Component();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipselabs.damos.execution.executiongraph.Node#getOutgoingDataFlows <em>Outgoing Data Flows</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outgoing Data Flows</em>'.
	 * @see org.eclipselabs.damos.execution.executiongraph.Node#getOutgoingDataFlows()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_OutgoingDataFlows();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipselabs.damos.execution.executiongraph.Node#getIncomingDataFlows <em>Incoming Data Flows</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Incoming Data Flows</em>'.
	 * @see org.eclipselabs.damos.execution.executiongraph.Node#getIncomingDataFlows()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_IncomingDataFlows();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipselabs.damos.execution.executiongraph.Node#getEnclosingSubsystems <em>Enclosing Subsystems</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Enclosing Subsystems</em>'.
	 * @see org.eclipselabs.damos.execution.executiongraph.Node#getEnclosingSubsystems()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_EnclosingSubsystems();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.execution.executiongraph.Link <em>Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link</em>'.
	 * @see org.eclipselabs.damos.execution.executiongraph.Link
	 * @generated
	 */
	EClass getLink();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.damos.execution.executiongraph.Link#getSourceNode <em>Source Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source Node</em>'.
	 * @see org.eclipselabs.damos.execution.executiongraph.Link#getSourceNode()
	 * @see #getLink()
	 * @generated
	 */
	EReference getLink_SourceNode();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.damos.execution.executiongraph.Link#getTargetNode <em>Target Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Node</em>'.
	 * @see org.eclipselabs.damos.execution.executiongraph.Link#getTargetNode()
	 * @see #getLink()
	 * @generated
	 */
	EReference getLink_TargetNode();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.execution.executiongraph.DataFlowSourceEnd <em>Data Flow Source End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Flow Source End</em>'.
	 * @see org.eclipselabs.damos.execution.executiongraph.DataFlowSourceEnd
	 * @generated
	 */
	EClass getDataFlowSourceEnd();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.damos.execution.executiongraph.DataFlowSourceEnd#getPort <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Port</em>'.
	 * @see org.eclipselabs.damos.execution.executiongraph.DataFlowSourceEnd#getPort()
	 * @see #getDataFlowSourceEnd()
	 * @generated
	 */
	EReference getDataFlowSourceEnd_Port();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipselabs.damos.execution.executiongraph.DataFlowSourceEnd#getDataFlow <em>Data Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Data Flow</em>'.
	 * @see org.eclipselabs.damos.execution.executiongraph.DataFlowSourceEnd#getDataFlow()
	 * @see #getDataFlowSourceEnd()
	 * @generated
	 */
	EReference getDataFlowSourceEnd_DataFlow();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.damos.execution.executiongraph.DataFlowSourceEnd#getNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Node</em>'.
	 * @see org.eclipselabs.damos.execution.executiongraph.DataFlowSourceEnd#getNode()
	 * @see #getDataFlowSourceEnd()
	 * @generated
	 */
	EReference getDataFlowSourceEnd_Node();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.execution.executiongraph.DataFlowEnd <em>Data Flow End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Flow End</em>'.
	 * @see org.eclipselabs.damos.execution.executiongraph.DataFlowEnd
	 * @generated
	 */
	EClass getDataFlowEnd();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.execution.executiongraph.DataFlow <em>Data Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Flow</em>'.
	 * @see org.eclipselabs.damos.execution.executiongraph.DataFlow
	 * @generated
	 */
	EClass getDataFlow();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.damos.execution.executiongraph.DataFlow#getSourceEnd <em>Source End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Source End</em>'.
	 * @see org.eclipselabs.damos.execution.executiongraph.DataFlow#getSourceEnd()
	 * @see #getDataFlow()
	 * @generated
	 */
	EReference getDataFlow_SourceEnd();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.execution.executiongraph.DataFlow#getTargetEnds <em>Target Ends</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Target Ends</em>'.
	 * @see org.eclipselabs.damos.execution.executiongraph.DataFlow#getTargetEnds()
	 * @see #getDataFlow()
	 * @generated
	 */
	EReference getDataFlow_TargetEnds();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.execution.executiongraph.DataFlowTargetEnd <em>Data Flow Target End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Flow Target End</em>'.
	 * @see org.eclipselabs.damos.execution.executiongraph.DataFlowTargetEnd
	 * @generated
	 */
	EClass getDataFlowTargetEnd();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.damos.execution.executiongraph.DataFlowTargetEnd#getNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Node</em>'.
	 * @see org.eclipselabs.damos.execution.executiongraph.DataFlowTargetEnd#getNode()
	 * @see #getDataFlowTargetEnd()
	 * @generated
	 */
	EReference getDataFlowTargetEnd_Node();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.damos.execution.executiongraph.DataFlowTargetEnd#getPort <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Port</em>'.
	 * @see org.eclipselabs.damos.execution.executiongraph.DataFlowTargetEnd#getPort()
	 * @see #getDataFlowTargetEnd()
	 * @generated
	 */
	EReference getDataFlowTargetEnd_Port();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipselabs.damos.execution.executiongraph.DataFlowTargetEnd#getDataFlow <em>Data Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Data Flow</em>'.
	 * @see org.eclipselabs.damos.execution.executiongraph.DataFlowTargetEnd#getDataFlow()
	 * @see #getDataFlowTargetEnd()
	 * @generated
	 */
	EReference getDataFlowTargetEnd_DataFlow();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ExecutionGraphFactory getExecutionGraphFactory();

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
		 * The meta object literal for the '{@link org.eclipselabs.damos.execution.executiongraph.impl.ExecutionGraphImpl <em>Execution Graph</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.execution.executiongraph.impl.ExecutionGraphImpl
		 * @see org.eclipselabs.damos.execution.executiongraph.impl.ExecutionGraphPackageImpl#getExecutionGraph()
		 * @generated
		 */
		EClass EXECUTION_GRAPH = eINSTANCE.getExecutionGraph();

		/**
		 * The meta object literal for the '<em><b>Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION_GRAPH__NODES = eINSTANCE.getExecutionGraph_Nodes();

		/**
		 * The meta object literal for the '<em><b>Initial Nodes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION_GRAPH__INITIAL_NODES = eINSTANCE.getExecutionGraph_InitialNodes();

		/**
		 * The meta object literal for the '<em><b>Links</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION_GRAPH__LINKS = eINSTANCE.getExecutionGraph_Links();

		/**
		 * The meta object literal for the '<em><b>Top Level Fragment</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION_GRAPH__TOP_LEVEL_FRAGMENT = eINSTANCE.getExecutionGraph_TopLevelFragment();

		/**
		 * The meta object literal for the '<em><b>Data Flows</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION_GRAPH__DATA_FLOWS = eINSTANCE.getExecutionGraph_DataFlows();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.execution.executiongraph.impl.NodeImpl <em>Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.execution.executiongraph.impl.NodeImpl
		 * @see org.eclipselabs.damos.execution.executiongraph.impl.ExecutionGraphPackageImpl#getNode()
		 * @generated
		 */
		EClass NODE = eINSTANCE.getNode();

		/**
		 * The meta object literal for the '<em><b>Incoming Links</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__INCOMING_LINKS = eINSTANCE.getNode_IncomingLinks();

		/**
		 * The meta object literal for the '<em><b>Outgoing Links</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__OUTGOING_LINKS = eINSTANCE.getNode_OutgoingLinks();

		/**
		 * The meta object literal for the '<em><b>Component</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__COMPONENT = eINSTANCE.getNode_Component();

		/**
		 * The meta object literal for the '<em><b>Outgoing Data Flows</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__OUTGOING_DATA_FLOWS = eINSTANCE.getNode_OutgoingDataFlows();

		/**
		 * The meta object literal for the '<em><b>Incoming Data Flows</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__INCOMING_DATA_FLOWS = eINSTANCE.getNode_IncomingDataFlows();

		/**
		 * The meta object literal for the '<em><b>Enclosing Subsystems</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__ENCLOSING_SUBSYSTEMS = eINSTANCE.getNode_EnclosingSubsystems();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.execution.executiongraph.impl.LinkImpl <em>Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.execution.executiongraph.impl.LinkImpl
		 * @see org.eclipselabs.damos.execution.executiongraph.impl.ExecutionGraphPackageImpl#getLink()
		 * @generated
		 */
		EClass LINK = eINSTANCE.getLink();

		/**
		 * The meta object literal for the '<em><b>Source Node</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LINK__SOURCE_NODE = eINSTANCE.getLink_SourceNode();

		/**
		 * The meta object literal for the '<em><b>Target Node</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LINK__TARGET_NODE = eINSTANCE.getLink_TargetNode();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.execution.executiongraph.impl.DataFlowSourceEndImpl <em>Data Flow Source End</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.execution.executiongraph.impl.DataFlowSourceEndImpl
		 * @see org.eclipselabs.damos.execution.executiongraph.impl.ExecutionGraphPackageImpl#getDataFlowSourceEnd()
		 * @generated
		 */
		EClass DATA_FLOW_SOURCE_END = eINSTANCE.getDataFlowSourceEnd();

		/**
		 * The meta object literal for the '<em><b>Port</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_FLOW_SOURCE_END__PORT = eINSTANCE.getDataFlowSourceEnd_Port();

		/**
		 * The meta object literal for the '<em><b>Data Flow</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_FLOW_SOURCE_END__DATA_FLOW = eINSTANCE.getDataFlowSourceEnd_DataFlow();

		/**
		 * The meta object literal for the '<em><b>Node</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_FLOW_SOURCE_END__NODE = eINSTANCE.getDataFlowSourceEnd_Node();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.execution.executiongraph.impl.DataFlowEndImpl <em>Data Flow End</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.execution.executiongraph.impl.DataFlowEndImpl
		 * @see org.eclipselabs.damos.execution.executiongraph.impl.ExecutionGraphPackageImpl#getDataFlowEnd()
		 * @generated
		 */
		EClass DATA_FLOW_END = eINSTANCE.getDataFlowEnd();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.execution.executiongraph.impl.DataFlowImpl <em>Data Flow</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.execution.executiongraph.impl.DataFlowImpl
		 * @see org.eclipselabs.damos.execution.executiongraph.impl.ExecutionGraphPackageImpl#getDataFlow()
		 * @generated
		 */
		EClass DATA_FLOW = eINSTANCE.getDataFlow();

		/**
		 * The meta object literal for the '<em><b>Source End</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_FLOW__SOURCE_END = eINSTANCE.getDataFlow_SourceEnd();

		/**
		 * The meta object literal for the '<em><b>Target Ends</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_FLOW__TARGET_ENDS = eINSTANCE.getDataFlow_TargetEnds();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.execution.executiongraph.impl.DataFlowTargetEndImpl <em>Data Flow Target End</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.execution.executiongraph.impl.DataFlowTargetEndImpl
		 * @see org.eclipselabs.damos.execution.executiongraph.impl.ExecutionGraphPackageImpl#getDataFlowTargetEnd()
		 * @generated
		 */
		EClass DATA_FLOW_TARGET_END = eINSTANCE.getDataFlowTargetEnd();

		/**
		 * The meta object literal for the '<em><b>Node</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_FLOW_TARGET_END__NODE = eINSTANCE.getDataFlowTargetEnd_Node();

		/**
		 * The meta object literal for the '<em><b>Port</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_FLOW_TARGET_END__PORT = eINSTANCE.getDataFlowTargetEnd_Port();

		/**
		 * The meta object literal for the '<em><b>Data Flow</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_FLOW_TARGET_END__DATA_FLOW = eINSTANCE.getDataFlowTargetEnd_DataFlow();

	}

} //ExecutionGraphPackage
