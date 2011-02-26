/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.execution.executionflow;

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
 * @see org.eclipselabs.damos.execution.executionflow.ExecutionFlowFactory
 * @model kind="package"
 * @generated
 */
public interface ExecutionFlowPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "executionflow";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipselabs.org/damos/ExecutionFlow/1.0.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "executionflow";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ExecutionFlowPackage eINSTANCE = org.eclipselabs.damos.execution.executionflow.impl.ExecutionFlowPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.execution.executionflow.impl.ExecutionFlowImpl <em>Execution Flow</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.execution.executionflow.impl.ExecutionFlowImpl
	 * @see org.eclipselabs.damos.execution.executionflow.impl.ExecutionFlowPackageImpl#getExecutionFlow()
	 * @generated
	 */
	int EXECUTION_FLOW = 0;

	/**
	 * The feature id for the '<em><b>Top Level Fragment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_FLOW__TOP_LEVEL_FRAGMENT = 0;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_FLOW__GRAPH = 1;

	/**
	 * The feature id for the '<em><b>Data Flows</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_FLOW__DATA_FLOWS = 2;

	/**
	 * The number of structural features of the '<em>Execution Flow</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_FLOW_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.execution.executionflow.impl.GraphImpl <em>Graph</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.execution.executionflow.impl.GraphImpl
	 * @see org.eclipselabs.damos.execution.executionflow.impl.ExecutionFlowPackageImpl#getGraph()
	 * @generated
	 */
	int GRAPH = 1;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH__NODES = 0;

	/**
	 * The feature id for the '<em><b>Initial Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH__INITIAL_NODES = 1;

	/**
	 * The feature id for the '<em><b>Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH__EDGES = 2;

	/**
	 * The number of structural features of the '<em>Graph</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.execution.executionflow.impl.NodeImpl <em>Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.execution.executionflow.impl.NodeImpl
	 * @see org.eclipselabs.damos.execution.executionflow.impl.ExecutionFlowPackageImpl#getNode()
	 * @generated
	 */
	int NODE = 2;

	/**
	 * The feature id for the '<em><b>Incoming Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__INCOMING_EDGES = 0;

	/**
	 * The feature id for the '<em><b>Outgoing Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__OUTGOING_EDGES = 1;

	/**
	 * The feature id for the '<em><b>Enclosing Subsystems</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__ENCLOSING_SUBSYSTEMS = 2;

	/**
	 * The feature id for the '<em><b>Incoming Data Flows</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__INCOMING_DATA_FLOWS = 3;

	/**
	 * The feature id for the '<em><b>Outgoing Data Flows</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__OUTGOING_DATA_FLOWS = 4;

	/**
	 * The number of structural features of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.execution.executionflow.impl.SubgraphImpl <em>Subgraph</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.execution.executionflow.impl.SubgraphImpl
	 * @see org.eclipselabs.damos.execution.executionflow.impl.ExecutionFlowPackageImpl#getSubgraph()
	 * @generated
	 */
	int SUBGRAPH = 3;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBGRAPH__NODES = GRAPH__NODES;

	/**
	 * The feature id for the '<em><b>Initial Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBGRAPH__INITIAL_NODES = GRAPH__INITIAL_NODES;

	/**
	 * The feature id for the '<em><b>Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBGRAPH__EDGES = GRAPH__EDGES;

	/**
	 * The feature id for the '<em><b>Incoming Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBGRAPH__INCOMING_EDGES = GRAPH_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Outgoing Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBGRAPH__OUTGOING_EDGES = GRAPH_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Enclosing Subsystems</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBGRAPH__ENCLOSING_SUBSYSTEMS = GRAPH_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Incoming Data Flows</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBGRAPH__INCOMING_DATA_FLOWS = GRAPH_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Outgoing Data Flows</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBGRAPH__OUTGOING_DATA_FLOWS = GRAPH_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Subgraph</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBGRAPH_FEATURE_COUNT = GRAPH_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.execution.executionflow.impl.ComponentNodeImpl <em>Component Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.execution.executionflow.impl.ComponentNodeImpl
	 * @see org.eclipselabs.damos.execution.executionflow.impl.ExecutionFlowPackageImpl#getComponentNode()
	 * @generated
	 */
	int COMPONENT_NODE = 4;

	/**
	 * The feature id for the '<em><b>Incoming Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_NODE__INCOMING_EDGES = NODE__INCOMING_EDGES;

	/**
	 * The feature id for the '<em><b>Outgoing Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_NODE__OUTGOING_EDGES = NODE__OUTGOING_EDGES;

	/**
	 * The feature id for the '<em><b>Enclosing Subsystems</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_NODE__ENCLOSING_SUBSYSTEMS = NODE__ENCLOSING_SUBSYSTEMS;

	/**
	 * The feature id for the '<em><b>Incoming Data Flows</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_NODE__INCOMING_DATA_FLOWS = NODE__INCOMING_DATA_FLOWS;

	/**
	 * The feature id for the '<em><b>Outgoing Data Flows</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_NODE__OUTGOING_DATA_FLOWS = NODE__OUTGOING_DATA_FLOWS;

	/**
	 * The feature id for the '<em><b>Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_NODE__COMPONENT = NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Component Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_NODE_FEATURE_COUNT = NODE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.execution.executionflow.impl.CompoundNodeImpl <em>Compound Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.execution.executionflow.impl.CompoundNodeImpl
	 * @see org.eclipselabs.damos.execution.executionflow.impl.ExecutionFlowPackageImpl#getCompoundNode()
	 * @generated
	 */
	int COMPOUND_NODE = 5;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_NODE__NODES = SUBGRAPH__NODES;

	/**
	 * The feature id for the '<em><b>Initial Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_NODE__INITIAL_NODES = SUBGRAPH__INITIAL_NODES;

	/**
	 * The feature id for the '<em><b>Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_NODE__EDGES = SUBGRAPH__EDGES;

	/**
	 * The feature id for the '<em><b>Incoming Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_NODE__INCOMING_EDGES = SUBGRAPH__INCOMING_EDGES;

	/**
	 * The feature id for the '<em><b>Outgoing Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_NODE__OUTGOING_EDGES = SUBGRAPH__OUTGOING_EDGES;

	/**
	 * The feature id for the '<em><b>Enclosing Subsystems</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_NODE__ENCLOSING_SUBSYSTEMS = SUBGRAPH__ENCLOSING_SUBSYSTEMS;

	/**
	 * The feature id for the '<em><b>Incoming Data Flows</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_NODE__INCOMING_DATA_FLOWS = SUBGRAPH__INCOMING_DATA_FLOWS;

	/**
	 * The feature id for the '<em><b>Outgoing Data Flows</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_NODE__OUTGOING_DATA_FLOWS = SUBGRAPH__OUTGOING_DATA_FLOWS;

	/**
	 * The feature id for the '<em><b>Compound</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_NODE__COMPOUND = SUBGRAPH_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Compound Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_NODE_FEATURE_COUNT = SUBGRAPH_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.execution.executionflow.impl.SubsystemNodeImpl <em>Subsystem Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.execution.executionflow.impl.SubsystemNodeImpl
	 * @see org.eclipselabs.damos.execution.executionflow.impl.ExecutionFlowPackageImpl#getSubsystemNode()
	 * @generated
	 */
	int SUBSYSTEM_NODE = 6;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSYSTEM_NODE__NODES = SUBGRAPH__NODES;

	/**
	 * The feature id for the '<em><b>Initial Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSYSTEM_NODE__INITIAL_NODES = SUBGRAPH__INITIAL_NODES;

	/**
	 * The feature id for the '<em><b>Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSYSTEM_NODE__EDGES = SUBGRAPH__EDGES;

	/**
	 * The feature id for the '<em><b>Incoming Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSYSTEM_NODE__INCOMING_EDGES = SUBGRAPH__INCOMING_EDGES;

	/**
	 * The feature id for the '<em><b>Outgoing Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSYSTEM_NODE__OUTGOING_EDGES = SUBGRAPH__OUTGOING_EDGES;

	/**
	 * The feature id for the '<em><b>Enclosing Subsystems</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSYSTEM_NODE__ENCLOSING_SUBSYSTEMS = SUBGRAPH__ENCLOSING_SUBSYSTEMS;

	/**
	 * The feature id for the '<em><b>Incoming Data Flows</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSYSTEM_NODE__INCOMING_DATA_FLOWS = SUBGRAPH__INCOMING_DATA_FLOWS;

	/**
	 * The feature id for the '<em><b>Outgoing Data Flows</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSYSTEM_NODE__OUTGOING_DATA_FLOWS = SUBGRAPH__OUTGOING_DATA_FLOWS;

	/**
	 * The feature id for the '<em><b>Subsystem</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSYSTEM_NODE__SUBSYSTEM = SUBGRAPH_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Subsystem Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSYSTEM_NODE_FEATURE_COUNT = SUBGRAPH_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.execution.executionflow.impl.EdgeImpl <em>Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.execution.executionflow.impl.EdgeImpl
	 * @see org.eclipselabs.damos.execution.executionflow.impl.ExecutionFlowPackageImpl#getEdge()
	 * @generated
	 */
	int EDGE = 7;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__SOURCE = 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__TARGET = 1;

	/**
	 * The number of structural features of the '<em>Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.execution.executionflow.impl.DataFlowImpl <em>Data Flow</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.execution.executionflow.impl.DataFlowImpl
	 * @see org.eclipselabs.damos.execution.executionflow.impl.ExecutionFlowPackageImpl#getDataFlow()
	 * @generated
	 */
	int DATA_FLOW = 8;

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
	 * The meta object id for the '{@link org.eclipselabs.damos.execution.executionflow.impl.DataFlowEndImpl <em>Data Flow End</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.execution.executionflow.impl.DataFlowEndImpl
	 * @see org.eclipselabs.damos.execution.executionflow.impl.ExecutionFlowPackageImpl#getDataFlowEnd()
	 * @generated
	 */
	int DATA_FLOW_END = 9;

	/**
	 * The feature id for the '<em><b>Connector Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FLOW_END__CONNECTOR_INFO = 0;

	/**
	 * The number of structural features of the '<em>Data Flow End</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FLOW_END_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.execution.executionflow.impl.DataFlowSourceEndImpl <em>Data Flow Source End</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.execution.executionflow.impl.DataFlowSourceEndImpl
	 * @see org.eclipselabs.damos.execution.executionflow.impl.ExecutionFlowPackageImpl#getDataFlowSourceEnd()
	 * @generated
	 */
	int DATA_FLOW_SOURCE_END = 10;

	/**
	 * The feature id for the '<em><b>Connector Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FLOW_SOURCE_END__CONNECTOR_INFO = DATA_FLOW_END__CONNECTOR_INFO;

	/**
	 * The feature id for the '<em><b>Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FLOW_SOURCE_END__NODE = DATA_FLOW_END_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Data Flow</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FLOW_SOURCE_END__DATA_FLOW = DATA_FLOW_END_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FLOW_SOURCE_END__CONNECTOR = DATA_FLOW_END_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Data Flow Source End</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FLOW_SOURCE_END_FEATURE_COUNT = DATA_FLOW_END_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.execution.executionflow.impl.DataFlowTargetEndImpl <em>Data Flow Target End</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.execution.executionflow.impl.DataFlowTargetEndImpl
	 * @see org.eclipselabs.damos.execution.executionflow.impl.ExecutionFlowPackageImpl#getDataFlowTargetEnd()
	 * @generated
	 */
	int DATA_FLOW_TARGET_END = 11;

	/**
	 * The feature id for the '<em><b>Connector Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FLOW_TARGET_END__CONNECTOR_INFO = DATA_FLOW_END__CONNECTOR_INFO;

	/**
	 * The feature id for the '<em><b>Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FLOW_TARGET_END__NODE = DATA_FLOW_END_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Data Flow</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FLOW_TARGET_END__DATA_FLOW = DATA_FLOW_END_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FLOW_TARGET_END__CONNECTOR = DATA_FLOW_END_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Data Flow Target End</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FLOW_TARGET_END_FEATURE_COUNT = DATA_FLOW_END_FEATURE_COUNT + 3;


	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.execution.executionflow.impl.ConnectorInfoImpl <em>Connector Info</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.execution.executionflow.impl.ConnectorInfoImpl
	 * @see org.eclipselabs.damos.execution.executionflow.impl.ExecutionFlowPackageImpl#getConnectorInfo()
	 * @generated
	 */
	int CONNECTOR_INFO = 12;

	/**
	 * The number of structural features of the '<em>Connector Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_INFO_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.execution.executionflow.impl.PortInfoImpl <em>Port Info</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.execution.executionflow.impl.PortInfoImpl
	 * @see org.eclipselabs.damos.execution.executionflow.impl.ExecutionFlowPackageImpl#getPortInfo()
	 * @generated
	 */
	int PORT_INFO = 13;

	/**
	 * The feature id for the '<em><b>Inoutput Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_INFO__INOUTPUT_INDEX = CONNECTOR_INFO_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Port Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_INFO__PORT_INDEX = CONNECTOR_INFO_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Port Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_INFO_FEATURE_COUNT = CONNECTOR_INFO_FEATURE_COUNT + 2;


	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.execution.executionflow.ExecutionFlow <em>Execution Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Execution Flow</em>'.
	 * @see org.eclipselabs.damos.execution.executionflow.ExecutionFlow
	 * @generated
	 */
	EClass getExecutionFlow();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.damos.execution.executionflow.ExecutionFlow#getTopLevelFragment <em>Top Level Fragment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Top Level Fragment</em>'.
	 * @see org.eclipselabs.damos.execution.executionflow.ExecutionFlow#getTopLevelFragment()
	 * @see #getExecutionFlow()
	 * @generated
	 */
	EReference getExecutionFlow_TopLevelFragment();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.damos.execution.executionflow.ExecutionFlow#getGraph <em>Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Graph</em>'.
	 * @see org.eclipselabs.damos.execution.executionflow.ExecutionFlow#getGraph()
	 * @see #getExecutionFlow()
	 * @generated
	 */
	EReference getExecutionFlow_Graph();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.execution.executionflow.ExecutionFlow#getDataFlows <em>Data Flows</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Data Flows</em>'.
	 * @see org.eclipselabs.damos.execution.executionflow.ExecutionFlow#getDataFlows()
	 * @see #getExecutionFlow()
	 * @generated
	 */
	EReference getExecutionFlow_DataFlows();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.execution.executionflow.Graph <em>Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Graph</em>'.
	 * @see org.eclipselabs.damos.execution.executionflow.Graph
	 * @generated
	 */
	EClass getGraph();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.execution.executionflow.Graph#getNodes <em>Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Nodes</em>'.
	 * @see org.eclipselabs.damos.execution.executionflow.Graph#getNodes()
	 * @see #getGraph()
	 * @generated
	 */
	EReference getGraph_Nodes();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipselabs.damos.execution.executionflow.Graph#getInitialNodes <em>Initial Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Initial Nodes</em>'.
	 * @see org.eclipselabs.damos.execution.executionflow.Graph#getInitialNodes()
	 * @see #getGraph()
	 * @generated
	 */
	EReference getGraph_InitialNodes();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.execution.executionflow.Graph#getEdges <em>Edges</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Edges</em>'.
	 * @see org.eclipselabs.damos.execution.executionflow.Graph#getEdges()
	 * @see #getGraph()
	 * @generated
	 */
	EReference getGraph_Edges();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.execution.executionflow.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node</em>'.
	 * @see org.eclipselabs.damos.execution.executionflow.Node
	 * @generated
	 */
	EClass getNode();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipselabs.damos.execution.executionflow.Node#getIncomingEdges <em>Incoming Edges</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Incoming Edges</em>'.
	 * @see org.eclipselabs.damos.execution.executionflow.Node#getIncomingEdges()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_IncomingEdges();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipselabs.damos.execution.executionflow.Node#getOutgoingEdges <em>Outgoing Edges</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outgoing Edges</em>'.
	 * @see org.eclipselabs.damos.execution.executionflow.Node#getOutgoingEdges()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_OutgoingEdges();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipselabs.damos.execution.executionflow.Node#getEnclosingSubsystems <em>Enclosing Subsystems</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Enclosing Subsystems</em>'.
	 * @see org.eclipselabs.damos.execution.executionflow.Node#getEnclosingSubsystems()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_EnclosingSubsystems();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipselabs.damos.execution.executionflow.Node#getIncomingDataFlows <em>Incoming Data Flows</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Incoming Data Flows</em>'.
	 * @see org.eclipselabs.damos.execution.executionflow.Node#getIncomingDataFlows()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_IncomingDataFlows();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipselabs.damos.execution.executionflow.Node#getOutgoingDataFlows <em>Outgoing Data Flows</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outgoing Data Flows</em>'.
	 * @see org.eclipselabs.damos.execution.executionflow.Node#getOutgoingDataFlows()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_OutgoingDataFlows();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.execution.executionflow.Subgraph <em>Subgraph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Subgraph</em>'.
	 * @see org.eclipselabs.damos.execution.executionflow.Subgraph
	 * @generated
	 */
	EClass getSubgraph();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.execution.executionflow.ComponentNode <em>Component Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component Node</em>'.
	 * @see org.eclipselabs.damos.execution.executionflow.ComponentNode
	 * @generated
	 */
	EClass getComponentNode();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.damos.execution.executionflow.ComponentNode#getComponent <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Component</em>'.
	 * @see org.eclipselabs.damos.execution.executionflow.ComponentNode#getComponent()
	 * @see #getComponentNode()
	 * @generated
	 */
	EReference getComponentNode_Component();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.execution.executionflow.CompoundNode <em>Compound Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Compound Node</em>'.
	 * @see org.eclipselabs.damos.execution.executionflow.CompoundNode
	 * @generated
	 */
	EClass getCompoundNode();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.damos.execution.executionflow.CompoundNode#getCompound <em>Compound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Compound</em>'.
	 * @see org.eclipselabs.damos.execution.executionflow.CompoundNode#getCompound()
	 * @see #getCompoundNode()
	 * @generated
	 */
	EReference getCompoundNode_Compound();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.execution.executionflow.SubsystemNode <em>Subsystem Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Subsystem Node</em>'.
	 * @see org.eclipselabs.damos.execution.executionflow.SubsystemNode
	 * @generated
	 */
	EClass getSubsystemNode();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.damos.execution.executionflow.SubsystemNode#getSubsystem <em>Subsystem</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Subsystem</em>'.
	 * @see org.eclipselabs.damos.execution.executionflow.SubsystemNode#getSubsystem()
	 * @see #getSubsystemNode()
	 * @generated
	 */
	EReference getSubsystemNode_Subsystem();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.execution.executionflow.Edge <em>Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Edge</em>'.
	 * @see org.eclipselabs.damos.execution.executionflow.Edge
	 * @generated
	 */
	EClass getEdge();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.damos.execution.executionflow.Edge#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see org.eclipselabs.damos.execution.executionflow.Edge#getSource()
	 * @see #getEdge()
	 * @generated
	 */
	EReference getEdge_Source();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.damos.execution.executionflow.Edge#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.eclipselabs.damos.execution.executionflow.Edge#getTarget()
	 * @see #getEdge()
	 * @generated
	 */
	EReference getEdge_Target();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.execution.executionflow.DataFlow <em>Data Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Flow</em>'.
	 * @see org.eclipselabs.damos.execution.executionflow.DataFlow
	 * @generated
	 */
	EClass getDataFlow();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.execution.executionflow.DataFlow#getTargetEnds <em>Target Ends</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Target Ends</em>'.
	 * @see org.eclipselabs.damos.execution.executionflow.DataFlow#getTargetEnds()
	 * @see #getDataFlow()
	 * @generated
	 */
	EReference getDataFlow_TargetEnds();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.damos.execution.executionflow.DataFlow#getSourceEnd <em>Source End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Source End</em>'.
	 * @see org.eclipselabs.damos.execution.executionflow.DataFlow#getSourceEnd()
	 * @see #getDataFlow()
	 * @generated
	 */
	EReference getDataFlow_SourceEnd();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.execution.executionflow.DataFlowEnd <em>Data Flow End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Flow End</em>'.
	 * @see org.eclipselabs.damos.execution.executionflow.DataFlowEnd
	 * @generated
	 */
	EClass getDataFlowEnd();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.damos.execution.executionflow.DataFlowEnd#getConnectorInfo <em>Connector Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Connector Info</em>'.
	 * @see org.eclipselabs.damos.execution.executionflow.DataFlowEnd#getConnectorInfo()
	 * @see #getDataFlowEnd()
	 * @generated
	 */
	EReference getDataFlowEnd_ConnectorInfo();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.execution.executionflow.DataFlowSourceEnd <em>Data Flow Source End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Flow Source End</em>'.
	 * @see org.eclipselabs.damos.execution.executionflow.DataFlowSourceEnd
	 * @generated
	 */
	EClass getDataFlowSourceEnd();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipselabs.damos.execution.executionflow.DataFlowSourceEnd#getDataFlow <em>Data Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Data Flow</em>'.
	 * @see org.eclipselabs.damos.execution.executionflow.DataFlowSourceEnd#getDataFlow()
	 * @see #getDataFlowSourceEnd()
	 * @generated
	 */
	EReference getDataFlowSourceEnd_DataFlow();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.damos.execution.executionflow.DataFlowSourceEnd#getConnector <em>Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Connector</em>'.
	 * @see org.eclipselabs.damos.execution.executionflow.DataFlowSourceEnd#getConnector()
	 * @see #getDataFlowSourceEnd()
	 * @generated
	 */
	EReference getDataFlowSourceEnd_Connector();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.damos.execution.executionflow.DataFlowSourceEnd#getNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Node</em>'.
	 * @see org.eclipselabs.damos.execution.executionflow.DataFlowSourceEnd#getNode()
	 * @see #getDataFlowSourceEnd()
	 * @generated
	 */
	EReference getDataFlowSourceEnd_Node();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.execution.executionflow.DataFlowTargetEnd <em>Data Flow Target End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Flow Target End</em>'.
	 * @see org.eclipselabs.damos.execution.executionflow.DataFlowTargetEnd
	 * @generated
	 */
	EClass getDataFlowTargetEnd();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.damos.execution.executionflow.DataFlowTargetEnd#getNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Node</em>'.
	 * @see org.eclipselabs.damos.execution.executionflow.DataFlowTargetEnd#getNode()
	 * @see #getDataFlowTargetEnd()
	 * @generated
	 */
	EReference getDataFlowTargetEnd_Node();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipselabs.damos.execution.executionflow.DataFlowTargetEnd#getDataFlow <em>Data Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Data Flow</em>'.
	 * @see org.eclipselabs.damos.execution.executionflow.DataFlowTargetEnd#getDataFlow()
	 * @see #getDataFlowTargetEnd()
	 * @generated
	 */
	EReference getDataFlowTargetEnd_DataFlow();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.damos.execution.executionflow.DataFlowTargetEnd#getConnector <em>Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Connector</em>'.
	 * @see org.eclipselabs.damos.execution.executionflow.DataFlowTargetEnd#getConnector()
	 * @see #getDataFlowTargetEnd()
	 * @generated
	 */
	EReference getDataFlowTargetEnd_Connector();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.execution.executionflow.ConnectorInfo <em>Connector Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connector Info</em>'.
	 * @see org.eclipselabs.damos.execution.executionflow.ConnectorInfo
	 * @generated
	 */
	EClass getConnectorInfo();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.execution.executionflow.PortInfo <em>Port Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Port Info</em>'.
	 * @see org.eclipselabs.damos.execution.executionflow.PortInfo
	 * @generated
	 */
	EClass getPortInfo();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.execution.executionflow.PortInfo#getInoutputIndex <em>Inoutput Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Inoutput Index</em>'.
	 * @see org.eclipselabs.damos.execution.executionflow.PortInfo#getInoutputIndex()
	 * @see #getPortInfo()
	 * @generated
	 */
	EAttribute getPortInfo_InoutputIndex();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.execution.executionflow.PortInfo#getPortIndex <em>Port Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Port Index</em>'.
	 * @see org.eclipselabs.damos.execution.executionflow.PortInfo#getPortIndex()
	 * @see #getPortInfo()
	 * @generated
	 */
	EAttribute getPortInfo_PortIndex();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ExecutionFlowFactory getExecutionFlowFactory();

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
		 * The meta object literal for the '{@link org.eclipselabs.damos.execution.executionflow.impl.ExecutionFlowImpl <em>Execution Flow</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.execution.executionflow.impl.ExecutionFlowImpl
		 * @see org.eclipselabs.damos.execution.executionflow.impl.ExecutionFlowPackageImpl#getExecutionFlow()
		 * @generated
		 */
		EClass EXECUTION_FLOW = eINSTANCE.getExecutionFlow();

		/**
		 * The meta object literal for the '<em><b>Top Level Fragment</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION_FLOW__TOP_LEVEL_FRAGMENT = eINSTANCE.getExecutionFlow_TopLevelFragment();

		/**
		 * The meta object literal for the '<em><b>Graph</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION_FLOW__GRAPH = eINSTANCE.getExecutionFlow_Graph();

		/**
		 * The meta object literal for the '<em><b>Data Flows</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION_FLOW__DATA_FLOWS = eINSTANCE.getExecutionFlow_DataFlows();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.execution.executionflow.impl.GraphImpl <em>Graph</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.execution.executionflow.impl.GraphImpl
		 * @see org.eclipselabs.damos.execution.executionflow.impl.ExecutionFlowPackageImpl#getGraph()
		 * @generated
		 */
		EClass GRAPH = eINSTANCE.getGraph();

		/**
		 * The meta object literal for the '<em><b>Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPH__NODES = eINSTANCE.getGraph_Nodes();

		/**
		 * The meta object literal for the '<em><b>Initial Nodes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPH__INITIAL_NODES = eINSTANCE.getGraph_InitialNodes();

		/**
		 * The meta object literal for the '<em><b>Edges</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPH__EDGES = eINSTANCE.getGraph_Edges();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.execution.executionflow.impl.NodeImpl <em>Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.execution.executionflow.impl.NodeImpl
		 * @see org.eclipselabs.damos.execution.executionflow.impl.ExecutionFlowPackageImpl#getNode()
		 * @generated
		 */
		EClass NODE = eINSTANCE.getNode();

		/**
		 * The meta object literal for the '<em><b>Incoming Edges</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__INCOMING_EDGES = eINSTANCE.getNode_IncomingEdges();

		/**
		 * The meta object literal for the '<em><b>Outgoing Edges</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__OUTGOING_EDGES = eINSTANCE.getNode_OutgoingEdges();

		/**
		 * The meta object literal for the '<em><b>Enclosing Subsystems</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__ENCLOSING_SUBSYSTEMS = eINSTANCE.getNode_EnclosingSubsystems();

		/**
		 * The meta object literal for the '<em><b>Incoming Data Flows</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__INCOMING_DATA_FLOWS = eINSTANCE.getNode_IncomingDataFlows();

		/**
		 * The meta object literal for the '<em><b>Outgoing Data Flows</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__OUTGOING_DATA_FLOWS = eINSTANCE.getNode_OutgoingDataFlows();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.execution.executionflow.impl.SubgraphImpl <em>Subgraph</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.execution.executionflow.impl.SubgraphImpl
		 * @see org.eclipselabs.damos.execution.executionflow.impl.ExecutionFlowPackageImpl#getSubgraph()
		 * @generated
		 */
		EClass SUBGRAPH = eINSTANCE.getSubgraph();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.execution.executionflow.impl.ComponentNodeImpl <em>Component Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.execution.executionflow.impl.ComponentNodeImpl
		 * @see org.eclipselabs.damos.execution.executionflow.impl.ExecutionFlowPackageImpl#getComponentNode()
		 * @generated
		 */
		EClass COMPONENT_NODE = eINSTANCE.getComponentNode();

		/**
		 * The meta object literal for the '<em><b>Component</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_NODE__COMPONENT = eINSTANCE.getComponentNode_Component();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.execution.executionflow.impl.CompoundNodeImpl <em>Compound Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.execution.executionflow.impl.CompoundNodeImpl
		 * @see org.eclipselabs.damos.execution.executionflow.impl.ExecutionFlowPackageImpl#getCompoundNode()
		 * @generated
		 */
		EClass COMPOUND_NODE = eINSTANCE.getCompoundNode();

		/**
		 * The meta object literal for the '<em><b>Compound</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOUND_NODE__COMPOUND = eINSTANCE.getCompoundNode_Compound();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.execution.executionflow.impl.SubsystemNodeImpl <em>Subsystem Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.execution.executionflow.impl.SubsystemNodeImpl
		 * @see org.eclipselabs.damos.execution.executionflow.impl.ExecutionFlowPackageImpl#getSubsystemNode()
		 * @generated
		 */
		EClass SUBSYSTEM_NODE = eINSTANCE.getSubsystemNode();

		/**
		 * The meta object literal for the '<em><b>Subsystem</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUBSYSTEM_NODE__SUBSYSTEM = eINSTANCE.getSubsystemNode_Subsystem();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.execution.executionflow.impl.EdgeImpl <em>Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.execution.executionflow.impl.EdgeImpl
		 * @see org.eclipselabs.damos.execution.executionflow.impl.ExecutionFlowPackageImpl#getEdge()
		 * @generated
		 */
		EClass EDGE = eINSTANCE.getEdge();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE__SOURCE = eINSTANCE.getEdge_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE__TARGET = eINSTANCE.getEdge_Target();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.execution.executionflow.impl.DataFlowImpl <em>Data Flow</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.execution.executionflow.impl.DataFlowImpl
		 * @see org.eclipselabs.damos.execution.executionflow.impl.ExecutionFlowPackageImpl#getDataFlow()
		 * @generated
		 */
		EClass DATA_FLOW = eINSTANCE.getDataFlow();

		/**
		 * The meta object literal for the '<em><b>Target Ends</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_FLOW__TARGET_ENDS = eINSTANCE.getDataFlow_TargetEnds();

		/**
		 * The meta object literal for the '<em><b>Source End</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_FLOW__SOURCE_END = eINSTANCE.getDataFlow_SourceEnd();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.execution.executionflow.impl.DataFlowEndImpl <em>Data Flow End</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.execution.executionflow.impl.DataFlowEndImpl
		 * @see org.eclipselabs.damos.execution.executionflow.impl.ExecutionFlowPackageImpl#getDataFlowEnd()
		 * @generated
		 */
		EClass DATA_FLOW_END = eINSTANCE.getDataFlowEnd();

		/**
		 * The meta object literal for the '<em><b>Connector Info</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_FLOW_END__CONNECTOR_INFO = eINSTANCE.getDataFlowEnd_ConnectorInfo();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.execution.executionflow.impl.DataFlowSourceEndImpl <em>Data Flow Source End</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.execution.executionflow.impl.DataFlowSourceEndImpl
		 * @see org.eclipselabs.damos.execution.executionflow.impl.ExecutionFlowPackageImpl#getDataFlowSourceEnd()
		 * @generated
		 */
		EClass DATA_FLOW_SOURCE_END = eINSTANCE.getDataFlowSourceEnd();

		/**
		 * The meta object literal for the '<em><b>Data Flow</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_FLOW_SOURCE_END__DATA_FLOW = eINSTANCE.getDataFlowSourceEnd_DataFlow();

		/**
		 * The meta object literal for the '<em><b>Connector</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_FLOW_SOURCE_END__CONNECTOR = eINSTANCE.getDataFlowSourceEnd_Connector();

		/**
		 * The meta object literal for the '<em><b>Node</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_FLOW_SOURCE_END__NODE = eINSTANCE.getDataFlowSourceEnd_Node();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.execution.executionflow.impl.DataFlowTargetEndImpl <em>Data Flow Target End</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.execution.executionflow.impl.DataFlowTargetEndImpl
		 * @see org.eclipselabs.damos.execution.executionflow.impl.ExecutionFlowPackageImpl#getDataFlowTargetEnd()
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
		 * The meta object literal for the '<em><b>Data Flow</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_FLOW_TARGET_END__DATA_FLOW = eINSTANCE.getDataFlowTargetEnd_DataFlow();

		/**
		 * The meta object literal for the '<em><b>Connector</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_FLOW_TARGET_END__CONNECTOR = eINSTANCE.getDataFlowTargetEnd_Connector();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.execution.executionflow.impl.ConnectorInfoImpl <em>Connector Info</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.execution.executionflow.impl.ConnectorInfoImpl
		 * @see org.eclipselabs.damos.execution.executionflow.impl.ExecutionFlowPackageImpl#getConnectorInfo()
		 * @generated
		 */
		EClass CONNECTOR_INFO = eINSTANCE.getConnectorInfo();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.execution.executionflow.impl.PortInfoImpl <em>Port Info</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.execution.executionflow.impl.PortInfoImpl
		 * @see org.eclipselabs.damos.execution.executionflow.impl.ExecutionFlowPackageImpl#getPortInfo()
		 * @generated
		 */
		EClass PORT_INFO = eINSTANCE.getPortInfo();

		/**
		 * The meta object literal for the '<em><b>Inoutput Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORT_INFO__INOUTPUT_INDEX = eINSTANCE.getPortInfo_InoutputIndex();

		/**
		 * The meta object literal for the '<em><b>Port Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORT_INFO__PORT_INDEX = eINSTANCE.getPortInfo_PortIndex();

	}

} //ExecutionFlowPackage
