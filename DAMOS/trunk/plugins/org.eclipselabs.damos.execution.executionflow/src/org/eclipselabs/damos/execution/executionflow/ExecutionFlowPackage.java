/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.execution.executionflow;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
	String eNS_URI = "http://www.eclipselabs.org/damos/2011/ExecutionFlow";

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
	 * The feature id for the '<em><b>Asynchronous Zone Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_FLOW__ASYNCHRONOUS_ZONE_COUNT = 3;

	/**
	 * The feature id for the '<em><b>Task Graphs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_FLOW__TASK_GRAPHS = 4;

	/**
	 * The feature id for the '<em><b>Fundamental Sample Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_FLOW__FUNDAMENTAL_SAMPLE_TIME = 5;

	/**
	 * The number of structural features of the '<em>Execution Flow</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_FLOW_FEATURE_COUNT = 6;

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
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__GRAPH = 0;

	/**
	 * The feature id for the '<em><b>Incoming Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__INCOMING_EDGES = 1;

	/**
	 * The feature id for the '<em><b>Outgoing Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__OUTGOING_EDGES = 2;

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
	 * The feature id for the '<em><b>System Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__SYSTEM_PATH = 5;

	/**
	 * The number of structural features of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_FEATURE_COUNT = 6;

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
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBGRAPH__GRAPH = GRAPH_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Incoming Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBGRAPH__INCOMING_EDGES = GRAPH_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Outgoing Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBGRAPH__OUTGOING_EDGES = GRAPH_FEATURE_COUNT + 2;

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
	 * The feature id for the '<em><b>System Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBGRAPH__SYSTEM_PATH = GRAPH_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Subgraph</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBGRAPH_FEATURE_COUNT = GRAPH_FEATURE_COUNT + 6;

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
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_NODE__GRAPH = NODE__GRAPH;

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
	 * The feature id for the '<em><b>System Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_NODE__SYSTEM_PATH = NODE__SYSTEM_PATH;

	/**
	 * The feature id for the '<em><b>Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_NODE__COMPONENT = NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Sample Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_NODE__SAMPLE_TIME = NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Asynchronous Zone</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_NODE__ASYNCHRONOUS_ZONE = NODE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Component Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_NODE_FEATURE_COUNT = NODE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.execution.executionflow.impl.LatchNodeImpl <em>Latch Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.execution.executionflow.impl.LatchNodeImpl
	 * @see org.eclipselabs.damos.execution.executionflow.impl.ExecutionFlowPackageImpl#getLatchNode()
	 * @generated
	 */
	int LATCH_NODE = 5;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LATCH_NODE__GRAPH = COMPONENT_NODE__GRAPH;

	/**
	 * The feature id for the '<em><b>Incoming Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LATCH_NODE__INCOMING_EDGES = COMPONENT_NODE__INCOMING_EDGES;

	/**
	 * The feature id for the '<em><b>Outgoing Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LATCH_NODE__OUTGOING_EDGES = COMPONENT_NODE__OUTGOING_EDGES;

	/**
	 * The feature id for the '<em><b>Incoming Data Flows</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LATCH_NODE__INCOMING_DATA_FLOWS = COMPONENT_NODE__INCOMING_DATA_FLOWS;

	/**
	 * The feature id for the '<em><b>Outgoing Data Flows</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LATCH_NODE__OUTGOING_DATA_FLOWS = COMPONENT_NODE__OUTGOING_DATA_FLOWS;

	/**
	 * The feature id for the '<em><b>System Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LATCH_NODE__SYSTEM_PATH = COMPONENT_NODE__SYSTEM_PATH;

	/**
	 * The feature id for the '<em><b>Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LATCH_NODE__COMPONENT = COMPONENT_NODE__COMPONENT;

	/**
	 * The feature id for the '<em><b>Sample Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LATCH_NODE__SAMPLE_TIME = COMPONENT_NODE__SAMPLE_TIME;

	/**
	 * The feature id for the '<em><b>Asynchronous Zone</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LATCH_NODE__ASYNCHRONOUS_ZONE = COMPONENT_NODE__ASYNCHRONOUS_ZONE;

	/**
	 * The feature id for the '<em><b>Task Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LATCH_NODE__TASK_NODES = COMPONENT_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Latch Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LATCH_NODE_FEATURE_COUNT = COMPONENT_NODE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.execution.executionflow.impl.CompoundNodeImpl <em>Compound Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.execution.executionflow.impl.CompoundNodeImpl
	 * @see org.eclipselabs.damos.execution.executionflow.impl.ExecutionFlowPackageImpl#getCompoundNode()
	 * @generated
	 */
	int COMPOUND_NODE = 6;

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
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_NODE__GRAPH = SUBGRAPH__GRAPH;

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
	 * The feature id for the '<em><b>System Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_NODE__SYSTEM_PATH = SUBGRAPH__SYSTEM_PATH;

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
	 * The meta object id for the '{@link org.eclipselabs.damos.execution.executionflow.impl.ActionNodeImpl <em>Action Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.execution.executionflow.impl.ActionNodeImpl
	 * @see org.eclipselabs.damos.execution.executionflow.impl.ExecutionFlowPackageImpl#getActionNode()
	 * @generated
	 */
	int ACTION_NODE = 7;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_NODE__NODES = COMPOUND_NODE__NODES;

	/**
	 * The feature id for the '<em><b>Initial Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_NODE__INITIAL_NODES = COMPOUND_NODE__INITIAL_NODES;

	/**
	 * The feature id for the '<em><b>Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_NODE__EDGES = COMPOUND_NODE__EDGES;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_NODE__GRAPH = COMPOUND_NODE__GRAPH;

	/**
	 * The feature id for the '<em><b>Incoming Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_NODE__INCOMING_EDGES = COMPOUND_NODE__INCOMING_EDGES;

	/**
	 * The feature id for the '<em><b>Outgoing Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_NODE__OUTGOING_EDGES = COMPOUND_NODE__OUTGOING_EDGES;

	/**
	 * The feature id for the '<em><b>Incoming Data Flows</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_NODE__INCOMING_DATA_FLOWS = COMPOUND_NODE__INCOMING_DATA_FLOWS;

	/**
	 * The feature id for the '<em><b>Outgoing Data Flows</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_NODE__OUTGOING_DATA_FLOWS = COMPOUND_NODE__OUTGOING_DATA_FLOWS;

	/**
	 * The feature id for the '<em><b>System Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_NODE__SYSTEM_PATH = COMPOUND_NODE__SYSTEM_PATH;

	/**
	 * The feature id for the '<em><b>Compound</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_NODE__COMPOUND = COMPOUND_NODE__COMPOUND;

	/**
	 * The feature id for the '<em><b>Choice Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_NODE__CHOICE_NODE = COMPOUND_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Action Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_NODE_FEATURE_COUNT = COMPOUND_NODE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.execution.executionflow.impl.SubsystemNodeImpl <em>Subsystem Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.execution.executionflow.impl.SubsystemNodeImpl
	 * @see org.eclipselabs.damos.execution.executionflow.impl.ExecutionFlowPackageImpl#getSubsystemNode()
	 * @generated
	 */
	int SUBSYSTEM_NODE = 8;

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
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSYSTEM_NODE__GRAPH = SUBGRAPH__GRAPH;

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
	 * The feature id for the '<em><b>System Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSYSTEM_NODE__SYSTEM_PATH = SUBGRAPH__SYSTEM_PATH;

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
	 * The meta object id for the '{@link org.eclipselabs.damos.execution.executionflow.impl.TaskGraphImpl <em>Task Graph</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.execution.executionflow.impl.TaskGraphImpl
	 * @see org.eclipselabs.damos.execution.executionflow.impl.ExecutionFlowPackageImpl#getTaskGraph()
	 * @generated
	 */
	int TASK_GRAPH = 9;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_GRAPH__NODES = GRAPH__NODES;

	/**
	 * The feature id for the '<em><b>Initial Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_GRAPH__INITIAL_NODES = GRAPH__INITIAL_NODES;

	/**
	 * The feature id for the '<em><b>Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_GRAPH__EDGES = GRAPH__EDGES;

	/**
	 * The feature id for the '<em><b>Input Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_GRAPH__INPUT_NODES = GRAPH_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Latch Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_GRAPH__LATCH_NODES = GRAPH_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Task Graph</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_GRAPH_FEATURE_COUNT = GRAPH_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.execution.executionflow.impl.TaskInputNodeImpl <em>Task Input Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.execution.executionflow.impl.TaskInputNodeImpl
	 * @see org.eclipselabs.damos.execution.executionflow.impl.ExecutionFlowPackageImpl#getTaskInputNode()
	 * @generated
	 */
	int TASK_INPUT_NODE = 10;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_INPUT_NODE__GRAPH = NODE__GRAPH;

	/**
	 * The feature id for the '<em><b>Incoming Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_INPUT_NODE__INCOMING_EDGES = NODE__INCOMING_EDGES;

	/**
	 * The feature id for the '<em><b>Outgoing Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_INPUT_NODE__OUTGOING_EDGES = NODE__OUTGOING_EDGES;

	/**
	 * The feature id for the '<em><b>Incoming Data Flows</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_INPUT_NODE__INCOMING_DATA_FLOWS = NODE__INCOMING_DATA_FLOWS;

	/**
	 * The feature id for the '<em><b>Outgoing Data Flows</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_INPUT_NODE__OUTGOING_DATA_FLOWS = NODE__OUTGOING_DATA_FLOWS;

	/**
	 * The feature id for the '<em><b>System Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_INPUT_NODE__SYSTEM_PATH = NODE__SYSTEM_PATH;

	/**
	 * The feature id for the '<em><b>Task Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_INPUT_NODE__TASK_GRAPH = NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Task Input Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_INPUT_NODE_FEATURE_COUNT = NODE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.execution.executionflow.impl.EdgeImpl <em>Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.execution.executionflow.impl.EdgeImpl
	 * @see org.eclipselabs.damos.execution.executionflow.impl.ExecutionFlowPackageImpl#getEdge()
	 * @generated
	 */
	int EDGE = 11;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__GRAPH = 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__SOURCE = 1;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__TARGET = 2;

	/**
	 * The number of structural features of the '<em>Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.execution.executionflow.impl.DataFlowImpl <em>Data Flow</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.execution.executionflow.impl.DataFlowImpl
	 * @see org.eclipselabs.damos.execution.executionflow.impl.ExecutionFlowPackageImpl#getDataFlow()
	 * @generated
	 */
	int DATA_FLOW = 12;

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
	int DATA_FLOW_END = 13;

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
	int DATA_FLOW_SOURCE_END = 14;

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
	int DATA_FLOW_TARGET_END = 15;

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
	int CONNECTOR_INFO = 16;

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
	int PORT_INFO = 17;

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
	 * The meta object id for the '<em>System Path</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dml.util.SystemPath
	 * @see org.eclipselabs.damos.execution.executionflow.impl.ExecutionFlowPackageImpl#getSystemPath()
	 * @generated
	 */
	int SYSTEM_PATH = 18;


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
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.execution.executionflow.ExecutionFlow#getAsynchronousZoneCount <em>Asynchronous Zone Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Asynchronous Zone Count</em>'.
	 * @see org.eclipselabs.damos.execution.executionflow.ExecutionFlow#getAsynchronousZoneCount()
	 * @see #getExecutionFlow()
	 * @generated
	 */
	EAttribute getExecutionFlow_AsynchronousZoneCount();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.execution.executionflow.ExecutionFlow#getTaskGraphs <em>Task Graphs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Task Graphs</em>'.
	 * @see org.eclipselabs.damos.execution.executionflow.ExecutionFlow#getTaskGraphs()
	 * @see #getExecutionFlow()
	 * @generated
	 */
	EReference getExecutionFlow_TaskGraphs();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.execution.executionflow.ExecutionFlow#getFundamentalSampleTime <em>Fundamental Sample Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fundamental Sample Time</em>'.
	 * @see org.eclipselabs.damos.execution.executionflow.ExecutionFlow#getFundamentalSampleTime()
	 * @see #getExecutionFlow()
	 * @generated
	 */
	EAttribute getExecutionFlow_FundamentalSampleTime();

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
	 * Returns the meta object for the container reference '{@link org.eclipselabs.damos.execution.executionflow.Node#getGraph <em>Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Graph</em>'.
	 * @see org.eclipselabs.damos.execution.executionflow.Node#getGraph()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_Graph();

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
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.execution.executionflow.Node#getSystemPath <em>System Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>System Path</em>'.
	 * @see org.eclipselabs.damos.execution.executionflow.Node#getSystemPath()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_SystemPath();

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
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.execution.executionflow.ComponentNode#getSampleTime <em>Sample Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sample Time</em>'.
	 * @see org.eclipselabs.damos.execution.executionflow.ComponentNode#getSampleTime()
	 * @see #getComponentNode()
	 * @generated
	 */
	EAttribute getComponentNode_SampleTime();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.execution.executionflow.ComponentNode#getAsynchronousZone <em>Asynchronous Zone</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Asynchronous Zone</em>'.
	 * @see org.eclipselabs.damos.execution.executionflow.ComponentNode#getAsynchronousZone()
	 * @see #getComponentNode()
	 * @generated
	 */
	EAttribute getComponentNode_AsynchronousZone();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.execution.executionflow.LatchNode <em>Latch Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Latch Node</em>'.
	 * @see org.eclipselabs.damos.execution.executionflow.LatchNode
	 * @generated
	 */
	EClass getLatchNode();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipselabs.damos.execution.executionflow.LatchNode#getTaskNodes <em>Task Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Task Nodes</em>'.
	 * @see org.eclipselabs.damos.execution.executionflow.LatchNode#getTaskNodes()
	 * @see #getLatchNode()
	 * @generated
	 */
	EReference getLatchNode_TaskNodes();

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
	 * Returns the meta object for class '{@link org.eclipselabs.damos.execution.executionflow.ActionNode <em>Action Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action Node</em>'.
	 * @see org.eclipselabs.damos.execution.executionflow.ActionNode
	 * @generated
	 */
	EClass getActionNode();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.damos.execution.executionflow.ActionNode#getChoiceNode <em>Choice Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Choice Node</em>'.
	 * @see org.eclipselabs.damos.execution.executionflow.ActionNode#getChoiceNode()
	 * @see #getActionNode()
	 * @generated
	 */
	EReference getActionNode_ChoiceNode();

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
	 * Returns the meta object for class '{@link org.eclipselabs.damos.execution.executionflow.TaskGraph <em>Task Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Task Graph</em>'.
	 * @see org.eclipselabs.damos.execution.executionflow.TaskGraph
	 * @generated
	 */
	EClass getTaskGraph();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.execution.executionflow.TaskGraph#getInputNodes <em>Input Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Input Nodes</em>'.
	 * @see org.eclipselabs.damos.execution.executionflow.TaskGraph#getInputNodes()
	 * @see #getTaskGraph()
	 * @generated
	 */
	EReference getTaskGraph_InputNodes();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipselabs.damos.execution.executionflow.TaskGraph#getLatchNodes <em>Latch Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Latch Nodes</em>'.
	 * @see org.eclipselabs.damos.execution.executionflow.TaskGraph#getLatchNodes()
	 * @see #getTaskGraph()
	 * @generated
	 */
	EReference getTaskGraph_LatchNodes();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.execution.executionflow.TaskInputNode <em>Task Input Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Task Input Node</em>'.
	 * @see org.eclipselabs.damos.execution.executionflow.TaskInputNode
	 * @generated
	 */
	EClass getTaskInputNode();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipselabs.damos.execution.executionflow.TaskInputNode#getTaskGraph <em>Task Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Task Graph</em>'.
	 * @see org.eclipselabs.damos.execution.executionflow.TaskInputNode#getTaskGraph()
	 * @see #getTaskInputNode()
	 * @generated
	 */
	EReference getTaskInputNode_TaskGraph();

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
	 * Returns the meta object for the container reference '{@link org.eclipselabs.damos.execution.executionflow.Edge#getGraph <em>Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Graph</em>'.
	 * @see org.eclipselabs.damos.execution.executionflow.Edge#getGraph()
	 * @see #getEdge()
	 * @generated
	 */
	EReference getEdge_Graph();

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
	 * Returns the meta object for data type '{@link org.eclipselabs.damos.dml.util.SystemPath <em>System Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>System Path</em>'.
	 * @see org.eclipselabs.damos.dml.util.SystemPath
	 * @model instanceClass="org.eclipselabs.damos.dml.util.SystemPath"
	 * @generated
	 */
	EDataType getSystemPath();

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
		 * The meta object literal for the '<em><b>Asynchronous Zone Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXECUTION_FLOW__ASYNCHRONOUS_ZONE_COUNT = eINSTANCE.getExecutionFlow_AsynchronousZoneCount();

		/**
		 * The meta object literal for the '<em><b>Task Graphs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION_FLOW__TASK_GRAPHS = eINSTANCE.getExecutionFlow_TaskGraphs();

		/**
		 * The meta object literal for the '<em><b>Fundamental Sample Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXECUTION_FLOW__FUNDAMENTAL_SAMPLE_TIME = eINSTANCE.getExecutionFlow_FundamentalSampleTime();

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
		 * The meta object literal for the '<em><b>Graph</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__GRAPH = eINSTANCE.getNode_Graph();

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
		 * The meta object literal for the '<em><b>System Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__SYSTEM_PATH = eINSTANCE.getNode_SystemPath();

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
		 * The meta object literal for the '<em><b>Sample Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT_NODE__SAMPLE_TIME = eINSTANCE.getComponentNode_SampleTime();

		/**
		 * The meta object literal for the '<em><b>Asynchronous Zone</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT_NODE__ASYNCHRONOUS_ZONE = eINSTANCE.getComponentNode_AsynchronousZone();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.execution.executionflow.impl.LatchNodeImpl <em>Latch Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.execution.executionflow.impl.LatchNodeImpl
		 * @see org.eclipselabs.damos.execution.executionflow.impl.ExecutionFlowPackageImpl#getLatchNode()
		 * @generated
		 */
		EClass LATCH_NODE = eINSTANCE.getLatchNode();

		/**
		 * The meta object literal for the '<em><b>Task Nodes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LATCH_NODE__TASK_NODES = eINSTANCE.getLatchNode_TaskNodes();

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
		 * The meta object literal for the '{@link org.eclipselabs.damos.execution.executionflow.impl.ActionNodeImpl <em>Action Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.execution.executionflow.impl.ActionNodeImpl
		 * @see org.eclipselabs.damos.execution.executionflow.impl.ExecutionFlowPackageImpl#getActionNode()
		 * @generated
		 */
		EClass ACTION_NODE = eINSTANCE.getActionNode();

		/**
		 * The meta object literal for the '<em><b>Choice Node</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION_NODE__CHOICE_NODE = eINSTANCE.getActionNode_ChoiceNode();

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
		 * The meta object literal for the '{@link org.eclipselabs.damos.execution.executionflow.impl.TaskGraphImpl <em>Task Graph</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.execution.executionflow.impl.TaskGraphImpl
		 * @see org.eclipselabs.damos.execution.executionflow.impl.ExecutionFlowPackageImpl#getTaskGraph()
		 * @generated
		 */
		EClass TASK_GRAPH = eINSTANCE.getTaskGraph();

		/**
		 * The meta object literal for the '<em><b>Input Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TASK_GRAPH__INPUT_NODES = eINSTANCE.getTaskGraph_InputNodes();

		/**
		 * The meta object literal for the '<em><b>Latch Nodes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TASK_GRAPH__LATCH_NODES = eINSTANCE.getTaskGraph_LatchNodes();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.execution.executionflow.impl.TaskInputNodeImpl <em>Task Input Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.execution.executionflow.impl.TaskInputNodeImpl
		 * @see org.eclipselabs.damos.execution.executionflow.impl.ExecutionFlowPackageImpl#getTaskInputNode()
		 * @generated
		 */
		EClass TASK_INPUT_NODE = eINSTANCE.getTaskInputNode();

		/**
		 * The meta object literal for the '<em><b>Task Graph</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TASK_INPUT_NODE__TASK_GRAPH = eINSTANCE.getTaskInputNode_TaskGraph();

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
		 * The meta object literal for the '<em><b>Graph</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE__GRAPH = eINSTANCE.getEdge_Graph();

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

		/**
		 * The meta object literal for the '<em>System Path</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dml.util.SystemPath
		 * @see org.eclipselabs.damos.execution.executionflow.impl.ExecutionFlowPackageImpl#getSystemPath()
		 * @generated
		 */
		EDataType SYSTEM_PATH = eINSTANCE.getSystemPath();

	}

} //ExecutionFlowPackage
